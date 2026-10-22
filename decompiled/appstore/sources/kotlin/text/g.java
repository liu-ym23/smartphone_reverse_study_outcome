package kotlin.text;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21270a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f21271b = null;

    static {
        f21270a = new g();
        String r10 = "[eE][+-]?(\\p{Digit}+)";
        f21271b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + r10 + ")?)|(\\.((\\p{Digit}+))(" + r10 + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    public g() {
    }
}
