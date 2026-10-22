package com.bytedance.android.livesdk.message.model;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.annotation.IgnoreStyleCheck;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GiftMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u0090\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0091\u0002B\t¢\u0006\u0006\b\u008e\u0002\u0010\u008f\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0000J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J-\u0010#\u001a\u00028\u0000\"\u000e\b\u0000\u0010 *\b\u0012\u0004\u0012\u00020\u00030\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016¢\u0006\u0004\b#\u0010$J/\u0010%\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010 *\b\u0012\u0004\u0012\u00020\u00030\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016¢\u0006\u0004\b%\u0010$J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140(H\u0016J\u0016\u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140(H\u0016R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\"\u0010;\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b;\u00103\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\"\u0010>\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\"\u0010B\u001a\u00020A8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR*\u0010I\u001a\u0002012\u0006\u0010H\u001a\u0002018\u0016@WX\u0097\u000e¢\u0006\u0012\n\u0004\bI\u00103\u001a\u0004\bJ\u00105\"\u0004\bK\u00107R*\u0010L\u001a\u0002012\u0006\u0010H\u001a\u0002018\u0016@WX\u0097\u000e¢\u0006\u0012\n\u0004\bL\u00103\u001a\u0004\bM\u00105\"\u0004\bN\u00107R*\u0010O\u001a\u0002012\u0006\u0010H\u001a\u0002018\u0016@WX\u0097\u000e¢\u0006\u0012\n\u0004\bO\u00103\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R$\u0010S\u001a\u0004\u0018\u00010R8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010\\\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b\\\u0010^\"\u0004\b_\u0010`R\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010]R$\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010t\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bt\u00103\u001a\u0004\bu\u00105\"\u0004\bv\u00107R$\u0010x\u001a\u0004\u0018\u00010w8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u007f\u001a\u0004\u0018\u00010~8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010]\u001a\u0005\b\u0086\u0001\u0010^\"\u0005\b\u0087\u0001\u0010`R+\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0089\u0001\u001a\u0006\b\u008f\u0001\u0010\u008b\u0001\"\u0006\b\u0090\u0001\u0010\u008d\u0001R&\u0010\u0091\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u00103\u001a\u0005\b\u0092\u0001\u00105\"\u0005\b\u0093\u0001\u00107R&\u0010\u0094\u0001\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u00103\u001a\u0005\b\u0095\u0001\u00105\"\u0005\b\u0096\u0001\u00107R1\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R+\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0089\u0001\u001a\u0006\b\u009e\u0001\u0010\u008b\u0001\"\u0006\b\u009f\u0001\u0010\u008d\u0001R&\u0010 \u0001\u001a\u00020A8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010C\u001a\u0005\b¡\u0001\u0010E\"\u0005\b¢\u0001\u0010GR,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R2\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010\u0098\u0001\u001a\u0006\b¬\u0001\u0010\u009a\u0001\"\u0006\b\u00ad\u0001\u0010\u009c\u0001R2\u0010®\u0001\u001a\u000b\u0012\u0004\u0012\u000201\u0018\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010\u0098\u0001\u001a\u0006\b¯\u0001\u0010\u009a\u0001\"\u0006\b°\u0001\u0010\u009c\u0001R&\u0010±\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b±\u0001\u00103\u001a\u0005\b²\u0001\u00105\"\u0005\b³\u0001\u00107R&\u0010´\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b´\u0001\u00103\u001a\u0005\bµ\u0001\u00105\"\u0005\b¶\u0001\u00107R&\u0010·\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b·\u0001\u00103\u001a\u0005\b¸\u0001\u00105\"\u0005\b¹\u0001\u00107R,\u0010»\u0001\u001a\u0005\u0018\u00010º\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R,\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R,\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R&\u0010Ï\u0001\u001a\u00020A8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010C\u001a\u0005\bÐ\u0001\u0010E\"\u0005\bÑ\u0001\u0010GR&\u0010Ò\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010]\u001a\u0005\bÓ\u0001\u0010^\"\u0005\bÔ\u0001\u0010`R2\u0010Ö\u0001\u001a\u000b\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010\u0098\u0001\u001a\u0006\b×\u0001\u0010\u009a\u0001\"\u0006\bØ\u0001\u0010\u009c\u0001R&\u0010Ù\u0001\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÙ\u0001\u00103\u001a\u0005\bÚ\u0001\u00105\"\u0005\bÛ\u0001\u00107R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010]R&\u0010Ü\u0001\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÜ\u0001\u0010C\u001a\u0005\bÝ\u0001\u0010E\"\u0005\bÞ\u0001\u0010GR&\u0010ß\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bß\u0001\u0010]\u001a\u0005\bß\u0001\u0010^\"\u0005\bà\u0001\u0010`R&\u0010á\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010]\u001a\u0005\bâ\u0001\u0010^\"\u0005\bã\u0001\u0010`R!\u0010ä\u0001\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bä\u0001\u0010\u0089\u0001\u001a\u0006\bå\u0001\u0010\u008b\u0001R<\u0010ì\u0001\u001a\u000b\u0018\u00010\u0018j\u0005\u0018\u0001`æ\u00012\u0010\u0010ç\u0001\u001a\u000b\u0018\u00010\u0018j\u0005\u0018\u0001`æ\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010ë\u0001R<\u0010ï\u0001\u001a\u000b\u0018\u00010\u0018j\u0005\u0018\u0001`æ\u00012\u0010\u0010ç\u0001\u001a\u000b\u0018\u00010\u0018j\u0005\u0018\u0001`æ\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bí\u0001\u0010é\u0001\"\u0006\bî\u0001\u0010ë\u0001R-\u0010ó\u0001\u001a\u0004\u0018\u00010Y2\t\u0010ç\u0001\u001a\u0004\u0018\u00010Y8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u000b\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R,\u0010ö\u0001\u001a\u0004\u0018\u00010f2\t\u0010ç\u0001\u001a\u0004\u0018\u00010f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bô\u0001\u0010j\"\u0005\bõ\u0001\u0010lR,\u0010ù\u0001\u001a\u0004\u0018\u00010m2\t\u0010ç\u0001\u001a\u0004\u0018\u00010m8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b÷\u0001\u0010q\"\u0005\bø\u0001\u0010sR:\u0010ü\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010(2\u000f\u0010ç\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010(8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bú\u0001\u0010\u009a\u0001\"\u0006\bû\u0001\u0010\u009c\u0001R<\u0010ÿ\u0001\u001a\u000b\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010(2\u0010\u0010ç\u0001\u001a\u000b\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010(8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bý\u0001\u0010\u009a\u0001\"\u0006\bþ\u0001\u0010\u009c\u0001R\u0017\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028F¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0016\u0010\u0084\u0002\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0002\u0010^R\u0016\u0010\u0085\u0002\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0002\u0010^R\u0016\u0010\u0086\u0002\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0002\u0010^R\u001a\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0087\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002R.\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008b\u0002\u0010\u008b\u0001\"\u0006\b\u008c\u0002\u0010\u008d\u0001¨\u0006\u0092\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/n5;", "Lcom/bytedance/android/livesdk/message/model/f;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/message/model/o7;", "Lgm2/h;", "Lcom/bytedance/android/live/base/model/message/u3;", "", "localInsertMsg", "", "setLocalInsertMsg", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "getPublicAreaCommon", "message", "isSame", "canText", "Lcom/bytedance/android/livesdk/message/model/GiftIMPriority;", "getGiftIMPriority", "priority", "setGiftIMPriority", "isLocal", "", "getPriorityInfo", "supportDisplayText", "getOrInitPublicAreaCommon", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInMessage", "toString", "unKnowGift", "setUnKnowGift", "chatFromServer", "trayFromServer", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "b", "setLocal", "", "getToUserIdStrings", "list", "setToUserIdString", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "repeatCount", "getRepeatCount", "setRepeatCount", "fanTicketCount", "getFanTicketCount", "setFanTicketCount", "roomFanTicketCount", "getRoomFanTicketCount", "setRoomFanTicketCount", "", "repeatEnd", "I", "getRepeatEnd", "()I", "setRepeatEnd", "(I)V", "<set-?>", "comboCount", "getComboCount", "setComboCount", "groupCount", "getGroupCount", "setGroupCount", "groupId", "getGroupId", "setGroupId", "Lcom/bytedance/android/livesdk/message/model/TextEffect;", "textEffect", "Lcom/bytedance/android/livesdk/message/model/TextEffect;", "getTextEffect", "()Lcom/bytedance/android/livesdk/message/model/TextEffect;", "setTextEffect", "(Lcom/bytedance/android/livesdk/message/model/TextEffect;)V", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "_publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "isUrgent", "Z", "()Z", "setUrgent", "(Z)V", "Lcom/bytedance/android/livesdk/message/model/GiftIMPriority;", "getPriority", "()Lcom/bytedance/android/livesdk/message/model/GiftIMPriority;", "setPriority", "(Lcom/bytedance/android/livesdk/message/model/GiftIMPriority;)V", "Lcom/bytedance/android/livesdk/gift/model/h1;", "_gift", "Lcom/bytedance/android/livesdk/gift/model/h1;", "get_gift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "set_gift", "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "_trayDisplayText", "Lcom/bytedance/android/live/base/model/message/a5;", "get_trayDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "set_trayDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "bannedDisplayEffects", "getBannedDisplayEffects", "setBannedDisplayEffects", "Lcom/bytedance/android/livesdk/gift/model/c;", "assetEffectMixInfo", "Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/c;", "setAssetEffectMixInfo", "(Lcom/bytedance/android/livesdk/gift/model/c;)V", "Lcom/bytedance/android/livesdk/gift/model/o0;", "trayInfo", "Lcom/bytedance/android/livesdk/gift/model/o0;", "getTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/o0;", "setTrayInfo", "(Lcom/bytedance/android/livesdk/gift/model/o0;)V", "displayForSelf", "getDisplayForSelf", "setDisplayForSelf", "interactGiftInfo", "Ljava/lang/String;", "getInteractGiftInfo", "()Ljava/lang/String;", "setInteractGiftInfo", "(Ljava/lang/String;)V", "diyItemInfoList", "getDiyItemInfoList", "setDiyItemInfoList", "totalCount", "getTotalCount", "setTotalCount", "totalMoney", "getTotalMoney", "setTotalMoney", "minAssetSet", "Ljava/util/List;", "getMinAssetSet", "()Ljava/util/List;", "setMinAssetSet", "(Ljava/util/List;)V", "traceId", "getTraceId", "setTraceId", "clientGiftSource", "getClientGiftSource", "setClientGiftSource", "Lcom/bytedance/android/livesdk/gift/model/a1;", "anchorGift", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "setAnchorGift", "(Lcom/bytedance/android/livesdk/gift/model/a1;)V", "", "toOpenUserIds", "getToOpenUserIds", "setToOpenUserIds", "_toUserIds", "get_toUserIds", "set_toUserIds", "sendGiftTime", "getSendGiftTime", "setSendGiftTime", "forceDisplayEffects", "getForceDisplayEffects", "setForceDisplayEffects", "effectDisplayTs", "getEffectDisplayTs", "setEffectDisplayTs", "Lcom/bytedance/android/livesdk/gift/model/j3;", "sendTogetherInfo", "Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/j3;", "setSendTogetherInfo", "(Lcom/bytedance/android/livesdk/gift/model/j3;)V", "Lcom/bytedance/android/livesdk/gift/model/w;", "extraEffectInfo", "Lcom/bytedance/android/livesdk/gift/model/w;", "getExtraEffectInfo", "()Lcom/bytedance/android/livesdk/gift/model/w;", "setExtraEffectInfo", "(Lcom/bytedance/android/livesdk/gift/model/w;)V", "Lcom/bytedance/android/livesdk/message/model/zj;", "roomHotInfo", "Lcom/bytedance/android/livesdk/message/model/zj;", "getRoomHotInfo", "()Lcom/bytedance/android/livesdk/message/model/zj;", "setRoomHotInfo", "(Lcom/bytedance/android/livesdk/message/model/zj;)V", "multiSendEffectLevel", "getMultiSendEffectLevel", "setMultiSendEffectLevel", "useRoomMessage", "getUseRoomMessage", "setUseRoomMessage", "Lcom/bytedance/android/livesdk/gift/model/n3;", "_seriesGiftData", "get_seriesGiftData", "set_seriesGiftData", "count", "getCount", "setCount", "messageFilterTextBackground", "getMessageFilterTextBackground", "setMessageFilterTextBackground", "isRtcRoomMessage", "setRtcRoomMessage", "rtcRoomMessageIsExpire", "getRtcRoomMessageIsExpire", "setRtcRoomMessageIsExpire", "videoLinkMicRoomId", "getVideoLinkMicRoomId", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "value", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setFromUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "fromUser", "getToUser", "setToUser", "toUser", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "setPublicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;)V", "publicAreaCommon", "getGift", "setGift", PbRequest.SwitchType.GIFT, "getTrayDisplayText", "setTrayDisplayText", "trayDisplayText", "getToUserIds", "setToUserIds", "toUserIds", "getSeriesGiftData", "setSeriesGiftData", "seriesGiftData", "Lcom/bytedance/android/live/base/model/ImageModel;", "getUserLabel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "userLabel", "isBannedInChat", "isBannedInTray", "isBannedInEffect", "Lcom/bytedance/android/livesdk/message/model/m7;", "getGiftPriority", "()Lcom/bytedance/android/livesdk/message/model/m7;", "giftPriority", "getLogId", "setLogId", "logId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n5 extends f implements vh7.c.a<o7>, o7, com.bytedance.android.live.base.model.message.u3, vh7.h {
    public static final int BANNED_IN_CHAT = 1;
    public static final int BANNED_IN_EFFECT = 4;
    public static final int BANNED_IN_TRAY = 2;
    public static final a Companion = null;
    public static final long DISPLAY_EFFECT_EFFECT = 4;
    public static final long DISPLAY_EFFECT_UNUSED = 0;
    private static final String TAG = "GiftMessage";

    @SerializedName(PbRequest.SwitchType.GIFT)
    protected com.bytedance.android.livesdk.gift.model.h1 _gift;

    @SerializedName("public_area_common")
    protected IPublicAreaCommon _publicAreaCommon;

    @SerializedName("series_gift_data")
    protected List<? extends com.bytedance.android.livesdk.gift.model.n3> _seriesGiftData;

    @SerializedName("to_user_ids")
    protected List<Long> _toUserIds;

    @SerializedName("tray_display_text")
    protected com.bytedance.android.live.base.model.message.a5 _trayDisplayText;

    @SerializedName("anchor_gift")
    protected com.bytedance.android.livesdk.gift.model.a1 anchorGift;

    @SerializedName("asset_effect_mix_info")
    protected com.bytedance.android.livesdk.gift.model.c assetEffectMixInfo;

    @SerializedName("banned_display_effects")
    protected long bannedDisplayEffects;

    @IgnoreProtoFieldCheck
    @SerializedName("client_gift_source")
    protected int clientGiftSource;

    @SerializedName("combo_count")
    protected long comboCount;
    private long count;
    private final transient FlexModelDelegate<o7> delegate;

    @SerializedName("display_for_self")
    protected boolean displayForSelf;

    @SerializedName("diy_item_info")
    protected String diyItemInfoList;

    @SerializedName("effect_display_ts")
    protected long effectDisplayTs;

    @SerializedName("extra_effect")
    protected com.bytedance.android.livesdk.gift.model.w extraEffectInfo;

    @SerializedName("fan_ticket_count")
    protected long fanTicketCount;

    @SerializedName("force_display_effects")
    protected long forceDisplayEffects;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long giftId;

    @SerializedName("group_count")
    protected long groupCount;

    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("interact_gift_info")
    protected String interactGiftInfo;

    @IgnoreStyleCheck
    public transient boolean isLocal;
    private boolean isRtcRoomMessage;
    private boolean isUrgent;

    @IgnoreProtoFieldCheck
    private int messageFilterTextBackground;

    @SerializedName("min_asset_set")
    protected List<Long> minAssetSet;

    @SerializedName("multi_send_effect_level")
    protected int multiSendEffectLevel;

    @SerializedName("priority")
    protected GiftIMPriority priority;

    @SerializedName("repeat_count")
    protected long repeatCount;

    @SerializedName("repeat_end")
    protected int repeatEnd;

    @SerializedName("room_fan_ticket_count")
    protected long roomFanTicketCount;

    @SerializedName("room_hot_info")
    protected zj roomHotInfo;
    private boolean rtcRoomMessageIsExpire;

    @SerializedName("send_time")
    protected long sendGiftTime;

    @SerializedName("send_together")
    protected com.bytedance.android.livesdk.gift.model.j3 sendTogetherInfo;

    @SerializedName("text_effect")
    protected TextEffect textEffect;

    @SerializedName("to_openids")
    protected List<String> toOpenUserIds;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    protected long totalCount;
    private long totalMoney;

    @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
    protected String traceId;

    @SerializedName("tray_info")
    protected com.bytedance.android.livesdk.gift.model.o0 trayInfo;
    private boolean unKnowGift;

    @SerializedName("use_room_message")
    protected boolean useRoomMessage;

    @SerializedName("video_linkmic_room_id")
    protected String videoLinkMicRoomId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public String getPriorityInfo() {
        if (this.priority == null) goto L5;
        StringBuilder r100 = new StringBuilder("GiftMessage: priority: ");
        GiftIMPriority r101 = this.priority;
        Intrinsics.checkNotNull(r101);
        r100.append(r101.getPriority());
        r100.append(" queue size: ");
        GiftIMPriority r102 = this.priority;
        Intrinsics.checkNotNull(r102);
        r100.append(r102.getQueueSizes());
        r100.append(" self: ");
        GiftIMPriority r103 = this.priority;
        Intrinsics.checkNotNull(r103);
        r100.append(r103.getSelfQueuePriority());
        return r100.toString();
    L5:
        return "GiftMessage: invalid configure";
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public List<String> getToUserIdStrings() {
        return new ArrayList(this.toOpenUserIds);
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (r100.supportDisplayText() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("GiftMessage{fromUserId=");
        r100.append(getFromUser());
        r100.append(", toUserId=");
        if (getToUser() == null) goto L5;
        Object r101 = getToUser().getIdString();
    L6:
        r100.append(r101);
        r100.append(", giftId=");
        r100.append(getGiftId());
        r100.append(", repeatCount=");
        r100.append(getRepeatCount());
        r100.append(", fanTicketCount=");
        r100.append(getFanTicketCount());
        r100.append(", repeatEnd=");
        r100.append(getRepeatEnd());
        r100.append(", comboCount=");
        r100.append(getComboCount());
        r100.append(", groupCount=");
        r100.append(getGroupCount());
        r100.append(", groupId=");
        r100.append(getGroupId());
        r100.append(", textEffect=");
        r100.append(GsonProtectorUtils.toJson(GsonHelper.get(), getTextEffect()));
        r100.append(", isUrgent=");
        r100.append(isUrgent());
        r100.append(", isLocal=");
        r100.append(this.isLocal);
        r100.append(", bannedDisplayEffects=");
        r100.append(getBannedDisplayEffects());
        r100.append('}');
        return r100.toString();
    L5:
        r101 = 0;
        goto L6
    }

    public n5() {
        this.delegate = new FlexModelDelegate(o7.class, this);
        this.toOpenUserIds = new ArrayList();
        this.type = MessageType.GIFT;
        setUrgent(false);
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean canText() {
        if (getFromUser() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean chatFromServer() {
        if ((getForceDisplayEffects() & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public /* bridge */ /* synthetic */ m7 getGiftIMPriority() {
        return getGiftIMPriority();
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public PublicAreaCommon getOrInitPublicAreaCommon() {
        if (getPublicAreaCommon() != null) goto L5;
        setPublicAreaCommon(new PublicAreaCommon());
    L5:
        IPublicAreaCommon r100 = getPublicAreaCommon();
        if (r100 == null) goto L10;
        return (PublicAreaCommon) r100;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.message.PublicAreaCommon");
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public final PublicAreaCommon getPublicAreaCommon() {
        return (PublicAreaCommon) getPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public /* bridge */ /* synthetic */ zb getTextEffect() {
        return getTextEffect();
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public List<String> getToUserIds() {
        return getToUserIdStrings();
    }

    public final ImageModel getUserLabel() {
        IPublicAreaCommon r100 = getPublicAreaCommon();
        py.k r101 = null;
        if (r100 == null) goto L5;
        py.k r102 = r100.getUserLabel();
    L7:
        if ((r102 instanceof ImageModel) == false) goto L11;
        r101 = r102;
    L11:
        return (ImageModel) r101;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isBannedInChat() {
        if ((getBannedDisplayEffects() & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isBannedInEffect() {
        if ((getBannedDisplayEffects() & ((long) 4)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isBannedInTray() {
        if ((getBannedDisplayEffects() & ((long) 2)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean trayFromServer() {
        if ((getForceDisplayEffects() & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.a1 getAnchorGift() {
        return this.anchorGift;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.c getAssetEffectMixInfo() {
        return this.assetEffectMixInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getBannedDisplayEffects() {
        return this.bannedDisplayEffects;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public int getClientGiftSource() {
        return this.clientGiftSource;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getComboCount() {
        return this.comboCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getCount() {
        return this.count;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<o7> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean getDisplayForSelf() {
        return this.displayForSelf;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public String getDiyItemInfoList() {
        return this.diyItemInfoList;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getEffectDisplayTs() {
        return this.effectDisplayTs;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.w getExtraEffectInfo() {
        return this.extraEffectInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getFanTicketCount() {
        return this.fanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getForceDisplayEffects() {
        return this.forceDisplayEffects;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, com.bytedance.android.livesdk.message.model.k6
    public IBaseUser getFromUser() {
        return this.mFromUser;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.h1 getGift() {
        return this._gift;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getGiftId() {
        return this.giftId;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public m7 getGiftPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getGroupCount() {
        return this.groupCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public String getInteractGiftInfo() {
        return this.interactGiftInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, gm2.d, com.bytedance.android.livesdk.message.model.k6
    public String getLogId() {
        return this.mLogId;
    }

    public final int getMessageFilterTextBackground() {
        return this.messageFilterTextBackground;
    }

    public final List<Long> getMinAssetSet() {
        return this.minAssetSet;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public int getMultiSendEffectLevel() {
        return this.multiSendEffectLevel;
    }

    public final GiftIMPriority getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getRepeatCount() {
        return this.repeatCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public int getRepeatEnd() {
        return this.repeatEnd;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getRoomFanTicketCount() {
        return this.roomFanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public zj getRoomHotInfo() {
        return this.roomHotInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean getRtcRoomMessageIsExpire() {
        return this.rtcRoomMessageIsExpire;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getSendGiftTime() {
        return this.sendGiftTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.j3 getSendTogetherInfo() {
        return this.sendTogetherInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public List<com.bytedance.android.livesdk.gift.model.n3> getSeriesGiftData() {
        return this._seriesGiftData;
    }

    public final List<String> getToOpenUserIds() {
        return this.toOpenUserIds;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, com.bytedance.android.livesdk.message.model.k6
    public IBaseUser getToUser() {
        return this.mToUser;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getTotalCount() {
        return this.totalCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public long getTotalMoney() {
        return this.totalMoney;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.live.base.model.message.a5 getTrayDisplayText() {
        return this._trayDisplayText;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public com.bytedance.android.livesdk.gift.model.o0 getTrayInfo() {
        return this.trayInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean getUseRoomMessage() {
        return this.useRoomMessage;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public IBaseUser getUserInMessage() {
        return this.mFromUser;
    }

    public final String getVideoLinkMicRoomId() {
        return this.videoLinkMicRoomId;
    }

    public final com.bytedance.android.livesdk.gift.model.h1 get_gift() {
        return this._gift;
    }

    public final List<com.bytedance.android.livesdk.gift.model.n3> get_seriesGiftData() {
        return this._seriesGiftData;
    }

    public final List<Long> get_toUserIds() {
        return this._toUserIds;
    }

    public final com.bytedance.android.live.base.model.message.a5 get_trayDisplayText() {
        return this._trayDisplayText;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isLocal() {
        return this.isLocal;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isRtcRoomMessage() {
        return this.isRtcRoomMessage;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public boolean isUrgent() {
        return this.isUrgent;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public GiftIMPriority getGiftIMPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public /* bridge */ /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon() {
        return getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public IPublicAreaCommon getPublicAreaCommon() {
        return this._publicAreaCommon;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public TextEffect getTextEffect() {
        return this.textEffect;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.android.livesdk.gift.model.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.android.livesdk.gift.model.a1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.bytedance.android.livesdk.gift.model.j3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.bytedance.android.livesdk.gift.model.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.bytedance.android.livesdkapi.message.IPublicAreaCommon, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.bytedance.android.livesdk.gift.model.o0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v38, types: [com.bytedance.android.livesdk.gift.model.h1, java.lang.Object] */
    public n5(am3.g r100) {
        this.minAssetSet = new ArrayList();
        this.toOpenUserIds = new ArrayList();
        this._toUserIds = new ArrayList();
        this._seriesGiftData = new ArrayList();
        this.delegate = new FlexModelDelegate(o7.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L57;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        if (r102 != 45) goto L8;
        this.videoLinkMicRoomId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 == 5000) goto L55;
        switch(r102) {
            case 1: goto L54;
            case 2: goto L53;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L48;
            case 8: goto L47;
            case 9: goto L46;
            case 10: goto L45;
            case 11: goto L44;
            default: goto L10;
        };
    L44:
        this.groupId = r100.j();
        goto L3
    L45:
        this.textEffect = new TextEffect(r100);
        goto L3
    L46:
        this.repeatEnd = r100.i();
        goto L3
    L47:
        this.mToUser = new User(r100);
        goto L3
    L48:
        this.mFromUser = new User(r100);
        goto L3
    L49:
        this.comboCount = r100.j();
        goto L3
    L50:
        this.repeatCount = r100.j();
        goto L3
    L51:
        this.groupCount = r100.j();
        goto L3
    L52:
        this.fanTicketCount = r100.j();
        goto L3
    L53:
        this.giftId = r100.j();
        goto L3
    L54:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        switch(r102) {
            case 13: goto L43;
            case 14: goto L42;
            case 15: goto L41;
            case 16: goto L40;
            default: goto L11;
        };
    L40:
        this.mLogId = am3.h.c(r100);
        goto L3
    L41:
        this._gift = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.h1.class);
        goto L3
    L42:
        this.priority = new GiftIMPriority(r100);
        goto L3
    L43:
        this.roomFanTicketCount = r100.j();
        goto L3
    L11:
        switch(r102) {
            case 18: goto L39;
            case 19: goto L38;
            case 20: goto L37;
            case 21: goto L36;
            default: goto L12;
        };
    L36:
        this.trayInfo = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.o0.class);
        goto L3
    L37:
        this.bannedDisplayEffects = r100.j();
        goto L3
    L38:
        this._trayDisplayText = vh7.f.a(r100, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L39:
        this._publicAreaCommon = vh7.f.a(r100, IPublicAreaCommon.class);
        goto L3
    L12:
        switch(r102) {
            case 24: goto L35;
            case 25: goto L34;
            case 26: goto L33;
            case 27: goto L32;
            case 28: goto L29;
            case 29: goto L28;
            case 30: goto L27;
            case 31: goto L26;
            case 32: goto L25;
            case 33: goto L24;
            case 34: goto L23;
            case 35: goto L22;
            case 36: goto L21;
            case 37: goto L20;
            case 38: goto L19;
            case 39: goto L18;
            default: goto L13;
        };
    L18:
        this.roomHotInfo = new zj(r100);
        goto L3
    L19:
        this.extraEffectInfo = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.w.class);
        goto L3
    L20:
        this.sendTogetherInfo = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.j3.class);
        goto L3
    L21:
        this.effectDisplayTs = r100.j();
        goto L3
    L22:
        this.traceId = am3.h.c(r100);
        goto L3
    L23:
        this.forceDisplayEffects = r100.j();
        goto L3
    L24:
        this.sendGiftTime = r100.j();
        goto L3
    L25:
        List r104 = this._toUserIds;
    L30:
        Object r105 = Long.valueOf(r100.j());
    L31:
        r104.add(r105);
        goto L3
    L26:
        this.anchorGift = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.a1.class);
        goto L3
    L27:
        this.clientGiftSource = r100.i();
        goto L3
    L28:
        this.totalCount = r100.j();
        goto L3
    L29:
        r104 = this.minAssetSet;
        goto L30
    L32:
        this.diyItemInfoList = am3.h.c(r100);
        goto L3
    L33:
        this.interactGiftInfo = am3.h.c(r100);
        goto L3
    L34:
        this.displayForSelf = am3.h.a(r100);
        goto L3
    L35:
        this.assetEffectMixInfo = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.c.class);
        goto L3
    L13:
        switch(r102) {
            case 41: goto L17;
            case 42: goto L16;
            case 43: goto L15;
            default: goto L14;
        };
    L15:
        this.useRoomMessage = am3.h.a(r100);
        goto L3
    L16:
        r104 = this._seriesGiftData;
        r105 = vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.n3.class);
        goto L31
    L17:
        this.multiSendEffectLevel = r100.i();
        goto L3
    L14:
        am3.h.d(r103, r100);
        goto L3
    L55:
        r104 = this.toOpenUserIds;
        r105 = am3.h.c(r100);
        goto L31
    L57:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        if (this.toOpenUserIds.isEmpty() == false) goto L60;
        this.toOpenUserIds = new ArrayList();
    L60:
        this.type = MessageType.GIFT;
        setUrgent(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<o7>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<o7>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    public final boolean isSame(n5 r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getFromUser() != null) goto L8;
        return false;
    L8:
        if (getGiftId() != r100.getGiftId()) goto L22;
        IBaseUser r101 = getFromUser();
        if (r101 == null) goto L12;
        String r102 = r101.getIdString();
    L13:
        IBaseUser r103 = r100.getFromUser();
        if (r103 == null) goto L16;
        String r104 = r103.getIdString();
    L18:
        if (StringsKt.equals$default(r102, r104, false, 2, null) == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r104 = null;
        goto L18
    L12:
        r102 = null;
        goto L13
    L22:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setAnchorGift(com.bytedance.android.livesdk.gift.model.a1 r100) {
        this.anchorGift = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setAssetEffectMixInfo(com.bytedance.android.livesdk.gift.model.c r100) {
        this.assetEffectMixInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setBannedDisplayEffects(long r100) {
        this.bannedDisplayEffects = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setClientGiftSource(int r100) {
        this.clientGiftSource = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    @SerializedName("combo_count")
    public void setComboCount(long r100) {
        this.comboCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setCount(long r100) {
        this.count = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setDisplayForSelf(boolean r100) {
        this.displayForSelf = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setDiyItemInfoList(String r100) {
        this.diyItemInfoList = r100;
    }

    public void setEffectDisplayTs(long r100) {
        this.effectDisplayTs = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setExtraEffectInfo(com.bytedance.android.livesdk.gift.model.w r100) {
        this.extraEffectInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setFanTicketCount(long r100) {
        this.fanTicketCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setForceDisplayEffects(long r100) {
        this.forceDisplayEffects = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, com.bytedance.android.livesdk.message.model.k6
    public void setFromUser(IBaseUser r100) {
        if ((r100 instanceof User) == true) goto L5;
        r100 = null;
    L5:
        this.mFromUser = (User) r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setGift(com.bytedance.android.livesdk.gift.model.h1 r100) {
        this._gift = (com.bytedance.android.livesdk.gift.model.h1) com.bytedance.android.live.base.model.m.b(r100, Gift.class);
    }

    @SerializedName("priority")
    public final void setGiftIMPriority(GiftIMPriority r100) {
        this.priority = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setGiftId(long r100) {
        this.giftId = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    @SerializedName("group_count")
    public void setGroupCount(long r100) {
        this.groupCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    @SerializedName("group_id")
    public void setGroupId(long r100) {
        this.groupId = r100;
    }

    public void setInteractGiftInfo(String r100) {
        this.interactGiftInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setLocal(boolean r100) {
        this.isLocal = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.livesdk.message.model.o7
    public void setLocalInsertMsg(boolean r100) {
        this.isLocalInsertMsg2 = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, com.bytedance.android.livesdk.message.model.k6
    public void setLogId(String r100) {
        this.mLogId = r100;
    }

    public final void setMessageFilterTextBackground(int r100) {
        this.messageFilterTextBackground = r100;
    }

    public final void setMinAssetSet(List<Long> r100) {
        this.minAssetSet = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setMultiSendEffectLevel(int r100) {
        this.multiSendEffectLevel = r100;
    }

    public final void setPriority(GiftIMPriority r100) {
        this.priority = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setPublicAreaCommon(IPublicAreaCommon r100) {
        this._publicAreaCommon = (IPublicAreaCommon) com.bytedance.android.live.base.model.m.b(r100, PublicAreaCommon.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setRepeatCount(long r100) {
        this.repeatCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setRepeatEnd(int r100) {
        this.repeatEnd = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setRoomFanTicketCount(long r100) {
        this.roomFanTicketCount = r100;
    }

    public void setRoomHotInfo(zj r100) {
        this.roomHotInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setRtcRoomMessage(boolean r100) {
        this.isRtcRoomMessage = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setRtcRoomMessageIsExpire(boolean r100) {
        this.rtcRoomMessageIsExpire = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setSendGiftTime(long r100) {
        this.sendGiftTime = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setSendTogetherInfo(com.bytedance.android.livesdk.gift.model.j3 r100) {
        this.sendTogetherInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setSeriesGiftData(List<? extends com.bytedance.android.livesdk.gift.model.n3> r100) {
        this._seriesGiftData = KotlinTypeUtilsKt.castElementType(r100);
    }

    public void setTextEffect(TextEffect r100) {
        this.textEffect = r100;
    }

    public final void setToOpenUserIds(List<String> r100) {
        this.toOpenUserIds = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gift.a, com.bytedance.android.livesdk.message.model.k6
    public void setToUser(IBaseUser r100) {
        if ((r100 instanceof User) == true) goto L5;
        r100 = null;
    L5:
        this.mToUser = (User) r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setToUserIdString(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (this._toUserIds != null) goto L5;
        this._toUserIds = new ArrayList();
    L5:
        List<String> r101 = this.toOpenUserIds;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        List<String> r102 = this.toOpenUserIds;
        if (r102 == null) goto L12;
        r102.addAll(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setToUserIds(List<String> r100) {
        setToUserIdString(r100);
    }

    public void setTotalCount(long r100) {
        this.totalCount = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setTotalMoney(long r100) {
        this.totalMoney = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setTraceId(String r100) {
        this.traceId = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setTrayDisplayText(com.bytedance.android.live.base.model.message.a5 r100) {
        this._trayDisplayText = (com.bytedance.android.live.base.model.message.a5) com.bytedance.android.live.base.model.m.b(r100, Text.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setTrayInfo(com.bytedance.android.livesdk.gift.model.o0 r100) {
        this.trayInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setUnKnowGift(boolean r100) {
        this.unKnowGift = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.o7
    public void setUrgent(boolean r100) {
        this.isUrgent = r100;
    }

    public void setUseRoomMessage(boolean r100) {
        this.useRoomMessage = r100;
    }

    public final void set_gift(com.bytedance.android.livesdk.gift.model.h1 r100) {
        this._gift = r100;
    }

    public final void set_seriesGiftData(List<? extends com.bytedance.android.livesdk.gift.model.n3> r100) {
        this._seriesGiftData = r100;
    }

    public final void set_toUserIds(List<Long> r100) {
        this._toUserIds = r100;
    }

    public final void set_trayDisplayText(com.bytedance.android.live.base.model.message.a5 r100) {
        this._trayDisplayText = r100;
    }
}
