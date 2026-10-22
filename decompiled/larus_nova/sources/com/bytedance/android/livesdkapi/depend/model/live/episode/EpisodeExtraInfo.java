package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.depend.model.live.EpisodePreviewImage;
import com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MultiCameraBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.SharePosterInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.android.livesdkapi.depend.model.live.vs._BusinessConfigure_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\b\u0089\u0003\u0010'J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0016J\u001c\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R*\u0010 \u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b \u0010!\u0012\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010(\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00102\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R$\u0010A\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bA\u0010)\u001a\u0004\bB\u0010+\"\u0004\bC\u0010-R$\u0010D\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010)\u001a\u0004\bE\u0010+\"\u0004\bF\u0010-R$\u0010H\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010O\u001a\u0004\u0018\u00010N8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010U\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bU\u00109\u001a\u0004\bV\u0010;\"\u0004\bW\u0010=R$\u0010X\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bX\u0010)\u001a\u0004\bY\u0010+\"\u0004\bZ\u0010-R$\u0010[\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010)\u001a\u0004\b\\\u0010+\"\u0004\b]\u0010-R$\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010)\u001a\u0004\b_\u0010+\"\u0004\b`\u0010-R$\u0010a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010)\u001a\u0004\bb\u0010+\"\u0004\bc\u0010-R$\u0010d\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010q\u001a\u0004\u0018\u00010p8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010w\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bw\u0010)\u001a\u0004\bx\u0010+\"\u0004\by\u0010-R*\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR0\u0010\u0082\u0001\u001a\f\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010{\u001a\u0005\b\u0083\u0001\u0010}\"\u0005\b\u0084\u0001\u0010\u007fR0\u0010\u0085\u0001\u001a\f\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010{\u001a\u0005\b\u0086\u0001\u0010}\"\u0005\b\u0087\u0001\u0010\u007fR0\u0010\u0089\u0001\u001a\f\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010\u0080\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010{\u001a\u0005\b\u008a\u0001\u0010}\"\u0005\b\u008b\u0001\u0010\u007fR(\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010)\u001a\u0005\b\u008d\u0001\u0010+\"\u0005\b\u008e\u0001\u0010-R(\u0010\u008f\u0001\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u00103\u001a\u0005\b\u0090\u0001\u00105\"\u0005\b\u0091\u0001\u00107R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R&\u0010\u0099\u0001\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u00109\u001a\u0005\b\u009a\u0001\u0010;\"\u0005\b\u009b\u0001\u0010=R*\u0010\u009c\u0001\u001a\u00030\u0092\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u0094\u0001\u001a\u0006\b\u009d\u0001\u0010\u0096\u0001\"\u0006\b\u009e\u0001\u0010\u0098\u0001R,\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R,\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R(\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010)\u001a\u0005\b®\u0001\u0010+\"\u0005\b¯\u0001\u0010-R(\u0010°\u0001\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b°\u0001\u00103\u001a\u0005\b±\u0001\u00105\"\u0005\b²\u0001\u00107R(\u0010³\u0001\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010)\u001a\u0005\b´\u0001\u0010+\"\u0005\bµ\u0001\u0010-R(\u0010¶\u0001\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010)\u001a\u0005\b·\u0001\u0010+\"\u0005\b¸\u0001\u0010-R/\u0010º\u0001\u001a\u000b\u0012\u0005\u0012\u00030¹\u0001\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010{\u001a\u0005\b»\u0001\u0010}\"\u0005\b¼\u0001\u0010\u007fR&\u0010½\u0001\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b½\u0001\u00109\u001a\u0005\b¾\u0001\u0010;\"\u0005\b¿\u0001\u0010=R(\u0010À\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010e\u001a\u0005\bÁ\u0001\u0010g\"\u0005\bÂ\u0001\u0010iR,\u0010Ã\u0001\u001a\u0005\u0018\u00010¹\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R(\u0010É\u0001\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010!\u001a\u0005\bÊ\u0001\u0010#\"\u0005\bË\u0001\u0010%R(\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010)\u001a\u0005\bÍ\u0001\u0010+\"\u0005\bÎ\u0001\u0010-R,\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R(\u0010Ö\u0001\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÖ\u0001\u0010I\u001a\u0005\b×\u0001\u0010K\"\u0005\bØ\u0001\u0010MR,\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R,\u0010á\u0001\u001a\u0005\u0018\u00010à\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R(\u0010ç\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010)\u001a\u0005\bè\u0001\u0010+\"\u0005\bé\u0001\u0010-R3\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u001f\n\u0006\bë\u0001\u0010ì\u0001\u0012\u0005\bñ\u0001\u0010'\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R,\u0010ó\u0001\u001a\u0005\u0018\u00010ò\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R,\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bú\u0001\u0010û\u0001\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R&\u0010\u0080\u0002\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0080\u0002\u00109\u001a\u0005\b\u0081\u0002\u0010;\"\u0005\b\u0082\u0002\u0010=R,\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0083\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0084\u0002\u0010\u0085\u0002\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002\"\u0006\b\u0088\u0002\u0010\u0089\u0002R,\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008a\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008b\u0002\u0010\u008c\u0002\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002\"\u0006\b\u008f\u0002\u0010\u0090\u0002R,\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R,\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010\u009a\u0002\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002\"\u0006\b\u009d\u0002\u0010\u009e\u0002R(\u0010\u009f\u0002\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009f\u0002\u00103\u001a\u0005\b \u0002\u00105\"\u0005\b¡\u0002\u00107R,\u0010£\u0002\u001a\u0005\u0018\u00010¢\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R+\u0010©\u0002\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b©\u0002\u0010ª\u0002\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R-\u0010¯\u0002\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b¯\u0002\u00109\u0012\u0005\b²\u0002\u0010'\u001a\u0005\b°\u0002\u0010;\"\u0005\b±\u0002\u0010=R,\u0010´\u0002\u001a\u0005\u0018\u00010³\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b´\u0002\u0010µ\u0002\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R.\u0010º\u0002\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bº\u0002\u0010{\u001a\u0005\b»\u0002\u0010}\"\u0005\b¼\u0002\u0010\u007fR+\u0010½\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b½\u0002\u0010¾\u0002\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0006\bÁ\u0002\u0010Â\u0002R&\u0010Ã\u0002\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÃ\u0002\u0010k\u001a\u0005\bÄ\u0002\u0010m\"\u0005\bÅ\u0002\u0010oR+\u0010Æ\u0002\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÆ\u0002\u0010Ç\u0002\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R&\u0010Ì\u0002\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0002\u00109\u001a\u0005\bÍ\u0002\u0010;\"\u0005\bÎ\u0002\u0010=R+\u0010Ï\u0002\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÏ\u0002\u0010Ð\u0002\u001a\u0006\bÑ\u0002\u0010Ò\u0002\"\u0006\bÓ\u0002\u0010Ô\u0002R,\u0010Ö\u0002\u001a\u0005\u0018\u00010Õ\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÖ\u0002\u0010×\u0002\u001a\u0006\bØ\u0002\u0010Ù\u0002\"\u0006\bÚ\u0002\u0010Û\u0002R(\u0010Ü\u0002\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÜ\u0002\u0010)\u001a\u0005\bÝ\u0002\u0010+\"\u0005\bÞ\u0002\u0010-R(\u0010ß\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bß\u0002\u0010)\u001a\u0005\bà\u0002\u0010+\"\u0005\bá\u0002\u0010-R(\u0010â\u0002\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bâ\u0002\u00103\u001a\u0005\bã\u0002\u00105\"\u0005\bä\u0002\u00107R(\u0010å\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bå\u0002\u0010)\u001a\u0005\bæ\u0002\u0010+\"\u0005\bç\u0002\u0010-R,\u0010é\u0002\u001a\u0005\u0018\u00010è\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bé\u0002\u0010ê\u0002\u001a\u0006\bë\u0002\u0010ì\u0002\"\u0006\bí\u0002\u0010î\u0002R-\u0010ï\u0002\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bï\u0002\u00109\u0012\u0005\bò\u0002\u0010'\u001a\u0005\bð\u0002\u0010;\"\u0005\bñ\u0002\u0010=R(\u0010ó\u0002\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bó\u0002\u0010)\u001a\u0005\bô\u0002\u0010+\"\u0005\bõ\u0002\u0010-R?\u0010ö\u0002\u001a\u0011\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\bö\u0002\u0010÷\u0002\u0012\u0005\bü\u0002\u0010'\u001a\u0006\bø\u0002\u0010ù\u0002\"\u0006\bú\u0002\u0010û\u0002R7\u0010ý\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bý\u0002\u0010÷\u0002\u001a\u0006\bþ\u0002\u0010ù\u0002\"\u0006\bÿ\u0002\u0010û\u0002R&\u0010\u0080\u0003\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0080\u0003\u0010k\u001a\u0005\b\u0080\u0003\u0010m\"\u0005\b\u0081\u0003\u0010oR*\u0010\u0082\u0003\u001a\u00030\u0092\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0082\u0003\u0010\u0094\u0001\u001a\u0006\b\u0083\u0003\u0010\u0096\u0001\"\u0006\b\u0084\u0003\u0010\u0098\u0001R\u001a\u0010\u0088\u0003\u001a\u0005\u0018\u00010\u0085\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0003\u0010\u0087\u0003¨\u0006\u008a\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeExtraInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo;", "getPrivilegeInfo", "privilegeInfo", "", "setPrivilegeInfo", "getOwnerUserIdStr", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getLiveUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "getVideo", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeHighLight;", "getHighlights", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "getStartHighLight", "", "getHighLightFirst", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "getStatistics", "", "getRoomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;", "getUserStatistics", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePaidInfo;", "getPaidInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "getRealMod", "episodeMod", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "getEpisodeMod", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "setEpisodeMod", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;)V", "getEpisodeMod$annotations", "()V", "currentPeriod", "Ljava/lang/String;", "getCurrentPeriod", "()Ljava/lang/String;", "setCurrentPeriod", "(Ljava/lang/String;)V", "episodeIdStr", "getEpisodeIdStr", "setEpisodeIdStr", "Lpy/k;", "cover", "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "watchPeriod", "J", "getWatchPeriod", "()J", "setWatchPeriod", "(J)V", "latestPeriod", "getLatestPeriod", "setLatestPeriod", "title", "getTitle", d.f25925o, "episodeListH5", "getEpisodeListH5", "setEpisodeListH5", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "episodeWatchInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "getEpisodeWatchInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "setEpisodeWatchInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "firstShowPlayControl", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "getFirstShowPlayControl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "setFirstShowPlayControl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;)V", "id", "getId", "setId", "itemId", "getItemId", "setItemId", "selectionUrl", "getSelectionUrl", "setSelectionUrl", "finishUrl", "getFinishUrl", "setFinishUrl", "seasonIdStr", "getSeasonIdStr", "setSeasonIdStr", "seasonId", "Ljava/lang/Long;", "getSeasonId", "()Ljava/lang/Long;", "setSeasonId", "(Ljava/lang/Long;)V", "collected", "Z", "getCollected", "()Z", "setCollected", "(Z)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "titleIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "getTitleIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "setTitleIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;)V", "relationPlaceText", "getRelationPlaceText", "setRelationPlaceText", "operationPlaceTextList", "Ljava/util/List;", "getOperationPlaceTextList", "()Ljava/util/List;", "setOperationPlaceTextList", "(Ljava/util/List;)V", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSToolbarConfigData;", "toolbarConfigList", "getToolbarConfigList", "setToolbarConfigList", "pannelToolbarList", "getPannelToolbarList", "setPannelToolbarList", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessConfigure;", "businessConfigure", "getBusinessConfigure", "setBusinessConfigure", "releaseTime", "getReleaseTime", "setReleaseTime", "background", "getBackground", "setBackground", "", "period", "I", "getPeriod", "()I", "setPeriod", "(I)V", "nextSpecialEpisodeId", "getNextSpecialEpisodeId", "setNextSpecialEpisodeId", "style", "getStyle", "setStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "panelIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "getPanelIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;", "setPanelIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPanelIcon;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "vsGiftPannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "getVsGiftPannel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "setVsGiftPannel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;)V", "drawSubTitle", "getDrawSubTitle", "setDrawSubTitle", "seasonCoverVertical", "getSeasonCoverVertical", "setSeasonCoverVertical", "showName", "getShowName", "setShowName", "multiSeasonTag", "getMultiSeasonTag", "setMultiSeasonTag", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "cameraInfos", "getCameraInfos", "setCameraInfos", "defaultCameraId", "getDefaultCameraId", "setDefaultCameraId", "defaultCameraIdStr", "getDefaultCameraIdStr", "setDefaultCameraIdStr", "priorityCameraInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "getPriorityCameraInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "setPriorityCameraInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;)V", "mod", "getMod", "setMod", "seasonTypeName", "getSeasonTypeName", "setSeasonTypeName", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSBar;", "vsBar", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSBar;", "getVsBar", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSBar;", "setVsBar", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSBar;)V", "seasonWatchInfo", "getSeasonWatchInfo", "setSeasonWatchInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "vsLinkedRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "getVsLinkedRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "setVsLinkedRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPremiereToast;", "vsPremiereToast", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPremiereToast;", "getVsPremiereToast", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPremiereToast;", "setVsPremiereToast", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSPremiereToast;)V", "cameraInfosTableTitle", "getCameraInfosTableTitle", "setCameraInfosTableTitle", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "matchRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "getMatchRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "setMatchRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;)V", "getMatchRoomInfo$annotations", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MainCameraMatchInfo;", "mainCameraMatchInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MainCameraMatchInfo;", "getMainCameraMatchInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MainCameraMatchInfo;", "setMainCameraMatchInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MainCameraMatchInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "multiTab", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "getMultiTab", "()Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "setMultiTab", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;)V", "groupId", "getGroupId", "setGroupId", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MultiCameraBasicInfo;", "multiCameraBasicInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MultiCameraBasicInfo;", "getMultiCameraBasicInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MultiCameraBasicInfo;", "setMultiCameraBasicInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MultiCameraBasicInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo;", "sharePosterInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo;", "getSharePosterInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo;", "setSharePosterInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/SharePosterInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage;", "previewImage", "Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage;", "getPreviewImage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage;", "setPreviewImage", "(Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "previewBottom", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "getPreviewBottom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "setPreviewBottom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;)V", "previewBackground", "getPreviewBackground", "setPreviewBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "_paidInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "get_paidInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "set_paidInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;)V", "_liveUser", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "get_liveUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "set_liveUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "ownerUserId", "getOwnerUserId", "setOwnerUserId", "getOwnerUserId$annotations", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeVideo;", "_video", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeVideo;", "get_video", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeVideo;", "set_video", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeVideo;)V", "_highlights", "get_highlights", "set_highlights", "_startHighLight", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "get_startHighLight", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "set_startHighLight", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;)V", "_highLightFirst", "get_highLightFirst", "set_highLightFirst", "_statistics", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "get_statistics", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "set_statistics", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;)V", "_roomId", "get_roomId", "set_roomId", "_userStatistics", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;", "get_userStatistics", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;", "set_userStatistics", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "vsWatermark", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "getVsWatermark", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "setVsWatermark", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;)V", "publicScreenColor", "getPublicScreenColor", "setPublicScreenColor", "chatTrayColor", "getChatTrayColor", "setChatTrayColor", "mainCameraCover", "getMainCameraCover", "setMainCameraCover", "mainCameraTitle", "getMainCameraTitle", "setMainCameraTitle", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSConfigDrawer;", "vsConfigDrawer", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSConfigDrawer;", "getVsConfigDrawer", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSConfigDrawer;", "setVsConfigDrawer", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSConfigDrawer;)V", "currentCameraId", "getCurrentCameraId", "setCurrentCameraId", "getCurrentCameraId$annotations", "previewBottomText", "getPreviewBottomText", "setPreviewBottomText", "_privilegeInfo", "Ljava/util/Map;", "get_privilegeInfo", "()Ljava/util/Map;", "set_privilegeInfo", "(Ljava/util/Map;)V", "get_privilegeInfo$annotations", "privilegeInfoV2", "getPrivilegeInfoV2", "setPrivilegeInfoV2", "isInteractConfigExist", "setInteractConfigExist", "shareType", "getShareType", "setShareType", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSGiftPanel;", "getVSGiftPanel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSGiftPanel;", "vSGiftPanel", "<init>", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeExtraInfo extends FlexModelBase<IEpisodeExtraInfo> implements IEpisodeExtraInfo, h {

    @SerializedName("start_hl_first")
    @IgnoreProtoDecode
    private boolean _highLightFirst;

    @SerializedName("highlights")
    @IgnoreProtoDecode
    private List<? extends IEpisodeHighLight> _highlights;

    @SerializedName("owner")
    @IgnoreProtoDecode
    private IBaseUser _liveUser;

    @SerializedName("paid_info")
    @IgnoreProtoDecode
    private EpisodePaidInfo _paidInfo;

    @SerializedName("privilege_info")
    protected Map<Integer, PrivilegeInfo> _privilegeInfo;

    @SerializedName("room_id")
    @IgnoreProtoDecode
    private long _roomId;

    @SerializedName("start_hl")
    @IgnoreProtoDecode
    private IEpisodeStartHighLight _startHighLight;

    @SerializedName("statistics")
    @IgnoreProtoDecode
    private IEpisodeStatistics _statistics;

    @SerializedName("user_statistics")
    @IgnoreProtoDecode
    private IEpisodeUserStatistics _userStatistics;

    @SerializedName(a.KEY_VIDEO_INFO)
    @IgnoreProtoDecode
    private EpisodeVideo _video;

    @SerializedName("background")
    protected k background;

    @SerializedName("business_configure")
    protected List<BusinessConfigure> businessConfigure;

    @SerializedName("camera_infos")
    protected List<? extends IVSCameraInfo> cameraInfos;

    @SerializedName("camera_infos_table_title")
    protected String cameraInfosTableTitle;

    @SerializedName("chat_tray_color")
    protected String chatTrayColor;

    @SerializedName("collected")
    protected boolean collected;

    @SerializedName("cover")
    protected k cover;

    @IgnoreProtoDecode
    private long currentCameraId;

    @SerializedName("current_period")
    protected String currentPeriod;

    @SerializedName("default_camera_id")
    protected long defaultCameraId;

    @SerializedName("default_camera_id_str")
    protected Long defaultCameraIdStr;

    @SerializedName("draw_sub_title")
    protected String drawSubTitle;

    @SerializedName("episode_id_str")
    protected String episodeIdStr;

    @SerializedName("episode_list_h5")
    protected String episodeListH5;

    @SerializedName("episode_mod")
    protected IBaseEpisodeMod episodeMod;

    @SerializedName("watch_info")
    protected IEpisodeWatchInfo episodeWatchInfo;

    @SerializedName("finish_url")
    protected String finishUrl;

    @SerializedName("play_control")
    protected IEpisodePremierePlay firstShowPlayControl;

    @SerializedName("group_id")
    protected long groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("episode_id")
    protected long f162617id;

    @SerializedName("is_interact_config_exist")
    protected boolean isInteractConfigExist;

    @SerializedName("item_id")
    protected String itemId;

    @SerializedName("latest_period")
    protected long latestPeriod;

    @SerializedName("main_camera_cover")
    protected k mainCameraCover;

    @SerializedName("main_camera_match_info")
    protected MainCameraMatchInfo mainCameraMatchInfo;

    @SerializedName("main_camera_title")
    protected String mainCameraTitle;

    @SerializedName("match_room_info")
    protected IMatchRoomInfo matchRoomInfo;

    @SerializedName("mod")
    protected IBaseEpisodeMod mod;

    @SerializedName("multi_camera_basic_info")
    protected MultiCameraBasicInfo multiCameraBasicInfo;

    @SerializedName("multi_season_tag")
    protected String multiSeasonTag;

    @SerializedName("multi_tab")
    protected MultiTab multiTab;

    @SerializedName("next_special_episode_id")
    protected long nextSpecialEpisodeId;

    @SerializedName("operation_place_text_list")
    protected List<String> operationPlaceTextList;

    @SerializedName("owner_user_id")
    @IgnoreProtoDecode
    private long ownerUserId;

    @SerializedName("pannel_icon")
    protected VSPanelIcon panelIcon;

    @SerializedName("pannel_toolbar")
    protected List<VSToolbarConfigData> pannelToolbarList;

    @SerializedName("current_period_raw")
    protected int period;

    @SerializedName("preview_background")
    protected k previewBackground;

    @SerializedName("preview_bottom")
    protected IEpisodePreviewBottom previewBottom;

    @SerializedName("preview_bottom_text")
    protected String previewBottomText;

    @SerializedName("preview_image")
    protected EpisodePreviewImage previewImage;

    @SerializedName("priority_camera")
    protected IVSCameraInfo priorityCameraInfo;

    @SerializedName("privilege_info_v2")
    protected Map<String, PrivilegeInfo> privilegeInfoV2;

    @SerializedName("public_screen_color")
    protected String publicScreenColor;

    @SerializedName("relation_place_text")
    protected String relationPlaceText;

    @SerializedName("release_time")
    @IgnoreProtoDecode
    private String releaseTime;

    @SerializedName("season_cover_vertical")
    protected k seasonCoverVertical;

    @SerializedName("season_id")
    protected Long seasonId;

    @SerializedName("season_id_str")
    protected String seasonIdStr;

    @SerializedName("season_type_name")
    protected String seasonTypeName;

    @SerializedName("season_watch_info")
    protected IEpisodeWatchInfo seasonWatchInfo;

    @SerializedName("selection_url")
    protected String selectionUrl;

    @SerializedName("share_poster_info")
    protected SharePosterInfo sharePosterInfo;

    @SerializedName("share_type")
    protected int shareType;

    @SerializedName("show_name")
    protected String showName;

    @SerializedName("style")
    protected int style;

    @SerializedName("title")
    protected String title;

    @SerializedName("title_icon")
    protected IVSTitleIcon titleIcon;

    @SerializedName("toolbar_list")
    protected List<VSToolbarConfigData> toolbarConfigList;

    @SerializedName("vs_bar")
    protected VSBar vsBar;

    @SerializedName("vs_config_drawer")
    protected VSConfigDrawer vsConfigDrawer;

    @SerializedName("gift_pannel")
    protected VSGiftPannel vsGiftPannel;

    @SerializedName("link_room_info")
    protected VSLinkedRoomInfo vsLinkedRoomInfo;

    @SerializedName("premiere_toast")
    protected VSPremiereToast vsPremiereToast;

    @SerializedName("vs_watermark")
    protected IVSWatermark vsWatermark;

    @SerializedName("watch_period")
    protected long watchPeriod;

    @Deprecated(message = "")
    public static /* synthetic */ void getCurrentCameraId$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getEpisodeMod$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getMatchRoomInfo$annotations() {
    }

    @Deprecated(message = " 这个字段本身IDL里面就没有，留他在这里仅仅为了避免过多无用修改和奇怪的修改（给一个方法返回空）")
    public static /* synthetic */ void getOwnerUserId$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void get_privilegeInfo$annotations() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public Map<String, PrivilegeInfo> getPrivilegeInfo() {
        return null;
    }

    public EpisodeExtraInfo() {
        super(IEpisodeExtraInfo.class);
        this._highLightFirst = true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public String getOwnerUserIdStr() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.ownerUserId);
        r100.getClass();
        return o0.a.g(r101, "0");
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public /* bridge */ /* synthetic */ IMultiTab getMultiTab() {
        return getMultiTab();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public /* bridge */ /* synthetic */ IEpisodePreviewImage getPreviewImage() {
        return getPreviewImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IBaseEpisodeMod getRealMod() {
        if (getMod() == null) goto L7;
        return getMod();
    L7:
        return getEpisodeMod();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public k getBackground() {
        return this.background;
    }

    public final List<BusinessConfigure> getBusinessConfigure() {
        return this.businessConfigure;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public List<IVSCameraInfo> getCameraInfos() {
        return this.cameraInfos;
    }

    public final String getCameraInfosTableTitle() {
        return this.cameraInfosTableTitle;
    }

    public final String getChatTrayColor() {
        return this.chatTrayColor;
    }

    public final boolean getCollected() {
        return this.collected;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public k getCover() {
        return this.cover;
    }

    public final long getCurrentCameraId() {
        return this.currentCameraId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getCurrentPeriod() {
        return this.currentPeriod;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public long getDefaultCameraId() {
        return this.defaultCameraId;
    }

    public final Long getDefaultCameraIdStr() {
        return this.defaultCameraIdStr;
    }

    public final String getDrawSubTitle() {
        return this.drawSubTitle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getEpisodeIdStr() {
        return this.episodeIdStr;
    }

    public final String getEpisodeListH5() {
        return this.episodeListH5;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IBaseEpisodeMod getEpisodeMod() {
        return this.episodeMod;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IEpisodeWatchInfo getEpisodeWatchInfo() {
        return this.episodeWatchInfo;
    }

    public final String getFinishUrl() {
        return this.finishUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IEpisodePremierePlay getFirstShowPlayControl() {
        return this.firstShowPlayControl;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public boolean getHighLightFirst() {
        return this._highLightFirst;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public List<IEpisodeHighLight> getHighlights() {
        return this._highlights;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public long getId() {
        return this.f162617id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getItemId() {
        return this.itemId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public long getLatestPeriod() {
        return this.latestPeriod;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IBaseUser getLiveUser() {
        return this._liveUser;
    }

    public final k getMainCameraCover() {
        return this.mainCameraCover;
    }

    public final MainCameraMatchInfo getMainCameraMatchInfo() {
        return this.mainCameraMatchInfo;
    }

    public final String getMainCameraTitle() {
        return this.mainCameraTitle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IMatchRoomInfo getMatchRoomInfo() {
        return this.matchRoomInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IBaseEpisodeMod getMod() {
        return this.mod;
    }

    public final MultiCameraBasicInfo getMultiCameraBasicInfo() {
        return this.multiCameraBasicInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getMultiSeasonTag() {
        return this.multiSeasonTag;
    }

    public final long getNextSpecialEpisodeId() {
        return this.nextSpecialEpisodeId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public List<String> getOperationPlaceTextList() {
        return this.operationPlaceTextList;
    }

    public final long getOwnerUserId() {
        return this.ownerUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IEpisodePaidInfo getPaidInfo() {
        return this._paidInfo;
    }

    public final VSPanelIcon getPanelIcon() {
        return this.panelIcon;
    }

    public final List<VSToolbarConfigData> getPannelToolbarList() {
        return this.pannelToolbarList;
    }

    public final int getPeriod() {
        return this.period;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public k getPreviewBackground() {
        return this.previewBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IEpisodePreviewBottom getPreviewBottom() {
        return this.previewBottom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getPreviewBottomText() {
        return this.previewBottomText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IVSCameraInfo getPriorityCameraInfo() {
        return this.priorityCameraInfo;
    }

    public final Map<String, PrivilegeInfo> getPrivilegeInfoV2() {
        return this.privilegeInfoV2;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getPublicScreenColor() {
        return this.publicScreenColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getRelationPlaceText() {
        return this.relationPlaceText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getReleaseTime() {
        return this.releaseTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public long getRoomId() {
        return this._roomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public k getSeasonCoverVertical() {
        return this.seasonCoverVertical;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public Long getSeasonId() {
        return this.seasonId;
    }

    public final String getSeasonIdStr() {
        return this.seasonIdStr;
    }

    public final String getSeasonTypeName() {
        return this.seasonTypeName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IEpisodeWatchInfo getSeasonWatchInfo() {
        return this.seasonWatchInfo;
    }

    public final String getSelectionUrl() {
        return this.selectionUrl;
    }

    public final SharePosterInfo getSharePosterInfo() {
        return this.sharePosterInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public int getShareType() {
        return this.shareType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getShowName() {
        return this.showName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IEpisodeStartHighLight getStartHighLight() {
        return this._startHighLight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IEpisodeStatistics getStatistics() {
        return this._statistics;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public int getStyle() {
        return this.style;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IVSTitleIcon getTitleIcon() {
        return this.titleIcon;
    }

    public final List<VSToolbarConfigData> getToolbarConfigList() {
        return this.toolbarConfigList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IEpisodeUserStatistics getUserStatistics() {
        return this._userStatistics;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoBase
    public IVSGiftPanel getVSGiftPanel() {
        return this.vsGiftPannel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoEx
    public IEpisodeVideo getVideo() {
        return this._video;
    }

    public final VSBar getVsBar() {
        return this.vsBar;
    }

    public final VSConfigDrawer getVsConfigDrawer() {
        return this.vsConfigDrawer;
    }

    public final VSGiftPannel getVsGiftPannel() {
        return this.vsGiftPannel;
    }

    public final VSLinkedRoomInfo getVsLinkedRoomInfo() {
        return this.vsLinkedRoomInfo;
    }

    public final VSPremiereToast getVsPremiereToast() {
        return this.vsPremiereToast;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public IVSWatermark getVsWatermark() {
        return this.vsWatermark;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public long getWatchPeriod() {
        return this.watchPeriod;
    }

    public final boolean get_highLightFirst() {
        return this._highLightFirst;
    }

    public final List<IEpisodeHighLight> get_highlights() {
        return this._highlights;
    }

    public final IBaseUser get_liveUser() {
        return this._liveUser;
    }

    public final EpisodePaidInfo get_paidInfo() {
        return this._paidInfo;
    }

    public final Map<Integer, PrivilegeInfo> get_privilegeInfo() {
        return this._privilegeInfo;
    }

    public final long get_roomId() {
        return this._roomId;
    }

    public final IEpisodeStartHighLight get_startHighLight() {
        return this._startHighLight;
    }

    public final IEpisodeStatistics get_statistics() {
        return this._statistics;
    }

    public final IEpisodeUserStatistics get_userStatistics() {
        return this._userStatistics;
    }

    public final EpisodeVideo get_video() {
        return this._video;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public boolean isInteractConfigExist() {
        return this.isInteractConfigExist;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public MultiTab getMultiTab() {
        return this.multiTab;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public EpisodePreviewImage getPreviewImage() {
        return this.previewImage;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v29, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v36, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePreviewBottom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v45, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v52, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v54, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermark, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v58, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v62, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v84, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IVSTitleIcon, java.lang.Object] */
    public EpisodeExtraInfo(g r110) {
        super(IEpisodeExtraInfo.class);
        this.operationPlaceTextList = new ArrayList();
        this.toolbarConfigList = new ArrayList();
        this.pannelToolbarList = new ArrayList();
        this.businessConfigure = new ArrayList();
        this.cameraInfos = new ArrayList();
        this._privilegeInfo = new HashMap();
        this.privilegeInfoV2 = new HashMap();
        this._highLightFirst = true;
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L104;
        g.a r102 = decodeExtensionFields(r101, r110);
        Object r103 = null;
        switch(r101) {
            case 1: goto L103;
            case 2: goto L102;
            case 3: goto L101;
            case 4: goto L100;
            case 5: goto L99;
            case 6: goto L98;
            case 7: goto L97;
            case 8: goto L96;
            case 9: goto L95;
            case 10: goto L94;
            case 11: goto L92;
            case 12: goto L90;
            case 13: goto L89;
            case 14: goto L88;
            case 15: goto L87;
            case 16: goto L7;
            case 17: goto L86;
            case 18: goto L85;
            case 19: goto L84;
            case 20: goto L83;
            case 21: goto L7;
            case 22: goto L82;
            case 23: goto L7;
            case 24: goto L81;
            case 25: goto L80;
            case 26: goto L7;
            case 27: goto L79;
            case 28: goto L78;
            case 29: goto L77;
            case 30: goto L76;
            case 31: goto L75;
            case 32: goto L74;
            case 33: goto L73;
            case 34: goto L72;
            case 35: goto L71;
            case 36: goto L70;
            case 37: goto L69;
            case 38: goto L68;
            case 39: goto L7;
            case 40: goto L67;
            case 41: goto L66;
            case 42: goto L65;
            case 43: goto L64;
            case 44: goto L63;
            case 45: goto L7;
            case 46: goto L62;
            case 47: goto L7;
            case 48: goto L61;
            case 49: goto L60;
            case 50: goto L59;
            case 51: goto L58;
            case 52: goto L7;
            case 53: goto L57;
            case 54: goto L7;
            case 55: goto L56;
            case 56: goto L55;
            case 57: goto L54;
            case 58: goto L53;
            case 59: goto L52;
            case 60: goto L51;
            case 61: goto L50;
            case 62: goto L49;
            case 63: goto L48;
            case 64: goto L47;
            case 65: goto L46;
            case 66: goto L30;
            case 67: goto L29;
            case 68: goto L28;
            case 69: goto L27;
            case 70: goto L26;
            case 71: goto L25;
            case 72: goto L7;
            case 73: goto L9;
            case 74: goto L8;
            default: goto L7;
        };
    L8:
        this.shareType = r110.i();
        goto L3
    L9:
        long r111 = r110.c();
        PrivilegeInfo r104 = null;
    L10:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L10
    L13:
        if (r105 != 2) goto L14;
        r104 = new PrivilegeInfo(r110);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r111);
        Map r106 = this.privilegeInfoV2;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
    L41:
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.titleIcon = f.a(r110, IVSTitleIcon.class);
        goto L3
    L26:
        this.vsConfigDrawer = _VSConfigDrawer_ProtoDecoder.decodeStatic(r110);
        goto L3
    L27:
        this.groupId = r110.j();
        goto L3
    L28:
        this.mainCameraMatchInfo = new MainCameraMatchInfo(r110);
        goto L3
    L29:
        this.isInteractConfigExist = am3.h.a(r110);
        goto L3
    L30:
        long r112 = r110.c();
        r104 = null;
    L31:
        int r107 = r110.f();
        if (r107 == (-1)) goto L38;
        if (r107 != 1) goto L34;
        r103 = Integer.valueOf(r110.i());
        goto L31
    L34:
        if (r107 != 2) goto L35;
        r104 = new PrivilegeInfo(r110);
        goto L31
    L35:
        am3.h.e(r110);
        goto L31
    L38:
        r110.d(r112);
        r106 = this._privilegeInfo;
        if (r103 == null) goto L45;
        if (r104 != null) goto L41;
        throw new IllegalStateException("Value must not be null");
    L45:
        throw new IllegalStateException("Key must not be null");
    L46:
        this.mainCameraTitle = am3.h.c(r110);
        goto L3
    L47:
        this.mainCameraCover = f.a(r110, k.class);
        goto L3
    L48:
        this.multiTab = new MultiTab(r110);
        goto L3
    L49:
        this.chatTrayColor = am3.h.c(r110);
        goto L3
    L50:
        this.publicScreenColor = am3.h.c(r110);
        goto L3
    L51:
        List r108 = this.businessConfigure;
        Object r109 = _BusinessConfigure_ProtoDecoder.decodeStatic(r110);
    L93:
        r108.add(r109);
        goto L3
    L52:
        this.previewBottomText = am3.h.c(r110);
        goto L3
    L53:
        this.vsPremiereToast = _VSPremiereToast_ProtoDecoder.decodeStatic(r110);
        goto L3
    L54:
        this.sharePosterInfo = new SharePosterInfo(r110);
        goto L3
    L55:
        this.multiCameraBasicInfo = new MultiCameraBasicInfo(r110);
        goto L3
    L56:
        this.matchRoomInfo = f.a(r110, IMatchRoomInfo.class);
        goto L3
    L57:
        this.cameraInfosTableTitle = am3.h.c(r110);
        goto L3
    L58:
        this.vsLinkedRoomInfo = new VSLinkedRoomInfo(r110);
        goto L3
    L59:
        this.seasonWatchInfo = f.a(r110, IEpisodeWatchInfo.class);
        goto L3
    L60:
        this.vsBar = _VSBar_ProtoDecoder.decodeStatic(r110);
        goto L3
    L61:
        this.seasonTypeName = am3.h.c(r110);
        goto L3
    L62:
        this.vsWatermark = f.a(r110, IVSWatermark.class);
        goto L3
    L63:
        this.mod = f.a(r110, IBaseEpisodeMod.class);
        goto L3
    L64:
        this.background = f.a(r110, k.class);
        goto L3
    L65:
        this.previewBackground = f.a(r110, k.class);
        goto L3
    L66:
        this.multiSeasonTag = am3.h.c(r110);
        goto L3
    L67:
        this.priorityCameraInfo = f.a(r110, IVSCameraInfo.class);
        goto L3
    L68:
        this.defaultCameraIdStr = Long.valueOf(r110.j());
        goto L3
    L69:
        this.defaultCameraId = r110.j();
        goto L3
    L70:
        r108 = this.cameraInfos;
        r109 = f.a(r110, IVSCameraInfo.class);
        goto L93
    L71:
        this.seasonCoverVertical = f.a(r110, k.class);
        goto L3
    L72:
        this.drawSubTitle = am3.h.c(r110);
        goto L3
    L73:
        this.previewBottom = f.a(r110, IEpisodePreviewBottom.class);
        goto L3
    L74:
        r108 = this.pannelToolbarList;
    L91:
        r109 = _VSToolbarConfigData_ProtoDecoder.decodeStatic(r110);
        goto L93
    L75:
        this.panelIcon = new VSPanelIcon(r110);
        goto L3
    L76:
        this.vsGiftPannel = new VSGiftPannel(r110);
        goto L3
    L77:
        this.previewImage = new EpisodePreviewImage(r110);
        goto L3
    L78:
        this.firstShowPlayControl = f.a(r110, IEpisodePremierePlay.class);
        goto L3
    L79:
        this.style = r110.i();
        goto L3
    L80:
        this.cover = f.a(r110, k.class);
        goto L3
    L81:
        this.nextSpecialEpisodeId = r110.j();
        goto L3
    L82:
        this.seasonIdStr = am3.h.c(r110);
        goto L3
    L83:
        this.period = r110.i();
        goto L3
    L84:
        this.showName = am3.h.c(r110);
        goto L3
    L85:
        this.latestPeriod = r110.j();
        goto L3
    L86:
        this.watchPeriod = r110.j();
        goto L3
    L87:
        this.finishUrl = am3.h.c(r110);
        goto L3
    L88:
        this.seasonId = Long.valueOf(r110.j());
        goto L3
    L89:
        this.collected = am3.h.a(r110);
        goto L3
    L90:
        r108 = this.toolbarConfigList;
        goto L91
    L92:
        r108 = this.operationPlaceTextList;
        r109 = am3.h.c(r110);
        goto L93
    L94:
        this.relationPlaceText = am3.h.c(r110);
        goto L3
    L95:
        this.selectionUrl = am3.h.c(r110);
        goto L3
    L96:
        this.itemId = am3.h.c(r110);
        goto L3
    L97:
        this.episodeIdStr = am3.h.c(r110);
        goto L3
    L98:
        this.f162617id = r110.j();
        goto L3
    L99:
        this.episodeWatchInfo = f.a(r110, IEpisodeWatchInfo.class);
        goto L3
    L100:
        this.episodeListH5 = am3.h.c(r110);
        goto L3
    L101:
        this.title = am3.h.c(r110);
        goto L3
    L102:
        this.currentPeriod = am3.h.c(r110);
        goto L3
    L103:
        this.episodeMod = f.a(r110, IBaseEpisodeMod.class);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L104:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setBackground(k r100) {
        this.background = r100;
    }

    public final void setBusinessConfigure(List<BusinessConfigure> r100) {
        this.businessConfigure = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setCameraInfos(List<? extends IVSCameraInfo> r100) {
        this.cameraInfos = r100;
    }

    public final void setCameraInfosTableTitle(String r100) {
        this.cameraInfosTableTitle = r100;
    }

    public final void setChatTrayColor(String r100) {
        this.chatTrayColor = r100;
    }

    public final void setCollected(boolean r100) {
        this.collected = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setCover(k r100) {
        this.cover = r100;
    }

    public final void setCurrentCameraId(long r100) {
        this.currentCameraId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setCurrentPeriod(String r100) {
        this.currentPeriod = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setDefaultCameraId(long r100) {
        this.defaultCameraId = r100;
    }

    public final void setDefaultCameraIdStr(Long r100) {
        this.defaultCameraIdStr = r100;
    }

    public final void setDrawSubTitle(String r100) {
        this.drawSubTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setEpisodeIdStr(String r100) {
        this.episodeIdStr = r100;
    }

    public final void setEpisodeListH5(String r100) {
        this.episodeListH5 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setEpisodeMod(IBaseEpisodeMod r100) {
        this.episodeMod = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setEpisodeWatchInfo(IEpisodeWatchInfo r100) {
        this.episodeWatchInfo = r100;
    }

    public final void setFinishUrl(String r100) {
        this.finishUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setFirstShowPlayControl(IEpisodePremierePlay r100) {
        this.firstShowPlayControl = r100;
    }

    public final void setGroupId(long r100) {
        this.groupId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setId(long r100) {
        this.f162617id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setInteractConfigExist(boolean r100) {
        this.isInteractConfigExist = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setItemId(String r100) {
        this.itemId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setLatestPeriod(long r100) {
        this.latestPeriod = r100;
    }

    public final void setMainCameraCover(k r100) {
        this.mainCameraCover = r100;
    }

    public final void setMainCameraMatchInfo(MainCameraMatchInfo r100) {
        this.mainCameraMatchInfo = r100;
    }

    public final void setMainCameraTitle(String r100) {
        this.mainCameraTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setMatchRoomInfo(IMatchRoomInfo r100) {
        this.matchRoomInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setMod(IBaseEpisodeMod r100) {
        this.mod = r100;
    }

    public final void setMultiCameraBasicInfo(MultiCameraBasicInfo r100) {
        this.multiCameraBasicInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setMultiSeasonTag(String r100) {
        this.multiSeasonTag = r100;
    }

    public void setMultiTab(MultiTab r100) {
        this.multiTab = r100;
    }

    public final void setNextSpecialEpisodeId(long r100) {
        this.nextSpecialEpisodeId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setOperationPlaceTextList(List<String> r100) {
        this.operationPlaceTextList = r100;
    }

    public final void setOwnerUserId(long r100) {
        this.ownerUserId = r100;
    }

    public final void setPanelIcon(VSPanelIcon r100) {
        this.panelIcon = r100;
    }

    public final void setPannelToolbarList(List<VSToolbarConfigData> r100) {
        this.pannelToolbarList = r100;
    }

    public final void setPeriod(int r100) {
        this.period = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setPreviewBackground(k r100) {
        this.previewBackground = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setPreviewBottom(IEpisodePreviewBottom r100) {
        this.previewBottom = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setPreviewBottomText(String r100) {
        this.previewBottomText = r100;
    }

    public void setPreviewImage(EpisodePreviewImage r100) {
        this.previewImage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setPriorityCameraInfo(IVSCameraInfo r100) {
        this.priorityCameraInfo = r100;
    }

    public final void setPrivilegeInfo(Map<String, PrivilegeInfo> r100) {
        this.privilegeInfoV2 = r100;
    }

    public final void setPrivilegeInfoV2(Map<String, PrivilegeInfo> r100) {
        this.privilegeInfoV2 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setPublicScreenColor(String r100) {
        this.publicScreenColor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setRelationPlaceText(String r100) {
        this.relationPlaceText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setReleaseTime(String r100) {
        this.releaseTime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setSeasonCoverVertical(k r100) {
        this.seasonCoverVertical = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setSeasonId(Long r100) {
        this.seasonId = r100;
    }

    public final void setSeasonIdStr(String r100) {
        this.seasonIdStr = r100;
    }

    public final void setSeasonTypeName(String r100) {
        this.seasonTypeName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setSeasonWatchInfo(IEpisodeWatchInfo r100) {
        this.seasonWatchInfo = r100;
    }

    public final void setSelectionUrl(String r100) {
        this.selectionUrl = r100;
    }

    public final void setSharePosterInfo(SharePosterInfo r100) {
        this.sharePosterInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setShareType(int r100) {
        this.shareType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setShowName(String r100) {
        this.showName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setStyle(int r100) {
        this.style = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setTitle(String r100) {
        this.title = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setTitleIcon(IVSTitleIcon r100) {
        this.titleIcon = r100;
    }

    public final void setToolbarConfigList(List<VSToolbarConfigData> r100) {
        this.toolbarConfigList = r100;
    }

    public final void setVsBar(VSBar r100) {
        this.vsBar = r100;
    }

    public final void setVsConfigDrawer(VSConfigDrawer r100) {
        this.vsConfigDrawer = r100;
    }

    public final void setVsGiftPannel(VSGiftPannel r100) {
        this.vsGiftPannel = r100;
    }

    public final void setVsLinkedRoomInfo(VSLinkedRoomInfo r100) {
        this.vsLinkedRoomInfo = r100;
    }

    public final void setVsPremiereToast(VSPremiereToast r100) {
        this.vsPremiereToast = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setVsWatermark(IVSWatermark r100) {
        this.vsWatermark = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo
    public void setWatchPeriod(long r100) {
        this.watchPeriod = r100;
    }

    public final void set_highLightFirst(boolean r100) {
        this._highLightFirst = r100;
    }

    public final void set_highlights(List<? extends IEpisodeHighLight> r100) {
        this._highlights = r100;
    }

    public final void set_liveUser(IBaseUser r100) {
        this._liveUser = r100;
    }

    public final void set_paidInfo(EpisodePaidInfo r100) {
        this._paidInfo = r100;
    }

    public final void set_privilegeInfo(Map<Integer, PrivilegeInfo> r100) {
        this._privilegeInfo = r100;
    }

    public final void set_roomId(long r100) {
        this._roomId = r100;
    }

    public final void set_startHighLight(IEpisodeStartHighLight r100) {
        this._startHighLight = r100;
    }

    public final void set_statistics(IEpisodeStatistics r100) {
        this._statistics = r100;
    }

    public final void set_userStatistics(IEpisodeUserStatistics r100) {
        this._userStatistics = r100;
    }

    public final void set_video(EpisodeVideo r100) {
        this._video = r100;
    }
}
