package androidx.camera.camera2.impl;

import D.B;
import D.C0761b0;
import K.InterfaceC0898v;
import K.V;
import K.z0;
import M.q;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.media.MediaCodec;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.camera2.impl.e;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.h;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.AwaitKt;
import o.C4961A;
import o.C4981m;
import o.Q;
import p9.InterfaceC5074l;
import s.UseCaseCameraConfig;
import s.v;
import t.C5473b;
import t.InterfaceC5494v;
import t.i0;
import t.j0;
import t.y0;
import u.C5556d;
import v.C5644a;

@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u007fB©\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0003¢\u0006\u0004\b)\u0010*J\u001d\u0010.\u001a\u00020(2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002¢\u0006\u0004\b.\u0010/J\u001d\u00101\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\b1\u0010/J\u000f\u00102\u001a\u00020(H\u0003¢\u0006\u0004\b2\u0010*J\u0017\u00105\u001a\u00020(2\u0006\u00104\u001a\u000203H\u0003¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020(2\u0006\u00104\u001a\u000203H\u0003¢\u0006\u0004\b7\u00106J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\b8\u00109J\u001d\u0010;\u001a\u00020:2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u00020:2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\b=\u0010<J\u0019\u0010?\u001a\u00020:*\b\u0012\u0004\u0012\u00020,0>H\u0002¢\u0006\u0004\b?\u0010@J\u001d\u0010A\u001a\u00020:2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\bA\u0010<J\u001d\u0010B\u001a\u00020:2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0003¢\u0006\u0004\bB\u0010<J\u000f\u0010C\u001a\u00020(H\u0003¢\u0006\u0004\bC\u0010*J\u000f\u0010D\u001a\u00020(H\u0003¢\u0006\u0004\bD\u0010*J\u0019\u0010E\u001a\u00020:*\b\u0012\u0004\u0012\u00020,0>H\u0002¢\u0006\u0004\bE\u0010@J\u000f\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bG\u0010HJ\u001d\u0010L\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0IH\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010N\u001a\b\u0012\u0004\u0012\u00020J0I*\b\u0012\u0004\u0012\u00020,0>H\u0002¢\u0006\u0004\bN\u0010OJ!\u0010R\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u00010P0P0I*\u00020,H\u0002¢\u0006\u0004\bR\u0010SJ\u0019\u0010T\u001a\u00020:*\b\u0012\u0004\u0012\u00020,0>H\u0002¢\u0006\u0004\bT\u0010@J\u001f\u0010V\u001a\b\u0012\u0004\u0012\u00020U0I*\b\u0012\u0004\u0012\u00020,0>H\u0002¢\u0006\u0004\bV\u0010OJ\u000f\u0010W\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020(H\u0002¢\u0006\u0004\bY\u0010*J\u0017\u0010[\u001a\u00020(2\u0006\u0010Z\u001a\u00020:H\u0000¢\u0006\u0004\b[\u0010\\J\u0011\u0010^\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0004\b^\u0010_J\u001b\u0010a\u001a\u00020(2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020,0I¢\u0006\u0004\ba\u0010bJ\u001b\u0010c\u001a\u00020(2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020,0I¢\u0006\u0004\bc\u0010bJ\u0015\u0010e\u001a\u00020(2\u0006\u0010d\u001a\u00020,¢\u0006\u0004\be\u0010fJ\u0015\u0010g\u001a\u00020(2\u0006\u0010d\u001a\u00020,¢\u0006\u0004\bg\u0010fJ\u0015\u0010h\u001a\u00020(2\u0006\u0010d\u001a\u00020,¢\u0006\u0004\bh\u0010fJ\u0015\u0010i\u001a\u00020(2\u0006\u0010d\u001a\u00020,¢\u0006\u0004\bi\u0010fJ\u0015\u0010k\u001a\u00020(2\u0006\u0010j\u001a\u00020:¢\u0006\u0004\bk\u0010\\J\u0017\u0010m\u001a\u0004\u0018\u00010(2\u0006\u0010l\u001a\u00020:¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020(H\u0086@¢\u0006\u0004\bo\u0010pJ\u000f\u0010r\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ)\u0010y\u001a\u0002032\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020v2\b\b\u0002\u0010x\u001a\u00020:H\u0001¢\u0006\u0004\by\u0010zJ\u0017\u0010}\u001a\u00020(2\u0006\u0010|\u001a\u00020{H\u0000¢\u0006\u0004\b}\u0010~R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0016\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010\u0089\u0001R\u0015\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b;\u0010\u008a\u0001R\u0015\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bC\u0010\u008b\u0001R\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\ba\u0010\u008c\u0001R\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b7\u0010\u008c\u0001R\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bo\u0010\u008c\u0001R\u0015\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b2\u0010\u008d\u0001R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0015\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bW\u0010\u0090\u0001R\u0015\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\by\u0010\u0091\u0001R\u0016\u0010\u0093\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010\u0092\u0001R8\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018@@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001d\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020,0\u009d\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bc\u0010\u0089\u0001R\u001d\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020,0\u009d\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bN\u0010\u0089\u0001R\u0019\u0010¢\u0001\u001a\u00020:8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0018\u0010£\u0001\u001a\u00020:8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bG\u0010¡\u0001R\u001a\u0010¥\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bR\u0010¤\u0001R\u0017\u0010j\u001a\u00020:8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b^\u0010¡\u0001R\u001d\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020,0\u009d\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bL\u0010\u0089\u0001R\u0017\u0010©\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b8\u0010¨\u0001R\u0018\u0010¬\u0001\u001a\u00030ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010«\u0001R\u0017\u0010¯\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bV\u0010®\u0001R#\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020{0°\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bE\u0010±\u0001R\u001b\u0010µ\u0001\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b=\u0010´\u0001R\u001e\u0010¹\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010¶\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bT\u0010¸\u0001R%\u0010º\u0001\u001a\u0011\u0012\f\u0012\n Q*\u0004\u0018\u00010\r0\r0\u009d\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b1\u0010\u0089\u0001R\u0017\u0010½\u0001\u001a\u0005\u0018\u00010»\u00018F¢\u0006\b\u001a\u0006\b \u0001\u0010¼\u0001¨\u0006¾\u0001"}, d2 = {"Landroidx/camera/camera2/impl/g;", "", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "LE/a;", "cameraCoordinator", "Ls/v$a;", "builder", "Lo/Q;", "zslControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "lowLightBoostControl", "Ljava/util/Set;", "Lt/j0;", "controls", "Lv/a;", "camera2CameraControl", "Lo/m;", "cameraStateAdapter", "LX8/a;", "Landroidx/camera/core/impl/CameraInternal;", "cameraInternal", "Lt/y0;", "useCaseThreads", "LK/v;", "cameraInfoInternal", "LK/V;", "encoderProfilesProvider", "Lt/v;", "cameraProperties", "Landroidx/camera/core/f;", "cameraXConfig", "Landroidx/camera/camera2/impl/c;", "cameraGraphConfigProvider", "Landroid/content/Context;", "context", "Lt/Q;", "displayInfoManager", "<init>", "(Landroidx/camera/camera2/pipe/h;LE/a;Ls/v$a;Lo/Q;Landroidx/camera/camera2/impl/LowLightBoostControl;Ljava/util/Set;Lv/a;Lo/m;LX8/a;LX8/a;LX8/a;LK/V;Lt/v;Landroidx/camera/core/f;Landroidx/camera/camera2/impl/c;Landroid/content/Context;Lt/Q;)V", "LY8/t;", "F", "()V", "", "Landroidx/camera/core/UseCase;", "runningUseCases", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/util/Set;)V", "newUseCases", ExifInterface.LONGITUDE_EAST, "l", "Ls/z;", "useCaseCameraConfig", "R", "(Ls/z;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "y", "()Ljava/util/Set;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Set;)Z", "C", "", "P", "(Ljava/util/Collection;)Z", "O", "Q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "G", "B", "", "u", "()I", "", "Landroidx/camera/core/impl/b;", "attachedSurfaceInfoList", "x", "(Ljava/util/List;)I", "s", "(Ljava/util/Collection;)Ljava/util/List;", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "kotlin.jvm.PlatformType", "v", "(Landroidx/camera/core/UseCase;)Ljava/util/List;", "D", "Landroidx/camera/core/impl/SurfaceConfig;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "n", "()Landroidx/camera/core/impl/SurfaceConfig;", "U", "createImmediately", "L", "(Z)V", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "w", "()Landroidx/camera/camera2/pipe/CameraGraph$b;", "useCases", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)V", "r", "useCase", "f", "(Landroidx/camera/core/UseCase;)V", "p", ExifInterface.LATITUDE_SOUTH, "H", "isPrimary", "M", x5.d.EXTRA_ENABLED, "K", "(Z)LY8/t;", "k", "(Le9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter", "Lo/A;", "graphStateToCameraStateAdapter", "isExtensions", "o", "(Landroidx/camera/camera2/adapter/SessionConfigAdapter;Lo/A;Z)Ls/z;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "I", "(Landroidx/camera/camera2/pipe/CameraGraph;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/h;", Const.INTENT_KEY_PKGNAME, "LE/a;", "c", "Ls/v$a;", Const.INTENT_KEY_UMID, "Lo/Q;", "e", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "Ljava/util/Set;", "Lv/a;", "Lo/m;", "LX8/a;", "LK/V;", "m", "Lt/v;", "Landroidx/camera/core/f;", "Landroidx/camera/camera2/impl/c;", "Ljava/lang/Object;", "lock", "LK/z0;", UxipConstants.f30680s, "q", "LK/z0;", "z", "()LK/z0;", "N", "(LK/z0;)V", "sessionProcessor", "", "attachedUseCases", "activeUseCases", "t", "Z", "activeResumeEnabled", "shouldCreateCameraGraphImmediately", "Ls/z;", "deferredUseCaseCameraConfig", "pendingUseCasesToNotifyCameraControlReady", "Landroidx/camera/camera2/impl/e;", "Landroidx/camera/camera2/impl/e;", "meteringRepeating", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", "supportedSurfaceCombination", "Lu/d;", "Lu/d;", "dynamicRangeResolver", "Lkotlin/Function1;", "Lp9/l;", "defaultCameraGraphFactory", "Ls/v;", "Ls/v;", "_activeComponent", "", "Lkotlinx/coroutines/g;", "Ljava/util/List;", "closingCameraJobs", "allControls", "Lt/i0;", "()Lt/i0;", C3081a.CAMERA_FOCUS, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final C5556d dynamicRangeResolver;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<CameraGraph.b, CameraGraph> defaultCameraGraphFactory;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public volatile v _activeComponent;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public final List<kotlinx.coroutines.g> closingCameraJobs;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public final Set<j0> allControls;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h cameraPipe;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final E.a cameraCoordinator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final v.a builder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Q zslControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final LowLightBoostControl lowLightBoostControl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Set<j0> controls;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final C5644a camera2CameraControl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final C4981m cameraStateAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final X8.a<CameraInternal> cameraInternal;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final X8.a<y0> useCaseThreads;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final X8.a<InterfaceC0898v> cameraInfoInternal;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final V encoderProfilesProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.core.f cameraXConfig;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final c cameraGraphConfigProvider;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public z0 sessionProcessor;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final Set<UseCase> attachedUseCases;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Set<UseCase> activeUseCases;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public boolean activeResumeEnabled;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public boolean shouldCreateCameraGraphImmediately;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraConfig deferredUseCaseCameraConfig;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public boolean isPrimary;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final Set<UseCase> pendingUseCasesToNotifyCameraControlReady;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final e meteringRepeating;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final SupportedSurfaceCombination supportedSurfaceCombination;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/impl/g$a;", "", "", "Landroidx/camera/core/UseCase;", "runningUseCases", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(Set<? extends UseCase> runningUseCases);
    }

    public g(h cameraPipe, E.a cameraCoordinator, v.a builder, Q zslControl, LowLightBoostControl lowLightBoostControl, Set<j0> controls, C5644a camera2CameraControl, C4981m cameraStateAdapter, X8.a<CameraInternal> cameraInternal, X8.a<y0> useCaseThreads, X8.a<InterfaceC0898v> cameraInfoInternal, V encoderProfilesProvider, InterfaceC5494v cameraProperties, androidx.camera.core.f cameraXConfig, c cameraGraphConfigProvider, Context context, t.Q displayInfoManager) {
        p.i(cameraPipe, "cameraPipe");
        p.i(cameraCoordinator, "cameraCoordinator");
        p.i(builder, "builder");
        p.i(zslControl, "zslControl");
        p.i(lowLightBoostControl, "lowLightBoostControl");
        p.i(controls, "controls");
        p.i(camera2CameraControl, "camera2CameraControl");
        p.i(cameraStateAdapter, "cameraStateAdapter");
        p.i(cameraInternal, "cameraInternal");
        p.i(useCaseThreads, "useCaseThreads");
        p.i(cameraInfoInternal, "cameraInfoInternal");
        p.i(encoderProfilesProvider, "encoderProfilesProvider");
        p.i(cameraProperties, "cameraProperties");
        p.i(cameraXConfig, "cameraXConfig");
        p.i(cameraGraphConfigProvider, "cameraGraphConfigProvider");
        p.i(context, "context");
        p.i(displayInfoManager, "displayInfoManager");
        this.cameraPipe = cameraPipe;
        this.cameraCoordinator = cameraCoordinator;
        this.builder = builder;
        this.zslControl = zslControl;
        this.lowLightBoostControl = lowLightBoostControl;
        this.controls = controls;
        this.camera2CameraControl = camera2CameraControl;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraInternal = cameraInternal;
        this.useCaseThreads = useCaseThreads;
        this.cameraInfoInternal = cameraInfoInternal;
        this.encoderProfilesProvider = encoderProfilesProvider;
        this.cameraProperties = cameraProperties;
        this.cameraXConfig = cameraXConfig;
        this.cameraGraphConfigProvider = cameraGraphConfigProvider;
        this.lock = new Object();
        this.attachedUseCases = new LinkedHashSet();
        this.activeUseCases = new LinkedHashSet();
        this.shouldCreateCameraGraphImmediately = true;
        this.isPrimary = true;
        this.pendingUseCasesToNotifyCameraControlReady = new LinkedHashSet();
        this.meteringRepeating = new e.a(cameraProperties, displayInfoManager).b();
        this.supportedSurfaceCombination = new SupportedSurfaceCombination(context, cameraProperties.getMetadata(), encoderProfilesProvider, androidx.camera.core.featuregroup.impl.a.f11304b);
        this.dynamicRangeResolver = new C5556d(cameraProperties.getMetadata());
        this.defaultCameraGraphFactory = new InterfaceC5074l() { // from class: t.u0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return androidx.camera.camera2.impl.g.q(this.f41956a, (CameraGraph.b) obj);
            }
        };
        this.closingCameraJobs = new ArrayList();
        Set<j0> setQ1 = F.q1(controls);
        setQ1.add(camera2CameraControl);
        this.allControls = setQ1;
    }

    public static final CameraGraph J(CameraGraph cameraGraph, CameraGraph.b bVar) {
        p.i(bVar, "<unused var>");
        return cameraGraph;
    }

    public static final t m(g gVar, kotlinx.coroutines.g gVar2, Throwable th) {
        synchronized (gVar.lock) {
            gVar.closingCameraJobs.remove(gVar2);
        }
        return t.f7040a;
    }

    public static final CameraGraph q(g gVar, CameraGraph.b config) {
        p.i(config, "config");
        return gVar.cameraPipe.d(config);
    }

    public final List<SurfaceConfig> A(Collection<? extends UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            List<DeferrableSurface> listP = useCase.z().p();
            p.h(listP, "getSurfaces(...)");
            for (DeferrableSurface deferrableSurface : listP) {
                SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
                int iU = u();
                int iO = useCase.l().o();
                Size sizeH = deferrableSurface.h();
                p.h(sizeH, "getPrescribedSize(...)");
                StreamUseCase streamUseCaseU = useCase.l().U();
                p.h(streamUseCaseU, "getStreamUseCase(...)");
                arrayList.add(supportedSurfaceCombination.m0(iU, iO, sizeH, streamUseCaseU));
            }
        }
        return arrayList;
    }

    public final boolean B(Collection<? extends UseCase> collection) {
        if (this.meteringRepeating.h() == null) {
            this.meteringRepeating.p0();
        }
        List<androidx.camera.core.impl.b> listS = s(collection);
        if (listS.isEmpty()) {
            return false;
        }
        List<SurfaceConfig> listA = A(collection);
        SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
        SupportedSurfaceCombination.FeatureSettings featureSettings = new SupportedSurfaceCombination.FeatureSettings(u(), x(listS), q.b(collection), q.e(collection, null, 1, null), D(collection), false, false, false, null, false, 992, null);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listA);
        arrayList.add(n());
        t tVar = t.f7040a;
        boolean zG = SupportedSurfaceCombination.g(supportedSurfaceCombination, featureSettings, arrayList, null, null, null, 28, null);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Combination of " + listA + " + " + this.meteringRepeating + " is supported: " + zG);
        }
        return zG;
    }

    public final boolean C(Set<? extends UseCase> runningUseCases) {
        if (!this.cameraXConfig.q0()) {
            return false;
        }
        Set<? extends UseCase> set = runningUseCases;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UseCase useCase = (UseCase) it.next();
                if (!p.d(useCase, this.meteringRepeating)) {
                    List<DeferrableSurface> listP = useCase.z().p();
                    p.h(listP, "getSurfaces(...)");
                    if (!listP.isEmpty()) {
                        Set<UseCase> set2 = this.attachedUseCases;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : set2) {
                            if (!p.d((UseCase) obj, this.meteringRepeating)) {
                                arrayList.add(obj);
                            }
                        }
                        if (!arrayList.isEmpty() && P(arrayList) && B(arrayList)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean D(Collection<? extends UseCase> collection) {
        z<?> zVarL;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj instanceof ImageCapture) {
                arrayList.add(obj);
            }
        }
        ImageCapture imageCapture = (ImageCapture) F.s0(arrayList);
        return (imageCapture == null || (zVarL = imageCapture.l()) == null || zVarL.o() != 4101) ? false : true;
    }

    public final void E(Set<? extends UseCase> newUseCases) {
        Pair<Integer, Integer> pairF;
        Integer num;
        l();
        List listM1 = F.m1(newUseCases);
        if (listM1.isEmpty()) {
            for (j0 j0Var : this.allControls) {
                j0Var.b(null);
                j0Var.reset();
            }
            return;
        }
        if (!this.shouldCreateCameraGraphImmediately) {
            Iterator<j0> it = this.allControls.iterator();
            while (it.hasNext()) {
                it.next().b(null);
            }
        }
        C4961A c4961a = new C4961A(this.cameraStateAdapter);
        z0 z0VarZ = z();
        boolean z10 = false;
        if (z0VarZ != null && (pairF = z0VarZ.f()) != null && (num = (Integer) pairF.first) != null && num.intValue() == 1) {
            z10 = true;
        }
        SessionConfigAdapter sessionConfigAdapter = new SessionConfigAdapter(listM1, this.isPrimary);
        if (z10) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Setting up UseCaseManager with OperatingMode.EXTENSION");
            }
            z0 z0VarZ2 = z();
            p.f(z0VarZ2);
            z0VarZ2.b(this.cameraInfoInternal.get(), null);
        }
        R(o(sessionConfigAdapter, c4961a, z10));
    }

    public final void F() {
        if (this.attachedUseCases.isEmpty()) {
            return;
        }
        Set<UseCase> setY = y();
        if (O(setY)) {
            h();
        } else if (Q(setY)) {
            G();
        } else {
            T(setY);
        }
    }

    public final void G() {
        p(this.meteringRepeating);
        r(C1172u.e(this.meteringRepeating));
        this.meteringRepeating.d0(this.cameraInternal.get());
    }

    public final void H(UseCase useCase) {
        p.i(useCase, "useCase");
        synchronized (this.lock) {
            try {
                if (this.attachedUseCases.contains(useCase)) {
                    E(this.attachedUseCases);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void I(final CameraGraph cameraGraph) {
        p.i(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            UseCaseCameraConfig useCaseCameraConfig = this.deferredUseCaseCameraConfig;
            if (useCaseCameraConfig == null) {
                throw new IllegalStateException("Required value was null.");
            }
            j(UseCaseCameraConfig.d(useCaseCameraConfig, new InterfaceC5074l() { // from class: t.t0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return androidx.camera.camera2.impl.g.J(cameraGraph, (CameraGraph.b) obj);
                }
            }, null, null, null, null, 30, null));
            t tVar = t.f7040a;
        }
    }

    public final t K(boolean enabled) {
        t tVar;
        synchronized (this.lock) {
            this.activeResumeEnabled = enabled;
            i0 i0VarT = t();
            if (i0VarT != null) {
                i0VarT.d(enabled);
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
        }
        return tVar;
    }

    public final void L(boolean createImmediately) {
        synchronized (this.lock) {
            try {
                this.shouldCreateCameraGraphImmediately = createImmediately;
                if (createImmediately) {
                    this.deferredUseCaseCameraConfig = null;
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void M(boolean isPrimary) {
        synchronized (this.lock) {
            this.isPrimary = isPrimary;
            t tVar = t.f7040a;
        }
    }

    public final void N(z0 z0Var) {
        synchronized (this.lock) {
            this.sessionProcessor = z0Var;
            t tVar = t.f7040a;
        }
    }

    public final boolean O(Set<? extends UseCase> runningUseCases) {
        return this.cameraXConfig.q0() && !this.attachedUseCases.contains(this.meteringRepeating) && C(runningUseCases);
    }

    public final boolean P(Collection<? extends UseCase> collection) {
        boolean z10;
        if (collection.isEmpty()) {
            return false;
        }
        SessionConfig.g gVar = new SessionConfig.g();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            gVar.b(((UseCase) it.next()).z());
        }
        SessionConfig sessionConfigC = gVar.c();
        p.h(sessionConfigC, "build(...)");
        List<DeferrableSurface> listH = sessionConfigC.l().h();
        p.h(listH, "getSurfaces(...)");
        List<DeferrableSurface> listP = sessionConfigC.p();
        p.h(listP, "getSurfaces(...)");
        if (listP.isEmpty()) {
            return false;
        }
        List<DeferrableSurface> list = listP;
        if ((list instanceof Collection) && list.isEmpty()) {
            z10 = true;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!p.d(((DeferrableSurface) it2.next()).g(), MediaCodec.class)) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
        }
        return z10 || listH.isEmpty();
    }

    public final boolean Q(Set<? extends UseCase> runningUseCases) {
        return runningUseCases.contains(this.meteringRepeating) && !C(runningUseCases);
    }

    public final void R(UseCaseCameraConfig useCaseCameraConfig) {
        if (this.shouldCreateCameraGraphImmediately) {
            j(useCaseCameraConfig);
        } else {
            this.deferredUseCaseCameraConfig = useCaseCameraConfig;
            this.cameraCoordinator.c(this.cameraInfoInternal.get());
        }
    }

    public final void S(UseCase useCase) {
        p.i(useCase, "useCase");
        synchronized (this.lock) {
            try {
                if (this.attachedUseCases.contains(useCase)) {
                    F();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void T(Set<? extends UseCase> runningUseCases) {
        i0 i0VarT = t();
        if (i0VarT != null) {
            i0VarT.b(this.isPrimary, runningUseCases);
            for (j0 j0Var : this.allControls) {
                if (j0Var instanceof a) {
                    ((a) j0Var).a(runningUseCases);
                }
            }
        }
    }

    public final void U() {
        Set<UseCase> set = this.attachedUseCases;
        boolean z10 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((UseCase) it.next()).l().Q(false)) {
                    z10 = true;
                    break;
                }
            }
        }
        this.zslControl.e(z10);
    }

    public final void f(UseCase useCase) {
        p.i(useCase, "useCase");
        synchronized (this.lock) {
            try {
                if (this.activeUseCases.add(useCase)) {
                    F();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g(Set<? extends UseCase> runningUseCases) {
        if (O(runningUseCases)) {
            h();
            return true;
        }
        if (!Q(runningUseCases)) {
            return false;
        }
        G();
        return true;
    }

    public final void h() {
        this.meteringRepeating.d(this.cameraInternal.get(), null, null, null);
        this.meteringRepeating.p0();
        i(C1172u.e(this.meteringRepeating));
        f(this.meteringRepeating);
    }

    public final void i(List<? extends UseCase> useCases) {
        p.i(useCases, "useCases");
        synchronized (this.lock) {
            if (useCases.isEmpty()) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Attach [] from " + this + " (Ignored)");
                }
                return;
            }
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Attaching " + useCases + " from " + this);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : useCases) {
                if (!this.attachedUseCases.contains((UseCase) obj)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((UseCase) it.next()).R();
            }
            if (this.attachedUseCases.addAll(useCases) && !g(y())) {
                U();
                this.lowLightBoostControl.q(F.m1(this.attachedUseCases));
                E(this.attachedUseCases);
            }
            if (this.shouldCreateCameraGraphImmediately) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((UseCase) it2.next()).O();
                }
            } else {
                this.pendingUseCasesToNotifyCameraControlReady.addAll(arrayList);
            }
            t tVar = t.f7040a;
        }
    }

    public final void j(UseCaseCameraConfig useCaseCameraConfig) {
        this._activeComponent = this.builder.a(useCaseCameraConfig).build();
        i0 i0VarT = t();
        if (i0VarT == null) {
            throw new IllegalStateException("Required value was null.");
        }
        i0VarT.start();
        Iterator<j0> it = this.allControls.iterator();
        while (it.hasNext()) {
            it.next().b(i0VarT.getRequestControl());
        }
        i0VarT.d(this.activeResumeEnabled);
        T(y());
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Notifying " + this.pendingUseCasesToNotifyCameraControlReady + " camera control ready");
        }
        Iterator<UseCase> it2 = this.pendingUseCasesToNotifyCameraControlReady.iterator();
        while (it2.hasNext()) {
            it2.next().O();
        }
        this.pendingUseCasesToNotifyCameraControlReady.clear();
    }

    public final Object k(InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        List listM1;
        synchronized (this.lock) {
            l();
            this.meteringRepeating.V();
            listM1 = F.m1(this.closingCameraJobs);
        }
        Object objB = AwaitKt.b(listM1, interfaceC4014c);
        return objB == C4063a.g() ? objB : t.f7040a;
    }

    public final void l() {
        final kotlinx.coroutines.g gVarClose;
        i0 i0VarT = t();
        this._activeComponent = null;
        this.cameraCoordinator.d(this.cameraInfoInternal.get());
        if (i0VarT != null && (gVarClose = i0VarT.close()) != null) {
            this.closingCameraJobs.add(gVarClose);
            gVarClose.J(new InterfaceC5074l() { // from class: t.s0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return androidx.camera.camera2.impl.g.m(this.f41950a, gVarClose, (Throwable) obj);
                }
            });
        }
        z0 z0VarZ = z();
        if (z0VarZ != null) {
            z0VarZ.a();
        }
    }

    public final SurfaceConfig n() {
        SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
        int iU = u();
        int iP = this.meteringRepeating.p();
        Size sizeH = this.meteringRepeating.h();
        p.f(sizeH);
        StreamUseCase streamUseCaseU = this.meteringRepeating.l().U();
        p.h(streamUseCaseU, "getStreamUseCase(...)");
        return supportedSurfaceCombination.m0(iU, iP, sizeH, streamUseCaseU);
    }

    public final UseCaseCameraConfig o(SessionConfigAdapter sessionConfigAdapter, C4961A graphStateToCameraStateAdapter, boolean isExtensions) {
        p.i(sessionConfigAdapter, "sessionConfigAdapter");
        p.i(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        return UseCaseCameraConfig.INSTANCE.b(sessionConfigAdapter, this.cameraGraphConfigProvider, this.defaultCameraGraphFactory, graphStateToCameraStateAdapter, z(), isExtensions);
    }

    public final void p(UseCase useCase) {
        p.i(useCase, "useCase");
        synchronized (this.lock) {
            try {
                if (this.activeUseCases.remove(useCase)) {
                    F();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r(List<? extends UseCase> useCases) {
        p.i(useCases, "useCases");
        synchronized (this.lock) {
            if (useCases.isEmpty()) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Detaching [] from " + this + " (Ignored)");
                }
                return;
            }
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Detaching " + useCases + " from " + this);
            }
            this.activeUseCases.removeAll(useCases);
            for (UseCase useCase : useCases) {
                if (this.attachedUseCases.contains(useCase)) {
                    useCase.S();
                }
            }
            if (this.attachedUseCases.removeAll(useCases)) {
                if (g(y())) {
                    return;
                }
                if (this.attachedUseCases.isEmpty()) {
                    this.zslControl.e(false);
                    this.lowLightBoostControl.q(C1173v.m());
                } else {
                    U();
                    this.lowLightBoostControl.q(F.m1(this.attachedUseCases));
                }
                E(this.attachedUseCases);
            }
            this.pendingUseCasesToNotifyCameraControlReady.removeAll(useCases);
            t tVar = t.f7040a;
        }
    }

    public final List<androidx.camera.core.impl.b> s(Collection<? extends UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            Size sizeH = useCase.h();
            y yVarG = useCase.g();
            if (sizeH == null || yVarG == null) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Invalid surface resolution or stream spec is found.");
                }
                arrayList.clear();
                return arrayList;
            }
            SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
            int iU = u();
            int iO = useCase.l().o();
            StreamUseCase streamUseCaseU = useCase.l().U();
            p.h(streamUseCaseU, "getStreamUseCase(...)");
            SurfaceConfig surfaceConfigM0 = supportedSurfaceCombination.m0(iU, iO, sizeH, streamUseCaseU);
            int iO2 = useCase.l().o();
            B b10 = yVarG.b();
            List<UseCaseConfigFactory.CaptureType> listV = v(useCase);
            Config configD = yVarG.d();
            if (configD == null) {
                configD = u.k0();
                p.h(configD, "create(...)");
            }
            androidx.camera.core.impl.b bVarA = androidx.camera.core.impl.b.a(surfaceConfigM0, iO2, sizeH, b10, listV, configD, yVarG.g(), yVarG.c(), useCase.l().G(), useCase.l().W(sizeH));
            p.h(bVarA, "create(...)");
            arrayList.add(bVarA);
        }
        return arrayList;
    }

    public final i0 t() {
        v vVar = this._activeComponent;
        if (vVar != null) {
            return vVar.a();
        }
        return null;
    }

    public String toString() {
        return "UseCaseManager<" + this.cameraGraphConfigProvider + '>';
    }

    public final int u() {
        synchronized (this.lock) {
            if (this.cameraCoordinator.e() == 2) {
                return 1;
            }
            t tVar = t.f7040a;
            return 0;
        }
    }

    public final List<UseCaseConfigFactory.CaptureType> v(UseCase useCase) {
        if (!(useCase instanceof Y.f)) {
            return C1172u.e(useCase.l().V());
        }
        z<?> zVarL = ((Y.f) useCase).l();
        p.g(zVarL, "null cannot be cast to non-null type androidx.camera.core.streamsharing.StreamSharingConfig");
        List<UseCaseConfigFactory.CaptureType> listH0 = ((Y.h) zVarL).h0();
        p.f(listH0);
        return listH0;
    }

    public final CameraGraph.b w() {
        CameraGraph.b bVarE;
        synchronized (this.lock) {
            UseCaseCameraConfig useCaseCameraConfig = this.deferredUseCaseCameraConfig;
            bVarE = useCaseCameraConfig != null ? useCaseCameraConfig.e() : null;
        }
        return bVarE;
    }

    public final int x(List<? extends androidx.camera.core.impl.b> attachedSurfaceInfoList) {
        Iterator<Map.Entry<z<?>, B>> it = this.dynamicRangeResolver.g(attachedSurfaceInfoList, C1172u.e(this.meteringRepeating.l()), C1172u.e(0)).entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().a() == 10) {
                return 10;
            }
        }
        return 8;
    }

    public final Set<UseCase> y() {
        return F.w0(this.attachedUseCases, this.activeUseCases);
    }

    public final z0 z() {
        z0 z0Var;
        synchronized (this.lock) {
            z0Var = this.sessionProcessor;
        }
        return z0Var;
    }
}
