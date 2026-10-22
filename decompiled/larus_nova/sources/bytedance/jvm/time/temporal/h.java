package bytedance.jvm.time.temporal;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class h implements e {
    public /* synthetic */ h() {
    }

    @Override // bytedance.jvm.time.temporal.e
    public final b adjustInto(b r100) {
        ChronoField r101 = ChronoField.DAY_OF_MONTH;
        return r100.with(r101, r100.range(r101).getMaximum());
    }
}
