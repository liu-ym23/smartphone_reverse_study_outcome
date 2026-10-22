package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0004DEFGB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ$\u0010(\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010,\u001a\u00020\u001bH\u0002J\u0013\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J(\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010403H\u0007J\u0010\u00105\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u00107\u001a\u000206H\u0016J\u0012\u00108\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u00109\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010:\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u000102H\u0002J\u0015\u0010;\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u000202H\u0000¢\u0006\u0002\b<J\u0015\u0010;\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b<J*\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u000104H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b$\u0010\u001dR\u0010\u0010&\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\n¨\u0006H"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "uri", "", "(Ljava/lang/String;)V", "uriPattern", "action", DBDefinition.MIME_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "arguments", "", "argumentsNames", "", "getArgumentsNames$navigation_common_release", "()Ljava/util/List;", "<set-?>", "", "isExactDeepLink", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isParameterizedQuery", "getMimeType", "mimeTypeFinalRegex", "mimeTypePattern", "Ljava/util/regex/Pattern;", "getMimeTypePattern", "()Ljava/util/regex/Pattern;", "mimeTypePattern$delegate", "Lkotlin/Lazy;", "paramArgMap", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "pattern", "getPattern", "pattern$delegate", "patternFinalRegex", "getUriPattern", "buildPathRegex", "uriRegex", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "fillInPattern", "equals", "other", "getMatchingArguments", "Landroid/os/Bundle;", "deepLink", "Landroid/net/Uri;", "", "Landroidx/navigation/NavArgument;", "getMimeTypeMatchRating", "", "hashCode", "matchAction", "matchMimeType", "matchUri", "matches", "matches$navigation_common_release", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "parseArgument", "bundle", "name", "value", "argument", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLink {
    private static final Companion Companion = null;
    private static final Pattern SCHEME_PATTERN = null;
    private final String action;
    private final List<String> arguments;
    private boolean isExactDeepLink;
    private boolean isParameterizedQuery;
    private final String mimeType;
    private String mimeTypeFinalRegex;
    private final Lazy mimeTypePattern$delegate;
    private final Map<String, ParamQuery> paramArgMap;
    private final Lazy pattern$delegate;
    private String patternFinalRegex;
    private final String uriPattern;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", DBDefinition.MIME_TYPE, "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        private String action;
        private String mimeType;
        private String uriPattern;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", DBDefinition.MIME_TYPE, "fromUriPattern", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final Builder fromAction(String r100) {
                Intrinsics.checkNotNullParameter(r100, "action");
                if (r100.length() <= 0) goto L5;
                boolean r101 = true;
            L6:
                if (r101 == false) goto L10;
                Builder r102 = new Builder();
                r102.setAction(r100);
                return r102;
            L10:
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            L5:
                r101 = false;
                goto L6
            }

            @JvmStatic
            public final Builder fromMimeType(String r100) {
                Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
                Builder r101 = new Builder();
                r101.setMimeType(r100);
                return r101;
            }

            @JvmStatic
            public final Builder fromUriPattern(String r100) {
                Intrinsics.checkNotNullParameter(r100, "uriPattern");
                Builder r101 = new Builder();
                r101.setUriPattern(r100);
                return r101;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Builder() {
        }

        @JvmStatic
        public static final Builder fromAction(String r100) {
            return Companion.fromAction(r100);
        }

        @JvmStatic
        public static final Builder fromMimeType(String r100) {
            return Companion.fromMimeType(r100);
        }

        @JvmStatic
        public static final Builder fromUriPattern(String r100) {
            return Companion.fromUriPattern(r100);
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        public final Builder setAction(String r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.action = r100;
            return this;
        L10:
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        L5:
            r101 = false;
            goto L6
        }

        public final Builder setMimeType(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
            this.mimeType = r100;
            return this;
        }

        public final Builder setUriPattern(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uriPattern");
            this.uriPattern = r100;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", DBDefinition.MIME_TYPE, "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", "type", "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public final String getSubType() {
            return this.subType;
        }

        public final String getType() {
            return this.type;
        }

        public MimeType(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
            List<String> r101 = new Regex(HTTP.URL_DEFAULT).split(r100, 0);
            if (r101.isEmpty() == true) goto L13;
            ListIterator<String> r102 = r101.listIterator(r101.size());
        L6:
            if (r102.hasPrevious() == false) goto L13;
            if (r102.previous().length() != 0) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == true) goto L6;
            List r104 = CollectionsKt.take(r101, r102.nextIndex() + 1);
        L14:
            this.type = (String) ListProtector.get(r104, 0);
            this.subType = (String) ListProtector.get(r104, 1);
            return;
        L10:
            r103 = false;
        L13:
            r104 = CollectionsKt.emptyList();
            goto L14
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(MimeType r100) {
            Intrinsics.checkNotNullParameter(r100, "other");
            if (Intrinsics.areEqual(this.type, r100.type) == false) goto L5;
            int r101 = 2;
        L7:
            if (Intrinsics.areEqual(this.subType, r100.subType) == true) goto L9;
            return r101;
        L9:
            return r101 + 1;
        L5:
            r101 = 0;
            goto L7
        }

        public final void setSubType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.subType = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(MimeType r100) {
            return compareTo2(r100);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "()V", "arguments", "", "", "getArguments", "()Ljava/util/List;", "paramRegex", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "(Ljava/lang/String;)V", "addArgumentName", "", "name", "getArgumentName", "index", "", "size", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParamQuery {
        private final List<String> arguments;
        private String paramRegex;

        public final int size() {
            return this.arguments.size();
        }

        public ParamQuery() {
            this.arguments = new ArrayList();
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void addArgumentName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.arguments.add(r100);
        }

        public final String getArgumentName(int r100) {
            return (String) ListProtector.get(this.arguments, r100);
        }

        public final void setParamRegex(String r100) {
            this.paramRegex = r100;
        }
    }

    static {
        Companion = new Companion(null);
        SCHEME_PATTERN = PatternProtector.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    private final Pattern getPattern() {
        return (Pattern) this.pattern$delegate.getValue();
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> r100 = this.arguments;
        Collection<ParamQuery> r101 = this.paramArgMap.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        CollectionsKt.addAll(r102, ((ParamQuery) r103.next()).getArguments());
        goto L4
    L7:
        return CollectionsKt.plus(r100, r102);
    }

    public int hashCode() {
        String r100 = this.uriPattern;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 0) * 31;
        String r104 = this.action;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mimeType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public NavDeepLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this(r100, null, null);
    }

    public static final /* synthetic */ String access$getMimeTypeFinalRegex$p(NavDeepLink r100) {
        return r100.mimeTypeFinalRegex;
    }

    public static final /* synthetic */ String access$getPatternFinalRegex$p(NavDeepLink r100) {
        return r100.patternFinalRegex;
    }

    private final boolean matchAction(String r100) {
        if (r100 != null) goto L5;
        boolean r101 = true;
    L6:
        String r102 = this.action;
        if (r102 == null) goto L9;
        boolean r103 = true;
    L10:
        if (r101 != r103) goto L12;
    L11:
        return false;
    L12:
        if (r100 != null) goto L14;
        return true;
    L14:
        if (Intrinsics.areEqual(r102, r100) == false) goto L11;
        return true;
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    private final boolean matchMimeType(String r100) {
        if (r100 != null) goto L5;
        boolean r101 = true;
    L7:
        if (this.mimeType == null) goto L9;
        boolean r102 = true;
    L10:
        if (r101 != r102) goto L12;
    L11:
        return false;
    L12:
        if (r100 == null) goto L16;
        Pattern r103 = getMimeTypePattern();
        Intrinsics.checkNotNull(r103);
        if (r103.matcher(r100).matches() == false) goto L11;
        return true;
    L16:
        return true;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    private final boolean matchUri(Uri r100) {
        if (r100 != null) goto L5;
        boolean r101 = true;
    L7:
        if (getPattern() == null) goto L9;
        boolean r102 = true;
    L10:
        if (r101 != r102) goto L12;
    L11:
        return false;
    L12:
        if (r100 == null) goto L16;
        Pattern r103 = getPattern();
        Intrinsics.checkNotNull(r103);
        if (r103.matcher(r100.toString()).matches() == false) goto L11;
        return true;
    L16:
        return true;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof NavDeepLink) == false) goto L19;
        NavDeepLink r101 = (NavDeepLink) r100;
        if (Intrinsics.areEqual(this.uriPattern, r101.uriPattern) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public final int getMimeTypeMatchRating(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
        if (this.mimeType == null) goto L8;
        Pattern r101 = getMimeTypePattern();
        Intrinsics.checkNotNull(r101);
        if (r101.matcher(r100).matches() == false) goto L8;
        return new MimeType(this.mimeType).compareTo2(new MimeType(r100));
    L8:
        return -1;
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "deepLinkRequest");
        if (matchUri(r100.getUri()) == true) goto L6;
        return false;
    L6:
        if (matchAction(r100.getAction()) == true) goto L9;
        return false;
    L9:
        return matchMimeType(r100.getMimeType());
    }

    public final void setExactDeepLink$navigation_common_release(boolean r100) {
        this.isExactDeepLink = r100;
    }

    public final boolean matches$navigation_common_release(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(r100, null, null));
    }

    public final Bundle getMatchingArguments(Uri r110, Map<String, NavArgument> r111) {
        Intrinsics.checkNotNullParameter(r110, "deepLink");
        Intrinsics.checkNotNullParameter(r111, "arguments");
        Pattern r100 = getPattern();
        if (r100 != null) goto L5;
        Matcher r101 = null;
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.matches() == true) goto L11;
        return null;
    L11:
        Bundle r102 = new Bundle();
        int r103 = this.arguments.size();
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L20;
        int r105 = r104 + 1;
        String r106 = (String) ListProtector.get(this.arguments, r104);
        if (parseArgument(r102, r106, Uri.decode(r101.group(r105)), r111.get(r106)) == true) goto L16;
        r104 = r105;
        goto L12
    L16:
        return null;
    L18:
        return null;
    L20:
        if (this.isParameterizedQuery == false) goto L50;
        Iterator<String> r107 = this.paramArgMap.keySet().iterator();
    L23:
        if (r107.hasNext() == false) goto L50;
        String r108 = r107.next();
        ParamQuery r109 = this.paramArgMap.get(r108);
        String r112 = UriProtector.getQueryParameter(r110, r108);
        if (r112 == null) goto L29;
        Intrinsics.checkNotNull(r109);
        Matcher r113 = PatternProtector.compile(r109.getParamRegex(), 32).matcher(r112);
        if (r113.matches() == false) goto L28;
    L30:
        Bundle r114 = new Bundle();
        Intrinsics.checkNotNull(r109);     // Catch: IllegalArgumentException -> L49
        int r115 = r109.size();     // Catch: IllegalArgumentException -> L49
        int r116 = 0;
    L32:
        if (r116 >= r115) goto L47;
        int r117 = r116 + 1;     // Catch: IllegalArgumentException -> L49
        if (r113 == null) goto L38;
        String r118 = r113.group(r117);     // Catch: IllegalArgumentException -> L49
        if (r118 != null) goto L39;
        r118 = "";
    L39:
        String r119 = r109.getArgumentName(r116);     // Catch: IllegalArgumentException -> L49
        NavArgument r120 = r111.get(r119);     // Catch: IllegalArgumentException -> L49
        if (r118 == null) goto L46;
        if (Intrinsics.areEqual(r118, '{' + r119 + '}') == true) goto L46;
        if (parseArgument(r114, r119, r118, r120) == false) goto L46;
        return null;
    L46:
        r116 = r117;
        goto L32
    L38:
        r118 = null;
        goto L39
    L47:
        r102.putAll(r114);     // Catch: IllegalArgumentException -> L49
        goto L23
    L28:
        return null;
    L29:
        r113 = null;
    L50:
        Iterator<Map.Entry<String, NavArgument>> r121 = r111.entrySet().iterator();
    L52:
        if (r121.hasNext() == false) goto L65;
        Map.Entry<String, NavArgument> r122 = r121.next();
        String r123 = r122.getKey();
        NavArgument r124 = r122.getValue();
        if (r124 != null) goto L56;
    L60:
        boolean r125 = false;
    L61:
        if (r125 == false) goto L52;
        if (r102.containsKey(r123) == true) goto L52;
        return null;
    L56:
        if (r124.isNullable() == true) goto L60;
        if (r124.isDefaultValuePresent() == true) goto L60;
        r125 = true;
        goto L61
    L65:
        return r102;
    L5:
        r101 = r100.matcher(r110.toString());
        goto L6
    }

    public NavDeepLink(String r210, String r211, String r212) {
        this.uriPattern = r210;
        this.action = r211;
        this.mimeType = r212;
        this.arguments = new ArrayList();
        this.paramArgMap = new LinkedHashMap();
        this.pattern$delegate = LazyKt.lazy(new NavDeepLink$pattern$2(this));
        this.mimeTypePattern$delegate = LazyKt.lazy(new NavDeepLink$mimeTypePattern$2(this));
        if (r210 == null) goto L38;
        Uri r100 = UriProtector.parse(r210);
        if (r100.getQuery() == null) goto L7;
        boolean r101 = true;
    L8:
        this.isParameterizedQuery = r101;
        StringBuilder r102 = new StringBuilder("^");
        if (SCHEME_PATTERN.matcher(r210).find() == true) goto L11;
        r102.append("http[s]?://");
    L11:
        Pattern r103 = PatternProtector.compile("\\{(.+?)\\}");
        if (this.isParameterizedQuery == false) goto L35;
        Matcher r104 = PatternProtector.compile("(\\?)").matcher(r210);
        if (r104.find() == false) goto L16;
        this.isExactDeepLink = buildPathRegex(r210.substring(0, r104.start()), r102, r103);
    L16:
        Iterator<String> r105 = UriProtector.getQueryParameterNames(r100).iterator();
    L18:
        if (r105.hasNext() == false) goto L36;
        String r106 = r105.next();
        StringBuilder r107 = new StringBuilder();
        String r108 = UriProtector.getQueryParameter(r100, r106);
        if (r108 == null) goto L34;
        Matcher r110 = r103.matcher(r108);
        ParamQuery r111 = new ParamQuery();
        int r112 = 0;
    L23:
        if (r110.find() == false) goto L30;
        String r113 = r110.group(1);
        if (r113 == null) goto L28;
        r111.addArgumentName(r113);
        r107.append(Pattern.quote(r108.substring(r112, r110.start())));
        r107.append("(.+?)?");
        r112 = r110.end();
        goto L23
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L30:
        if (r112 >= r108.length()) goto L32;
        r107.append(Pattern.quote(r108.substring(r112)));
    L32:
        r111.setParamRegex(StringsKt.replace$default(r107.toString(), ".*", "\\E.*\\Q", false, 4, null));
        this.paramArgMap.put(r106, r111);
        goto L18
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L36:
        this.patternFinalRegex = StringsKt.replace$default(r102.toString(), ".*", "\\E.*\\Q", false, 4, null);
        goto L38
    L35:
        this.isExactDeepLink = buildPathRegex(r210, r102, r103);
        goto L36
    L7:
        r101 = false;
    L38:
        if (this.mimeType != null) goto L40;
        return;
    L40:
        if (PatternProtector.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches() == false) goto L43;
        MimeType r109 = new MimeType(this.mimeType);
        this.mimeTypeFinalRegex = StringsKt.replace$default("^(" + r109.getType() + "|[*]+)/(" + r109.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
        return;
    L43:
        throw new IllegalArgumentException(("The given mimeType " + getMimeType() + " does not match to required \"type/subtype\" format").toString());
    }

    private final boolean buildPathRegex(String r100, StringBuilder r101, Pattern r102) {
        Matcher r103 = r102.matcher(r100);
        boolean r104 = !StringsKt.contains$default(r100, ".*", false, 2, null);
        int r105 = 0;
    L4:
        if (r103.find() == false) goto L11;
        String r106 = r103.group(1);
        if (r106 == null) goto L9;
        this.arguments.add(r106);
        r101.append(Pattern.quote(r100.substring(r105, r103.start())));
        r101.append("([^/]+?)");
        r105 = r103.end();
        r104 = false;
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L11:
        if (r105 >= r100.length()) goto L13;
        r101.append(Pattern.quote(r100.substring(r105)));
    L13:
        r101.append("($|(\\?(.)*)|(\\#(.)*))");
        return r104;
    }

    private final boolean parseArgument(Bundle r100, String r101, String r102, NavArgument r103) {
        if (r103 == null) goto L4;
        r103.getType().parseAndPut(r100, r101, r102);
        return false;
    L4:
        r100.putString(r101, r102);
        return false;
    }
}
