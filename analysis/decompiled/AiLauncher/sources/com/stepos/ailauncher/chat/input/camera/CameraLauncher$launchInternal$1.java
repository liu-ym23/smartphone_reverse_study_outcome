package com.stepos.ailauncher.chat.input.camera;

import Ua.M;
import Y8.t;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.TransferActivity;
import com.zyql.ai.selector.PictureSelector;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.camera.CameraLauncher$launchInternal$1", f = "CameraLauncher.kt", l = {113}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CameraLauncher$launchInternal$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ boolean $fromMoreMenu;
    final /* synthetic */ M $scope;
    int label;
    final /* synthetic */ CameraLauncher this$0;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/input/camera/CameraLauncher$launchInternal$1$a", "Lcom/zyql/ai/selector/listener/OnResultCallbackListener;", "Lcom/zyql/ai/selector/entity/LocalMedia;", "", "result", "LY8/t;", "onResult", "(Ljava/util/List;)V", "onCancel", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements OnResultCallbackListener<LocalMedia> {
        final /* synthetic */ CameraLauncher this$0;

        public a(CameraLauncher cameraLauncher) {
            this.this$0 = cameraLauncher;
        }

        @Override // com.zyql.ai.selector.listener.OnResultCallbackListener
        public void onCancel() {
            if (this.this$0.H()) {
                return;
            }
            Log.d("CameraLauncher", "openCamera: 用户取消拍照");
            TransferActivity.INSTANCE.f();
            this.this$0.v();
        }

        @Override // com.zyql.ai.selector.listener.OnResultCallbackListener
        public void onResult(List<LocalMedia> result) {
            kotlin.jvm.internal.p.i(result, "result");
            TransferActivity.INSTANCE.f();
            if (!result.isEmpty()) {
                Log.d("CameraLauncher", "openCamera: 收到照片结果,数量: " + result.size());
                this.this$0.onResult.invoke(result);
            }
            this.this$0.v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraLauncher$launchInternal$1(CameraLauncher cameraLauncher, M m10, boolean z10, InterfaceC4014c<? super CameraLauncher$launchInternal$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = cameraLauncher;
        this.$scope = m10;
        this.$fromMoreMenu = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraLauncher$launchInternal$1(this.this$0, this.$scope, this.$fromMoreMenu, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CameraLauncher$launchInternal$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Activity activity;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                CameraLauncher cameraLauncher = this.this$0;
                M m10 = this.$scope;
                boolean z10 = this.$fromMoreMenu;
                this.label = 1;
                obj = cameraLauncher.t(m10, z10, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            activity = (Activity) obj;
        } catch (CancellationException e10) {
            TransferActivity.Companion companion = TransferActivity.INSTANCE;
            companion.c();
            companion.f();
            this.this$0.v();
            throw e10;
        } catch (Exception e11) {
            TransferActivity.Companion companion2 = TransferActivity.INSTANCE;
            companion2.c();
            Log.e("CameraLauncher", "openCamera: 打开相机失败", e11);
            Toast.makeText(this.this$0.context, this.this$0.context.getString(R$string.camera_open_failed, e11.getMessage()), 0).show();
            companion2.f();
            this.this$0.v();
        }
        if (activity != null && !this.this$0.cancelledFromHome) {
            this.this$0.A();
            PictureSelector.create(activity).openCamera(PictureMimeType.ofImage()).imageEngine(com.stepos.ailauncher.chat.util.a.INSTANCE.a()).forResult(new a(this.this$0));
            return t.f7040a;
        }
        Log.e("CameraLauncher", "launch: 无法获取 Activity 实例 or cancelled");
        this.this$0.v();
        return t.f7040a;
    }
}
