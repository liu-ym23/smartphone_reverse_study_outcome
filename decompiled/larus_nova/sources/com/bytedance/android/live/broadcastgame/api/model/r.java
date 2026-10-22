package com.bytedance.android.live.broadcastgame.api.model;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.open.SocialConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0002Ö\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R\u001a\u00109\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R\u001a\u0010=\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010R\u001a\u0010?\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0019\u001a\u0004\b@\u0010\u001bR\u001a\u0010A\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u000e\u001a\u0004\bB\u0010\u0010R\u001a\u0010C\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010\u0019\u001a\u0004\bD\u0010\u001bR\u001a\u0010E\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\u001bR\u001a\u0010G\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\u0019\u001a\u0004\bH\u0010\u001bR\u001a\u0010J\u001a\u00020I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010T\u001a\u00020S8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u000e\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\t\u001a\u0004\b]\u0010\u000bR\u001c\u0010^\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010R\u001a\u0010`\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u001a\u0010b\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010\u0019\u001a\u0004\bc\u0010\u001bR\u001a\u0010d\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u0019\u001a\u0004\be\u0010\u001bR\u001a\u0010f\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0019\u001a\u0004\bg\u0010\u001bR\u001a\u0010h\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010i\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bi\u0010\u0019\u001a\u0004\b\u0004\u0010\u001bR\u001a\u0010j\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010\t\u001a\u0004\bk\u0010\u000bR\u001a\u0010l\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bl\u0010\u000e\u001a\u0004\bm\u0010\u0010R\u001a\u0010n\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bn\u0010\u000e\u001a\u0004\bo\u0010\u0010R\u001a\u0010p\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bp\u0010\u0004\u001a\u0004\bq\u0010\u0006R\u001a\u0010r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006R\u001a\u0010t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\u0006R\u001a\u0010w\u001a\u00020v8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001a\u0010{\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010\u0019\u001a\u0004\b|\u0010\u001bR\u001a\u0010}\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010\t\u001a\u0004\b~\u0010\u000bR\u001b\u0010\u007f\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u007f\u0010\u0019\u001a\u0005\b\u0080\u0001\u0010\u001bR\u001d\u0010\u0081\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0019\u001a\u0005\b\u0082\u0001\u0010\u001bR\u001d\u0010\u0083\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0019\u001a\u0005\b\u0084\u0001\u0010\u001bR\u001d\u0010\u0085\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0019\u001a\u0005\b\u0086\u0001\u0010\u001bR\u001d\u0010\u0087\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006R\u001d\u0010\u0089\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0004\u001a\u0005\b\u008a\u0001\u0010\u0006R\u001d\u0010\u008b\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u0019\u001a\u0005\b\u008c\u0001\u0010\u001bR\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u000e\u001a\u0005\b\u0093\u0001\u0010\u0010R\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u000e\u001a\u0005\b\u0095\u0001\u0010\u0010R\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u000e\u001a\u0005\b\u0097\u0001\u0010\u0010R\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u000e\u001a\u0005\b\u0099\u0001\u0010\u0010R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u000e\u001a\u0005\b\u009b\u0001\u0010\u0010R\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u000e\u001a\u0005\b\u009d\u0001\u0010\u0010R\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u000e\u001a\u0005\b\u009f\u0001\u0010\u0010R\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010\u000e\u001a\u0005\b¡\u0001\u0010\u0010R\"\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R\u001f\u0010¬\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¬\u0001\u0010\u000e\u001a\u0005\b\u00ad\u0001\u0010\u0010R\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b®\u0001\u0010\u000e\u001a\u0005\b¯\u0001\u0010\u0010R\u001d\u0010°\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b°\u0001\u0010\u000e\u001a\u0005\b±\u0001\u0010\u0010RA\u0010´\u0001\u001a$\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010²\u0001j\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`³\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u001d\u0010¸\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0004\u001a\u0005\b¹\u0001\u0010\u0006RA\u0010º\u0001\u001a$\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010²\u0001j\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`³\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bº\u0001\u0010µ\u0001\u001a\u0006\b»\u0001\u0010·\u0001R\u001f\u0010¼\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u000e\u001a\u0005\b½\u0001\u0010\u0010R\u001f\u0010¾\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u000e\u001a\u0005\b¿\u0001\u0010\u0010R\u001d\u0010À\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u0004\u001a\u0005\bÁ\u0001\u0010\u0006R\u001d\u0010Â\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u000e\u001a\u0005\bÃ\u0001\u0010\u0010R\u001d\u0010Ä\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u000e\u001a\u0005\bÅ\u0001\u0010\u0010R\u001d\u0010Æ\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u000e\u001a\u0005\bÇ\u0001\u0010\u0010R\u001d\u0010È\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u000e\u001a\u0005\bÉ\u0001\u0010\u0010R%\u0010Ê\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÊ\u0001\u0010.\u001a\u0005\bË\u0001\u00100R&\u0010Í\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÍ\u0001\u0010.\u001a\u0005\bÎ\u0001\u00100R\u001d\u0010Ï\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006R%\u0010Ñ\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\bÑ\u0001\u0010\u0004\u0012\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0005\bÒ\u0001\u0010\u0006R(\u0010Õ\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\u000e\u001a\u0005\bÖ\u0001\u0010\u0010\"\u0005\b×\u0001\u0010[R \u0010Ø\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\bØ\u0001\u0010.R\u001f\u0010Ù\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÙ\u0001\u0010\u000e\u001a\u0005\bÚ\u0001\u0010\u0010R\u001f\u0010Û\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u000e\u001a\u0005\bÜ\u0001\u0010\u0010R\"\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001R!\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\u0006X\u0087\u0004¢\u0006\u000f\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0005\bx\u0010å\u0001R\"\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001R\u001d\u0010ë\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bë\u0001\u0010\u0004\u001a\u0005\bì\u0001\u0010\u0006R\u001d\u0010í\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bí\u0001\u0010\u0004\u001a\u0005\bî\u0001\u0010\u0006R\u001f\u0010ï\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bï\u0001\u0010\u000e\u001a\u0005\bð\u0001\u0010\u0010R\"\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001¨\u0006ö\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/r;", "", "", BdpAppEventConstant.PARAMS_GAME_TYPE, "I", "r", "()I", "", "game_id", "J", "p", "()J", "", EventConstants.ExtraJson.GAME_NAME, "Ljava/lang/String;", "q", "()Ljava/lang/String;", "open_type", "getOpen_type", "support_players", "getSupport_players", "orientation", "getOrientation", "", "need_game_desc", "Z", "getNeed_game_desc", "()Z", "game_description_snippet", "getGame_description_snippet", "game_cover", "getGame_cover", "game_video", "getGame_video", "game_package", "getGame_package", "autodownload", "d", "loading_time", "getLoading_time", "loading_text", "getLoading_text", "ab_param_key", "getAb_param_key", "", "url_prefix", "Ljava/util/List;", "L", "()Ljava/util/List;", "repelPanel", "getRepelPanel", "supportLiveScene", FaceService.neutralLabel, "supportChatRoomType", "getSupportChatRoomType", "supportLiveMode", "getSupportLiveMode", "supportLiveRole", "G", "supportLiveRoleV2", "getSupportLiveRoleV2", "bigCover", "getBigCover", "audience_show_loading", "getAudience_show_loading", "audience_loading_text", "getAudience_loading_text", "need_show_rematch_entrance", "getNeed_show_rematch_entrance", "need_local_mix_stream", "getNeed_local_mix_stream", "hide_user_entrance", "u", "Lcom/bytedance/android/live/broadcastgame/api/model/c;", "bubble_config", "Lcom/bytedance/android/live/broadcastgame/api/model/c;", "f", "()Lcom/bytedance/android/live/broadcastgame/api/model/c;", "Lcom/bytedance/android/live/broadcastgame/api/model/a;", "breathing_light_config", "Lcom/bytedance/android/live/broadcastgame/api/model/a;", "e", "()Lcom/bytedance/android/live/broadcastgame/api/model/a;", "Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "red_dot_config", "Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "B", "()Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "game_identifier", "getGame_identifier", "setGame_identifier", "(Ljava/lang/String;)V", MobConstants.EFFECT_ID, "l", "guide_name", "s", "guide_show_count", "t", "loadgame_when_guide", BaseSwitches.V, "need_beat", "y", "need_bgmusic", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "support_mode", "support_effect_mix_stream", "wmini_game_ttid", "getWmini_game_ttid", "wmini_game_id", "getWmini_game_id", "loading_bg_url", "getLoading_bg_url", "wmini_game_matching_players", "getWmini_game_matching_players", "game_base_on_type", "o", "wtimor_game_repel_panel", "getWtimor_game_repel_panel", "", "anchor_window_threshold", FaceService.girlLabel, "getAnchor_window_threshold", "()F", "wtimor_delete_start_request", "getWtimor_delete_start_request", "audience_game_start_channel", "getAudience_game_start_channel", "show_anchor_float_entrance", "getShow_anchor_float_entrance", "show_audience_float_entrance", ExifInterface.LONGITUDE_EAST, "allow_auto_show_anchor_panel", "getAllow_auto_show_anchor_panel", "allow_auto_show_audience_panel", "getAllow_auto_show_audience_panel", "anchor_panel_limit_frequency", "getAnchor_panel_limit_frequency", "audience_panel_limit_frequency", "getAudience_panel_limit_frequency", "allow_panel_transparency", "getAllow_panel_transparency", "Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "float_entrance_style", "Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "getFloat_entrance_style", "()Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "lynx_channel", "getLynx_channel", "effect_channel", "getEffect_channel", "anchor_effect_resource_url", "getAnchor_effect_resource_url", "audience_effect_resource_url", "getAudience_effect_resource_url", "audience_effect_resource_version", "getAudience_effect_resource_version", "lynx_resource_business_version", "getLynx_resource_business_version", "anchor_lynx_resource_url", "getAnchor_lynx_resource_url", "audience_lynx_resource_url", "getAudience_lynx_resource_url", "Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "min_support_version", "Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "getMin_support_version", "()Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "lynx_fallback_url", "Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "getLynx_fallback_url", "()Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "resource_access_key", "getResource_access_key", "float_entrance_channel", "getFloat_entrance_channel", "schema", "C", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "gameDynamicResources", "Ljava/util/HashMap;", "getGameDynamicResources", "()Ljava/util/HashMap;", "useSZLiveGameFramework", "getUseSZLiveGameFramework", "linkMicTagImages", "getLinkMicTagImages", "interactGameTitle", "getInteractGameTitle", "interactGameImage", "getInteractGameImage", "innerGame", "getInnerGame", "appId", "b", "textIntro", "K", "developer", ce.f26395j, "appVersion", "c", "sensitivityTip", "D", "Lcom/bytedance/android/live/broadcastgame/api/model/b0;", "mediaIntro", "w", "businessType", ce.f26391f, "anchorRatio", "getAnchorRatio", "getAnchorRatio$annotations", "()V", "anchorRatioV2", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchorRatioV2", "supportiveEntrance", "gameCardInfo", "m", SocialConstants.PARAM_APP_DESC, RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/live/broadcastgame/api/model/d;", "chatroomScreencastConfig", "Lcom/bytedance/android/live/broadcastgame/api/model/d;", "h", "()Lcom/bytedance/android/live/broadcastgame/api/model/d;", "Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "singleScreencastConfig", "Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "()Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "Lcom/bytedance/android/live/broadcastgame/api/model/g;", "gameEngineInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/g;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/live/broadcastgame/api/model/g;", "gameMultiPlayerType", "getGameMultiPlayerType", "dynamicInteractId", ce.f26396k, "playRule", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "microGameInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "x", "()Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Sticker f59368a;

    @SerializedName("ab_param_key")
    private final String ab_param_key;

    @SerializedName("allow_auto_show_anchor_panel")
    private final boolean allow_auto_show_anchor_panel;

    @SerializedName("allow_auto_show_audience_panel")
    private final boolean allow_auto_show_audience_panel;

    @SerializedName("allow_panel_transparency")
    private final boolean allow_panel_transparency;

    @SerializedName("anchor_ratio")
    private final int anchorRatio;

    @SerializedName("anchor_ratio_v2")
    private String anchorRatioV2;

    @SerializedName("anchor_effect_resource_url")
    private final String anchor_effect_resource_url;

    @SerializedName("anchor_lynx_resource_url")
    private final String anchor_lynx_resource_url;

    @SerializedName("anchor_panel_limit_frequency")
    private final int anchor_panel_limit_frequency;

    @SerializedName("wtimor_game_window_threshold")
    private final float anchor_window_threshold;

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("audience_effect_resource_url")
    private final String audience_effect_resource_url;

    @SerializedName("effect_resource_version")
    private final String audience_effect_resource_version;

    @SerializedName("to_audience_game_start_channel")
    private final long audience_game_start_channel;

    @SerializedName("audience_loading_text")
    private final String audience_loading_text;

    @SerializedName("audience_lynx_resource_url")
    private final String audience_lynx_resource_url;

    @SerializedName("audience_panel_limit_frequency")
    private final int audience_panel_limit_frequency;

    @SerializedName("audience_show_loading")
    private final boolean audience_show_loading;

    @SerializedName("autodownload")
    private final boolean autodownload;

    @SerializedName("support_pk_end_cover")
    private final String bigCover;

    @SerializedName("breathing_light_config")
    private final com.bytedance.android.live.broadcastgame.api.model.a breathing_light_config;

    @SerializedName("bubble_config")
    private final c bubble_config;

    @SerializedName("business_type")
    private final int businessType;

    @SerializedName("screencast_config")
    private final d chatroomScreencastConfig;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("developer")
    private final String developer;

    @SerializedName("dynamic_interact_id")
    private final int dynamicInteractId;

    @SerializedName("effect_channel")
    private final String effect_channel;

    @SerializedName(MobConstants.EFFECT_ID)
    private final long effect_id;

    @SerializedName("float_entrance_channel")
    private final String float_entrance_channel;

    @SerializedName("float_entrance_style")
    private final FloatEntranceStyle float_entrance_style;

    @SerializedName("game_card_extra")
    private final String gameCardInfo;

    @SerializedName("game_dynamic_prefab_resource")
    private final HashMap<String, String> gameDynamicResources;

    @SerializedName("game_engine_info")
    private final g gameEngineInfo;

    @SerializedName("game_multiplayer_type")
    private final int gameMultiPlayerType;

    @SerializedName("wtimor_game_type")
    private final int game_base_on_type;

    @SerializedName("game_cover")
    private final String game_cover;

    @SerializedName("game_description_snippet")
    private final String game_description_snippet;

    @SerializedName("game_id")
    private final long game_id;

    @SerializedName("game_identifier")
    private String game_identifier;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private final String game_name;

    @SerializedName("game_package")
    private final String game_package;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    private final int game_type;

    @SerializedName("game_video")
    private final String game_video;

    @SerializedName("guide_name")
    private final String guide_name;

    @SerializedName("guide_show_count")
    private final int guide_show_count;

    @SerializedName("hide_user_entrance")
    private final boolean hide_user_entrance;

    @SerializedName("inner_game")
    private final int innerGame;

    @SerializedName("interact_game_image")
    private final String interactGameImage;

    @SerializedName("interact_game_title")
    private final String interactGameTitle;

    @SerializedName("link_mic_tag_images")
    private final HashMap<String, String> linkMicTagImages;

    @SerializedName("loadgame_when_guide")
    private final boolean loadgame_when_guide;

    @SerializedName("loading_bg_url")
    private final String loading_bg_url;

    @SerializedName("loading_text")
    private final String loading_text;

    @SerializedName("loading_time")
    private final int loading_time;

    @SerializedName("lynx_channel")
    private final String lynx_channel;

    @SerializedName("lynx_fallback_url")
    private final a0 lynx_fallback_url;

    @SerializedName("lynx_resource_business_version")
    private final String lynx_resource_business_version;

    @SerializedName("media_intro")
    private final List<b0> mediaIntro;

    @SerializedName("micro_game_info")
    private final c0 microGameInfo;

    @SerializedName("min_support_version")
    private final d0 min_support_version;

    @SerializedName("need_beat")
    private final boolean need_beat;

    @SerializedName("need_bgmusic")
    private final boolean need_bgmusic;

    @SerializedName("need_game_desc")
    private final boolean need_game_desc;

    @SerializedName("need_local_mix_stream")
    private final boolean need_local_mix_stream;

    @SerializedName("need_show_rematch_entrance")
    private final boolean need_show_rematch_entrance;

    @SerializedName("open_type")
    private final String open_type;

    @SerializedName("orientation")
    private final int orientation;

    @SerializedName("play_rule")
    private final String playRule;

    @SerializedName("red_dot_config")
    private final j0 red_dot_config;

    @SerializedName("RepelPanel")
    private final int repelPanel;

    @SerializedName("resource_access_key")
    private final String resource_access_key;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("sensitivity_tip")
    private final List<String> sensitivityTip;

    @SerializedName("show_anchor_float_entrance")
    private final boolean show_anchor_float_entrance;

    @SerializedName("show_audience_float_entrance")
    private final boolean show_audience_float_entrance;

    @SerializedName("single_screencast_config")
    private final p0 singleScreencastConfig;

    @SerializedName("support_chatroom_type")
    private final List<Integer> supportChatRoomType;

    @SerializedName("support_live_mode")
    private final List<Integer> supportLiveMode;

    @SerializedName("support_live_role")
    private final int supportLiveRole;

    @SerializedName("support_live_role_v2")
    private final List<Integer> supportLiveRoleV2;

    @SerializedName("support_live_scene")
    private final List<Integer> supportLiveScene;

    @SerializedName("support_effect_mix_stream")
    private final boolean support_effect_mix_stream;

    @SerializedName("support_mode")
    private final int support_mode;

    @SerializedName("support_players")
    private final int support_players;

    @SerializedName("support_live_entrance")
    public List<Long> supportiveEntrance;

    @SerializedName("text_intro")
    private final String textIntro;

    @SerializedName("url_prefix")
    private final List<String> url_prefix;

    @SerializedName("use_sz_live_game_framework")
    private final int useSZLiveGameFramework;

    @SerializedName("wtimor_game_id")
    private final String wmini_game_id;

    @SerializedName("wtimor_game_matching_players")
    private final int wmini_game_matching_players;

    @SerializedName("wtimor_game_ttid")
    private final long wmini_game_ttid;

    @SerializedName("wtimor_delete_start_request")
    private final boolean wtimor_delete_start_request;

    @SerializedName("wtimor_game_repel_panel")
    private final int wtimor_game_repel_panel;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L196;
        r r101 = (r) r100;
        if (this.game_type == r101.game_type) goto L8;
        return false;
    L8:
        if (this.game_id == r101.game_id) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.game_name, r101.game_name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.open_type, r101.open_type) == true) goto L14;
        return false;
    L14:
        if (this.support_players == r101.support_players) goto L16;
        return false;
    L16:
        if (this.orientation == r101.orientation) goto L18;
        return false;
    L18:
        if (this.need_game_desc == r101.need_game_desc) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.game_description_snippet, r101.game_description_snippet) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.game_cover, r101.game_cover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.game_video, r101.game_video) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.game_package, r101.game_package) == true) goto L28;
        return false;
    L28:
        if (this.autodownload == r101.autodownload) goto L30;
        return false;
    L30:
        if (this.loading_time == r101.loading_time) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.loading_text, r101.loading_text) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.ab_param_key, r101.ab_param_key) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.url_prefix, r101.url_prefix) == true) goto L38;
        return false;
    L38:
        if (this.repelPanel == r101.repelPanel) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.supportLiveScene, r101.supportLiveScene) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.supportChatRoomType, r101.supportChatRoomType) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.supportLiveMode, r101.supportLiveMode) == true) goto L46;
        return false;
    L46:
        if (this.supportLiveRole == r101.supportLiveRole) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.supportLiveRoleV2, r101.supportLiveRoleV2) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.bigCover, r101.bigCover) == true) goto L52;
        return false;
    L52:
        if (this.audience_show_loading == r101.audience_show_loading) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.audience_loading_text, r101.audience_loading_text) == true) goto L56;
        return false;
    L56:
        if (this.need_show_rematch_entrance == r101.need_show_rematch_entrance) goto L58;
        return false;
    L58:
        if (this.need_local_mix_stream == r101.need_local_mix_stream) goto L60;
        return false;
    L60:
        if (this.hide_user_entrance == r101.hide_user_entrance) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.bubble_config, r101.bubble_config) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.breathing_light_config, r101.breathing_light_config) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.red_dot_config, r101.red_dot_config) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.game_identifier, r101.game_identifier) == true) goto L70;
        return false;
    L70:
        if (this.effect_id == r101.effect_id) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.guide_name, r101.guide_name) == true) goto L74;
        return false;
    L74:
        if (this.guide_show_count == r101.guide_show_count) goto L76;
        return false;
    L76:
        if (this.loadgame_when_guide == r101.loadgame_when_guide) goto L78;
        return false;
    L78:
        if (this.need_beat == r101.need_beat) goto L80;
        return false;
    L80:
        if (this.need_bgmusic == r101.need_bgmusic) goto L82;
        return false;
    L82:
        if (this.support_mode == r101.support_mode) goto L84;
        return false;
    L84:
        if (this.support_effect_mix_stream == r101.support_effect_mix_stream) goto L86;
        return false;
    L86:
        if (this.wmini_game_ttid == r101.wmini_game_ttid) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.wmini_game_id, r101.wmini_game_id) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.loading_bg_url, r101.loading_bg_url) == true) goto L92;
        return false;
    L92:
        if (this.wmini_game_matching_players == r101.wmini_game_matching_players) goto L94;
        return false;
    L94:
        if (this.game_base_on_type == r101.game_base_on_type) goto L96;
        return false;
    L96:
        if (this.wtimor_game_repel_panel == r101.wtimor_game_repel_panel) goto L98;
        return false;
    L98:
        if (Float.compare(this.anchor_window_threshold, r101.anchor_window_threshold) == 0) goto L100;
        return false;
    L100:
        if (this.wtimor_delete_start_request == r101.wtimor_delete_start_request) goto L102;
        return false;
    L102:
        if (this.audience_game_start_channel == r101.audience_game_start_channel) goto L104;
        return false;
    L104:
        if (this.show_anchor_float_entrance == r101.show_anchor_float_entrance) goto L106;
        return false;
    L106:
        if (this.show_audience_float_entrance == r101.show_audience_float_entrance) goto L108;
        return false;
    L108:
        if (this.allow_auto_show_anchor_panel == r101.allow_auto_show_anchor_panel) goto L110;
        return false;
    L110:
        if (this.allow_auto_show_audience_panel == r101.allow_auto_show_audience_panel) goto L112;
        return false;
    L112:
        if (this.anchor_panel_limit_frequency == r101.anchor_panel_limit_frequency) goto L114;
        return false;
    L114:
        if (this.audience_panel_limit_frequency == r101.audience_panel_limit_frequency) goto L116;
        return false;
    L116:
        if (this.allow_panel_transparency == r101.allow_panel_transparency) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.float_entrance_style, r101.float_entrance_style) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.lynx_channel, r101.lynx_channel) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.effect_channel, r101.effect_channel) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.anchor_effect_resource_url, r101.anchor_effect_resource_url) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.audience_effect_resource_url, r101.audience_effect_resource_url) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.audience_effect_resource_version, r101.audience_effect_resource_version) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.lynx_resource_business_version, r101.lynx_resource_business_version) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.anchor_lynx_resource_url, r101.anchor_lynx_resource_url) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.audience_lynx_resource_url, r101.audience_lynx_resource_url) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.min_support_version, r101.min_support_version) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.lynx_fallback_url, r101.lynx_fallback_url) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.resource_access_key, r101.resource_access_key) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.float_entrance_channel, r101.float_entrance_channel) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.gameDynamicResources, r101.gameDynamicResources) == true) goto L148;
        return false;
    L148:
        if (this.useSZLiveGameFramework == r101.useSZLiveGameFramework) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.linkMicTagImages, r101.linkMicTagImages) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.interactGameTitle, r101.interactGameTitle) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.interactGameImage, r101.interactGameImage) == true) goto L156;
        return false;
    L156:
        if (this.innerGame == r101.innerGame) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.textIntro, r101.textIntro) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.developer, r101.developer) == true) goto L164;
        return false;
    L164:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.sensitivityTip, r101.sensitivityTip) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.mediaIntro, r101.mediaIntro) == true) goto L170;
        return false;
    L170:
        if (this.businessType == r101.businessType) goto L172;
        return false;
    L172:
        if (this.anchorRatio == r101.anchorRatio) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.anchorRatioV2, r101.anchorRatioV2) == true) goto L176;
        return false;
    L176:
        if (Intrinsics.areEqual(this.supportiveEntrance, r101.supportiveEntrance) == true) goto L178;
        return false;
    L178:
        if (Intrinsics.areEqual(this.gameCardInfo, r101.gameCardInfo) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L182;
        return false;
    L182:
        if (Intrinsics.areEqual(this.chatroomScreencastConfig, r101.chatroomScreencastConfig) == true) goto L184;
        return false;
    L184:
        if (Intrinsics.areEqual(this.singleScreencastConfig, r101.singleScreencastConfig) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.gameEngineInfo, r101.gameEngineInfo) == true) goto L188;
        return false;
    L188:
        if (this.gameMultiPlayerType == r101.gameMultiPlayerType) goto L190;
        return false;
    L190:
        if (this.dynamicInteractId == r101.dynamicInteractId) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.playRule, r101.playRule) == true) goto L194;
        return false;
    L194:
        if (Intrinsics.areEqual(this.microGameInfo, r101.microGameInfo) == true) goto L295;
        return false;
    L295:
        return true;
    L196:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v103, types: [int] */
    /* JADX WARN: Type inference failed for: r1v106, types: [int] */
    /* JADX WARN: Type inference failed for: r1v108, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v112, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v251 */
    /* JADX WARN: Type inference failed for: r1v252 */
    /* JADX WARN: Type inference failed for: r1v253 */
    /* JADX WARN: Type inference failed for: r1v254 */
    /* JADX WARN: Type inference failed for: r1v255 */
    /* JADX WARN: Type inference failed for: r1v258 */
    /* JADX WARN: Type inference failed for: r1v259 */
    /* JADX WARN: Type inference failed for: r1v260 */
    /* JADX WARN: Type inference failed for: r1v261 */
    /* JADX WARN: Type inference failed for: r1v267 */
    /* JADX WARN: Type inference failed for: r1v268 */
    /* JADX WARN: Type inference failed for: r1v269 */
    /* JADX WARN: Type inference failed for: r1v271 */
    /* JADX WARN: Type inference failed for: r1v280 */
    /* JADX WARN: Type inference failed for: r1v285 */
    /* JADX WARN: Type inference failed for: r1v288 */
    /* JADX WARN: Type inference failed for: r1v289 */
    /* JADX WARN: Type inference failed for: r1v290 */
    /* JADX WARN: Type inference failed for: r1v291 */
    /* JADX WARN: Type inference failed for: r1v292 */
    /* JADX WARN: Type inference failed for: r1v293 */
    /* JADX WARN: Type inference failed for: r1v294 */
    /* JADX WARN: Type inference failed for: r1v295 */
    /* JADX WARN: Type inference failed for: r1v296 */
    /* JADX WARN: Type inference failed for: r1v297 */
    /* JADX WARN: Type inference failed for: r1v298 */
    /* JADX WARN: Type inference failed for: r1v299 */
    /* JADX WARN: Type inference failed for: r1v300 */
    /* JADX WARN: Type inference failed for: r1v301 */
    /* JADX WARN: Type inference failed for: r1v302 */
    /* JADX WARN: Type inference failed for: r1v54, types: [int] */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /* JADX WARN: Type inference failed for: r1v61, types: [int] */
    /* JADX WARN: Type inference failed for: r1v63, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82, types: [int] */
    /* JADX WARN: Type inference failed for: r1v84, types: [int] */
    /* JADX WARN: Type inference failed for: r1v86, types: [int] */
    /* JADX WARN: Type inference failed for: r1v89, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final int hashCode() {
        int r100 = this.game_type * 31;
        long r101 = this.game_id;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.game_name;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.open_type;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (((((r106 + r108) * 31) + this.support_players) * 31) + this.orientation) * 31;
        boolean r110 = this.need_game_desc;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L13;
        r112 = 1;
    L13:
        int r113 = (r109 + r112) * 31;
        String r114 = this.game_description_snippet;
        if (r114 == null) goto L16;
        int r115 = r114.hashCode();
    L17:
        int r116 = (r113 + r115) * 31;
        String r117 = this.game_cover;
        if (r117 == null) goto L20;
        int r118 = r117.hashCode();
    L21:
        int r119 = (r116 + r118) * 31;
        String r120 = this.game_video;
        if (r120 == null) goto L24;
        int r121 = r120.hashCode();
    L25:
        int r122 = (r119 + r121) * 31;
        String r123 = this.game_package;
        if (r123 == null) goto L28;
        int r124 = r123.hashCode();
    L29:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.autodownload;
        ?? r127 = r126;
        if (r126 == false) goto L32;
        r127 = 1;
    L32:
        int r128 = (((r125 + r127) * 31) + this.loading_time) * 31;
        String r129 = this.loading_text;
        if (r129 == null) goto L35;
        int r130 = r129.hashCode();
    L36:
        int r131 = (r128 + r130) * 31;
        String r132 = this.ab_param_key;
        if (r132 == null) goto L39;
        int r133 = r132.hashCode();
    L40:
        int r134 = (r131 + r133) * 31;
        List<String> r135 = this.url_prefix;
        if (r135 == null) goto L43;
        int r136 = r135.hashCode();
    L44:
        int r137 = (((r134 + r136) * 31) + this.repelPanel) * 31;
        List<Integer> r138 = this.supportLiveScene;
        if (r138 == null) goto L47;
        int r139 = r138.hashCode();
    L48:
        int r140 = (r137 + r139) * 31;
        List<Integer> r141 = this.supportChatRoomType;
        if (r141 == null) goto L51;
        int r142 = r141.hashCode();
    L52:
        int r143 = (r140 + r142) * 31;
        List<Integer> r144 = this.supportLiveMode;
        if (r144 == null) goto L55;
        int r145 = r144.hashCode();
    L56:
        int r146 = (((r143 + r145) * 31) + this.supportLiveRole) * 31;
        List<Integer> r147 = this.supportLiveRoleV2;
        if (r147 == null) goto L59;
        int r148 = r147.hashCode();
    L60:
        int r149 = (r146 + r148) * 31;
        String r150 = this.bigCover;
        if (r150 == null) goto L63;
        int r151 = r150.hashCode();
    L64:
        int r152 = (r149 + r151) * 31;
        boolean r153 = this.audience_show_loading;
        ?? r154 = r153;
        if (r153 == false) goto L67;
        r154 = 1;
    L67:
        int r155 = (r152 + r154) * 31;
        String r156 = this.audience_loading_text;
        if (r156 == null) goto L70;
        int r157 = r156.hashCode();
    L71:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.need_show_rematch_entrance;
        ?? r160 = r159;
        if (r159 == false) goto L74;
        r160 = 1;
    L74:
        int r161 = (r158 + r160) * 31;
        boolean r162 = this.need_local_mix_stream;
        ?? r163 = r162;
        if (r162 == false) goto L77;
        r163 = 1;
    L77:
        int r164 = (r161 + r163) * 31;
        boolean r165 = this.hide_user_entrance;
        ?? r166 = r165;
        if (r165 == false) goto L80;
        r166 = 1;
    L80:
        int r167 = (r164 + r166) * 31;
        c r168 = this.bubble_config;
        if (r168 == null) goto L83;
        int r169 = r168.hashCode();
    L84:
        int r170 = (r167 + r169) * 31;
        com.bytedance.android.live.broadcastgame.api.model.a r171 = this.breathing_light_config;
        if (r171 == null) goto L87;
        int r172 = r171.hashCode();
    L88:
        int r173 = (r170 + r172) * 31;
        j0 r174 = this.red_dot_config;
        if (r174 == null) goto L91;
        int r175 = r174.hashCode();
    L92:
        int r176 = (r173 + r175) * 31;
        String r177 = this.game_identifier;
        if (r177 == null) goto L95;
        int r178 = r177.hashCode();
    L96:
        long r179 = this.effect_id;
        int r180 = (((r176 + r178) * 31) + ((int) (r179 ^ (r179 >>> 32)))) * 31;
        String r181 = this.guide_name;
        if (r181 == null) goto L99;
        int r182 = r181.hashCode();
    L100:
        int r183 = (((r180 + r182) * 31) + this.guide_show_count) * 31;
        boolean r184 = this.loadgame_when_guide;
        ?? r185 = r184;
        if (r184 == false) goto L103;
        r185 = 1;
    L103:
        int r186 = (r183 + r185) * 31;
        boolean r187 = this.need_beat;
        ?? r188 = r187;
        if (r187 == false) goto L106;
        r188 = 1;
    L106:
        int r189 = (r186 + r188) * 31;
        boolean r190 = this.need_bgmusic;
        ?? r191 = r190;
        if (r190 == false) goto L109;
        r191 = 1;
    L109:
        int r192 = (((r189 + r191) * 31) + this.support_mode) * 31;
        boolean r193 = this.support_effect_mix_stream;
        ?? r194 = r193;
        if (r193 == false) goto L112;
        r194 = 1;
    L112:
        long r195 = this.wmini_game_ttid;
        int r196 = (((r192 + r194) * 31) + ((int) (r195 ^ (r195 >>> 32)))) * 31;
        String r197 = this.wmini_game_id;
        if (r197 == null) goto L115;
        int r198 = r197.hashCode();
    L116:
        int r199 = (r196 + r198) * 31;
        String r200 = this.loading_bg_url;
        if (r200 == null) goto L119;
        int r201 = r200.hashCode();
    L120:
        int r202 = (((((((((r199 + r201) * 31) + this.wmini_game_matching_players) * 31) + this.game_base_on_type) * 31) + this.wtimor_game_repel_panel) * 31) + Float.floatToIntBits(this.anchor_window_threshold)) * 31;
        boolean r203 = this.wtimor_delete_start_request;
        ?? r204 = r203;
        if (r203 == false) goto L123;
        r204 = 1;
    L123:
        long r205 = this.audience_game_start_channel;
        int r206 = (((r202 + r204) * 31) + ((int) (r205 ^ (r205 >>> 32)))) * 31;
        boolean r207 = this.show_anchor_float_entrance;
        ?? r208 = r207;
        if (r207 == false) goto L126;
        r208 = 1;
    L126:
        int r209 = (r206 + r208) * 31;
        boolean r210 = this.show_audience_float_entrance;
        ?? r211 = r210;
        if (r210 == false) goto L129;
        r211 = 1;
    L129:
        int r212 = (r209 + r211) * 31;
        boolean r213 = this.allow_auto_show_anchor_panel;
        ?? r214 = r213;
        if (r213 == false) goto L132;
        r214 = 1;
    L132:
        int r215 = (r212 + r214) * 31;
        boolean r216 = this.allow_auto_show_audience_panel;
        ?? r217 = r216;
        if (r216 == false) goto L135;
        r217 = 1;
    L135:
        int r218 = (((((r215 + r217) * 31) + this.anchor_panel_limit_frequency) * 31) + this.audience_panel_limit_frequency) * 31;
        boolean r219 = this.allow_panel_transparency;
        if (r219 == true) goto L139;
        r111 = r219;
    L139:
        int r220 = (r218 + r111) * 31;
        FloatEntranceStyle r221 = this.float_entrance_style;
        if (r221 == null) goto L142;
        int r222 = r221.hashCode();
    L143:
        int r223 = (r220 + r222) * 31;
        String r224 = this.lynx_channel;
        if (r224 == null) goto L146;
        int r225 = r224.hashCode();
    L147:
        int r226 = (r223 + r225) * 31;
        String r227 = this.effect_channel;
        if (r227 == null) goto L150;
        int r228 = r227.hashCode();
    L151:
        int r229 = (r226 + r228) * 31;
        String r230 = this.anchor_effect_resource_url;
        if (r230 == null) goto L154;
        int r231 = r230.hashCode();
    L155:
        int r232 = (r229 + r231) * 31;
        String r233 = this.audience_effect_resource_url;
        if (r233 == null) goto L158;
        int r234 = r233.hashCode();
    L159:
        int r235 = (r232 + r234) * 31;
        String r236 = this.audience_effect_resource_version;
        if (r236 == null) goto L162;
        int r237 = r236.hashCode();
    L163:
        int r238 = (r235 + r237) * 31;
        String r239 = this.lynx_resource_business_version;
        if (r239 == null) goto L166;
        int r240 = r239.hashCode();
    L167:
        int r241 = (r238 + r240) * 31;
        String r242 = this.anchor_lynx_resource_url;
        if (r242 == null) goto L170;
        int r243 = r242.hashCode();
    L171:
        int r244 = (r241 + r243) * 31;
        String r245 = this.audience_lynx_resource_url;
        if (r245 == null) goto L174;
        int r246 = r245.hashCode();
    L175:
        int r247 = (r244 + r246) * 31;
        d0 r248 = this.min_support_version;
        if (r248 == null) goto L178;
        int r249 = r248.hashCode();
    L179:
        int r250 = (r247 + r249) * 31;
        a0 r251 = this.lynx_fallback_url;
        if (r251 == null) goto L182;
        int r252 = r251.hashCode();
    L183:
        int r253 = (r250 + r252) * 31;
        String r254 = this.resource_access_key;
        if (r254 == null) goto L186;
        int r255 = r254.hashCode();
    L187:
        int r256 = (r253 + r255) * 31;
        String r257 = this.float_entrance_channel;
        if (r257 == null) goto L190;
        int r258 = r257.hashCode();
    L191:
        int r259 = (r256 + r258) * 31;
        String r260 = this.schema;
        if (r260 == null) goto L194;
        int r261 = r260.hashCode();
    L195:
        int r262 = (r259 + r261) * 31;
        HashMap<String, String> r263 = this.gameDynamicResources;
        if (r263 == null) goto L198;
        int r264 = r263.hashCode();
    L199:
        int r265 = (((r262 + r264) * 31) + this.useSZLiveGameFramework) * 31;
        HashMap<String, String> r266 = this.linkMicTagImages;
        if (r266 == null) goto L202;
        int r267 = r266.hashCode();
    L203:
        int r268 = (r265 + r267) * 31;
        String r269 = this.interactGameTitle;
        if (r269 == null) goto L206;
        int r270 = r269.hashCode();
    L207:
        int r271 = (r268 + r270) * 31;
        String r272 = this.interactGameImage;
        if (r272 == null) goto L210;
        int r273 = r272.hashCode();
    L211:
        int r274 = (((r271 + r273) * 31) + this.innerGame) * 31;
        String r275 = this.appId;
        if (r275 == null) goto L214;
        int r276 = r275.hashCode();
    L215:
        int r277 = (r274 + r276) * 31;
        String r278 = this.textIntro;
        if (r278 == null) goto L218;
        int r279 = r278.hashCode();
    L219:
        int r280 = (r277 + r279) * 31;
        String r281 = this.developer;
        if (r281 == null) goto L222;
        int r282 = r281.hashCode();
    L223:
        int r283 = (r280 + r282) * 31;
        String r284 = this.appVersion;
        if (r284 == null) goto L226;
        int r285 = r284.hashCode();
    L227:
        int r286 = (r283 + r285) * 31;
        List<String> r287 = this.sensitivityTip;
        if (r287 == null) goto L230;
        int r288 = r287.hashCode();
    L231:
        int r289 = (r286 + r288) * 31;
        List<b0> r290 = this.mediaIntro;
        if (r290 == null) goto L234;
        int r291 = r290.hashCode();
    L235:
        int r292 = (((((r289 + r291) * 31) + this.businessType) * 31) + this.anchorRatio) * 31;
        String r293 = this.anchorRatioV2;
        if (r293 == null) goto L238;
        int r294 = r293.hashCode();
    L239:
        int r295 = (r292 + r294) * 31;
        List<Long> r296 = this.supportiveEntrance;
        if (r296 == null) goto L242;
        int r297 = r296.hashCode();
    L243:
        int r298 = (r295 + r297) * 31;
        String r299 = this.gameCardInfo;
        if (r299 == null) goto L246;
        int r300 = r299.hashCode();
    L247:
        int r301 = (r298 + r300) * 31;
        String r302 = this.desc;
        if (r302 == null) goto L250;
        int r303 = r302.hashCode();
    L251:
        int r304 = (r301 + r303) * 31;
        d r305 = this.chatroomScreencastConfig;
        if (r305 == null) goto L254;
        int r306 = r305.hashCode();
    L255:
        int r307 = (r304 + r306) * 31;
        p0 r308 = this.singleScreencastConfig;
        if (r308 == null) goto L258;
        int r309 = r308.hashCode();
    L259:
        int r310 = (r307 + r309) * 31;
        g r311 = this.gameEngineInfo;
        if (r311 == null) goto L262;
        int r312 = r311.hashCode();
    L263:
        int r313 = (((((r310 + r312) * 31) + this.gameMultiPlayerType) * 31) + this.dynamicInteractId) * 31;
        String r314 = this.playRule;
        if (r314 == null) goto L266;
        int r315 = r314.hashCode();
    L267:
        int r316 = (r313 + r315) * 31;
        c0 r317 = this.microGameInfo;
        if (r317 == null) goto L271;
        r104 = r317.hashCode();
    L271:
        return r316 + r104;
    L266:
        r315 = 0;
        goto L267
    L262:
        r312 = 0;
        goto L263
    L258:
        r309 = 0;
        goto L259
    L254:
        r306 = 0;
        goto L255
    L250:
        r303 = 0;
        goto L251
    L246:
        r300 = 0;
        goto L247
    L242:
        r297 = 0;
        goto L243
    L238:
        r294 = 0;
        goto L239
    L234:
        r291 = 0;
        goto L235
    L230:
        r288 = 0;
        goto L231
    L226:
        r285 = 0;
        goto L227
    L222:
        r282 = 0;
        goto L223
    L218:
        r279 = 0;
        goto L219
    L214:
        r276 = 0;
        goto L215
    L210:
        r273 = 0;
        goto L211
    L206:
        r270 = 0;
        goto L207
    L202:
        r267 = 0;
        goto L203
    L198:
        r264 = 0;
        goto L199
    L194:
        r261 = 0;
        goto L195
    L190:
        r258 = 0;
        goto L191
    L186:
        r255 = 0;
        goto L187
    L182:
        r252 = 0;
        goto L183
    L178:
        r249 = 0;
        goto L179
    L174:
        r246 = 0;
        goto L175
    L170:
        r243 = 0;
        goto L171
    L166:
        r240 = 0;
        goto L167
    L162:
        r237 = 0;
        goto L163
    L158:
        r234 = 0;
        goto L159
    L154:
        r231 = 0;
        goto L155
    L150:
        r228 = 0;
        goto L151
    L146:
        r225 = 0;
        goto L147
    L142:
        r222 = 0;
        goto L143
    L119:
        r201 = 0;
        goto L120
    L115:
        r198 = 0;
        goto L116
    L99:
        r182 = 0;
        goto L100
    L95:
        r178 = 0;
        goto L96
    L91:
        r175 = 0;
        goto L92
    L87:
        r172 = 0;
        goto L88
    L83:
        r169 = 0;
        goto L84
    L70:
        r157 = 0;
        goto L71
    L63:
        r151 = 0;
        goto L64
    L59:
        r148 = 0;
        goto L60
    L55:
        r145 = 0;
        goto L56
    L51:
        r142 = 0;
        goto L52
    L47:
        r139 = 0;
        goto L48
    L43:
        r136 = 0;
        goto L44
    L39:
        r133 = 0;
        goto L40
    L35:
        r130 = 0;
        goto L36
    L28:
        r124 = 0;
        goto L29
    L24:
        r121 = 0;
        goto L25
    L20:
        r118 = 0;
        goto L21
    L16:
        r115 = 0;
        goto L17
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractGameExtra(game_type=" + this.game_type + ", game_id=" + this.game_id + ", game_name=" + this.game_name + ", open_type=" + this.open_type + ", support_players=" + this.support_players + ", orientation=" + this.orientation + ", need_game_desc=" + this.need_game_desc + ", game_description_snippet=" + this.game_description_snippet + ", game_cover=" + this.game_cover + ", game_video=" + this.game_video + ", game_package=" + this.game_package + ", autodownload=" + this.autodownload + ", loading_time=" + this.loading_time + ", loading_text=" + this.loading_text + ", ab_param_key=" + this.ab_param_key + ", url_prefix=" + this.url_prefix + ", repelPanel=" + this.repelPanel + ", supportLiveScene=" + this.supportLiveScene + ", supportChatRoomType=" + this.supportChatRoomType + ", supportLiveMode=" + this.supportLiveMode + ", supportLiveRole=" + this.supportLiveRole + ", supportLiveRoleV2=" + this.supportLiveRoleV2 + ", bigCover=" + this.bigCover + ", audience_show_loading=" + this.audience_show_loading + ", audience_loading_text=" + this.audience_loading_text + ", need_show_rematch_entrance=" + this.need_show_rematch_entrance + ", need_local_mix_stream=" + this.need_local_mix_stream + ", hide_user_entrance=" + this.hide_user_entrance + ", bubble_config=" + this.bubble_config + ", breathing_light_config=" + this.breathing_light_config + ", red_dot_config=" + this.red_dot_config + ", game_identifier=" + this.game_identifier + ", effect_id=" + this.effect_id + ", guide_name=" + this.guide_name + ", guide_show_count=" + this.guide_show_count + ", loadgame_when_guide=" + this.loadgame_when_guide + ", need_beat=" + this.need_beat + ", need_bgmusic=" + this.need_bgmusic + ", support_mode=" + this.support_mode + ", support_effect_mix_stream=" + this.support_effect_mix_stream + ", wmini_game_ttid=" + this.wmini_game_ttid + ", wmini_game_id=" + this.wmini_game_id + ", loading_bg_url=" + this.loading_bg_url + ", wmini_game_matching_players=" + this.wmini_game_matching_players + ", game_base_on_type=" + this.game_base_on_type + ", wtimor_game_repel_panel=" + this.wtimor_game_repel_panel + ", anchor_window_threshold=" + this.anchor_window_threshold + ", wtimor_delete_start_request=" + this.wtimor_delete_start_request + ", audience_game_start_channel=" + this.audience_game_start_channel + ", show_anchor_float_entrance=" + this.show_anchor_float_entrance + ", show_audience_float_entrance=" + this.show_audience_float_entrance + ", allow_auto_show_anchor_panel=" + this.allow_auto_show_anchor_panel + ", allow_auto_show_audience_panel=" + this.allow_auto_show_audience_panel + ", anchor_panel_limit_frequency=" + this.anchor_panel_limit_frequency + ", audience_panel_limit_frequency=" + this.audience_panel_limit_frequency + ", allow_panel_transparency=" + this.allow_panel_transparency + ", float_entrance_style=" + this.float_entrance_style + ", lynx_channel=" + this.lynx_channel + ", effect_channel=" + this.effect_channel + ", anchor_effect_resource_url=" + this.anchor_effect_resource_url + ", audience_effect_resource_url=" + this.audience_effect_resource_url + ", audience_effect_resource_version=" + this.audience_effect_resource_version + ", lynx_resource_business_version=" + this.lynx_resource_business_version + ", anchor_lynx_resource_url=" + this.anchor_lynx_resource_url + ", audience_lynx_resource_url=" + this.audience_lynx_resource_url + ", min_support_version=" + this.min_support_version + ", lynx_fallback_url=" + this.lynx_fallback_url + ", resource_access_key=" + this.resource_access_key + ", float_entrance_channel=" + this.float_entrance_channel + ", schema=" + this.schema + ", gameDynamicResources=" + this.gameDynamicResources + ", useSZLiveGameFramework=" + this.useSZLiveGameFramework + ", linkMicTagImages=" + this.linkMicTagImages + ", interactGameTitle=" + this.interactGameTitle + ", interactGameImage=" + this.interactGameImage + ", innerGame=" + this.innerGame + ", appId=" + this.appId + ", textIntro=" + this.textIntro + ", developer=" + this.developer + ", appVersion=" + this.appVersion + ", sensitivityTip=" + this.sensitivityTip + ", mediaIntro=" + this.mediaIntro + ", businessType=" + this.businessType + ", anchorRatio=" + this.anchorRatio + ", anchorRatioV2=" + this.anchorRatioV2 + ", supportiveEntrance=" + this.supportiveEntrance + ", gameCardInfo=" + this.gameCardInfo + ", desc=" + this.desc + ", chatroomScreencastConfig=" + this.chatroomScreencastConfig + ", singleScreencastConfig=" + this.singleScreencastConfig + ", gameEngineInfo=" + this.gameEngineInfo + ", gameMultiPlayerType=" + this.gameMultiPlayerType + ", dynamicInteractId=" + this.dynamicInteractId + ", playRule=" + this.playRule + ", microGameInfo=" + this.microGameInfo + ")";
    }

    public final String A() {
        return this.playRule;
    }

    public final j0 B() {
        return this.red_dot_config;
    }

    public final String C() {
        return this.schema;
    }

    public final List<String> D() {
        return this.sensitivityTip;
    }

    public final boolean E() {
        return this.show_audience_float_entrance;
    }

    public final p0 F() {
        return this.singleScreencastConfig;
    }

    public final int G() {
        return this.supportLiveRole;
    }

    public final List<Integer> H() {
        return this.supportLiveScene;
    }

    public final boolean I() {
        return this.support_effect_mix_stream;
    }

    public final int J() {
        return this.support_mode;
    }

    public final String K() {
        return this.textIntro;
    }

    public final List<String> L() {
        return this.url_prefix;
    }

    public final String a() {
        return this.anchorRatioV2;
    }

    public final String b() {
        return this.appId;
    }

    public final String c() {
        return this.appVersion;
    }

    public final boolean d() {
        return this.autodownload;
    }

    public final com.bytedance.android.live.broadcastgame.api.model.a e() {
        return this.breathing_light_config;
    }

    public final c f() {
        return this.bubble_config;
    }

    public final int g() {
        return this.businessType;
    }

    public final d h() {
        return this.chatroomScreencastConfig;
    }

    public final String i() {
        return this.desc;
    }

    public final String j() {
        return this.developer;
    }

    public final int k() {
        return this.dynamicInteractId;
    }

    public final long l() {
        return this.effect_id;
    }

    public final String m() {
        return this.gameCardInfo;
    }

    public final g n() {
        return this.gameEngineInfo;
    }

    public final int o() {
        return this.game_base_on_type;
    }

    public final long p() {
        return this.game_id;
    }

    public final String q() {
        return this.game_name;
    }

    public final int r() {
        return this.game_type;
    }

    public final String s() {
        return this.guide_name;
    }

    public final int t() {
        return this.guide_show_count;
    }

    public final boolean u() {
        return this.hide_user_entrance;
    }

    public final boolean v() {
        return this.loadgame_when_guide;
    }

    public final List<b0> w() {
        return this.mediaIntro;
    }

    public final c0 x() {
        return this.microGameInfo;
    }

    public final boolean y() {
        return this.need_beat;
    }

    public final boolean z() {
        return this.need_bgmusic;
    }
}
