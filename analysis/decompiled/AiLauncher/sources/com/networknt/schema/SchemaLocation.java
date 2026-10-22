package com.networknt.schema;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.path.PathType;
import com.networknt.schema.utils.Strings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SchemaLocation {
    private static final NodePath ANCHOR;
    public static final SchemaLocation DOCUMENT;
    private static final NodePath JSON_POINTER;
    private final AbsoluteIri absoluteIri;
    private final NodePath fragment;
    private volatile String value;

    public static class Builder {
        private AbsoluteIri absoluteIri;
        private NodePath fragment = SchemaLocation.JSON_POINTER;

        public Builder absoluteIri(AbsoluteIri absoluteIri) {
            this.absoluteIri = absoluteIri;
            return this;
        }

        public SchemaLocation build() {
            return new SchemaLocation(this.absoluteIri, this.fragment);
        }

        public Builder fragment(NodePath nodePath) {
            this.fragment = nodePath;
            return this;
        }

        public Builder absoluteIri(String str) {
            return absoluteIri(AbsoluteIri.of(str));
        }

        public Builder fragment(String str) {
            return fragment(Fragment.of(str));
        }
    }

    public static class Fragment {
        public static boolean isAnchorFragment(String str) {
            return (!isFragment(str) || isDocumentFragment(str) || isJsonPointerFragment(str)) ? false : true;
        }

        public static boolean isDocumentFragment(String str) {
            return Const.STR_MART_WELL.equals(str);
        }

        public static boolean isFragment(String str) {
            return str.startsWith(Const.STR_MART_WELL);
        }

        public static boolean isJsonPointerFragment(String str) {
            return str.startsWith("#/");
        }

        public static NodePath of(String str) throws UnsupportedEncodingException {
            boolean z10 = true;
            if (str.startsWith(Const.STR_MART_WELL)) {
                str = str.substring(1);
            }
            NodePath nodePathAppend = SchemaLocation.JSON_POINTER;
            String[] strArrSplit = Strings.split(str, JsonPointer.SEPARATOR);
            if (!str.startsWith("/")) {
                nodePathAppend = SchemaLocation.ANCHOR;
                z10 = false;
            }
            int i10 = -1;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                if (i11 != 0 || !z10) {
                    String strDecode = strArrSplit[i11];
                    int i12 = 0;
                    while (i12 < strDecode.length()) {
                        char cCharAt = strDecode.charAt(i12);
                        if (cCharAt < '0' || cCharAt > '9') {
                            i10 = -1;
                            break;
                        }
                        i10 = (i12 == 0 ? 0 : i10 * 10) + (cCharAt - '0');
                        i12++;
                    }
                    if (i10 != -1) {
                        nodePathAppend = nodePathAppend.append(i10);
                    } else {
                        if (PathType.JSON_POINTER.equals(nodePathAppend.getPathType())) {
                            if (strDecode.contains("~")) {
                                strDecode = strDecode.replace(JsonPointer.ESC_SLASH, "/").replace(JsonPointer.ESC_TILDE, "~");
                            }
                            if (strDecode.contains("%")) {
                                try {
                                    strDecode = URLDecoder.decode(strDecode, StandardCharsets.UTF_8.toString());
                                } catch (UnsupportedEncodingException unused) {
                                }
                            }
                        }
                        nodePathAppend = nodePathAppend.append(strDecode);
                    }
                }
            }
            return nodePathAppend;
        }
    }

    static {
        NodePath nodePath = new NodePath(PathType.JSON_POINTER);
        JSON_POINTER = nodePath;
        ANCHOR = new NodePath(PathType.URI_REFERENCE);
        DOCUMENT = new SchemaLocation(null, nodePath);
    }

    public SchemaLocation(AbsoluteIri absoluteIri, NodePath nodePath) {
        this.value = null;
        this.absoluteIri = absoluteIri;
        this.fragment = nodePath;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SchemaLocation of(String str) throws UnsupportedEncodingException {
        AbsoluteIri absoluteIriOf;
        if (str == null) {
            return null;
        }
        if (Const.STR_MART_WELL.equals(str)) {
            return DOCUMENT;
        }
        NodePath nodePathOf = JSON_POINTER;
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            absoluteIriOf = AbsoluteIri.of(str);
        } else {
            AbsoluteIri absoluteIriOf2 = AbsoluteIri.of(str.substring(0, iIndexOf));
            int i10 = iIndexOf + 1;
            if (str.length() > i10) {
                nodePathOf = Fragment.of(str.substring(i10));
            }
            absoluteIriOf = absoluteIriOf2;
        }
        return new SchemaLocation(absoluteIriOf, nodePathOf);
    }

    public SchemaLocation append(String str) {
        return new SchemaLocation(this.absoluteIri, this.fragment.append(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SchemaLocation schemaLocation = (SchemaLocation) obj;
        return Objects.equals(this.fragment, schemaLocation.fragment) && Objects.equals(this.absoluteIri, schemaLocation.absoluteIri);
    }

    public AbsoluteIri getAbsoluteIri() {
        return this.absoluteIri;
    }

    public NodePath getFragment() {
        return this.fragment;
    }

    public int hashCode() {
        return Objects.hash(this.fragment, this.absoluteIri);
    }

    public SchemaLocation resolve(String str) throws UnsupportedEncodingException {
        int i10;
        if (str == null) {
            return this;
        }
        if (Const.STR_MART_WELL.equals(str)) {
            return new SchemaLocation(getAbsoluteIri(), JSON_POINTER);
        }
        NodePath nodePathOf = JSON_POINTER;
        int iIndexOf = str.indexOf(35);
        AbsoluteIri absoluteIri = getAbsoluteIri();
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (absoluteIri == null) {
            absoluteIri = AbsoluteIri.of(strSubstring);
        } else if (!strSubstring.isEmpty()) {
            absoluteIri = absoluteIri.resolve(strSubstring);
        }
        if (iIndexOf != -1 && str.length() > (i10 = iIndexOf + 1)) {
            String strSubstring2 = str.substring(i10);
            if (!strSubstring2.isEmpty()) {
                nodePathOf = Fragment.of(strSubstring2);
            }
        }
        return new SchemaLocation(absoluteIri, nodePathOf);
    }

    public String toString() {
        if (this.value == null) {
            AbsoluteIri absoluteIri = this.absoluteIri;
            if (absoluteIri == null || this.fragment != null) {
                StringBuilder sb2 = new StringBuilder();
                AbsoluteIri absoluteIri2 = this.absoluteIri;
                if (absoluteIri2 != null) {
                    sb2.append(absoluteIri2);
                }
                sb2.append(Const.STR_MART_WELL);
                NodePath nodePath = this.fragment;
                if (nodePath != null) {
                    sb2.append(nodePath);
                }
                this.value = sb2.toString();
            } else {
                this.value = absoluteIri.toString();
            }
        }
        return this.value;
    }

    public SchemaLocation append(int i10) {
        return new SchemaLocation(this.absoluteIri, this.fragment.append(i10));
    }

    public SchemaLocation(AbsoluteIri absoluteIri) {
        this(absoluteIri, JSON_POINTER);
    }

    public static String resolve(SchemaLocation schemaLocation, String str) {
        String strSubstring;
        int i10;
        if (Const.STR_MART_WELL.equals(str)) {
            return schemaLocation.getAbsoluteIri().toString() + Const.STR_MART_WELL;
        }
        int iIndexOf = str.indexOf(35);
        AbsoluteIri absoluteIri = schemaLocation.getAbsoluteIri();
        String strSubstring2 = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (absoluteIri != null) {
            if (!strSubstring2.isEmpty()) {
                strSubstring2 = absoluteIri.resolve(strSubstring2).toString();
            } else {
                strSubstring2 = absoluteIri.toString();
            }
        }
        if (iIndexOf != -1 && str.length() > (i10 = iIndexOf + 1)) {
            strSubstring = str.substring(i10);
        } else {
            strSubstring = "";
        }
        if (!strSubstring.isEmpty()) {
            return strSubstring2 + Const.STR_MART_WELL + strSubstring;
        }
        return strSubstring2 + Const.STR_MART_WELL;
    }
}
