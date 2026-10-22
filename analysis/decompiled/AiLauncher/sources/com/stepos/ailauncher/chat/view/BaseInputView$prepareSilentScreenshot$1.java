package com.stepos.ailauncher.chat.view;

import android.net.Uri;
import android.os.SystemClock;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C0919o;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$prepareSilentScreenshot$1", f = "BaseInputView.kt", l = {4195, 4203}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$prepareSilentScreenshot$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ long $screenshotRound;
    final /* synthetic */ Uri $uri;
    long J$0;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$prepareSilentScreenshot$1(long j10, BaseInputView baseInputView, Uri uri, InterfaceC4014c<? super BaseInputView$prepareSilentScreenshot$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$screenshotRound = j10;
        this.this$0 = baseInputView;
        this.$uri = uri;
    }

    public static final Y8.t h(BaseInputView baseInputView, long j10, FileInfo fileInfo) {
        baseInputView.silentScreenshotUploadInFlight = false;
        if (baseInputView.silentCaptureCancelled || fileInfo == null) {
            baseInputView.silentScreenshotFile = null;
            baseInputView.d6(true);
        } else {
            baseInputView.d6(true);
        }
        C0919o.e("SCREENSHOT", (baseInputView.silentCaptureCancelled || fileInfo == null) ? "问屏图上传失败/拦截/取消" : "问屏图上传就绪(成功)", SystemClock.elapsedRealtime() - j10);
        C4148a.d("InputView", "prepareSilentScreenshot: upload result ready=" + (fileInfo != null) + " silent=" + (fileInfo != null ? Boolean.valueOf(fileInfo.getSilent()) : null), false, 4, null);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$prepareSilentScreenshot$1(this.$screenshotRound, this.this$0, this.$uri, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$prepareSilentScreenshot$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.BaseInputView$prepareSilentScreenshot$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
