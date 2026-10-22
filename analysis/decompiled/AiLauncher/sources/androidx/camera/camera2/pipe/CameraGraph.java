package androidx.camera.camera2.pipe;

import Ua.Q;
import Z8.C1173v;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Log;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.p;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.C5694F;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.C5699e;
import w.C5701g;
import w.C5708n;
import w.ConcurrentCameraGraphs;
import w.InterfaceC5690B;
import w.InterfaceC5698d;
import w.InterfaceC5704j;
import w.M;
import w.Result3A;
import w.x;
import w.y;
import x.C5810d0;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0007\u0004\u0005\u0006\u0007\b\t\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/d;", "Landroidx/camera/camera2/pipe/CameraGraph$f;", "Lw/j;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "RepeatingRequestRequirementsBeforeCapture", Const.INTENT_KEY_UMID, "e", "c", "f", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CameraGraph extends d<f>, InterfaceC5704j {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u000eB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "", "LY8/m;", "repeatingFramesToComplete", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "completionBehavior", "<init>", "(ILandroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;Lkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "()I", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "()Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "CompletionBehavior", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RepeatingRequestRequirementsBeforeCapture {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int repeatingFramesToComplete;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final CompletionBehavior completionBehavior;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture$CompletionBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "AT_LEAST", "EXACT", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CompletionBehavior {
            private static final /* synthetic */ InterfaceC4149a $ENTRIES;
            private static final /* synthetic */ CompletionBehavior[] $VALUES;
            public static final CompletionBehavior AT_LEAST = new CompletionBehavior("AT_LEAST", 0);
            public static final CompletionBehavior EXACT = new CompletionBehavior("EXACT", 1);

            private static final /* synthetic */ CompletionBehavior[] $values() {
                return new CompletionBehavior[]{AT_LEAST, EXACT};
            }

            static {
                CompletionBehavior[] completionBehaviorArr$values = $values();
                $VALUES = completionBehaviorArr$values;
                $ENTRIES = kotlin.enums.a.a(completionBehaviorArr$values);
            }

            private CompletionBehavior(String str, int i10) {
            }

            public static InterfaceC4149a<CompletionBehavior> getEntries() {
                return $ENTRIES;
            }

            public static CompletionBehavior valueOf(String str) {
                return (CompletionBehavior) Enum.valueOf(CompletionBehavior.class, str);
            }

            public static CompletionBehavior[] values() {
                return (CompletionBehavior[]) $VALUES.clone();
            }
        }

        public /* synthetic */ RepeatingRequestRequirementsBeforeCapture(int i10, CompletionBehavior completionBehavior, kotlin.jvm.internal.i iVar) {
            this(i10, completionBehavior);
        }

        /* renamed from: a, reason: from getter */
        public final CompletionBehavior getCompletionBehavior() {
            return this.completionBehavior;
        }

        /* renamed from: b, reason: from getter */
        public final int getRepeatingFramesToComplete() {
            return this.repeatingFramesToComplete;
        }

        public RepeatingRequestRequirementsBeforeCapture(int i10, CompletionBehavior completionBehavior) {
            kotlin.jvm.internal.p.i(completionBehavior, "completionBehavior");
            this.repeatingFramesToComplete = i10;
            this.completionBehavior = completionBehavior;
        }

        public /* synthetic */ RepeatingRequestRequirementsBeforeCapture(int i10, CompletionBehavior completionBehavior, int i11, kotlin.jvm.internal.i iVar) {
            this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? CompletionBehavior.AT_LEAST : completionBehavior, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$a;", "", "", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfigs", "<init>", "(Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<b> graphConfigs;

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0053 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[LOOP:1: B:10:0x002e->B:44:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.util.List<androidx.camera.camera2.pipe.CameraGraph.b> r6) {
            /*
                r5 = this;
                java.lang.String r0 = "graphConfigs"
                kotlin.jvm.internal.p.i(r6, r0)
                r5.<init>()
                r5.graphConfigs = r6
                int r0 = r6.size()
                r1 = 2
                if (r0 < r1) goto La5
                java.lang.Object r0 = Z8.F.q0(r6)
                androidx.camera.camera2.pipe.CameraGraph$b r0 = (androidx.camera.camera2.pipe.CameraGraph.b) r0
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                boolean r1 = r6 instanceof java.util.Collection
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L2a
                r1 = r6
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L2a
            L28:
                r6 = r3
                goto L54
            L2a:
                java.util.Iterator r6 = r6.iterator()
            L2e:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L28
                java.lang.Object r1 = r6.next()
                androidx.camera.camera2.pipe.CameraGraph$b r1 = (androidx.camera.camera2.pipe.CameraGraph.b) r1
                java.lang.String r1 = r1.getCameraBackendId()
                java.lang.String r4 = r0.getCameraBackendId()
                if (r1 != 0) goto L4a
                if (r4 != 0) goto L48
                r1 = r3
                goto L51
            L48:
                r1 = r2
                goto L51
            L4a:
                if (r4 != 0) goto L4d
                goto L48
            L4d:
                boolean r1 = w.C5699e.d(r1, r4)
            L51:
                if (r1 != 0) goto L2e
                r6 = r2
            L54:
                if (r6 == 0) goto L9d
                java.util.List<androidx.camera.camera2.pipe.CameraGraph$b> r6 = r5.graphConfigs
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 10
                int r1 = Z8.C1174w.x(r6, r1)
                r0.<init>(r1)
                java.util.Iterator r6 = r6.iterator()
            L69:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L81
                java.lang.Object r1 = r6.next()
                androidx.camera.camera2.pipe.CameraGraph$b r1 = (androidx.camera.camera2.pipe.CameraGraph.b) r1
                java.lang.String r1 = r1.getCamera()
                w.n r1 = w.C5708n.a(r1)
                r0.add(r1)
                goto L69
            L81:
                java.util.List r6 = Z8.F.g0(r0)
                int r6 = r6.size()
                java.util.List<androidx.camera.camera2.pipe.CameraGraph$b> r5 = r5.graphConfigs
                int r5 = r5.size()
                if (r6 != r5) goto L92
                r2 = r3
            L92:
                if (r2 == 0) goto L95
                return
            L95:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "Each CameraGraph.Config must have a distinct camera id!"
                r5.<init>(r6)
                throw r5
            L9d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "Each CameraGraph.Config must use the same camera backend!"
                r5.<init>(r6)
                throw r5
            La5:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "Cannot create ConcurrentGraphConfig without 2 or more CameraGraph.Config(s)"
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.CameraGraph.a.<init>(java.util.List):void");
        }

        public final List<b> a() {
            return this.graphConfigs;
        }
    }

    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u0010&R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010)R#\u0010\u000e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b5\u0010=\u001a\u0004\bC\u0010)R\u0017\u0010\u0011\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\bD\u0010=\u001a\u0004\b?\u0010)R#\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0006¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\b<\u0010BR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00103R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\bE\u00103R#\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0006¢\u0006\f\n\u0004\bF\u0010@\u001a\u0004\bF\u0010BR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\b0\u0010&R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\bC\u0010H\u001a\u0004\b6\u0010IR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\bA\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b>\u0010M\u001a\u0004\bD\u0010NR\u0019\u0010!\u001a\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\bG\u0010&R$\u0010T\u001a\u0004\u0018\u00010O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b4\u0010R\"\u0004\bP\u0010S¨\u0006U"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$b;", "", "Lw/n;", C3081a.CAMERA_FOCUS, "", "Landroidx/camera/camera2/pipe/k$a;", "streams", "exclusiveStreamGroups", "Landroidx/camera/camera2/pipe/p$a;", "input", "postviewStream", "Lw/M;", "sessionTemplate", "", "sessionParameters", "Landroidx/camera/camera2/pipe/CameraGraph$e;", "sessionMode", "defaultTemplate", "defaultParameters", "Landroidx/camera/camera2/pipe/t$a;", "defaultListeners", "Lw/B;", "graphStateListeners", "requiredParameters", "Lw/e;", "cameraBackendId", "Lw/d;", "customCameraBackend", "Landroidx/camera/camera2/pipe/r;", "metadataTransform", "Landroidx/camera/camera2/pipe/CameraGraph$d;", "flags", "Lw/g;", "sessionColorSpace", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/k$a;ILjava/util/Map;IILjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lw/d;Landroidx/camera/camera2/pipe/r;Landroidx/camera/camera2/pipe/CameraGraph$d;Ljava/lang/String;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "r", "()Ljava/util/List;", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "k", "e", "Landroidx/camera/camera2/pipe/k$a;", "l", "()Landroidx/camera/camera2/pipe/k$a;", "f", "I", "q", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", "p", "()Ljava/util/Map;", "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "m", "n", "Lw/d;", "()Lw/d;", "Landroidx/camera/camera2/pipe/r;", "getMetadataTransform", "()Landroidx/camera/camera2/pipe/r;", "Landroidx/camera/camera2/pipe/CameraGraph$d;", "()Landroidx/camera/camera2/pipe/CameraGraph$d;", "Lw/s;", "s", "Lw/s;", "()Lw/s;", "(Lw/s;)V", "concurrentCameraGraphs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String camera;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<k.a> streams;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<List<k.a>> exclusiveStreamGroups;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<p.a> input;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final k.a postviewStream;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final int sessionTemplate;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> sessionParameters;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final int sessionMode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final int defaultTemplate;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> defaultParameters;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final List<t.a> defaultListeners;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public final List<InterfaceC5690B> graphStateListeners;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> requiredParameters;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public final String cameraBackendId;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5698d customCameraBackend;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public final MetadataTransform metadataTransform;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public final Flags flags;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public final String sessionColorSpace;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public ConcurrentCameraGraphs concurrentCameraGraphs;

        public /* synthetic */ b(String str, List list, List list2, List list3, k.a aVar, int i10, Map map, int i11, int i12, Map map2, List list4, List list5, Map map3, String str2, InterfaceC5698d interfaceC5698d, MetadataTransform metadataTransform, Flags flags, String str3, kotlin.jvm.internal.i iVar) {
            this(str, list, list2, list3, aVar, i10, map, i11, i12, map2, list4, list5, map3, str2, interfaceC5698d, metadataTransform, flags, str3);
        }

        /* renamed from: a, reason: from getter */
        public final String getCamera() {
            return this.camera;
        }

        /* renamed from: b, reason: from getter */
        public final String getCameraBackendId() {
            return this.cameraBackendId;
        }

        /* renamed from: c, reason: from getter */
        public final ConcurrentCameraGraphs getConcurrentCameraGraphs() {
            return this.concurrentCameraGraphs;
        }

        /* renamed from: d, reason: from getter */
        public final InterfaceC5698d getCustomCameraBackend() {
            return this.customCameraBackend;
        }

        public final List<t.a> e() {
            return this.defaultListeners;
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00dc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 233
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.CameraGraph.b.equals(java.lang.Object):boolean");
        }

        public final Map<?, Object> f() {
            return this.defaultParameters;
        }

        /* renamed from: g, reason: from getter */
        public final int getDefaultTemplate() {
            return this.defaultTemplate;
        }

        public final List<List<k.a>> h() {
            return this.exclusiveStreamGroups;
        }

        public int hashCode() {
            int iE = ((((C5708n.e(this.camera) * 31) + this.streams.hashCode()) * 31) + this.exclusiveStreamGroups.hashCode()) * 31;
            List<p.a> list = this.input;
            int iHashCode = (iE + (list == null ? 0 : list.hashCode())) * 31;
            k.a aVar = this.postviewStream;
            int iHashCode2 = (((((((((((((((((iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + M.f(this.sessionTemplate)) * 31) + this.sessionParameters.hashCode()) * 31) + e.g(this.sessionMode)) * 31) + M.f(this.defaultTemplate)) * 31) + this.defaultParameters.hashCode()) * 31) + this.defaultListeners.hashCode()) * 31) + this.graphStateListeners.hashCode()) * 31) + this.requiredParameters.hashCode()) * 31;
            String str = this.cameraBackendId;
            int iE2 = (iHashCode2 + (str == null ? 0 : C5699e.e(str))) * 31;
            InterfaceC5698d interfaceC5698d = this.customCameraBackend;
            int iHashCode3 = (((((iE2 + (interfaceC5698d == null ? 0 : interfaceC5698d.hashCode())) * 31) + this.metadataTransform.hashCode()) * 31) + this.flags.hashCode()) * 31;
            String str2 = this.sessionColorSpace;
            return iHashCode3 + (str2 != null ? C5701g.c(str2) : 0);
        }

        /* renamed from: i, reason: from getter */
        public final Flags getFlags() {
            return this.flags;
        }

        public final List<InterfaceC5690B> j() {
            return this.graphStateListeners;
        }

        public final List<p.a> k() {
            return this.input;
        }

        /* renamed from: l, reason: from getter */
        public final k.a getPostviewStream() {
            return this.postviewStream;
        }

        public final Map<?, Object> m() {
            return this.requiredParameters;
        }

        /* renamed from: n, reason: from getter */
        public final String getSessionColorSpace() {
            return this.sessionColorSpace;
        }

        /* renamed from: o, reason: from getter */
        public final int getSessionMode() {
            return this.sessionMode;
        }

        public final Map<?, Object> p() {
            return this.sessionParameters;
        }

        /* renamed from: q, reason: from getter */
        public final int getSessionTemplate() {
            return this.sessionTemplate;
        }

        public final List<k.a> r() {
            return this.streams;
        }

        public final void s(ConcurrentCameraGraphs c5712s) {
            this.concurrentCameraGraphs = c5712s;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Config(camera=");
            sb2.append((Object) C5708n.f(this.camera));
            sb2.append(", streams=");
            sb2.append(this.streams);
            sb2.append(", exclusiveStreamGroups=");
            sb2.append(this.exclusiveStreamGroups);
            sb2.append(", input=");
            sb2.append(this.input);
            sb2.append(", postviewStream=");
            sb2.append(this.postviewStream);
            sb2.append(", sessionTemplate=");
            sb2.append((Object) M.g(this.sessionTemplate));
            sb2.append(", sessionParameters=");
            sb2.append(this.sessionParameters);
            sb2.append(", sessionMode=");
            sb2.append((Object) e.h(this.sessionMode));
            sb2.append(", defaultTemplate=");
            sb2.append((Object) M.g(this.defaultTemplate));
            sb2.append(", defaultParameters=");
            sb2.append(this.defaultParameters);
            sb2.append(", defaultListeners=");
            sb2.append(this.defaultListeners);
            sb2.append(", graphStateListeners=");
            sb2.append(this.graphStateListeners);
            sb2.append(", requiredParameters=");
            sb2.append(this.requiredParameters);
            sb2.append(", cameraBackendId=");
            String str = this.cameraBackendId;
            sb2.append((Object) (str == null ? "null" : C5699e.f(str)));
            sb2.append(", customCameraBackend=");
            sb2.append(this.customCameraBackend);
            sb2.append(", metadataTransform=");
            sb2.append(this.metadataTransform);
            sb2.append(", flags=");
            sb2.append(this.flags);
            sb2.append(", sessionColorSpace=");
            String str2 = this.sessionColorSpace;
            sb2.append((Object) (str2 != null ? C5701g.e(str2) : "null"));
            sb2.append(')');
            return sb2.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String camera, List<k.a> streams, List<? extends List<k.a>> exclusiveStreamGroups, List<p.a> list, k.a aVar, int i10, Map<?, ? extends Object> sessionParameters, int i11, int i12, Map<?, ? extends Object> defaultParameters, List<? extends t.a> defaultListeners, List<? extends InterfaceC5690B> graphStateListeners, Map<?, ? extends Object> requiredParameters, String str, InterfaceC5698d interfaceC5698d, MetadataTransform metadataTransform, Flags flags, String str2) {
            kotlin.jvm.internal.p.i(camera, "camera");
            kotlin.jvm.internal.p.i(streams, "streams");
            kotlin.jvm.internal.p.i(exclusiveStreamGroups, "exclusiveStreamGroups");
            kotlin.jvm.internal.p.i(sessionParameters, "sessionParameters");
            kotlin.jvm.internal.p.i(defaultParameters, "defaultParameters");
            kotlin.jvm.internal.p.i(defaultListeners, "defaultListeners");
            kotlin.jvm.internal.p.i(graphStateListeners, "graphStateListeners");
            kotlin.jvm.internal.p.i(requiredParameters, "requiredParameters");
            kotlin.jvm.internal.p.i(metadataTransform, "metadataTransform");
            kotlin.jvm.internal.p.i(flags, "flags");
            this.camera = camera;
            this.streams = streams;
            this.exclusiveStreamGroups = exclusiveStreamGroups;
            this.input = list;
            this.postviewStream = aVar;
            this.sessionTemplate = i10;
            this.sessionParameters = sessionParameters;
            this.sessionMode = i11;
            this.defaultTemplate = i12;
            this.defaultParameters = defaultParameters;
            this.defaultListeners = defaultListeners;
            this.graphStateListeners = graphStateListeners;
            this.requiredParameters = requiredParameters;
            this.cameraBackendId = str;
            this.customCameraBackend = interfaceC5698d;
            this.metadataTransform = metadataTransform;
            this.flags = flags;
            this.sessionColorSpace = str2;
            if (str != null && interfaceC5698d != null) {
                throw new IllegalStateException("Setting both cameraBackendId and customCameraBackend is not supported.");
            }
        }

        public /* synthetic */ b(String str, List list, List list2, List list3, k.a aVar, int i10, Map map, int i11, int i12, Map map2, List list4, List list5, Map map3, String str2, InterfaceC5698d interfaceC5698d, MetadataTransform metadataTransform, Flags flags, String str3, int i13, kotlin.jvm.internal.i iVar) {
            this(str, list, (i13 & 4) != 0 ? C1173v.m() : list2, (i13 & 8) != 0 ? null : list3, (i13 & 16) != 0 ? null : aVar, (i13 & 32) != 0 ? M.b(1) : i10, (i13 & 64) != 0 ? kotlin.collections.a.i() : map, (i13 & 128) != 0 ? e.INSTANCE.d() : i11, (i13 & 256) != 0 ? M.b(1) : i12, (i13 & 512) != 0 ? kotlin.collections.a.i() : map2, (i13 & 1024) != 0 ? C1173v.m() : list4, (i13 & 2048) != 0 ? C1173v.m() : list5, (i13 & 4096) != 0 ? kotlin.collections.a.i() : map3, (i13 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str2, (i13 & 16384) != 0 ? null : interfaceC5698d, (32768 & i13) != 0 ? new MetadataTransform(0, 0, null, 7, null) : metadataTransform, (65536 & i13) != 0 ? new Flags(false, false, null, null, 0, false, false, false, 255, null) : flags, (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str3, null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$c;", "", "<init>", "()V", "", "Landroid/hardware/camera2/params/MeteringRectangle;", Const.INTENT_KEY_PKGNAME, "[Landroid/hardware/camera2/params/MeteringRectangle;", "getMETERING_REGIONS_EMPTY", "()[Landroid/hardware/camera2/params/MeteringRectangle;", "METERING_REGIONS_EMPTY", "c", Const.INTENT_KEY_APIKEY, "METERING_REGIONS_DEFAULT", "Lw/y;", Const.INTENT_KEY_UMID, "J", "getFRAME_NUMBER_INVALID-Ugla2oM", "()J", "FRAME_NUMBER_INVALID", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f10153a = new c();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final MeteringRectangle[] METERING_REGIONS_EMPTY = new MeteringRectangle[0];

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final MeteringRectangle[] METERING_REGIONS_DEFAULT = {new MeteringRectangle(0, 0, 0, 0, 0)};

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public static final long FRAME_NUMBER_INVALID = y.b(-1);

        public final MeteringRectangle[] a() {
            return METERING_REGIONS_DEFAULT;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u0018\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b \u0010\u001bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b&\u0010\u001b¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$d;", "", "", "configureBlankSessionOnStop", "abortCapturesOnStop", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "awaitRepeatingRequestBeforeCapture", "awaitRepeatingRequestOnDisconnect", "Landroidx/camera/camera2/pipe/CameraGraph$d$a;", "finalizeSessionOnCloseBehavior", "closeCaptureSessionOnDisconnect", "closeCameraDeviceOnClose", "enableRestartDelays", "<init>", "(ZZLandroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;Ljava/lang/Boolean;IZZZLkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "getConfigureBlankSessionOnStop", "()Z", Const.INTENT_KEY_PKGNAME, "c", "Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", "()Landroidx/camera/camera2/pipe/CameraGraph$RepeatingRequestRequirementsBeforeCapture;", Const.INTENT_KEY_UMID, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "e", "I", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.CameraGraph$d, reason: from toString */
    public static final /* data */ class Flags {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean configureBlankSessionOnStop;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean abortCapturesOnStop;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Boolean awaitRepeatingRequestOnDisconnect;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final int finalizeSessionOnCloseBehavior;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean closeCaptureSessionOnDisconnect;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean closeCameraDeviceOnClose;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean enableRestartDelays;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$d$a;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(I)I", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Ljava/lang/String;", "f", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.CameraGraph$d$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* renamed from: b, reason: collision with root package name */
            public static final int f10166b = d(0);

            /* renamed from: c, reason: collision with root package name */
            public static final int f10167c = d(1);

            /* renamed from: d, reason: collision with root package name */
            public static final int f10168d = d(2);

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$d$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/CameraGraph$d$a;", "OFF", "I", Const.INTENT_KEY_PKGNAME, "()I", "IMMEDIATE", Const.INTENT_KEY_APIKEY, "TIMEOUT", "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* renamed from: androidx.camera.camera2.pipe.CameraGraph$d$a$a, reason: collision with other inner class name and from kotlin metadata */
            public static final class Companion {
                public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                    this();
                }

                public final int a() {
                    return a.f10167c;
                }

                public final int b() {
                    return a.f10166b;
                }

                public final int c() {
                    return a.f10168d;
                }

                public Companion() {
                }
            }

            public static int d(int i10) {
                return i10;
            }

            public static final boolean e(int i10, int i11) {
                return i10 == i11;
            }

            public static int f(int i10) {
                return Integer.hashCode(i10);
            }

            public static String g(int i10) {
                return "FinalizeSessionOnCloseBehavior(value=" + i10 + ')';
            }
        }

        public /* synthetic */ Flags(boolean z10, boolean z11, RepeatingRequestRequirementsBeforeCapture repeatingRequestRequirementsBeforeCapture, Boolean bool, int i10, boolean z12, boolean z13, boolean z14, kotlin.jvm.internal.i iVar) {
            this(z10, z11, repeatingRequestRequirementsBeforeCapture, bool, i10, z12, z13, z14);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAbortCapturesOnStop() {
            return this.abortCapturesOnStop;
        }

        /* renamed from: b, reason: from getter */
        public final RepeatingRequestRequirementsBeforeCapture getAwaitRepeatingRequestBeforeCapture() {
            return this.awaitRepeatingRequestBeforeCapture;
        }

        /* renamed from: c, reason: from getter */
        public final Boolean getAwaitRepeatingRequestOnDisconnect() {
            return this.awaitRepeatingRequestOnDisconnect;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getCloseCameraDeviceOnClose() {
            return this.closeCameraDeviceOnClose;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getCloseCaptureSessionOnDisconnect() {
            return this.closeCaptureSessionOnDisconnect;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Flags)) {
                return false;
            }
            Flags flags = (Flags) other;
            return this.configureBlankSessionOnStop == flags.configureBlankSessionOnStop && this.abortCapturesOnStop == flags.abortCapturesOnStop && kotlin.jvm.internal.p.d(this.awaitRepeatingRequestBeforeCapture, flags.awaitRepeatingRequestBeforeCapture) && kotlin.jvm.internal.p.d(this.awaitRepeatingRequestOnDisconnect, flags.awaitRepeatingRequestOnDisconnect) && a.e(this.finalizeSessionOnCloseBehavior, flags.finalizeSessionOnCloseBehavior) && this.closeCaptureSessionOnDisconnect == flags.closeCaptureSessionOnDisconnect && this.closeCameraDeviceOnClose == flags.closeCameraDeviceOnClose && this.enableRestartDelays == flags.enableRestartDelays;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getEnableRestartDelays() {
            return this.enableRestartDelays;
        }

        /* renamed from: g, reason: from getter */
        public final int getFinalizeSessionOnCloseBehavior() {
            return this.finalizeSessionOnCloseBehavior;
        }

        public int hashCode() {
            int iHashCode = ((((Boolean.hashCode(this.configureBlankSessionOnStop) * 31) + Boolean.hashCode(this.abortCapturesOnStop)) * 31) + this.awaitRepeatingRequestBeforeCapture.hashCode()) * 31;
            Boolean bool = this.awaitRepeatingRequestOnDisconnect;
            return ((((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + a.f(this.finalizeSessionOnCloseBehavior)) * 31) + Boolean.hashCode(this.closeCaptureSessionOnDisconnect)) * 31) + Boolean.hashCode(this.closeCameraDeviceOnClose)) * 31) + Boolean.hashCode(this.enableRestartDelays);
        }

        public String toString() {
            return "Flags(configureBlankSessionOnStop=" + this.configureBlankSessionOnStop + ", abortCapturesOnStop=" + this.abortCapturesOnStop + ", awaitRepeatingRequestBeforeCapture=" + this.awaitRepeatingRequestBeforeCapture + ", awaitRepeatingRequestOnDisconnect=" + this.awaitRepeatingRequestOnDisconnect + ", finalizeSessionOnCloseBehavior=" + ((Object) a.g(this.finalizeSessionOnCloseBehavior)) + ", closeCaptureSessionOnDisconnect=" + this.closeCaptureSessionOnDisconnect + ", closeCameraDeviceOnClose=" + this.closeCameraDeviceOnClose + ", enableRestartDelays=" + this.enableRestartDelays + ')';
        }

        public Flags(boolean z10, boolean z11, RepeatingRequestRequirementsBeforeCapture awaitRepeatingRequestBeforeCapture, Boolean bool, int i10, boolean z12, boolean z13, boolean z14) {
            kotlin.jvm.internal.p.i(awaitRepeatingRequestBeforeCapture, "awaitRepeatingRequestBeforeCapture");
            this.configureBlankSessionOnStop = z10;
            this.abortCapturesOnStop = z11;
            this.awaitRepeatingRequestBeforeCapture = awaitRepeatingRequestBeforeCapture;
            this.awaitRepeatingRequestOnDisconnect = bool;
            this.finalizeSessionOnCloseBehavior = i10;
            this.closeCaptureSessionOnDisconnect = z12;
            this.closeCameraDeviceOnClose = z13;
            this.enableRestartDelays = z14;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Flags(boolean z10, boolean z11, RepeatingRequestRequirementsBeforeCapture repeatingRequestRequirementsBeforeCapture, Boolean bool, int i10, boolean z12, boolean z13, boolean z14, int i11, kotlin.jvm.internal.i iVar) {
            this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? new RepeatingRequestRequirementsBeforeCapture(0, null, 3, 0 == true ? 1 : 0) : repeatingRequestRequirementsBeforeCapture, (i11 & 8) != 0 ? null : bool, (i11 & 16) != 0 ? a.INSTANCE.b() : i10, (i11 & 32) != 0 ? C5810d0.INSTANCE.a() : z12, (i11 & 64) != 0 ? false : z13, (i11 & 128) != 0 ? false : z14, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$e;", "", "", "mode", "e", "(I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final int f10170b = e(0);

        /* renamed from: c, reason: collision with root package name */
        public static final int f10171c = e(1);

        /* renamed from: d, reason: collision with root package name */
        public static final int f10172d = e(2);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$e$a;", "", "<init>", "()V", "", "mode", "Landroidx/camera/camera2/pipe/CameraGraph$e;", Const.INTENT_KEY_APIKEY, "(I)I", "NORMAL", "I", Const.INTENT_KEY_UMID, "()I", "HIGH_SPEED", "c", "EXTENSION", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.CameraGraph$e$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final int a(int mode) {
                if (mode != d() && mode != c()) {
                    return e.e(mode);
                }
                if (z.k.f44508a.b()) {
                    Log.e("CXCP", "Custom operating mode " + mode + " conflicts with standard modes");
                }
                throw new IllegalArgumentException(Y8.t.f7040a.toString());
            }

            public final int b() {
                return e.f10172d;
            }

            public final int c() {
                return e.f10171c;
            }

            public final int d() {
                return e.f10170b;
            }

            public Companion() {
            }
        }

        public static int e(int i10) {
            return i10;
        }

        public static final boolean f(int i10, int i11) {
            return i10 == i11;
        }

        public static int g(int i10) {
            return Integer.hashCode(i10);
        }

        public static String h(int i10) {
            return "OperatingMode(mode=" + i10 + ')';
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\r\u0010\u000eJî\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020%H¦@¢\u0006\u0004\b*\u0010+Jf\u00101\u001a\b\u0012\u0004\u0012\u00020)0(2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010 2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u00100\u001a\u00020%H¦@¢\u0006\u0004\b1\u00102J>\u00105\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u00100\u001a\u00020%H¦@¢\u0006\u0004\b5\u00106J \u00108\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u00107\u001a\u00020 H¦@¢\u0006\u0004\b8\u00109ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006:À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$f;", "Lw/j;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroidx/camera/camera2/pipe/t;", "request", "LY8/t;", "i0", "(Landroidx/camera/camera2/pipe/t;)V", "stopRepeating", "()V", "", "requests", "o", "(Ljava/util/List;)V", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "Lw/F;", "aeLockBehavior", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "Lkotlin/Function1;", "Lw/x;", "", "convergedCondition", "lockedCondition", "", "frameLimit", "", "convergedTimeLimitNs", "lockedTimeLimitNs", "LUa/Q;", "Lw/N;", "L0", "(Lw/a;Lw/b;Lw/c;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lw/F;Lw/F;Lw/F;Lw/a;Lp9/l;Lp9/l;IJJLe9/c;)Ljava/lang/Object;", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "v", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;IJLe9/c;)Ljava/lang/Object;", "triggerAf", "waitForAwb", "i1", "(ZZIJLe9/c;)Ljava/lang/Object;", "cancelAf", "J0", "(ZLe9/c;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface f extends InterfaceC5704j, AutoCloseable {
        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Object Q0(f fVar, Boolean bool, Boolean bool2, Boolean bool3, InterfaceC5074l interfaceC5074l, int i10, long j10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock3A");
            }
            if ((i11 & 1) != 0) {
                bool = null;
            }
            if ((i11 & 2) != 0) {
                bool2 = null;
            }
            if ((i11 & 4) != 0) {
                bool3 = null;
            }
            if ((i11 & 8) != 0) {
                interfaceC5074l = null;
            }
            if ((i11 & 16) != 0) {
                i10 = 60;
            }
            if ((i11 & 32) != 0) {
                j10 = 3000000000L;
            }
            return fVar.v(bool, bool2, bool3, interfaceC5074l, i10, j10, interfaceC4014c);
        }

        static /* synthetic */ Object j0(f fVar, C5695a c5695a, C5696b c5696b, C5697c c5697c, List list, List list2, List list3, C5694F c5694f, C5694F c5694f2, C5694F c5694f3, C5695a c5695a2, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i10, long j10, long j11, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
            long j12;
            f fVar2;
            InterfaceC4014c interfaceC4014c2;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3A--tS25XM");
            }
            C5695a c5695a3 = (i11 & 1) != 0 ? null : c5695a;
            C5696b c5696b2 = (i11 & 2) != 0 ? null : c5696b;
            C5697c c5697c2 = (i11 & 4) != 0 ? null : c5697c;
            List list4 = (i11 & 8) != 0 ? null : list;
            List list5 = (i11 & 16) != 0 ? null : list2;
            List list6 = (i11 & 32) != 0 ? null : list3;
            C5694F c5694f4 = (i11 & 64) != 0 ? null : c5694f;
            C5694F c5694f5 = (i11 & 128) != 0 ? null : c5694f2;
            C5694F c5694f6 = (i11 & 256) != 0 ? null : c5694f3;
            C5695a c5695a4 = (i11 & 512) != 0 ? null : c5695a2;
            InterfaceC5074l interfaceC5074l3 = (i11 & 1024) != 0 ? null : interfaceC5074l;
            InterfaceC5074l interfaceC5074l4 = (i11 & 2048) != 0 ? null : interfaceC5074l2;
            int i12 = (i11 & 4096) != 0 ? 60 : i10;
            long j13 = (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 3000000000L : j10;
            if ((i11 & 16384) != 0) {
                j12 = 3000000000L;
                interfaceC4014c2 = interfaceC4014c;
                fVar2 = fVar;
            } else {
                j12 = j11;
                fVar2 = fVar;
                interfaceC4014c2 = interfaceC4014c;
            }
            return fVar2.L0(c5695a3, c5696b2, c5697c2, list4, list5, list6, c5694f4, c5694f5, c5694f6, c5695a4, interfaceC5074l3, interfaceC5074l4, i12, j13, j12, interfaceC4014c2);
        }

        static /* synthetic */ Object t(f fVar, boolean z10, boolean z11, int i10, long j10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3AForCapture");
            }
            if ((i11 & 1) != 0) {
                z10 = true;
            }
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                i10 = 60;
            }
            if ((i11 & 8) != 0) {
                j10 = 3000000000L;
            }
            int i12 = i10;
            return fVar.i1(z10, z11, i12, j10, interfaceC4014c);
        }

        Object J0(boolean z10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c);

        Object L0(C5695a c5695a, C5696b c5696b, C5697c c5697c, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, C5694F c5694f, C5694F c5694f2, C5694F c5694f3, C5695a c5695a2, InterfaceC5074l<? super x, Boolean> interfaceC5074l, InterfaceC5074l<? super x, Boolean> interfaceC5074l2, int i10, long j10, long j11, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c);

        void i0(t request);

        Object i1(boolean z10, boolean z11, int i10, long j10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c);

        void o(List<t> requests);

        void stopRepeating();

        Object v(Boolean bool, Boolean bool2, Boolean bool3, InterfaceC5074l<? super x, Boolean> interfaceC5074l, int i10, long j10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c);
    }
}
