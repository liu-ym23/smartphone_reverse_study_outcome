package K4;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.code.CodeTokenKind;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LK4/d;", "", "<init>", "()V", "", "language", "source", "LK4/d$a;", "colors", "", "limit", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;LK4/d$a;I)Ljava/lang/CharSequence;", "", "isNight", Const.INTENT_KEY_APIKEY, "(Z)LK4/d$a;", "HIGHLIGHT_CHAR_LIMIT", "I", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {
    public static final int HIGHLIGHT_CHAR_LIMIT = 20000;
    public static final d INSTANCE = new d();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"LK4/d$a;", "", "", "comment", "string", "key", "<init>", "(III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K4.d$a, reason: from toString */
    public static final /* data */ class Colors {
        private final int comment;
        private final int key;
        private final int string;

        public Colors(int i10, int i11, int i12) {
            this.comment = i10;
            this.string = i11;
            this.key = i12;
        }

        /* renamed from: a, reason: from getter */
        public final int getComment() {
            return this.comment;
        }

        /* renamed from: b, reason: from getter */
        public final int getKey() {
            return this.key;
        }

        /* renamed from: c, reason: from getter */
        public final int getString() {
            return this.string;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Colors)) {
                return false;
            }
            Colors colors = (Colors) other;
            return this.comment == colors.comment && this.string == colors.string && this.key == colors.key;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.comment) * 31) + Integer.hashCode(this.string)) * 31) + Integer.hashCode(this.key);
        }

        public String toString() {
            return "Colors(comment=" + this.comment + ", string=" + this.string + ", key=" + this.key + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodeTokenKind.values().length];
            try {
                iArr[CodeTokenKind.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CodeTokenKind.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CodeTokenKind.KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Colors a(boolean isNight) {
        return new Colors(isNight ? 1944841205 : -9800835, TaskChipController.DONE_TEXT_COLOR, -2317044);
    }

    public final CharSequence b(String language, String source, Colors colors, int limit) {
        int comment;
        p.i(language, "language");
        p.i(source, "source");
        p.i(colors, "colors");
        if (source.length() == 0) {
            return source;
        }
        int iN = C5685n.n(limit, 0, source.length());
        K4.b bVar = K4.b.INSTANCE;
        List<CodeToken> listH = bVar.h(source, bVar.g(language), iN);
        if (listH.isEmpty()) {
            return source;
        }
        String strSubstring = source.substring(0, iN);
        p.h(strSubstring, "substring(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strSubstring);
        if (iN < source.length()) {
            String strSubstring2 = source.substring(iN);
            p.h(strSubstring2, "substring(...)");
            spannableStringBuilder.append((CharSequence) strSubstring2);
        }
        for (CodeToken codeToken : listH) {
            int i10 = b.$EnumSwitchMapping$0[codeToken.getKind().ordinal()];
            if (i10 == 1) {
                comment = colors.getComment();
            } else if (i10 == 2) {
                comment = colors.getString();
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                comment = colors.getKey();
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(comment), codeToken.getStart(), codeToken.getEnd(), 33);
        }
        return spannableStringBuilder;
    }
}
