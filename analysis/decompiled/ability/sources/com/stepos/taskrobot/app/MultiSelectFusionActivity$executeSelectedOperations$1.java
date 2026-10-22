package com.stepos.taskrobot.app;

import android.graphics.Bitmap;
import android.util.Log;
import com.zyql.screenperception.api.IFusionCallback;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/taskrobot/app/MultiSelectFusionActivity$executeSelectedOperations$1", "Lcom/zyql/screenperception/api/IFusionCallback$Stub;", "", "result", "LC7/r;", "onResult", "(Ljava/lang/String;)V", "", "errorCode", "errorMsg", "onError", "(ILjava/lang/String;)V", "Landroid/graphics/Bitmap;", "p0", "onImageResult", "(Landroid/graphics/Bitmap;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MultiSelectFusionActivity$executeSelectedOperations$1 extends IFusionCallback.Stub {
    final /* synthetic */ long $currentTime;
    final /* synthetic */ a this$0;

    public MultiSelectFusionActivity$executeSelectedOperations$1(long j5, a aVar) {
        this.$currentTime = j5;
    }

    private static final void onResult$lambda$0(a aVar, String str) {
        int i = a.f4024a;
        throw null;
    }

    @Override // com.zyql.screenperception.api.IFusionCallback
    public void onError(int errorCode, String errorMsg) {
        Log.d("MultiSelectFusionActivity", "errorMsg: " + errorMsg + "  errorCode： " + errorCode);
    }

    @Override // com.zyql.screenperception.api.IFusionCallback
    public void onImageResult(Bitmap p02) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.zyql.screenperception.api.IFusionCallback
    public void onResult(String result) {
        Log.d("MultiSelectFusionActivity", "onResult: " + result + "  " + (System.currentTimeMillis() - this.$currentTime));
        throw null;
    }
}
