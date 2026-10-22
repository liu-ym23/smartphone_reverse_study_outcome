package androidx.compose.foundation.content;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/content/MediaType;", "", "representation", "", "<init>", "(Ljava/lang/String;)V", "getRepresentation", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MediaType {
    public static final int $stable = 0;
    private static final MediaType All = null;
    public static final Companion Companion = null;
    private static final MediaType HtmlText = null;
    private static final MediaType Image = null;
    private static final MediaType PlainText = null;
    private static final MediaType Text = null;
    private final String representation;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/content/MediaType$Companion;", "", "<init>", "()V", "Text", "Landroidx/compose/foundation/content/MediaType;", "getText", "()Landroidx/compose/foundation/content/MediaType;", "PlainText", "getPlainText", "HtmlText", "getHtmlText", "Image", "getImage", CancelRetainContactInfoFunctions.All, "getAll", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final MediaType getAll() {
            return MediaType.access$getAll$cp();
        }

        public final MediaType getHtmlText() {
            return MediaType.access$getHtmlText$cp();
        }

        public final MediaType getImage() {
            return MediaType.access$getImage$cp();
        }

        public final MediaType getPlainText() {
            return MediaType.access$getPlainText$cp();
        }

        public final MediaType getText() {
            return MediaType.access$getText$cp();
        }
    }

    static {
        Companion = new Companion(null);
        Text = new MediaType("text/*");
        PlainText = new MediaType("text/plain");
        HtmlText = new MediaType("text/html");
        Image = new MediaType("image/*");
        All = new MediaType("*/*");
    }

    public int hashCode() {
        return this.representation.hashCode();
    }

    public String toString() {
        return "MediaType(representation='" + this.representation + "')";
    }

    public static final /* synthetic */ MediaType access$getAll$cp() {
        return All;
    }

    public static final /* synthetic */ MediaType access$getHtmlText$cp() {
        return HtmlText;
    }

    public static final /* synthetic */ MediaType access$getImage$cp() {
        return Image;
    }

    public static final /* synthetic */ MediaType access$getPlainText$cp() {
        return PlainText;
    }

    public static final /* synthetic */ MediaType access$getText$cp() {
        return Text;
    }

    public final String getRepresentation() {
        return this.representation;
    }

    public MediaType(String r100) {
        this.representation = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaType) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.representation, ((MediaType) r100).representation);
    }
}
