package com.bytedance.android.livesdkapi.depend.model.live;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.IStartLiveInterceptor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomType;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.io.Serializable;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 ã\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006:\u0002ã\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010!\u001a\u00060\u001cj\u0002`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\r\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\r\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\r\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R6\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c02j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c`38&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\r\u001a\u0004\b4\u00105R\"\u0010<\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\r\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010:R\u001c\u0010A\u001a\u0004\u0018\u00010=8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\r\u001a\u0004\b>\u0010?R\u001e\u0010D\u001a\u00060\u001cj\u0002`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\r\u001a\u0004\bB\u0010\u001fR$\u0010K\u001a\u0004\u0018\u00010E8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\r\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010R\u001a\u00020L8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bQ\u0010\r\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010S8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\r\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010]\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\\\u0010\r\u001a\u0004\bZ\u0010\u001f\"\u0004\b[\u0010:R$\u0010a\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\r\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000bR\u001c\u0010f\u001a\u0004\u0018\u00010b8&X§\u0004¢\u0006\f\u0012\u0004\be\u0010\r\u001a\u0004\bc\u0010dR$\u0010m\u001a\u0004\u0018\u00010g8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bl\u0010\r\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010n\u001a\u00020+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bp\u0010\r\u001a\u0004\bn\u0010-\"\u0004\bo\u0010/R\u001e\u0010s\u001a\u00060\u001cj\u0002`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\br\u0010\r\u001a\u0004\bq\u0010\u001fR\"\u0010w\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bv\u0010\r\u001a\u0004\bt\u0010\u001f\"\u0004\bu\u0010:R$\u0010~\u001a\u0004\u0018\u00010x8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b}\u0010\r\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R \u0010\u0083\u0001\u001a\u0004\u0018\u00010\u007f8&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0082\u0001\u0010\r\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R&\u0010\u0087\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0086\u0001\u0010\r\u001a\u0005\b\u0084\u0001\u0010\u001f\"\u0005\b\u0085\u0001\u0010:R\u001d\u0010\u0088\u0001\u001a\u00020+8&X§\u0004¢\u0006\u000e\u0012\u0005\b\u0089\u0001\u0010\r\u001a\u0005\b\u0088\u0001\u0010-R&\u0010\u008a\u0001\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u008c\u0001\u0010\r\u001a\u0005\b\u008a\u0001\u0010-\"\u0005\b\u008b\u0001\u0010/R&\u0010\u0090\u0001\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u008f\u0001\u0010\r\u001a\u0005\b\u008d\u0001\u0010-\"\u0005\b\u008e\u0001\u0010/R&\u0010\u0094\u0001\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0093\u0001\u0010\r\u001a\u0005\b\u0091\u0001\u0010-\"\u0005\b\u0092\u0001\u0010/R(\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0097\u0001\u0010\r\u001a\u0005\b\u0095\u0001\u0010\t\"\u0005\b\u0096\u0001\u0010\u000bR(\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u009b\u0001\u0010\r\u001a\u0005\b\u0099\u0001\u0010\t\"\u0005\b\u009a\u0001\u0010\u000bR\u001d\u0010\u009f\u0001\u001a\u00020\u001c8&X§\u0004¢\u0006\u000e\u0012\u0005\b\u009e\u0001\u0010\r\u001a\u0005\b\u009d\u0001\u0010\u001fR(\u0010£\u0001\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¢\u0001\u0010\r\u001a\u0005\b \u0001\u0010\t\"\u0005\b¡\u0001\u0010\u000bR+\u0010ª\u0001\u001a\u0005\u0018\u00010¤\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b©\u0001\u0010\r\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R(\u0010®\u0001\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u00ad\u0001\u0010\r\u001a\u0005\b«\u0001\u0010\t\"\u0005\b¬\u0001\u0010\u000bR(\u0010²\u0001\u001a\u0004\u0018\u00010S8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b±\u0001\u0010\r\u001a\u0005\b¯\u0001\u0010U\"\u0005\b°\u0001\u0010WR(\u0010¶\u0001\u001a\u0004\u0018\u00010S8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bµ\u0001\u0010\r\u001a\u0005\b³\u0001\u0010U\"\u0005\b´\u0001\u0010WR&\u0010º\u0001\u001a\u00020\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¹\u0001\u0010\r\u001a\u0005\b·\u0001\u0010\t\"\u0005\b¸\u0001\u0010\u000bR&\u0010¾\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b½\u0001\u0010\r\u001a\u0005\b»\u0001\u0010\u001f\"\u0005\b¼\u0001\u0010:R&\u0010Â\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÁ\u0001\u0010\r\u001a\u0005\b¿\u0001\u0010\u001f\"\u0005\bÀ\u0001\u0010:R&\u0010Æ\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÅ\u0001\u0010\r\u001a\u0005\bÃ\u0001\u0010\u001f\"\u0005\bÄ\u0001\u0010:R!\u0010Ë\u0001\u001a\u0005\u0018\u00010Ç\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bÊ\u0001\u0010\r\u001a\u0006\bÈ\u0001\u0010É\u0001R&\u0010Ï\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÎ\u0001\u0010\r\u001a\u0005\bÌ\u0001\u0010\u001f\"\u0005\bÍ\u0001\u0010:R&\u0010Ó\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÒ\u0001\u0010\r\u001a\u0005\bÐ\u0001\u0010\u001f\"\u0005\bÑ\u0001\u0010:R!\u0010Ø\u0001\u001a\u0005\u0018\u00010Ô\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b×\u0001\u0010\r\u001a\u0006\bÕ\u0001\u0010Ö\u0001R!\u0010Û\u0001\u001a\u0005\u0018\u00010Ô\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bÚ\u0001\u0010\r\u001a\u0006\bÙ\u0001\u0010Ö\u0001R!\u0010à\u0001\u001a\u0005\u0018\u00010Ü\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bß\u0001\u0010\r\u001a\u0006\bÝ\u0001\u0010Þ\u0001R+\u0010ç\u0001\u001a\u0005\u0018\u00010á\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bæ\u0001\u0010\r\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R+\u0010î\u0001\u001a\u0005\u0018\u00010è\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bí\u0001\u0010\r\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R&\u0010ò\u0001\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bñ\u0001\u0010\r\u001a\u0005\bï\u0001\u0010-\"\u0005\bð\u0001\u0010/R&\u0010ö\u0001\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bõ\u0001\u0010\r\u001a\u0005\bó\u0001\u0010-\"\u0005\bô\u0001\u0010/R&\u0010ú\u0001\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bù\u0001\u0010\r\u001a\u0005\b÷\u0001\u0010\u001f\"\u0005\bø\u0001\u0010:R(\u0010þ\u0001\u001a\u0004\u0018\u00010S8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bý\u0001\u0010\r\u001a\u0005\bû\u0001\u0010U\"\u0005\bü\u0001\u0010WR(\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0081\u0002\u0010\r\u001a\u0005\bÿ\u0001\u0010\t\"\u0005\b\u0080\u0002\u0010\u000bR&\u0010\u0086\u0002\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0085\u0002\u0010\r\u001a\u0005\b\u0083\u0002\u0010\u001f\"\u0005\b\u0084\u0002\u0010:R+\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u0087\u00028&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u008c\u0002\u0010\r\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R+\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u008e\u00028&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0093\u0002\u0010\r\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R+\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0095\u00028&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u009a\u0002\u0010\r\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002\"\u0006\b\u0098\u0002\u0010\u0099\u0002R&\u0010\u009f\u0002\u001a\u00020L8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u009e\u0002\u0010\r\u001a\u0005\b\u009c\u0002\u0010N\"\u0005\b\u009d\u0002\u0010PR!\u0010¤\u0002\u001a\u0005\u0018\u00010 \u00028&X§\u0004¢\u0006\u000f\u0012\u0005\b£\u0002\u0010\r\u001a\u0006\b¡\u0002\u0010¢\u0002R!\u0010©\u0002\u001a\u0005\u0018\u00010¥\u00028&X§\u0004¢\u0006\u000f\u0012\u0005\b¨\u0002\u0010\r\u001a\u0006\b¦\u0002\u0010§\u0002R+\u0010°\u0002\u001a\u0005\u0018\u00010ª\u00028&@&X§\u000e¢\u0006\u0017\u0012\u0005\b¯\u0002\u0010\r\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R(\u0010´\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b³\u0002\u0010\r\u001a\u0005\b±\u0002\u0010\t\"\u0005\b²\u0002\u0010\u000bR\u001d\u0010µ\u0002\u001a\u00020+8&X§\u0004¢\u0006\u000e\u0012\u0005\b¶\u0002\u0010\r\u001a\u0005\bµ\u0002\u0010-R(\u0010º\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¹\u0002\u0010\r\u001a\u0005\b·\u0002\u0010\t\"\u0005\b¸\u0002\u0010\u000bR&\u0010»\u0002\u001a\u00020+8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b½\u0002\u0010\r\u001a\u0005\b»\u0002\u0010-\"\u0005\b¼\u0002\u0010/R(\u0010Á\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÀ\u0002\u0010\r\u001a\u0005\b¾\u0002\u0010\t\"\u0005\b¿\u0002\u0010\u000bR&\u0010Å\u0002\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÄ\u0002\u0010\r\u001a\u0005\bÂ\u0002\u0010\u001f\"\u0005\bÃ\u0002\u0010:R(\u0010É\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÈ\u0002\u0010\r\u001a\u0005\bÆ\u0002\u0010\t\"\u0005\bÇ\u0002\u0010\u000bR(\u0010Í\u0002\u001a\u0004\u0018\u00010\u00078&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÌ\u0002\u0010\r\u001a\u0005\bÊ\u0002\u0010\t\"\u0005\bË\u0002\u0010\u000bR&\u0010Ñ\u0002\u001a\u00020L8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÐ\u0002\u0010\r\u001a\u0005\bÎ\u0002\u0010N\"\u0005\bÏ\u0002\u0010PR&\u0010Õ\u0002\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÔ\u0002\u0010\r\u001a\u0005\bÒ\u0002\u0010\u001f\"\u0005\bÓ\u0002\u0010:R&\u0010Ù\u0002\u001a\u00020\u001c8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bØ\u0002\u0010\r\u001a\u0005\bÖ\u0002\u0010\u001f\"\u0005\b×\u0002\u0010:R+\u0010à\u0002\u001a\u0005\u0018\u00010Ú\u00028&@&X§\u000e¢\u0006\u0017\u0012\u0005\bß\u0002\u0010\r\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R\u001d\u0010á\u0002\u001a\u00020+8&X§\u0004¢\u0006\u000e\u0012\u0005\bâ\u0002\u0010\r\u001a\u0005\bá\u0002\u0010-¨\u0006ä\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomType;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/utils/Serializable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomEx;", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "()V", "title", "getShortTitle", "setShortTitle", "getShortTitle$annotations", "shortTitle", "getIntroduction", "setIntroduction", "getIntroduction$annotations", "introduction", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "getEpisodeExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "getEpisodeExtra$annotations", "episodeExtra", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getRoomLayout", "()J", "getRoomLayout$annotations", "roomLayout", "getIdStr", "setIdStr", "getIdStr$annotations", "idStr", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl$annotations", "streamUrl", "", "getWithLinkMic", "()Z", "setWithLinkMic", "(Z)V", "getWithLinkMic$annotations", "withLinkMic", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkMap", "()Ljava/util/Map;", "getLinkMap$annotations", "linkMap", "getUserCount", "setUserCount", "(J)V", "getUserCount$annotations", "userCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getMRoomAuthStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getMRoomAuthStatus$annotations", "mRoomAuthStatus", "getLiveRoomMode", "getLiveRoomMode$annotations", "liveRoomMode", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "getStats", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "setStats", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;)V", "getStats$annotations", "stats", "", "getBusinessLive", "()I", "setBusinessLive", "(I)V", "getBusinessLive$annotations", "businessLive", "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "getCover$annotations", "cover", "getHasGamePromote", "setHasGamePromote", "getHasGamePromote$annotations", "hasGamePromote", "getShareUrl", "setShareUrl", "getShareUrl$annotations", "shareUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData;", "getPaidLiveData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData;", "getPaidLiveData$annotations", "paidLiveData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;", "getRoomCart", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;", "setRoomCart", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;)V", "getRoomCart$annotations", "roomCart", "isHasCommerceGoods", "setHasCommerceGoods", "isHasCommerceGoods$annotations", "getLayout", "getLayout$annotations", "layout", "getAutoCover", "setAutoCover", "getAutoCover$annotations", "autoCover", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "getRoomIMInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "setRoomIMInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;)V", "getRoomIMInfo$annotations", "roomIMInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "getToolbarData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "getToolbarData$annotations", "toolbarData", "getStreamId", "setStreamId", "getStreamId$annotations", "streamId", "isThirdParty", "isThirdParty$annotations", "isOfficialType", "setOfficialType", "isOfficialType$annotations", "getLiveTypeVsLive", "setLiveTypeVsLive", "getLiveTypeVsLive$annotations", "liveTypeVsLive", "getLiveTypeVsPremiere", "setLiveTypeVsPremiere", "getLiveTypeVsPremiere$annotations", "liveTypeVsPremiere", "getVideoFeedTag", "setVideoFeedTag", "getVideoFeedTag$annotations", "videoFeedTag", "getItemExplicitInfo", "setItemExplicitInfo", "getItemExplicitInfo$annotations", "itemExplicitInfo", "getPlatform", "getPlatform$annotations", "platform", "getPrivateInfo", "setPrivateInfo", "getPrivateInfo$annotations", "privateInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "getTvInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "setTvInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;)V", "getTvInfo$annotations", "tvInfo", "getLiveHashTagJson", "setLiveHashTagJson", "getLiveHashTagJson$annotations", "liveHashTagJson", "getContentLabel", "setContentLabel", "getContentLabel$annotations", "contentLabel", "getOperationLabel", "setOperationLabel", "getOperationLabel$annotations", "operationLabel", "getContentTag", "setContentTag", "getContentTag$annotations", "contentTag", "getLinkMicLayout", "setLinkMicLayout", "getLinkMicLayout$annotations", "linkMicLayout", "getPreEnterTime", "setPreEnterTime", "getPreEnterTime$annotations", "preEnterTime", "getRedEnvelopeNumber", "setRedEnvelopeNumber", "getRedEnvelopeNumber$annotations", "redEnvelopeNumber", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerUsers;", "getLinkerUsers", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerUsers;", "getLinkerUsers$annotations", "linkerUsers", "getLinkmicDisplayType", "setLinkmicDisplayType", "getLinkmicDisplayType$annotations", "linkmicDisplayType", "getAcquaintanceStatus", "setAcquaintanceStatus", "getAcquaintanceStatus$annotations", "acquaintanceStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "getAssistLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "getAssistLabel$annotations", "assistLabel", "getDynamicLabel", "getDynamicLabel$annotations", "dynamicLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExposeData;", "getExposeData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExposeData;", "getExposeData$annotations", "exposeData", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;", "getLiveStatusInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;", "setLiveStatusInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;)V", "getLiveStatusInfo$annotations", "liveStatusInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "getGameCPData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "setGameCPData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;)V", "getGameCPData$annotations", "gameCPData", "getLiveTypeSandbox", "setLiveTypeSandbox", "getLiveTypeSandbox$annotations", "liveTypeSandbox", "getReplay", "setReplay", "getReplay$annotations", "replay", "getStatus", "setStatus", "getStatus$annotations", "status", "getBackground", "setBackground", "getBackground$annotations", "background", "getVid", "setVid", "getVid$annotations", "vid", "getStreamCloseTime", "setStreamCloseTime", "getStreamCloseTime$annotations", "streamCloseTime", "Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;", "getReplayInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;", "setReplayInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;)V", "getReplayInfo$annotations", "replayInfo", "Lcom/bytedance/android/livesdk/link/model/z5;", "getLinkerDetail", "()Lcom/bytedance/android/livesdk/link/model/z5;", "setLinkerDetail", "(Lcom/bytedance/android/livesdk/link/model/z5;)V", "getLinkerDetail$annotations", "linkerDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "getCircleInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "setCircleInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;)V", "getCircleInfo$annotations", "circleInfo", "getVisibilityRange", "setVisibilityRange", "getVisibilityRange$annotations", "visibilityRange", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "getAnchorData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "getAnchorData$annotations", "anchorData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "getSceneTypeInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "getSceneTypeInfo$annotations", "sceneTypeInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getVoiceLiveTheme", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setVoiceLiveTheme", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "getVoiceLiveTheme$annotations", "voiceLiveTheme", "getLiveRoomStampsJson", "setLiveRoomStampsJson", "getLiveRoomStampsJson$annotations", "liveRoomStampsJson", "isScreenshot", "isScreenshot$annotations", "getLabels", "setLabels", "getLabels$annotations", "labels", "isOfficialChannelRoom", "setOfficialChannelRoom", "isOfficialChannelRoom$annotations", "getLivePlatformSource", "setLivePlatformSource", "getLivePlatformSource$annotations", "livePlatformSource", "getCreateTime", "setCreateTime", "getCreateTime$annotations", "createTime", "getDistanceCity", "setDistanceCity", "getDistanceCity$annotations", "distanceCity", "getDistanceKm", "setDistanceKm", "getDistanceKm$annotations", "distanceKm", "getAnchorTabType", "setAnchorTabType", "getAnchorTabType$annotations", "anchorTabType", "getDiggCount", "setDiggCount", "getDiggCount$annotations", "diggCount", "getFinishTime", "setFinishTime", "getFinishTime$annotations", "finishTime", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "getBasisRoomData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "setBasisRoomData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;)V", "getBasisRoomData$annotations", "basisRoomData", "isLiveTypeAudio", "isLiveTypeAudio$annotations", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoom extends IRoomType, c<IRoom>, IRoomBase, Serializable, IRoomEx {
    public static final long ACQUAINTANCE_STATUS_FRIENDS = 1;
    public static final long ACQUAINTANCE_STATUS_PRIVATE = 2;
    public static final int COMMENT_STYLE_DANMAKU = 2;
    public static final int COMMENT_STYLE_NONE = 0;
    public static final int COMMENT_STYLE_PUBLIC_SCREEN = 1;
    public static final Companion Companion = null;
    public static final long LIVE_MODE_ACQUAINTANCE = 5;
    public static final long LIVE_MODE_NORMAL = 0;
    public static final long LIVE_MODE_RECORD = 4;
    public static final long LIVE_MODE_VIDEO_TALK = 16;
    public static final long LIVE_MODE_VS_FIRST_SHOW = 7;
    public static final long LIVE_MODE_VS_LIVE = 6;
    public static final int ONLY_VIP_CAN = 5;
    public static final int ROOM_ACTIVITY_TYPE_PIX = 1;
    public static final int ROOM_FINISH = 4;
    public static final int ROOM_FINISH_REASON_CLOSE_NITIFICATION = 9;
    public static final int ROOM_FINISH_REASON_FORCE_FINISH_OF_ILLEGAL = 8;
    public static final int ROOM_FINISH_REASON_NORMAL = 1;
    public static final int ROOM_FINISH_REASON_PAUSE_OVER = 7;
    public static final int ROOM_FINISH_REASON_PROJECTION_DENY = 8;
    public static final int ROOM_FINISH_REASON_STREAM_PUSH_FAILED = 6;
    public static final long ROOM_LAYOUT_MEDIA = 1;
    public static final int ROOM_LAYOUT_MIRROR = 999;
    public static final int ROOM_MSG_FOLD_TYPE_AUDIENCE = 2;
    public static final int ROOM_MSG_FOLD_TYPE_AUDIENCE_HIDE = 3;
    public static final int ROOM_MSG_FOLD_TYPE_DEFAULT = 0;
    public static final int ROOM_MSG_INTERCEPTOR_TYPE = 1;
    public static final int ROOM_PAUSE = 3;
    public static final int ROOM_PLAYING = 2;
    public static final int ROOM_PREPARE = 1;
    public static final long ROOM_TYPE_D3_ACTIVITY = 4;
    public static final long ROOM_TYPE_KOI_ACTIVITY = 3;
    public static final long ROOM_TYPE_NORMAL = 0;

    @Deprecated(message = "")
    public static final long ROOM_TYPE_OFFICIAL_ACTIVITY = 1;
    public static final long ROOM_TYPE_STAR_ACTIVITY = 2;
    public static final long USER_FROM_FOLLOW = 2;
    public static final long USER_FROM_LIVE_FEED_FOLLOW = 2001;
    public static final long USER_FROM_PROFILE = 3;
    public static final long USER_FROM_PUSH = 4;
    public static final long USER_FROM_RECOMMEND = 1;
    public static final long USER_FROM_TIMELINE = 0;
    public static final long USER_FROM_WEB = 5;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom$Companion;", "", "()V", "ACQUAINTANCE_STATUS_FRIENDS", "", "ACQUAINTANCE_STATUS_PRIVATE", "COMMENT_STYLE_DANMAKU", "", "COMMENT_STYLE_NONE", "COMMENT_STYLE_PUBLIC_SCREEN", "LIVE_MODE_ACQUAINTANCE", "LIVE_MODE_NORMAL", "LIVE_MODE_RECORD", "LIVE_MODE_VIDEO_TALK", "LIVE_MODE_VS_FIRST_SHOW", "LIVE_MODE_VS_LIVE", "ONLY_VIP_CAN", "ROOM_ACTIVITY_TYPE_PIX", "ROOM_FINISH", "ROOM_FINISH_REASON_CLOSE_NITIFICATION", "ROOM_FINISH_REASON_FORCE_FINISH_OF_ILLEGAL", "ROOM_FINISH_REASON_NORMAL", "ROOM_FINISH_REASON_PAUSE_OVER", "ROOM_FINISH_REASON_PROJECTION_DENY", "ROOM_FINISH_REASON_STREAM_PUSH_FAILED", "ROOM_LAYOUT_MEDIA", "ROOM_LAYOUT_MIRROR", "ROOM_MSG_FOLD_TYPE_AUDIENCE", "ROOM_MSG_FOLD_TYPE_AUDIENCE_HIDE", "ROOM_MSG_FOLD_TYPE_DEFAULT", "ROOM_MSG_INTERCEPTOR_TYPE", "ROOM_PAUSE", "ROOM_PLAYING", "ROOM_PREPARE", "ROOM_TYPE_D3_ACTIVITY", "ROOM_TYPE_KOI_ACTIVITY", "ROOM_TYPE_NORMAL", "ROOM_TYPE_OFFICIAL_ACTIVITY", "getROOM_TYPE_OFFICIAL_ACTIVITY$annotations", "ROOM_TYPE_STAR_ACTIVITY", "USER_FROM_FOLLOW", "USER_FROM_LIVE_FEED_FOLLOW", "USER_FROM_PROFILE", "USER_FROM_PUSH", "USER_FROM_RECOMMEND", "USER_FROM_TIMELINE", "USER_FROM_WEB", "isValid", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long ACQUAINTANCE_STATUS_FRIENDS = 1;
        public static final long ACQUAINTANCE_STATUS_PRIVATE = 2;
        public static final int COMMENT_STYLE_DANMAKU = 2;
        public static final int COMMENT_STYLE_NONE = 0;
        public static final int COMMENT_STYLE_PUBLIC_SCREEN = 1;
        public static final long LIVE_MODE_ACQUAINTANCE = 5;
        public static final long LIVE_MODE_NORMAL = 0;
        public static final long LIVE_MODE_RECORD = 4;
        public static final long LIVE_MODE_VIDEO_TALK = 16;
        public static final long LIVE_MODE_VS_FIRST_SHOW = 7;
        public static final long LIVE_MODE_VS_LIVE = 6;
        public static final int ONLY_VIP_CAN = 5;
        public static final int ROOM_ACTIVITY_TYPE_PIX = 1;
        public static final int ROOM_FINISH = 4;
        public static final int ROOM_FINISH_REASON_CLOSE_NITIFICATION = 9;
        public static final int ROOM_FINISH_REASON_FORCE_FINISH_OF_ILLEGAL = 8;
        public static final int ROOM_FINISH_REASON_NORMAL = 1;
        public static final int ROOM_FINISH_REASON_PAUSE_OVER = 7;
        public static final int ROOM_FINISH_REASON_PROJECTION_DENY = 8;
        public static final int ROOM_FINISH_REASON_STREAM_PUSH_FAILED = 6;
        public static final long ROOM_LAYOUT_MEDIA = 1;
        public static final int ROOM_LAYOUT_MIRROR = 999;
        public static final int ROOM_MSG_FOLD_TYPE_AUDIENCE = 2;
        public static final int ROOM_MSG_FOLD_TYPE_AUDIENCE_HIDE = 3;
        public static final int ROOM_MSG_FOLD_TYPE_DEFAULT = 0;
        public static final int ROOM_MSG_INTERCEPTOR_TYPE = 1;
        public static final int ROOM_PAUSE = 3;
        public static final int ROOM_PLAYING = 2;
        public static final int ROOM_PREPARE = 1;
        public static final long ROOM_TYPE_D3_ACTIVITY = 4;
        public static final long ROOM_TYPE_KOI_ACTIVITY = 3;
        public static final long ROOM_TYPE_NORMAL = 0;
        public static final long ROOM_TYPE_OFFICIAL_ACTIVITY = 1;
        public static final long ROOM_TYPE_STAR_ACTIVITY = 2;
        public static final long USER_FROM_FOLLOW = 2;
        public static final long USER_FROM_LIVE_FEED_FOLLOW = 2001;
        public static final long USER_FROM_PROFILE = 3;
        public static final long USER_FROM_PUSH = 4;
        public static final long USER_FROM_RECOMMEND = 1;
        public static final long USER_FROM_TIMELINE = 0;
        public static final long USER_FROM_WEB = 5;

        private Companion() {
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getROOM_TYPE_OFFICIAL_ACTIVITY$annotations() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        public final boolean isValid(IRoom r100) {
            if (r100 != null) goto L4;
        L8:
            return false;
        L4:
            if (r100.getRoomId() <= 0) goto L8;
            if (r100.getOwner() == null) goto L8;
            return true;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "acquaintance_status")
        public static /* synthetic */ void getAcquaintanceStatus$annotations() {
        }

        @FieldName(name = "anchor_data")
        public static /* synthetic */ void getAnchorData$annotations() {
        }

        @FieldName(name = "anchor_tab_type")
        public static /* synthetic */ void getAnchorTabType$annotations() {
        }

        @FieldName(name = "assist_label")
        public static /* synthetic */ void getAssistLabel$annotations() {
        }

        @FieldName(name = "auto_cover")
        public static /* synthetic */ void getAutoCover$annotations() {
        }

        @FieldName(name = "background")
        public static /* synthetic */ void getBackground$annotations() {
        }

        @FieldName(name = "basis")
        public static /* synthetic */ void getBasisRoomData$annotations() {
        }

        @FieldName(name = "business_live")
        public static /* synthetic */ void getBusinessLive$annotations() {
        }

        @FieldName(name = "circle_info")
        public static /* synthetic */ void getCircleInfo$annotations() {
        }

        @FieldName(name = "content_label")
        public static /* synthetic */ void getContentLabel$annotations() {
        }

        @FieldName(name = "content_tag")
        public static /* synthetic */ void getContentTag$annotations() {
        }

        @FieldName(name = "cover")
        public static /* synthetic */ void getCover$annotations() {
        }

        @FieldName(name = "create_time")
        public static /* synthetic */ void getCreateTime$annotations() {
        }

        @FieldName(name = "like_count")
        public static /* synthetic */ void getDiggCount$annotations() {
        }

        @FieldName(name = "distance_city")
        public static /* synthetic */ void getDistanceCity$annotations() {
        }

        @FieldName(name = "distance_km")
        public static /* synthetic */ void getDistanceKm$annotations() {
        }

        @FieldName(name = "dynamic_label")
        public static /* synthetic */ void getDynamicLabel$annotations() {
        }

        @FieldName(name = "episode_extra")
        public static /* synthetic */ void getEpisodeExtra$annotations() {
        }

        @FieldName(name = "preview_expose")
        public static /* synthetic */ void getExposeData$annotations() {
        }

        @FieldName(name = "finish_time")
        public static /* synthetic */ void getFinishTime$annotations() {
        }

        @FieldName(name = "game_cp")
        public static /* synthetic */ void getGameCPData$annotations() {
        }

        @FieldName(name = "has_promotion_games")
        public static /* synthetic */ void getHasGamePromote$annotations() {
        }

        @FieldName(name = "id_str")
        public static /* synthetic */ void getIdStr$annotations() {
        }

        @FieldName(name = "introduction")
        public static /* synthetic */ void getIntroduction$annotations() {
        }

        @FieldName(name = "item_explicit_info")
        public static /* synthetic */ void getItemExplicitInfo$annotations() {
        }

        @FieldName(name = "common_label_list")
        public static /* synthetic */ void getLabels$annotations() {
        }

        @FieldName(name = "layout")
        public static /* synthetic */ void getLayout$annotations() {
        }

        @FieldName(name = "linker_map")
        public static /* synthetic */ void getLinkMap$annotations() {
        }

        @FieldName(name = "linkmic_layout")
        public static /* synthetic */ void getLinkMicLayout$annotations() {
        }

        @FieldName(name = "linker_detail")
        public static /* synthetic */ void getLinkerDetail$annotations() {
        }

        @FieldName(name = "linker_users")
        public static /* synthetic */ void getLinkerUsers$annotations() {
        }

        @FieldName(name = "linkmic_display_type")
        public static /* synthetic */ void getLinkmicDisplayType$annotations() {
        }

        @FieldName(name = "challenge_info")
        public static /* synthetic */ void getLiveHashTagJson$annotations() {
        }

        @FieldName(name = "live_platform_source")
        public static /* synthetic */ void getLivePlatformSource$annotations() {
        }

        @FieldName(name = "live_room_mode")
        public static /* synthetic */ void getLiveRoomMode$annotations() {
        }

        @FieldName(name = "stamps")
        public static /* synthetic */ void getLiveRoomStampsJson$annotations() {
        }

        @FieldName(name = "live_status_info")
        public static /* synthetic */ void getLiveStatusInfo$annotations() {
        }

        @FieldName(name = "live_type_sandbox")
        public static /* synthetic */ void getLiveTypeSandbox$annotations() {
        }

        @FieldName(name = "live_type_vs_live")
        public static /* synthetic */ void getLiveTypeVsLive$annotations() {
        }

        @FieldName(name = "live_type_vs_premiere")
        public static /* synthetic */ void getLiveTypeVsPremiere$annotations() {
        }

        @FieldName(name = "room_auth")
        public static /* synthetic */ void getMRoomAuthStatus$annotations() {
        }

        @FieldName(name = "operation_label")
        public static /* synthetic */ void getOperationLabel$annotations() {
        }

        @FieldName(name = "paid_live_data")
        public static /* synthetic */ void getPaidLiveData$annotations() {
        }

        @FieldName(name = "os_type")
        public static /* synthetic */ void getPlatform$annotations() {
        }

        @FieldName(name = "pre_enter_time")
        public static /* synthetic */ void getPreEnterTime$annotations() {
        }

        @FieldName(name = "private_info")
        public static /* synthetic */ void getPrivateInfo$annotations() {
        }

        @FieldName(name = "luckymoney_num")
        public static /* synthetic */ void getRedEnvelopeNumber$annotations() {
        }

        @FieldName(name = "replay")
        public static /* synthetic */ void getReplay$annotations() {
        }

        @FieldName(name = "replay_info")
        public static /* synthetic */ void getReplayInfo$annotations() {
        }

        @FieldName(name = "room_cart")
        public static /* synthetic */ void getRoomCart$annotations() {
        }

        @FieldName(name = "im_info")
        public static /* synthetic */ void getRoomIMInfo$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT)
        public static /* synthetic */ void getRoomLayout$annotations() {
        }

        @FieldName(name = "scene_type_info")
        public static /* synthetic */ void getSceneTypeInfo$annotations() {
        }

        @FieldName(name = "share_url")
        public static /* synthetic */ void getShareUrl$annotations() {
        }

        @FieldName(name = "short_title")
        public static /* synthetic */ void getShortTitle$annotations() {
        }

        @FieldName(name = "stats")
        public static /* synthetic */ void getStats$annotations() {
        }

        @FieldName(name = "status")
        public static /* synthetic */ void getStatus$annotations() {
        }

        @FieldName(name = "stream_close_time")
        public static /* synthetic */ void getStreamCloseTime$annotations() {
        }

        @FieldName(name = "stream_id")
        public static /* synthetic */ void getStreamId$annotations() {
        }

        @FieldName(name = "stream_url")
        public static /* synthetic */ void getStreamUrl$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }

        @FieldName(name = "toolbar_data")
        public static /* synthetic */ void getToolbarData$annotations() {
        }

        @FieldName(name = CommonCmd.AIDL_PLATFORM_TYPE_TV)
        public static /* synthetic */ void getTvInfo$annotations() {
        }

        @FieldName(name = "user_count")
        public static /* synthetic */ void getUserCount$annotations() {
        }

        @FieldName(name = "vid")
        public static /* synthetic */ void getVid$annotations() {
        }

        @FieldName(name = "video_feed_tag")
        public static /* synthetic */ void getVideoFeedTag$annotations() {
        }

        @FieldName(name = "visibility_range")
        public static /* synthetic */ void getVisibilityRange$annotations() {
        }

        @FieldName(name = "AudioRoomBGImage")
        public static /* synthetic */ void getVoiceLiveTheme$annotations() {
        }

        @FieldName(name = "with_linkmic")
        public static /* synthetic */ void getWithLinkMic$annotations() {
        }

        @FieldName(name = IStartLiveInterceptor.StartLiveParams.KEY_COMMERCE_LIVE_ENABLED)
        public static /* synthetic */ void isHasCommerceGoods$annotations() {
        }

        @FieldName(name = "live_type_audio")
        public static /* synthetic */ void isLiveTypeAudio$annotations() {
        }

        @FieldName(name = "is_official_channel_room")
        public static /* synthetic */ void isOfficialChannelRoom$annotations() {
        }

        @FieldName(name = "live_type_official")
        public static /* synthetic */ void isOfficialType$annotations() {
        }

        @FieldName(name = "live_type_screenshot")
        public static /* synthetic */ void isScreenshot$annotations() {
        }

        @FieldName(name = "live_type_third_party")
        public static /* synthetic */ void isThirdParty$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* synthetic */ e castTo(Class r100);

    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "acquaintance_status")
    long getAcquaintanceStatus();

    @FieldName(name = "anchor_data")
    IAnchorData getAnchorData();

    @FieldName(name = "anchor_tab_type")
    int getAnchorTabType();

    @FieldName(name = "assist_label")
    ILabelInfo getAssistLabel();

    @FieldName(name = "auto_cover")
    long getAutoCover();

    @FieldName(name = "background")
    k getBackground();

    @FieldName(name = "basis")
    IRoomBasisData getBasisRoomData();

    @FieldName(name = "business_live")
    int getBusinessLive();

    @FieldName(name = "circle_info")
    ICircleInfo getCircleInfo();

    @FieldName(name = "content_label")
    k getContentLabel();

    @FieldName(name = "content_tag")
    String getContentTag();

    @FieldName(name = "cover")
    k getCover();

    @FieldName(name = "create_time")
    long getCreateTime();

    @FieldName(name = "like_count")
    long getDiggCount();

    @FieldName(name = "distance_city")
    String getDistanceCity();

    @FieldName(name = "distance_km")
    String getDistanceKm();

    @FieldName(name = "dynamic_label")
    ILabelInfo getDynamicLabel();

    @FieldName(name = "episode_extra")
    IEpisodeExtraInfo getEpisodeExtra();

    @FieldName(name = "preview_expose")
    IPreviewExposeData getExposeData();

    @FieldName(name = "finish_time")
    long getFinishTime();

    @FieldName(name = "game_cp")
    IGameCPData getGameCPData();

    @FieldName(name = "has_promotion_games")
    long getHasGamePromote();

    @FieldName(name = "id_str")
    String getIdStr();

    @FieldName(name = "introduction")
    String getIntroduction();

    @FieldName(name = "item_explicit_info")
    String getItemExplicitInfo();

    @FieldName(name = "common_label_list")
    String getLabels();

    @FieldName(name = "layout")
    long getLayout();

    @FieldName(name = "linker_map")
    Map<String, Long> getLinkMap();

    @FieldName(name = "linkmic_layout")
    long getLinkMicLayout();

    @FieldName(name = "linker_detail")
    z5 getLinkerDetail();

    @FieldName(name = "linker_users")
    ILinkerUsers getLinkerUsers();

    @FieldName(name = "linkmic_display_type")
    long getLinkmicDisplayType();

    @FieldName(name = "challenge_info")
    String getLiveHashTagJson();

    @FieldName(name = "live_platform_source")
    String getLivePlatformSource();

    @FieldName(name = "live_room_mode")
    long getLiveRoomMode();

    @FieldName(name = "stamps")
    String getLiveRoomStampsJson();

    @FieldName(name = "live_status_info")
    ILiveStatusInfo getLiveStatusInfo();

    @FieldName(name = "live_type_sandbox")
    boolean getLiveTypeSandbox();

    @FieldName(name = "live_type_vs_live")
    boolean getLiveTypeVsLive();

    @FieldName(name = "live_type_vs_premiere")
    boolean getLiveTypeVsPremiere();

    @FieldName(name = "room_auth")
    IRoomAuthStatus getMRoomAuthStatus();

    @FieldName(name = "operation_label")
    k getOperationLabel();

    @FieldName(name = "paid_live_data")
    IPaidLiveData getPaidLiveData();

    @FieldName(name = "os_type")
    long getPlatform();

    @FieldName(name = "pre_enter_time")
    long getPreEnterTime();

    @FieldName(name = "private_info")
    String getPrivateInfo();

    @FieldName(name = "luckymoney_num")
    long getRedEnvelopeNumber();

    @FieldName(name = "replay")
    boolean getReplay();

    @FieldName(name = "replay_info")
    IReplayInfo getReplayInfo();

    @FieldName(name = "room_cart")
    IRoomCart getRoomCart();

    @FieldName(name = "im_info")
    IRoomIMInfo getRoomIMInfo();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT)
    long getRoomLayout();

    @FieldName(name = "scene_type_info")
    IRoomSpecificSceneTypeInfo getSceneTypeInfo();

    @FieldName(name = "share_url")
    String getShareUrl();

    @FieldName(name = "short_title")
    String getShortTitle();

    @FieldName(name = "stats")
    IRoomStats getStats();

    @FieldName(name = "status")
    long getStatus();

    @FieldName(name = "stream_close_time")
    long getStreamCloseTime();

    @FieldName(name = "stream_id")
    long getStreamId();

    @FieldName(name = "stream_url")
    IBaseStreamUrl getStreamUrl();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "toolbar_data")
    ILiveToolbarData getToolbarData();

    @FieldName(name = CommonCmd.AIDL_PLATFORM_TYPE_TV)
    ILiveNearbyTVInfo getTvInfo();

    @FieldName(name = "user_count")
    long getUserCount();

    @FieldName(name = "vid")
    String getVid();

    @FieldName(name = "video_feed_tag")
    String getVideoFeedTag();

    @FieldName(name = "visibility_range")
    int getVisibilityRange();

    @FieldName(name = "AudioRoomBGImage")
    IVoiceLiveTheme getVoiceLiveTheme();

    @FieldName(name = "with_linkmic")
    boolean getWithLinkMic();

    @FieldName(name = IStartLiveInterceptor.StartLiveParams.KEY_COMMERCE_LIVE_ENABLED)
    boolean isHasCommerceGoods();

    @FieldName(name = "live_type_audio")
    boolean isLiveTypeAudio();

    @FieldName(name = "is_official_channel_room")
    boolean isOfficialChannelRoom();

    @FieldName(name = "live_type_official")
    boolean isOfficialType();

    @FieldName(name = "live_type_screenshot")
    boolean isScreenshot();

    @FieldName(name = "live_type_third_party")
    boolean isThirdParty();

    @FieldName(name = "acquaintance_status#setter")
    void setAcquaintanceStatus(long r100);

    @FieldName(name = "anchor_tab_type#setter")
    void setAnchorTabType(int r100);

    @FieldName(name = "auto_cover#setter")
    void setAutoCover(long r100);

    @FieldName(name = "background#setter")
    void setBackground(k r100);

    @FieldName(name = "basis#setter")
    void setBasisRoomData(IRoomBasisData r100);

    @FieldName(name = "business_live#setter")
    void setBusinessLive(int r100);

    @FieldName(name = "circle_info#setter")
    void setCircleInfo(ICircleInfo r100);

    @FieldName(name = "content_label#setter")
    void setContentLabel(k r100);

    @FieldName(name = "content_tag#setter")
    void setContentTag(String r100);

    @FieldName(name = "cover#setter")
    void setCover(k r100);

    @FieldName(name = "create_time#setter")
    void setCreateTime(long r100);

    @FieldName(name = "like_count#setter")
    void setDiggCount(long r100);

    @FieldName(name = "distance_city#setter")
    void setDistanceCity(String r100);

    @FieldName(name = "distance_km#setter")
    void setDistanceKm(String r100);

    @FieldName(name = "finish_time#setter")
    void setFinishTime(long r100);

    @FieldName(name = "game_cp#setter")
    void setGameCPData(IGameCPData r100);

    @FieldName(name = "has_commerce_goods#setter")
    void setHasCommerceGoods(boolean r100);

    @FieldName(name = "has_promotion_games#setter")
    void setHasGamePromote(long r100);

    @FieldName(name = "id_str#setter")
    void setIdStr(String r100);

    @FieldName(name = "introduction#setter")
    void setIntroduction(String r100);

    @FieldName(name = "item_explicit_info#setter")
    void setItemExplicitInfo(String r100);

    @FieldName(name = "common_label_list#setter")
    void setLabels(String r100);

    @FieldName(name = "linkmic_layout#setter")
    void setLinkMicLayout(long r100);

    @FieldName(name = "linker_detail#setter")
    void setLinkerDetail(z5 r100);

    @FieldName(name = "linkmic_display_type#setter")
    void setLinkmicDisplayType(long r100);

    @FieldName(name = "challenge_info#setter")
    void setLiveHashTagJson(String r100);

    @FieldName(name = "live_platform_source#setter")
    void setLivePlatformSource(String r100);

    @FieldName(name = "stamps#setter")
    void setLiveRoomStampsJson(String r100);

    @FieldName(name = "live_status_info#setter")
    void setLiveStatusInfo(ILiveStatusInfo r100);

    @FieldName(name = "live_type_sandbox#setter")
    void setLiveTypeSandbox(boolean r100);

    @FieldName(name = "live_type_vs_live#setter")
    void setLiveTypeVsLive(boolean r100);

    @FieldName(name = "live_type_vs_premiere#setter")
    void setLiveTypeVsPremiere(boolean r100);

    @FieldName(name = "is_official_channel_room#setter")
    void setOfficialChannelRoom(boolean r100);

    @FieldName(name = "live_type_official#setter")
    void setOfficialType(boolean r100);

    @FieldName(name = "operation_label#setter")
    void setOperationLabel(k r100);

    @FieldName(name = "pre_enter_time#setter")
    void setPreEnterTime(long r100);

    @FieldName(name = "private_info#setter")
    void setPrivateInfo(String r100);

    @FieldName(name = "luckymoney_num#setter")
    void setRedEnvelopeNumber(long r100);

    @FieldName(name = "replay#setter")
    void setReplay(boolean r100);

    @FieldName(name = "replay_info#setter")
    void setReplayInfo(IReplayInfo r100);

    @FieldName(name = "room_cart#setter")
    void setRoomCart(IRoomCart r100);

    @FieldName(name = "im_info#setter")
    void setRoomIMInfo(IRoomIMInfo r100);

    @FieldName(name = "share_url#setter")
    void setShareUrl(String r100);

    @FieldName(name = "short_title#setter")
    void setShortTitle(String r100);

    @FieldName(name = "stats#setter")
    void setStats(IRoomStats r100);

    @FieldName(name = "status#setter")
    void setStatus(long r100);

    @FieldName(name = "stream_close_time#setter")
    void setStreamCloseTime(long r100);

    @FieldName(name = "stream_id#setter")
    void setStreamId(long r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);

    @FieldName(name = "tv#setter")
    void setTvInfo(ILiveNearbyTVInfo r100);

    @FieldName(name = "user_count#setter")
    void setUserCount(long r100);

    @FieldName(name = "vid#setter")
    void setVid(String r100);

    @FieldName(name = "video_feed_tag#setter")
    void setVideoFeedTag(String r100);

    @FieldName(name = "visibility_range#setter")
    void setVisibilityRange(int r100);

    @FieldName(name = "AudioRoomBGImage#setter")
    void setVoiceLiveTheme(IVoiceLiveTheme r100);

    @FieldName(name = "with_linkmic#setter")
    void setWithLinkMic(boolean r100);
}
