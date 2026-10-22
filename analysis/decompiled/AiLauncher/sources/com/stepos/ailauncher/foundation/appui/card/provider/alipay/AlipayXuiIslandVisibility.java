package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import Z8.C1174w;
import Z8.Y;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.common.utils.r;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.H;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u007f\u0080\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b \u0010\u0010J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020)2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J/\u0010-\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010,\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010\u0003J\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u0010\fJ\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002000\u0014H\u0002¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020\u000407H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\fJ\u0017\u0010;\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b;\u0010\fJ\u001d\u0010=\u001a\u00020\b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000407H\u0002¢\u0006\u0004\b=\u0010>J1\u0010?\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u001d\u0010A\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\bE\u0010\u0013J!\u0010F\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bF\u0010\u0010J9\u0010J\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bL\u0010\u001bJ\u001f\u0010M\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\bO\u0010PJ+\u0010R\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bR\u0010SJ!\u0010T\u001a\u00020)2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020)2\u0006\u0010V\u001a\u00020)H\u0000¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\bY\u0010\u001bJ!\u0010[\u001a\u00020\b2\u0006\u0010Z\u001a\u00020)2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010]\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b^\u0010_J1\u0010a\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\ba\u0010\u001fJ#\u0010b\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bb\u0010cR \u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR \u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010fR \u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010fRT\u0010k\u001aB\u0012\f\u0012\n j*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n j*\u0004\u0018\u00010)0) j* \u0012\f\u0012\n j*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n j*\u0004\u0018\u00010)0)\u0018\u00010i0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR \u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010fR\u0016\u0010Z\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010nR\u0016\u0010p\u001a\u0004\u0018\u00010o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010sR\u0014\u0010u\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u00102R\u0016\u0010v\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010nR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility;", "", "<init>", "()V", "", "liveId", "", "now", "LY8/t;", "f", "(Ljava/lang/String;J)V", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;", "live", "k", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)V", "reason", "o", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Ljava/lang/String;)V", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", AuthSessionDto.STATUS_PENDING, "", "P", "(Ljava/util/List;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)I", "D", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)V", "taskId", "keepLiveId", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "card", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", "memory", "known", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;Ljava/lang/String;)Z", "floatOverlay", "G", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;ZLjava/lang/String;)V", "p", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Record;", "record", "J", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Record;)V", "L", "y", "()Ljava/util/List;", "", "z", "()Ljava/util/Set;", "K", "t", "ids", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/util/Set;)V", "H", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;JLjava/lang/String;)V", "X", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;)Z", "U", "(Ljava/lang/String;)Ljava/lang/String;", "l", "n", "status", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "q", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "u", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;)V", "v", "(Ljava/lang/String;)Z", "fresh", "Q", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;)Z", "B", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;Ljava/lang/String;)Z", "onTop", "C", "(Z)Z", "M", "alipayOnTop", "F", "(ZLcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;)V", "sessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)V", "chatSessionId", "r", "N", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;J)V", "Ljava/util/concurrent/ConcurrentHashMap;", "cards", "Ljava/util/concurrent/ConcurrentHashMap;", "suppressed", "records", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "acknowledged", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "reopenOnLeave", "Z", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "MMKV_ID", "Ljava/lang/String;", "INDEX_KEY", "WATCH_MS", "switchHooked", "Ljava/lang/Runnable;", "watchRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/common/utils/r$b;", "leaveListener", "Lcom/stepos/ailauncher/common/utils/r$b;", "REOPEN_REASONS", "Ljava/util/Set;", "Card", "Record", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayXuiIslandVisibility {
    private static final String INDEX_KEY = "__index";
    private static final String MMKV_ID = "alipay_xui_island_live";
    private static final Set<String> REOPEN_REASONS;
    private static final long WATCH_MS = 1000;
    private static boolean alipayOnTop;
    private static final r.b leaveListener;
    private static final Handler mainHandler;
    private static boolean switchHooked;
    private static final Runnable watchRunnable;
    public static final AlipayXuiIslandVisibility INSTANCE = new AlipayXuiIslandVisibility();
    private static final ConcurrentHashMap<String, Card> cards = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Card> suppressed = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Record> records = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> acknowledged = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<String, Card> reopenOnLeave = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (AlipayXuiIslandVisibility.cards.isEmpty() && AlipayXuiIslandVisibility.suppressed.isEmpty()) {
                return;
            }
            AlipayXuiIslandVisibility.INSTANCE.F(G.INSTANCE.d(), (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class));
        }
    }

    static {
        Looper mainLooper = Looper.getMainLooper();
        mainHandler = mainLooper != null ? new Handler(mainLooper) : null;
        watchRunnable = new a();
        leaveListener = new r.b() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.I
            @Override // com.stepos.ailauncher.common.utils.r.b
            public final void a(r.ForegroundApp foregroundApp) {
                AlipayXuiIslandVisibility.w(foregroundApp);
            }
        };
        REOPEN_REASONS = Y.j("click", AlipayXuiLiveClickReceiver.EXTRA_SWIPE, "gone");
    }

    public static /* synthetic */ void I(AlipayXuiIslandVisibility alipayXuiIslandVisibility, ILiveNotificationService iLiveNotificationService, Card card, long j10, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = System.currentTimeMillis();
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            str = "publish";
        }
        alipayXuiIslandVisibility.H(iLiveNotificationService, card, j11, str);
    }

    public static /* synthetic */ void O(AlipayXuiIslandVisibility alipayXuiIslandVisibility, ILiveNotificationService iLiveNotificationService, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class);
        }
        if ((i10 & 2) != 0) {
            j10 = System.currentTimeMillis();
        }
        alipayXuiIslandVisibility.N(iLiveNotificationService, j10);
    }

    public static /* synthetic */ boolean R(AlipayXuiIslandVisibility alipayXuiIslandVisibility, String str, ILiveNotificationService iLiveNotificationService, Card card, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            card = null;
        }
        return alipayXuiIslandVisibility.Q(str, iLiveNotificationService, card);
    }

    public static final void g(String str) {
        INSTANCE.E(str);
    }

    public static /* synthetic */ void m(AlipayXuiIslandVisibility alipayXuiIslandVisibility, String str, ILiveNotificationService iLiveNotificationService, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class);
        }
        if ((i10 & 4) != 0) {
            str2 = "click";
        }
        alipayXuiIslandVisibility.l(str, iLiveNotificationService, str2);
    }

    public static /* synthetic */ void s(AlipayXuiIslandVisibility alipayXuiIslandVisibility, String str, String str2, ILiveNotificationService iLiveNotificationService, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class);
        }
        alipayXuiIslandVisibility.r(str, str2, iLiveNotificationService);
    }

    public static final void w(r.ForegroundApp app) {
        kotlin.jvm.internal.p.i(app, "app");
        if (kotlin.jvm.internal.p.d(app.getPackageName(), C3236a.PKG_ALIPAY)) {
            Handler handler = mainHandler;
            if (handler == null) {
                INSTANCE.F(true, (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class));
            } else {
                handler.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.K
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlipayXuiIslandVisibility.x();
                    }
                });
            }
        }
    }

    public static final void x() {
        INSTANCE.F(true, (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class));
    }

    public final boolean A(Card card, String taskId) {
        if (kotlin.jvm.internal.p.d(card.getTaskId(), taskId)) {
            return true;
        }
        return La.D.X(card.getLiveId(), AlipayXuiIsland.TASK_PREFIX + taskId + ServerSentEventKt.COLON, false, 2, null);
    }

    public final boolean B(ILiveNotificationService live, String liveId) {
        kotlin.jvm.internal.p.i(liveId, "liveId");
        if (live == null || !live.isPosted(liveId)) {
            return acknowledged.contains(liveId);
        }
        acknowledged.add(liveId);
        return false;
    }

    public final boolean C(boolean onTop) {
        boolean z10 = alipayOnTop && !onTop;
        alipayOnTop = onTop;
        return z10;
    }

    public final void D(ILiveNotificationService live) {
        if (live == null) {
            return;
        }
        Collection<Card> collectionValues = cards.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (INSTANCE.B(live, ((Card) obj).getLiveId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Card) it.next()).getLiveId());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            o((String) it2.next(), live, AlipayXuiLiveClickReceiver.EXTRA_SWIPE);
        }
    }

    public final void E(String liveId) {
        Long collapseAt;
        Record record = records.get(liveId);
        if (record == null || (collapseAt = record.getCollapseAt()) == null) {
            return;
        }
        if (System.currentTimeMillis() + 50 < collapseAt.longValue()) {
            return;
        }
        k(liveId, (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class));
    }

    public final void F(boolean alipayOnTop2, ILiveNotificationService live) {
        boolean zC = C(alipayOnTop2);
        if (alipayOnTop2) {
            V(live);
        } else {
            if (!zC) {
                D(live);
            }
            Collection<Card> collectionValues = suppressed.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            P(Z8.F.m1(collectionValues), live);
            if (zC) {
                M(live);
            }
        }
        p();
    }

    public final void G(ILiveNotificationService live, Card card, boolean floatOverlay, String reason) {
        live.showSmall(card.getLiveId(), card.getTitle(), card.getContent(), card.getStatus(), card.getAppLink(), card.getSessionId(), floatOverlay, card.getMedium(), 14400000L);
        R5.b.INSTANCE.c("binder.island." + reason, Y8.j.a("liveId", card.getLiveId()), Y8.j.a("status", card.getStatus()), Y8.j.a("floatOverlay", Boolean.valueOf(floatOverlay)), Y8.j.a("medium", Boolean.valueOf(card.getMedium())));
    }

    public final void H(ILiveNotificationService live, Card card, long now, String reason) {
        kotlin.jvm.internal.p.i(live, "live");
        kotlin.jvm.internal.p.i(card, "card");
        kotlin.jvm.internal.p.i(reason, "reason");
        Long lValueOf = card.getFloatOverlay() ? Long.valueOf(5000 + now) : null;
        suppressed.remove(card.getLiveId());
        cards.put(card.getLiveId(), card);
        acknowledged.remove(card.getLiveId());
        J(new Record(card, lValueOf, false));
        G(live, card, card.getFloatOverlay(), reason);
        f(card.getLiveId(), now);
        p();
    }

    public final void J(Record record) {
        Object objB;
        records.put(record.getCard().getLiveId(), record);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(N5.k.INSTANCE.b().toJson(record));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return;
        }
        try {
            Result.b(Boolean.valueOf(C5009a.INSTANCE.H(MMKV_ID, record.getCard().getLiveId(), str)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        K(record.getCard().getLiveId());
    }

    public final void K(String liveId) {
        Set<String> setQ1 = Z8.F.q1(z());
        if (setQ1.add(liveId)) {
            T(setQ1);
        }
    }

    public final void L(String liveId) {
        try {
            Result.Companion companion = Result.INSTANCE;
            C5009a.INSTANCE.J(MMKV_ID, liveId);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        t(liveId);
    }

    public final void M(ILiveNotificationService live) {
        if (live == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Card card : reopenOnLeave.values()) {
            kotlin.jvm.internal.p.h(card, "next(...)");
            Card card2 = card;
            if (AlipayXuiIsland.INSTANCE.n(Integer.valueOf(card2.getRawStatus())) && !cards.containsKey(card2.getLiveId()) && !live.isPosted(card2.getLiveId())) {
                linkedHashMap.put(card2.getLiveId(), W(card2));
            }
        }
        for (H.Memory aVar : H.INSTANCE.b()) {
            if (!linkedHashMap.containsKey(aVar.getLiveId())) {
                linkedHashMap.put(aVar.getLiveId(), j(aVar, reopenOnLeave.get(aVar.getLiveId())));
            }
        }
        reopenOnLeave.clear();
        for (Object obj : linkedHashMap.values()) {
            kotlin.jvm.internal.p.h(obj, "next(...)");
            Card card3 = (Card) obj;
            if (!La.H.x0(card3.getTaskId())) {
                I(this, live, card3, 0L, "restore", 4, null);
                H.INSTANCE.g(card3.getTaskId(), card3.getRawStatus(), card3.getTitle(), card3.getContent(), card3.getLiveId());
            }
        }
    }

    public final void N(ILiveNotificationService live, long now) {
        for (Record record : y()) {
            Card card = record.getCard();
            if (record.getSuppressed() && AlipayXuiIsland.INSTANCE.n(Integer.valueOf(card.getRawStatus()))) {
                records.put(card.getLiveId(), record);
                suppressed.put(card.getLiveId(), card);
            } else if (live == null || !live.isPosted(card.getLiveId())) {
                H.INSTANCE.a(card.getTaskId());
                L(card.getLiveId());
            } else {
                records.put(card.getLiveId(), record);
                cards.put(card.getLiveId(), card);
                if (record.getCollapseAt() != null) {
                    if (now >= record.getCollapseAt().longValue()) {
                        k(card.getLiveId(), live);
                    } else {
                        f(card.getLiveId(), now);
                    }
                }
            }
        }
        if (cards.isEmpty() && suppressed.isEmpty()) {
            return;
        }
        F(G.INSTANCE.d(), live);
    }

    public final int P(List<Card> pending, ILiveNotificationService live) {
        AlipayXuiIslandVisibility alipayXuiIslandVisibility;
        ILiveNotificationService iLiveNotificationService;
        int i10 = 0;
        for (Card card : pending) {
            kotlin.jvm.internal.p.h(card, "next(...)");
            Card card2 = card;
            if (AlipayXuiIsland.INSTANCE.n(Integer.valueOf(card2.getRawStatus()))) {
                if (live != null) {
                    Card cardW = this.W(card2);
                    alipayXuiIslandVisibility = this;
                    iLiveNotificationService = live;
                    I(alipayXuiIslandVisibility, iLiveNotificationService, cardW, 0L, "restore", 4, null);
                    if (!La.H.x0(cardW.getTaskId())) {
                        H.INSTANCE.g(cardW.getTaskId(), cardW.getRawStatus(), cardW.getTitle(), cardW.getContent(), cardW.getLiveId());
                    }
                    reopenOnLeave.remove(card2.getLiveId());
                    i10++;
                }
                this = alipayXuiIslandVisibility;
                live = iLiveNotificationService;
            } else {
                suppressed.remove(card2.getLiveId());
                records.remove(card2.getLiveId());
                acknowledged.remove(card2.getLiveId());
                reopenOnLeave.remove(card2.getLiveId());
                this.L(card2.getLiveId());
            }
            alipayXuiIslandVisibility = this;
            iLiveNotificationService = live;
            this = alipayXuiIslandVisibility;
            live = iLiveNotificationService;
        }
        return i10;
    }

    public final boolean Q(String taskId, ILiveNotificationService live, Card fresh) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Collection<Card> collectionValues = suppressed.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList<Card> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Card card = (Card) obj;
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = INSTANCE;
            kotlin.jvm.internal.p.f(card);
            if (alipayXuiIslandVisibility.A(card, taskId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (Card cardCopy$default : arrayList) {
            if (fresh == null || !kotlin.jvm.internal.p.d(cardCopy$default.getLiveId(), fresh.getLiveId())) {
                kotlin.jvm.internal.p.f(cardCopy$default);
            } else {
                kotlin.jvm.internal.p.f(cardCopy$default);
                String title = fresh.getTitle();
                String content = fresh.getContent();
                String status = fresh.getStatus();
                String appLink = fresh.getAppLink();
                if (appLink == null) {
                    appLink = cardCopy$default.getAppLink();
                }
                String str = appLink;
                String sessionId = fresh.getSessionId();
                if (sessionId == null) {
                    sessionId = cardCopy$default.getSessionId();
                }
                cardCopy$default = Card.copy$default(cardCopy$default, null, title, content, status, str, sessionId, null, 0, fresh.getMedium(), false, 705, null);
            }
            arrayList2.add(cardCopy$default);
        }
        return !arrayList2.isEmpty() && P(arrayList2, live) > 0;
    }

    public final void S(String taskId, String keepLiveId, ILiveNotificationService live) {
        Collection<Card> collectionValues = cards.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Collection<Card> collectionValues2 = suppressed.values();
        kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
        List listS0 = Z8.F.S0(collectionValues, collectionValues2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            Card card = (Card) obj;
            if (!kotlin.jvm.internal.p.d(card.getLiveId(), keepLiveId)) {
                AlipayXuiIslandVisibility alipayXuiIslandVisibility = INSTANCE;
                kotlin.jvm.internal.p.f(card);
                if (alipayXuiIslandVisibility.A(card, taskId)) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Card) it.next()).getLiveId());
        }
        for (String str : Z8.F.g0(arrayList2)) {
            cards.remove(str);
            suppressed.remove(str);
            records.remove(str);
            L(str);
            reopenOnLeave.remove(str);
            i(str, live);
        }
    }

    public final void T(Set<String> ids) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.b(Boolean.valueOf(C5009a.INSTANCE.H(MMKV_ID, INDEX_KEY, Z8.F.A0(ids, "\n", null, null, 0, null, null, 62, null))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final String U(String liveId) {
        String sessionId;
        kotlin.jvm.internal.p.i(liveId, "liveId");
        Card card = cards.get(liveId);
        if (card == null || (sessionId = card.getSessionId()) == null || La.H.x0(sessionId)) {
            return null;
        }
        return sessionId;
    }

    public final void V(ILiveNotificationService live) {
        Set<String> setKeySet = cards.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        for (String str : Z8.F.m1(setKeySet)) {
            Card card = cards.get(str);
            if (card != null) {
                if (AlipayXuiIsland.INSTANCE.n(Integer.valueOf(card.getRawStatus()))) {
                    u(live, card);
                } else {
                    o(str, live, "enterAlipay");
                }
            }
        }
    }

    public final Card W(Card card) {
        AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
        AlipayXuiIsland.Phase phaseK = alipayXuiIsland.k(Integer.valueOf(card.getRawStatus()));
        return Card.copy$default(card, null, null, null, null, null, null, null, 0, phaseK != null && alipayXuiIsland.h(phaseK), false, 255, null);
    }

    public final boolean X(ILiveNotificationService live, Card card) {
        String str;
        String str2;
        kotlin.jvm.internal.p.i(live, "live");
        kotlin.jvm.internal.p.i(card, "card");
        if (live.isPosted(card.getLiveId())) {
            acknowledged.add(card.getLiveId());
        } else {
            if (suppressed.containsKey(card.getLiveId()) || v(card.getTaskId())) {
                u(live, card);
                return true;
            }
            if (!cards.containsKey(card.getLiveId())) {
                H.INSTANCE.a(card.getTaskId());
                return false;
            }
            if (B(live, card.getLiveId())) {
                o(card.getLiveId(), live, "gone");
                return false;
            }
        }
        Record record = records.get(card.getLiveId());
        Card card2 = record != null ? record.getCard() : null;
        Card card3 = card2 == null ? card : card2;
        String title = card.getTitle();
        String content = card.getContent();
        String status = card.getStatus();
        String appLink = card.getAppLink();
        if (appLink != null) {
            str = appLink;
        } else if (card2 != null) {
            appLink = card2.getAppLink();
            str = appLink;
        } else {
            str = null;
        }
        String sessionId = card.getSessionId();
        if (sessionId != null) {
            str2 = sessionId;
        } else if (card2 != null) {
            sessionId = card2.getSessionId();
            str2 = sessionId;
        } else {
            str2 = null;
        }
        Card cardCopy$default = Card.copy$default(card3, null, title, content, status, str, str2, null, 0, card.getMedium(), card2 != null ? card2.getFloatOverlay() : false, 193, null);
        cards.put(card.getLiveId(), cardCopy$default);
        J(new Record(cardCopy$default, record != null ? record.getCollapseAt() : null, false, 4, null));
        G(live, cardCopy$default, cardCopy$default.getFloatOverlay(), "text");
        return true;
    }

    public final void f(final String liveId, long now) {
        Record record;
        Long collapseAt;
        Handler handler = mainHandler;
        if (handler == null || (record = records.get(liveId)) == null || (collapseAt = record.getCollapseAt()) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.J
            @Override // java.lang.Runnable
            public final void run() {
                AlipayXuiIslandVisibility.g(liveId);
            }
        }, C5685n.g(collapseAt.longValue() - now, 0L));
    }

    public final void h(String liveId, String sessionId) {
        String liveId2 = liveId;
        kotlin.jvm.internal.p.i(liveId2, "liveId");
        if (La.H.x0(liveId2)) {
            liveId2 = null;
        }
        if (liveId2 == null || sessionId == null) {
            return;
        }
        String str = !La.H.x0(sessionId) ? sessionId : null;
        if (str == null) {
            return;
        }
        ConcurrentHashMap<String, Card> concurrentHashMap = cards;
        Card card = concurrentHashMap.get(liveId2);
        ConcurrentHashMap<String, Card> concurrentHashMap2 = suppressed;
        Card card2 = concurrentHashMap2.get(liveId2);
        if (card != null) {
            card2 = card;
        } else if (card2 == null) {
            return;
        }
        String sessionId2 = card2.getSessionId();
        if (sessionId2 == null || La.H.x0(sessionId2)) {
            Card cardCopy$default = Card.copy$default(card2, null, null, null, null, null, str, null, 0, false, false, 991, null);
            if (card != null) {
                concurrentHashMap.put(liveId2, cardCopy$default);
            } else {
                concurrentHashMap2.put(liveId2, cardCopy$default);
            }
            Record record = records.get(liveId2);
            if (record != null) {
                INSTANCE.J(Record.copy$default(record, cardCopy$default, null, false, 6, null));
            }
        }
    }

    public final void i(String liveId, ILiveNotificationService live) {
        if (live != null) {
            live.cancel(liveId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.Card j(com.stepos.ailauncher.foundation.appui.card.provider.alipay.H.Memory r15, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.Card r16) {
        /*
            r14 = this;
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland r14 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland.INSTANCE
            int r0 = r15.getStatus()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$Phase r0 = r14.k(r0)
            r1 = 0
            if (r16 == 0) goto L24
            java.lang.String r2 = r16.getTaskId()
            if (r2 == 0) goto L24
            boolean r3 = La.H.x0(r2)
            if (r3 != 0) goto L1e
            goto L1f
        L1e:
            r2 = r1
        L1f:
            if (r2 != 0) goto L22
            goto L24
        L22:
            r10 = r2
            goto L31
        L24:
            java.lang.String r2 = r15.getLiveId()
            java.lang.String r2 = r14.o(r2)
            if (r2 != 0) goto L22
            java.lang.String r2 = ""
            goto L22
        L31:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card r3 = new com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card
            java.lang.String r4 = r15.getLiveId()
            java.lang.String r5 = r15.getTitle()
            java.lang.String r6 = r15.getContent()
            int r2 = r15.getStatus()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r7 = r14.g(r2)
            if (r16 == 0) goto L53
            java.lang.String r2 = r16.getAppLink()
            r8 = r2
            goto L54
        L53:
            r8 = r1
        L54:
            if (r16 == 0) goto L5a
            java.lang.String r1 = r16.getSessionId()
        L5a:
            r9 = r1
            int r11 = r15.getStatus()
            if (r0 == 0) goto L6a
            boolean r14 = r14.h(r0)
            if (r14 == 0) goto L6a
            r14 = 1
        L68:
            r12 = r14
            goto L6c
        L6a:
            r14 = 0
            goto L68
        L6c:
            r13 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.j(com.stepos.ailauncher.foundation.appui.card.provider.alipay.H$a, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card):com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card");
    }

    public final void k(String liveId, ILiveNotificationService live) {
        Record record = records.get(liveId);
        if (record == null || record.getCollapseAt() == null) {
            return;
        }
        Record recordCopy$default = Record.copy$default(record, Card.copy$default(record.getCard(), null, null, null, null, null, null, null, 0, false, false, 511, null), null, false, 4, null);
        J(recordCopy$default);
        cards.put(liveId, recordCopy$default.getCard());
        if (live == null || !live.isPosted(liveId)) {
            return;
        }
        G(live, recordCopy$default.getCard(), false, "collapse");
    }

    public final void l(String liveId, ILiveNotificationService live, String reason) {
        kotlin.jvm.internal.p.i(liveId, "liveId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (La.H.x0(liveId)) {
            liveId = null;
        }
        if (liveId == null) {
            return;
        }
        o(liveId, live, reason);
    }

    public final void n(String taskId, ILiveNotificationService live) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(taskId)) {
            return;
        }
        Collection<Card> collectionValues = cards.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Collection<Card> collectionValues2 = suppressed.values();
        kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
        List listS0 = Z8.F.S0(collectionValues, collectionValues2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            Card card = (Card) obj;
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = INSTANCE;
            kotlin.jvm.internal.p.f(card);
            if (alipayXuiIslandVisibility.A(card, taskId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Card) it.next()).getLiveId());
        }
        Iterator it2 = Z8.F.g0(arrayList2).iterator();
        while (it2.hasNext()) {
            o((String) it2.next(), live, "replace");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(java.lang.String r5, com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService r6, java.lang.String r7) {
        /*
            r4 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card> r0 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.cards
            java.lang.Object r0 = r0.remove(r5)
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card r0 = (com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.Card) r0
            if (r0 != 0) goto L12
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card> r0 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.suppressed
            java.lang.Object r0 = r0.remove(r5)
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card r0 = (com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.Card) r0
        L12:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.suppressed
            r1.remove(r5)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Record> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.records
            r1.remove(r5)
            java.util.concurrent.ConcurrentHashMap$KeySetView<java.lang.String, java.lang.Boolean> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.acknowledged
            r1.remove(r5)
            r4.L(r5)
            if (r0 == 0) goto L4c
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland.INSTANCE
            int r2 = r0.getRawStatus()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r1 = r1.n(r2)
            if (r1 == 0) goto L4c
            java.util.Set<java.lang.String> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.REOPEN_REASONS
            boolean r1 = r1.contains(r7)
            if (r1 == 0) goto L4c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.reopenOnLeave
            java.lang.String r2 = r0.getLiveId()
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card r3 = r4.W(r0)
            r1.put(r2, r3)
            goto L51
        L4c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility$Card> r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.reopenOnLeave
            r1.remove(r5)
        L51:
            if (r0 == 0) goto L63
            java.lang.String r0 = r0.getTaskId()
            if (r0 == 0) goto L63
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L60
            goto L61
        L60:
            r0 = 0
        L61:
            if (r0 != 0) goto L69
        L63:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland r0 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland.INSTANCE
            java.lang.String r0 = r0.o(r5)
        L69:
            if (r0 == 0) goto L77
            boolean r1 = La.H.x0(r0)
            if (r1 == 0) goto L72
            goto L77
        L72:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.H r1 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.H.INSTANCE
            r1.a(r0)
        L77:
            r4.i(r5, r6)
            R5.b r6 = R5.b.INSTANCE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "binder.island."
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "liveId"
            kotlin.Pair r5 = Y8.j.a(r0, r5)
            kotlin.Pair[] r5 = new kotlin.Pair[]{r5}
            r6.c(r7, r5)
            r4.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.o(java.lang.String, com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService, java.lang.String):void");
    }

    public final void p() {
        if (!switchHooked) {
            switchHooked = true;
            try {
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.common.utils.r.INSTANCE.o(leaveListener);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        Handler handler = mainHandler;
        if (handler == null) {
            return;
        }
        Runnable runnable = watchRunnable;
        handler.removeCallbacks(runnable);
        if (cards.isEmpty() && suppressed.isEmpty()) {
            return;
        }
        handler.postDelayed(runnable, 1000L);
    }

    public final void q(String taskId, int status, String title, String content, ILiveNotificationService live) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        if (La.H.x0(taskId) || AlipayXuiIsland.INSTANCE.n(Integer.valueOf(status))) {
            return;
        }
        n(taskId, live);
        ConcurrentHashMap<String, Card> concurrentHashMap = reopenOnLeave;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Card> entry : concurrentHashMap.entrySet()) {
            if (INSTANCE.A(entry.getValue(), taskId)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : Z8.F.m1(linkedHashMap.keySet())) {
            reopenOnLeave.remove(str);
            i(str, live);
        }
        H.INSTANCE.f(taskId, status, title, content, AlipayXuiIsland.INSTANCE.f(taskId, status));
    }

    public final void r(String liveId, String chatSessionId, ILiveNotificationService live) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (liveId != null) {
            if (La.H.x0(liveId)) {
                liveId = null;
            }
            if (liveId != null) {
                linkedHashSet.add(liveId);
            }
        }
        if (chatSessionId != null) {
            if (La.H.x0(chatSessionId)) {
                chatSessionId = null;
            }
            if (chatSessionId != null) {
                Collection<Card> collectionValues = cards.values();
                kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
                Collection<Card> collectionValues2 = suppressed.values();
                kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
                for (Object obj : Z8.F.S0(collectionValues, collectionValues2)) {
                    kotlin.jvm.internal.p.h(obj, "next(...)");
                    Card card = (Card) obj;
                    if (kotlin.jvm.internal.p.d(card.getSessionId(), chatSessionId)) {
                        linkedHashSet.add(card.getLiveId());
                    }
                }
            }
        }
        Iterator it = linkedHashSet.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            o((String) next, live, "forgetSession");
        }
    }

    public final void t(String liveId) {
        Set<String> setQ1 = Z8.F.q1(z());
        if (setQ1.remove(liveId)) {
            T(setQ1);
        }
    }

    public final void u(ILiveNotificationService live, Card card) {
        kotlin.jvm.internal.p.i(card, "card");
        if (AlipayXuiIsland.INSTANCE.n(Integer.valueOf(card.getRawStatus())) && !La.H.x0(card.getTaskId())) {
            Card cardW = W(card);
            S(cardW.getTaskId(), cardW.getLiveId(), live);
            ConcurrentHashMap<String, Card> concurrentHashMap = cards;
            if (concurrentHashMap.containsKey(cardW.getLiveId())) {
                i(cardW.getLiveId(), live);
                concurrentHashMap.remove(cardW.getLiveId());
            }
            acknowledged.remove(cardW.getLiveId());
            reopenOnLeave.remove(cardW.getLiveId());
            suppressed.put(cardW.getLiveId(), cardW);
            J(new Record(cardW, null, true));
            p();
        }
    }

    public final boolean v(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Collection<Card> collectionValues = suppressed.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Collection<Card> collection = collectionValues;
        if (collection.isEmpty()) {
            return false;
        }
        for (Card card : collection) {
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = INSTANCE;
            kotlin.jvm.internal.p.f(card);
            if (alipayXuiIslandVisibility.A(card, taskId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Record> y() {
        Object objB;
        Record recordB;
        Set<String> setZ = z();
        ArrayList arrayList = new ArrayList();
        for (String str : setZ) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(C5009a.v(C5009a.INSTANCE, MMKV_ID, str, null, 4, null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            String str2 = (String) objB;
            if (str2 != null) {
                try {
                    recordB = Result.b((Record) N5.k.INSTANCE.b().fromJson(str2, Record.class));
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    recordB = Result.b(C4849c.a(th2));
                }
                record = Result.g(recordB) ? null : recordB;
            }
            if (record != null) {
                arrayList.add(record);
            }
        }
        return arrayList;
    }

    public final Set<String> z() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C5009a.v(C5009a.INSTANCE, MMKV_ID, INDEX_KEY, null, 4, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        List listA1 = La.H.a1(str, new char[]{'\n'}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA1) {
            if (!La.H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return Z8.F.r1(arrayList);
    }

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Record;", "", "card", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", "collapseAt", "", "suppressed", "", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;Ljava/lang/Long;Z)V", "getCard", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", "getCollapseAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSuppressed", "()Z", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;Ljava/lang/Long;Z)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Record;", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Record {
        private final Card card;
        private final Long collapseAt;
        private final boolean suppressed;

        public Record(Card card, Long l10, boolean z10) {
            kotlin.jvm.internal.p.i(card, "card");
            this.card = card;
            this.collapseAt = l10;
            this.suppressed = z10;
        }

        public static /* synthetic */ Record copy$default(Record record, Card card, Long l10, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                card = record.card;
            }
            if ((i10 & 2) != 0) {
                l10 = record.collapseAt;
            }
            if ((i10 & 4) != 0) {
                z10 = record.suppressed;
            }
            return record.copy(card, l10, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final Card getCard() {
            return this.card;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getCollapseAt() {
            return this.collapseAt;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSuppressed() {
            return this.suppressed;
        }

        public final Record copy(Card card, Long collapseAt, boolean suppressed) {
            kotlin.jvm.internal.p.i(card, "card");
            return new Record(card, collapseAt, suppressed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Record)) {
                return false;
            }
            Record record = (Record) other;
            return kotlin.jvm.internal.p.d(this.card, record.card) && kotlin.jvm.internal.p.d(this.collapseAt, record.collapseAt) && this.suppressed == record.suppressed;
        }

        public final Card getCard() {
            return this.card;
        }

        public final Long getCollapseAt() {
            return this.collapseAt;
        }

        public final boolean getSuppressed() {
            return this.suppressed;
        }

        public int hashCode() {
            int iHashCode = this.card.hashCode() * 31;
            Long l10 = this.collapseAt;
            return ((iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31) + Boolean.hashCode(this.suppressed);
        }

        public String toString() {
            return "Record(card=" + this.card + ", collapseAt=" + this.collapseAt + ", suppressed=" + this.suppressed + ")";
        }

        public /* synthetic */ Record(Card card, Long l10, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(card, l10, (i10 & 4) != 0 ? false : z10);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIslandVisibility$Card;", "", "liveId", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "status", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "sessionId", "taskId", "rawStatus", "", "medium", "", "floatOverlay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZ)V", "getLiveId", "()Ljava/lang/String;", "getTitle", "getContent", "getStatus", "getAppLink", "getSessionId", "getTaskId", "getRawStatus", "()I", "getMedium", "()Z", "getFloatOverlay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Card {
        private final String appLink;
        private final String content;
        private final boolean floatOverlay;
        private final String liveId;
        private final boolean medium;
        private final int rawStatus;
        private final String sessionId;
        private final String status;
        private final String taskId;
        private final String title;

        public Card(String liveId, String title, String content, String status, String str, String str2, String taskId, int i10, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(liveId, "liveId");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(status, "status");
            kotlin.jvm.internal.p.i(taskId, "taskId");
            this.liveId = liveId;
            this.title = title;
            this.content = content;
            this.status = status;
            this.appLink = str;
            this.sessionId = str2;
            this.taskId = taskId;
            this.rawStatus = i10;
            this.medium = z10;
            this.floatOverlay = z11;
        }

        public static /* synthetic */ Card copy$default(Card card, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, boolean z10, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = card.liveId;
            }
            if ((i11 & 2) != 0) {
                str2 = card.title;
            }
            if ((i11 & 4) != 0) {
                str3 = card.content;
            }
            if ((i11 & 8) != 0) {
                str4 = card.status;
            }
            if ((i11 & 16) != 0) {
                str5 = card.appLink;
            }
            if ((i11 & 32) != 0) {
                str6 = card.sessionId;
            }
            if ((i11 & 64) != 0) {
                str7 = card.taskId;
            }
            if ((i11 & 128) != 0) {
                i10 = card.rawStatus;
            }
            if ((i11 & 256) != 0) {
                z10 = card.medium;
            }
            if ((i11 & 512) != 0) {
                z11 = card.floatOverlay;
            }
            boolean z12 = z10;
            boolean z13 = z11;
            String str8 = str7;
            int i12 = i10;
            String str9 = str5;
            String str10 = str6;
            return card.copy(str, str2, str3, str4, str9, str10, str8, i12, z12, z13);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLiveId() {
            return this.liveId;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getFloatOverlay() {
            return this.floatOverlay;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component4, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component5, reason: from getter */
        public final String getAppLink() {
            return this.appLink;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component8, reason: from getter */
        public final int getRawStatus() {
            return this.rawStatus;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getMedium() {
            return this.medium;
        }

        public final Card copy(String liveId, String title, String content, String status, String appLink, String sessionId, String taskId, int rawStatus, boolean medium, boolean floatOverlay) {
            kotlin.jvm.internal.p.i(liveId, "liveId");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(status, "status");
            kotlin.jvm.internal.p.i(taskId, "taskId");
            return new Card(liveId, title, content, status, appLink, sessionId, taskId, rawStatus, medium, floatOverlay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Card)) {
                return false;
            }
            Card card = (Card) other;
            return kotlin.jvm.internal.p.d(this.liveId, card.liveId) && kotlin.jvm.internal.p.d(this.title, card.title) && kotlin.jvm.internal.p.d(this.content, card.content) && kotlin.jvm.internal.p.d(this.status, card.status) && kotlin.jvm.internal.p.d(this.appLink, card.appLink) && kotlin.jvm.internal.p.d(this.sessionId, card.sessionId) && kotlin.jvm.internal.p.d(this.taskId, card.taskId) && this.rawStatus == card.rawStatus && this.medium == card.medium && this.floatOverlay == card.floatOverlay;
        }

        public final String getAppLink() {
            return this.appLink;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean getFloatOverlay() {
            return this.floatOverlay;
        }

        public final String getLiveId() {
            return this.liveId;
        }

        public final boolean getMedium() {
            return this.medium;
        }

        public final int getRawStatus() {
            return this.rawStatus;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = ((((((this.liveId.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.status.hashCode()) * 31;
            String str = this.appLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sessionId;
            return ((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.taskId.hashCode()) * 31) + Integer.hashCode(this.rawStatus)) * 31) + Boolean.hashCode(this.medium)) * 31) + Boolean.hashCode(this.floatOverlay);
        }

        public String toString() {
            return "Card(liveId=" + this.liveId + ", title=" + this.title + ", content=" + this.content + ", status=" + this.status + ", appLink=" + this.appLink + ", sessionId=" + this.sessionId + ", taskId=" + this.taskId + ", rawStatus=" + this.rawStatus + ", medium=" + this.medium + ", floatOverlay=" + this.floatOverlay + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Card(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, boolean r22, boolean r23, int r24, kotlin.jvm.internal.i r25) {
            /*
                r13 = this;
                r0 = r24
                r1 = r0 & 64
                if (r1 == 0) goto La
                java.lang.String r1 = ""
                r9 = r1
                goto Lc
            La:
                r9 = r20
            Lc:
                r1 = r0 & 128(0x80, float:1.8E-43)
                r2 = 0
                if (r1 == 0) goto L13
                r10 = r2
                goto L15
            L13:
                r10 = r21
            L15:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L1b
                r11 = r2
                goto L1d
            L1b:
                r11 = r22
            L1d:
                r0 = r0 & 512(0x200, float:7.17E-43)
                if (r0 == 0) goto L2e
                r12 = r2
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r8 = r19
                r2 = r13
                goto L3b
            L2e:
                r12 = r23
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r8 = r19
            L3b:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility.Card.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, boolean, int, kotlin.jvm.internal.i):void");
        }
    }
}
