package com.stepos.agentframework.adapter.bff;

import V4.AbstractC0262i;
import V4.C0256c;
import V4.C0258e;
import V4.C0259f;
import V4.C0260g;
import V4.C0261h;
import androidx.appcompat.app.AppCompatDelegate;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.statsrpk.d;
import com.zyql.protobuf.common.FileData$Builder;
import com.zyql.protobuf.common.Part$Builder;
import com.zyql.protobuf.skull.Message$Builder;
import com.zyql.protobuf.skull.Resource$Builder;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import q7.C1809g;
import q7.G;
import v7.l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u0000*\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011\u001a%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006*\b\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LV4/i;", "Lcom/zyql/protobuf/skull/Message$Builder;", "msgBuilder", "Lcom/zyql/protobuf/skull/Resource$Builder;", "toResourceBuilder", "(LV4/i;Lcom/zyql/protobuf/skull/Message$Builder;)Lcom/zyql/protobuf/skull/Resource$Builder;", "", "Lv7/l;", "toResourceList", "(Ljava/util/List;Lcom/zyql/protobuf/skull/Message$Builder;)Ljava/util/List;", "toChatContent", "(Lv7/l;)LV4/i;", "", "messageContent", "toChatContentList", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lq7/g;", "(Lq7/g;)LV4/i;", "", "thought", "Lq7/G;", "toPrats", "(Ljava/util/List;Z)Ljava/util/List;", "Lcom/zyql/protobuf/common/Part$Builder;", "toPartBuilder", "(LV4/i;Z)Lcom/zyql/protobuf/common/Part$Builder;", "displayName", "getDisplayName", "(Ljava/lang/String;)Ljava/lang/String;", "bff_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatContentExtKt {
    public static final String getDisplayName(String str) {
        return (str == null || str.length() == 0 || m.s0(str)) ? "" : str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final AbstractC0262i toChatContent(l lVar) {
        String strC0;
        k.f(lVar, "<this>");
        String strG0 = lVar.g0();
        k.e(strG0, "getType(...)");
        String lowerCase = strG0.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case 3143036:
                if (lowerCase.equals(BffConstant.Type.File)) {
                    if (lVar.b0().containsKey("coverUrl") || ((strC0 = lVar.c0()) != null && t.e0(strC0, "video/", false))) {
                        C0261h c0261h = new C0261h(lVar.i0(), (String) lVar.b0().get("coverUrl"), lVar.c0(), 17);
                        Map mapB0 = lVar.b0();
                        if (mapB0 != null) {
                            c0261h.f1363a.putAll(mapB0);
                        }
                        return c0261h;
                    }
                    String strI0 = lVar.i0();
                    String strC02 = lVar.c0();
                    String str = (String) lVar.b0().get("fileName");
                    String str2 = (String) lVar.b0().get("fileSize");
                    C0258e c0258e = new C0258e(strI0, 69, str2 != null ? t.g0(str2) : null, str, strC02);
                    Map mapB02 = lVar.b0();
                    if (mapB02 != null) {
                        c0258e.f1363a.putAll(mapB02);
                    }
                    return c0258e;
                }
                return null;
            case 3556653:
                if (lowerCase.equals("text")) {
                    String strX = lVar.X();
                    if (strX == null) {
                        strX = "";
                    }
                    return new C0260g(strX);
                }
                return null;
            case 93166550:
                if (lowerCase.equals(BffConstant.Type.Audio)) {
                    C0256c c0256c = new C0256c(lVar.i0(), lVar.c0());
                    Map mapB03 = lVar.b0();
                    if (mapB03 != null) {
                        c0256c.f1363a.putAll(mapB03);
                    }
                    return c0256c;
                }
                return null;
            case 100313435:
                if (lowerCase.equals("image")) {
                    C0259f c0259f = new C0259f(lVar.i0(), (String) lVar.b0().get("thumbnailUrl"), lVar.c0(), 101);
                    Map mapB04 = lVar.b0();
                    if (mapB04 != null) {
                        c0259f.f1363a.putAll(mapB04);
                    }
                    return c0259f;
                }
                return null;
            default:
                return null;
        }
    }

    public static final List<AbstractC0262i> toChatContentList(List<l> list, String str) {
        k.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        if (str != null && !m.s0(str)) {
            arrayList.add(new C0260g(str));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AbstractC0262i chatContent = toChatContent((l) it.next());
            if (chatContent != null) {
                arrayList2.add(chatContent);
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public static final Part$Builder toPartBuilder(AbstractC0262i abstractC0262i, boolean z10) {
        k.f(abstractC0262i, "<this>");
        Part$Builder part$BuilderJ0 = G.j0();
        part$BuilderJ0.setThought(z10);
        if (abstractC0262i instanceof C0260g) {
            part$BuilderJ0.setText(((C0260g) abstractC0262i).b);
            return part$BuilderJ0;
        }
        if (abstractC0262i instanceof C0259f) {
            FileData$Builder fileData$BuilderU = C1809g.U();
            C0259f c0259f = (C0259f) abstractC0262i;
            String str = c0259f.b;
            if (str == null) {
                str = "";
            }
            fileData$BuilderU.setUri(str);
            String str2 = c0259f.d;
            if (str2 != null) {
                fileData$BuilderU.setMimeType(str2);
            }
            fileData$BuilderU.setDisplayName(getDisplayName(c0259f.e));
            part$BuilderJ0.setFileData((C1809g) fileData$BuilderU.k());
            return part$BuilderJ0;
        }
        if (abstractC0262i instanceof C0256c) {
            FileData$Builder fileData$BuilderU2 = C1809g.U();
            C0256c c0256c = (C0256c) abstractC0262i;
            String str3 = c0256c.b;
            if (str3 != null) {
                fileData$BuilderU2.setUri(str3);
            }
            String str4 = c0256c.c;
            if (str4 != null) {
                fileData$BuilderU2.setMimeType(str4);
            }
            fileData$BuilderU2.setDisplayName(getDisplayName(c0256c.d));
            part$BuilderJ0.setFileData((C1809g) fileData$BuilderU2.k());
            return part$BuilderJ0;
        }
        if (abstractC0262i instanceof C0261h) {
            FileData$Builder fileData$BuilderU3 = C1809g.U();
            C0261h c0261h = (C0261h) abstractC0262i;
            String str5 = c0261h.b;
            if (str5 != null) {
                fileData$BuilderU3.setUri(str5);
            }
            String str6 = c0261h.d;
            if (str6 != null) {
                fileData$BuilderU3.setMimeType(str6);
            }
            fileData$BuilderU3.setDisplayName(getDisplayName(c0261h.e));
            part$BuilderJ0.setFileData((C1809g) fileData$BuilderU3.k());
            return part$BuilderJ0;
        }
        if (!(abstractC0262i instanceof C0258e)) {
            return null;
        }
        FileData$Builder fileData$BuilderU4 = C1809g.U();
        C0258e c0258e = (C0258e) abstractC0262i;
        String str7 = c0258e.b;
        if (str7 != null) {
            fileData$BuilderU4.setUri(str7);
        }
        String str8 = c0258e.e;
        if (str8 != null) {
            fileData$BuilderU4.setMimeType(str8);
        }
        fileData$BuilderU4.setDisplayName(getDisplayName(c0258e.f));
        part$BuilderJ0.setFileData((C1809g) fileData$BuilderU4.k());
        return part$BuilderJ0;
    }

    public static final List<G> toPrats(List<? extends AbstractC0262i> list, boolean z10) {
        k.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Part$Builder partBuilder = toPartBuilder((AbstractC0262i) it.next(), z10);
            G g = partBuilder != null ? (G) partBuilder.k() : null;
            if (g != null) {
                arrayList.add(g);
            }
        }
        return arrayList;
    }

    public static final Resource$Builder toResourceBuilder(AbstractC0262i abstractC0262i, Message$Builder msgBuilder) {
        k.f(abstractC0262i, "<this>");
        k.f(msgBuilder, "msgBuilder");
        Resource$Builder resource$BuilderK0 = l.k0();
        String lowerCase = abstractC0262i.a().name().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        Resource$Builder type = resource$BuilderK0.setType(lowerCase);
        type.putAllExtra(abstractC0262i.f1363a);
        if (abstractC0262i instanceof C0260g) {
            msgBuilder.setContent(((C0260g) abstractC0262i).b);
            return null;
        }
        if (abstractC0262i instanceof C0259f) {
            d.D("ChatContentExt", "toResourceBuilder Image");
            C0259f c0259f = (C0259f) abstractC0262i;
            String str = c0259f.b;
            if (str == null) {
                str = "";
            }
            type.setUri(str);
            String str2 = c0259f.d;
            if (str2 != null) {
                type.setMimeType(str2);
            }
            String str3 = c0259f.c;
            if (str3 != null) {
                type.putExtra("thumbnailUrl", str3);
                return type;
            }
        } else if (abstractC0262i instanceof C0256c) {
            C0256c c0256c = (C0256c) abstractC0262i;
            type.setUri(c0256c.b);
            String str4 = c0256c.c;
            if (str4 != null) {
                type.setMimeType(str4);
                return type;
            }
        } else {
            if (abstractC0262i instanceof C0261h) {
                C0261h c0261h = (C0261h) abstractC0262i;
                String str5 = c0261h.b;
                if (str5 != null) {
                    type.setUri(str5);
                }
                String str6 = c0261h.d;
                if (str6 != null) {
                    type.setMimeType(str6);
                }
                String str7 = c0261h.c;
                if (str7 != null) {
                    type.putExtra("coverUrl", str7);
                }
                type.setType(BffConstant.Type.File);
                return type;
            }
            if (!(abstractC0262i instanceof C0258e)) {
                return null;
            }
            C0258e c0258e = (C0258e) abstractC0262i;
            String str8 = c0258e.e;
            if (str8 != null) {
                type.setMimeType(str8);
            }
            String str9 = c0258e.c;
            if (str9 != null) {
                type.putExtra("fileName", str9);
            }
            Long l = c0258e.d;
            if (l != null) {
                type.putExtra("fileSize", String.valueOf(l.longValue()));
            }
        }
        return type;
    }

    public static final List<l> toResourceList(List<? extends AbstractC0262i> list, Message$Builder msgBuilder) {
        k.f(list, "<this>");
        k.f(msgBuilder, "msgBuilder");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Resource$Builder resourceBuilder = toResourceBuilder((AbstractC0262i) it.next(), msgBuilder);
            l lVar = resourceBuilder != null ? (l) resourceBuilder.k() : null;
            if (lVar != null) {
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    public static final AbstractC0262i toChatContent(C1809g c1809g) {
        k.f(c1809g, "<this>");
        String strQ = c1809g.Q();
        k.e(strQ, "getMimeType(...)");
        if (t.e0(strQ, "image/", false)) {
            return new C0259f(c1809g.S(), null, c1809g.Q(), AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        }
        String strQ2 = c1809g.Q();
        k.e(strQ2, "getMimeType(...)");
        if (t.e0(strQ2, "audio/", false)) {
            return new C0256c(c1809g.S(), c1809g.Q());
        }
        String strQ3 = c1809g.Q();
        k.e(strQ3, "getMimeType(...)");
        if (t.e0(strQ3, "video/", false)) {
            return new C0261h(c1809g.S(), null, c1809g.Q(), 21);
        }
        return new C0258e(c1809g.S(), 93, null, null, c1809g.Q());
    }
}
