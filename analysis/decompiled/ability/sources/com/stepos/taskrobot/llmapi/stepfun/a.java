package com.stepos.taskrobot.llmapi.stepfun;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4029a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(String str, int i) {
        this.f4029a = i;
        this.b = str;
    }

    @Override // S7.a
    public final Object invoke() {
        boolean zIsConflictVisibleToCaller$lambda$0;
        int i = this.f4029a;
        String str = this.b;
        switch (i) {
            case 0:
                return DebugInfoDialogListener.onUserInputRequested$lambda$0$1(str);
            case 1:
                zIsConflictVisibleToCaller$lambda$0 = SystemSdkBridge.isConflictVisibleToCaller$lambda$0(str);
                break;
            default:
                zIsConflictVisibleToCaller$lambda$0 = SystemSdkBridge.isConflictVisibleToCaller$lambda$1(str);
                break;
        }
        return Boolean.valueOf(zIsConflictVisibleToCaller$lambda$0);
    }
}
