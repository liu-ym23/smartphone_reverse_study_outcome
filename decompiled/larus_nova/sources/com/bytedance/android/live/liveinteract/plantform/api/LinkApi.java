package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LayoutConfigResponseData;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.model.b1;
import com.bytedance.android.live.liveinteract.plantform.model.d1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.k;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.IGetMVListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.IGetMVTabListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.l2;
import com.bytedance.android.livesdk.chatroom.model.interact.n;
import com.bytedance.android.livesdk.chatroom.model.interact.o;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.model.interact.t0;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.chatroom.model.l1;
import com.bytedance.android.livesdk.chatroom.model.o2;
import com.bytedance.android.livesdk.chatroom.model.w1;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.android.livesdk.message.linker.d;
import com.bytedance.android.livesdk.message.linker.h;
import com.bytedance.android.livesdk.rank.model.c;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\n¦\u0001§\u0001¨\u0001©\u0001ª\u0001JR\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH'J\\\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'JF\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0005H'J(\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u000fH'JN\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\tH'J4\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020\u00052\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\tH'J2\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00052\b\b\u0001\u0010'\u001a\u00020\u0005H'J.\u0010+\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00052\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\tH'J2\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\tH'J<\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\u0005H'J2\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u0005H'JF\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\u00052\b\b\u0001\u00103\u001a\u00020\u000fH'J2\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\tH'J<\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\t2\b\b\u0001\u00106\u001a\u00020\u000fH'J2\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u0005H'J6\u00109\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\t2\b\b\u0001\u00108\u001a\u00020\u0005H'J<\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010:\u001a\u00020\u00022\b\b\u0001\u0010;\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0002H'J'\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\f0>2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b@\u0010AJ\u001e\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JH\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010D\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010E\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010F\u001a\u00020\u0005H'J4\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010I\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010J\u001a\u00020\u0005H'J4\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00140\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010D\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010E\u001a\u00020\u0005H'JJ\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\t2\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010P\u001a\u0004\u0018\u00010\tH'J>\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\t2\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\tH'J*\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010P\u001a\u0004\u0018\u00010\tH'J,\u0010Y\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010W\u001a\u00020\u00052\b\b\u0001\u0010X\u001a\u00020\u0005H'J0\u0010\\\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010ZH'J,\u0010_\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010]\u001a\u00020\u000f2\b\b\u0003\u0010^\u001a\u00020\u000fH'J:\u0010`\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010Z2\b\b\u0001\u0010F\u001a\u00020\u0005H'JI\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010c\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\be\u0010fJ*\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\tH'J\u001e\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\f0\u000b2\b\b\u0001\u0010g\u001a\u00020\u0002H'J\u001e\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JX\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0\u00140>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010l\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010m\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010o\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0011\u001a\u00020\u0002H'JH\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020t0\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010r\u001a\u00020\u00052\b\b\u0001\u0010s\u001a\u00020\u00052\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\tH'J(\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010v\u001a\u00020\u0002H'J2\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010v\u001a\u00020\u00022\b\b\u0001\u0010y\u001a\u00020\u0002H'JP\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010v\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010r\u001a\u00020\u00052\b\b\u0001\u0010,\u001a\u00020\t2\b\b\u0001\u0010-\u001a\u00020\tH'JX\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020 0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010{\u001a\u00020\t2\b\b\u0001\u0010|\u001a\u00020\u00052\b\b\u0001\u0010}\u001a\u00020\u000f2\n\b\u0001\u0010~\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u007f\u001a\u00020\u000f2\t\b\u0003\u0010\u0080\u0001\u001a\u00020\u0005H'J \u0010\u0083\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J:\u0010\u0087\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000b\b\u0001\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010\u0085\u0001\u001a\u0004\u0018\u00010\tH'J>\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020 0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000b\b\u0001\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010\u0085\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0001\u0010\u0089\u0001\u001a\u00020\u0005H'J@\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020 0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000b\b\u0001\u0010\u0085\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010\u008b\u0001\u001a\u0004\u0018\u00010\tH'J\u0015\u0010\u008d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0>H'JN\u0010\u0094\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u008e\u0001\u001a\u00020\u00052\n\b\u0001\u0010\u0090\u0001\u001a\u00030\u008f\u00012\n\b\u0001\u0010\u0091\u0001\u001a\u00030\u008f\u00012\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u0005H'J/\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020 0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\b\u0001\u00108\u001a\u00020\u0005H'JF\u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0097\u0001\u001a\u00020\t2\t\b\u0001\u0010\u0098\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0099\u0001\u001a\u00020\u0002H'J*\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u0005H'J@\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u00052\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\tH'J*\u0010\u009f\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u009e\u0001\u001a\u00020\u0002H'J \u0010¡\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030 \u00010\f0>2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010¤\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00010\f0>2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010¢\u0001\u001a\u0004\u0018\u00010\tH'¢\u0006\u0006\b¤\u0001\u0010¥\u0001¨\u0006«\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi;", "", "", "roomId", "linkerId", "", "fromScene", "toScene", "toUILayout", "", "reason", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/v1;", "switchScene", "", "isPassiveStart", "scene", Keys.API_EVENT_KEY_PLAY_MODE, "type", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/message/linker/d;", "changePlayMode", "usePlayModeInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k1;", "fetchPlayModeInfo", "content", "", "toUserIds", "", "toOpenIds", "extra", "Lcom/bytedance/android/live/network/response/a;", "sendSignalV1", "layout", "reqSource", "Lcom/bytedance/android/livesdk/chatroom/model/LinkFinishResult;", "finishV1", "position", "lockStatus", "Lcom/bytedance/android/livesdk/chatroom/model/l1;", "lockPostion", "positionName", "setPositionAttribute", "toUserId", "toUserIdString", "Lcom/bytedance/android/livesdk/chatroom/model/interact/r1;", LiveCommonConstants.REASON_SILENCE, "silenceType", "toRoomId", "silenceLinkRoom", "resumeLastSilence", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c2;", "unSilence", "enforced", "unSilenceLinkRoom", "updateType", "updateMcStatus", RemoteMessageConst.Notification.CHANNEL_ID, "toPosition", "Lcom/bytedance/android/livesdk/chatroom/model/interact/t0;", "updateLinkerPosition", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/message/linker/h;", "getLinkmicInfoWithRtcInfo", "(Ljava/lang/Long;)Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/link/model/bridge/i0;", "joinChannelV1", EffectConfiguration.KEY_CURSOR, "count", "source", "Lcom/bytedance/android/livesdk/chatroom/model/w1;", "getWaitingList", "uids", "waitingListType", "Lcom/bytedance/android/live/liveinteract/plantform/model/d1;", "getUserWaitingInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/b1;", "getPrepareApplyList", "secToUid", "reqFrom", "Lcom/bytedance/android/livesdk/chatroom/model/interact/l2;", "kickOut", "Lcom/bytedance/android/livesdk/chatroom/model/interact/t2;", "permit", "Lcom/bytedance/android/livesdk/chatroom/model/g1;", "leave", "action", "applyType", "applyStash", "", "query", "updateSetting", "open", "temp", "updateEnlargeStageSettings", "updateSettingV2", "secOwnerId", "ownerId", "ownerOpenId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/n;", "getSetting", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Single;", "banType", "Lbf2/a;", "getLatestBanRecord", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LayoutConfigResponseData;", "getLayouConfig", "secAnchorId", "secLinkerUserId", "anchor_open_id", "linker_open_id", "Lcom/bytedance/android/livesdk/rank/model/c;", "getLinkerRankList", "emojiType", "category", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/k;", "getTalkRoomEmojiList", "emojiId", "Lcom/bytedance/android/live/liveinteract/voicechat/model/a;", "sendTalkRoomEmoji", "emojiAction", "sendTalkRoomInteractEmoji", "giftIdListStr", "orderSingAutoEnlarge", "autoPlayMv", "auditionGiftIdListStr", "showGiftInfo", "giftId", "orderSingTurnOn", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IGetMVTabListResponse;", "getMvTab", "tabName", "itemId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IGetMVListResponse;", "getMvList", "vid", "mvType", "bindMvToItem", "closeSource", "closePlayingMv", "checkOpenChatRoomPermission", "subtitleStyle", "", "x", "y", "subtitleType", "Lcom/bytedance/android/livesdk/chatroom/model/interact/o;", "audioSubtitleOpen", "updateAudioSubtitleSetting", "targetUserId", "targetOpenId", "playId", "showType", "Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse;", "contributeShow", "status", "xplayInitCallback", "avatarId", "notifyAvatarChange", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/g;", "getAudienceSingEnableSetting", "rtcInfos", "Lcom/bytedance/android/livesdk/chatroom/model/o2;", "orderSingGenStreamInfo", "(Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "ApplyStashType", "OrderSingAutoEnlarge", "UpdateMcAction", "XplayInitCallbackScene", "XplayInitCallbackStatus", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkApi {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi$ApplyStashType;", "", "APPLY_WINDOW", "ONLINE_WINDOW", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ApplyStashType extends Enum<ApplyStashType> {
        public static final ApplyStashType APPLY_WINDOW = null;
        public static final ApplyStashType ONLINE_WINDOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ApplyStashType[] f75476a = null;

        static {
            ApplyStashType r100 = new ApplyStashType("APPLY_WINDOW", 0);
            APPLY_WINDOW = r100;
            ApplyStashType r101 = new ApplyStashType("ONLINE_WINDOW", 1);
            ONLINE_WINDOW = r101;
            f75476a = new ApplyStashType[]{r100, r101};
        }

        public static ApplyStashType valueOf(String r100) {
            return (ApplyStashType) r27.a.a(ApplyStashType.class, r100);
        }

        public static ApplyStashType[] values() {
            return (ApplyStashType[]) f75476a.clone();
        }

        public ApplyStashType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi$OrderSingAutoEnlarge;", "", "", "value", "I", "getValue", "()I", "ORDER_SING_AUTO_ENLARGE_UNKNOWN", "ORDER_SING_AUTO_ENLARGE_OPEN", "ORDER_SING_AUTO_ENLARGE_OFF", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OrderSingAutoEnlarge extends Enum<OrderSingAutoEnlarge> {
        public static final OrderSingAutoEnlarge ORDER_SING_AUTO_ENLARGE_OFF = null;
        public static final OrderSingAutoEnlarge ORDER_SING_AUTO_ENLARGE_OPEN = null;
        public static final OrderSingAutoEnlarge ORDER_SING_AUTO_ENLARGE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OrderSingAutoEnlarge[] f75477a = null;
        private final int value;

        static {
            OrderSingAutoEnlarge r100 = new OrderSingAutoEnlarge("ORDER_SING_AUTO_ENLARGE_UNKNOWN", 0, 0);
            ORDER_SING_AUTO_ENLARGE_UNKNOWN = r100;
            OrderSingAutoEnlarge r101 = new OrderSingAutoEnlarge("ORDER_SING_AUTO_ENLARGE_OPEN", 1, 1);
            ORDER_SING_AUTO_ENLARGE_OPEN = r101;
            OrderSingAutoEnlarge r102 = new OrderSingAutoEnlarge("ORDER_SING_AUTO_ENLARGE_OFF", 2, 2);
            ORDER_SING_AUTO_ENLARGE_OFF = r102;
            f75477a = new OrderSingAutoEnlarge[]{r100, r101, r102};
        }

        public static OrderSingAutoEnlarge valueOf(String r100) {
            return (OrderSingAutoEnlarge) r27.a.a(OrderSingAutoEnlarge.class, r100);
        }

        public static OrderSingAutoEnlarge[] values() {
            return (OrderSingAutoEnlarge[]) f75477a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public OrderSingAutoEnlarge(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi$UpdateMcAction;", "", UserProfileEvent.POSITION_NONE, "SET_KTV_HOST", "UNSET_KTV_HOST", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum UpdateMcAction extends Enum<UpdateMcAction> {
        public static final UpdateMcAction NONE = null;
        public static final UpdateMcAction SET_KTV_HOST = null;
        public static final UpdateMcAction UNSET_KTV_HOST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateMcAction[] f75478a = null;

        static {
            UpdateMcAction r100 = new UpdateMcAction(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            UpdateMcAction r101 = new UpdateMcAction("SET_KTV_HOST", 1);
            SET_KTV_HOST = r101;
            UpdateMcAction r102 = new UpdateMcAction("UNSET_KTV_HOST", 2);
            UNSET_KTV_HOST = r102;
            f75478a = new UpdateMcAction[]{r100, r101, r102};
        }

        public static UpdateMcAction valueOf(String r100) {
            return (UpdateMcAction) r27.a.a(UpdateMcAction.class, r100);
        }

        public static UpdateMcAction[] values() {
            return (UpdateMcAction[]) f75478a.clone();
        }

        public UpdateMcAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi$XplayInitCallbackScene;", "", "", "value", "I", "getValue", "()I", "SCENE_DEFAULT", "SCENE_AVATAR", "SCENE_DANMU", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum XplayInitCallbackScene extends Enum<XplayInitCallbackScene> {
        public static final XplayInitCallbackScene SCENE_AVATAR = null;
        public static final XplayInitCallbackScene SCENE_DANMU = null;
        public static final XplayInitCallbackScene SCENE_DEFAULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ XplayInitCallbackScene[] f75479a = null;
        private final int value;

        static {
            XplayInitCallbackScene r100 = new XplayInitCallbackScene("SCENE_DEFAULT", 0, 0);
            SCENE_DEFAULT = r100;
            XplayInitCallbackScene r101 = new XplayInitCallbackScene("SCENE_AVATAR", 1, 1);
            SCENE_AVATAR = r101;
            XplayInitCallbackScene r102 = new XplayInitCallbackScene("SCENE_DANMU", 2, 2);
            SCENE_DANMU = r102;
            f75479a = new XplayInitCallbackScene[]{r100, r101, r102};
        }

        public static XplayInitCallbackScene valueOf(String r100) {
            return (XplayInitCallbackScene) r27.a.a(XplayInitCallbackScene.class, r100);
        }

        public static XplayInitCallbackScene[] values() {
            return (XplayInitCallbackScene[]) f75479a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public XplayInitCallbackScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/api/LinkApi$XplayInitCallbackStatus;", "", "", "value", "I", "getValue", "()I", "STATUS_SUCCESS", "STATUS_FAIL", "STATUS_EXIT", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum XplayInitCallbackStatus extends Enum<XplayInitCallbackStatus> {
        public static final XplayInitCallbackStatus STATUS_EXIT = null;
        public static final XplayInitCallbackStatus STATUS_FAIL = null;
        public static final XplayInitCallbackStatus STATUS_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ XplayInitCallbackStatus[] f75480a = null;
        private final int value;

        static {
            XplayInitCallbackStatus r100 = new XplayInitCallbackStatus("STATUS_SUCCESS", 0, 0);
            STATUS_SUCCESS = r100;
            XplayInitCallbackStatus r101 = new XplayInitCallbackStatus("STATUS_FAIL", 1, 1);
            STATUS_FAIL = r101;
            XplayInitCallbackStatus r102 = new XplayInitCallbackStatus("STATUS_EXIT", 2, 2);
            STATUS_EXIT = r102;
            f75480a = new XplayInitCallbackStatus[]{r100, r101, r102};
        }

        public static XplayInitCallbackStatus valueOf(String r100) {
            return (XplayInitCallbackStatus) r27.a.a(XplayInitCallbackStatus.class, r100);
        }

        public static XplayInitCallbackStatus[] values() {
            return (XplayInitCallbackStatus[]) f75480a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public XplayInitCallbackStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public static /* synthetic */ Observable a(LinkApi r100, long r101, int r110, int r111, int r112) {
            return r100.getTalkRoomEmojiList(r101, r110, r111, r112, "");
        }
    }

    @GET("/webcast/linkmic_audience/apply_stash/")
    Single<com.bytedance.android.live.network.response.a> applyStash(@Query("room_id") long r100, @Query("action") int r101, @Query(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE) int r102);

    @GET("/webcast/linkmic_profit/audio_subtitle_open/")
    Observable<e<o>> audioSubtitleOpen(@Query("room_id") long r100, @Query("subtitle_style") int r101, @Query("x") float r102, @Query("y") float r103, @Query("subtitle_type") int r104);

    @GET("/webcast/linkmic_profit/bind_mv_to_item/")
    Observable<com.bytedance.android.live.network.response.a> bindMvToItem(@Query("room_id") long r100, @Query("video_id") String r101, @Query("item_id") String r102, @Query("mv_type") int r103);

    @GET("/webcast/linkmic_audience/change_play_mode/")
    Single<Response<d>> changePlayMode(@Query("room_id") long r100, @Query("linker_id") long r101, @Query("scene") int r102, @Query(FastStartLiveConfig.PLAY_MODE) int r103, @Query("type") int r104);

    @GET("/webcast/linkmic_audience/check_chat_match_permission/")
    Observable<e<Object>> checkOpenChatRoomPermission();

    @GET("/webcast/linkmic_profit/close_mv/")
    Observable<com.bytedance.android.live.network.response.a> closePlayingMv(@Query("room_id") long r100, @Query("item_id") String r101, @Query("video_id") String r102, @Query("close_source") String r103);

    @GET("/webcast/linkmic_profit/contribute_show/")
    Observable<ContributeShowResponse> contributeShow(@Query("room_id") long r100, @Query("target_user_id") long r101, @Query("target_open_id") String r102, @Query(InstantPlayContext.PLAY_ID) long r103, @Query("show_type") long r104);

    @GET("/webcast/linkmic_audience/get_play_mode_info/")
    Single<e<k1>> fetchPlayModeInfo(@Query("room_id") long r100, @Query("use_play_mode_info") boolean r101);

    @GET("/webcast/linkmic_audience/finish/")
    Single<e<LinkFinishResult>> finishV1(@Query("room_id") long r100, @Query("layout") int r101, @Query("request_source") String r102);

    @GET("/webcast/ktv/get_ktv_component_setting/")
    Observable<e<g>> getAudienceSingEnableSetting(@Query("room_id") long r100);

    @GET("/webcast/review/get_latest_ban_record/")
    Single<e<bf2.a>> getLatestBanRecord(@Query("ban_type") long r100);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_layout_config/")
    Single<e<LayoutConfigResponseData>> getLayouConfig(@Query("room_id") long r100);

    @GET("/webcast/ranklist/linker/")
    Observable<Response<c>> getLinkerRankList(@Query("room_id") long r100, @Query("sec_anchor_id") String r101, @Query("sec_linker_user_id") String r102, @Query("anchor_open_id") String r103, @Query("linker_open_id") String r104, @Query("scene") long r105);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_linkmic_info_with_rtc_info/")
    Observable<e<h>> getLinkmicInfoWithRtcInfo(@Query("room_id") Long r100);

    @GET("/webcast/linkmic_profit/get_mv_list/")
    Observable<e<IGetMVListResponse>> getMvList(@Query("room_id") long r100, @Query("tab_id") String r101, @Query("item_id") String r102);

    @GET("/webcast/linkmic_profit/get_mv_tab_list/")
    Observable<e<IGetMVTabListResponse>> getMvTab(@Query("room_id") long r100);

    @GET("/webcast/linkmic_audience/prepare_apply_list/")
    Single<Response<b1>> getPrepareApplyList(@Query("room_id") long r100, @Query(EffectConfiguration.KEY_CURSOR) String r101, @Query("count") int r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_settings/")
    Single<e<n>> getSetting(@Query("room_id") long r100, @Query("sec_owner_id") String r101);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_settings/")
    Single<e<n>> getSetting(@Query("room_id") long r100, @Query("sec_owner_id") String r101, @Query("owner_id") Long r102, @Query("owner_open_id") String r103);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list_emojis/")
    Observable<e<k>> getTalkRoomEmojiList(@Query("room_id") long r100, @Query("scene") int r101, @Query("type") int r102, @Query("category") int r103, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r104);

    @GET("/webcast/linkmic_audience/get_waiting_user_info/")
    Single<e<d1>> getUserWaitingInfo(@Query("room_id") long r100, @Query("user_ids") String r101, @Query("waiting_list_type") int r102);

    @GET("/webcast/linkmic_audience/waiting_list/")
    Single<e<w1>> getWaitingList(@Query("room_id") long r100, @Query(EffectConfiguration.KEY_CURSOR) String r101, @Query("count") long r102, @Query("type") int r103, @Query("source") int r104);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/join_channel/")
    Single<e<i0>> joinChannelV1(@Query("room_id") long r100);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/kick_out/")
    Single<e<l2>> kickOut(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r101, @Query("to_user_open_id") String r102, @Query("sec_to_user_id") String r103, @Query("request_source") String r104);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/leave/")
    Single<e<g1>> leave(@Query("room_id") long r100, @Query("request_source") String r101);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/lock_position/")
    Single<e<l1>> lockPostion(@Query("room_id") long r100, @Query("position") int r101, @Query("lock_status") int r102);

    @FormUrlEncoded
    @POST("/webcast/linkmic_profit/order_sing_update_hamlet_avatar/")
    Observable<e<Object>> notifyAvatarChange(@Field("room_id") long r100, @Field("avatar_id") long r101);

    @FormUrlEncoded
    @POST("/webcast/linkmic_profit/order_sing_gen_stream_info/")
    Observable<e<o2>> orderSingGenStreamInfo(@Field("room_id") Long r100, @Field("rtc_infos") String r101);

    @GET("/webcast/linkmic_profit/order_sing_turn_on/")
    Observable<com.bytedance.android.live.network.response.a> orderSingTurnOn(@Query("room_id") long r100, @Query("gift_id_list_str") String r101, @Query("order_sing_auto_enlarge") int r102, @Query("auto_play_mv") boolean r103, @Query("audition_gift_id_list_str") String r104, @Query("show_gift_info") boolean r105, @Query(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) int r106);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/permit/")
    Single<e<t2>> permit(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r101, @Query("to_user_open_id") String r102, @Query("sec_to_user_id") String r103);

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/send_signaling/")
    Single<com.bytedance.android.live.network.response.a> sendSignalV1(@Field("room_id") long r100, @Field("content") String r101, @Field("to_user_ids") long[] r102, @Field("to_user_open_ids") List<String> r103, @Field("extra") String r104);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/send_emoji/")
    Observable<e<com.bytedance.android.live.liveinteract.voicechat.model.a>> sendTalkRoomEmoji(@Query("room_id") long r100, @Query("emoji_id") long r101);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/send_emoji/")
    Observable<e<com.bytedance.android.live.liveinteract.voicechat.model.a>> sendTalkRoomEmoji(@Query("room_id") long r100, @Query("emoji_id") long r101, @Query("emoji_action") long r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/send_emoji/")
    Observable<e<com.bytedance.android.live.liveinteract.voicechat.model.a>> sendTalkRoomInteractEmoji(@Query("room_id") long r100, @Query("emoji_id") long r101, @Query("scene") int r102, @Query("type") int r103, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r104, @Query("to_user_open_id") String r105);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/set_position_attribute/")
    Single<com.bytedance.android.live.network.response.a> setPositionAttribute(@Query("room_id") long r100, @Query("position") int r101, @Query("position_name") String r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/silence/")
    Single<e<r1>> silence(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) long r101, @Query("to_user_open_id") String r102, @Query("silence_type") int r103, @Query("resume_last_silence") boolean r104);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/silence/")
    Single<e<r1>> silence(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r101, @Query("to_user_open_id") String r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/silence/")
    Single<e<r1>> silence(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r101, @Query("to_user_open_id") String r102, @Query("silence_type") int r103);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/silence/")
    Single<e<r1>> silenceLinkRoom(@Query("room_id") long r100, @Query("to_room_id") long r101, @Query("silence_type") int r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/switch_scene/")
    Single<e<v1>> switchScene(@Query("room_id") long r100, @Query("linker_id") long r101, @Query("from_scene") int r102, @Query("to_scene") int r103, @Query("to_ui_layout") int r104, @Query("reason") String r105);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/switch_scene/")
    Single<e<v1>> switchScene(@Query("room_id") long r100, @Query("linker_id") long r101, @Query("from_scene") int r102, @Query("to_scene") int r103, @Query("to_ui_layout") int r104, @Query("reason") String r105, @Query("passive_start") boolean r106);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/unsilence/")
    Single<e<c2>> unSilence(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) long r101, @Query("to_user_open_id") String r102, @Query("enforced") boolean r103);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/unsilence/")
    Single<e<c2>> unSilence(@Query("room_id") long r100, @Query(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) String r101, @Query("to_user_open_id") String r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/unsilence/")
    Single<e<c2>> unSilenceLinkRoom(@Query("room_id") long r100, @Query("to_room_id") long r101, @Query("un_silence_type") int r102);

    @GET("/webcast/linkmic_profit/update_audio_subtitle_settings/")
    Observable<com.bytedance.android.live.network.response.a> updateAudioSubtitleSetting(@Query("room_id") long r100, @Query("content") String r101, @Query(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE) int r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_enlarge_stage_settings/")
    Single<com.bytedance.android.live.network.response.a> updateEnlargeStageSettings(@Query("room_id") long r100, @Query("open") boolean r101, @Query("temporary_operation") boolean r102);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_position/")
    Single<e<t0>> updateLinkerPosition(@Query("room_id") long r100, @Query("channel_id") long r101, @Query("to_position") long r102, @Query("scene") long r103);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/ktv/update_mc/")
    Single<com.bytedance.android.live.network.response.a> updateMcStatus(@Field("room_id") long r100, @Field(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) long r101, @Query("to_open_id") String r102, @Field(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE) int r103);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_settings/")
    Single<com.bytedance.android.live.network.response.a> updateSetting(@Query("room_id") long r100, @QueryMap Map<String, Object> r101);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_settings/")
    Single<com.bytedance.android.live.network.response.a> updateSettingV2(@Query("room_id") long r100, @QueryMap Map<String, Object> r101, @Query("source") int r102);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/xplay_init_callback/")
    Observable<e<Object>> xplayInitCallback(@Field("room_id") long r100, @Field("status") int r101);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/xplay_init_callback/")
    Observable<e<Object>> xplayInitCallback(@Field("room_id") long r100, @Field("status") int r101, @Field("callback_scene") int r102, @Field("extra") String r103);
}
