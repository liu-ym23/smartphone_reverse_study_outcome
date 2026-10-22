package t5;

import S7.k;
import android.graphics.Bitmap;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.sqlite.SQLiteConnection;
import com.stepos.motionkit.fx.anim.AnimationBuilder;
import com.stepos.motionkit.fx.anim.TrackBuilder;
import com.stepos.motionkit.fx.effects.EdgeGlowKt;
import com.stepos.motionkit.fx.effects.SpectrumBorderKt;
import com.stepos.motionkit.fx.effects.WaveGlowKt;
import com.stepos.net.HttpConfig;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import stepai.aios.guiagent.llm.cell.config.ModelConfigInner;

/* renamed from: t5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2016a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6659a;

    public /* synthetic */ C2016a(int i) {
        this.f6659a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6659a) {
            case 0:
                return EdgeGlowKt.EdgeGlow$lambda$1$lambda$0((TrackBuilder) obj);
            case 1:
                return EdgeGlowKt.EdgeGlow$lambda$1((AnimationBuilder) obj);
            case 2:
                return SpectrumBorderKt.SpectrumBorder$lambda$1((AnimationBuilder) obj);
            case 3:
                return SpectrumBorderKt.SpectrumBorder$lambda$1$lambda$0((TrackBuilder) obj);
            case 4:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$0((TrackBuilder) obj);
            case 5:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$9((TrackBuilder) obj);
            case 6:
                return WaveGlowKt.WaveGlow$lambda$11((AnimationBuilder) obj);
            case 7:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$10((TrackBuilder) obj);
            case 8:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$1((TrackBuilder) obj);
            case 9:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$2((TrackBuilder) obj);
            case 10:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$3((TrackBuilder) obj);
            case 11:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$4((TrackBuilder) obj);
            case 12:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$5((TrackBuilder) obj);
            case 13:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$6((TrackBuilder) obj);
            case 14:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$7((TrackBuilder) obj);
            case 15:
                return WaveGlowKt.WaveGlow$lambda$11$lambda$8((TrackBuilder) obj);
            case 16:
                return TaskDao_Impl.deleteAllTasks$lambda$0("DELETE FROM task", (SQLiteConnection) obj);
            case 17:
                return TaskDao_Impl.getAll$lambda$0("SELECT * FROM task ORDER BY createTime DESC", (SQLiteConnection) obj);
            case 18:
                return TaskDeviceInfoDao_Impl.getAll$lambda$0("SELECT * FROM task_device_info ORDER BY createTime DESC", (SQLiteConnection) obj);
            case 19:
                return TaskStepDao_Impl.deleteAllSteps$lambda$0("DELETE FROM task_step", (SQLiteConnection) obj);
            case 20:
                Bitmap it = (Bitmap) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return it;
            case 21:
                AccessibilityNodeInfo node = (AccessibilityNodeInfo) obj;
                kotlin.jvm.internal.k.f(node, "node");
                return Boolean.valueOf(node.isFocused() && node.isEditable() && node.isEnabled());
            case 22:
                return Boolean.valueOf(HttpConfig.Builder.successCodeChecker$lambda$0(((Integer) obj).intValue()));
            case 23:
                kotlin.jvm.internal.k.f((String) obj, "it");
                return new kotlinx.coroutines.sync.a();
            default:
                return ModelConfigInner.applyModelCellToRuntime$lambda$0$0((Bitmap) obj);
        }
    }
}
