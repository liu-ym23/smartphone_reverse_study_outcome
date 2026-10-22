package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "<init>", "()V", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Url", "Clickable", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LinkAnnotation implements AnnotatedString.Annotation {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "tag", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getTag", "()Ljava/lang/String;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Clickable extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String tag;

        public int hashCode() {
            int r100 = this.tag.hashCode() * 31;
            TextLinkStyles r101 = getStyles();
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            LinkInteractionListener r105 = getLinkInteractionListener();
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.tag + ')';
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public final String getTag() {
            return this.tag;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Clickable) == true) goto L8;
            return false;
        L8:
            Clickable r101 = (Clickable) r100;
            if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getStyles(), r101.getStyles()) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(getLinkInteractionListener(), r101.getLinkInteractionListener()) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public Clickable(String r100, TextLinkStyles r101, LinkInteractionListener r102) {
            super(null);
            this.tag = r100;
            this.styles = r101;
            this.linkInteractionListener = r102;
        }

        public final Clickable copy(String r100, TextLinkStyles r101, LinkInteractionListener r102) {
            return new Clickable(r100, r101, r102);
        }

        public /* synthetic */ Clickable(String r100, TextLinkStyles r101, LinkInteractionListener r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, r102);
        }

        public static /* synthetic */ Clickable copy$default(Clickable r100, String r101, TextLinkStyles r102, LinkInteractionListener r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.tag;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.getStyles();
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.getLinkInteractionListener();
        L12:
            return r100.copy(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "url", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getUrl", "()Ljava/lang/String;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Url extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String url;

        public int hashCode() {
            int r100 = this.url.hashCode() * 31;
            TextLinkStyles r101 = getStyles();
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            LinkInteractionListener r105 = getLinkInteractionListener();
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.url + ')';
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public final String getUrl() {
            return this.url;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Url) == true) goto L8;
            return false;
        L8:
            Url r101 = (Url) r100;
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getStyles(), r101.getStyles()) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(getLinkInteractionListener(), r101.getLinkInteractionListener()) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public Url(String r100, TextLinkStyles r101, LinkInteractionListener r102) {
            super(null);
            this.url = r100;
            this.styles = r101;
            this.linkInteractionListener = r102;
        }

        public final Url copy(String r100, TextLinkStyles r101, LinkInteractionListener r102) {
            return new Url(r100, r101, r102);
        }

        public /* synthetic */ Url(String r100, TextLinkStyles r101, LinkInteractionListener r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }

        public static /* synthetic */ Url copy$default(Url r100, String r101, TextLinkStyles r102, LinkInteractionListener r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.url;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.getStyles();
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.getLinkInteractionListener();
        L12:
            return r100.copy(r101, r102, r103);
        }
    }

    private LinkAnnotation() {
    }

    public /* synthetic */ LinkAnnotation(DefaultConstructorMarker r100) {
        this();
    }

    public abstract LinkInteractionListener getLinkInteractionListener();

    public abstract TextLinkStyles getStyles();
}
