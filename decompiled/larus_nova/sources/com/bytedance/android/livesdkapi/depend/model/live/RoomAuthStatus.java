package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomAuthStatus")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\bZ\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\n®\u0002¯\u0002°\u0002±\u0002²\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010â\u0001\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020<H\u0016J\u0012\u0010:\u001a\u00030ã\u00012\u0007\u0010ä\u0001\u001a\u00020\u0005H\u0016J\t\u0010å\u0001\u001a\u00020<H\u0016J\t\u0010æ\u0001\u001a\u00020<H\u0016J\b\u0010A\u001a\u00020<H\u0016J\u0007\u0010ç\u0001\u001a\u00020<J\t\u0010è\u0001\u001a\u00020<H\u0016J\t\u0010é\u0001\u001a\u00020<H\u0016J\b\u0010L\u001a\u00020<H\u0016J\t\u0010ê\u0001\u001a\u00020<H\u0016J\t\u0010ë\u0001\u001a\u00020<H\u0016J\t\u0010ì\u0001\u001a\u00020<H\u0016J\u0007\u0010í\u0001\u001a\u00020<J\t\u0010î\u0001\u001a\u00020<H\u0016J\u0007\u0010ï\u0001\u001a\u00020<J\u0007\u0010ð\u0001\u001a\u00020<J\u0007\u0010ñ\u0001\u001a\u00020<J\u0007\u0010ò\u0001\u001a\u00020<J\t\u0010ó\u0001\u001a\u00020<H\u0016J\u0007\u0010ô\u0001\u001a\u00020<J\t\u0010õ\u0001\u001a\u00020<H\u0016J\t\u0010ö\u0001\u001a\u00020<H\u0016J\t\u0010÷\u0001\u001a\u00020<H\u0016J\u0011\u0010Z\u001a\u00030ã\u00012\u0006\u0010Z\u001a\u00020\u0005H\u0016J\u0007\u0010ø\u0001\u001a\u00020<J\t\u0010ù\u0001\u001a\u00020<H\u0016J\f\u0010ú\u0001\u001a\u0005\u0018\u00010û\u0001H\u0016J\f\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J\t\u0010þ\u0001\u001a\u00020<H\u0016J\u0007\u0010ÿ\u0001\u001a\u00020<J\t\u0010\u0080\u0002\u001a\u00020<H\u0016J\t\u0010\u0081\u0002\u001a\u00020<H\u0016J\t\u0010\u0082\u0002\u001a\u00020<H\u0016J\t\u0010\u0083\u0002\u001a\u00020<H\u0016J\t\u0010\u0084\u0002\u001a\u00020<H\u0016J\t\u0010\u0085\u0002\u001a\u00020<H\u0016J\t\u0010\u0086\u0002\u001a\u00020<H\u0016J\t\u0010\u0087\u0002\u001a\u00020<H\u0016J\t\u0010\u0088\u0002\u001a\u00020<H\u0016J\t\u0010\u0089\u0002\u001a\u00020<H\u0016J\t\u0010\u008a\u0002\u001a\u00020<H\u0016J\t\u0010\u008b\u0002\u001a\u00020<H\u0016J\t\u0010\u008c\u0002\u001a\u00020<H\u0016J\u0010\u0010\u008d\u0002\u001a\u00020<2\u0007\u0010\u008e\u0002\u001a\u00020<J\t\u0010\u008f\u0002\u001a\u00020<H\u0016J\t\u0010\u0090\u0002\u001a\u00020<H\u0016J\t\u0010\u0091\u0002\u001a\u00020<H\u0016J\t\u0010\u0092\u0002\u001a\u00020<H\u0016J\t\u0010\u0093\u0002\u001a\u00020<H\u0016J\t\u0010\u0094\u0002\u001a\u00020<H\u0016J\t\u0010\u0095\u0002\u001a\u00020<H\u0016J\t\u0010\u0096\u0002\u001a\u00020<H\u0016J\t\u0010\u0097\u0002\u001a\u00020<H\u0016J\t\u0010\u0098\u0002\u001a\u00020<H\u0016J\t\u0010\u0099\u0002\u001a\u00020<H\u0016J\t\u0010\u009a\u0002\u001a\u00020<H\u0016J\t\u0010\u009b\u0002\u001a\u00020<H\u0016J\t\u0010\u009c\u0002\u001a\u00020<H\u0016J\t\u0010\u009d\u0002\u001a\u00020<H\u0016J\t\u0010\u009e\u0002\u001a\u00020<H\u0016J\t\u0010\u009f\u0002\u001a\u00020<H\u0016J\t\u0010 \u0002\u001a\u00020<H\u0016J\t\u0010¡\u0002\u001a\u00020<H\u0016J\t\u0010¢\u0002\u001a\u00020<H\u0016J\t\u0010£\u0002\u001a\u00020<H\u0016J\t\u0010¤\u0002\u001a\u00020<H\u0016J\t\u0010¥\u0002\u001a\u00020<H\u0016J\u0010\u0010¦\u0002\u001a\u00030ã\u00012\u0006\u0010T\u001a\u00020<J\u0010\u0010§\u0002\u001a\u00030ã\u00012\u0006\u0010~\u001a\u00020\u0005J\u0011\u0010¨\u0002\u001a\u00030ã\u00012\u0007\u0010\u0080\u0001\u001a\u00020\u0005J\u0011\u0010©\u0002\u001a\u00030ã\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0005J\u0011\u0010ª\u0002\u001a\u00030ã\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u0005J\u0016\u0010«\u0002\u001a\u00030ã\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J\n\u0010¬\u0002\u001a\u00030\u00ad\u0002H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001e\u0010\u001d\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u0012\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u0012\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001e\u0010(\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001e\u0010+\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u0012\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u001e\u00103\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001e\u00106\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u0012\u00109\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0012\u0010A\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010B\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u001e\u0010E\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010>\"\u0004\bG\u0010@R\u0012\u0010H\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010I\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010>\"\u0004\bK\u0010@R\u0012\u0010L\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010M\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010P\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010>\"\u0004\bS\u0010@R\u0012\u0010T\u001a\u00020<8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010U\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010V\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010W\u001a\u00020<8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010>\"\u0004\bY\u0010@R\u001e\u0010Z\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000fR\u0012\u0010]\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010^\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010_\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\r\"\u0004\ba\u0010\u000fR\u0012\u0010b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR\u0012\u0010f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010g\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR\u001e\u0010j\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\r\"\u0004\bl\u0010\u000fR\u0012\u0010m\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010o\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010p\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010q\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bq\u0010>R\u0011\u0010r\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\br\u0010>R\u0011\u0010s\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bs\u0010>R\u0011\u0010t\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bt\u0010>R\u0011\u0010u\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bu\u0010>R\u0012\u0010v\u001a\u00020<8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010w\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bw\u0010>R\u0011\u0010x\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bx\u0010>R\u0011\u0010y\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\by\u0010>R\u0011\u0010z\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bz\u0010>R\u0011\u0010{\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b{\u0010>R\u0012\u0010|\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010}\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010~\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u007f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0080\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0081\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0082\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0083\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0084\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0085\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0086\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0087\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0088\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0089\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008a\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008b\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008c\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008d\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008e\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008f\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010\u0090\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\r\"\u0005\b\u0092\u0001\u0010\u000fR!\u0010\u0093\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\r\"\u0005\b\u0095\u0001\u0010\u000fR\u0016\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0098\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010\u0099\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\r\"\u0005\b\u009b\u0001\u0010\u000fR\u0013\u0010\u009c\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010\u009d\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\r\"\u0005\b\u009f\u0001\u0010\u000fR!\u0010 \u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\r\"\u0005\b¢\u0001\u0010\u000fR!\u0010£\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\r\"\u0005\b¥\u0001\u0010\u000fR\u0013\u0010¦\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010§\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¨\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010©\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010ª\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\r\"\u0005\b¬\u0001\u0010\u000fR\u0013\u0010\u00ad\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010®\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\r\"\u0005\b°\u0001\u0010\u000fR!\u0010±\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\r\"\u0005\b³\u0001\u0010\u000fR\u0016\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¶\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010·\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¸\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¹\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010º\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010»\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¼\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010½\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¾\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010¿\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\r\"\u0005\bÁ\u0001\u0010\u000fR!\u0010Â\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\r\"\u0005\bÄ\u0001\u0010\u000fR\u0013\u0010Å\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Æ\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ç\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010È\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010\r\"\u0005\bÊ\u0001\u0010\u000fR\u0013\u0010Ë\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ì\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010Í\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\r\"\u0005\bÏ\u0001\u0010\u000fR!\u0010Ð\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010\r\"\u0005\bÒ\u0001\u0010\u000fR\u0013\u0010Ó\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ô\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Õ\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ö\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010×\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010\r\"\u0005\bÙ\u0001\u0010\u000fR\u0013\u0010Ú\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Û\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ü\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ý\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Þ\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R!\u0010ß\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\r\"\u0005\bá\u0001\u0010\u000f¨\u0006³\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "()V", "aiClone", "", "anchorAsr", "anchorColdMessageTiled", "anchorMission", "bulletStyle", "canSellPaidLiveTicket", "castScreen", "getCastScreen", "()J", "setCastScreen", "(J)V", "castScreenExplicit", "getCastScreenExplicit", "setCastScreenExplicit", "chatDispatch", "chatDynamicSlideSpeed", "chatDynamicSlideSpeedAnchor", "chatGuideEmoji", "chatGuideImage", "chatOperate", "clearEntranceOption", ShareChannel.COLLECT, "getCollect", "setCollect", "commerceCard", "getCommerceCard", "setCommerceCard", "commerceComponent", "commonCard", "getCommonCard", "setCommonCard", "countType", "danmakuDefault", "getDanmakuDefault", "setDanmakuDefault", "denounce", "getDenounce", "setDenounce", AppConstants.BUNDLE_DISLIKE, "getDislike", "setDislike", "douPlus", "douPlusPopularityGem", "downloadVideo", "getDownloadVideo", "setDownloadVideo", "ecomFansClubAuth", "getEcomFansClubAuth", "setEcomFansClubAuth", "enableAdminPinComment", "getEnableAdminPinComment", "setEnableAdminPinComment", "enableAnchorFans", "enableBanner", "enableChat", "", "getEnableChat", "()Z", "setEnableChat", "(Z)V", "enableChatMentionV2", "enableDanmaku", "getEnableDanmaku", "setEnableDanmaku", "enableDigg", "getEnableDigg", "setEnableDigg", "enableFrequentChat", "enableGift", "getEnableGift", "setEnableGift", "enableInteractionGift", "enableOpPanel", "enablePSSelectedMessage", "enablePinComment", "enablePinHighlight", "enablePoi", "getEnablePoi", "setEnablePoi", "enableRoomContributor", "enableRoomSecretChat", "enableShowLikeCount", "enableUserCard", "getEnableUserCard", "setEnableUserCard", "enableVideoShare", "getEnableVideoShare", "setEnableVideoShare", "enhancedTouch", "expandScreen", "fansClubAuth", "getFansClubAuth", "setFansClubAuth", "fansGroup", "fixChat", "getFixChat", "setFixChat", "fusionEmoji", "gamePointsPlaying", "getGamePointsPlaying", "setGamePointsPlaying", "highlightAreaContainer", "getHighlightAreaContainer", "setHighlightAreaContainer", "highlights", "hostTeam", "hourRank", "interactiveComponent", "isEnableAnchorAsr", "isEnableClearEntranceOption", "isEnableCollect", "isEnableLandscapeGift", "isEnableLongPressOption", "isEnableLuckMoney", "isEnableRoomChannel", "isEnableRoomChannelByAnchor", "isEnableRoomWidget", "isEnableStrokeUpDownGuide", "isEnableTimedShutdown", "itemShare", "ktvOrderSong", "landscape", "landscapeChat", "landscapeDynamic", "landscapeGift", "landscapeScreenCapture", "landscapeScreenRecording", "landscapeScreenShare", IStrategyStateSupplier.KEY_INFO_LIKE, "liveIMIndustryService", "loadFirstHistoryChat", "loadMoreHistoryChat", "longPressOption", "longTouch", "markUser", "mediaRoomLinkmic", "mediaRoomTypingCommentState", "messageDispatch", "missionCenter", "moreAnchor", "getMoreAnchor", "setMoreAnchor", "multiplierPlayback", "getMultiplierPlayback", "setMultiplierPlayback", "offReason", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$OffReason;", "onlyTa", "padPlay", "getPadPlay", "setPadPlay", "panelECService", "pcPlay", "getPcPlay", "setPcPlay", "playerRankList", "getPlayerRankList", "setPlayerRankList", "poster", "getPoster", "setPoster", "previewChatExpose", "previewDanmaku", "previewPosterCache", "projectScreenBarrage", "projectionBtn", "getProjectionBtn", "setProjectionBtn", "publicScreenMessageHeatStrategy", "quizGamePointsPlaying", "getQuizGamePointsPlaying", "setQuizGamePointsPlaying", "recordScreen", "getRecordScreen", "setRecordScreen", "roomAuthSpecialStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$RoomAuthSpecialStyle;", "roomChannel", "roomWidget", "seek", "selectionAlbum", "selectionEntrance", "shortTouch", "shortTouchTempState", "showGamePlugin", "showQualification", "showShare", "getShowShare", "setShowShare", "streamAdaptation", "getStreamAdaptation", "setStreamAdaptation", "strokeUpDownGuide", "teamChannel", "teleprompter", "timedShutdown", "getTimedShutdown", "setTimedShutdown", "toolbarBubble", "topic", "ugcVSReplayDelete", "getUgcVSReplayDelete", "setUgcVSReplayDelete", "ugcVsReplayVisibility", "getUgcVsReplayVisibility", "setUgcVsReplayVisibility", "upRightStatsFloatingLayer", "useHostInfo", "verticalRank", "verticalScreenShare", "videoAmplificationType", "getVideoAmplificationType", "setVideoAmplificationType", "vsCommentBar", "vsDouPlus", "vsFansClub", "vsTopic", "vsWelcomeDanmaku", "worldSquare", "getWorldSquare", "setWorldSquare", "adminPinCommentAction", "", "enable", "enableBulletStyle", "enableCastScreen", "enableEnhancedTouch", "enableFansClub", "enableHourRank", "enableLandscapeQuickRecord", "enableLandscapeQuickShot", "enableLandscapeScreenShare", "enableLongTouch", "enableOperateTopic", "enablePadPlay", "enablePcPlay", "enablePreviewPosterCache", "enableShortTouch", "enableTempShortTouch", "enableVSDouPlus", "enableVSFansClub", "enableVerticalRank", "enableVerticalScreenShare", "enableVsLike", "enableVsWelcomeDanmu", "getOffReason", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IOffReason;", "getRoomAuthSpecialStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IRoomAuthSpecialStyle;", "isAnchorColdMessageTiled", "isChatDispatch", "isChatGuideEmojiEnable", "isChatGuideImageEnable", "isDisableSelectionAlbum", "isDisableShare", "isEnableAIClone", "isEnableAnchorChannel", "isEnableAnchorChatDynamicSlideSpeed", "isEnableAudienceOpPanel", "isEnableChatDynamicSlideSpeed", "isEnableChatOperate", "isEnableDouPlus", "isEnableFirstFetchHistory", "isEnableFusionEmoji", "isEnableGamePointsPlaying", "isAnchor", "isEnableInteractivtyShare", "isEnableLandscapeChat", "isEnableLoadMoreHistory", "isEnableMarkUser", "isEnablePinHighlight", "isEnablePreviewDanmaku", "isEnableRecordScreen", "isEnableRoomContributor", "isEnableSecretChat", "isEnableShowLikeCount", "isEnableStableTopic", "isEnableSwitchLandscape", "isEnableUpRightStatsFloatingLayer", "isEnableWorldSquare", "isFrequentChatEnable", "isLandscapeDynamicSpeedStrategyEnable", "isMessageBreak", "isOrderSongOpened", "isPSSelectedMessageEnable", "isPanelECServiceEnable", "isPublicScreenMessageHeatStrategyEnable", "isShopFansClubMode", "isVSRoomEnableSeek", "setEnableRoomContributor", "setLandscape", "setLandscapeDynamic", "setMessageDispatch", "setPanelECService", "setRoomAuthSpecialStyle", "toString", "", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "CountType", "OffReason", "RoomAuthSpecialStyle", "Style", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomAuthStatus extends FlexModelBase<IRoomAuthStatus> implements IRoomAuthStatus, h {

    @SerializedName("AIClone")
    public long aiClone;

    @SerializedName("AnchorAudioChat")
    public long anchorAsr;

    @SerializedName("AnchorColdMessageTiled")
    public long anchorColdMessageTiled;

    @SerializedName("AnchorMission")
    public long anchorMission;

    @SerializedName("BulletStyle")
    public long bulletStyle;

    @SerializedName("CanSellTicket")
    public long canSellPaidLiveTicket;

    @SerializedName("CastScreen")
    protected long castScreen;

    @SerializedName("CastScreenExplicit")
    protected long castScreenExplicit;

    @SerializedName("ChatDispatch")
    public long chatDispatch;

    @SerializedName("ChatDynamicSlideSpeed")
    public long chatDynamicSlideSpeed;

    @SerializedName("ChatDynamicSlideSpeedAnchor")
    public long chatDynamicSlideSpeedAnchor;

    @SerializedName("ChatGuideEmoji")
    public long chatGuideEmoji;

    @SerializedName("ChatGuideImage")
    public long chatGuideImage;

    @SerializedName("ChatOperate")
    public long chatOperate;

    @SerializedName("ClearEntranceOption")
    public long clearEntranceOption;

    @SerializedName("Collect")
    protected long collect;

    @SerializedName("CommerceCard")
    protected long commerceCard;

    @SerializedName("CommerceComponent")
    public long commerceComponent;

    @SerializedName("CommonCard")
    protected long commonCard;

    @SerializedName("CountType")
    public long countType;

    @SerializedName("DanmakuDefault")
    protected long danmakuDefault;

    @SerializedName("Denounce")
    protected long denounce;

    @SerializedName("Dislike")
    protected long dislike;

    @SerializedName("DouPlus")
    public long douPlus;

    @SerializedName("DouPlusPopularityGem")
    public long douPlusPopularityGem;

    @SerializedName("DownloadVideo")
    protected long downloadVideo;

    @SerializedName("EcomFansClub")
    protected long ecomFansClubAuth;

    @SerializedName("AdminCommentWall")
    protected long enableAdminPinComment;

    @SerializedName("RoomAnchorFansChannel")
    public long enableAnchorFans;

    @SerializedName("Banner")
    public long enableBanner;

    @SerializedName("Chat")
    protected boolean enableChat;

    @SerializedName("ChatMentionV2")
    public long enableChatMentionV2;

    @SerializedName("Danmaku")
    protected boolean enableDanmaku;

    @SerializedName("Digg")
    protected boolean enableDigg;

    @SerializedName("FrequentlyChat")
    public long enableFrequentChat;

    @SerializedName("Gift")
    protected boolean enableGift;

    @SerializedName("InteractionGift")
    public long enableInteractionGift;

    @SerializedName("RoomChatOperatePanel")
    public long enableOpPanel;

    @SerializedName("FeaturedPublicScreen")
    public long enablePSSelectedMessage;

    @SerializedName("CommentWall")
    public long enablePinComment;

    @SerializedName("RoomPinHighlight")
    public long enablePinHighlight;

    @SerializedName("POI")
    protected boolean enablePoi;

    @SerializedName("RoomContributor")
    public boolean enableRoomContributor;

    @SerializedName("RoomSecretChat")
    public long enableRoomSecretChat;

    @SerializedName("RoomChatLikeDisplay")
    public long enableShowLikeCount;

    @SerializedName("UserCard")
    protected boolean enableUserCard;

    @SerializedName("VideoShare")
    protected long enableVideoShare;

    @SerializedName("EnhancedTouch")
    public long enhancedTouch;

    @SerializedName("ExpandScreen")
    public long expandScreen;

    @SerializedName("FansClub")
    protected long fansClubAuth;

    @SerializedName("FansGroup")
    public long fansGroup;

    @SerializedName("FixedChat")
    protected long fixChat;

    @SerializedName("FusionEmoji")
    public long fusionEmoji;

    @SerializedName("GamePointsPlaying")
    protected long gamePointsPlaying;

    @SerializedName("HighlightAreaContainer")
    protected long highlightAreaContainer;

    @SerializedName("Highlights")
    public long highlights;

    @SerializedName("HostTeam")
    public long hostTeam;

    @SerializedName("HourRank")
    public long hourRank;

    @SerializedName("InteractiveComponent")
    public long interactiveComponent;

    @SerializedName("LuckMoney")
    public boolean isEnableLuckMoney;

    @SerializedName("ItemShare")
    public long itemShare;

    @SerializedName("KtvOrderSong")
    public long ktvOrderSong;

    @SerializedName("Landscape")
    public long landscape;

    @SerializedName("LandscapeChat")
    public long landscapeChat;

    @SerializedName("LandscapeChatDynamicSlideSpeed")
    public long landscapeDynamic;

    @SerializedName("LandscapeGift")
    public long landscapeGift;

    @SerializedName("LandscapeScreenCapture")
    public long landscapeScreenCapture;

    @SerializedName("LandscapeScreenRecording")
    public long landscapeScreenRecording;

    @SerializedName("LandscapeScreenShare")
    public long landscapeScreenShare;

    @SerializedName("Like")
    public long like;

    @SerializedName("IndustryService")
    public long liveIMIndustryService;

    @SerializedName("FirstFeedHistChat")
    public long loadFirstHistoryChat;

    @SerializedName("MoreHistChat")
    public long loadMoreHistoryChat;

    @SerializedName("LongPressOption")
    public long longPressOption;

    @SerializedName("LongTouch")
    public long longTouch;

    @SerializedName("MarkUser")
    public long markUser;

    @SerializedName("MediaLinkmic")
    public long mediaRoomLinkmic;

    @SerializedName("TypingCommentState")
    public long mediaRoomTypingCommentState;

    @SerializedName("MessageDispatch")
    public long messageDispatch;

    @SerializedName("MissionCenter")
    public long missionCenter;

    @SerializedName("MoreAnchor")
    protected long moreAnchor;

    @SerializedName("MultiplierPlayback")
    protected long multiplierPlayback;

    @SerializedName("OffReason")
    public OffReason offReason;

    @SerializedName("OnlyTa")
    public long onlyTa;

    @SerializedName("PadPlay")
    protected long padPlay;

    @SerializedName("PanelECService")
    public long panelECService;

    @SerializedName("PCPlay")
    protected long pcPlay;

    @SerializedName("PlayerRankList")
    protected long playerRankList;

    @SerializedName("Poster")
    protected long poster;

    @SerializedName("PreviewChatExpose")
    public long previewChatExpose;

    @SerializedName("PreviewDanMaKu")
    public long previewDanmaku;

    @SerializedName("PosterCache")
    public long previewPosterCache;

    @SerializedName("ScreenProjectionBarrage")
    public long projectScreenBarrage;

    @SerializedName("ProjectionBtn")
    protected long projectionBtn;

    @SerializedName("ImHeatValue")
    public long publicScreenMessageHeatStrategy;

    @SerializedName("QuizGamePointsPlaying")
    protected long quizGamePointsPlaying;

    @SerializedName("RecordScreen")
    protected long recordScreen;

    @SerializedName("SpecialStyle")
    public RoomAuthSpecialStyle roomAuthSpecialStyle;

    @SerializedName("RoomChannel")
    public long roomChannel;

    @SerializedName("RoomWidget")
    public long roomWidget;

    @SerializedName("Seek")
    public long seek;

    @SerializedName("SelectionAlbum")
    public long selectionAlbum;

    @SerializedName("Selection")
    public long selectionEntrance;

    @SerializedName("ShortTouch")
    public long shortTouch;

    @SerializedName("ShortTouchTempState")
    public long shortTouchTempState;

    @SerializedName("ShowGamePlugin")
    public long showGamePlugin;

    @SerializedName("ShowQualification")
    public long showQualification;

    @SerializedName("Share")
    protected long showShare;

    @SerializedName("StreamAdaptation")
    protected long streamAdaptation;

    @SerializedName("StrokeUpDownGuide")
    public long strokeUpDownGuide;

    @SerializedName("HostTeamChannel")
    public long teamChannel;

    @SerializedName("Teleprompter")
    public long teleprompter;

    @SerializedName("TimedShutdown")
    protected long timedShutdown;

    @SerializedName("ToolbarBubble")
    public long toolbarBubble;

    @SerializedName("Topic")
    public long topic;

    @SerializedName("UgcVSReplayDelete")
    protected long ugcVSReplayDelete;

    @SerializedName("UgcVsReplayVisibility")
    protected long ugcVsReplayVisibility;

    @SerializedName("UpRightStatsFloatingLayer")
    public long upRightStatsFloatingLayer;

    @SerializedName("UseHostInfo")
    public long useHostInfo;

    @SerializedName("VerticalRank")
    public long verticalRank;

    @SerializedName("VerticalScreenShare")
    public long verticalScreenShare;

    @SerializedName("VideoAmplificationType")
    protected long videoAmplificationType;

    @SerializedName("VsCommentBar")
    public long vsCommentBar;

    @SerializedName("VsDouPlus")
    public long vsDouPlus;

    @SerializedName("VsFansClub")
    public long vsFansClub;

    @SerializedName("VSTopic")
    public long vsTopic;

    @SerializedName("VsWelcomeDanmaku")
    public long vsWelcomeDanmaku;

    @SerializedName("WorldSquare")
    protected long worldSquare;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$Action;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$Action;", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class Action implements IRoomAuthStatus.Action {
        final /* synthetic */ RoomAuthStatus this$0;

        public Action(RoomAuthStatus r100) {
            this.this$0 = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$CountType;", "", "()V", "ACCUMULATED_ENTER_COUNT", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CountType {
        public static final long ACCUMULATED_ENTER_COUNT = 1;
        public static final CountType INSTANCE = null;

        private CountType() {
        }

        static {
            INSTANCE = new CountType();
        }
    }

    @ProtoMessage("webcast.data.RoomAuthStatus.RoomAuthOffReasons")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$OffReason;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IOffReason;", "()V", PbRequest.SwitchType.GIFT, "", "getGift", "()Ljava/lang/String;", "setGift", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OffReason extends FlexModelBase<IRoomAuthStatus.IOffReason> implements IRoomAuthStatus.IOffReason, h {

        @SerializedName(PbRequest.SwitchType.GIFT)
        protected String gift;

        public OffReason() {
            super(IRoomAuthStatus.IOffReason.class);
        }

        public OffReason(g r100) {
            super(IRoomAuthStatus.IOffReason.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L7;
            this.gift = am3.h.c(r100);
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L9:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IOffReason
        public String getGift() {
            return this.gift;
        }

        public void setGift(String r100) {
            this.gift = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomAuthStatus.RoomAuthSpecialStyle")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$RoomAuthSpecialStyle;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus$IRoomAuthSpecialStyle;", "()V", "castScreenAuth", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "getCastScreenAuth", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "setCastScreenAuth", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;)V", "chatStyle", "getChatStyle", "setChatStyle", "landscapeStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$Style;", "likeStyle", "roomChannel", "shareStyle", "getShareStyle", "setShareStyle", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RoomAuthSpecialStyle extends FlexModelBase<IRoomAuthStatus.IRoomAuthSpecialStyle> implements IRoomAuthStatus.IRoomAuthSpecialStyle, h {

        @SerializedName("CastScreenAuth")
        protected IRoomAuthStatusStyle castScreenAuth;

        @SerializedName("Chat")
        protected IRoomAuthStatusStyle chatStyle;

        @SerializedName("Landscape")
        public Style landscapeStyle;

        @SerializedName("Like")
        public Style likeStyle;

        @SerializedName("RoomChannel")
        public Style roomChannel;

        @SerializedName("Share")
        protected IRoomAuthStatusStyle shareStyle;

        public RoomAuthSpecialStyle() {
            super(IRoomAuthStatus.IRoomAuthSpecialStyle.class);
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle, java.lang.Object] */
        public RoomAuthSpecialStyle(g r100) {
            super(IRoomAuthStatus.IRoomAuthSpecialStyle.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L7;
            this.chatStyle = f.a(r100, IRoomAuthStatusStyle.class);
            goto L3
        L7:
            switch(r102) {
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                default: goto L8;
            };
        L9:
            this.landscapeStyle = new Style(r100);
            goto L3
        L10:
            this.castScreenAuth = f.a(r100, IRoomAuthStatusStyle.class);
            goto L3
        L11:
            this.shareStyle = f.a(r100, IRoomAuthStatusStyle.class);
            goto L3
        L12:
            this.roomChannel = new Style(r100);
            goto L3
        L13:
            this.likeStyle = new Style(r100);
            goto L3
        L8:
            am3.h.d(r103, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public IRoomAuthStatusStyle getCastScreenAuth() {
            return this.castScreenAuth;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public IRoomAuthStatusStyle getChatStyle() {
            return this.chatStyle;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public IRoomAuthStatusStyle getShareStyle() {
            return this.shareStyle;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public void setCastScreenAuth(IRoomAuthStatusStyle r100) {
            this.castScreenAuth = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public void setChatStyle(IRoomAuthStatusStyle r100) {
            this.chatStyle = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus.IRoomAuthSpecialStyle
        public void setShareStyle(IRoomAuthStatusStyle r100) {
            this.shareStyle = r100;
        }
    }

    @ProtoMessage("webcast.data.RoomAuthStatus.RoomAuthSpecialStyle.Style")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus$Style;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatusStyle;", "()V", "anchorSwitch", "", "getAnchorSwitch", "()I", "setAnchorSwitch", "(I)V", "anchorSwitchForPaidLive", "getAnchorSwitchForPaidLive", "setAnchorSwitchForPaidLive", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentForPaidLive", "getContentForPaidLive", "setContentForPaidLive", "switchStatusAnchorTipMsg", "getSwitchStatusAnchorTipMsg", "setSwitchStatusAnchorTipMsg", "switchStatusTipMsg", "getSwitchStatusTipMsg", "setSwitchStatusTipMsg", "unableStyle", "getUnableStyle", "setUnableStyle", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Style extends FlexModelBase<IRoomAuthStatusStyle> implements IRoomAuthStatusStyle, h {

        @SerializedName("AnchorSwitch")
        protected int anchorSwitch;

        @SerializedName("AnchorSwitchForPaidLive")
        protected int anchorSwitchForPaidLive;

        @SerializedName("Content")
        protected String content;

        @SerializedName("ContentForPaidLive")
        protected String contentForPaidLive;

        @SerializedName("SwitchStatusAnchorTipMsg")
        protected String switchStatusAnchorTipMsg;

        @SerializedName("SwitchStatusTipMsg")
        protected String switchStatusTipMsg;

        @SerializedName("UnableStyle")
        protected int unableStyle;

        public Style() {
            super(IRoomAuthStatusStyle.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public int getAnchorSwitch() {
            return this.anchorSwitch;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public int getAnchorSwitchForPaidLive() {
            return this.anchorSwitchForPaidLive;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public String getContent() {
            return this.content;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public String getContentForPaidLive() {
            return this.contentForPaidLive;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public String getSwitchStatusAnchorTipMsg() {
            return this.switchStatusAnchorTipMsg;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public String getSwitchStatusTipMsg() {
            return this.switchStatusTipMsg;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public int getUnableStyle() {
            return this.unableStyle;
        }

        public Style(g r100) {
            super(IRoomAuthStatusStyle.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            g.a r103 = decodeExtensionFields(r102, r100);
            switch(r102) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L7;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            this.contentForPaidLive = am3.h.c(r100);
            goto L3
        L9:
            this.anchorSwitchForPaidLive = r100.i();
            goto L3
        L10:
            this.switchStatusAnchorTipMsg = am3.h.c(r100);
            goto L3
        L11:
            this.switchStatusTipMsg = am3.h.c(r100);
            goto L3
        L12:
            this.anchorSwitch = r100.i();
            goto L3
        L13:
            this.content = am3.h.c(r100);
            goto L3
        L14:
            this.unableStyle = r100.i();
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setAnchorSwitch(int r100) {
            this.anchorSwitch = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setAnchorSwitchForPaidLive(int r100) {
            this.anchorSwitchForPaidLive = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setContent(String r100) {
            this.content = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setContentForPaidLive(String r100) {
            this.contentForPaidLive = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setSwitchStatusAnchorTipMsg(String r100) {
            this.switchStatusAnchorTipMsg = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setSwitchStatusTipMsg(String r100) {
            this.switchStatusTipMsg = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle
        public void setUnableStyle(int r100) {
            this.unableStyle = r100;
        }
    }

    public RoomAuthStatus() {
        super(IRoomAuthStatus.class);
        this.strokeUpDownGuide = 2;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableBanner() {
        if (this.enableBanner != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableBulletStyle() {
        if (this.bulletStyle != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableChatMentionV2() {
        long r100 = this.enableChatMentionV2;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean enableEnhancedTouch() {
        if (this.enhancedTouch == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableHourRank() {
        long r100 = this.hourRank;
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableInteractionGift() {
        if (this.enableInteractionGift != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableLandscapeQuickRecord() {
        if (this.landscapeScreenRecording != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableLandscapeQuickShot() {
        if (this.landscapeScreenCapture != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableLandscapeScreenShare() {
        long r100 = this.landscapeScreenShare;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean enableLongTouch() {
        if (this.longTouch != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableOperateTopic() {
        if (this.vsTopic != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean enablePreviewPosterCache() {
        if (this.previewPosterCache != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean enableShortTouch() {
        if (this.shortTouch == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableTempShortTouch() {
        if (this.shortTouchTempState != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean enableVSDouPlus() {
        if (this.vsDouPlus != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableVSFansClub() {
        if (this.vsFansClub != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableVerticalRank() {
        long r100 = this.verticalRank;
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableVerticalScreenShare() {
        long r100 = this.verticalScreenShare;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean enableVsLike() {
        if (this.like != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableVsWelcomeDanmu() {
        if (this.vsWelcomeDanmaku != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isAnchorColdMessageTiled() {
        long r100 = this.anchorColdMessageTiled;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isChatDispatch() {
        long r100 = this.chatDispatch;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isChatGuideEmojiEnable() {
        long r100 = this.chatGuideEmoji;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isChatGuideImageEnable() {
        long r100 = this.chatGuideImage;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isDisableSelectionAlbum() {
        if (this.selectionAlbum == 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableAIClone() {
        long r100 = this.aiClone;
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 0) goto L8;
        return false;
    }

    public final boolean isEnableAnchorAsr() {
        long r100 = this.anchorAsr;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableAnchorChannel() {
        if (this.enableAnchorFans == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableAnchorChatDynamicSlideSpeed() {
        long r100 = this.chatDynamicSlideSpeedAnchor;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableAudienceOpPanel() {
        if (this.enableOpPanel == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableChatDynamicSlideSpeed() {
        long r100 = this.chatDynamicSlideSpeed;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableChatOperate() {
        long r100 = this.chatOperate;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isEnableClearEntranceOption() {
        long r100 = this.clearEntranceOption;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableDouPlus() {
        long r100 = this.douPlus;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableFirstFetchHistory() {
        long r100 = this.loadFirstHistoryChat;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableFusionEmoji() {
        long r100 = this.fusionEmoji;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableInteractivtyShare() {
        long r100 = this.itemShare;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableLandscapeChat() {
        long r100 = this.landscapeChat;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isEnableLandscapeGift() {
        long r100 = this.landscapeGift;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableLoadMoreHistory() {
        long r100 = this.loadMoreHistoryChat;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isEnableLongPressOption() {
        long r100 = this.longPressOption;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableMarkUser() {
        long r100 = this.markUser;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnablePinHighlight() {
        if (this.enablePinHighlight == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnablePreviewDanmaku() {
        long r100 = this.previewDanmaku;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isEnableRoomChannel() {
        long r100 = this.roomChannel;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    public final boolean isEnableRoomChannelByAnchor() {
        RoomAuthSpecialStyle r100 = this.roomAuthSpecialStyle;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.roomChannel == null) goto L9;
        RoomAuthSpecialStyle r101 = this.roomAuthSpecialStyle;
        Intrinsics.checkNotNull(r101);
        Style r102 = r101.roomChannel;
        Intrinsics.checkNotNull(r102);
        if (r102.getAnchorSwitch() != 2) goto L9;
        return false;
    L9:
        return true;
    }

    public final boolean isEnableRoomWidget() {
        if (this.roomWidget != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableSecretChat() {
        if (this.enableRoomSecretChat == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableShowLikeCount() {
        if (this.enableShowLikeCount != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableStableTopic() {
        if (this.vsCommentBar != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isEnableStrokeUpDownGuide() {
        long r100 = this.strokeUpDownGuide;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableSwitchLandscape() {
        long r100 = this.landscape;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableUpRightStatsFloatingLayer() {
        long r100 = this.upRightStatsFloatingLayer;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableWorldSquare() {
        if (this.worldSquare == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isFrequentChatEnable() {
        long r100 = this.enableFrequentChat;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isLandscapeDynamicSpeedStrategyEnable() {
        long r100 = this.landscapeDynamic;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isMessageBreak() {
        long r100 = this.messageDispatch;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isOrderSongOpened() {
        if (this.ktvOrderSong != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isPSSelectedMessageEnable() {
        long r100 = this.enablePSSelectedMessage;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isPanelECServiceEnable() {
        long r100 = this.panelECService;
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isPublicScreenMessageHeatStrategyEnable() {
        if (this.publicScreenMessageHeatStrategy != 0) goto L5;
    L8:
        return true;
    L5:
        if (this.anchorColdMessageTiled == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isVSRoomEnableSeek() {
        if (this.seek != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "{\"enableChat\":" + getEnableChat() + ",\"enableDanmaku\":" + getEnableDanmaku() + ",\"enableGift\":" + getEnableGift() + ",\"enableDigg\":" + getEnableDigg() + ",\"enableLuckMoney\":" + this.isEnableLuckMoney + ",\"enableRoomContributor\":" + this.enableRoomContributor + ",\"enableUserCard\":" + getEnableUserCard() + ",\"moreAnchor\":" + getMoreAnchor() + ",\"enableBanner\":" + this.enableBanner + ",\"showShare\":" + getShowShare() + ",\"enablePoi\":" + getEnablePoi() + ",\"landscape\":" + this.landscape + ",\"landscapeChat\":" + this.landscapeChat + ",\"recordScreen\":" + getRecordScreen() + ",\"hourRank\":" + this.hourRank + ",\"commerceCard\":" + getCommerceCard() + ",\"offReason\":" + this.offReason + ",\"danmakuDefault\":" + getDanmakuDefault() + ",\"ktvOrderSong\":" + this.ktvOrderSong + ",\"selectionAlbum\":" + this.selectionAlbum + ",\"like\":" + this.like + ",\"multiplierPlayback\":" + getMultiplierPlayback() + ",\"downloadVideo\":" + getDownloadVideo() + ",\"collect\":" + getCollect() + ",\"timedShutdown\":" + getTimedShutdown() + ",\"seek\":" + this.seek + ",\"denounce\":" + getDenounce() + ",\"dislike\":" + getDislike() + ",\"onlyTa\":" + this.onlyTa + ",\"castScreen\":" + getCastScreen() + ",\"castScreenExplicit\":" + getCastScreenExplicit() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public long adminPinCommentAction() {
        return getEnableAdminPinComment();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableCastScreen() {
        if (getCastScreen() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean enableFansClub() {
        if (getFansClubAuth() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getFansClubAuth() == 1) goto L8;
        return false;
    }

    public final boolean enablePadPlay() {
        if (getPadPlay() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean enablePcPlay() {
        if (getPcPlay() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isDisableShare() {
        if (getShowShare() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isEnableCollect() {
        if (getCollect() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getCollect() == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableRecordScreen() {
        if (getRecordScreen() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isEnableTimedShutdown() {
        if (getTimedShutdown() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getTimedShutdown() == 1) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isShopFansClubMode() {
        if (getEcomFansClubAuth() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getCastScreen() {
        return this.castScreen;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getCastScreenExplicit() {
        return this.castScreenExplicit;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getCollect() {
        return this.collect;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getCommerceCard() {
        return this.commerceCard;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getCommonCard() {
        return this.commonCard;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getDanmakuDefault() {
        return this.danmakuDefault;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getDenounce() {
        return this.denounce;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getDislike() {
        return this.dislike;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getDownloadVideo() {
        return this.downloadVideo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getEcomFansClubAuth() {
        return this.ecomFansClubAuth;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getEnableAdminPinComment() {
        return this.enableAdminPinComment;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnableChat() {
        return this.enableChat;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnableDanmaku() {
        return this.enableDanmaku;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnableDigg() {
        return this.enableDigg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnableGift() {
        return this.enableGift;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnablePoi() {
        return this.enablePoi;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public boolean getEnableUserCard() {
        return this.enableUserCard;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getEnableVideoShare() {
        return this.enableVideoShare;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getFansClubAuth() {
        return this.fansClubAuth;
    }

    public final long getFixChat() {
        return this.fixChat;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getGamePointsPlaying() {
        return this.gamePointsPlaying;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getHighlightAreaContainer() {
        return this.highlightAreaContainer;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getMoreAnchor() {
        return this.moreAnchor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getMultiplierPlayback() {
        return this.multiplierPlayback;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public IRoomAuthStatus.IOffReason getOffReason() {
        return this.offReason;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getPadPlay() {
        return this.padPlay;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getPcPlay() {
        return this.pcPlay;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getPlayerRankList() {
        return this.playerRankList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getPoster() {
        return this.poster;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getProjectionBtn() {
        return this.projectionBtn;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getQuizGamePointsPlaying() {
        return this.quizGamePointsPlaying;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getRecordScreen() {
        return this.recordScreen;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public IRoomAuthStatus.IRoomAuthSpecialStyle getRoomAuthSpecialStyle() {
        return this.roomAuthSpecialStyle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getShowShare() {
        return this.showShare;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getStreamAdaptation() {
        return this.streamAdaptation;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getTimedShutdown() {
        return this.timedShutdown;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getUgcVSReplayDelete() {
        return this.ugcVSReplayDelete;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getUgcVsReplayVisibility() {
        return this.ugcVsReplayVisibility;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public long getVideoAmplificationType() {
        return this.videoAmplificationType;
    }

    public final long getWorldSquare() {
        return this.worldSquare;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public boolean isEnableRoomContributor() {
        return this.enableRoomContributor;
    }

    public RoomAuthStatus(g r100) {
        super(IRoomAuthStatus.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L159;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.enableChat = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.enableDanmaku = am3.h.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.enableGift = am3.h.a(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.isEnableLuckMoney = am3.h.a(r100);
        goto L3
    L14:
        if (r103 != 5) goto L16;
        this.enableDigg = am3.h.a(r100);
        goto L3
    L16:
        if (r103 != 15) goto L18;
        this.landscape = r100.j();
        goto L3
    L18:
        if (r103 != 16) goto L20;
        this.landscapeChat = r100.j();
        goto L3
    L20:
        if (r103 != 21) goto L22;
        this.hourRank = r100.j();
        goto L3
    L22:
        if (r103 != 22) goto L23;
        this.commerceCard = r100.j();
        goto L3
    L23:
        switch(r103) {
            case 7: goto L149;
            case 19: goto L148;
            case 24: goto L147;
            case 25: goto L146;
            case 26: goto L145;
            case 27: goto L144;
            case 28: goto L143;
            case 29: goto L142;
            case 30: goto L141;
            case 31: goto L140;
            case 32: goto L139;
            case 33: goto L138;
            case 34: goto L137;
            case 35: goto L136;
            case 36: goto L135;
            case 37: goto L134;
            case 38: goto L133;
            case 39: goto L132;
            case 41: goto L131;
            case 57: goto L130;
            case 87: goto L129;
            case 88: goto L128;
            case 90: goto L127;
            case 91: goto L126;
            case 92: goto L125;
            case 93: goto L124;
            case 94: goto L123;
            case 96: goto L122;
            case 99: goto L121;
            case 100: goto L120;
            case 101: goto L119;
            case 102: goto L118;
            case 103: goto L117;
            case 104: goto L116;
            case 106: goto L115;
            case 107: goto L114;
            case 109: goto L113;
            case 110: goto L112;
            case 111: goto L111;
            case 113: goto L110;
            case 114: goto L109;
            case 115: goto L108;
            case 118: goto L107;
            case 119: goto L106;
            case 120: goto L105;
            case 121: goto L104;
            case 122: goto L103;
            case 123: goto L102;
            case 124: goto L101;
            case 125: goto L100;
            case 126: goto L99;
            case 129: goto L98;
            case 130: goto L97;
            case 131: goto L96;
            case 132: goto L95;
            case 133: goto L94;
            case 141: goto L93;
            case 142: goto L92;
            case 143: goto L91;
            case 144: goto L90;
            case 145: goto L89;
            case 146: goto L88;
            case 147: goto L87;
            case 148: goto L86;
            case 160: goto L85;
            case 161: goto L84;
            case 200: goto L83;
            case 201: goto L82;
            case 202: goto L81;
            case 204: goto L80;
            case 205: goto L79;
            case 206: goto L78;
            case 207: goto L77;
            case 208: goto L76;
            case 210: goto L75;
            case 301: goto L74;
            case 5000: goto L73;
            default: goto L24;
        };
    L73:
        this.countType = r100.j();
        goto L3
    L74:
        this.useHostInfo = r100.j();
        goto L3
    L75:
        this.showQualification = r100.j();
        goto L3
    L76:
        this.enableInteractionGift = r100.j();
        goto L3
    L77:
        this.ugcVsReplayVisibility = r100.j();
        goto L3
    L78:
        this.ugcVSReplayDelete = r100.j();
        goto L3
    L79:
        this.quizGamePointsPlaying = r100.j();
        goto L3
    L80:
        this.vsDouPlus = r100.j();
        goto L3
    L81:
        this.vsFansClub = r100.j();
        goto L3
    L82:
        this.vsWelcomeDanmaku = r100.j();
        goto L3
    L83:
        this.vsCommentBar = r100.j();
        goto L3
    L84:
        this.worldSquare = r100.j();
        goto L3
    L85:
        this.previewDanmaku = r100.j();
        goto L3
    L86:
        this.highlightAreaContainer = r100.j();
        goto L3
    L87:
        this.enablePinHighlight = r100.j();
        goto L3
    L88:
        this.enableAnchorFans = r100.j();
        goto L3
    L89:
        this.enableRoomSecretChat = r100.j();
        goto L3
    L90:
        this.enableShowLikeCount = r100.j();
        goto L3
    L91:
        this.enableOpPanel = r100.j();
        goto L3
    L92:
        this.enableChatMentionV2 = r100.j();
        goto L3
    L93:
        this.enhancedTouch = r100.j();
        goto L3
    L94:
        this.aiClone = r100.j();
        goto L3
    L95:
        this.playerRankList = r100.j();
        goto L3
    L96:
        this.clearEntranceOption = r100.j();
        goto L3
    L97:
        this.longPressOption = r100.j();
        goto L3
    L98:
        this.markUser = r100.j();
        goto L3
    L99:
        this.fusionEmoji = r100.j();
        goto L3
    L100:
        this.previewChatExpose = r100.j();
        goto L3
    L101:
        this.anchorAsr = r100.j();
        goto L3
    L102:
        this.verticalScreenShare = r100.j();
        goto L3
    L103:
        this.landscapeScreenShare = r100.j();
        goto L3
    L104:
        this.enablePSSelectedMessage = r100.j();
        goto L3
    L105:
        this.videoAmplificationType = r100.j();
        goto L3
    L106:
        this.streamAdaptation = r100.j();
        goto L3
    L107:
        this.enableFrequentChat = r100.j();
        goto L3
    L108:
        this.interactiveComponent = r100.j();
        goto L3
    L109:
        this.publicScreenMessageHeatStrategy = r100.j();
        goto L3
    L110:
        this.toolbarBubble = r100.j();
        goto L3
    L111:
        this.previewPosterCache = r100.j();
        goto L3
    L112:
        this.chatDynamicSlideSpeedAnchor = r100.j();
        goto L3
    L113:
        this.projectionBtn = r100.j();
        goto L3
    L114:
        this.shortTouchTempState = r100.j();
        goto L3
    L115:
        this.itemShare = r100.j();
        goto L3
    L116:
        this.landscapeGift = r100.j();
        goto L3
    L117:
        this.fixChat = r100.j();
        goto L3
    L118:
        this.panelECService = r100.j();
        goto L3
    L119:
        this.roomAuthSpecialStyle = new RoomAuthSpecialStyle(r100);
        goto L3
    L120:
        this.offReason = new OffReason(r100);
        goto L3
    L121:
        this.roomWidget = r100.j();
        goto L3
    L122:
        this.anchorColdMessageTiled = r100.j();
        goto L3
    L123:
        this.hostTeam = r100.j();
        goto L3
    L124:
        this.landscapeDynamic = r100.j();
        goto L3
    L125:
        this.teamChannel = r100.j();
        goto L3
    L126:
        this.shortTouch = r100.j();
        goto L3
    L127:
        this.commonCard = r100.j();
        goto L3
    L128:
        this.ecomFansClubAuth = r100.j();
        goto L3
    L129:
        this.chatOperate = r100.j();
        goto L3
    L130:
        this.fansClubAuth = r100.j();
        goto L3
    L131:
        this.vsTopic = r100.j();
        goto L3
    L132:
        this.showGamePlugin = r100.j();
        goto L3
    L133:
        this.bulletStyle = r100.j();
        goto L3
    L134:
        this.enablePinComment = r100.j();
        goto L3
    L135:
        this.castScreen = r100.j();
        goto L3
    L136:
        this.onlyTa = r100.j();
        goto L3
    L137:
        this.dislike = r100.j();
        goto L3
    L138:
        this.denounce = r100.j();
        goto L3
    L139:
        this.seek = r100.j();
        goto L3
    L140:
        this.timedShutdown = r100.j();
        goto L3
    L141:
        this.collect = r100.j();
        goto L3
    L142:
        this.downloadVideo = r100.j();
        goto L3
    L143:
        this.multiplierPlayback = r100.j();
        goto L3
    L144:
        this.like = r100.j();
        goto L3
    L145:
        this.selectionAlbum = r100.j();
        goto L3
    L146:
        this.ktvOrderSong = r100.j();
        goto L3
    L147:
        this.danmakuDefault = r100.j();
        goto L3
    L148:
        this.recordScreen = r100.j();
        goto L3
    L149:
        this.enableRoomContributor = am3.h.a(r100);
        goto L3
    L24:
        switch(r103) {
            case 9: goto L72;
            case 10: goto L71;
            case 11: goto L70;
            case 12: goto L69;
            case 13: goto L68;
            default: goto L25;
        };
    L68:
        this.showShare = r100.j();
        goto L3
    L69:
        this.enableBanner = r100.j();
        goto L3
    L70:
        this.moreAnchor = r100.j();
        goto L3
    L71:
        this.enablePoi = am3.h.a(r100);
        goto L3
    L72:
        this.enableUserCard = am3.h.a(r100);
        goto L3
    L25:
        switch(r103) {
            case 43: goto L67;
            case 44: goto L66;
            case 45: goto L65;
            case 46: goto L64;
            case 47: goto L63;
            case 48: goto L62;
            case 49: goto L61;
            case 50: goto L60;
            case 51: goto L59;
            case 52: goto L58;
            case 53: goto L57;
            case 54: goto L56;
            case 55: goto L55;
            default: goto L26;
        };
    L55:
        this.verticalRank = r100.j();
        goto L3
    L56:
        this.liveIMIndustryService = r100.j();
        goto L3
    L57:
        this.selectionEntrance = r100.j();
        goto L3
    L58:
        this.castScreenExplicit = r100.j();
        goto L3
    L59:
        this.upRightStatsFloatingLayer = r100.j();
        goto L3
    L60:
        this.strokeUpDownGuide = r100.j();
        r101 = r101 | true;
        goto L3
    L61:
        this.mediaRoomTypingCommentState = r100.j();
        goto L3
    L62:
        this.highlights = r100.j();
        goto L3
    L63:
        this.poster = r100.j();
        goto L3
    L64:
        this.gamePointsPlaying = r100.j();
        goto L3
    L65:
        this.douPlus = r100.j();
        goto L3
    L66:
        this.commerceComponent = r100.j();
        goto L3
    L67:
        this.enableAdminPinComment = r100.j();
        goto L3
    L26:
        switch(r103) {
            case 59: goto L54;
            case 60: goto L53;
            case 61: goto L52;
            case 62: goto L51;
            case 63: goto L50;
            case 64: goto L49;
            case 65: goto L48;
            case 66: goto L47;
            case 67: goto L46;
            default: goto L27;
        };
    L46:
        this.chatDynamicSlideSpeed = r100.j();
        goto L3
    L47:
        this.teleprompter = r100.j();
        goto L3
    L48:
        this.anchorMission = r100.j();
        goto L3
    L49:
        this.topic = r100.j();
        goto L3
    L50:
        this.fansGroup = r100.j();
        goto L3
    L51:
        this.expandScreen = r100.j();
        goto L3
    L52:
        this.missionCenter = r100.j();
        goto L3
    L53:
        this.douPlusPopularityGem = r100.j();
        goto L3
    L54:
        this.canSellPaidLiveTicket = r100.j();
        goto L3
    L27:
        switch(r103) {
            case 69: goto L45;
            case 70: goto L44;
            case 71: goto L43;
            default: goto L28;
        };
    L43:
        this.chatDispatch = r100.j();
        goto L3
    L44:
        this.roomChannel = r100.j();
        goto L3
    L45:
        this.messageDispatch = r100.j();
        goto L3
    L28:
        switch(r103) {
            case 73: goto L42;
            case 74: goto L41;
            case 75: goto L40;
            case 76: goto L39;
            case 77: goto L38;
            case 78: goto L37;
            case 79: goto L36;
            case 80: goto L35;
            case 81: goto L34;
            default: goto L29;
        };
    L34:
        this.loadMoreHistoryChat = r100.j();
        goto L3
    L35:
        this.loadFirstHistoryChat = r100.j();
        goto L3
    L36:
        this.longTouch = r100.j();
        goto L3
    L37:
        this.padPlay = r100.j();
        goto L3
    L38:
        this.pcPlay = r100.j();
        goto L3
    L39:
        this.chatGuideImage = r100.j();
        goto L3
    L40:
        this.chatGuideEmoji = r100.j();
        goto L3
    L41:
        this.enableVideoShare = r100.j();
        goto L3
    L42:
        this.mediaRoomLinkmic = r100.j();
        goto L3
    L29:
        switch(r103) {
            case 83: goto L33;
            case 84: goto L32;
            case 85: goto L31;
            default: goto L30;
        };
    L31:
        this.projectScreenBarrage = r100.j();
        goto L3
    L32:
        this.landscapeScreenRecording = r100.j();
        goto L3
    L33:
        this.landscapeScreenCapture = r100.j();
        goto L3
    L30:
        am3.h.d(r104, r100);
        goto L3
    L159:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L438;
        this.strokeUpDownGuide = 2;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public void enableBanner(long r100) {
        this.enableBanner = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public void enableVideoShare(long r100) {
        setEnableVideoShare(r100);
    }

    public final boolean isEnableGamePointsPlaying(boolean r100) {
        if (r100 == false) goto L10;
        if (getQuizGamePointsPlaying() != 0) goto L7;
        return true;
    L7:
        if (getQuizGamePointsPlaying() == 1) goto L15;
    L12:
        return false;
    L15:
        return true;
    L10:
        if (getQuizGamePointsPlaying() != 1) goto L12;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setCastScreen(long r100) {
        this.castScreen = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setCastScreenExplicit(long r100) {
        this.castScreenExplicit = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setCollect(long r100) {
        this.collect = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setCommerceCard(long r100) {
        this.commerceCard = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setCommonCard(long r100) {
        this.commonCard = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setDanmakuDefault(long r100) {
        this.danmakuDefault = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setDenounce(long r100) {
        this.denounce = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setDislike(long r100) {
        this.dislike = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setDownloadVideo(long r100) {
        this.downloadVideo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEcomFansClubAuth(long r100) {
        this.ecomFansClubAuth = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableAdminPinComment(long r100) {
        this.enableAdminPinComment = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableChat(boolean r100) {
        this.enableChat = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableDanmaku(boolean r100) {
        this.enableDanmaku = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableDigg(boolean r100) {
        this.enableDigg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableGift(boolean r100) {
        this.enableGift = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnablePoi(boolean r100) {
        this.enablePoi = r100;
    }

    public final void setEnableRoomContributor(boolean r100) {
        this.enableRoomContributor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableUserCard(boolean r100) {
        this.enableUserCard = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setEnableVideoShare(long r100) {
        this.enableVideoShare = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setFansClubAuth(long r100) {
        this.fansClubAuth = r100;
    }

    public final void setFixChat(long r100) {
        this.fixChat = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setGamePointsPlaying(long r100) {
        this.gamePointsPlaying = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setHighlightAreaContainer(long r100) {
        this.highlightAreaContainer = r100;
    }

    public final void setLandscape(long r100) {
        this.landscape = r100;
    }

    public final void setLandscapeDynamic(long r100) {
        this.landscapeDynamic = r100;
    }

    public final void setMessageDispatch(long r100) {
        this.messageDispatch = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setMoreAnchor(long r100) {
        this.moreAnchor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setMultiplierPlayback(long r100) {
        this.multiplierPlayback = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setPadPlay(long r100) {
        this.padPlay = r100;
    }

    public final void setPanelECService(long r100) {
        this.panelECService = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setPcPlay(long r100) {
        this.pcPlay = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setPlayerRankList(long r100) {
        this.playerRankList = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setPoster(long r100) {
        this.poster = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setProjectionBtn(long r100) {
        this.projectionBtn = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setQuizGamePointsPlaying(long r100) {
        this.quizGamePointsPlaying = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setRecordScreen(long r100) {
        this.recordScreen = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusKt
    public void setRoomAuthSpecialStyle(IRoomAuthStatus.IRoomAuthSpecialStyle r100) {
        this.roomAuthSpecialStyle = (RoomAuthSpecialStyle) m.b(r100, RoomAuthSpecialStyle.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setShowShare(long r100) {
        this.showShare = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setStreamAdaptation(long r100) {
        this.streamAdaptation = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setTimedShutdown(long r100) {
        this.timedShutdown = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setUgcVSReplayDelete(long r100) {
        this.ugcVSReplayDelete = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setUgcVsReplayVisibility(long r100) {
        this.ugcVsReplayVisibility = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus
    public void setVideoAmplificationType(long r100) {
        this.videoAmplificationType = r100;
    }

    public final void setWorldSquare(long r100) {
        this.worldSquare = r100;
    }
}
