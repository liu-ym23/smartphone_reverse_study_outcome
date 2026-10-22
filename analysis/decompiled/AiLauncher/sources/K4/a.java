package K4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.code.KeyStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LK4/a;", "", "", "lineComment", "", "blockComment", "htmlComment", "quotes", "Lcom/stepos/agentframework/uikit/code/KeyStyle;", "keyStyle", "<init>", "(Ljava/lang/String;ZZLjava/lang/String;Lcom/stepos/agentframework/uikit/code/KeyStyle;)V", "inTag", Const.INTENT_KEY_APIKEY, "(Z)Z", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "c", "f", "Lcom/stepos/agentframework/uikit/code/KeyStyle;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/uikit/code/KeyStyle;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    private final boolean blockComment;
    private final boolean htmlComment;
    private final KeyStyle keyStyle;
    private final String lineComment;
    private final String quotes;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K4.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0064a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyStyle.values().length];
            try {
                iArr[KeyStyle.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyStyle.ATTR_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyStyle.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public a(String str, boolean z10, boolean z11, String quotes, KeyStyle keyStyle) {
        p.i(quotes, "quotes");
        p.i(keyStyle, "keyStyle");
        this.lineComment = str;
        this.blockComment = z10;
        this.htmlComment = z11;
        this.quotes = quotes;
        this.keyStyle = keyStyle;
    }

    public final boolean a(boolean inTag) {
        int i10 = C0064a.$EnumSwitchMapping$0[this.keyStyle.ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return inTag;
        }
        if (i10 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: b, reason: from getter */
    public final boolean getBlockComment() {
        return this.blockComment;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHtmlComment() {
        return this.htmlComment;
    }

    /* renamed from: d, reason: from getter */
    public final KeyStyle getKeyStyle() {
        return this.keyStyle;
    }

    /* renamed from: e, reason: from getter */
    public final String getLineComment() {
        return this.lineComment;
    }

    /* renamed from: f, reason: from getter */
    public final String getQuotes() {
        return this.quotes;
    }

    public /* synthetic */ a(String str, boolean z10, boolean z11, String str2, KeyStyle keyStyle, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? "\"'" : str2, (i10 & 16) != 0 ? KeyStyle.NONE : keyStyle);
    }
}
