package com.bytedance.android.livesdkapi.depend.model.live.room;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.livesdk.chatroom.detail.a;
import com.bytedance.android.livesdk.chatroom.detail.e;
import com.bytedance.android.livesdk.chatroom.detail.p;
import com.bytedance.android.livesdk.chatroom.i;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.room.r0;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.room.utils.RoomEnterInfoExtKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSession;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.room.core.IRoomLogService;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.share.QzonePublish;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q81.f;
import yg1.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B&\u0012\b\u0010Ú\u0002\u001a\u00030Ù\u0002\u0012\u0007\u0010Þ\u0002\u001a\u00020\u0002\u0012\b\u0010å\u0002\u001a\u00030ä\u0002¢\u0006\u0006\bø\u0002\u0010ù\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0017J\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020 R\"\u0010#\u001a\u00020\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\"\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010?\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR\"\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010?\u001a\u0004\bK\u0010A\"\u0004\bL\u0010CR\"\u0010M\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010?\u001a\u0004\bN\u0010A\"\u0004\bO\u0010CR\"\u0010P\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010?\u001a\u0004\bP\u0010A\"\u0004\bQ\u0010CR\"\u0010R\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010?\u001a\u0004\bS\u0010A\"\u0004\bT\u0010CR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010YR\"\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010?\u001a\u0004\bc\u0010A\"\u0004\bd\u0010CR\"\u0010f\u001a\u00020e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010m\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010s\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010n\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R$\u0010}\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010x\u001a\u0004\b~\u0010z\"\u0004\b\u007f\u0010|R&\u0010\u0080\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010?\u001a\u0005\b\u0081\u0001\u0010A\"\u0005\b\u0082\u0001\u0010CR&\u0010\u0083\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010^\u001a\u0005\b\u0084\u0001\u0010`\"\u0005\b\u0085\u0001\u0010bR&\u0010\u0086\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010^\u001a\u0005\b\u0087\u0001\u0010`\"\u0005\b\u0088\u0001\u0010bR,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u008b\u0001\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u008b\u0001\u001a\u0006\b\u0094\u0001\u0010\u008d\u0001\"\u0006\b\u0095\u0001\u0010\u008f\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u008b\u0001\u001a\u0006\b\u0097\u0001\u0010\u008d\u0001\"\u0006\b\u0098\u0001\u0010\u008f\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u008b\u0001\u001a\u0006\b\u009a\u0001\u0010\u008d\u0001\"\u0006\b\u009b\u0001\u0010\u008f\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R&\u0010±\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010^\u001a\u0005\b²\u0001\u0010`\"\u0005\b³\u0001\u0010bR&\u0010´\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010?\u001a\u0005\b´\u0001\u0010A\"\u0005\bµ\u0001\u0010CR,\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001d\u0010½\u0001\u001a\u00020\u00048\u0006X\u0086D¢\u0006\u000e\n\u0005\b½\u0001\u0010^\u001a\u0005\b¾\u0001\u0010`R,\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R2\u0010Ç\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010Æ\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R%\u0010Î\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00140Í\u00018\u0006¢\u0006\u0010\n\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R(\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010^\u001a\u0005\bÓ\u0001\u0010`\"\u0005\bÔ\u0001\u0010bR,\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R,\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R&\u0010ã\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010?\u001a\u0005\bä\u0001\u0010A\"\u0005\bå\u0001\u0010CR,\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R&\u0010í\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010?\u001a\u0005\bí\u0001\u0010A\"\u0005\bî\u0001\u0010CR,\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R*\u0010÷\u0001\u001a\u00030ö\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001R*\u0010ý\u0001\u001a\u00030ö\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bý\u0001\u0010ø\u0001\u001a\u0006\bþ\u0001\u0010ú\u0001\"\u0006\bÿ\u0001\u0010ü\u0001R&\u0010\u0080\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0002\u0010?\u001a\u0005\b\u0080\u0002\u0010A\"\u0005\b\u0081\u0002\u0010CR(\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0002\u0010^\u001a\u0005\b\u0083\u0002\u0010`\"\u0005\b\u0084\u0002\u0010bR,\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R&\u0010\u008c\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0002\u0010?\u001a\u0005\b\u008d\u0002\u0010A\"\u0005\b\u008e\u0002\u0010CR,\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008f\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0002\u0010\u0091\u0002\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002\"\u0006\b\u0094\u0002\u0010\u0095\u0002R&\u0010\u0096\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0002\u0010?\u001a\u0005\b\u0097\u0002\u0010A\"\u0005\b\u0098\u0002\u0010CR(\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0099\u0002\u0010^\u001a\u0005\b\u009a\u0002\u0010`\"\u0005\b\u009b\u0002\u0010bR(\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0002\u0010^\u001a\u0005\b\u009d\u0002\u0010`\"\u0005\b\u009e\u0002\u0010bR(\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0002\u0010^\u001a\u0005\b \u0002\u0010`\"\u0005\b¡\u0002\u0010bR&\u0010¢\u0002\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0002\u0010^\u001a\u0005\b£\u0002\u0010`\"\u0005\b¤\u0002\u0010bR,\u0010¦\u0002\u001a\u0005\u0018\u00010¥\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0002\u0010§\u0002\u001a\u0006\b¨\u0002\u0010©\u0002\"\u0006\bª\u0002\u0010«\u0002R&\u0010¬\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010?\u001a\u0005\b¬\u0002\u0010A\"\u0005\b\u00ad\u0002\u0010CR&\u0010®\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b®\u0002\u0010?\u001a\u0005\b®\u0002\u0010A\"\u0005\b¯\u0002\u0010CR&\u0010°\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b°\u0002\u0010?\u001a\u0005\b°\u0002\u0010A\"\u0005\b±\u0002\u0010CR&\u0010²\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0002\u0010?\u001a\u0005\b²\u0002\u0010A\"\u0005\b³\u0002\u0010CR&\u0010´\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b´\u0002\u0010?\u001a\u0005\bµ\u0002\u0010A\"\u0005\b¶\u0002\u0010CR&\u0010·\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b·\u0002\u0010?\u001a\u0005\b·\u0002\u0010A\"\u0005\b¸\u0002\u0010CR&\u0010¹\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¹\u0002\u0010?\u001a\u0005\b¹\u0002\u0010A\"\u0005\bº\u0002\u0010CR&\u0010»\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b»\u0002\u0010?\u001a\u0005\b»\u0002\u0010A\"\u0005\b¼\u0002\u0010CR&\u0010½\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b½\u0002\u0010?\u001a\u0005\b½\u0002\u0010A\"\u0005\b¾\u0002\u0010CR&\u0010¿\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¿\u0002\u0010?\u001a\u0005\b¿\u0002\u0010A\"\u0005\bÀ\u0002\u0010CR&\u0010Á\u0002\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÁ\u0002\u0010?\u001a\u0005\bÂ\u0002\u0010A\"\u0005\bÃ\u0002\u0010CR&\u0010Ä\u0002\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÄ\u0002\u0010?\u001a\u0005\bÅ\u0002\u0010A\"\u0005\bÆ\u0002\u0010CR&\u0010Ç\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÇ\u0002\u0010?\u001a\u0005\bÇ\u0002\u0010A\"\u0005\bÈ\u0002\u0010CR&\u0010É\u0002\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÉ\u0002\u0010^\u001a\u0005\bÊ\u0002\u0010`\"\u0005\bË\u0002\u0010bR&\u0010Ì\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÌ\u0002\u0010?\u001a\u0005\bÍ\u0002\u0010A\"\u0005\bÎ\u0002\u0010CR&\u0010Ï\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÏ\u0002\u0010?\u001a\u0005\bÏ\u0002\u0010A\"\u0005\bÐ\u0002\u0010CR\u0018\u0010Ñ\u0002\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\bÑ\u0002\u0010?R6\u0010Ó\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010Ò\u0002\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bÓ\u0002\u0010Ô\u0002\u001a\u0006\bÕ\u0002\u0010Ö\u0002\"\u0006\b×\u0002\u0010Ø\u0002R\u001d\u0010Ú\u0002\u001a\u00030Ù\u00028\u0006¢\u0006\u0010\n\u0006\bÚ\u0002\u0010Û\u0002\u001a\u0006\bÜ\u0002\u0010Ý\u0002R)\u0010Þ\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0002\u0010ß\u0002\u001a\u0006\bà\u0002\u0010á\u0002\"\u0006\bâ\u0002\u0010ã\u0002R\u001d\u0010å\u0002\u001a\u00030ä\u00028\u0006¢\u0006\u0010\n\u0006\bå\u0002\u0010æ\u0002\u001a\u0006\bç\u0002\u0010è\u0002R$\u0010î\u0002\u001a\u0005\u0018\u00010é\u00028&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bê\u0002\u0010ë\u0002\"\u0006\bì\u0002\u0010í\u0002R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00148&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bï\u0002\u0010Ö\u0002\"\u0006\bð\u0002\u0010Ø\u0002R\"\u0010ó\u0002\u001a\u00030ö\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bñ\u0002\u0010ú\u0001\"\u0006\bò\u0002\u0010ü\u0001R(\u0010÷\u0002\u001a\u0013\u0012\u0005\u0012\u00030ö\u0001\u0012\u0005\u0012\u00030ö\u0001\u0018\u00010ô\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bõ\u0002\u0010ö\u0002¨\u0006ú\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/RoomBaseSession;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSession;", "Landroid/os/Bundle;", "args", "", "getUidFromEnterRoomArgs", "getPullData", "", "disableTextureRender", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "reason", "", "setRoomLoggerEndReason", "logRoomDuration", "", "roomId", "Lls2/e;", "roomError", "logRoomExit", "updateStreamLog", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "setupRoomContextRoom", "Lcom/bytedance/android/livesdkapi/model/BackendGeneratedData;", "result", "setBackendRoomContext", "Lkotlin/Function0;", "Lyg1/b;", "task", "updateLastEnterRoomTask", "initialize", "getRoomIdWithMicRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/EnterRoomInfo;", "getEnterRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/live/LiveRoomState;", "curState", "Lcom/bytedance/android/livesdkapi/depend/live/LiveRoomState;", "getCurState", "()Lcom/bytedance/android/livesdkapi/depend/live/LiveRoomState;", "setCurState", "(Lcom/bytedance/android/livesdkapi/depend/live/LiveRoomState;)V", "Lcom/bytedance/android/livesdk/chatroom/room/p0;", "eventHub", "Lcom/bytedance/android/livesdk/chatroom/room/p0;", "getEventHub", "()Lcom/bytedance/android/livesdk/chatroom/room/p0;", "setEventHub", "(Lcom/bytedance/android/livesdk/chatroom/room/p0;)V", "Lcom/bytedance/android/livesdk/chatroom/room/r0;", "enterInfo", "Lcom/bytedance/android/livesdk/chatroom/room/r0;", "getEnterInfo", "()Lcom/bytedance/android/livesdk/chatroom/room/r0;", "setEnterInfo", "(Lcom/bytedance/android/livesdk/chatroom/room/r0;)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "hasRoomPrepare", "Z", "getHasRoomPrepare", "()Z", "setHasRoomPrepare", "(Z)V", "hasRoomPreloaded", "getHasRoomPreloaded", "setHasRoomPreloaded", "hasEndOnce", "getHasEndOnce", "setHasEndOnce", "livePaused", "getLivePaused", "setLivePaused", "liveIllegal", "getLiveIllegal", "setLiveIllegal", "isVideoHorizontal", "setVideoHorizontal", "paidStreamUrlInvalid", "getPaidStreamUrlInvalid", "setPaidStreamUrlInvalid", "J", "getRoomId", "()J", "setRoomId", "(J)V", "micRoomPrePullId", "getMicRoomPrePullId", "setMicRoomPrePullId", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "isCustomizeAudioRoom", "setCustomizeAudioRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "streamType", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getStreamType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "setStreamType", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;)V", "Lcom/bytedance/android/livesdk/chatroom/detail/p;", "enterRoomController", "Lcom/bytedance/android/livesdk/chatroom/detail/p;", "getEnterRoomController", "()Lcom/bytedance/android/livesdk/chatroom/detail/p;", "setEnterRoomController", "(Lcom/bytedance/android/livesdk/chatroom/detail/p;)V", "preEnterRoomController", "getPreEnterRoomController", "setPreEnterRoomController", "Lcom/bytedance/android/livesdk/chatroom/detail/a;", "backendRoomController", "Lcom/bytedance/android/livesdk/chatroom/detail/a;", "getBackendRoomController", "()Lcom/bytedance/android/livesdk/chatroom/detail/a;", "setBackendRoomController", "(Lcom/bytedance/android/livesdk/chatroom/detail/a;)V", "preBackendRoomController", "getPreBackendRoomController", "setPreBackendRoomController", "firstShow", "getFirstShow", "setFirstShow", "linkUserId", "getLinkUserId", "setLinkUserId", "jointAnchorId", "getJointAnchorId", "setJointAnchorId", "Lcom/bytedance/android/livesdk/chatroom/detail/e;", "roomStateFetcher", "Lcom/bytedance/android/livesdk/chatroom/detail/e;", "getRoomStateFetcher", "()Lcom/bytedance/android/livesdk/chatroom/detail/e;", "setRoomStateFetcher", "(Lcom/bytedance/android/livesdk/chatroom/detail/e;)V", "userRoomFetcher", "getUserRoomFetcher", "setUserRoomFetcher", "orientationSwitchStateFetcher", "getOrientationSwitchStateFetcher", "setOrientationSwitchStateFetcher", "roomPreloadFetcher", "getRoomPreloadFetcher", "setRoomPreloadFetcher", "roomPreloadFetcherV2", "getRoomPreloadFetcherV2", "setRoomPreloadFetcherV2", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/IRoomPreloadTaskManager;", "roomPreloadTaskManager", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/IRoomPreloadTaskManager;", "getRoomPreloadTaskManager", "()Lcom/bytedance/android/livesdkapi/depend/model/live/room/IRoomPreloadTaskManager;", "setRoomPreloadTaskManager", "(Lcom/bytedance/android/livesdkapi/depend/model/live/room/IRoomPreloadTaskManager;)V", "Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "externalConfigJudger", "Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "getExternalConfigJudger", "()Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "setExternalConfigJudger", "(Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager;", "innerStateManager", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager;", "getInnerStateManager", "()Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager;", "setInnerStateManager", "(Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager;)V", "logSession", "getLogSession", "setLogSession", "isInner", "setInner", "Lcom/bytedance/android/livesdk/chatroom/i;", "autoPageChangeManager", "Lcom/bytedance/android/livesdk/chatroom/i;", "getAutoPageChangeManager", "()Lcom/bytedance/android/livesdk/chatroom/i;", "setAutoPageChangeManager", "(Lcom/bytedance/android/livesdk/chatroom/i;)V", "labels", "getLabels", "Landroid/app/Dialog;", "liveAbnormalFinishDialog", "Landroid/app/Dialog;", "getLiveAbnormalFinishDialog", "()Landroid/app/Dialog;", "setLiveAbnormalFinishDialog", "(Landroid/app/Dialog;)V", "Landroidx/fragment/app/Fragment;", "getFragment", "Lkotlin/jvm/functions/Function0;", "getGetFragment", "()Lkotlin/jvm/functions/Function0;", "setGetFragment", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/lifecycle/MutableLiveData;", "splitEnterData", "Landroidx/lifecycle/MutableLiveData;", "getSplitEnterData", "()Landroidx/lifecycle/MutableLiveData;", "nickName", "getNickName", "setNickName", "Lq81/i;", "extensionMonitor", "Lq81/i;", "getExtensionMonitor", "()Lq81/i;", "setExtensionMonitor", "(Lq81/i;)V", "Lq81/f;", "apmTraceAPMMonitor", "Lq81/f;", "getApmTraceAPMMonitor", "()Lq81/f;", "setApmTraceAPMMonitor", "(Lq81/f;)V", "autoStartWhenResume", "getAutoStartWhenResume", "setAutoStartWhenResume", "Lcom/bytedance/android/livesdk/chatroom/detail/p$a;", "preEnterRoomListener", "Lcom/bytedance/android/livesdk/chatroom/detail/p$a;", "getPreEnterRoomListener", "()Lcom/bytedance/android/livesdk/chatroom/detail/p$a;", "setPreEnterRoomListener", "(Lcom/bytedance/android/livesdk/chatroom/detail/p$a;)V", "isStopPlayerForNextRoomPrePullStream", "setStopPlayerForNextRoomPrePullStream", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "liveRequest", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "getLiveRequest", "()Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "setLiveRequest", "(Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;)V", "", "portraitVideoViewBottom", "I", "getPortraitVideoViewBottom", "()I", "setPortraitVideoViewBottom", "(I)V", "portraitVideoViewMarginTop", "getPortraitVideoViewMarginTop", "setPortraitVideoViewMarginTop", "isWormholePrePlay", "setWormholePrePlay", "sharePullStreamData", "getSharePullStreamData", "setSharePullStreamData", "Lorg/json/JSONObject;", "picoInfo", "Lorg/json/JSONObject;", "getPicoInfo", "()Lorg/json/JSONObject;", "setPicoInfo", "(Lorg/json/JSONObject;)V", "needRePullStream", "getNeedRePullStream", "setNeedRePullStream", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;)V", "hasDefaultMultiStreamData", "getHasDefaultMultiStreamData", "setHasDefaultMultiStreamData", "defaultPullStreamUrl", "getDefaultPullStreamUrl", "setDefaultPullStreamUrl", "sdkParams", "getSdkParams", "setSdkParams", "defaultMultiPullStreamData", "getDefaultMultiPullStreamData", "setDefaultMultiPullStreamData", "defaultResolution", "getDefaultResolution", "setDefaultResolution", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;", "streamSrConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;", "getStreamSrConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;", "setStreamSrConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;)V", "isSmoothEnterDoubleRender", "setSmoothEnterDoubleRender", "isSmoothLeaveDoubleRender", "setSmoothLeaveDoubleRender", "isVsRoom", "setVsRoom", "isPseudo", "setPseudo", "inPkMode", "getInPkMode", "setInPkMode", "isMediaRoomEnding", "setMediaRoomEnding", "isPreEnter", "setPreEnter", "isFromLongerVideoHorizontal", "setFromLongerVideoHorizontal", "isEnterFromPreviewLiveMix", "setEnterFromPreviewLiveMix", "isEnterFromDetailPreview", "setEnterFromDetailPreview", "enterSmooth", "getEnterSmooth", "setEnterSmooth", "reqSmoothLeave", "getReqSmoothLeave", "setReqSmoothLeave", "isSwitchingSubCamera", "setSwitchingSubCamera", "currentSubSteamKey", "getCurrentSubSteamKey", "setCurrentSubSteamKey", "enableSplitBackendRequest", "getEnableSplitBackendRequest", "setEnableSplitBackendRequest", "isLiveHeadEnterSmooth", "setLiveHeadEnterSmooth", "liveEndAutoPageChange", "value", "preLoadRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getPreLoadRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setPreLoadRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService;", "roomLog", "Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService;", "getRoomLog", "()Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "getRoom", "setRoom", "getScreenOrientation", "setScreenOrientation", "screenOrientation", "Lkotlin/Pair;", "getVideoSize", "()Lkotlin/Pair;", QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, "<init>", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService;)V", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomBaseSession implements IRoomSession {
    private f apmTraceAPMMonitor;
    private i autoPageChangeManager;
    private boolean autoStartWhenResume;
    private a backendRoomController;
    private final Context context;
    private LiveRoomState curState;
    private String currentSubSteamKey;
    private DataCenter dataCenter;
    private String defaultMultiPullStreamData;
    private String defaultPullStreamUrl;
    private String defaultResolution;
    private boolean enableSplitBackendRequest;
    private r0 enterInfo;
    private p enterRoomController;
    private boolean enterSmooth;
    private p0 eventHub;
    private q81.i extensionMonitor;
    private IExternalConfigJudger externalConfigJudger;
    private Bundle extra;
    private boolean firstShow;
    private Function0<? extends Fragment> getFragment;
    private boolean hasDefaultMultiStreamData;
    private boolean hasEndOnce;
    private boolean hasRoomPreloaded;
    private boolean hasRoomPrepare;
    private boolean inPkMode;
    private LiveInnerStateManager innerStateManager;
    private boolean isCustomizeAudioRoom;
    private boolean isEnterFromDetailPreview;
    private boolean isEnterFromPreviewLiveMix;
    private boolean isFromLongerVideoHorizontal;
    private boolean isInner;
    private boolean isLiveHeadEnterSmooth;
    private boolean isMediaRoomEnding;
    private boolean isPreEnter;
    private boolean isPseudo;
    private boolean isSmoothEnterDoubleRender;
    private boolean isSmoothLeaveDoubleRender;
    private boolean isStopPlayerForNextRoomPrePullStream;
    private boolean isSwitchingSubCamera;
    private boolean isVideoHorizontal;
    private boolean isVsRoom;
    private boolean isWormholePrePlay;
    private String jointAnchorId;
    private final String labels;
    private String linkUserId;
    private Dialog liveAbnormalFinishDialog;
    public boolean liveEndAutoPageChange;
    private boolean liveIllegal;
    private boolean livePaused;
    private LiveRequest liveRequest;
    private String logSession;
    private long micRoomPrePullId;
    private boolean needRePullStream;
    private String nickName;
    private e orientationSwitchStateFetcher;
    private boolean paidStreamUrlInvalid;
    private JSONObject picoInfo;
    private int portraitVideoViewBottom;
    private int portraitVideoViewMarginTop;
    private a preBackendRoomController;
    private p preEnterRoomController;
    private p.a preEnterRoomListener;
    private Room preLoadRoom;
    private boolean reqSmoothLeave;
    private long roomId;
    private final IRoomLogService roomLog;
    private e roomPreloadFetcher;
    private e roomPreloadFetcherV2;
    private IRoomPreloadTaskManager roomPreloadTaskManager;
    private e roomStateFetcher;
    private String sdkParams;
    private String sharePullStreamData;
    private final MutableLiveData<Room> splitEnterData;
    private StreamUrlExtra.SrConfig streamSrConfig;
    private LiveMode streamType;
    private StreamUrl streamUrl;
    private String userId;
    private e userRoomFetcher;

    public abstract boolean disableTextureRender();

    public abstract LifecycleOwner getLifecycleOwner();

    public abstract String getPullData();

    public abstract Room getRoom();

    public abstract int getScreenOrientation();

    public abstract Pair<Integer, Integer> getVideoSize();

    public abstract void logRoomDuration();

    public abstract void logRoomExit(long r100, ls2.e r101);

    public void setBackendRoomContext(BackendGeneratedData r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    public abstract void setLifecycleOwner(LifecycleOwner r100);

    public abstract void setRoom(Room r100);

    public abstract void setRoomLoggerEndReason(EndReason r100);

    public abstract void setScreenOrientation(int r100);

    public void setupRoomContextRoom(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
    }

    public void updateLastEnterRoomTask(Function0<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
    }

    public void updateStreamLog() {
    }

    public final EnterRoomInfo getEnterRoomInfo() {
        EnterRoomInfo r100 = new EnterRoomInfo();
        r100.setEnterRoomSource(RoomEnterInfoExtKt.a(this.enterInfo));
        r100.setEnterRoomType(this.enterInfo.f111125a);
        String r101 = this.enterInfo.f111137m;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setLinkerMap(r101);
        String r103 = this.enterInfo.f111128d;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.setEnterMerge(r103);
        String r104 = this.enterInfo.f111130f;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r100.setEnterMethod(r104);
        String r105 = this.enterInfo.f111125a;
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        r100.setEnterType(r102);
        r100.setUiLayout(this.enterInfo.f111138n);
        return r100;
    }

    public final long getRoomIdWithMicRoom() {
        long r100 = this.micRoomPrePullId;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.roomId;
    }

    public void initialize() {
        String r100 = getUidFromEnterRoomArgs(this.extra);
        if (r100 != null) goto L5;
        r100 = "0";
    L5:
        this.userId = r100;
        if (this.enterInfo.G == true) goto L8;
    L10:
        boolean r101 = false;
        if (this.isVsRoom == true) goto L14;
        r101 = this.extra.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_PSEUDO_LIVING, false);
    L14:
        this.isPseudo = r101;
        if (this.roomId == 0) goto L17;
    L20:
        LiveRoomState r102 = LiveRoomState.INITIALIZED;
    L21:
        setCurState(r102);
        return;
    L17:
        if (q0.a(this.userId) == true) goto L20;
        r102 = LiveRoomState.IDLE;
        goto L21
    L8:
        if (q0.a(r100) == false) goto L10;
        this.roomId = 0;
        goto L10
    }

    public final f getApmTraceAPMMonitor() {
        return this.apmTraceAPMMonitor;
    }

    public final i getAutoPageChangeManager() {
        return this.autoPageChangeManager;
    }

    public final boolean getAutoStartWhenResume() {
        return this.autoStartWhenResume;
    }

    public final a getBackendRoomController() {
        return this.backendRoomController;
    }

    public final Context getContext() {
        return this.context;
    }

    public LiveRoomState getCurState() {
        return this.curState;
    }

    public final String getCurrentSubSteamKey() {
        return this.currentSubSteamKey;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final String getDefaultMultiPullStreamData() {
        return this.defaultMultiPullStreamData;
    }

    public final String getDefaultPullStreamUrl() {
        return this.defaultPullStreamUrl;
    }

    public final String getDefaultResolution() {
        return this.defaultResolution;
    }

    public final boolean getEnableSplitBackendRequest() {
        return this.enableSplitBackendRequest;
    }

    public final r0 getEnterInfo() {
        return this.enterInfo;
    }

    public final p getEnterRoomController() {
        return this.enterRoomController;
    }

    public boolean getEnterSmooth() {
        return this.enterSmooth;
    }

    public final p0 getEventHub() {
        return this.eventHub;
    }

    public final q81.i getExtensionMonitor() {
        return this.extensionMonitor;
    }

    public final IExternalConfigJudger getExternalConfigJudger() {
        return this.externalConfigJudger;
    }

    public final Bundle getExtra() {
        return this.extra;
    }

    public final boolean getFirstShow() {
        return this.firstShow;
    }

    public final Function0<Fragment> getGetFragment() {
        return this.getFragment;
    }

    public final boolean getHasDefaultMultiStreamData() {
        return this.hasDefaultMultiStreamData;
    }

    public final boolean getHasEndOnce() {
        return this.hasEndOnce;
    }

    public final boolean getHasRoomPreloaded() {
        return this.hasRoomPreloaded;
    }

    public final boolean getHasRoomPrepare() {
        return this.hasRoomPrepare;
    }

    public final boolean getInPkMode() {
        return this.inPkMode;
    }

    public final LiveInnerStateManager getInnerStateManager() {
        return this.innerStateManager;
    }

    public final String getJointAnchorId() {
        return this.jointAnchorId;
    }

    public final String getLabels() {
        return this.labels;
    }

    public final String getLinkUserId() {
        return this.linkUserId;
    }

    public final Dialog getLiveAbnormalFinishDialog() {
        return this.liveAbnormalFinishDialog;
    }

    public final boolean getLiveIllegal() {
        return this.liveIllegal;
    }

    public final boolean getLivePaused() {
        return this.livePaused;
    }

    public final LiveRequest getLiveRequest() {
        return this.liveRequest;
    }

    public final String getLogSession() {
        return this.logSession;
    }

    public final long getMicRoomPrePullId() {
        return this.micRoomPrePullId;
    }

    public final boolean getNeedRePullStream() {
        return this.needRePullStream;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final e getOrientationSwitchStateFetcher() {
        return this.orientationSwitchStateFetcher;
    }

    public final boolean getPaidStreamUrlInvalid() {
        return this.paidStreamUrlInvalid;
    }

    public final JSONObject getPicoInfo() {
        return this.picoInfo;
    }

    public final int getPortraitVideoViewBottom() {
        return this.portraitVideoViewBottom;
    }

    public final int getPortraitVideoViewMarginTop() {
        return this.portraitVideoViewMarginTop;
    }

    public final a getPreBackendRoomController() {
        return this.preBackendRoomController;
    }

    public final p getPreEnterRoomController() {
        return this.preEnterRoomController;
    }

    public final p.a getPreEnterRoomListener() {
        return this.preEnterRoomListener;
    }

    public final Room getPreLoadRoom() {
        return this.preLoadRoom;
    }

    public boolean getReqSmoothLeave() {
        return this.reqSmoothLeave;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final IRoomLogService getRoomLog() {
        return this.roomLog;
    }

    public final e getRoomPreloadFetcher() {
        return this.roomPreloadFetcher;
    }

    public final e getRoomPreloadFetcherV2() {
        return this.roomPreloadFetcherV2;
    }

    public final IRoomPreloadTaskManager getRoomPreloadTaskManager() {
        return this.roomPreloadTaskManager;
    }

    public final e getRoomStateFetcher() {
        return this.roomStateFetcher;
    }

    public final String getSdkParams() {
        return this.sdkParams;
    }

    public final String getSharePullStreamData() {
        return this.sharePullStreamData;
    }

    public final MutableLiveData<Room> getSplitEnterData() {
        return this.splitEnterData;
    }

    public final StreamUrlExtra.SrConfig getStreamSrConfig() {
        return this.streamSrConfig;
    }

    public final LiveMode getStreamType() {
        return this.streamType;
    }

    public final StreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final e getUserRoomFetcher() {
        return this.userRoomFetcher;
    }

    public final boolean isCustomizeAudioRoom() {
        return this.isCustomizeAudioRoom;
    }

    public final boolean isEnterFromDetailPreview() {
        return this.isEnterFromDetailPreview;
    }

    public final boolean isEnterFromPreviewLiveMix() {
        return this.isEnterFromPreviewLiveMix;
    }

    public final boolean isFromLongerVideoHorizontal() {
        return this.isFromLongerVideoHorizontal;
    }

    public final boolean isInner() {
        return this.isInner;
    }

    public final boolean isLiveHeadEnterSmooth() {
        return this.isLiveHeadEnterSmooth;
    }

    public final boolean isMediaRoomEnding() {
        return this.isMediaRoomEnding;
    }

    public final boolean isPreEnter() {
        return this.isPreEnter;
    }

    public final boolean isPseudo() {
        return this.isPseudo;
    }

    public final boolean isSmoothEnterDoubleRender() {
        return this.isSmoothEnterDoubleRender;
    }

    public final boolean isSmoothLeaveDoubleRender() {
        return this.isSmoothLeaveDoubleRender;
    }

    public final boolean isStopPlayerForNextRoomPrePullStream() {
        return this.isStopPlayerForNextRoomPrePullStream;
    }

    public final boolean isSwitchingSubCamera() {
        return this.isSwitchingSubCamera;
    }

    public final boolean isVideoHorizontal() {
        return this.isVideoHorizontal;
    }

    public final boolean isVsRoom() {
        return this.isVsRoom;
    }

    public final boolean isWormholePrePlay() {
        return this.isWormholePrePlay;
    }

    private final String getUidFromEnterRoomArgs(Bundle r100) {
        o0.f58946a.getClass();
        String r101 = o0.a.c(r100, ILiveRoomPlayFragmentConstant.EXTRA_USER_ID, "0");
        if (q0.a(r101) == false) goto L5;
        return r101;
    L5:
        String r102 = o0.a.c(r100, "anchor_id", "0");
        if (q0.a(r102) == true) goto L10;
        return null;
    L10:
        return r102;
    }

    public final void setApmTraceAPMMonitor(f r100) {
        this.apmTraceAPMMonitor = r100;
    }

    public final void setAutoPageChangeManager(i r100) {
        this.autoPageChangeManager = r100;
    }

    public final void setAutoStartWhenResume(boolean r100) {
        this.autoStartWhenResume = r100;
    }

    public final void setBackendRoomController(a r100) {
        this.backendRoomController = r100;
    }

    public void setCurState(LiveRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.curState = r100;
    }

    public final void setCurrentSubSteamKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentSubSteamKey = r100;
    }

    public final void setCustomizeAudioRoom(boolean r100) {
        this.isCustomizeAudioRoom = r100;
    }

    public final void setDataCenter(DataCenter r100) {
        this.dataCenter = r100;
    }

    public final void setDefaultMultiPullStreamData(String r100) {
        this.defaultMultiPullStreamData = r100;
    }

    public final void setDefaultPullStreamUrl(String r100) {
        this.defaultPullStreamUrl = r100;
    }

    public final void setDefaultResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultResolution = r100;
    }

    public final void setEnableSplitBackendRequest(boolean r100) {
        this.enableSplitBackendRequest = r100;
    }

    public final void setEnterFromDetailPreview(boolean r100) {
        this.isEnterFromDetailPreview = r100;
    }

    public final void setEnterFromPreviewLiveMix(boolean r100) {
        this.isEnterFromPreviewLiveMix = r100;
    }

    public final void setEnterInfo(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterInfo = r100;
    }

    public final void setEnterRoomController(p r100) {
        this.enterRoomController = r100;
    }

    public void setEnterSmooth(boolean r100) {
        this.enterSmooth = r100;
    }

    public final void setEventHub(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventHub = r100;
    }

    public final void setExtensionMonitor(q81.i r100) {
        this.extensionMonitor = r100;
    }

    public final void setExternalConfigJudger(IExternalConfigJudger r100) {
        this.externalConfigJudger = r100;
    }

    public final void setExtra(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setFirstShow(boolean r100) {
        this.firstShow = r100;
    }

    public final void setFromLongerVideoHorizontal(boolean r100) {
        this.isFromLongerVideoHorizontal = r100;
    }

    public final void setGetFragment(Function0<? extends Fragment> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.getFragment = r100;
    }

    public final void setHasDefaultMultiStreamData(boolean r100) {
        this.hasDefaultMultiStreamData = r100;
    }

    public final void setHasEndOnce(boolean r100) {
        this.hasEndOnce = r100;
    }

    public final void setHasRoomPreloaded(boolean r100) {
        this.hasRoomPreloaded = r100;
    }

    public final void setHasRoomPrepare(boolean r100) {
        this.hasRoomPrepare = r100;
    }

    public final void setInPkMode(boolean r100) {
        this.inPkMode = r100;
    }

    public final void setInner(boolean r100) {
        this.isInner = r100;
    }

    public final void setInnerStateManager(LiveInnerStateManager r100) {
        this.innerStateManager = r100;
    }

    public final void setJointAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jointAnchorId = r100;
    }

    public final void setLinkUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkUserId = r100;
    }

    public final void setLiveAbnormalFinishDialog(Dialog r100) {
        this.liveAbnormalFinishDialog = r100;
    }

    public final void setLiveHeadEnterSmooth(boolean r100) {
        this.isLiveHeadEnterSmooth = r100;
    }

    public final void setLiveIllegal(boolean r100) {
        this.liveIllegal = r100;
    }

    public final void setLivePaused(boolean r100) {
        this.livePaused = r100;
    }

    public final void setLiveRequest(LiveRequest r100) {
        this.liveRequest = r100;
    }

    public final void setLogSession(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logSession = r100;
    }

    public final void setMediaRoomEnding(boolean r100) {
        this.isMediaRoomEnding = r100;
    }

    public final void setMicRoomPrePullId(long r100) {
        this.micRoomPrePullId = r100;
    }

    public final void setNeedRePullStream(boolean r100) {
        this.needRePullStream = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setOrientationSwitchStateFetcher(e r100) {
        this.orientationSwitchStateFetcher = r100;
    }

    public final void setPaidStreamUrlInvalid(boolean r100) {
        this.paidStreamUrlInvalid = r100;
    }

    public final void setPicoInfo(JSONObject r100) {
        this.picoInfo = r100;
    }

    public final void setPortraitVideoViewBottom(int r100) {
        this.portraitVideoViewBottom = r100;
    }

    public final void setPortraitVideoViewMarginTop(int r100) {
        this.portraitVideoViewMarginTop = r100;
    }

    public final void setPreBackendRoomController(a r100) {
        this.preBackendRoomController = r100;
    }

    public final void setPreEnter(boolean r100) {
        this.isPreEnter = r100;
    }

    public final void setPreEnterRoomController(p r100) {
        this.preEnterRoomController = r100;
    }

    public final void setPreEnterRoomListener(p.a r100) {
        this.preEnterRoomListener = r100;
    }

    public final void setPreLoadRoom(Room r100) {
        this.preLoadRoom = r100;
        if (r100 == null) goto L12;
        this.streamType = r100.getStreamType();
        IRoomBasisData r101 = r100.getBasisRoomData();
        if (r101 == null) goto L9;
        Boolean r102 = r101.isCustomizeAudioRoom();
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        this.isCustomizeAudioRoom = r103;
        return;
    L9:
        r103 = false;
        goto L10
    }

    public final void setPseudo(boolean r100) {
        this.isPseudo = r100;
    }

    public void setReqSmoothLeave(boolean r100) {
        this.reqSmoothLeave = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setRoomPreloadFetcher(e r100) {
        this.roomPreloadFetcher = r100;
    }

    public final void setRoomPreloadFetcherV2(e r100) {
        this.roomPreloadFetcherV2 = r100;
    }

    public final void setRoomPreloadTaskManager(IRoomPreloadTaskManager r100) {
        this.roomPreloadTaskManager = r100;
    }

    public final void setRoomStateFetcher(e r100) {
        this.roomStateFetcher = r100;
    }

    public final void setSdkParams(String r100) {
        this.sdkParams = r100;
    }

    public final void setSharePullStreamData(String r100) {
        this.sharePullStreamData = r100;
    }

    public final void setSmoothEnterDoubleRender(boolean r100) {
        this.isSmoothEnterDoubleRender = r100;
    }

    public final void setSmoothLeaveDoubleRender(boolean r100) {
        this.isSmoothLeaveDoubleRender = r100;
    }

    public final void setStopPlayerForNextRoomPrePullStream(boolean r100) {
        this.isStopPlayerForNextRoomPrePullStream = r100;
    }

    public final void setStreamSrConfig(StreamUrlExtra.SrConfig r100) {
        this.streamSrConfig = r100;
    }

    public final void setStreamType(LiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamType = r100;
    }

    public final void setStreamUrl(StreamUrl r100) {
        this.streamUrl = r100;
    }

    public final void setSwitchingSubCamera(boolean r100) {
        this.isSwitchingSubCamera = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public final void setUserRoomFetcher(e r100) {
        this.userRoomFetcher = r100;
    }

    public final void setVideoHorizontal(boolean r100) {
        this.isVideoHorizontal = r100;
    }

    public final void setVsRoom(boolean r100) {
        this.isVsRoom = r100;
    }

    public final void setWormholePrePlay(boolean r100) {
        this.isWormholePrePlay = r100;
    }

    public RoomBaseSession(Context r100, Bundle r101, IRoomLogService r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "extra");
        Intrinsics.checkNotNullParameter(r102, "roomLog");
        this.context = r100;
        this.extra = r101;
        this.roomLog = r102;
        this.curState = LiveRoomState.IDLE;
        this.eventHub = new p0();
        this.enterInfo = new r0(this.extra);
        Bundle r103 = this.extra;
        Intrinsics.checkNotNullParameter(r103, "$this$isPaidShareStreamUrlInValid");
        this.paidStreamUrlInvalid = r103.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_PAID_SHARE_STREAM_URL_INVALID, false);
        this.userId = "0";
        this.streamType = LiveMode.VIDEO;
        this.linkUserId = "";
        this.jointAnchorId = "";
        this.logSession = "";
        this.labels = "";
        this.getFragment = RoomBaseSession$getFragment$1.INSTANCE;
        this.splitEnterData = new MutableLiveData();
        this.sharePullStreamData = yt2.a.e(this.extra, ILiveRoomPlayFragmentConstant.EXTRA_PULL_SHARE_URL);
        this.defaultPullStreamUrl = this.extra.getString(ILiveRoomPlayFragmentConstant.EXTRA_PULL_STREAM_URL);
        this.sdkParams = "";
        if (this.enterInfo.f111142r.getDefaultCameraId() <= 0) goto L5;
    L4:
        String r104 = "";
    L8:
        this.defaultMultiPullStreamData = r104;
        this.defaultResolution = PlayerResolution.SDKKEY.ORIGIN;
        this.enterSmooth = this.extra.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PREVIEW_SMOOTH, false);
        this.reqSmoothLeave = this.extra.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_REQ_FORCE_SMOOTH_LEAVE, false);
        this.currentSubSteamKey = "";
        this.isLiveHeadEnterSmooth = this.extra.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_HEAD_ENTER_SMOOTH, false);
        return;
    L5:
        r104 = m0.d(this.extra);
        if (r104 != null) goto L8;
        goto L8
    }
}
