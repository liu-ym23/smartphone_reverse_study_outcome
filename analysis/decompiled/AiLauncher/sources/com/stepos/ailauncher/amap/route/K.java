package com.stepos.ailauncher.amap.route;

import Z8.C1173v;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.K;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.common.memory.d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005*\u0001w\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001zB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u001dJ\u001f\u0010&\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u001dJ\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001eH\u0002¢\u0006\u0004\b*\u0010!J'\u0010-\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001eH\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b/\u0010!J\u001f\u00100\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b0\u0010!J\u001f\u00101\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b1\u0010!J!\u00103\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u0003J\u0017\u00106\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u0010\u001dJ\u000f\u00107\u001a\u00020\u000fH\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u000fH\u0002¢\u0006\u0004\b8\u0010\u0003J\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u000fH\u0002¢\u0006\u0004\b=\u0010\u0003J\u0017\u0010?\u001a\u0004\u0018\u00010\b2\u0006\u0010>\u001a\u00020\u0013¢\u0006\u0004\b?\u0010@J1\u0010F\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010B\u001a\u00020A2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u000f0C¢\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bL\u0010KJ\u0015\u0010M\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bM\u0010IJ\u0015\u0010N\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bN\u0010IJ\u0015\u0010O\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bO\u0010IJ\u001d\u0010Q\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010P\u001a\u00020:¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\bS\u0010IJ\r\u0010T\u001a\u00020:¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020:¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u001e¢\u0006\u0004\bY\u0010ZJ\u0015\u0010[\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b[\u0010KJ\u0017\u0010\\\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\\\u0010IR\u0014\u0010]\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010^R\u0014\u0010`\u001a\u00020:8\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010YR\u0014\u0010b\u001a\u00020a8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010=R\u0014\u0010c\u001a\u00020:8\u0002X\u0082T¢\u0006\u0006\n\u0004\bc\u0010YR\u0014\u0010d\u001a\u00020a8\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010=R\u0014\u0010e\u001a\u00020a8\u0002X\u0082T¢\u0006\u0006\n\u0004\be\u0010=R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00040f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010NR\u0016\u0010o\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010YR\u0016\u0010p\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010YR\u0016\u0010q\u001a\u00020a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010=R\u0016\u0010r\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010YR\u0014\u0010s\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR \u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006{"}, d2 = {"Lcom/stepos/ailauncher/amap/route/K;", "", "<init>", "()V", "Lcom/stepos/ailauncher/amap/route/K$a;", "entry", "", "wasSoft", "Lcom/amap/api/maps/MapView;", "n", "(Lcom/stepos/ailauncher/amap/route/K$a;Z)Lcom/amap/api/maps/MapView;", "m0", "()Z", "forceDeliver", "hideUntilReveal", "LY8/t;", "h0", "(Lcom/stepos/ailauncher/amap/route/K$a;ZZ)V", "g0", "Landroid/content/Context;", "ctx", "u", "(Landroid/content/Context;)Lcom/stepos/ailauncher/amap/route/K$a;", "L", "()Lcom/stepos/ailauncher/amap/route/K$a;", "mapView", "K", "(Lcom/amap/api/maps/MapView;)Lcom/stepos/ailauncher/amap/route/K$a;", "w", "(Lcom/stepos/ailauncher/amap/route/K$a;)V", "", "from", "R", "(Lcom/stepos/ailauncher/amap/route/K$a;Ljava/lang/String;)V", "f0", "t", "Ljava/lang/Runnable;", "canceller", "j0", "(Lcom/stepos/ailauncher/amap/route/K$a;Ljava/lang/Runnable;)V", "s", "msg", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "event", "detail", "U", "(Lcom/stepos/ailauncher/amap/route/K$a;Ljava/lang/String;Ljava/lang/String;)V", "H", "Y", "M", "clearDeliverCallback", "q", "(Lcom/stepos/ailauncher/amap/route/K$a;Z)V", "F", ExifInterface.LONGITUDE_EAST, "b0", "X", "mv", "", "P", "(Lcom/amap/api/maps/MapView;)I", "J", "context", "m", "(Landroid/content/Context;)Lcom/amap/api/maps/MapView;", "Landroid/widget/FrameLayout;", "slot", "Lkotlin/Function1;", "Lcom/amap/api/maps/AMap;", "onMapReady", "p", "(Lcom/amap/api/maps/MapView;Landroid/widget/FrameLayout;Lp9/l;)V", "G", "(Lcom/amap/api/maps/MapView;)V", "l0", "(Lcom/amap/api/maps/MapView;)Z", "k0", "c0", "Z", "d0", "insetPx", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/amap/api/maps/MapView;I)V", "a0", "o", "()I", "level", ExifInterface.LONGITUDE_WEST, "(I)V", "I", "()Ljava/lang/String;", "e0", "Q", "TAG", "Ljava/lang/String;", "JANK_TAG", "MAX_POOL_SIZE", "", "IDLE_DESTROY_DELAY_MS", "EDGE_BLEED_PX", "REVEAL_SETTLE_MS", "DARK_STYLE_TIMEOUT_MS", "", "entries", "Ljava/util/List;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "appContext", "Landroid/content/Context;", "trimCallbackRegistered", "createCount", "destroyCount", "lastJankEventElapsed", "attachSeq", "idleDestroyRunnable", "Ljava/lang/Runnable;", "foregroundListener", "Lp9/l;", "com/stepos/ailauncher/amap/route/K$b", "componentCallbacks", "Lcom/stepos/ailauncher/amap/route/K$b;", Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class K {
    private static final long DARK_STYLE_TIMEOUT_MS = 1200;
    private static final int EDGE_BLEED_PX = 2;
    private static final long IDLE_DESTROY_DELAY_MS = 30000;
    public static final K INSTANCE;
    private static final String JANK_TAG = "MapScrollJank";
    private static final int MAX_POOL_SIZE = 2;
    private static final long REVEAL_SETTLE_MS = 280;
    private static final String TAG = "MapViewPool";
    private static Context appContext;
    private static int attachSeq;
    private static final b componentCallbacks;
    private static int createCount;
    private static int destroyCount;
    private static final List<a> entries;
    private static final InterfaceC5074l<Boolean, Y8.t> foregroundListener;
    private static final Runnable idleDestroyRunnable;
    private static long lastJankEventElapsed;
    private static final Handler mainHandler;
    private static boolean trimCallbackRegistered;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002040;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010B\u001a\u0004\bO\u0010D\"\u0004\bP\u0010FR0\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020R\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Lcom/stepos/ailauncher/amap/route/K$a;", "", "Lcom/amap/api/maps/MapView;", "mapView", "<init>", "(Lcom/amap/api/maps/MapView;)V", "Lcom/amap/api/maps/MapView;", "f", "()Lcom/amap/api/maps/MapView;", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/maps/AMap;", Const.INTENT_KEY_APIKEY, "()Lcom/amap/api/maps/AMap;", "p", "(Lcom/amap/api/maps/AMap;)V", "", "resumed", "Z", "m", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "allocated", Const.INTENT_KEY_PKGNAME, "q", "softHeld", "n", "B", "delivered", "e", "u", "styleReady", "o", "C", "pendingForceDeliver", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "w", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "pendingResumeListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "y", "(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "Landroid/view/View$OnAttachStateChangeListener;", "pendingAttachListener", "Landroid/view/View$OnAttachStateChangeListener;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/view/View$OnAttachStateChangeListener;", "v", "(Landroid/view/View$OnAttachStateChangeListener;)V", "Ljava/lang/Runnable;", "pendingRevealRunnable", "Ljava/lang/Runnable;", "k", "()Ljava/lang/Runnable;", "z", "(Ljava/lang/Runnable;)V", "", "pendingStyleCancellers", "Ljava/util/List;", "l", "()Ljava/util/List;", "", "chromeInsetPx", "I", Const.INTENT_KEY_UMID, "()I", "t", "(I)V", "", "attachStartedElapsed", "J", "getAttachStartedElapsed", "()J", "s", "(J)V", "attachSeq", "c", "r", "Lkotlin/Function1;", "LY8/t;", "pendingOnMapReady", "Lp9/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lp9/l;", "x", "(Lp9/l;)V", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private AMap aMap;
        private boolean allocated;
        private int attachSeq;
        private long attachStartedElapsed;
        private int chromeInsetPx;
        private boolean delivered;
        private final MapView mapView;
        private View.OnAttachStateChangeListener pendingAttachListener;
        private boolean pendingForceDeliver;
        private InterfaceC5074l<? super AMap, Y8.t> pendingOnMapReady;
        private ViewTreeObserver.OnGlobalLayoutListener pendingResumeListener;
        private Runnable pendingRevealRunnable;
        private final List<Runnable> pendingStyleCancellers;
        private boolean resumed;
        private boolean softHeld;
        private boolean styleReady;

        public a(MapView mapView) {
            kotlin.jvm.internal.p.i(mapView, "mapView");
            this.mapView = mapView;
            this.pendingStyleCancellers = new ArrayList();
            this.chromeInsetPx = -1;
        }

        public final void A(boolean z10) {
            this.resumed = z10;
        }

        public final void B(boolean z10) {
            this.softHeld = z10;
        }

        public final void C(boolean z10) {
            this.styleReady = z10;
        }

        /* renamed from: a, reason: from getter */
        public final AMap getAMap() {
            return this.aMap;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getAllocated() {
            return this.allocated;
        }

        /* renamed from: c, reason: from getter */
        public final int getAttachSeq() {
            return this.attachSeq;
        }

        /* renamed from: d, reason: from getter */
        public final int getChromeInsetPx() {
            return this.chromeInsetPx;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getDelivered() {
            return this.delivered;
        }

        /* renamed from: f, reason: from getter */
        public final MapView getMapView() {
            return this.mapView;
        }

        /* renamed from: g, reason: from getter */
        public final View.OnAttachStateChangeListener getPendingAttachListener() {
            return this.pendingAttachListener;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getPendingForceDeliver() {
            return this.pendingForceDeliver;
        }

        public final InterfaceC5074l<AMap, Y8.t> i() {
            return this.pendingOnMapReady;
        }

        /* renamed from: j, reason: from getter */
        public final ViewTreeObserver.OnGlobalLayoutListener getPendingResumeListener() {
            return this.pendingResumeListener;
        }

        /* renamed from: k, reason: from getter */
        public final Runnable getPendingRevealRunnable() {
            return this.pendingRevealRunnable;
        }

        public final List<Runnable> l() {
            return this.pendingStyleCancellers;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getResumed() {
            return this.resumed;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getSoftHeld() {
            return this.softHeld;
        }

        /* renamed from: o, reason: from getter */
        public final boolean getStyleReady() {
            return this.styleReady;
        }

        public final void p(AMap aMap) {
            this.aMap = aMap;
        }

        public final void q(boolean z10) {
            this.allocated = z10;
        }

        public final void r(int i10) {
            this.attachSeq = i10;
        }

        public final void s(long j10) {
            this.attachStartedElapsed = j10;
        }

        public final void t(int i10) {
            this.chromeInsetPx = i10;
        }

        public final void u(boolean z10) {
            this.delivered = z10;
        }

        public final void v(View.OnAttachStateChangeListener onAttachStateChangeListener) {
            this.pendingAttachListener = onAttachStateChangeListener;
        }

        public final void w(boolean z10) {
            this.pendingForceDeliver = z10;
        }

        public final void x(InterfaceC5074l<? super AMap, Y8.t> interfaceC5074l) {
            this.pendingOnMapReady = interfaceC5074l;
        }

        public final void y(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.pendingResumeListener = onGlobalLayoutListener;
        }

        public final void z(Runnable runnable) {
            this.pendingRevealRunnable = runnable;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/amap/route/K$b", "Landroid/content/ComponentCallbacks2;", "", "level", "LY8/t;", "onTrimMemory", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ComponentCallbacks2 {
        public static final void c() {
            K.INSTANCE.W(80);
        }

        public static final void d(int i10) {
            K.INSTANCE.W(i10);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            kotlin.jvm.internal.p.i(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            K.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.M
                @Override // java.lang.Runnable
                public final void run() {
                    K.b.c();
                }
            });
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(final int level) {
            K.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.L
                @Override // java.lang.Runnable
                public final void run() {
                    K.b.d(level);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/amap/route/K$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnAttachStateChangeListener {
        final /* synthetic */ a $entry;
        final /* synthetic */ boolean $hideUntilReveal;

        public c(a aVar, boolean z10) {
            this.$entry = aVar;
            this.$hideUntilReveal = z10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            K k10 = K.INSTANCE;
            a aVar = this.$entry;
            k10.h0(aVar, aVar.getPendingForceDeliver(), this.$hideUntilReveal || !this.$entry.getStyleReady());
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }
    }

    static {
        final K k10 = new K();
        INSTANCE = k10;
        entries = new ArrayList();
        mainHandler = new Handler(Looper.getMainLooper());
        idleDestroyRunnable = new Runnable() { // from class: com.stepos.ailauncher.amap.route.A
            @Override // java.lang.Runnable
            public final void run() {
                K.S();
            }
        };
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.ailauncher.common.memory.d.INSTANCE.s(TAG, new d.a() { // from class: com.stepos.ailauncher.amap.route.B
                @Override // com.stepos.ailauncher.common.memory.d.a
                public final String a() {
                    return K.j(this.f24480a);
                }
            });
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        foregroundListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.N(((Boolean) obj).booleanValue());
            }
        };
        componentCallbacks = new b();
    }

    public static final Y8.t A(AMap aMap, a aVar, int i10, boolean z10) {
        if (!D(aVar, i10, "dark-resolve")) {
            B(aVar, i10, aMap, "resolve-dark" + z10);
        }
        return Y8.t.f7040a;
    }

    public static final void B(final a aVar, final int i10, final AMap aMap, final String str) {
        final MapView mapView = aVar.getMapView();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.amap.route.J
            @Override // java.lang.Runnable
            public final void run() {
                K.C(aVar, str, mapView, aMap, i10);
            }
        };
        aVar.z(runnable);
        mapView.post(runnable);
    }

    public static final void C(a aVar, String str, MapView mapView, AMap aMap, int i10) {
        aVar.z(null);
        if (D(aVar, i10, "owner-ready-" + str)) {
            return;
        }
        aVar.C(true);
        C2410v.INSTANCE.e0(mapView);
        K k10 = INSTANCE;
        k10.V(aVar, "owner-ready from=" + str + " vis=" + mapView.getVisibility());
        k10.U(aVar, "STYLE_READY", "from=" + str + " size=" + mapView.getWidth() + "x" + mapView.getHeight());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("owner-ready-");
        sb2.append(str);
        x(aVar, i10, aMap, sb2.toString());
    }

    public static final boolean D(a aVar, int i10, String str) {
        if (aVar.getAttachSeq() == i10 && aVar.getAllocated()) {
            return false;
        }
        INSTANCE.V(aVar, "skip stale from=" + str + " seq=" + i10 + " now=" + aVar.getAttachSeq() + " alloc=" + aVar.getAllocated());
        return true;
    }

    public static final Y8.t N(boolean z10) {
        if (!z10) {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.D
                @Override // java.lang.Runnable
                public final void run() {
                    K.O();
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void O() {
        INSTANCE.X();
    }

    public static final void S() {
        INSTANCE.F();
    }

    public static final void i0(MapView mapView, a aVar, boolean z10) {
        if (!mapView.isAttachedToWindow() || mapView.getWidth() <= 0 || mapView.getHeight() <= 0) {
            return;
        }
        INSTANCE.h0(aVar, aVar.getPendingForceDeliver(), z10 || !aVar.getStyleReady());
    }

    public static String j(K k10) {
        return k10.I();
    }

    public static /* synthetic */ void r(K k10, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        k10.q(aVar, z10);
    }

    public static final void v(MapView mapView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        C2410v.INSTANCE.e0(mapView);
    }

    public static final void x(a aVar, int i10, AMap aMap, String str) {
        if (D(aVar, i10, str)) {
            return;
        }
        InterfaceC5074l<AMap, Y8.t> interfaceC5074lI = aVar.i();
        if (interfaceC5074lI != null) {
            aVar.x(null);
            interfaceC5074lI.invoke(aMap);
            return;
        }
        INSTANCE.V(aVar, "skip deliver no-cb from=" + str);
    }

    public static final Y8.t y(AMap aMap, a aVar, int i10, boolean z10) {
        if (!D(aVar, i10, "dark-cached")) {
            B(aVar, i10, aMap, "cached-dark" + z10);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t z(final a aVar, final int i10, final AMap map) {
        kotlin.jvm.internal.p.i(map, "map");
        aVar.p(map);
        if (D(aVar, i10, "resolve")) {
            return Y8.t.f7040a;
        }
        K k10 = INSTANCE;
        C2410v c2410v = C2410v.INSTANCE;
        k10.V(aVar, "deliver resolve cb mapType=" + c2410v.d0(map));
        try {
            Result.Companion companion = Result.INSTANCE;
            c2410v.Z(map);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            C2410v.INSTANCE.v(map);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        C2410v c2410v2 = C2410v.INSTANCE;
        c2410v2.a0(aVar.getMapView());
        K k11 = INSTANCE;
        k11.j0(aVar, c2410v2.g0(aVar.getMapView(), 0));
        k11.V(aVar, "deliver resolve afterDark mapType=" + c2410v2.d0(map));
        k11.j0(aVar, c2410v2.O(aVar.getMapView(), 1200L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.A(map, aVar, i10, ((Boolean) obj).booleanValue());
            }
        }));
        return Y8.t.f7040a;
    }

    public final void E(a entry) {
        Object objB;
        MapView mapView = entry.getMapView();
        r(this, entry, false, 2, null);
        ViewParent parent = mapView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(mapView);
        }
        Y(entry, "destroy");
        try {
            Result.Companion companion = Result.INSTANCE;
            mapView.onDestroy();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "onDestroy failed", thE, false, 8, null);
        }
        entry.p(null);
        destroyCount++;
        com.stepos.ailauncher.common.memory.d.INSTANCE.w(C3081a.FOCUS_MAP_NAME);
        C4148a.u(TAG, "MapView DESTROYED #" + destroyCount + " hash=" + P(mapView), false, 4, null);
    }

    public final void F() {
        List<a> list = entries;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            a aVar = (a) obj;
            if (!aVar.getAllocated() && !aVar.getSoftHeld()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.E((a) it.next());
        }
        entries.removeAll(Z8.F.r1(arrayList));
        C4148a.u(TAG, "destroyFreeEntries removed=" + arrayList.size() + " " + I(), false, 4, null);
    }

    public final void G(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            return;
        }
        if (aVarK.getAllocated() || !aVarK.getSoftHeld()) {
            r(this, aVarK, false, 2, null);
            Y(aVarK, "soft_release");
            ViewParent parent = mapView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(mapView);
            }
            mapView.setVisibility(4);
            aVarK.q(false);
            aVarK.B(true);
            aVarK.u(false);
            aVarK.w(false);
            U(aVarK, "SOFT_DETACH", "size=" + mapView.getWidth() + "x" + mapView.getHeight());
            C4148a.k(TAG, "soft detach mv=" + P(mapView) + " " + I(), false, 4, null);
        }
    }

    public final void H(a entry, String from) {
        Object objB;
        MapView mapView = entry.getMapView();
        if (entry.getResumed()) {
            V(entry, "resume skip-already from=" + from);
            return;
        }
        if (!mapView.isAttachedToWindow()) {
            V(entry, "resume skip-detached from=" + from);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            mapView.onResume();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "onResume failed (" + from + ")", thE, false, 8, null);
        }
        entry.A(true);
        U(entry, "RESUME", "from=" + from + " size=" + mapView.getWidth() + "x" + mapView.getHeight());
        C4148a.k(TAG, "resume (" + from + ") mv=" + P(mapView) + " size=" + mapView.getWidth() + "x" + mapView.getHeight() + " vis=" + mapView.getVisibility() + " styleReady=" + entry.getStyleReady(), false, 4, null);
    }

    public final String I() {
        Object objB;
        int i10;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Z8.F.m1(entries));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List list = (List) objB;
        if (list == null) {
            return "pool[size~" + entries.size() + " create=" + createCount + " destroy=" + destroyCount + " racing]";
        }
        int size = list.size();
        List list2 = list;
        boolean z10 = list2 instanceof Collection;
        int i11 = 0;
        if (z10 && list2.isEmpty()) {
            i10 = 0;
        } else {
            Iterator it = list2.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((a) it.next()).getAllocated() && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        if (!z10 || !list2.isEmpty()) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((a) it2.next()).getSoftHeld() && (i11 = i11 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return "pool[size=" + size + " allocated=" + i10 + " soft=" + i11 + " create=" + createCount + " destroy=" + destroyCount + "]";
    }

    public final void J() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("MapViewPool must be called on main thread");
        }
    }

    public final a K(MapView mapView) {
        Object next;
        Iterator<T> it = entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a) next).getMapView() == mapView) {
                break;
            }
        }
        return (a) next;
    }

    public final a L() {
        Object next;
        Iterator<T> it = entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((a) next).getAllocated()) {
                break;
            }
        }
        return (a) next;
    }

    public final void M(a entry, String from) {
        Object objB;
        MapView mapView = entry.getMapView();
        Object parent = mapView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int i10 = width + 4;
        int height = view.getHeight();
        int i11 = height + 4;
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        if (mapView.getWidth() == i10 && mapView.getHeight() == i11) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            mapView.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i11, 1073741824));
            mapView.layout(-2, -2, width + 2, height + 2);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "force layout failed (" + from + ")", thE, false, 8, null);
        }
        C4148a.k(TAG, "force layout (" + from + ") mv=" + P(mapView) + " -> " + mapView.getWidth() + "x" + mapView.getHeight() + " (parent " + view.getWidth() + "x" + view.getHeight() + " bleed=2)", false, 4, null);
    }

    public final int P(MapView mv) {
        return System.identityHashCode(mv);
    }

    public final void Q(MapView mapView) {
        a aVarK;
        J();
        if (mapView == null || (aVarK = K(mapView)) == null || !aVarK.getAllocated() || mapView.getParent() == null) {
            return;
        }
        mapView.setVisibility(4);
    }

    public final void R(a entry, String from) {
        MapView mapView = entry.getMapView();
        if (mapView.getVisibility() != 4) {
            mapView.setVisibility(4);
        }
        V(entry, "hideUntilStyled from=" + from);
    }

    public final void T(MapView mapView, int insetPx) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null || aVarK.getChromeInsetPx() != insetPx || !aVarK.getStyleReady()) {
            Runnable runnableG0 = C2410v.INSTANCE.g0(mapView, insetPx);
            if (aVarK != null) {
                j0(aVarK, runnableG0);
                aVarK.t(insetPx);
                return;
            }
            return;
        }
        C4148a.k(TAG, "insetLiteLogo skip cached mv=" + P(mapView) + " inset=" + insetPx, false, 4, null);
    }

    public final void U(a entry, String event, String detail) {
        int i10;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = lastJankEventElapsed;
        long j11 = j10 > 0 ? jElapsedRealtime - j10 : -1L;
        lastJankEventElapsed = jElapsedRealtime;
        List<a> list = entries;
        if ((list instanceof Collection) && list.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<T> it = list.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((a) it.next()).getResumed() && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        int iO = o();
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " gap=" + j11 + "ms " + event + " mv=" + P(entry.getMapView()) + " resumedN=" + i10 + " allocatedN=" + iO + " styleReady=" + entry.getStyleReady() + " vis=" + entry.getMapView().getVisibility() + " | " + detail, false, 4, null);
    }

    public final void V(a entry, String msg) {
        MapView mapView = entry.getMapView();
        C4148a.k(TAG, "styleDiag t=" + SystemClock.elapsedRealtime() + " mv=" + P(mapView) + " " + msg + " | styleReady=" + entry.getStyleReady() + " resumed=" + entry.getResumed() + " alpha=" + mapView.getAlpha() + " vis=" + mapView.getVisibility() + " size=" + mapView.getWidth() + "x" + mapView.getHeight() + " attached=" + mapView.isAttachedToWindow() + " mapType=" + C2410v.INSTANCE.d0(entry.getAMap()), false, 4, null);
    }

    public final void W(int level) {
        Y8.t tVar;
        J();
        if (level < 5) {
            return;
        }
        boolean z10 = level >= 10;
        C4148a.k(TAG, "onTrimMemory level=" + level + " severe=" + z10 + " " + I(), false, 4, null);
        if (z10) {
            List<a> list = entries;
            ArrayList<a> arrayList = new ArrayList();
            for (Object obj : list) {
                a aVar = (a) obj;
                if (aVar.getSoftHeld() && !aVar.getAllocated()) {
                    arrayList.add(obj);
                }
            }
            for (a aVar2 : arrayList) {
                aVar2.B(false);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AMap aMap = aVar2.getAMap();
                    if (aMap != null) {
                        aMap.clear();
                        tVar = Y8.t.f7040a;
                    } else {
                        tVar = null;
                    }
                    Result.b(tVar);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                C4148a.u(TAG, "trim force-drop softHeld mv=" + INSTANCE.P(aVar2.getMapView()), false, 4, null);
            }
        }
        F();
    }

    public final void X() {
        J();
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            INSTANCE.Y((a) it.next(), "app_background");
        }
        C4148a.k(TAG, "app background, paused all " + I(), false, 4, null);
    }

    public final void Y(a entry, String from) {
        Object objB;
        MapView mapView = entry.getMapView();
        if (kotlin.jvm.internal.p.d(from, "release") || kotlin.jvm.internal.p.d(from, "soft_release") || La.D.X(from, "destroy", false, 2, null)) {
            r(this, entry, false, 2, null);
        }
        if (entry.getResumed()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                mapView.onPause();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "onPause failed (" + from + ")", thE, false, 8, null);
            }
            entry.A(false);
            C4148a.k(TAG, "pause (" + from + ") mv=" + P(mapView), false, 4, null);
        }
    }

    public final void Z(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK != null && aVarK.getAllocated()) {
            if (aVarK.getResumed()) {
                U(aVarK, "PAUSE", "owner_offscreen=true");
            }
            Y(aVarK, "offscreen");
        }
    }

    public final void a0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        C2410v.INSTANCE.e0(mapView);
    }

    public final void b0() {
        if (trimCallbackRegistered) {
            return;
        }
        Context context = appContext;
        Application application = context instanceof Application ? (Application) context : null;
        if (application == null) {
            return;
        }
        application.registerComponentCallbacks(componentCallbacks);
        C2411w c2411w = C2411w.INSTANCE;
        c2411w.f(application);
        c2411w.d(foregroundListener);
        trimCallbackRegistered = true;
        C4148a.k(TAG, "trim + foreground callback registered", false, 4, null);
    }

    public final void c0(MapView mapView) {
        Object objB;
        Y8.t tVar;
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            return;
        }
        r(this, aVarK, false, 2, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            AMap aMap = aVarK.getAMap();
            if (aMap != null) {
                aMap.clear();
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "aMap.clear failed on release", thE, false, 8, null);
        }
        Y(aVarK, "release");
        ViewParent parent = mapView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(mapView);
        }
        aVarK.q(false);
        aVarK.B(false);
        aVarK.u(false);
        aVarK.w(false);
        C4148a.k(TAG, "release mv=" + P(mapView) + " " + I(), false, 4, null);
        g0();
    }

    public final void d0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK != null && aVarK.getAllocated()) {
            MapView mapView2 = aVarK.getMapView();
            M(aVarK, "resume_onscreen");
            if (!mapView2.isAttachedToWindow() || mapView2.getWidth() <= 0 || mapView2.getHeight() <= 0) {
                h0(aVarK, false, false);
                return;
            }
            boolean resumed = aVarK.getResumed();
            H(aVarK, "onscreen");
            if (resumed) {
                return;
            }
            U(aVarK, "RESUME_ONSCREEN", "vis=" + mapView2.getVisibility() + " ownerRevealPending=true");
        }
    }

    public final boolean e0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            return false;
        }
        if (aVarK.getAllocated() && mapView.getParent() != null && aVarK.getStyleReady()) {
            f0(aVarK, "owner-content-ready");
            return true;
        }
        int iP = P(mapView);
        boolean allocated = aVarK.getAllocated();
        boolean z10 = mapView.getParent() != null;
        C4148a.k(TAG, "revealForOwner rejected mv=" + iP + " allocated=" + allocated + " parent=" + z10 + " styleReady=" + aVarK.getStyleReady(), false, 4, null);
        return false;
    }

    public final void f0(a entry, String from) {
        MapView mapView = entry.getMapView();
        int visibility = mapView.getVisibility();
        entry.C(true);
        C2410v.INSTANCE.e0(mapView);
        mapView.setAlpha(1.0f);
        if (mapView.getVisibility() != 0) {
            mapView.setVisibility(0);
        }
        V(entry, "reveal from=" + from + " vis " + visibility + "->" + mapView.getVisibility());
    }

    public final void g0() {
        List<a> list = entries;
        boolean z10 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (!aVar.getAllocated() && !aVar.getSoftHeld()) {
                    z10 = true;
                    break;
                }
            }
        }
        Handler handler = mainHandler;
        Runnable runnable = idleDestroyRunnable;
        handler.removeCallbacks(runnable);
        if (z10) {
            handler.postDelayed(runnable, 30000L);
        }
    }

    public final void h0(final a entry, boolean forceDeliver, final boolean hideUntilReveal) {
        final MapView mapView = entry.getMapView();
        if (forceDeliver) {
            entry.w(true);
        }
        M(entry, "schedule");
        if (mapView.isAttachedToWindow() && mapView.getWidth() > 0 && mapView.getHeight() > 0) {
            q(entry, false);
            if (hideUntilReveal || !entry.getStyleReady()) {
                R(entry, "before-resume");
            }
            H(entry, "ready");
            V(entry, "after-resume ready");
            boolean z10 = entry.getPendingForceDeliver() || !entry.getDelivered();
            entry.w(false);
            if (!z10) {
                V(entry, "skip-deliver already delivered");
                return;
            } else {
                entry.u(true);
                w(entry);
                return;
            }
        }
        if (entry.getPendingAttachListener() == null) {
            c cVar = new c(entry, hideUntilReveal);
            entry.v(cVar);
            mapView.addOnAttachStateChangeListener(cVar);
        }
        if (entry.getPendingResumeListener() == null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.amap.route.E
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    K.i0(mapView, entry, hideUntilReveal);
                }
            };
            entry.y(onGlobalLayoutListener);
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
        C4148a.k(TAG, "resume deferred mv=" + P(mapView) + " attached=" + mapView.isAttachedToWindow() + " size=" + mapView.getWidth() + "x" + mapView.getHeight() + " forceDeliver=" + entry.getPendingForceDeliver(), false, 4, null);
    }

    public final void j0(a entry, Runnable canceller) {
        entry.l().add(canceller);
    }

    public final boolean k0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            return false;
        }
        if (!aVarK.getAllocated()) {
            if (!aVarK.getSoftHeld() && mapView.getParent() != null) {
                return false;
            }
            c0(mapView);
            return true;
        }
        C4148a.k(TAG, "finish soft SKIP allocated mv=" + P(mapView) + " " + I(), false, 4, null);
        return false;
    }

    public final boolean l0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            return false;
        }
        if (aVarK.getAllocated()) {
            C4148a.k(TAG, "reclaim soft already-allocated mv=" + P(mapView) + " " + I(), false, 4, null);
            return false;
        }
        aVarK.q(true);
        aVarK.B(false);
        aVarK.u(false);
        mainHandler.removeCallbacks(idleDestroyRunnable);
        g0();
        C4148a.k(TAG, "reclaim soft ok mv=" + P(mapView) + " " + I(), false, 4, null);
        return true;
    }

    public final MapView m(Context context) {
        a aVarL;
        kotlin.jvm.internal.p.i(context, "context");
        J();
        appContext = context.getApplicationContext();
        b0();
        a aVarL2 = L();
        if (aVarL2 != null) {
            return INSTANCE.n(aVarL2, aVarL2.getSoftHeld());
        }
        if (entries.size() >= 2) {
            if (m0() && (aVarL = L()) != null) {
                return INSTANCE.n(aVarL, aVarL.getSoftHeld());
            }
            C4148a.k(TAG, "acquire FULL -> null " + I(), false, 4, null);
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        a aVarU = u(applicationContext);
        aVarU.q(true);
        aVarU.B(false);
        aVarU.u(false);
        C4148a.k(TAG, "acquire new mv=" + P(aVarU.getMapView()) + " styleReady=" + aVarU.getStyleReady() + " vis=" + aVarU.getMapView().getVisibility() + " " + I(), false, 4, null);
        g0();
        return aVarU.getMapView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object] */
    public final boolean m0() {
        Object next;
        a next2;
        Iterator it = entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            a aVar = (a) next;
            if (aVar.getAllocated() && !aVar.getSoftHeld() && !aVar.getMapView().isAttachedToWindow()) {
                break;
            }
        }
        a aVar2 = (a) next;
        if (aVar2 == null) {
            Iterator it2 = entries.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = 0;
                    break;
                }
                next2 = it2.next();
                a aVar3 = (a) next2;
                if (aVar3.getAllocated() && !aVar3.getSoftHeld()) {
                    Object parent = aVar3.getMapView().getParent();
                    View view = parent instanceof View ? (View) parent : null;
                    if (view == null || !C2414z.INSTANCE.f(view)) {
                        break;
                    }
                }
            }
            aVar2 = next2;
            if (aVar2 == null) {
                return false;
            }
        }
        C4148a.k(TAG, "acquire yield offscreen mv=" + P(aVar2.getMapView()) + " attached=" + aVar2.getMapView().isAttachedToWindow() + " " + I(), false, 4, null);
        G(aVar2.getMapView());
        return true;
    }

    public final MapView n(a entry, boolean wasSoft) {
        Object objB;
        Y8.t tVar;
        entry.q(true);
        entry.B(false);
        entry.u(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            AMap aMap = entry.getAMap();
            if (aMap != null) {
                aMap.clear();
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "aMap.clear failed on acquire", thE, false, 8, null);
        }
        C4148a.k(TAG, "acquire reuse mv=" + P(entry.getMapView()) + " soft=" + wasSoft + " styleReady=" + entry.getStyleReady() + " vis=" + entry.getMapView().getVisibility() + " mapType=" + C2410v.INSTANCE.d0(entry.getAMap()) + " " + I(), false, 4, null);
        g0();
        return entry.getMapView();
    }

    public final int o() {
        List<a> list = entries;
        int i10 = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).getAllocated() && (i10 = i10 + 1) < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    public final void p(MapView mapView, FrameLayout slot, InterfaceC5074l<? super AMap, Y8.t> onMapReady) {
        AMap aMap;
        kotlin.jvm.internal.p.i(mapView, "mapView");
        kotlin.jvm.internal.p.i(slot, "slot");
        kotlin.jvm.internal.p.i(onMapReady, "onMapReady");
        J();
        a aVarK = K(mapView);
        if (aVarK == null) {
            C4148a.u(TAG, "attachToSlot no entry mv=" + P(mapView), false, 4, null);
            return;
        }
        r(this, aVarK, false, 2, null);
        boolean z10 = mapView.getParent() != slot;
        if (!z10 && aVarK.getAllocated() && aVarK.getDelivered() && aVarK.getStyleReady() && (aMap = aVarK.getAMap()) != null) {
            INSTANCE.V(aVarK, "attachToSlot same-slot live, skip re-hide/deliver");
            onMapReady.invoke(aMap);
            return;
        }
        mapView.setVisibility(4);
        if (z10) {
            ViewParent parent = mapView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                INSTANCE.Y(aVarK, "attach_move");
                viewGroup.removeView(mapView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(-2, -2, -2, -2);
            Y8.t tVar = Y8.t.f7040a;
            slot.addView(mapView, 0, layoutParams);
            C2410v.INSTANCE.a0(mapView);
        } else {
            ViewGroup.LayoutParams layoutParams2 = mapView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
            if (layoutParams3 != null && (layoutParams3.leftMargin != -2 || layoutParams3.rightMargin != -2)) {
                layoutParams3.setMargins(-2, -2, -2, -2);
                mapView.setLayoutParams(layoutParams3);
            }
            C2410v.INSTANCE.a0(mapView);
        }
        int i10 = attachSeq + 1;
        attachSeq = i10;
        aVarK.r(i10);
        aVarK.s(SystemClock.elapsedRealtime());
        U(aVarK, "ATTACH", "parentChanged=" + z10 + " forceDeliver=true hide=true styleReady=" + aVarK.getStyleReady() + " slot=" + slot.getWidth() + "x" + slot.getHeight() + " seq=" + aVarK.getAttachSeq());
        int width = slot.getWidth();
        int height = slot.getHeight();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachToSlot parentChanged=");
        sb2.append(z10);
        sb2.append(" forceDeliver=");
        sb2.append(true);
        sb2.append(" hideUntilReveal=");
        sb2.append(true);
        sb2.append(" slot=");
        sb2.append(width);
        sb2.append("x");
        sb2.append(height);
        V(aVarK, sb2.toString());
        aVarK.x(onMapReady);
        h0(aVarK, true, true);
    }

    public final void q(a entry, boolean clearDeliverCallback) {
        if (clearDeliverCallback) {
            entry.x(null);
        }
        s(entry);
        t(entry);
        ViewTreeObserver.OnGlobalLayoutListener pendingResumeListener = entry.getPendingResumeListener();
        if (pendingResumeListener != null) {
            entry.y(null);
            ViewTreeObserver viewTreeObserver = entry.getMapView().getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(pendingResumeListener);
            }
        }
        View.OnAttachStateChangeListener pendingAttachListener = entry.getPendingAttachListener();
        if (pendingAttachListener != null) {
            entry.v(null);
            entry.getMapView().removeOnAttachStateChangeListener(pendingAttachListener);
        }
    }

    public final void s(a entry) {
        Runnable pendingRevealRunnable = entry.getPendingRevealRunnable();
        if (pendingRevealRunnable != null) {
            entry.getMapView().removeCallbacks(pendingRevealRunnable);
            mainHandler.removeCallbacks(pendingRevealRunnable);
            entry.z(null);
            INSTANCE.V(entry, "cancel pending reveal");
        }
    }

    public final void t(a entry) {
        if (entry.l().isEmpty()) {
            return;
        }
        for (Runnable runnable : entry.l()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                runnable.run();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        entry.l().clear();
    }

    public final a u(Context ctx) {
        Object objB;
        final MapView mapView = new MapView(ctx, new AMapOptions().mapType(3));
        mapView.setVisibility(4);
        mapView.setAlpha(1.0f);
        C2410v.INSTANCE.a0(mapView);
        try {
            Result.Companion companion = Result.INSTANCE;
            mapView.onCreate(new Bundle());
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "MapView onCreate failed", thE, false, 8, null);
        }
        mapView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.amap.route.F
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                K.v(mapView, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        a aVar = new a(mapView);
        entries.add(aVar);
        createCount++;
        com.stepos.ailauncher.common.memory.d.INSTANCE.v(C3081a.FOCUS_MAP_NAME);
        C4148a.u(TAG, "MapView CREATED #" + createCount + " hash=" + P(mapView) + " vis=" + mapView.getVisibility() + " optNight=3 " + I(), false, 4, null);
        return aVar;
    }

    public final void w(final a entry) {
        s(entry);
        final int attachSeq2 = entry.getAttachSeq();
        final AMap aMap = entry.getAMap();
        if (aMap == null) {
            V(entry, "deliver resolve start");
            entry.getAttachSeq();
            C2410v.INSTANCE.m0(entry.getMapView(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return K.z(entry, attachSeq2, (AMap) obj);
                }
            });
            return;
        }
        K k10 = INSTANCE;
        String str = entry.getStyleReady() ? "hot" : "cold";
        C2410v c2410v = C2410v.INSTANCE;
        k10.V(entry, "deliver cached-" + str + " mapType=" + c2410v.d0(aMap));
        k10.R(entry, "deliver-cached-cold");
        try {
            Result.Companion companion = Result.INSTANCE;
            c2410v.Z(aMap);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            C2410v.INSTANCE.v(aMap);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        C2410v c2410v2 = C2410v.INSTANCE;
        c2410v2.a0(entry.getMapView());
        K k11 = INSTANCE;
        k11.V(entry, "deliver cached afterDark mapType=" + c2410v2.d0(aMap));
        k11.j0(entry, c2410v2.O(entry.getMapView(), 1200L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K.y(aMap, entry, attachSeq2, ((Boolean) obj).booleanValue());
            }
        }));
    }
}
