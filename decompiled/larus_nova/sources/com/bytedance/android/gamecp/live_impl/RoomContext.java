package com.bytedance.android.gamecp.live_impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.introducecard.s;
import com.bytedance.android.gamecp.host_api.model.j;
import com.bytedance.android.gamecp.live_impl.message.t;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b&\u0018\u0000 ê\u00012\u00020\u0001:\u0002ë\u0001B\t¢\u0006\u0006\bè\u0001\u0010é\u0001J\u001d\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010 \u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\r\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R2\u0010>\u001a\u0012\u0012\u0004\u0012\u0002020<j\b\u0012\u0004\u0012\u000202`=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010.\u001a\u0004\bE\u00100R!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010.\u001a\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010.\u001a\u0004\bY\u00100R1\u0010^\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020[0<j\b\u0012\u0004\u0012\u00020[`=0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010.\u001a\u0004\b]\u00100R!\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010.\u001a\u0004\b`\u00100R!\u0010e\u001a\b\u0012\u0004\u0012\u00020b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010.\u001a\u0004\bd\u00100R!\u0010i\u001a\b\u0012\u0004\u0012\u00020f0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010.\u001a\u0004\bh\u00100R\"\u0010k\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR-\u0010u\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020r0q0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bs\u0010.\u001a\u0004\bt\u00100R\"\u0010v\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010l\u001a\u0004\bw\u0010n\"\u0004\bx\u0010pR\"\u0010y\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\r\u001a\u0004\bz\u0010\u000e\"\u0004\b{\u0010\u0010R\"\u0010|\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010\r\u001a\u0004\b}\u0010\u000e\"\u0004\b~\u0010\u0010R$\u0010\u007f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\r\u001a\u0005\b\u0080\u0001\u0010\u000e\"\u0005\b\u0081\u0001\u0010\u0010R&\u0010\u0082\u0001\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010l\u001a\u0005\b\u0083\u0001\u0010n\"\u0005\b\u0084\u0001\u0010pR&\u0010\u0085\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u00104\u001a\u0005\b\u0086\u0001\u00106\"\u0005\b\u0087\u0001\u00108R&\u0010\u0088\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\r\u001a\u0005\b\u0089\u0001\u0010\u000e\"\u0005\b\u008a\u0001\u0010\u0010R&\u0010\u008b\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010\r\u001a\u0005\b\u008b\u0001\u0010\u000e\"\u0005\b\u008c\u0001\u0010\u0010R&\u0010\u008d\u0001\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010l\u001a\u0005\b\u008e\u0001\u0010n\"\u0005\b\u008f\u0001\u0010pR&\u0010\u0090\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\r\u001a\u0005\b\u0090\u0001\u0010\u000e\"\u0005\b\u0091\u0001\u0010\u0010R&\u0010\u0092\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\r\u001a\u0005\b\u0093\u0001\u0010\u000e\"\u0005\b\u0094\u0001\u0010\u0010R&\u0010\u0095\u0001\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010L\u001a\u0005\b\u0096\u0001\u0010N\"\u0005\b\u0097\u0001\u0010PR&\u0010\u0098\u0001\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010L\u001a\u0005\b\u0099\u0001\u0010N\"\u0005\b\u009a\u0001\u0010PR&\u0010\u009b\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010\r\u001a\u0005\b\u009c\u0001\u0010\u000e\"\u0005\b\u009d\u0001\u0010\u0010R&\u0010\u009e\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010\r\u001a\u0005\b\u009e\u0001\u0010\u000e\"\u0005\b\u009f\u0001\u0010\u0010R&\u0010 \u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010\r\u001a\u0005\b \u0001\u0010\u000e\"\u0005\b¡\u0001\u0010\u0010R,\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R&\u0010©\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010\r\u001a\u0005\b©\u0001\u0010\u000e\"\u0005\bª\u0001\u0010\u0010R%\u0010®\u0001\u001a\t\u0012\u0005\u0012\u00030«\u00010F8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¬\u0001\u0010.\u001a\u0005\b\u00ad\u0001\u0010IR&\u0010¯\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010\r\u001a\u0005\b°\u0001\u0010\u000e\"\u0005\b±\u0001\u0010\u0010R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R)\u0010»\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R&\u0010½\u0001\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010l\u001a\u0005\b¾\u0001\u0010n\"\u0005\b¿\u0001\u0010pR&\u0010À\u0001\u001a\u00020j8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010l\u001a\u0005\bÁ\u0001\u0010n\"\u0005\bÂ\u0001\u0010pR&\u0010Ã\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010\r\u001a\u0005\bÄ\u0001\u0010\u000e\"\u0005\bÅ\u0001\u0010\u0010R1\u0010É\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u000202\u0012\u0005\u0012\u00030Æ\u00010q0,8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÇ\u0001\u0010.\u001a\u0005\bÈ\u0001\u00100R&\u0010Ê\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÊ\u0001\u0010\r\u001a\u0005\bË\u0001\u0010\u000e\"\u0005\bÌ\u0001\u0010\u0010R&\u0010Í\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÍ\u0001\u00104\u001a\u0005\bÎ\u0001\u00106\"\u0005\bÏ\u0001\u00108R&\u0010Ð\u0001\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÐ\u0001\u0010L\u001a\u0005\bÑ\u0001\u0010N\"\u0005\bÒ\u0001\u0010PR&\u0010Ó\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÓ\u0001\u00104\u001a\u0005\bÔ\u0001\u00106\"\u0005\bÕ\u0001\u00108R&\u0010Ö\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÖ\u0001\u00104\u001a\u0005\b×\u0001\u00106\"\u0005\bØ\u0001\u00108R&\u0010Ù\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÙ\u0001\u00104\u001a\u0005\bÚ\u0001\u00106\"\u0005\bÛ\u0001\u00108R&\u0010Ü\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÜ\u0001\u0010\r\u001a\u0005\bÝ\u0001\u0010\u000e\"\u0005\bÞ\u0001\u0010\u0010R(\u0010ß\u0001\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bß\u0001\u00104\u001a\u0005\bà\u0001\u00106\"\u0005\bá\u0001\u00108R(\u0010â\u0001\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bâ\u0001\u00104\u001a\u0005\bã\u0001\u00106\"\u0005\bä\u0001\u00108R&\u0010å\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bå\u0001\u00104\u001a\u0005\bæ\u0001\u00106\"\u0005\bç\u0001\u00108¨\u0006ì\u0001"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/RoomContext;", "Lcom/bytedance/live/datacontext/DataContext;", ExifInterface.GPS_DIRECTION_TRUE, "response", "", "saveBackendData", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lcom/bytedance/android/gamecp/live_impl/card/a;", "callback", "getBackendDataV2", "", "isGameRoom", "Z", "()Z", "setGameRoom", "(Z)V", "isAiIntroGameEnabled", "setAiIntroGameEnabled", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "hasReportStart", "getHasReportStart", "setHasReportStart", "hasReportWillShow", "getHasReportWillShow", "setHasReportWillShow", "hasReportWillNotShow", "getHasReportWillNotShow", "setHasReportWillNotShow", "hasReportCancel", "getHasReportCancel", "setHasReportCancel", "hasReportEnd", "getHasReportEnd", "setHasReportEnd", "shouldReportWillShow", "getShouldReportWillShow", "setShouldReportWillShow", "Lcom/bytedance/live/datacontext/m;", "hasGetIntroduceCardEnterData$delegate", "Lcom/bytedance/live/datacontext/p;", "getHasGetIntroduceCardEnterData", "()Lcom/bytedance/live/datacontext/m;", "hasGetIntroduceCardEnterData", "", "uniqueKey", "Ljava/lang/String;", "getUniqueKey", "()Ljava/lang/String;", "setUniqueKey", "(Ljava/lang/String;)V", "roomId", "getRoomId", "setRoomId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "msgList", "Ljava/util/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "isIntroducingGameManually$delegate", "isIntroducingGameManually", "Lcom/bytedance/live/datacontext/n;", "isInResumeStatus$delegate", "isInResumeStatus", "()Lcom/bytedance/live/datacontext/n;", "", "requestCardDataCount", "I", "getRequestCardDataCount", "()I", "setRequestCardDataCount", "(I)V", "Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", "getStrategy", "()Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", "setStrategy", "(Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;)V", "manualCloseGameCard$delegate", "getManualCloseGameCard", "manualCloseGameCard", "Lcom/bytedance/android/gamecp/host_api/model/j;", "simplePromoteList$delegate", "getSimplePromoteList", "simplePromoteList", "userMetaDataFetched$delegate", "getUserMetaDataFetched", "userMetaDataFetched", "Lcom/bytedance/android/gamecp/live_impl/message/t;", "userIntroCardConfig$delegate", "getUserIntroCardConfig", "userIntroCardConfig", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "userIntroCardDisplayConfig$delegate", "getUserIntroCardDisplayConfig", "userIntroCardDisplayConfig", "", "enterRoomTimestamp", "J", "getEnterRoomTimestamp", "()J", "setEnterRoomTimestamp", "(J)V", "", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/n;", "userGiftStatusMap$delegate", "getUserGiftStatusMap", "userGiftStatusMap", "timerCurLoopCount", "getTimerCurLoopCount", "setTimerCurLoopCount", "openGameDetailFromAD", "getOpenGameDetailFromAD", "setOpenGameDetailFromAD", "executedEnterAnim", "getExecutedEnterAnim", "setExecutedEnterAnim", "screenOrientationChange", "getScreenOrientationChange", "setScreenOrientationChange", "screenOrientationChangeTime", "getScreenOrientationChangeTime", "setScreenOrientationChangeTime", "iconShowTime", "getIconShowTime", "setIconShowTime", "iconShowFirstTime", "getIconShowFirstTime", "setIconShowFirstTime", "isNeedShowReportFirstTime", "setNeedShowReportFirstTime", "receiveIconShowIMTime", "getReceiveIconShowIMTime", "setReceiveIconShowIMTime", "isCleanMode", "setCleanMode", "enterCardBackendDataReady", "getEnterCardBackendDataReady", "setEnterCardBackendDataReady", "allChannelInstallEnable", "getAllChannelInstallEnable", "setAllChannelInstallEnable", "allChannelDetailPageShowCount", "getAllChannelDetailPageShowCount", "setAllChannelDetailPageShowCount", "delayedClickAnchorIcon", "getDelayedClickAnchorIcon", "setDelayedClickAnchorIcon", "isPreloadScene", "setPreloadScene", "isClickedOnRoomPreload", "setClickedOnRoomPreload", "Lcom/google/gson/JsonObject;", "toolbarData", "Lcom/google/gson/JsonObject;", "getToolbarData", "()Lcom/google/gson/JsonObject;", "setToolbarData", "(Lcom/google/gson/JsonObject;)V", "isToolbarShow", "setToolbarShow", "Lqw/a;", "transferPageSchemaResponse$delegate", "getTransferPageSchemaResponse", "transferPageSchemaResponse", "hasReceiveBackendData", "getHasReceiveBackendData", "setHasReceiveBackendData", "Lorg/json/JSONObject;", "jumpExtra", "Lorg/json/JSONObject;", "getJumpExtra", "()Lorg/json/JSONObject;", "setJumpExtra", "(Lorg/json/JSONObject;)V", "backendDataResponseV2", "Lcom/bytedance/android/gamecp/live_impl/card/a;", "backendDataCallbackForNewVersion", "Lkotlin/jvm/functions/Function1;", "enterCardReceiveBackendDataTime", "getEnterCardReceiveBackendDataTime", "setEnterCardReceiveBackendDataTime", "enterCardReceiveBackendParseTime", "getEnterCardReceiveBackendParseTime", "setEnterCardReceiveBackendParseTime", "cardFirstReport", "getCardFirstReport", "setCardFirstReport", "", "injectPreviewData$delegate", "getInjectPreviewData", "injectPreviewData", "hasInvokePreviewAction", "getHasInvokePreviewAction", "setHasInvokePreviewAction", "preloadFrom", "getPreloadFrom", "setPreloadFrom", "loadFromLocal", "getLoadFromLocal", "setLoadFromLocal", "loadFromLocalError", "getLoadFromLocalError", "setLoadFromLocalError", "loadFromLocalSuccess", "getLoadFromLocalSuccess", "setLoadFromLocalSuccess", "memoryCache", "getMemoryCache", "setMemoryCache", "preloadResult", "getPreloadResult", "setPreloadResult", "preloadErrorMsg", "getPreloadErrorMsg", "setPreloadErrorMsg", "cacheKey", "getCacheKey", "setCacheKey", "realUrl", "getRealUrl", "setRealUrl", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final int ALL_CHANNEL_INSTALL_ENABLE_CLOSE = 0;
    public static final int ALL_CHANNEL_INSTALL_ENABLE_OPEN = 1;
    public static final a Companion = null;
    private int allChannelDetailPageShowCount;
    private int allChannelInstallEnable;
    private Function1<? super com.bytedance.android.gamecp.live_impl.card.a, Unit> backendDataCallbackForNewVersion;
    private com.bytedance.android.gamecp.live_impl.card.a backendDataResponseV2;
    private String cacheKey;
    private boolean cardFirstReport;
    private boolean delayedClickAnchorIcon;
    private Disposable disposable;
    private boolean enterCardBackendDataReady;
    private long enterCardReceiveBackendDataTime;
    private long enterCardReceiveBackendParseTime;
    private long enterRoomTimestamp;
    private boolean executedEnterAnim;
    private final p hasGetIntroduceCardEnterData$delegate;
    private boolean hasInvokePreviewAction;
    private boolean hasReceiveBackendData;
    private boolean hasReportCancel;
    private boolean hasReportEnd;
    private boolean hasReportStart;
    private boolean hasReportWillNotShow;
    private boolean hasReportWillShow;
    private boolean iconShowFirstTime;
    private String iconShowTime;
    private final p injectPreviewData$delegate;
    private boolean isAiIntroGameEnabled;
    private boolean isCleanMode;
    private boolean isClickedOnRoomPreload;
    private boolean isGameRoom;
    private final p isInResumeStatus$delegate;
    private final p isIntroducingGameManually$delegate;
    private boolean isNeedShowReportFirstTime;
    private boolean isPreloadScene;
    private boolean isToolbarShow;
    private JSONObject jumpExtra;
    private int loadFromLocal;
    private String loadFromLocalError;
    private String loadFromLocalSuccess;
    private final p manualCloseGameCard$delegate;
    private String memoryCache;
    private ArrayList<String> msgList;
    private boolean openGameDetailFromAD;
    private String preloadErrorMsg;
    private String preloadFrom;
    private boolean preloadResult;
    private String realUrl;
    private long receiveIconShowIMTime;
    private int requestCardDataCount;
    private String roomId;
    private boolean screenOrientationChange;
    private long screenOrientationChangeTime;
    private boolean shouldReportWillShow;
    private final p simplePromoteList$delegate;
    private com.bytedance.android.gamecp.host_api.model.intruducecard2.a strategy;
    private long timerCurLoopCount;
    private JsonObject toolbarData;
    private final p transferPageSchemaResponse$delegate;
    private String uniqueKey;
    private final p userGiftStatusMap$delegate;
    private final p userIntroCardConfig$delegate;
    private final p userIntroCardDisplayConfig$delegate;
    private final p userMetaDataFetched$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "source");
            boolean r103 = false;
            if (r100.length() != 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L12;
            Room r105 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r105 == null) goto L11;
            r100 = String.valueOf(r105.getId());
            if (r100 != null) goto L12;
        L11:
            r100 = "";
        L12:
            ILiveRoomControllerProvider.ProviderSource r106 = ILiveRoomControllerProvider.ProviderSource.PREVIEW;
            if (Intrinsics.areEqual(r102, r106.name()) == false) goto L21;
            if (r101.length() != 0) goto L17;
            boolean r107 = true;
        L18:
            if (r107 == false) goto L21;
            return r100 + '_' + r102;
        L17:
            r107 = false;
        L21:
            if (Intrinsics.areEqual(r102, r106.name()) == false) goto L28;
            if (r101.length() <= 0) goto L25;
            r103 = true;
        L25:
            if (r103 == false) goto L28;
            return r101 + '_' + r102;
        L28:
            return r100 + '_' + r102;
        L5:
            r104 = false;
            goto L6
        }

        @JvmStatic
        public static RoomContext b(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "source");
            String r103 = a(r100, r101, r102);
            DataContext r104 = com.bytedance.live.datacontext.d.d(r103);
            DataContext r105 = null;
            if ((r104 instanceof RoomContext) == true) goto L5;
            r104 = null;
        L5:
            RoomContext r106 = (RoomContext) r104;
            if (r106 != null) goto L13;
            DataContext r107 = com.bytedance.live.datacontext.d.d(RoomContext.class);
            if ((r107 instanceof RoomContext) == false) goto L11;
            r105 = r107;
        L11:
            RoomContext r108 = (RoomContext) r105;
            yr.b.b(6, "GameCP_RoomContext", "previewKey=" + r103 + " and result=" + r108);
            return r108;
        L13:
            return r106;
        }

        public static /* synthetic */ RoomContext c(a r100, String r101, String r102, String r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = "";
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        L11:
            r100.getClass();
            return b(r101, r102, r103);
        }
    }

    @JvmStatic
    public static final String generateUniqueKey(String r100, String r101, String r102) {
        Companion.getClass();
        return a.a(r100, r101, r102);
    }

    @JvmStatic
    public static final RoomContext getShared() {
        return a.c(Companion, null, null, null, 7);
    }

    @JvmStatic
    public static final RoomContext getShared(String r100) {
        return a.c(Companion, r100, null, null, 6);
    }

    @JvmStatic
    public static final RoomContext getShared(String r100, String r101) {
        return a.c(Companion, r100, r101, null, 4);
    }

    @JvmStatic
    public static final RoomContext getShared(String r100, String r101, String r102) {
        Companion.getClass();
        return a.b(r100, r101, r102);
    }

    public final m<Boolean> getHasGetIntroduceCardEnterData() {
        return (m) this.hasGetIntroduceCardEnterData$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Map<String, Object>> getInjectPreviewData() {
        return (m) this.injectPreviewData$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> getManualCloseGameCard() {
        return (m) this.manualCloseGameCard$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<ArrayList<j>> getSimplePromoteList() {
        return (m) this.simplePromoteList$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<qw.a> getTransferPageSchemaResponse() {
        return (n) this.transferPageSchemaResponse$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Map<String, com.bytedance.android.gamecp.host_api.model.introducecard.n>> getUserGiftStatusMap() {
        return (m) this.userGiftStatusMap$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<t> getUserIntroCardConfig() {
        return (m) this.userIntroCardConfig$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<s> getUserIntroCardDisplayConfig() {
        return (m) this.userIntroCardDisplayConfig$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getUserMetaDataFetched() {
        return (m) this.userMetaDataFetched$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<Boolean> isInResumeStatus() {
        return (n) this.isInResumeStatus$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> isIntroducingGameManually() {
        return (m) this.isIntroducingGameManually$delegate.a(this, $$delegatedProperties[1]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RoomContext.class, "hasGetIntroduceCardEnterData", "getHasGetIntroduceCardEnterData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "isIntroducingGameManually", "isIntroducingGameManually()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "isInResumeStatus", "isInResumeStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "manualCloseGameCard", "getManualCloseGameCard()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "simplePromoteList", "getSimplePromoteList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "userMetaDataFetched", "getUserMetaDataFetched()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "userIntroCardConfig", "getUserIntroCardConfig()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "userIntroCardDisplayConfig", "getUserIntroCardDisplayConfig()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "userGiftStatusMap", "getUserGiftStatusMap()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "transferPageSchemaResponse", "getTransferPageSchemaResponse()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "injectPreviewData", "getInjectPreviewData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public RoomContext() {
        Boolean r100 = Boolean.FALSE;
        this.hasGetIntroduceCardEnterData$delegate = q.d(this, r100);
        this.uniqueKey = "";
        this.roomId = "";
        this.msgList = new ArrayList();
        this.isIntroducingGameManually$delegate = q.d(this, r100);
        this.isInResumeStatus$delegate = q.b(this, AnonymousClass2.INSTANCE);
        this.manualCloseGameCard$delegate = q.d(this, r100);
        this.simplePromoteList$delegate = q.d(this, new ArrayList());
        this.userMetaDataFetched$delegate = q.d(this, r100);
        this.userIntroCardConfig$delegate = q.d(this, new t());
        this.userIntroCardDisplayConfig$delegate = q.d(this, new s());
        this.userGiftStatusMap$delegate = q.d(this, new LinkedHashMap());
        this.iconShowTime = "enter";
        this.iconShowFirstTime = true;
        this.isNeedShowReportFirstTime = true;
        this.receiveIconShowIMTime = -1;
        this.allChannelInstallEnable = 1;
        this.transferPageSchemaResponse$delegate = q.c(this);
        this.cardFirstReport = true;
        this.injectPreviewData$delegate = q.d(this, new LinkedHashMap());
        this.preloadFrom = "default";
        this.loadFromLocal = -1;
        this.loadFromLocalError = "";
        this.loadFromLocalSuccess = "";
        this.memoryCache = "";
        this.realUrl = "";
    }

    public final int getAllChannelDetailPageShowCount() {
        return this.allChannelDetailPageShowCount;
    }

    public final int getAllChannelInstallEnable() {
        return this.allChannelInstallEnable;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final boolean getCardFirstReport() {
        return this.cardFirstReport;
    }

    public final boolean getDelayedClickAnchorIcon() {
        return this.delayedClickAnchorIcon;
    }

    public final Disposable getDisposable() {
        return this.disposable;
    }

    public final boolean getEnterCardBackendDataReady() {
        return this.enterCardBackendDataReady;
    }

    public final long getEnterCardReceiveBackendDataTime() {
        return this.enterCardReceiveBackendDataTime;
    }

    public final long getEnterCardReceiveBackendParseTime() {
        return this.enterCardReceiveBackendParseTime;
    }

    public final long getEnterRoomTimestamp() {
        return this.enterRoomTimestamp;
    }

    public final boolean getExecutedEnterAnim() {
        return this.executedEnterAnim;
    }

    public final boolean getHasInvokePreviewAction() {
        return this.hasInvokePreviewAction;
    }

    public final boolean getHasReceiveBackendData() {
        return this.hasReceiveBackendData;
    }

    public final boolean getHasReportCancel() {
        return this.hasReportCancel;
    }

    public final boolean getHasReportEnd() {
        return this.hasReportEnd;
    }

    public final boolean getHasReportStart() {
        return this.hasReportStart;
    }

    public final boolean getHasReportWillNotShow() {
        return this.hasReportWillNotShow;
    }

    public final boolean getHasReportWillShow() {
        return this.hasReportWillShow;
    }

    public final boolean getIconShowFirstTime() {
        return this.iconShowFirstTime;
    }

    public final String getIconShowTime() {
        return this.iconShowTime;
    }

    public final JSONObject getJumpExtra() {
        return this.jumpExtra;
    }

    public final int getLoadFromLocal() {
        return this.loadFromLocal;
    }

    public final String getLoadFromLocalError() {
        return this.loadFromLocalError;
    }

    public final String getLoadFromLocalSuccess() {
        return this.loadFromLocalSuccess;
    }

    public final String getMemoryCache() {
        return this.memoryCache;
    }

    public final ArrayList<String> getMsgList() {
        return this.msgList;
    }

    public final boolean getOpenGameDetailFromAD() {
        return this.openGameDetailFromAD;
    }

    public final String getPreloadErrorMsg() {
        return this.preloadErrorMsg;
    }

    public final String getPreloadFrom() {
        return this.preloadFrom;
    }

    public final boolean getPreloadResult() {
        return this.preloadResult;
    }

    public final String getRealUrl() {
        return this.realUrl;
    }

    public final long getReceiveIconShowIMTime() {
        return this.receiveIconShowIMTime;
    }

    public final int getRequestCardDataCount() {
        return this.requestCardDataCount;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final boolean getScreenOrientationChange() {
        return this.screenOrientationChange;
    }

    public final long getScreenOrientationChangeTime() {
        return this.screenOrientationChangeTime;
    }

    public final boolean getShouldReportWillShow() {
        return this.shouldReportWillShow;
    }

    public final com.bytedance.android.gamecp.host_api.model.intruducecard2.a getStrategy() {
        return this.strategy;
    }

    public final long getTimerCurLoopCount() {
        return this.timerCurLoopCount;
    }

    public final JsonObject getToolbarData() {
        return this.toolbarData;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final boolean isAiIntroGameEnabled() {
        return this.isAiIntroGameEnabled;
    }

    public final boolean isCleanMode() {
        return this.isCleanMode;
    }

    public final boolean isClickedOnRoomPreload() {
        return this.isClickedOnRoomPreload;
    }

    public final boolean isGameRoom() {
        return this.isGameRoom;
    }

    public final boolean isNeedShowReportFirstTime() {
        return this.isNeedShowReportFirstTime;
    }

    public final boolean isPreloadScene() {
        return this.isPreloadScene;
    }

    public final boolean isToolbarShow() {
        return this.isToolbarShow;
    }

    public final void getBackendDataV2(Function1<? super com.bytedance.android.gamecp.live_impl.card.a, Unit> r100) {
        com.bytedance.android.gamecp.live_impl.card.a r101 = this.backendDataResponseV2;
        if (r101 == null) goto L5;
    L7:
        this.enterCardBackendDataReady = true;
        if (r100 == null) goto L12;
        Unit r102 = r100.invoke(r101);
        return;
    L12:
        return;
    L5:
        if (this.hasReceiveBackendData == true) goto L7;
        this.backendDataCallbackForNewVersion = r100;
    }

    public final <T> void saveBackendData(T r100) {
        boolean r101 = r100 instanceof com.bytedance.android.gamecp.live_impl.card.a;
        Object r102 = r100;
        if (r101 == true) goto L5;
        r102 = (T) null;
    L5:
        com.bytedance.android.gamecp.live_impl.card.a r103 = (com.bytedance.android.gamecp.live_impl.card.a) r102;
        this.backendDataResponseV2 = r103;
        this.hasReceiveBackendData = true;
        Function1<? super com.bytedance.android.gamecp.live_impl.card.a, Unit> r104 = this.backendDataCallbackForNewVersion;
        if (r104 == null) goto L8;
        Unit r105 = r104.invoke(r103);
    L8:
        this.backendDataCallbackForNewVersion = null;
    }

    public final void setAiIntroGameEnabled(boolean r100) {
        this.isAiIntroGameEnabled = r100;
    }

    public final void setAllChannelDetailPageShowCount(int r100) {
        this.allChannelDetailPageShowCount = r100;
    }

    public final void setAllChannelInstallEnable(int r100) {
        this.allChannelInstallEnable = r100;
    }

    public final void setCacheKey(String r100) {
        this.cacheKey = r100;
    }

    public final void setCardFirstReport(boolean r100) {
        this.cardFirstReport = r100;
    }

    public final void setCleanMode(boolean r100) {
        this.isCleanMode = r100;
    }

    public final void setClickedOnRoomPreload(boolean r100) {
        this.isClickedOnRoomPreload = r100;
    }

    public final void setDelayedClickAnchorIcon(boolean r100) {
        this.delayedClickAnchorIcon = r100;
    }

    public final void setDisposable(Disposable r100) {
        this.disposable = r100;
    }

    public final void setEnterCardBackendDataReady(boolean r100) {
        this.enterCardBackendDataReady = r100;
    }

    public final void setEnterCardReceiveBackendDataTime(long r100) {
        this.enterCardReceiveBackendDataTime = r100;
    }

    public final void setEnterCardReceiveBackendParseTime(long r100) {
        this.enterCardReceiveBackendParseTime = r100;
    }

    public final void setEnterRoomTimestamp(long r100) {
        this.enterRoomTimestamp = r100;
    }

    public final void setExecutedEnterAnim(boolean r100) {
        this.executedEnterAnim = r100;
    }

    public final void setGameRoom(boolean r100) {
        this.isGameRoom = r100;
    }

    public final void setHasInvokePreviewAction(boolean r100) {
        this.hasInvokePreviewAction = r100;
    }

    public final void setHasReceiveBackendData(boolean r100) {
        this.hasReceiveBackendData = r100;
    }

    public final void setHasReportCancel(boolean r100) {
        this.hasReportCancel = r100;
    }

    public final void setHasReportEnd(boolean r100) {
        this.hasReportEnd = r100;
    }

    public final void setHasReportStart(boolean r100) {
        this.hasReportStart = r100;
    }

    public final void setHasReportWillNotShow(boolean r100) {
        this.hasReportWillNotShow = r100;
    }

    public final void setHasReportWillShow(boolean r100) {
        this.hasReportWillShow = r100;
    }

    public final void setIconShowFirstTime(boolean r100) {
        this.iconShowFirstTime = r100;
    }

    public final void setIconShowTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconShowTime = r100;
    }

    public final void setJumpExtra(JSONObject r100) {
        this.jumpExtra = r100;
    }

    public final void setLoadFromLocal(int r100) {
        this.loadFromLocal = r100;
    }

    public final void setLoadFromLocalError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadFromLocalError = r100;
    }

    public final void setLoadFromLocalSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadFromLocalSuccess = r100;
    }

    public final void setMemoryCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.memoryCache = r100;
    }

    public final void setMsgList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msgList = r100;
    }

    public final void setNeedShowReportFirstTime(boolean r100) {
        this.isNeedShowReportFirstTime = r100;
    }

    public final void setOpenGameDetailFromAD(boolean r100) {
        this.openGameDetailFromAD = r100;
    }

    public final void setPreloadErrorMsg(String r100) {
        this.preloadErrorMsg = r100;
    }

    public final void setPreloadFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.preloadFrom = r100;
    }

    public final void setPreloadResult(boolean r100) {
        this.preloadResult = r100;
    }

    public final void setPreloadScene(boolean r100) {
        this.isPreloadScene = r100;
    }

    public final void setRealUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.realUrl = r100;
    }

    public final void setReceiveIconShowIMTime(long r100) {
        this.receiveIconShowIMTime = r100;
    }

    public final void setRequestCardDataCount(int r100) {
        this.requestCardDataCount = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setScreenOrientationChange(boolean r100) {
        this.screenOrientationChange = r100;
    }

    public final void setScreenOrientationChangeTime(long r100) {
        this.screenOrientationChangeTime = r100;
    }

    public final void setShouldReportWillShow(boolean r100) {
        this.shouldReportWillShow = r100;
    }

    public final void setStrategy(com.bytedance.android.gamecp.host_api.model.intruducecard2.a r100) {
        this.strategy = r100;
    }

    public final void setTimerCurLoopCount(long r100) {
        this.timerCurLoopCount = r100;
    }

    public final void setToolbarData(JsonObject r100) {
        this.toolbarData = r100;
    }

    public final void setToolbarShow(boolean r100) {
        this.isToolbarShow = r100;
    }

    public final void setUniqueKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uniqueKey = r100;
    }
}
