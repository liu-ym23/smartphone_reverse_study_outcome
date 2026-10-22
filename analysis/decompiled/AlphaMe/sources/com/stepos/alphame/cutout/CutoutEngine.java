package com.stepos.alphame.cutout;

import android.os.IBinder;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.utils.LocalConsts;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0005\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J&\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0006H\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine;", "Lcom/stepos/alphame/engine/EngineBase;", "()V", LocalConsts.FUNC_CUT_IMAGE_ACQUIRE, "Landroid/os/IBinder;", "fromApp", "", LocalConsts.FUNC_CUT_IMAGE_BY_URI, "bitmapUri", "rotateAngle", "", LocalConsts.FUNC_CUT_IMAGE_INIT, "", "tag", LocalConsts.FUNC_CUT_IMAGE_RELEASE, "", "onStart", "Companion", "CutImageAcquire", "CutImageByUri", "CutImageInit", "CutImageRelease", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CutoutEngine extends EngineBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<CutoutEngine> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<CutoutEngine>() { // from class: com.stepos.alphame.cutout.CutoutEngine$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final CutoutEngine invoke() {
            return new CutoutEngine();
        }
    });

    @NotNull
    public static final String TAG = "CutoutEngine";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/cutout/CutoutEngine;", "getINSTANCE", "()Lcom/stepos/alphame/cutout/CutoutEngine;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CutoutEngine getINSTANCE() {
            return (CutoutEngine) CutoutEngine.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine$CutImageAcquire;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CutImageAcquire extends EngineFunc {
        public CutImageAcquire(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CUT_IMAGE_ACQUIRE;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"fromPackageName"};
            this.returnType = (byte) 7;
            this.annotation = new String[]{"获取扣图结果图片", "@author lyl", "@param fromPackageName 调用方的包名", "@return IBinder 共享内存中的图片Binder "};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine$CutImageByUri;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CutImageByUri extends EngineFunc {
        public CutImageByUri(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CUT_IMAGE_BY_URI;
            this.argsType = new byte[]{6, 6, 4};
            this.argsName = new String[]{"bitmapUri", "fromPackageName", "rotateAngle"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据bitmapUri扣图", "@author lyl", "@param bitmapUri 需要扣图的文件Uri", "@param fromPackageName 调用方的包名", "@param rotateAngle 图片需要旋转角度", "@return String 扣图结果Json "};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine$CutImageInit;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CutImageInit extends EngineFunc {
        public CutImageInit(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CUT_IMAGE_INIT;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"tag"};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"扣图 初始化", "@author lyj", "@return true 初始化成功， false 初始化失败"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/cutout/CutoutEngine$CutImageRelease;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CutImageRelease extends EngineFunc {
        public CutImageRelease(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CUT_IMAGE_RELEASE;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"tag"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"扣图 释放", "@author lyj"};
        }
    }

    @NotProguard
    @Nullable
    public final IBinder cutImageAcquire(@Nullable String fromApp) {
        return CutImageHelper.getInstance().getCutImage(fromApp);
    }

    @NotProguard
    @Nullable
    public final String cutImageByUri(@Nullable String bitmapUri, @Nullable String fromApp, int rotateAngle) {
        return CutImageHelper.getInstance().cutImage(bitmapUri, fromApp, rotateAngle);
    }

    @NotProguard
    public final boolean cutImageInit(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return CutImageHelper.getInstance().init("thirdApp");
    }

    @NotProguard
    public final void cutImageRelease(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        CutImageHelper.getInstance().release(tag);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new CutImageByUri(this));
        EngineBase.addFunc(new CutImageAcquire(this));
        EngineBase.addFunc(new CutImageInit(this));
        EngineBase.addFunc(new CutImageRelease(this));
    }
}
