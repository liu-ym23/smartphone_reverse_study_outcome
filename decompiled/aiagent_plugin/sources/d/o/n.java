package d.o;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f38657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f38658b = null;

    private n() {
    }

    static {
        f38657a = new n();
        String r0 = "[eE][+-]?(\\p{Digit}+)";
        f38658b = new k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + r0 + ")?)|(\\.((\\p{Digit}+))(" + r0 + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
