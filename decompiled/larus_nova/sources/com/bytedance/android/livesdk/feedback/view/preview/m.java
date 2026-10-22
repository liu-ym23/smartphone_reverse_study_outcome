package com.bytedance.android.livesdk.feedback.view.preview;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f125035a;

    public m(n r100) {
        this.f125035a = r100;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.i
    public final void onClick(boolean r100) {
        if (r100 == false) goto L6;
        h r101 = this.f125035a.getListener();
        if (r101 == null) goto L10;
        r101.a(this.f125035a.getRoomCardStruct());
        return;
    L10:
        return;
    L6:
        h r102 = this.f125035a.getListener();
        if (r102 == null) goto L12;
        r102.b(this.f125035a.getRoomCardStruct());
        return;
    }
}
