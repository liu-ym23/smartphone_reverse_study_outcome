package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bX\n\u0002\u0018\u0002\n\u0002\b!\bg\u0018\u0000 \u008d\u00032\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0006\u008e\u0003\u008f\u0003\u0090\u0003J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H&R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u001c\u0010$\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001c\u0010%\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010.\u001a\u0004\u0018\u00010)8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00103\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00106\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001c\u00107\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\u001c\u0010;\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u001e\u0010@\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010C\u001a\u0004\u0018\u00010\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR\u001c\u0010F\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R\u001c\u0010I\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R\u001c\u0010L\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010\u0018R\u001c\u0010O\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010\u0016\"\u0004\bN\u0010\u0018R\u001c\u0010P\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010(R\u001e\u0010W\u001a\u0004\u0018\u00010R8&@&X¦\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010Z\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\bX\u00100\"\u0004\bY\u00102R\u001c\u0010]\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R\u001c\u0010`\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b^\u00100\"\u0004\b_\u00102R\u001c\u0010c\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0016\"\u0004\bb\u0010\u0018R\u001c\u0010f\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010\u0018R\u001c\u0010i\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\bg\u00100\"\u0004\bh\u00102R\u001e\u0010o\u001a\u0004\u0018\u00010j8&@&X¦\u000e¢\u0006\f\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010u\u001a\u0004\u0018\u00010p8&@&X¦\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010x\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bv\u0010&\"\u0004\bw\u0010(R\u001c\u0010{\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\by\u0010&\"\u0004\bz\u0010(R\u001c\u0010~\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b|\u0010\u0016\"\u0004\b}\u0010\u0018R0\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u00010\u007f8&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0086\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001f\u0010\u008e\u0001\u001a\u00020\u00148&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010\u0016\"\u0005\b\u008d\u0001\u0010\u0018R'\u0010\u0093\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0005\b\u008f\u0001\u00100\"\u0005\b\u0090\u0001\u00102R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0094\u00018&@&X§\u000e¢\u0006\u0018\u0012\u0006\b\u0099\u0001\u0010\u0092\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u009b\u0001\u001a\u00020\u00078&@&X§\u000e¢\u0006\u0016\u0012\u0006\b\u009d\u0001\u0010\u0092\u0001\u001a\u0005\b\u009b\u0001\u0010&\"\u0005\b\u009c\u0001\u0010(R'\u0010¡\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b \u0001\u0010\u0092\u0001\u001a\u0005\b\u009e\u0001\u00100\"\u0005\b\u009f\u0001\u00102R'\u0010¥\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¤\u0001\u0010\u0092\u0001\u001a\u0005\b¢\u0001\u00100\"\u0005\b£\u0001\u00102R)\u0010©\u0001\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¨\u0001\u0010\u0092\u0001\u001a\u0005\b¦\u0001\u0010\r\"\u0005\b§\u0001\u0010\u000fR'\u0010\u00ad\u0001\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¬\u0001\u0010\u0092\u0001\u001a\u0005\bª\u0001\u0010\u0016\"\u0005\b«\u0001\u0010\u0018R'\u0010±\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b°\u0001\u0010\u0092\u0001\u001a\u0005\b®\u0001\u00100\"\u0005\b¯\u0001\u00102R'\u0010²\u0001\u001a\u00020\u00078&@&X§\u000e¢\u0006\u0016\u0012\u0006\b´\u0001\u0010\u0092\u0001\u001a\u0005\b²\u0001\u0010&\"\u0005\b³\u0001\u0010(R'\u0010¸\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b·\u0001\u0010\u0092\u0001\u001a\u0005\bµ\u0001\u00100\"\u0005\b¶\u0001\u00102R'\u0010¼\u0001\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\b»\u0001\u0010\u0092\u0001\u001a\u0005\b¹\u0001\u0010\u0016\"\u0005\bº\u0001\u0010\u0018R\u001f\u0010¿\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b½\u0001\u00100\"\u0005\b¾\u0001\u00102R\u001f\u0010Â\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÀ\u0001\u00100\"\u0005\bÁ\u0001\u00102R\u001f\u0010Ã\u0001\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÃ\u0001\u0010&\"\u0005\bÄ\u0001\u0010(R\u001f\u0010Ç\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÅ\u0001\u00100\"\u0005\bÆ\u0001\u00102R\u001f\u0010Ê\u0001\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÈ\u0001\u0010&\"\u0005\bÉ\u0001\u0010(R\u001f\u0010Ë\u0001\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bË\u0001\u0010&\"\u0005\bÌ\u0001\u0010(R\u001f\u0010Ï\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÍ\u0001\u00100\"\u0005\bÎ\u0001\u00102R!\u0010Ò\u0001\u001a\u0004\u0018\u00010\u001a8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÐ\u0001\u0010\u001c\"\u0005\bÑ\u0001\u0010\u001eR\u001f\u0010Õ\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÓ\u0001\u00100\"\u0005\bÔ\u0001\u00102R+\u0010Ü\u0001\u001a\f\u0012\u0005\u0012\u00030×\u0001\u0018\u00010Ö\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R'\u0010à\u0001\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\bß\u0001\u0010\u0092\u0001\u001a\u0005\bÝ\u0001\u00100\"\u0005\bÞ\u0001\u00102R\u001e\u0010á\u0001\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\bâ\u0001\u0010\u0092\u0001\u001a\u0005\bá\u0001\u0010&R'\u0010æ\u0001\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\bå\u0001\u0010\u0092\u0001\u001a\u0005\bã\u0001\u0010\u0016\"\u0005\bä\u0001\u0010\u0018R)\u0010ê\u0001\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0016\u0012\u0006\bé\u0001\u0010\u0092\u0001\u001a\u0005\bç\u0001\u0010\r\"\u0005\bè\u0001\u0010\u000fR,\u0010ñ\u0001\u001a\u0005\u0018\u00010ë\u00018&@&X§\u000e¢\u0006\u0018\u0012\u0006\bð\u0001\u0010\u0092\u0001\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R\u001e\u0010ô\u0001\u001a\u00020\u00148&X§\u0004¢\u0006\u000f\u0012\u0006\bó\u0001\u0010\u0092\u0001\u001a\u0005\bò\u0001\u0010\u0016R3\u0010ù\u0001\u001a\f\u0012\u0005\u0012\u00030õ\u0001\u0018\u00010Ö\u00018&@&X§\u000e¢\u0006\u0018\u0012\u0006\bø\u0001\u0010\u0092\u0001\u001a\u0006\bö\u0001\u0010Ù\u0001\"\u0006\b÷\u0001\u0010Û\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ú\u00018&@&X§\u000e¢\u0006\u0018\u0012\u0006\bÿ\u0001\u0010\u0092\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R,\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0081\u00028&@&X§\u000e¢\u0006\u0018\u0012\u0006\b\u0086\u0002\u0010\u0092\u0001\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R,\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u0088\u00028&@&X§\u000e¢\u0006\u0018\u0012\u0006\b\u008d\u0002\u0010\u0092\u0001\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R'\u0010\u0092\u0002\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\b\u0091\u0002\u0010\u0092\u0001\u001a\u0005\b\u008f\u0002\u0010\u0016\"\u0005\b\u0090\u0002\u0010\u0018R'\u0010\u0096\u0002\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\b\u0095\u0002\u0010\u0092\u0001\u001a\u0005\b\u0093\u0002\u0010\u0016\"\u0005\b\u0094\u0002\u0010\u0018R,\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u0097\u00028&@&X§\u000e¢\u0006\u0018\u0012\u0006\b\u009c\u0002\u0010\u0092\u0001\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002\"\u0006\b\u009a\u0002\u0010\u009b\u0002R\u001e\u0010\u009e\u0002\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\b\u009f\u0002\u0010\u0092\u0001\u001a\u0005\b\u009e\u0002\u0010&R\u001e\u0010¢\u0002\u001a\u00020\u00048&X§\u0004¢\u0006\u000f\u0012\u0006\b¡\u0002\u0010\u0092\u0001\u001a\u0005\b \u0002\u00100R'\u0010¦\u0002\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¥\u0002\u0010\u0092\u0001\u001a\u0005\b£\u0002\u00100\"\u0005\b¤\u0002\u00102R\u001e\u0010§\u0002\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\b¨\u0002\u0010\u0092\u0001\u001a\u0005\b§\u0002\u0010&R)\u0010¬\u0002\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0016\u0012\u0006\b«\u0002\u0010\u0092\u0001\u001a\u0005\b©\u0002\u0010\r\"\u0005\bª\u0002\u0010\u000fR)\u0010°\u0002\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¯\u0002\u0010\u0092\u0001\u001a\u0005\b\u00ad\u0002\u0010\r\"\u0005\b®\u0002\u0010\u000fR)\u0010´\u0002\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0016\u0012\u0006\b³\u0002\u0010\u0092\u0001\u001a\u0005\b±\u0002\u0010\r\"\u0005\b²\u0002\u0010\u000fR\u0016\u0010¶\u0002\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\bµ\u0002\u00100R'\u0010º\u0002\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0016\u0012\u0006\b¹\u0002\u0010\u0092\u0001\u001a\u0005\b·\u0002\u00100\"\u0005\b¸\u0002\u00102R'\u0010¾\u0002\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\b½\u0002\u0010\u0092\u0001\u001a\u0005\b»\u0002\u0010\u0016\"\u0005\b¼\u0002\u0010\u0018R \u0010Á\u0002\u001a\u0004\u0018\u00010\u001a8&X§\u0004¢\u0006\u000f\u0012\u0006\bÀ\u0002\u0010\u0092\u0001\u001a\u0005\b¿\u0002\u0010\u001cR\u001e\u0010Ä\u0002\u001a\u00020\u00048&X§\u0004¢\u0006\u000f\u0012\u0006\bÃ\u0002\u0010\u0092\u0001\u001a\u0005\bÂ\u0002\u00100R'\u0010È\u0002\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0016\u0012\u0006\bÇ\u0002\u0010\u0092\u0001\u001a\u0005\bÅ\u0002\u0010\u0016\"\u0005\bÆ\u0002\u0010\u0018R\u001e\u0010Ë\u0002\u001a\u00020\u00148&X§\u0004¢\u0006\u000f\u0012\u0006\bÊ\u0002\u0010\u0092\u0001\u001a\u0005\bÉ\u0002\u0010\u0016R\u001e\u0010Î\u0002\u001a\u00020\u00148&X§\u0004¢\u0006\u000f\u0012\u0006\bÍ\u0002\u0010\u0092\u0001\u001a\u0005\bÌ\u0002\u0010\u0016R\u001e\u0010Ñ\u0002\u001a\u00020\u00048&X§\u0004¢\u0006\u000f\u0012\u0006\bÐ\u0002\u0010\u0092\u0001\u001a\u0005\bÏ\u0002\u00100R\u001f\u0010Ô\u0002\u001a\u00020\u00148&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÒ\u0002\u0010\u0016\"\u0005\bÓ\u0002\u0010\u0018R\u001f\u0010×\u0002\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0002\u00100\"\u0005\bÖ\u0002\u00102R\u001f\u0010Ú\u0002\u001a\u00020\u00148&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bØ\u0002\u0010\u0016\"\u0005\bÙ\u0002\u0010\u0018R\u001f\u0010Û\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÛ\u0002\u0010&\"\u0005\bÜ\u0002\u0010(R\u001f\u0010Ý\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÝ\u0002\u0010&\"\u0005\bÞ\u0002\u0010(R\u001f\u0010á\u0002\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bß\u0002\u0010\r\"\u0005\bà\u0002\u0010\u000fR\u001f\u0010â\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bâ\u0002\u0010&\"\u0005\bã\u0002\u0010(R\u001f\u0010ä\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bä\u0002\u0010&\"\u0005\bå\u0002\u0010(R\u001f\u0010è\u0002\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bæ\u0002\u00100\"\u0005\bç\u0002\u00102R\u001f\u0010ë\u0002\u001a\u00020\u00148&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bé\u0002\u0010\u0016\"\u0005\bê\u0002\u0010\u0018R\u001f\u0010ì\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bì\u0002\u0010&\"\u0005\bí\u0002\u0010(R\u001e\u0010î\u0002\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\bï\u0002\u0010\u0092\u0001\u001a\u0005\bî\u0002\u0010&R\"\u0010ô\u0002\u001a\u0005\u0018\u00010ð\u00028&X§\u0004¢\u0006\u0010\u0012\u0006\bó\u0002\u0010\u0092\u0001\u001a\u0006\bñ\u0002\u0010ò\u0002R\u001e\u0010õ\u0002\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\bö\u0002\u0010\u0092\u0001\u001a\u0005\bõ\u0002\u0010&R\u001e\u0010÷\u0002\u001a\u00020\u00078&X§\u0004¢\u0006\u000f\u0012\u0006\bø\u0002\u0010\u0092\u0001\u001a\u0005\b÷\u0002\u0010&R\u001f\u0010ù\u0002\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bù\u0002\u0010&\"\u0005\bú\u0002\u0010(R\u0016\u0010ü\u0002\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\bû\u0002\u00100R\u0016\u0010þ\u0002\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\bý\u0002\u00100R\u001f\u0010\u0081\u0003\u001a\u00020\u00148&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÿ\u0002\u0010\u0016\"\u0005\b\u0080\u0003\u0010\u0018R\u0016\u0010\u0083\u0003\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0003\u00100R\u001f\u0010\u0084\u0003\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0003\u0010&\"\u0005\b\u0085\u0003\u0010(R\u001f\u0010\u0086\u0003\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0003\u0010&\"\u0005\b\u0087\u0003\u0010(R\u001f\u0010\u008a\u0003\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0003\u0010\r\"\u0005\b\u0089\u0003\u0010\u000fR\u001f\u0010\u008b\u0003\u001a\u00020\u00078&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0003\u0010&\"\u0005\b\u008c\u0003\u0010(¨\u0006\u0091\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "Lvh7/c;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "Lcom/bytedance/android/live/liveinteract/plantform/model/m;", "", "getLinkMicPosTagType", "info", "", "isEqual", "", "update", "", "getInteractId", "()Ljava/lang/String;", "setInteractId", "(Ljava/lang/String;)V", "interactId", "getLinkMicUniqueIdStr", "setLinkMicUniqueIdStr", "linkMicUniqueIdStr", "", "getUserPositionFlex", "()I", "setUserPositionFlex", "(I)V", "userPositionFlex", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "getBaseUser", "baseUser", "getFanTicketDisplayStr", "setFanTicketDisplayStr", "fanTicketDisplayStr", "isEnlarged", "()Z", "setEnlarged", "(Z)V", "Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;", "getLinkmic2DAvatar", "()Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;", "setLinkmic2DAvatar", "(Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;)V", "linkmic2DAvatar", "getChorusGuestStatus", "()J", "setChorusGuestStatus", "(J)V", "chorusGuestStatus", "getAiGuestType", "setAiGuestType", "aiGuestType", "isMicHidden", "setMicHidden", "getStats", "setStats", "stats", "getKSongUid", "()Ljava/lang/Long;", "setKSongUid", "(Ljava/lang/Long;)V", "kSongUid", "getActiveName", "setActiveName", "activeName", "getVerifyStatus", "setVerifyStatus", "verifyStatus", "getPositionType", "setPositionType", "positionType", "getRoleType", "setRoleType", "roleType", "getSilenceStatus", "setSilenceStatus", "silenceStatus", "isBackground", "setBackground", "Lcom/bytedance/android/live/liveinteract/plantform/model/o;", "getLinkedListUserInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/o;", "setLinkedListUserInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/o;)V", "linkedListUserInfo", "getFanTicket", "setFanTicket", "fanTicket", "getMediaType", "setMediaType", "mediaType", "getModifyTime", "setModifyTime", "modifyTime", "getApplyType", "setApplyType", "applyType", "getLinkType", "setLinkType", "linkType", "getOriginLinkType", "setOriginLinkType", "originLinkType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "matchEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "cityEffect", "getShowCityEffect", "setShowCityEffect", "showCityEffect", "getMIsJoinUser", "setMIsJoinUser", "mIsJoinUser", "getLinkStatus", "setLinkStatus", "linkStatus", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getOtherRoomInfo", "()Ljava/util/Map$Entry;", "setOtherRoomInfo", "(Ljava/util/Map$Entry;)V", "otherRoomInfo", "Lkd1/b;", "getMicDress", "()Lkd1/b;", "setMicDress", "(Lkd1/b;)V", "micDress", "getClientUIPosition", "setClientUIPosition", "clientUIPosition", "getMcStatus", "setMcStatus", "getMcStatus$annotations", "()V", "mcStatus", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "getMicPosTagInfo$annotations", "micPosTagInfo", "isHost", "setHost", "isHost$annotations", "getAppId", "setAppId", "getAppId$annotations", "appId", "getClientVersion", "setClientVersion", "getClientVersion$annotations", "clientVersion", "getDevicePlatform", "setDevicePlatform", "getDevicePlatform$annotations", "devicePlatform", "getListUserRole", "setListUserRole", "getListUserRole$annotations", "listUserRole", "getPaidCount", "setPaidCount", "getPaidCount$annotations", "paidCount", "isAnonymous", "setAnonymous", "isAnonymous$annotations", "getSelfDisciplineDurationTime", "setSelfDisciplineDurationTime", "getSelfDisciplineDurationTime$annotations", "selfDisciplineDurationTime", "getThemedCompetitionRole", "setThemedCompetitionRole", "getThemedCompetitionRole$annotations", "themedCompetitionRole", "getSelfDisciplineDuration", "setSelfDisciplineDuration", "selfDisciplineDuration", "getSelfDisciplineTargetDuration", "setSelfDisciplineTargetDuration", "selfDisciplineTargetDuration", "isHasApplied", "setHasApplied", "getOrderedSongCount", "setOrderedSongCount", "orderedSongCount", "getAlreadyInvited", "setAlreadyInvited", "alreadyInvited", "isAddPrice", "setAddPrice", "getAddPriceTime", "setAddPriceTime", "addPriceTime", "getInvitor", "setInvitor", "invitor", "getPaidAmount", "setPaidAmount", "paidAmount", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "songList", "getRank", "setRank", "getRank$annotations", "rank", "isIsAnonymous", "isIsAnonymous$annotations", "getApplyTypeNew", "setApplyTypeNew", "getApplyTypeNew$annotations", "applyTypeNew", "getFuzzyFanTicket", "setFuzzyFanTicket", "getFuzzyFanTicket$annotations", "fuzzyFanTicket", "Lcom/bytedance/android/livesdk/message/model/fc;", "getUserHighScoreSongTag", "()Lcom/bytedance/android/livesdk/message/model/fc;", "setUserHighScoreSongTag", "(Lcom/bytedance/android/livesdk/message/model/fc;)V", "getUserHighScoreSongTag$annotations", "userHighScoreSongTag", "getInviteeType", "getInviteeType$annotations", "inviteeType", "Lcom/bytedance/android/live/liveinteract/plantform/model/v;", "getTags", "setTags", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "getEventInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "setEventInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c0;)V", "getEventInfo$annotations", "eventInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "getTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "setTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;)V", "getTag$annotations", "tag", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "setJoinTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/j0;)V", "getJoinTeamFightInfo$annotations", "joinTeamFightInfo", "getListUserType", "setListUserType", "getListUserType$annotations", "listUserType", "getListUserFromType", "setListUserFromType", "getListUserFromType$annotations", "listUserFromType", "Lcom/bytedance/android/live/liveinteract/plantform/model/o0;", "getWaitingListUserInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/o0;", "setWaitingListUserInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/o0;)V", "getWaitingListUserInfo$annotations", "waitingListUserInfo", "isActive", "isActive$annotations", "getLastActiveTimeMillis", "getLastActiveTimeMillis$annotations", "lastActiveTimeMillis", "getLastInvitedTimeMillis", "setLastInvitedTimeMillis", "getLastInvitedTimeMillis$annotations", "lastInvitedTimeMillis", "isIsHost", "isIsHost$annotations", "getMInteractIdStr", "setMInteractIdStr", "getMInteractIdStr$annotations", "mInteractIdStr", "getMLinkMicUniqueIdStr", "setMLinkMicUniqueIdStr", "getMLinkMicUniqueIdStr$annotations", "mLinkMicUniqueIdStr", "getLocation", "setLocation", "getLocation$annotations", "location", "getUserRelationType", "userRelationType", "getLinkDuration", "setLinkDuration", "getLinkDuration$annotations", "linkDuration", "getUserPosition", "setUserPosition", "getUserPosition$annotations", "userPosition", "getMInvitor", "getMInvitor$annotations", "mInvitor", "getMModifyTime", "getMModifyTime$annotations", "mModifyTime", "getMLinkStatus", "setMLinkStatus", "getMLinkStatus$annotations", "mLinkStatus", "getMLinkType", "getMLinkType$annotations", "mLinkType", "getMRoleType", "getMRoleType$annotations", "mRoleType", "getMFanTicket", "getMFanTicket$annotations", "mFanTicket", "getPaidMoney", "setPaidMoney", "paidMoney", "getModifyTimeInNano", "setModifyTimeInNano", "modifyTimeInNano", "getTalkState", "setTalkState", "talkState", "isOpenSendGift", "setOpenSendGift", "isHasInvited", "setHasInvited", "getCornerMarkUrl", "setCornerMarkUrl", "cornerMarkUrl", "isSelfBackground", "setSelfBackground", "isLinkRoomUser", "setLinkRoomUser", "getLinkRoomId", "setLinkRoomId", "linkRoomId", "getRoomLinkSilenceStatus", "setRoomLinkSilenceStatus", "roomLinkSilenceStatus", "isPaidUserLeave", "setPaidUserLeave", "isIsAddPrice", "isIsAddPrice$annotations", "Lcom/bytedance/android/live/liveinteract/plantform/model/i;", "getInviteListUserInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/i;", "getInviteListUserInfo$annotations", "inviteListUserInfo", "isIsEnlarged", "isIsEnlarged$annotations", "isAlreadyInvited", "isAlreadyInvited$annotations", "isSelfPreOn", "setSelfPreOn", "getExpectLeaveTime", "expectLeaveTime", "getJoinChannelTime", "joinChannelTime", "getInteractingState", "setInteractingState", "interactingState", "getPaidLinkCurrentTime", "paidLinkCurrentTime", "isInviting", "setInviting", "isHasExposed", "setHasExposed", "getButtonText", "setButtonText", "buttonText", "isAnchorPlayer", "setAnchorPlayer", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LinkType", "McStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkPlayerInfoBridge extends vh7.c<ILinkPlayerInfoBridge>, com.bytedance.android.live.liveinteract.plantform.base.h, m {
    public static final a Companion = null;
    public static final int DEFAULT_ClIENT_UI_POSITION = Integer.MIN_VALUE;
    public static final int INTERACTING_STATE_OFFLINE = 1;
    public static final int INTERACTING_STATE_ONLINE = 0;
    public static final int INVITEE_TYPE_FANS = 3;
    public static final int INVITEE_TYPE_MUTUAL = 2;
    public static final int INVITEE_TYPE_NONE = 0;
    public static final int INVITEE_TYPE_ROOM_AUDIENCE = 1;
    public static final int KICK_OUT_FROM_GAME = 2;
    public static final int KICK_OUT_FROM_PANEL = 1;
    public static final int LINK_STATUS_FINISHED = 3;
    public static final int LINK_STATUS_LINKED = 2;
    public static final int LINK_STATUS_UNKNOWN = 0;
    public static final int LINK_STATUS_WAITING = 1;
    public static final int LINK_TYPE_AUDIO = 2;
    public static final int LINK_TYPE_DIGIT_AVATAR = 3;
    public static final int LINK_TYPE_UNKNOWN = 0;
    public static final int LINK_TYPE_VIDEO = 1;
    public static final int MC_STATUS_KTV_HOST = 1;
    public static final int MC_STATUS_NOTHING = 0;
    public static final int ROLE_TYPE_LEADER = 1;
    public static final int ROLE_TYPE_PLAYER = 2;
    public static final int ROLE_TYPE_UNKNOWN = 0;
    public static final int SILENCE_BY_ANCHOR = 2;
    public static final int SILENCE_BY_GAME = 4;
    public static final int SILENCE_BY_SELF = 1;
    public static final int SILENCE_PASSIVE = 3;
    public static final int SILENCE_UNKONWN = -1;
    public static final int UNSILENCE = 0;
    public static final int USER_FROM_TYPE_BY_LINKED_USER = 4;
    public static final int USER_FROM_TYPE_KTV_ADD_SONG = 2;
    public static final int USER_FROM_TYPE_NONE = 0;
    public static final int USER_FROM_TYPE_NORMAL = 1;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge$LinkType;", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public @interface LinkType {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge$McStatus;", "", "UNKNOWN", "KTV_HOST", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum McStatus extends Enum<McStatus> {
        public static final McStatus KTV_HOST = null;
        public static final McStatus UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ McStatus[] f77222a = null;

        static {
            McStatus r100 = new McStatus("UNKNOWN", 0);
            UNKNOWN = r100;
            McStatus r101 = new McStatus("KTV_HOST", 1);
            KTV_HOST = r101;
            f77222a = new McStatus[]{r100, r101};
        }

        public static McStatus valueOf(String r100) {
            return (McStatus) r27.a.a(McStatus.class, r100);
        }

        public static McStatus[] values() {
            return (McStatus[]) f77222a.clone();
        }

        public McStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f77223a = null;

        public a() {
        }

        static {
            f77223a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f77223a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getActiveName();

    long getAddPriceTime();

    int getAiGuestType();

    boolean getAlreadyInvited();

    @FieldName(name = "app_id")
    long getAppId();

    int getApplyType();

    @FieldName(name = ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    int getApplyTypeNew();

    IBaseUser getBaseUser();

    String getButtonText();

    long getChorusGuestStatus();

    ICityEffect getCityEffect();

    int getClientUIPosition();

    @FieldName(name = "client_version")
    long getClientVersion();

    String getCornerMarkUrl();

    @FieldName(name = "device_platform")
    String getDevicePlatform();

    @FieldName(name = "event_info")
    c0 getEventInfo();

    long getExpectLeaveTime();

    long getFanTicket();

    String getFanTicketDisplayStr();

    @FieldName(name = "fuzzy_fan_ticket")
    String getFuzzyFanTicket();

    String getInteractId();

    int getInteractingState();

    @FieldName(name = "invite_list_user_info")
    i getInviteListUserInfo();

    @FieldName(name = "invitee_type")
    int getInviteeType();

    IBaseUser getInvitor();

    long getJoinChannelTime();

    @FieldName(name = "join_teamfight_info")
    j0 getJoinTeamFightInfo();

    Long getKSongUid();

    @FieldName(name = "last_active_time_ms")
    long getLastActiveTimeMillis();

    @FieldName(name = "last_invited_time_ms")
    long getLastInvitedTimeMillis();

    @FieldName(name = "link_duration")
    long getLinkDuration();

    long getLinkMicPosTagType();

    String getLinkMicUniqueIdStr();

    long getLinkRoomId();

    int getLinkStatus();

    int getLinkType();

    o getLinkedListUserInfo();

    Linkmic2DAvatar getLinkmic2DAvatar();

    @FieldName(name = "list_user_from_type")
    int getListUserFromType();

    @FieldName(name = "list_user_role")
    int getListUserRole();

    @FieldName(name = "list_user_type")
    int getListUserType();

    @FieldName(name = "location")
    String getLocation();

    @FieldName(name = "fan_ticket")
    long getMFanTicket();

    @FieldName(name = "linkmic_id_str")
    String getMInteractIdStr();

    @FieldName(name = "invitor")
    IBaseUser getMInvitor();

    boolean getMIsJoinUser();

    @FieldName(name = "linkmic_unique_id")
    String getMLinkMicUniqueIdStr();

    @FieldName(name = "link_status")
    int getMLinkStatus();

    @FieldName(name = "link_type")
    int getMLinkType();

    @FieldName(name = "modify_time")
    long getMModifyTime();

    @FieldName(name = "role_type")
    int getMRoleType();

    IMatchEffect getMatchEffect();

    @FieldName(name = "mc_status")
    long getMcStatus();

    int getMediaType();

    kd1.b getMicDress();

    @FieldName(name = "mic_pos_tag_info")
    g0 getMicPosTagInfo();

    long getModifyTime();

    long getModifyTimeInNano();

    long getOrderedSongCount();

    long getOriginLinkType();

    Map.Entry<Long, g2> getOtherRoomInfo();

    long getPaidAmount();

    @FieldName(name = "paid_count")
    long getPaidCount();

    long getPaidLinkCurrentTime();

    int getPaidMoney();

    int getPositionType();

    @FieldName(name = "rank")
    long getRank();

    int getRoleType();

    int getRoomLinkSilenceStatus();

    long getSelfDisciplineDuration();

    @FieldName(name = "self_discipline_duration")
    long getSelfDisciplineDurationTime();

    long getSelfDisciplineTargetDuration();

    boolean getShowCityEffect();

    int getSilenceStatus();

    List<KtvMusic> getSongList();

    int getStats();

    @FieldName(name = "tag")
    ListUserTag getTag();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<v> getTags();

    int getTalkState();

    @FieldName(name = "themed_competition_role")
    int getThemedCompetitionRole();

    IBaseUser getUser();

    @FieldName(name = "high_score_song_tag")
    fc getUserHighScoreSongTag();

    @FieldName(name = "user_position")
    int getUserPosition();

    int getUserPositionFlex();

    long getUserRelationType();

    int getVerifyStatus();

    @FieldName(name = "waiting_list_user_info")
    o0 getWaitingListUserInfo();

    @FieldName(name = "is_active")
    boolean isActive();

    boolean isAddPrice();

    @FieldName(name = "already_invited")
    boolean isAlreadyInvited();

    boolean isAnchorPlayer();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    boolean isAnonymous();

    boolean isBackground();

    boolean isEnlarged();

    boolean isEqual(ILinkPlayerInfoBridge r100);

    boolean isHasApplied();

    boolean isHasExposed();

    boolean isHasInvited();

    @FieldName(name = "host_permission")
    boolean isHost();

    boolean isInviting();

    @FieldName(name = "is_add_price")
    boolean isIsAddPrice();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    boolean isIsAnonymous();

    @FieldName(name = "is_enlarged")
    boolean isIsEnlarged();

    @FieldName(name = "host_permission")
    boolean isIsHost();

    boolean isLinkRoomUser();

    boolean isMicHidden();

    boolean isOpenSendGift();

    boolean isPaidUserLeave();

    boolean isSelfBackground();

    boolean isSelfPreOn();

    void setActiveName(String r100);

    void setAddPrice(boolean r100);

    void setAddPriceTime(long r100);

    void setAiGuestType(int r100);

    void setAlreadyInvited(boolean r100);

    void setAnchorPlayer(boolean r100);

    @FieldName(name = "is_anonymous#setter")
    void setAnonymous(boolean r100);

    @FieldName(name = "app_id#setter")
    void setAppId(long r100);

    void setApplyType(int r100);

    @FieldName(name = "apply_type#setter")
    void setApplyTypeNew(int r100);

    void setBackground(boolean r100);

    void setButtonText(String r100);

    void setChorusGuestStatus(long r100);

    void setCityEffect(ICityEffect r100);

    void setClientUIPosition(int r100);

    @FieldName(name = "client_version#setter")
    void setClientVersion(long r100);

    void setCornerMarkUrl(String r100);

    @FieldName(name = "device_platform#setter")
    void setDevicePlatform(String r100);

    void setEnlarged(boolean r100);

    @FieldName(name = "event_info#setter")
    void setEventInfo(c0 r100);

    void setFanTicket(long r100);

    void setFanTicketDisplayStr(String r100);

    @FieldName(name = "fuzzy_fan_ticket#setter")
    void setFuzzyFanTicket(String r100);

    void setHasApplied(boolean r100);

    void setHasExposed(boolean r100);

    void setHasInvited(boolean r100);

    @FieldName(name = "host_permission#setter")
    void setHost(boolean r100);

    void setInteractId(String r100);

    void setInteractingState(int r100);

    void setInviting(boolean r100);

    void setInvitor(IBaseUser r100);

    @FieldName(name = "join_teamfight_info#setter")
    void setJoinTeamFightInfo(j0 r100);

    void setKSongUid(Long r100);

    @FieldName(name = "last_invited_time_ms#setter")
    void setLastInvitedTimeMillis(long r100);

    @FieldName(name = "link_duration#setter")
    void setLinkDuration(long r100);

    void setLinkMicUniqueIdStr(String r100);

    void setLinkRoomId(long r100);

    void setLinkRoomUser(boolean r100);

    void setLinkStatus(int r100);

    void setLinkType(int r100);

    void setLinkedListUserInfo(o r100);

    void setLinkmic2DAvatar(Linkmic2DAvatar r100);

    @FieldName(name = "list_user_from_type#setter")
    void setListUserFromType(int r100);

    @FieldName(name = "list_user_role#setter")
    void setListUserRole(int r100);

    @FieldName(name = "list_user_type#setter")
    void setListUserType(int r100);

    @FieldName(name = "location#setter")
    void setLocation(String r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setMInteractIdStr(String r100);

    void setMIsJoinUser(boolean r100);

    @FieldName(name = "linkmic_unique_id#setter")
    void setMLinkMicUniqueIdStr(String r100);

    @FieldName(name = "link_status#setter")
    void setMLinkStatus(int r100);

    void setMatchEffect(IMatchEffect r100);

    @FieldName(name = "mc_status#setter")
    void setMcStatus(long r100);

    void setMediaType(int r100);

    void setMicDress(kd1.b r100);

    void setMicHidden(boolean r100);

    @FieldName(name = "mic_pos_tag_info#setter")
    void setMicPosTagInfo(g0 r100);

    void setModifyTime(long r100);

    void setModifyTimeInNano(long r100);

    void setOpenSendGift(boolean r100);

    void setOrderedSongCount(long r100);

    void setOriginLinkType(long r100);

    void setOtherRoomInfo(Map.Entry<Long, ? extends g2> r100);

    void setPaidAmount(long r100);

    @FieldName(name = "paid_count#setter")
    void setPaidCount(long r100);

    void setPaidMoney(int r100);

    void setPaidUserLeave(boolean r100);

    void setPositionType(int r100);

    @FieldName(name = "rank#setter")
    void setRank(long r100);

    void setRoleType(int r100);

    void setRoomLinkSilenceStatus(int r100);

    void setSelfBackground(boolean r100);

    void setSelfDisciplineDuration(long r100);

    @FieldName(name = "self_discipline_duration#setter")
    void setSelfDisciplineDurationTime(long r100);

    void setSelfDisciplineTargetDuration(long r100);

    void setSelfPreOn(boolean r100);

    void setShowCityEffect(boolean r100);

    void setSilenceStatus(int r100);

    void setSongList(List<KtvMusic> r100);

    void setStats(int r100);

    @FieldName(name = "tag#setter")
    void setTag(ListUserTag r100);

    @FieldName(name = "tags#setter")
    void setTags(List<? extends v> r100);

    void setTalkState(int r100);

    @FieldName(name = "themed_competition_role#setter")
    void setThemedCompetitionRole(int r100);

    void setUser(IBaseUser r100);

    @FieldName(name = "high_score_song_tag#setter")
    void setUserHighScoreSongTag(fc r100);

    @FieldName(name = "user_position#setter")
    void setUserPosition(int r100);

    void setUserPositionFlex(int r100);

    void setVerifyStatus(int r100);

    @FieldName(name = "waiting_list_user_info#setter")
    void setWaitingListUserInfo(o0 r100);

    void update(ILinkPlayerInfoBridge r100);
}
