package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;
import v9.C5680i;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b8\b\u0080\b\u0018\u00002\u00020\u0001:\u00041@n<B³\u0003\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0%\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b/\u00100J¼\u0003\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00042\b\b\u0003\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0%2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0000HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010;\u001a\u0004\b<\u00104R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u00106R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010;\u001a\u0004\bB\u00104R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010;\u001a\u0004\bC\u00104R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010;\u001a\u0004\bD\u00104R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010;\u001a\u0004\bE\u00104R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\b=\u00104R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\bF\u00104R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\bG\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010;\u001a\u0004\bH\u00104R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\bI\u00104R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010=\u001a\u0004\bJ\u00106R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010=\u001a\u0004\bK\u00106R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010;\u001a\u0004\bL\u00104R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010;\u001a\u0004\bP\u00104R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\bQ\u00104R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010;\u001a\u0004\bR\u00104R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010;\u001a\u0004\bS\u00104R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010;\u001a\u0004\bW\u00104R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010;\u001a\u0004\bX\u00104R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010;\u001a\u0004\bY\u00104R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\bZ\u00104R\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b[\u00104R\u0019\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010T\u001a\u0004\b\\\u0010VR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b]\u00104R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b^\u00104R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b$\u0010;\u001a\u0004\b_\u00104R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006¢\u0006\f\n\u0004\b'\u0010`\u001a\u0004\ba\u0010bR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0%8\u0006¢\u0006\f\n\u0004\b)\u0010`\u001a\u0004\bc\u0010bR\u0019\u0010*\u001a\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b*\u0010d\u001a\u0004\be\u0010fR\u0019\u0010,\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b,\u0010g\u001a\u0004\bh\u0010iR\u0019\u0010-\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b-\u0010g\u001a\u0004\bj\u0010iR\u0019\u0010.\u001a\u0004\u0018\u00010\u00008\u0006¢\u0006\f\n\u0004\b.\u0010k\u001a\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "LN5/n;", "", "cardId", "", "status", "", "activeMatching", "vendorPkg", "bizChannel", "sessionId", "messageId", "toolCallId", "requestTraceId", "clientRenderSource", "orderNo", "platformOrderId", "vendorFallbackIconRes", "vendorHighlightColorRes", "storeName", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;", "app", "backendInstallState", "authTitle", "authSubtitle", "title", "Lv9/i;", "titleHighlight", "titleTrailing", "routeText", "noteText", "summaryText", "plateTitle", "plateTitleHighlight", "plateSubtitle", "carImageUrl", "disclaimer", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$c;", "carTypes", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "infoRows", "ctaRow", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "primaryAction", "secondaryAction", "installGate", "<init>", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv9/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv9/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv9/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv9/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "C", "Z", Const.INTENT_KEY_UMID, "()Z", "L", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "B", "q", "y", "l", "s", "w", "J", "K", "D", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;", "e", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "F", "Lv9/i;", "G", "()Lv9/i;", "H", "z", "r", ExifInterface.LONGITUDE_EAST, "u", "v", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "n", "Ljava/util/List;", "k", "()Ljava/util/List;", "o", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "m", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "x", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "p", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.y, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiCardModel extends N5.n {
    private final boolean activeMatching;
    private final AppItem app;
    private final String authSubtitle;
    private final String authTitle;
    private final String backendInstallState;
    private final String bizChannel;
    private final String carImageUrl;
    private final List<CarTypeItem> carTypes;
    private final String cardId;
    private final String clientRenderSource;
    private final InfoRow ctaRow;
    private final String disclaimer;
    private final List<InfoRow> infoRows;
    private final DidiCardModel installGate;
    private final String messageId;
    private final String noteText;
    private final String orderNo;
    private final String plateSubtitle;
    private final String plateTitle;
    private final C5680i plateTitleHighlight;
    private final String platformOrderId;
    private final ActionItem primaryAction;
    private final String requestTraceId;
    private final String routeText;
    private final ActionItem secondaryAction;
    private final String sessionId;
    private final int status;
    private final String storeName;
    private final String summaryText;
    private final String title;
    private final C5680i titleHighlight;
    private final String titleTrailing;
    private final String toolCallId;
    private final int vendorFallbackIconRes;
    private final int vendorHighlightColorRes;
    private final String vendorPkg;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\b\u0080\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J¶\u0001\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b#\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b%\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b&\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b*\u0010\u0019R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b+\u0010)R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b,\u0010)R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b-\u0010\u0019R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b.\u0010\u0019R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b/\u0010\u0019R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b0\u0010\u0019R\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b1\u0010)¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "", "", "label", "", "backgroundRes", "textColorRes", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "intentPackage", "", "sendsChatReply", "chatReplyText", "localDismiss", "localDim", "launchPackage", "fallbackLaunchPackage", "storeLink", "storeLinkPackage", "showLoading", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", Const.INTENT_KEY_UMID, "p", "c", "q", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "l", "()Z", "e", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "n", "o", "m", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a, reason: from toString */
    public static final /* data */ class ActionItem {
        private final String appLink;
        private final int backgroundRes;
        private final String chatReplyText;
        private final String fallbackLaunchPackage;
        private final String intentPackage;
        private final String label;
        private final String launchPackage;
        private final boolean localDim;
        private final boolean localDismiss;
        private final boolean sendsChatReply;
        private final boolean showLoading;
        private final String storeLink;
        private final String storeLinkPackage;
        private final int textColorRes;
        private final String webLink;

        public ActionItem(String label, int i10, int i11, String str, String str2, String str3, boolean z10, String str4, boolean z11, boolean z12, String str5, String str6, String str7, String str8, boolean z13) {
            kotlin.jvm.internal.p.i(label, "label");
            this.label = label;
            this.backgroundRes = i10;
            this.textColorRes = i11;
            this.appLink = str;
            this.webLink = str2;
            this.intentPackage = str3;
            this.sendsChatReply = z10;
            this.chatReplyText = str4;
            this.localDismiss = z11;
            this.localDim = z12;
            this.launchPackage = str5;
            this.fallbackLaunchPackage = str6;
            this.storeLink = str7;
            this.storeLinkPackage = str8;
            this.showLoading = z13;
        }

        public final ActionItem a(String label, int backgroundRes, int textColorRes, String appLink, String webLink, String intentPackage, boolean sendsChatReply, String chatReplyText, boolean localDismiss, boolean localDim, String launchPackage, String fallbackLaunchPackage, String storeLink, String storeLinkPackage, boolean showLoading) {
            kotlin.jvm.internal.p.i(label, "label");
            return new ActionItem(label, backgroundRes, textColorRes, appLink, webLink, intentPackage, sendsChatReply, chatReplyText, localDismiss, localDim, launchPackage, fallbackLaunchPackage, storeLink, storeLinkPackage, showLoading);
        }

        /* renamed from: c, reason: from getter */
        public final String getAppLink() {
            return this.appLink;
        }

        /* renamed from: d, reason: from getter */
        public final int getBackgroundRes() {
            return this.backgroundRes;
        }

        /* renamed from: e, reason: from getter */
        public final String getChatReplyText() {
            return this.chatReplyText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionItem)) {
                return false;
            }
            ActionItem actionItem = (ActionItem) other;
            return kotlin.jvm.internal.p.d(this.label, actionItem.label) && this.backgroundRes == actionItem.backgroundRes && this.textColorRes == actionItem.textColorRes && kotlin.jvm.internal.p.d(this.appLink, actionItem.appLink) && kotlin.jvm.internal.p.d(this.webLink, actionItem.webLink) && kotlin.jvm.internal.p.d(this.intentPackage, actionItem.intentPackage) && this.sendsChatReply == actionItem.sendsChatReply && kotlin.jvm.internal.p.d(this.chatReplyText, actionItem.chatReplyText) && this.localDismiss == actionItem.localDismiss && this.localDim == actionItem.localDim && kotlin.jvm.internal.p.d(this.launchPackage, actionItem.launchPackage) && kotlin.jvm.internal.p.d(this.fallbackLaunchPackage, actionItem.fallbackLaunchPackage) && kotlin.jvm.internal.p.d(this.storeLink, actionItem.storeLink) && kotlin.jvm.internal.p.d(this.storeLinkPackage, actionItem.storeLinkPackage) && this.showLoading == actionItem.showLoading;
        }

        /* renamed from: f, reason: from getter */
        public final String getFallbackLaunchPackage() {
            return this.fallbackLaunchPackage;
        }

        /* renamed from: g, reason: from getter */
        public final String getIntentPackage() {
            return this.intentPackage;
        }

        /* renamed from: h, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        public int hashCode() {
            int iHashCode = ((((this.label.hashCode() * 31) + Integer.hashCode(this.backgroundRes)) * 31) + Integer.hashCode(this.textColorRes)) * 31;
            String str = this.appLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.webLink;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.intentPackage;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.sendsChatReply)) * 31;
            String str4 = this.chatReplyText;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.localDismiss)) * 31) + Boolean.hashCode(this.localDim)) * 31;
            String str5 = this.launchPackage;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.fallbackLaunchPackage;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.storeLink;
            int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.storeLinkPackage;
            return ((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + Boolean.hashCode(this.showLoading);
        }

        /* renamed from: i, reason: from getter */
        public final String getLaunchPackage() {
            return this.launchPackage;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getLocalDim() {
            return this.localDim;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getLocalDismiss() {
            return this.localDismiss;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getSendsChatReply() {
            return this.sendsChatReply;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getShowLoading() {
            return this.showLoading;
        }

        /* renamed from: n, reason: from getter */
        public final String getStoreLink() {
            return this.storeLink;
        }

        /* renamed from: o, reason: from getter */
        public final String getStoreLinkPackage() {
            return this.storeLinkPackage;
        }

        /* renamed from: p, reason: from getter */
        public final int getTextColorRes() {
            return this.textColorRes;
        }

        /* renamed from: q, reason: from getter */
        public final String getWebLink() {
            return this.webLink;
        }

        public String toString() {
            return "ActionItem(label=" + this.label + ", backgroundRes=" + this.backgroundRes + ", textColorRes=" + this.textColorRes + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ", intentPackage=" + this.intentPackage + ", sendsChatReply=" + this.sendsChatReply + ", chatReplyText=" + this.chatReplyText + ", localDismiss=" + this.localDismiss + ", localDim=" + this.localDim + ", launchPackage=" + this.launchPackage + ", fallbackLaunchPackage=" + this.fallbackLaunchPackage + ", storeLink=" + this.storeLink + ", storeLinkPackage=" + this.storeLinkPackage + ", showLoading=" + this.showLoading + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;", "", "", "name", "iconUrl", "sizeText", "extraText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.y$b, reason: from toString */
    public static final /* data */ class AppItem {
        private final String extraText;
        private final String iconUrl;
        private final String name;
        private final String sizeText;

        public AppItem() {
            this(null, null, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getExtraText() {
            return this.extraText;
        }

        /* renamed from: b, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final String getSizeText() {
            return this.sizeText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppItem)) {
                return false;
            }
            AppItem appItem = (AppItem) other;
            return kotlin.jvm.internal.p.d(this.name, appItem.name) && kotlin.jvm.internal.p.d(this.iconUrl, appItem.iconUrl) && kotlin.jvm.internal.p.d(this.sizeText, appItem.sizeText) && kotlin.jvm.internal.p.d(this.extraText, appItem.extraText);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.iconUrl;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sizeText;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.extraText;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "AppItem(name=" + this.name + ", iconUrl=" + this.iconUrl + ", sizeText=" + this.sizeText + ", extraText=" + this.extraText + ")";
        }

        public AppItem(String str, String str2, String str3, String str4) {
            this.name = str;
            this.iconUrl = str2;
            this.sizeText = str3;
            this.extraText = str4;
        }

        public /* synthetic */ AppItem(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$c;", "", "", "id", "name", "priceText", "", "priceValue", "originPriceText", "imageUrl", "", "selectedByDefault", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "e", "Ljava/lang/Double;", "f", "()Ljava/lang/Double;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.y$c, reason: from toString */
    public static final /* data */ class CarTypeItem {
        private final String id;
        private final String imageUrl;
        private final String name;
        private final String originPriceText;
        private final String priceText;
        private final Double priceValue;
        private final boolean selectedByDefault;

        public CarTypeItem(String id, String str, String str2, Double d10, String str3, String str4, boolean z10) {
            kotlin.jvm.internal.p.i(id, "id");
            this.id = id;
            this.name = str;
            this.priceText = str2;
            this.priceValue = d10;
            this.originPriceText = str3;
            this.imageUrl = str4;
            this.selectedByDefault = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final String getOriginPriceText() {
            return this.originPriceText;
        }

        /* renamed from: e, reason: from getter */
        public final String getPriceText() {
            return this.priceText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CarTypeItem)) {
                return false;
            }
            CarTypeItem carTypeItem = (CarTypeItem) other;
            return kotlin.jvm.internal.p.d(this.id, carTypeItem.id) && kotlin.jvm.internal.p.d(this.name, carTypeItem.name) && kotlin.jvm.internal.p.d(this.priceText, carTypeItem.priceText) && kotlin.jvm.internal.p.d(this.priceValue, carTypeItem.priceValue) && kotlin.jvm.internal.p.d(this.originPriceText, carTypeItem.originPriceText) && kotlin.jvm.internal.p.d(this.imageUrl, carTypeItem.imageUrl) && this.selectedByDefault == carTypeItem.selectedByDefault;
        }

        /* renamed from: f, reason: from getter */
        public final Double getPriceValue() {
            return this.priceValue;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getSelectedByDefault() {
            return this.selectedByDefault;
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.priceText;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Double d10 = this.priceValue;
            int iHashCode4 = (iHashCode3 + (d10 == null ? 0 : d10.hashCode())) * 31;
            String str3 = this.originPriceText;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.imageUrl;
            return ((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.selectedByDefault);
        }

        public String toString() {
            return "CarTypeItem(id=" + this.id + ", name=" + this.name + ", priceText=" + this.priceText + ", priceValue=" + this.priceValue + ", originPriceText=" + this.originPriceText + ", imageUrl=" + this.imageUrl + ", selectedByDefault=" + this.selectedByDefault + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "", "", "label", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.y$d, reason: from toString */
    public static final /* data */ class InfoRow {
        private final String label;
        private final String value;

        public InfoRow(String label, String value) {
            kotlin.jvm.internal.p.i(label, "label");
            kotlin.jvm.internal.p.i(value, "value");
            this.label = label;
            this.value = value;
        }

        /* renamed from: a, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: b, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InfoRow)) {
                return false;
            }
            InfoRow infoRow = (InfoRow) other;
            return kotlin.jvm.internal.p.d(this.label, infoRow.label) && kotlin.jvm.internal.p.d(this.value, infoRow.value);
        }

        public int hashCode() {
            return (this.label.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "InfoRow(label=" + this.label + ", value=" + this.value + ")";
        }
    }

    public DidiCardModel() {
        this(null, 0, false, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 15, null);
    }

    public static /* synthetic */ DidiCardModel c(DidiCardModel didiCardModel, String str, int i10, boolean z10, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i11, int i12, String str11, AppItem appItem, String str12, String str13, String str14, String str15, C5680i c5680i, String str16, String str17, String str18, String str19, String str20, C5680i c5680i2, String str21, String str22, String str23, List list, List list2, InfoRow infoRow, ActionItem actionItem, ActionItem actionItem2, DidiCardModel didiCardModel2, int i13, int i14, Object obj) {
        DidiCardModel didiCardModel3;
        ActionItem actionItem3;
        String str24;
        C5680i c5680i3;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        C5680i c5680i4;
        String str30;
        String str31;
        String str32;
        List list3;
        List list4;
        InfoRow infoRow2;
        ActionItem actionItem4;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        int i15;
        int i16;
        AppItem appItem2;
        String str42;
        String str43;
        String str44;
        int i17;
        boolean z11;
        String str45;
        String str46 = (i13 & 1) != 0 ? didiCardModel.cardId : str;
        int i18 = (i13 & 2) != 0 ? didiCardModel.status : i10;
        boolean z12 = (i13 & 4) != 0 ? didiCardModel.activeMatching : z10;
        String str47 = (i13 & 8) != 0 ? didiCardModel.vendorPkg : str2;
        String str48 = (i13 & 16) != 0 ? didiCardModel.bizChannel : str3;
        String str49 = (i13 & 32) != 0 ? didiCardModel.sessionId : str4;
        String str50 = (i13 & 64) != 0 ? didiCardModel.messageId : str5;
        String str51 = (i13 & 128) != 0 ? didiCardModel.toolCallId : str6;
        String str52 = (i13 & 256) != 0 ? didiCardModel.requestTraceId : str7;
        String str53 = (i13 & 512) != 0 ? didiCardModel.clientRenderSource : str8;
        String str54 = (i13 & 1024) != 0 ? didiCardModel.orderNo : str9;
        String str55 = (i13 & 2048) != 0 ? didiCardModel.platformOrderId : str10;
        int i19 = (i13 & 4096) != 0 ? didiCardModel.vendorFallbackIconRes : i11;
        int i20 = (i13 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? didiCardModel.vendorHighlightColorRes : i12;
        String str56 = str46;
        String str57 = (i13 & 16384) != 0 ? didiCardModel.storeName : str11;
        AppItem appItem3 = (i13 & 32768) != 0 ? didiCardModel.app : appItem;
        String str58 = (i13 & 65536) != 0 ? didiCardModel.backendInstallState : str12;
        String str59 = (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? didiCardModel.authTitle : str13;
        String str60 = (i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? didiCardModel.authSubtitle : str14;
        String str61 = (i13 & 524288) != 0 ? didiCardModel.title : str15;
        C5680i c5680i5 = (i13 & 1048576) != 0 ? didiCardModel.titleHighlight : c5680i;
        String str62 = (i13 & 2097152) != 0 ? didiCardModel.titleTrailing : str16;
        String str63 = (i13 & 4194304) != 0 ? didiCardModel.routeText : str17;
        String str64 = (i13 & 8388608) != 0 ? didiCardModel.noteText : str18;
        String str65 = (i13 & 16777216) != 0 ? didiCardModel.summaryText : str19;
        String str66 = (i13 & Const.FLAG_MUTABLE) != 0 ? didiCardModel.plateTitle : str20;
        C5680i c5680i6 = (i13 & 67108864) != 0 ? didiCardModel.plateTitleHighlight : c5680i2;
        String str67 = (i13 & 134217728) != 0 ? didiCardModel.plateSubtitle : str21;
        String str68 = (i13 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? didiCardModel.carImageUrl : str22;
        String str69 = (i13 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? didiCardModel.disclaimer : str23;
        List list5 = (i13 & 1073741824) != 0 ? didiCardModel.carTypes : list;
        List list6 = (i13 & Integer.MIN_VALUE) != 0 ? didiCardModel.infoRows : list2;
        InfoRow infoRow3 = (i14 & 1) != 0 ? didiCardModel.ctaRow : infoRow;
        ActionItem actionItem5 = (i14 & 2) != 0 ? didiCardModel.primaryAction : actionItem;
        ActionItem actionItem6 = (i14 & 4) != 0 ? didiCardModel.secondaryAction : actionItem2;
        if ((i14 & 8) != 0) {
            actionItem3 = actionItem6;
            didiCardModel3 = didiCardModel.installGate;
            c5680i3 = c5680i5;
            str25 = str62;
            str26 = str63;
            str27 = str64;
            str28 = str65;
            str29 = str66;
            c5680i4 = c5680i6;
            str30 = str67;
            str31 = str68;
            str32 = str69;
            list3 = list5;
            list4 = list6;
            infoRow2 = infoRow3;
            actionItem4 = actionItem5;
            str33 = str57;
            str35 = str49;
            str36 = str50;
            str37 = str51;
            str38 = str52;
            str39 = str53;
            str40 = str54;
            str41 = str55;
            i15 = i19;
            i16 = i20;
            appItem2 = appItem3;
            str42 = str58;
            str43 = str59;
            str44 = str60;
            str24 = str61;
            i17 = i18;
            z11 = z12;
            str45 = str47;
            str34 = str48;
        } else {
            didiCardModel3 = didiCardModel2;
            actionItem3 = actionItem6;
            str24 = str61;
            c5680i3 = c5680i5;
            str25 = str62;
            str26 = str63;
            str27 = str64;
            str28 = str65;
            str29 = str66;
            c5680i4 = c5680i6;
            str30 = str67;
            str31 = str68;
            str32 = str69;
            list3 = list5;
            list4 = list6;
            infoRow2 = infoRow3;
            actionItem4 = actionItem5;
            str33 = str57;
            str34 = str48;
            str35 = str49;
            str36 = str50;
            str37 = str51;
            str38 = str52;
            str39 = str53;
            str40 = str54;
            str41 = str55;
            i15 = i19;
            i16 = i20;
            appItem2 = appItem3;
            str42 = str58;
            str43 = str59;
            str44 = str60;
            i17 = i18;
            z11 = z12;
            str45 = str47;
        }
        return didiCardModel.b(str56, i17, z11, str45, str34, str35, str36, str37, str38, str39, str40, str41, i15, i16, str33, appItem2, str42, str43, str44, str24, c5680i3, str25, str26, str27, str28, str29, c5680i4, str30, str31, str32, list3, list4, infoRow2, actionItem4, actionItem3, didiCardModel3);
    }

    /* renamed from: A, reason: from getter */
    public final ActionItem getSecondaryAction() {
        return this.secondaryAction;
    }

    /* renamed from: B, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: C, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: D, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    /* renamed from: E, reason: from getter */
    public final String getSummaryText() {
        return this.summaryText;
    }

    /* renamed from: F, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: G, reason: from getter */
    public final C5680i getTitleHighlight() {
        return this.titleHighlight;
    }

    /* renamed from: H, reason: from getter */
    public final String getTitleTrailing() {
        return this.titleTrailing;
    }

    /* renamed from: I, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: J, reason: from getter */
    public final int getVendorFallbackIconRes() {
        return this.vendorFallbackIconRes;
    }

    /* renamed from: K, reason: from getter */
    public final int getVendorHighlightColorRes() {
        return this.vendorHighlightColorRes;
    }

    /* renamed from: L, reason: from getter */
    public final String getVendorPkg() {
        return this.vendorPkg;
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final DidiCardModel b(String cardId, int status, boolean activeMatching, String vendorPkg, String bizChannel, String sessionId, String messageId, String toolCallId, String requestTraceId, String clientRenderSource, String orderNo, String platformOrderId, int vendorFallbackIconRes, int vendorHighlightColorRes, String storeName, AppItem app, String backendInstallState, String authTitle, String authSubtitle, String title, C5680i titleHighlight, String titleTrailing, String routeText, String noteText, String summaryText, String plateTitle, C5680i plateTitleHighlight, String plateSubtitle, String carImageUrl, String disclaimer, List<CarTypeItem> carTypes, List<InfoRow> infoRows, InfoRow ctaRow, ActionItem primaryAction, ActionItem secondaryAction, DidiCardModel installGate) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(vendorPkg, "vendorPkg");
        kotlin.jvm.internal.p.i(carTypes, "carTypes");
        kotlin.jvm.internal.p.i(infoRows, "infoRows");
        return new DidiCardModel(cardId, status, activeMatching, vendorPkg, bizChannel, sessionId, messageId, toolCallId, requestTraceId, clientRenderSource, orderNo, platformOrderId, vendorFallbackIconRes, vendorHighlightColorRes, storeName, app, backendInstallState, authTitle, authSubtitle, title, titleHighlight, titleTrailing, routeText, noteText, summaryText, plateTitle, plateTitleHighlight, plateSubtitle, carImageUrl, disclaimer, carTypes, infoRows, ctaRow, primaryAction, secondaryAction, installGate);
    }

    /* renamed from: d, reason: from getter */
    public final boolean getActiveMatching() {
        return this.activeMatching;
    }

    /* renamed from: e, reason: from getter */
    public final AppItem getApp() {
        return this.app;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiCardModel)) {
            return false;
        }
        DidiCardModel didiCardModel = (DidiCardModel) other;
        return kotlin.jvm.internal.p.d(this.cardId, didiCardModel.cardId) && this.status == didiCardModel.status && this.activeMatching == didiCardModel.activeMatching && kotlin.jvm.internal.p.d(this.vendorPkg, didiCardModel.vendorPkg) && kotlin.jvm.internal.p.d(this.bizChannel, didiCardModel.bizChannel) && kotlin.jvm.internal.p.d(this.sessionId, didiCardModel.sessionId) && kotlin.jvm.internal.p.d(this.messageId, didiCardModel.messageId) && kotlin.jvm.internal.p.d(this.toolCallId, didiCardModel.toolCallId) && kotlin.jvm.internal.p.d(this.requestTraceId, didiCardModel.requestTraceId) && kotlin.jvm.internal.p.d(this.clientRenderSource, didiCardModel.clientRenderSource) && kotlin.jvm.internal.p.d(this.orderNo, didiCardModel.orderNo) && kotlin.jvm.internal.p.d(this.platformOrderId, didiCardModel.platformOrderId) && this.vendorFallbackIconRes == didiCardModel.vendorFallbackIconRes && this.vendorHighlightColorRes == didiCardModel.vendorHighlightColorRes && kotlin.jvm.internal.p.d(this.storeName, didiCardModel.storeName) && kotlin.jvm.internal.p.d(this.app, didiCardModel.app) && kotlin.jvm.internal.p.d(this.backendInstallState, didiCardModel.backendInstallState) && kotlin.jvm.internal.p.d(this.authTitle, didiCardModel.authTitle) && kotlin.jvm.internal.p.d(this.authSubtitle, didiCardModel.authSubtitle) && kotlin.jvm.internal.p.d(this.title, didiCardModel.title) && kotlin.jvm.internal.p.d(this.titleHighlight, didiCardModel.titleHighlight) && kotlin.jvm.internal.p.d(this.titleTrailing, didiCardModel.titleTrailing) && kotlin.jvm.internal.p.d(this.routeText, didiCardModel.routeText) && kotlin.jvm.internal.p.d(this.noteText, didiCardModel.noteText) && kotlin.jvm.internal.p.d(this.summaryText, didiCardModel.summaryText) && kotlin.jvm.internal.p.d(this.plateTitle, didiCardModel.plateTitle) && kotlin.jvm.internal.p.d(this.plateTitleHighlight, didiCardModel.plateTitleHighlight) && kotlin.jvm.internal.p.d(this.plateSubtitle, didiCardModel.plateSubtitle) && kotlin.jvm.internal.p.d(this.carImageUrl, didiCardModel.carImageUrl) && kotlin.jvm.internal.p.d(this.disclaimer, didiCardModel.disclaimer) && kotlin.jvm.internal.p.d(this.carTypes, didiCardModel.carTypes) && kotlin.jvm.internal.p.d(this.infoRows, didiCardModel.infoRows) && kotlin.jvm.internal.p.d(this.ctaRow, didiCardModel.ctaRow) && kotlin.jvm.internal.p.d(this.primaryAction, didiCardModel.primaryAction) && kotlin.jvm.internal.p.d(this.secondaryAction, didiCardModel.secondaryAction) && kotlin.jvm.internal.p.d(this.installGate, didiCardModel.installGate);
    }

    /* renamed from: f, reason: from getter */
    public final String getAuthSubtitle() {
        return this.authSubtitle;
    }

    /* renamed from: g, reason: from getter */
    public final String getAuthTitle() {
        return this.authTitle;
    }

    /* renamed from: h, reason: from getter */
    public final String getBackendInstallState() {
        return this.backendInstallState;
    }

    public int hashCode() {
        int iHashCode = ((((((this.cardId.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + Boolean.hashCode(this.activeMatching)) * 31) + this.vendorPkg.hashCode()) * 31;
        String str = this.bizChannel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.messageId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toolCallId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.requestTraceId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.clientRenderSource;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.orderNo;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.platformOrderId;
        int iHashCode9 = (((((iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + Integer.hashCode(this.vendorFallbackIconRes)) * 31) + Integer.hashCode(this.vendorHighlightColorRes)) * 31;
        String str9 = this.storeName;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        AppItem appItem = this.app;
        int iHashCode11 = (iHashCode10 + (appItem == null ? 0 : appItem.hashCode())) * 31;
        String str10 = this.backendInstallState;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.authTitle;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.authSubtitle;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.title;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        C5680i c5680i = this.titleHighlight;
        int iHashCode16 = (iHashCode15 + (c5680i == null ? 0 : c5680i.hashCode())) * 31;
        String str14 = this.titleTrailing;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.routeText;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.noteText;
        int iHashCode19 = (iHashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.summaryText;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.plateTitle;
        int iHashCode21 = (iHashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        C5680i c5680i2 = this.plateTitleHighlight;
        int iHashCode22 = (iHashCode21 + (c5680i2 == null ? 0 : c5680i2.hashCode())) * 31;
        String str19 = this.plateSubtitle;
        int iHashCode23 = (iHashCode22 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.carImageUrl;
        int iHashCode24 = (iHashCode23 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.disclaimer;
        int iHashCode25 = (((((iHashCode24 + (str21 == null ? 0 : str21.hashCode())) * 31) + this.carTypes.hashCode()) * 31) + this.infoRows.hashCode()) * 31;
        InfoRow infoRow = this.ctaRow;
        int iHashCode26 = (iHashCode25 + (infoRow == null ? 0 : infoRow.hashCode())) * 31;
        ActionItem actionItem = this.primaryAction;
        int iHashCode27 = (iHashCode26 + (actionItem == null ? 0 : actionItem.hashCode())) * 31;
        ActionItem actionItem2 = this.secondaryAction;
        int iHashCode28 = (iHashCode27 + (actionItem2 == null ? 0 : actionItem2.hashCode())) * 31;
        DidiCardModel didiCardModel = this.installGate;
        return iHashCode28 + (didiCardModel != null ? didiCardModel.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getBizChannel() {
        return this.bizChannel;
    }

    /* renamed from: j, reason: from getter */
    public final String getCarImageUrl() {
        return this.carImageUrl;
    }

    public final List<CarTypeItem> k() {
        return this.carTypes;
    }

    /* renamed from: l, reason: from getter */
    public final String getClientRenderSource() {
        return this.clientRenderSource;
    }

    /* renamed from: m, reason: from getter */
    public final InfoRow getCtaRow() {
        return this.ctaRow;
    }

    /* renamed from: n, reason: from getter */
    public final String getDisclaimer() {
        return this.disclaimer;
    }

    public final List<InfoRow> o() {
        return this.infoRows;
    }

    /* renamed from: p, reason: from getter */
    public final DidiCardModel getInstallGate() {
        return this.installGate;
    }

    /* renamed from: q, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: r, reason: from getter */
    public final String getNoteText() {
        return this.noteText;
    }

    /* renamed from: s, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    /* renamed from: t, reason: from getter */
    public final String getPlateSubtitle() {
        return this.plateSubtitle;
    }

    public String toString() {
        return "DidiCardModel(cardId=" + this.cardId + ", status=" + this.status + ", activeMatching=" + this.activeMatching + ", vendorPkg=" + this.vendorPkg + ", bizChannel=" + this.bizChannel + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", toolCallId=" + this.toolCallId + ", requestTraceId=" + this.requestTraceId + ", clientRenderSource=" + this.clientRenderSource + ", orderNo=" + this.orderNo + ", platformOrderId=" + this.platformOrderId + ", vendorFallbackIconRes=" + this.vendorFallbackIconRes + ", vendorHighlightColorRes=" + this.vendorHighlightColorRes + ", storeName=" + this.storeName + ", app=" + this.app + ", backendInstallState=" + this.backendInstallState + ", authTitle=" + this.authTitle + ", authSubtitle=" + this.authSubtitle + ", title=" + this.title + ", titleHighlight=" + this.titleHighlight + ", titleTrailing=" + this.titleTrailing + ", routeText=" + this.routeText + ", noteText=" + this.noteText + ", summaryText=" + this.summaryText + ", plateTitle=" + this.plateTitle + ", plateTitleHighlight=" + this.plateTitleHighlight + ", plateSubtitle=" + this.plateSubtitle + ", carImageUrl=" + this.carImageUrl + ", disclaimer=" + this.disclaimer + ", carTypes=" + this.carTypes + ", infoRows=" + this.infoRows + ", ctaRow=" + this.ctaRow + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ", installGate=" + this.installGate + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getPlateTitle() {
        return this.plateTitle;
    }

    /* renamed from: v, reason: from getter */
    public final C5680i getPlateTitleHighlight() {
        return this.plateTitleHighlight;
    }

    /* renamed from: w, reason: from getter */
    public final String getPlatformOrderId() {
        return this.platformOrderId;
    }

    /* renamed from: x, reason: from getter */
    public final ActionItem getPrimaryAction() {
        return this.primaryAction;
    }

    /* renamed from: y, reason: from getter */
    public final String getRequestTraceId() {
        return this.requestTraceId;
    }

    /* renamed from: z, reason: from getter */
    public final String getRouteText() {
        return this.routeText;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiCardModel(String cardId, int i10, boolean z10, String vendorPkg, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, int i12, String str9, AppItem appItem, String str10, String str11, String str12, String str13, C5680i c5680i, String str14, String str15, String str16, String str17, String str18, C5680i c5680i2, String str19, String str20, String str21, List<CarTypeItem> carTypes, List<InfoRow> infoRows, InfoRow infoRow, ActionItem actionItem, ActionItem actionItem2, DidiCardModel didiCardModel) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(vendorPkg, "vendorPkg");
        kotlin.jvm.internal.p.i(carTypes, "carTypes");
        kotlin.jvm.internal.p.i(infoRows, "infoRows");
        this.cardId = cardId;
        this.status = i10;
        this.activeMatching = z10;
        this.vendorPkg = vendorPkg;
        this.bizChannel = str;
        this.sessionId = str2;
        this.messageId = str3;
        this.toolCallId = str4;
        this.requestTraceId = str5;
        this.clientRenderSource = str6;
        this.orderNo = str7;
        this.platformOrderId = str8;
        this.vendorFallbackIconRes = i11;
        this.vendorHighlightColorRes = i12;
        this.storeName = str9;
        this.app = appItem;
        this.backendInstallState = str10;
        this.authTitle = str11;
        this.authSubtitle = str12;
        this.title = str13;
        this.titleHighlight = c5680i;
        this.titleTrailing = str14;
        this.routeText = str15;
        this.noteText = str16;
        this.summaryText = str17;
        this.plateTitle = str18;
        this.plateTitleHighlight = c5680i2;
        this.plateSubtitle = str19;
        this.carImageUrl = str20;
        this.disclaimer = str21;
        this.carTypes = carTypes;
        this.infoRows = infoRows;
        this.ctaRow = infoRow;
        this.primaryAction = actionItem;
        this.secondaryAction = actionItem2;
        this.installGate = didiCardModel;
    }

    public /* synthetic */ DidiCardModel(String str, int i10, boolean z10, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i11, int i12, String str11, AppItem appItem, String str12, String str13, String str14, String str15, C5680i c5680i, String str16, String str17, String str18, String str19, String str20, C5680i c5680i2, String str21, String str22, String str23, List list, List list2, InfoRow infoRow, ActionItem actionItem, ActionItem actionItem2, DidiCardModel didiCardModel, int i13, int i14, kotlin.jvm.internal.i iVar) {
        this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? -1 : i10, (i13 & 4) != 0 ? false : z10, (i13 & 8) == 0 ? str2 : "", (i13 & 16) != 0 ? null : str3, (i13 & 32) != 0 ? null : str4, (i13 & 64) != 0 ? null : str5, (i13 & 128) != 0 ? null : str6, (i13 & 256) != 0 ? null : str7, (i13 & 512) != 0 ? null : str8, (i13 & 1024) != 0 ? null : str9, (i13 & 2048) != 0 ? null : str10, (i13 & 4096) != 0 ? R$drawable.ic_card_didi_app : i11, (i13 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? R$color.card_didi_highlight : i12, (i13 & 16384) != 0 ? null : str11, (i13 & 32768) != 0 ? null : appItem, (i13 & 65536) != 0 ? null : str12, (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str13, (i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : str14, (i13 & 524288) != 0 ? null : str15, (i13 & 1048576) != 0 ? null : c5680i, (i13 & 2097152) != 0 ? null : str16, (i13 & 4194304) != 0 ? null : str17, (i13 & 8388608) != 0 ? null : str18, (i13 & 16777216) != 0 ? null : str19, (i13 & Const.FLAG_MUTABLE) != 0 ? null : str20, (i13 & 67108864) != 0 ? null : c5680i2, (i13 & 134217728) != 0 ? null : str21, (i13 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str22, (i13 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? null : str23, (i13 & 1073741824) != 0 ? C1173v.m() : list, (i13 & Integer.MIN_VALUE) != 0 ? C1173v.m() : list2, (i14 & 1) != 0 ? null : infoRow, (i14 & 2) != 0 ? null : actionItem, (i14 & 4) != 0 ? null : actionItem2, (i14 & 8) != 0 ? null : didiCardModel);
    }
}
