package com.bytedance.android.live.broadcast.api.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.model.component.BottomToolBarComponent;
import com.bytedance.android.live.broadcast.api.model.component.CategoryComponent;
import com.bytedance.android.live.broadcast.api.model.component.ComponentConfig;
import com.bytedance.android.live.broadcast.api.model.component.CreateButtonComponent;
import com.bytedance.android.live.broadcast.api.model.component.CustomerServiceComponent;
import com.bytedance.android.live.broadcast.api.model.component.LiveTopicComponent;
import com.bytedance.android.live.broadcast.api.model.component.TopAreaComponent;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemDotInfo;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.CreateInfoResponse.CreateInfo")
@Metadata(d1 = {"\u0000Ò\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001:(Å\u0001Æ\u0001Ç\u0001È\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001Ø\u0001B\b¢\u0006\u0005\bÄ\u0001\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0016\u0010\r\u0012\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0019\u0010\r\u0012\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u001b\u0010\r\u0012\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b \u0010\n\u0012\u0004\b!\u0010\u0018R\u001e\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\"\u0010\r\u0012\u0004\b#\u0010\u0018R\u001c\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b$\u0010\u0014\u0012\u0004\b%\u0010\u0018R\u0016\u0010&\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\nR\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u00105R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u00105R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010\rR\u0018\u0010@\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b@\u0010\u001fR\u0016\u0010A\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010\u0014R\u0016\u0010B\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u00102R\u0016\u0010C\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020D038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u00105R\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bM\u00105R\u0016\u0010N\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bN\u0010\u0014R$\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020O\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bP\u0010-R\u0016\u0010Q\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bQ\u00102R\u0018\u0010R\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bR\u0010\rR\u0016\u0010S\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bS\u0010\u0014R\u0016\u0010T\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010\u0014R\u0016\u0010U\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bU\u00102R\u0016\u0010V\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bV\u0010\u0014R\u0016\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bW\u0010\rR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\be\u0010fR$\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bg\u0010-R\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bk\u0010\nR\u0016\u0010l\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bl\u0010\nR\u0016\u0010m\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bm\u0010\nR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bq\u0010\nR\u0016\u0010r\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\br\u00102R\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\by\u0010\u0014R\u0018\u0010z\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bz\u0010\rR\u0018\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R7\u0010\u0088\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010*8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b\u0088\u0001\u0010-\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R,\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R,\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R,\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R,\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001¨\u0006Ù\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo;", "", "Lcom/bytedance/android/live/broadcast/api/model/j1;", "settingPrompt", "Lcom/bytedance/android/live/broadcast/api/model/j1;", "Lcom/bytedance/android/live/base/model/ImageModel;", "mCover", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "mCoverAuditStatus", "J", "", "mTitle", "Ljava/lang/String;", "mPrompt", "Lcom/bytedance/android/live/broadcast/api/model/q;", "mBroadcastConfig", "Lcom/bytedance/android/live/broadcast/api/model/q;", "", "mIsFirstBroadcastFlag", "I", "mAnchorPromptType", "blockMsgTitle", "getBlockMsgTitle$annotations", "()V", "mBlockSchema", "getMBlockSchema$annotations", "mBlockSchemaNew", "getMBlockSchemaNew$annotations", "", "isShowUserCard", "Ljava/lang/Boolean;", "unblockTime", "getUnblockTime$annotations", "unblockPrompt", "getUnblockPrompt$annotations", "mBlockStatus", "getMBlockStatus$annotations", "mAutoCover", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$c;", "mAnchorFansInfo", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$c;", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$p;", "pushStreamInfoMap", "Ljava/util/Map;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$e;", "mAnchorInfoBarData", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$e;", "mPCLivePermissionStatus", "Z", "", "mAutoCloseIntervalList", "Ljava/util/List;", "mAutoCloseInterval", "Ljava/lang/Long;", "defaultSyncToXT", "Lcom/bytedance/android/live/broadcast/api/model/a0;", "mLinkmicSetting", "mLinkmicSceneHasEverOpen", "Lcom/bytedance/android/live/broadcast/api/model/f1;", "mCircleInfo", "Lcom/bytedance/android/live/broadcast/api/model/f1;", "localAdsSchema", "localAdsUserTag", "mNewAnchorFlag", "isMedia", "isGov", "Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", ReportCardMonitorPlugin.CATEGORIES, "Lcom/bytedance/android/live/broadcast/api/model/t0;", "obsAuditStatus", "Lcom/bytedance/android/live/broadcast/api/model/t0;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$b;", "activityBanner", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$b;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$i;", "blockInfo", "interceptStrategy", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "bubbleInfo", "allowCreateLive", "userVerifiedType", "audienceDisplayType", "commodityNoFilter", "isCommodityNoFilterDefaultOpen", "startLiveVisibilityRange", "firstMessageId", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$o;", "publicAreaConfig", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$o;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$d;", "anchorInfo", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$d;", "Lcom/bytedance/android/live/broadcast/api/model/p;", "audienceLinkmicInfo", "Lcom/bytedance/android/live/broadcast/api/model/p;", "Lcom/bytedance/android/live/broadcast/api/model/e0;", "disableInfo", "Lcom/bytedance/android/live/broadcast/api/model/e0;", "Lcom/bytedance/android/live/broadcast/api/model/u;", "configInfo", "Lcom/bytedance/android/live/broadcast/api/model/u;", "customPushStreamInfoMap", "Lcom/bytedance/android/live/broadcast/api/model/d1;", "replaySetting", "Lcom/bytedance/android/live/broadcast/api/model/d1;", "douCoinCount", "urgeCount", "anchorRankHourSetting", "Lcom/bytedance/android/live/broadcast/api/model/c1;", "previewStream", "Lcom/bytedance/android/live/broadcast/api/model/c1;", "bookCount", "isVIP", "Lcom/bytedance/android/live/broadcast/api/model/o1;", "starInfo", "Lcom/bytedance/android/live/broadcast/api/model/o1;", "Lcom/bytedance/android/live/broadcast/api/model/v0;", "paidLiveInfo", "Lcom/bytedance/android/live/broadcast/api/model/v0;", "pcLivePermissionApplyStatus", "pcLivePermissionApplyButtonText", "Lcom/bytedance/android/live/broadcast/api/model/d0;", "desireInfo", "Lcom/bytedance/android/live/broadcast/api/model/d0;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$m;", "fansClubConfig", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$m;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$l;", "createPageConfig", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$l;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$f;", "anchorMonitorInfo", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$f;", "Lcom/bytedance/android/live/broadcast/api/model/component/ComponentConfig;", "componentConfig", "getComponentConfig", "()Ljava/util/Map;", "setComponentConfig", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "topAreaComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "getTopAreaComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "setTopAreaComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "customerServiceComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "getCustomerServiceComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "setCustomerServiceComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "createButtonComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "getCreateButtonComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "setCreateButtonComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/b;", "createModeComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/b;", "getCreateModeComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/b;", "setCreateModeComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/b;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "bottomToolBarComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "getBottomToolBarComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "setBottomToolBarComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "categoryComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "getCategoryComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "setCategoryComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "liveTopicComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "getLiveTopicComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "setLiveTopicComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/b;", "activityDeclaration", "Lcom/bytedance/android/live/broadcast/api/model/b;", "Lcom/bytedance/android/live/broadcast/api/model/RoomIntroInfo;", "roomIntroInfo", "Lcom/bytedance/android/live/broadcast/api/model/RoomIntroInfo;", "<init>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AICoverProduceStatusEnum", "AICoverSourceEnum", "b", "c", "d", "e", "f", ce.f26391f, "h", RXScreenCaptureService.KEY_INDEX, ce.f26395j, ce.f26396k, "l", "m", OfficeSDKRequestTag.KEY_NEW_USER, "LiveTabEnum", "o", "p", "q", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCreateInfo implements vh7.h {

    @SerializedName("activity")
    public b activityBanner;

    @IgnoreProtoFieldCheck
    @SerializedName("activity_declaration")
    public com.bytedance.android.live.broadcast.api.model.b activityDeclaration;

    @SerializedName("is_not_block_create_global")
    public boolean allowCreateLive;

    @SerializedName("anchor_info")
    public d anchorInfo;

    @SerializedName("anchor_monitor_info")
    public f anchorMonitorInfo;

    @SerializedName("rank_anchor_hour")
    public long anchorRankHourSetting;

    @SerializedName("audience_display_type")
    public int audienceDisplayType;

    @SerializedName("audience_linkmic_info")
    public com.bytedance.android.live.broadcast.api.model.p audienceLinkmicInfo;

    @SerializedName("block_info")
    public List<i> blockInfo;

    @SerializedName("block_prompt")
    public String blockMsgTitle;

    @SerializedName("book_count")
    public long bookCount;

    @SerializedName("bottom_toolbar_component")
    protected BottomToolBarComponent bottomToolBarComponent;

    @SerializedName("bubble_info")
    public Map<String, ItemBubbleInfo> bubbleInfo;

    @SerializedName("category_node")
    public List<CategoryNode> categories;

    @SerializedName("category_component")
    protected CategoryComponent categoryComponentConfig;

    @SerializedName("commodity_no_filter")
    public int commodityNoFilter;

    @SerializedName("component_config")
    protected Map<Integer, ComponentConfig> componentConfig;

    @SerializedName("config_info")
    public u configInfo;

    @SerializedName("create_button_component")
    protected CreateButtonComponent createButtonComponentConfig;

    @SerializedName("create_mode_component")
    protected com.bytedance.android.live.broadcast.api.model.component.b createModeComponentConfig;

    @SerializedName("create_page_config")
    public l createPageConfig;

    @IgnoreProtoFieldCheck
    @SerializedName("custom_push_stream_info")
    public Map<Long, p> customPushStreamInfoMap;

    @SerializedName("customer_service_component")
    protected CustomerServiceComponent customerServiceComponent;

    @SerializedName("default_sync_to_xt")
    public boolean defaultSyncToXT;

    @SerializedName("desire_info")
    public d0 desireInfo;

    @SerializedName("disable_info")
    public e0 disableInfo;

    @SerializedName("dou_coin_count")
    public long douCoinCount;

    @SerializedName("fans_club_config")
    public m fansClubConfig;

    @IgnoreProtoFieldCheck
    @SerializedName("first_message_id")
    public String firstMessageId;

    @SerializedName("live_guide_intercept_strategy")
    public int interceptStrategy;

    @SerializedName("is_commodity_no_filter_default_open")
    public boolean isCommodityNoFilterDefaultOpen;

    @SerializedName("is_gov")
    public boolean isGov;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA)
    public boolean isMedia;

    @SerializedName("is_show_user_card")
    public Boolean isShowUserCard;

    @SerializedName("is_vip")
    public boolean isVIP;

    @SerializedName("live_topic_component")
    protected LiveTopicComponent liveTopicComponent;

    @SerializedName("local_ads_schema")
    public String localAdsSchema;

    @SerializedName("local_ads_user_tag")
    public Boolean localAdsUserTag;

    @SerializedName("anchor_fans_info")
    public c mAnchorFansInfo;

    @SerializedName("anchor_info_bar_data")
    public e mAnchorInfoBarData;

    @SerializedName("anchor_prompt_type")
    public int mAnchorPromptType;

    @SerializedName("auto_close_interval")
    public Long mAutoCloseInterval;

    @SerializedName("auto_close_interval_list")
    public List<Long> mAutoCloseIntervalList;

    @SerializedName("auto_cover")
    public long mAutoCover;

    @SerializedName("block_schema_locale")
    public String mBlockSchema;

    @SerializedName("block_schema")
    public String mBlockSchemaNew;

    @SerializedName("block_status")
    public int mBlockStatus;

    @SerializedName("live_scenario")
    public com.bytedance.android.live.broadcast.api.model.q mBroadcastConfig;

    @SerializedName("circle_info")
    public f1 mCircleInfo;

    @SerializedName("cover")
    public ImageModel mCover;

    @SerializedName("cover_audit_status")
    public long mCoverAuditStatus;

    @SerializedName("never_go_live_flag")
    public int mIsFirstBroadcastFlag;

    @SerializedName("linkmic_scene_has_ever_open")
    public List<Integer> mLinkmicSceneHasEverOpen;

    @SerializedName("linkmic_setting")
    public List<a0> mLinkmicSetting;

    @SerializedName("new_anchor_flag")
    public int mNewAnchorFlag;

    @SerializedName("pc_live_permission_apply")
    public boolean mPCLivePermissionStatus;

    @SerializedName("go_live_prompt")
    public String mPrompt;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("obs_audit_status")
    public t0 obsAuditStatus;

    @SerializedName("paid_live_info")
    public v0 paidLiveInfo;

    @SerializedName("pc_live_permission_apply_button_text")
    public String pcLivePermissionApplyButtonText;

    @SerializedName("pc_live_permission_apply_status")
    public int pcLivePermissionApplyStatus;

    @SerializedName("preview_stream")
    public c1 previewStream;

    @SerializedName("public_area_config")
    public o publicAreaConfig;

    @SerializedName("push_stream_info_map")
    public Map<Long, p> pushStreamInfoMap;

    @SerializedName("replay_setting")
    public d1 replaySetting;

    @SerializedName("room_intro_info")
    public RoomIntroInfo roomIntroInfo;

    @SerializedName("setting_prompt")
    public j1 settingPrompt;

    @SerializedName("starInfo")
    public o1 starInfo;

    @SerializedName("visibility_range")
    public int startLiveVisibilityRange;

    @SerializedName("top_area_component")
    protected TopAreaComponent topAreaComponentConfig;

    @SerializedName("auto_un_block_prompts")
    public String unblockPrompt;

    @SerializedName("un_block_time")
    public long unblockTime;

    @SerializedName("urge_count")
    public long urgeCount;

    @SerializedName("user_verified_type")
    public String userVerifiedType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$AICoverProduceStatusEnum;", "", "", "value", "I", "getValue", "()I", "NoneProduce", "Producing", "FinishProduce", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AICoverProduceStatusEnum extends Enum<AICoverProduceStatusEnum> {
        public static final AICoverProduceStatusEnum FinishProduce = null;
        public static final AICoverProduceStatusEnum NoneProduce = null;
        public static final AICoverProduceStatusEnum Producing = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AICoverProduceStatusEnum[] f59020a = null;
        private final int value;

        static {
            AICoverProduceStatusEnum r100 = new AICoverProduceStatusEnum("NoneProduce", 0, 0);
            NoneProduce = r100;
            AICoverProduceStatusEnum r101 = new AICoverProduceStatusEnum("Producing", 1, 1);
            Producing = r101;
            AICoverProduceStatusEnum r102 = new AICoverProduceStatusEnum("FinishProduce", 2, 2);
            FinishProduce = r102;
            f59020a = new AICoverProduceStatusEnum[]{r100, r101, r102};
        }

        public static AICoverProduceStatusEnum valueOf(String r100) {
            return (AICoverProduceStatusEnum) r27.a.a(AICoverProduceStatusEnum.class, r100);
        }

        public static AICoverProduceStatusEnum[] values() {
            return (AICoverProduceStatusEnum[]) f59020a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public AICoverProduceStatusEnum(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$AICoverSourceEnum;", "", "", "value", "I", "getValue", "()I", "AvatarSource", "LastCoverSource", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AICoverSourceEnum extends Enum<AICoverSourceEnum> {
        public static final AICoverSourceEnum AvatarSource = null;
        public static final AICoverSourceEnum LastCoverSource = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AICoverSourceEnum[] f59021a = null;
        private final int value;

        static {
            AICoverSourceEnum r100 = new AICoverSourceEnum("AvatarSource", 0, 0);
            AvatarSource = r100;
            AICoverSourceEnum r101 = new AICoverSourceEnum("LastCoverSource", 1, 1);
            LastCoverSource = r101;
            f59021a = new AICoverSourceEnum[]{r100, r101};
        }

        public static AICoverSourceEnum valueOf(String r100) {
            return (AICoverSourceEnum) r27.a.a(AICoverSourceEnum.class, r100);
        }

        public static AICoverSourceEnum[] values() {
            return (AICoverSourceEnum[]) f59021a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public AICoverSourceEnum(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$LiveTabEnum;", "", "", "value", "I", "getValue", "()I", "NopeTab", "NormalTab", "MediaTab", "AudioTab", "ScreenShotTab", "ThirdPartyTab", "LiveAll", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveTabEnum extends Enum<LiveTabEnum> {
        public static final LiveTabEnum AudioTab = null;
        public static final LiveTabEnum LiveAll = null;
        public static final LiveTabEnum MediaTab = null;
        public static final LiveTabEnum NopeTab = null;
        public static final LiveTabEnum NormalTab = null;
        public static final LiveTabEnum ScreenShotTab = null;
        public static final LiveTabEnum ThirdPartyTab = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveTabEnum[] f59022a = null;
        private final int value;

        static {
            LiveTabEnum r100 = new LiveTabEnum("NopeTab", 0, 0);
            NopeTab = r100;
            LiveTabEnum r101 = new LiveTabEnum("NormalTab", 1, 1);
            NormalTab = r101;
            LiveTabEnum r102 = new LiveTabEnum("MediaTab", 2, 1);
            MediaTab = r102;
            LiveTabEnum r103 = new LiveTabEnum("AudioTab", 3, 2);
            AudioTab = r103;
            LiveTabEnum r104 = new LiveTabEnum("ScreenShotTab", 4, 3);
            ScreenShotTab = r104;
            LiveTabEnum r105 = new LiveTabEnum("ThirdPartyTab", 5, 4);
            ThirdPartyTab = r105;
            LiveTabEnum r106 = new LiveTabEnum("LiveAll", 6, 999);
            LiveAll = r106;
            f59022a = new LiveTabEnum[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static LiveTabEnum valueOf(String r100) {
            return (LiveTabEnum) r27.a.a(LiveTabEnum.class, r100);
        }

        public static LiveTabEnum[] values() {
            return (LiveTabEnum[]) f59022a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveTabEnum(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @ProtoMessage("webcast.api.room.AICoverInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$a;", "", "", "status", "Ljava/lang/Integer;", "source", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("image")
        public ImageModel image;

        @SerializedName("source")
        public Integer source;

        @SerializedName("status")
        public Integer status;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.status = Integer.valueOf(r100.i());
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.source = Integer.valueOf(r100.i());
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.image = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.Activity")
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$b;", "", "", "iconUrl", "Ljava/lang/String;", "iconSchemaUrl", "", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$g;", "banner", "Ljava/util/Map;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$h;", "tabsToBanners", "bubbleJson", "getBubbleJson", "()Ljava/lang/String;", "setBubbleJson", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("banner")
        public Map<Long, g> banner;

        @SerializedName("bubble")
        protected String bubbleJson;

        @SerializedName("icon_schema_url")
        public String iconSchemaUrl;

        @SerializedName("icon_url")
        public String iconUrl;

        @SerializedName("tabsToBanners")
        public Map<Long, h> tabsToBanners;

        public b() {
        }

        public b(am3.g r110) {
            this.banner = new HashMap();
            this.tabsToBanners = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L43;
            Long r102 = null;
            switch(r101) {
                case 25: goto L42;
                case 26: goto L41;
                case 27: goto L25;
                case 28: goto L24;
                case 29: goto L8;
                default: goto L7;
            };
        L8:
            long r103 = r110.c();
            Object r104 = null;
        L9:
            int r111 = r110.f();
            if (r111 == (-1)) goto L16;
            if (r111 != 1) goto L12;
            r102 = Long.valueOf(r110.j());
            goto L9
        L12:
            if (r111 != 2) goto L13;
            r104 = new h(r110);
            goto L9
        L13:
            am3.h.e(r110);
            goto L9
        L16:
            r110.d(r103);
            Map r105 = this.tabsToBanners;
            if (r102 == null) goto L23;
            if (r104 == null) goto L21;
        L36:
            r105.put(r102, r104);
            goto L3
        L21:
            throw new IllegalStateException("Value must not be null");
        L23:
            throw new IllegalStateException("Key must not be null");
        L24:
            this.bubbleJson = am3.h.c(r110);
            goto L3
        L25:
            long r106 = r110.c();
            r104 = null;
        L26:
            int r112 = r110.f();
            if (r112 == (-1)) goto L33;
            if (r112 != 1) goto L29;
            r102 = Long.valueOf(r110.j());
            goto L26
        L29:
            if (r112 != 2) goto L30;
            r104 = new g(r110);
            goto L26
        L30:
            am3.h.e(r110);
            goto L26
        L33:
            r110.d(r106);
            r105 = this.banner;
            if (r102 == null) goto L40;
            if (r104 != null) goto L36;
            throw new IllegalStateException("Value must not be null");
        L40:
            throw new IllegalStateException("Key must not be null");
        L41:
            this.iconSchemaUrl = am3.h.c(r110);
            goto L3
        L42:
            this.iconUrl = am3.h.c(r110);
            goto L3
        L7:
            am3.h.e(r110);
            goto L3
        L43:
            r110.d(r100);
        }
    }

    @ProtoMessage("webcast.api.room.AnchorFansInfo")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$c;", "", "", "mOnlineFansCount", "I", "mOnlineFriendCount", "mLivingFriendCount", "mAvatarType", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "mLivingFriendAvatars", "Ljava/util/List;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("avatar_type")
        public int mAvatarType;

        @SerializedName("avatars")
        public List<ImageModel> mLivingFriendAvatars;

        @SerializedName("living_friend_count")
        public int mLivingFriendCount;

        @SerializedName("online_fans_count")
        public int mOnlineFansCount;

        @SerializedName("online_friend_count")
        public int mOnlineFriendCount;

        public c() {
            this.mLivingFriendAvatars = new ArrayList();
        }

        public c(am3.g r100) {
            this.mLivingFriendAvatars = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.mOnlineFansCount = (int) r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.mOnlineFriendCount = (int) r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.mLivingFriendCount = (int) r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.mAvatarType = (int) r100.j();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.mLivingFriendAvatars.add(com.bytedance.android.live.base.model.x.a(r100));
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
            if (this.mLivingFriendAvatars.isEmpty() == false) goto L43;
            this.mLivingFriendAvatars = new ArrayList();
            return;
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.AnchorInfo")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$d;", "", "", "lastResolutionKey", "Ljava/lang/String;", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$a;", "recommendAiCovers", "Ljava/util/List;", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarWithBackground", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "lastCoverIsAi", "Ljava/lang/Boolean;", "lastTitleIsAi", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d implements vh7.h {

        @SerializedName("avatar_with_background")
        public ImageModel avatarWithBackground;

        @SerializedName("last_cover_is_ai")
        public Boolean lastCoverIsAi;

        @SerializedName("last_resolution_key")
        public String lastResolutionKey;

        @SerializedName("last_title_is_ai")
        public Boolean lastTitleIsAi;

        @SerializedName("recommend_ai_covers")
        public List<a> recommendAiCovers;

        public d() {
            Boolean r100 = Boolean.FALSE;
            this.lastCoverIsAi = r100;
            this.lastTitleIsAi = r100;
        }

        public d(am3.g r100) {
            this.recommendAiCovers = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 2) goto L8;
            this.lastResolutionKey = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 4) goto L10;
            this.lastTitleIsAi = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L10:
            if (r102 != 5) goto L12;
            this.recommendAiCovers.add(new a(r100));
            goto L3
        L12:
            if (r102 != 6) goto L14;
            this.avatarWithBackground = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L14:
            if (r102 != 7) goto L15;
            this.lastCoverIsAi = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
            if (this.lastCoverIsAi != null) goto L25;
            this.lastCoverIsAi = Boolean.FALSE;
        L25:
            if (this.lastTitleIsAi != null) goto L46;
            this.lastTitleIsAi = Boolean.FALSE;
            return;
        }
    }

    @ProtoMessage("webcast.api.room.AnchorInfoBarData")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$e;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "mIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "mTitle", "Ljava/lang/String;", "mJumpText", "mUrl", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e implements vh7.h {

        @SerializedName("icon")
        public ImageModel mIcon;

        @SerializedName("jump_text")
        public String mJumpText;

        @SerializedName("title")
        public String mTitle;

        @SerializedName("url")
        public String mUrl;

        public e() {
        }

        public e(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.mIcon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.mTitle = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.mJumpText = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.mUrl = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.AnchorMonitorInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$f;", "", "", "isTop", "Z", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f implements vh7.h {

        @SerializedName("is_top")
        public boolean isTop;

        public f() {
        }

        public f(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.isTop = am3.h.a(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.Banner")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$g;", "", "", "areaUrl", "Ljava/lang/String;", "areaSchemaUrl", "bannerId", "", "bannerType", "Ljava/lang/Long;", "lifeCycle", "accessibleName", "", "logExtra", "Ljava/util/Map;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g implements vh7.h {

        @SerializedName("accessible_name")
        public String accessibleName;

        @SerializedName("area_schema_url")
        public String areaSchemaUrl;

        @SerializedName("area_url")
        public String areaUrl;

        @SerializedName("banner_id")
        public String bannerId;

        @SerializedName("banner_type")
        public Long bannerType;

        @SerializedName("life_cycle")
        public String lifeCycle;

        @SerializedName("extra")
        public Map<String, String> logExtra;

        public g() {
        }

        public g(am3.g r110) {
            this.logExtra = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L31;
            switch(r101) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            this.accessibleName = am3.h.c(r110);
            goto L3
        L8:
            long r102 = r110.c();
            String r103 = null;
            String r104 = null;
        L9:
            int r105 = r110.f();
            if (r105 == (-1)) goto L18;
            if (r105 != 1) goto L14;
            r103 = am3.h.c(r110);
            goto L9
        L14:
            if (r105 != 2) goto L15;
            r104 = am3.h.c(r110);
            goto L9
        L15:
            am3.h.e(r110);
            goto L9
        L18:
            r110.d(r102);
            Map<String, String> r106 = this.logExtra;
            if (r103 == null) goto L25;
            if (r104 == null) goto L23;
            r106.put(r103, r104);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L26:
            this.lifeCycle = am3.h.c(r110);
            goto L3
        L27:
            this.bannerType = Long.valueOf(r110.j());
            goto L3
        L28:
            this.bannerId = am3.h.c(r110);
            goto L3
        L29:
            this.areaSchemaUrl = am3.h.c(r110);
            goto L3
        L30:
            this.areaUrl = am3.h.c(r110);
            goto L3
        L6:
            am3.h.e(r110);
            goto L3
        L31:
            r110.d(r100);
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.BannerList")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$h;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$g;", PromotionProductPrivilegesStruct.BANNERS, "Ljava/util/List;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h implements vh7.h {

        @SerializedName(PromotionProductPrivilegesStruct.BANNERS)
        public List<g> banners;

        public h() {
            this.banners = new ArrayList();
        }

        public h(am3.g r100) {
            this.banners = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.banners.add(new g(r100));
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
            if (this.banners.isEmpty() == false) goto L19;
            this.banners = new ArrayList();
            return;
        }
    }

    @ProtoMessage("webcast.api.room.BlockDetail")
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\f\u0010\b\u0012\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$i;", "", "", "mLiveTab", "I", "mBlockStatus", "", "blockMsgTitle", "Ljava/lang/String;", "", "unblockTime", "J", "mBlockSchema", "getMBlockSchema$annotations", "()V", "unblockPrompt", "", "allowCreateLive", "Z", "mBlockSchemaNew", "buttonText", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "promptType", "", "extra", "Ljava/util/Map;", "dialogInfo", "getDialogInfo", "()Ljava/lang/String;", "setDialogInfo", "(Ljava/lang/String;)V", "<init>", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class i implements vh7.h {

        @SerializedName("is_not_block_create")
        public boolean allowCreateLive;

        @SerializedName("block_prompt")
        public String blockMsgTitle;

        @SerializedName("button_text")
        public String buttonText;

        @SerializedName("dialog_info")
        protected String dialogInfo;

        @SerializedName("extra")
        public Map<String, String> extra;

        @SerializedName("icon")
        public ImageModel icon;

        @SerializedName("block_schema_locale")
        public String mBlockSchema;

        @SerializedName("block_schema")
        public String mBlockSchemaNew;

        @SerializedName("block_status")
        public int mBlockStatus;

        @SerializedName(LiveEndPageData.TAG_LIVE_TAB)
        public int mLiveTab;

        @SerializedName("prompt_type")
        public int promptType;

        @SerializedName("auto_un_block_prompts")
        public String unblockPrompt;

        @SerializedName("un_block_time")
        public long unblockTime;

        public i() {
            this.buttonText = "";
            this.dialogInfo = "";
        }

        public i(am3.g r110) {
            this.extra = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L37;
            switch(r101) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            this.buttonText = am3.h.c(r110);
            goto L3
        L8:
            this.dialogInfo = am3.h.c(r110);
            goto L3
        L9:
            long r102 = r110.c();
            String r103 = null;
            String r104 = null;
        L10:
            int r105 = r110.f();
            if (r105 == (-1)) goto L19;
            if (r105 != 1) goto L15;
            r103 = am3.h.c(r110);
            goto L10
        L15:
            if (r105 != 2) goto L16;
            r104 = am3.h.c(r110);
            goto L10
        L16:
            am3.h.e(r110);
            goto L10
        L19:
            r110.d(r102);
            Map<String, String> r106 = this.extra;
            if (r103 == null) goto L26;
            if (r104 == null) goto L24;
            r106.put(r103, r104);
            goto L3
        L24:
            throw new IllegalStateException("Value must not be null");
        L26:
            throw new IllegalStateException("Key must not be null");
        L27:
            this.icon = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L28:
            this.promptType = r110.i();
            goto L3
        L29:
            this.mBlockSchemaNew = am3.h.c(r110);
            goto L3
        L30:
            this.allowCreateLive = am3.h.a(r110);
            goto L3
        L31:
            this.unblockPrompt = am3.h.c(r110);
            goto L3
        L32:
            this.mBlockSchema = am3.h.c(r110);
            goto L3
        L33:
            this.unblockTime = r110.j();
            goto L3
        L34:
            this.blockMsgTitle = am3.h.c(r110);
            goto L3
        L35:
            this.mBlockStatus = (int) r110.j();
            goto L3
        L36:
            this.mLiveTab = r110.i();
            goto L3
        L6:
            am3.h.e(r110);
            goto L3
        L37:
            r110.d(r100);
            if (this.buttonText != null) goto L41;
            this.buttonText = "";
        L41:
            if (this.dialogInfo != null) goto L85;
            this.dialogInfo = "";
            return;
        }
    }

    public static final class j {
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.ConfigItem")
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u000bR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$k;", "", "", "name", "Ljava/lang/String;", "", "order", "I", "text", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "innerIcon", "selectedIcon", "schema", "", "excludedItems", "Ljava/util/List;", "type", "buttonText", com.bytedance.android.livesdk.gift.model.n.KEY_SUB_TEXT, "", "switchStatus", "Z", "panelName", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$n;", "subItems", "showInSubTabs", "dotType", "extra", "toolbarComponentType", "Ljava/lang/Integer;", "innerSelectedIcon", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "bubbleInfo", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "getBubbleInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "setBubbleInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "dotInfo", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "getDotInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "setDotInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class k implements vh7.h {

        @SerializedName("bubble_info")
        protected ItemBubbleInfo bubbleInfo;

        @SerializedName("button_text")
        public String buttonText;

        @SerializedName("dot_info")
        protected ItemDotInfo dotInfo;

        @SerializedName("dot_type")
        public int dotType;

        @SerializedName("excluded_by_other_items")
        public List<String> excludedItems;

        @SerializedName("extra")
        public String extra;

        @SerializedName("icon")
        public ImageModel icon;

        @SerializedName("inner_icon")
        public ImageModel innerIcon;

        @SerializedName("inner_selected_icon")
        public ImageModel innerSelectedIcon;

        @SerializedName("name")
        public String name;

        @SerializedName("order")
        public int order;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PANEL_NAME)
        public String panelName;

        @SerializedName("schema")
        public String schema;

        @SerializedName("selected_icon")
        public ImageModel selectedIcon;

        @SerializedName("show_in_sub_tabs")
        public List<Integer> showInSubTabs;

        @SerializedName("sub_items")
        public List<n> subItems;

        @SerializedName("sub_text")
        public String subText;

        @SerializedName(EventConstants.ExtraJson.SWITCH_STATUS)
        public boolean switchStatus;

        @SerializedName("text")
        public String text;

        @SerializedName("toolbar_component_type")
        public Integer toolbarComponentType;

        @SerializedName("type")
        public int type;

        public static final class a {
        }

        static {
        }

        public k() {
            this.name = "";
            this.order = -1;
            this.text = "";
            this.schema = "";
            this.buttonText = "";
            this.subText = "";
            this.panelName = "";
            this.extra = "";
        }

        public k(am3.g r100) {
            this.excludedItems = new ArrayList();
            this.subItems = new ArrayList();
            this.showInSubTabs = new ArrayList();
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L29;
            switch(r103) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L6;
                case 19: goto L10;
                case 20: goto L9;
                case 21: goto L8;
                case 22: goto L7;
                default: goto L6;
            };
        L7:
            this.innerSelectedIcon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            this.toolbarComponentType = Integer.valueOf(r100.i());
            goto L3
        L9:
            this.dotInfo = new ItemDotInfo(r100);
            goto L3
        L10:
            this.bubbleInfo = new ItemBubbleInfo(r100);
            goto L3
        L11:
            this.extra = am3.h.c(r100);
            goto L3
        L12:
            this.dotType = r100.i();
            goto L3
        L13:
            List r104 = this.showInSubTabs;
            Object r105 = Integer.valueOf(r100.i());
        L23:
            r104.add(r105);
            goto L3
        L14:
            this.panelName = am3.h.c(r100);
            goto L3
        L15:
            this.selectedIcon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L16:
            this.innerIcon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L17:
            r104 = this.subItems;
            r105 = new n(r100);
            goto L23
        L18:
            this.switchStatus = am3.h.a(r100);
            goto L3
        L19:
            this.subText = am3.h.c(r100);
            goto L3
        L20:
            this.buttonText = am3.h.c(r100);
            goto L3
        L21:
            this.type = r100.i();
            goto L3
        L22:
            r104 = this.excludedItems;
            r105 = am3.h.c(r100);
            goto L23
        L24:
            this.schema = am3.h.c(r100);
            goto L3
        L25:
            this.icon = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L26:
            this.text = am3.h.c(r100);
            goto L3
        L27:
            this.order = r100.i();
            r102 = r102 | true;
            goto L3
        L28:
            this.name = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L29:
            r100.d(r101);
            if (this.name != null) goto L33;
            this.name = "";
        L33:
            if ((r102 & true) == true) goto L36;
            this.order = -1;
        L36:
            if (this.text != null) goto L39;
            this.text = "";
        L39:
            if (this.schema != null) goto L42;
            this.schema = "";
        L42:
            if (this.buttonText != null) goto L45;
            this.buttonText = "";
        L45:
            if (this.subText != null) goto L48;
            this.subText = "";
        L48:
            if (this.panelName != null) goto L51;
            this.panelName = "";
        L51:
            if (this.extra != null) goto L98;
            this.extra = "";
            return;
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.CreatePageConfig")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$l;", "", "", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$q;", "configMap", "Ljava/util/Map;", "platformConfigMap", "", "oldToolbarConfigs", "Ljava/util/List;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class l implements vh7.h {

        @SerializedName("config_map")
        public Map<String, q> configMap;

        @SerializedName("old_toolbar_configs")
        public List<String> oldToolbarConfigs;

        @SerializedName("platform_config_map")
        public Map<String, q> platformConfigMap;

        public l() {
        }

        public l(am3.g r110) {
            this.configMap = new HashMap();
            this.platformConfigMap = new HashMap();
            this.oldToolbarConfigs = new ArrayList();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L44;
            String r102 = null;
            if (r101 == 1) goto L28;
            if (r101 != 2) goto L9;
            long r103 = r110.c();
            q r104 = null;
        L13:
            int r111 = r110.f();
            if (r111 == (-1)) goto L20;
            if (r111 != 1) goto L16;
            r102 = am3.h.c(r110);
            goto L13
        L16:
            if (r111 != 2) goto L17;
            r104 = new q(r110);
            goto L13
        L17:
            am3.h.e(r110);
            goto L13
        L20:
            r110.d(r103);
            Map<String, q> r105 = this.platformConfigMap;
            if (r102 == null) goto L27;
            if (r104 == null) goto L25;
        L39:
            r105.put(r102, r104);
            goto L3
        L25:
            throw new IllegalStateException("Value must not be null");
        L27:
            throw new IllegalStateException("Key must not be null");
        L9:
            if (r101 != 99) goto L10;
            this.oldToolbarConfigs.add(am3.h.c(r110));
            goto L3
        L10:
            am3.h.e(r110);
            goto L3
        L28:
            long r106 = r110.c();
            r104 = null;
        L29:
            int r112 = r110.f();
            if (r112 == (-1)) goto L36;
            if (r112 != 1) goto L32;
            r102 = am3.h.c(r110);
            goto L29
        L32:
            if (r112 != 2) goto L33;
            r104 = new q(r110);
            goto L29
        L33:
            am3.h.e(r110);
            goto L29
        L36:
            r110.d(r106);
            r105 = this.configMap;
            if (r102 == null) goto L43;
            if (r104 != null) goto L39;
            throw new IllegalStateException("Value must not be null");
        L43:
            throw new IllegalStateException("Key must not be null");
        L44:
            r110.d(r100);
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.FansClubConfig")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$m;", "", "", "fansClubType", "I", "", "typeEditable", "Z", "", "editDisableToast", "Ljava/lang/String;", "rulePageUrl", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class m implements vh7.h {

        @SerializedName("edit_disable_toast")
        public String editDisableToast;

        @SerializedName("fans_club_type")
        public int fansClubType;

        @SerializedName("rule_page_url")
        public String rulePageUrl;

        @SerializedName("type_editable")
        public boolean typeEditable;

        public m() {
            this.fansClubType = 1;
        }

        public m(am3.g r100) {
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L17;
            if (r103 != 1) goto L7;
            this.fansClubType = r100.i();
            r102 = r102 | true;
            goto L3
        L7:
            if (r103 != 2) goto L9;
            this.typeEditable = am3.h.a(r100);
            goto L3
        L9:
            if (r103 != 3) goto L11;
            this.editDisableToast = am3.h.c(r100);
            goto L3
        L11:
            if (r103 != 4) goto L12;
            this.rulePageUrl = am3.h.c(r100);
            goto L3
        L12:
            am3.h.e(r100);
            goto L3
        L17:
            r100.d(r101);
            if ((r102 & true) == true) goto L36;
            this.fansClubType = 1;
            return;
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.GroupConfig")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$n;", "", "", "groupName", "Ljava/lang/String;", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$k;", "configItems", "Ljava/util/List;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class n implements vh7.h {

        @SerializedName("config_items")
        public List<k> configItems;

        @SerializedName("group_name")
        public String groupName;

        public n() {
            this.groupName = "";
        }

        public n(am3.g r100) {
            this.configItems = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.groupName = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.configItems.add(new k(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.groupName != null) goto L25;
            this.groupName = "";
            return;
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.PublicAreaConfig")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$o;", "", "", "showEntry", "I", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class o implements vh7.h {

        @SerializedName("show_entry")
        public int showEntry;

        public o() {
        }

        public o(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.showEntry = (int) r100.j();
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.room.PushStreamInfo")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$p;", "", "", "defaultResolutionKey", "Ljava/lang/String;", "recommendResolutionKey", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$p$a;", "resolutions", "Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class p implements vh7.h {

        @SerializedName("default_resolution_key")
        public String defaultResolutionKey;

        @SerializedName("recommend_resolution_key")
        public String recommendResolutionKey;

        @SerializedName("resolutions")
        public List<a> resolutions;

        @ProtoMessage("webcast.api.room.PushStreamInfo.Resolution")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$p$a;", "", "", "text", "Ljava/lang/String;", "key", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a implements vh7.h {

            @SerializedName("key")
            public String key;

            @SerializedName("text")
            public String text;

            public a() {
                this.text = "";
                this.key = "";
            }

            public a(am3.g r100) {
                long r101 = r100.c();
            L3:
                int r102 = r100.f();
                if (r102 == (-1)) goto L12;
                if (r102 != 1) goto L8;
                this.text = am3.h.c(r100);
                goto L3
            L8:
                if (r102 != 2) goto L9;
                this.key = am3.h.c(r100);
                goto L3
            L9:
                am3.h.e(r100);
                goto L3
            L12:
                r100.d(r101);
                if (this.text != null) goto L16;
                this.text = "";
            L16:
                if (this.key != null) goto L28;
                this.key = "";
                return;
            }
        }

        public p() {
            this.defaultResolutionKey = "";
            this.recommendResolutionKey = "";
            this.resolutions = new ArrayList();
        }

        public p(am3.g r100) {
            this.resolutions = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.defaultResolutionKey = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.resolutions.add(new a(r100));
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.recommendResolutionKey = am3.h.c(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
            if (this.defaultResolutionKey != null) goto L19;
            this.defaultResolutionKey = "";
        L19:
            if (this.recommendResolutionKey != null) goto L22;
            this.recommendResolutionKey = "";
        L22:
            if (this.resolutions.isEmpty() == false) goto L37;
            this.resolutions = new ArrayList();
            return;
        }
    }

    @ProtoMessage("webcast.api.room.CreateInfoResponse.TabConfig")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0005\u0012\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$q;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$k;", "normalItems", "Ljava/util/List;", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$n;", "moreItems", "getMoreItems$annotations", "()V", "<init>", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class q implements vh7.h {

        @SerializedName("more_items")
        public List<n> moreItems;

        @SerializedName("normal_items")
        public List<k> normalItems;

        public q() {
        }

        public q(am3.g r100) {
            this.normalItems = new ArrayList();
            this.moreItems = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            if (r102 == 1) goto L11;
            if (r102 != 2) goto L9;
            List r103 = this.moreItems;
            vh7.h r104 = new n(r100);
        L12:
            r103.add(r104);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L11:
            r103 = this.normalItems;
            r104 = new k(r100);
            goto L12
        L13:
            r100.d(r101);
        }
    }

    static {
    }

    public RoomCreateInfo() {
        Boolean r100 = Boolean.FALSE;
        this.isShowUserCard = r100;
        this.mAutoCloseIntervalList = new ArrayList();
        this.mAutoCloseInterval = 0L;
        this.mLinkmicSetting = new ArrayList();
        this.mLinkmicSceneHasEverOpen = new ArrayList();
        this.localAdsUserTag = r100;
        this.categories = new ArrayList();
        this.blockInfo = new ArrayList();
        this.bubbleInfo = new HashMap();
        this.audienceDisplayType = 99;
        this.commodityNoFilter = 1;
        this.firstMessageId = "";
    }

    public RoomCreateInfo(am3.g r110) {
        this.pushStreamInfoMap = new HashMap();
        this.mAutoCloseIntervalList = new ArrayList();
        this.mLinkmicSetting = new ArrayList();
        this.mLinkmicSceneHasEverOpen = new ArrayList();
        this.categories = new ArrayList();
        this.blockInfo = new ArrayList();
        this.bubbleInfo = new HashMap();
        this.componentConfig = new HashMap();
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L149;
        if (r102 != 12) goto L8;
        this.mAutoCover = r110.j();
        goto L3
    L8:
        if (r102 != 13) goto L10;
        this.mAnchorFansInfo = new c(r110);
        goto L3
    L10:
        if (r102 != 100) goto L12;
        this.anchorInfo = new d(r110);
        goto L3
    L12:
        if (r102 != 101) goto L14;
        this.configInfo = new u(r110);
        goto L3
    L14:
        if (r102 != 107) goto L16;
        this.roomIntroInfo = new RoomIntroInfo(r110);
        goto L3
    L16:
        if (r102 != 108) goto L17;
        this.localAdsUserTag = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L17:
        Object r111 = null;
        if (r102 == 200) goto L127;
        if (r102 != 201) goto L22;
        this.topAreaComponentConfig = new TopAreaComponent(r110);
        goto L3
    L22:
        if (r102 != 209) goto L23;
        this.liveTopicComponent = new LiveTopicComponent(r110);
        goto L3
    L23:
        switch(r102) {
            case 1: goto L124;
            case 2: goto L123;
            case 3: goto L122;
            case 4: goto L121;
            case 5: goto L120;
            case 6: goto L119;
            case 7: goto L118;
            case 8: goto L117;
            case 9: goto L116;
            case 10: goto L115;
            default: goto L24;
        };
    L115:
        this.mBlockSchema = am3.h.c(r110);
        goto L3
    L116:
        this.blockMsgTitle = am3.h.c(r110);
        goto L3
    L117:
        this.mBlockStatus = (int) r110.j();
        goto L3
    L118:
        this.mIsFirstBroadcastFlag = (int) r110.j();
        goto L3
    L119:
        this.mBroadcastConfig = new com.bytedance.android.live.broadcast.api.model.q(r110);
        goto L3
    L120:
        this.mAnchorPromptType = (int) r110.j();
        goto L3
    L121:
        this.mPrompt = am3.h.c(r110);
        goto L3
    L122:
        this.mTitle = am3.h.c(r110);
        goto L3
    L123:
        this.mCoverAuditStatus = r110.j();
        goto L3
    L124:
        this.mCover = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L24:
        switch(r102) {
            case 15: goto L114;
            case 16: goto L113;
            case 17: goto L112;
            case 18: goto L110;
            default: goto L25;
        };
    L110:
        List r103 = this.categories;
        Object r104 = new CategoryNode(r110);
    L111:
        r103.add(r104);
        goto L3
    L112:
        this.obsAuditStatus = new t0(r110);
        goto L3
    L113:
        this.unblockPrompt = am3.h.c(r110);
        goto L3
    L114:
        this.unblockTime = r110.j();
        goto L3
    L25:
        switch(r102) {
            case 20: goto L109;
            case 21: goto L108;
            case 22: goto L107;
            case 23: goto L106;
            case 24: goto L105;
            case 25: goto L89;
            case 26: goto L88;
            case 27: goto L87;
            case 28: goto L86;
            case 29: goto L85;
            case 30: goto L84;
            case 31: goto L83;
            case 32: goto L82;
            case 33: goto L81;
            case 34: goto L80;
            case 35: goto L79;
            case 36: goto L78;
            case 37: goto L77;
            case 38: goto L76;
            case 39: goto L75;
            case 40: goto L74;
            case 41: goto L73;
            case 42: goto L72;
            case 43: goto L71;
            case 44: goto L70;
            case 45: goto L69;
            case 46: goto L68;
            case 47: goto L67;
            case 48: goto L66;
            case 49: goto L65;
            case 50: goto L64;
            case 51: goto L63;
            case 52: goto L62;
            case 53: goto L61;
            case 54: goto L60;
            case 55: goto L59;
            case 56: goto L58;
            case 57: goto L57;
            case 58: goto L56;
            case 59: goto L55;
            case 60: goto L54;
            case 61: goto L53;
            case 62: goto L52;
            default: goto L26;
        };
    L52:
        this.audienceLinkmicInfo = new com.bytedance.android.live.broadcast.api.model.p(r110);
        goto L3
    L53:
        this.publicAreaConfig = new o(r110);
        goto L3
    L54:
        this.activityDeclaration = new com.bytedance.android.live.broadcast.api.model.b(r110);
        goto L3
    L55:
        this.localAdsSchema = am3.h.c(r110);
        goto L3
    L56:
        this.anchorMonitorInfo = new f(r110);
        goto L3
    L57:
        this.defaultSyncToXT = am3.h.a(r110);
        goto L3
    L58:
        this.createPageConfig = new l(r110);
        goto L3
    L59:
        this.fansClubConfig = new m(r110);
        goto L3
    L60:
        this.isShowUserCard = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L61:
        this.mBlockSchemaNew = am3.h.c(r110);
        goto L3
    L62:
        this.starInfo = new o1(r110);
        goto L3
    L63:
        this.allowCreateLive = am3.h.a(r110);
        goto L3
    L64:
        this.isCommodityNoFilterDefaultOpen = am3.h.a(r110);
        goto L3
    L65:
        this.desireInfo = new d0(r110);
        goto L3
    L66:
        this.paidLiveInfo = new v0(r110);
        goto L3
    L67:
        this.pcLivePermissionApplyButtonText = am3.h.c(r110);
        goto L3
    L68:
        this.pcLivePermissionApplyStatus = r110.i();
        goto L3
    L69:
        this.isVIP = am3.h.a(r110);
        goto L3
    L70:
        this.bookCount = r110.j();
        goto L3
    L71:
        this.commodityNoFilter = r110.i();
        r101 = r101 | 2;
        goto L3
    L72:
        this.previewStream = new c1(r110);
        goto L3
    L73:
        this.settingPrompt = new j1(r110);
        goto L3
    L74:
        this.audienceDisplayType = r110.i();
        r101 = r101 | 1;
        goto L3
    L75:
        this.anchorRankHourSetting = r110.j();
        goto L3
    L76:
        this.mCircleInfo = new f1(r110);
        goto L3
    L77:
        this.isGov = am3.h.a(r110);
        goto L3
    L78:
        this.isMedia = am3.h.a(r110);
        goto L3
    L79:
        this.urgeCount = r110.j();
        goto L3
    L80:
        this.douCoinCount = r110.j();
        goto L3
    L81:
        this.firstMessageId = am3.h.c(r110);
        goto L3
    L82:
        r103 = this.mLinkmicSceneHasEverOpen;
        r104 = Integer.valueOf(r110.i());
        goto L111
    L83:
        r103 = this.mLinkmicSetting;
        r104 = new a0(r110);
        goto L111
    L84:
        this.startLiveVisibilityRange = r110.i();
        goto L3
    L85:
        this.mAutoCloseInterval = Long.valueOf(r110.j());
        goto L3
    L86:
        r103 = this.mAutoCloseIntervalList;
        r104 = Long.valueOf(r110.j());
        goto L111
    L87:
        this.replaySetting = new d1(r110);
        goto L3
    L88:
        this.userVerifiedType = am3.h.c(r110);
        goto L3
    L89:
        long r112 = r110.c();
        Object r105 = null;
    L90:
        int r106 = r110.f();
        if (r106 == (-1)) goto L97;
        if (r106 != 1) goto L93;
        r111 = Long.valueOf(r110.j());
        goto L90
    L93:
        if (r106 != 2) goto L94;
        r105 = new p(r110);
        goto L90
    L94:
        am3.h.e(r110);
        goto L90
    L97:
        r110.d(r112);
        Map r107 = this.pushStreamInfoMap;
        if (r111 == null) goto L104;
        if (r105 == null) goto L102;
    L100:
        r107.put(r111, r105);
        goto L3
    L102:
        throw new IllegalStateException("Value must not be null");
    L104:
        throw new IllegalStateException("Key must not be null");
    L105:
        r103 = this.blockInfo;
        r104 = new i(r110);
        goto L111
    L106:
        this.mPCLivePermissionStatus = am3.h.a(r110);
        goto L3
    L107:
        this.activityBanner = new b(r110);
        goto L3
    L108:
        this.mAnchorInfoBarData = new e(r110);
        goto L3
    L109:
        this.mNewAnchorFlag = (int) r110.j();
        goto L3
    L26:
        switch(r102) {
            case 103: goto L51;
            case 104: goto L50;
            case 105: goto L34;
            default: goto L27;
        };
    L34:
        long r113 = r110.c();
        r105 = null;
    L35:
        int r108 = r110.f();
        if (r108 == (-1)) goto L42;
        if (r108 != 1) goto L38;
        r111 = am3.h.c(r110);
        goto L35
    L38:
        if (r108 != 2) goto L39;
        r105 = new ItemBubbleInfo(r110);
        goto L35
    L39:
        am3.h.e(r110);
        goto L35
    L42:
        r110.d(r113);
        r107 = this.bubbleInfo;
        if (r111 == null) goto L49;
        if (r105 != null) goto L100;
        throw new IllegalStateException("Value must not be null");
    L49:
        throw new IllegalStateException("Key must not be null");
    L50:
        this.interceptStrategy = r110.i();
        goto L3
    L51:
        this.disableInfo = new e0(r110);
        goto L3
    L27:
        switch(r102) {
            case 203: goto L33;
            case 204: goto L32;
            case 205: goto L31;
            case 206: goto L30;
            case 207: goto L29;
            default: goto L28;
        };
    L29:
        this.customerServiceComponent = new CustomerServiceComponent(r110);
        goto L3
    L30:
        this.categoryComponentConfig = new CategoryComponent(r110);
        goto L3
    L31:
        this.bottomToolBarComponent = new BottomToolBarComponent(r110);
        goto L3
    L32:
        this.createModeComponentConfig = new com.bytedance.android.live.broadcast.api.model.component.b(r110);
        goto L3
    L33:
        this.createButtonComponentConfig = new CreateButtonComponent(r110);
        goto L3
    L28:
        am3.h.e(r110);
        goto L3
    L127:
        long r114 = r110.c();
        r105 = null;
    L128:
        int r109 = r110.f();
        if (r109 == (-1)) goto L135;
        if (r109 != 1) goto L131;
        r111 = Integer.valueOf(r110.i());
        goto L128
    L131:
        if (r109 != 2) goto L132;
        r105 = new ComponentConfig(r110);
        goto L128
    L132:
        am3.h.e(r110);
        goto L128
    L135:
        r110.d(r114);
        r107 = this.componentConfig;
        if (r111 == null) goto L142;
        if (r105 != null) goto L100;
        throw new IllegalStateException("Value must not be null");
    L142:
        throw new IllegalStateException("Key must not be null");
    L149:
        r110.d(r100);
        if (this.isShowUserCard != null) goto L153;
        this.isShowUserCard = Boolean.FALSE;
    L153:
        if (this.mAutoCloseIntervalList.isEmpty() == false) goto L156;
        this.mAutoCloseIntervalList = new ArrayList();
    L156:
        if (this.mAutoCloseInterval != null) goto L159;
        this.mAutoCloseInterval = 0L;
    L159:
        if (this.mLinkmicSetting.isEmpty() == false) goto L162;
        this.mLinkmicSetting = new ArrayList();
    L162:
        if (this.mLinkmicSceneHasEverOpen.isEmpty() == false) goto L165;
        this.mLinkmicSceneHasEverOpen = new ArrayList();
    L165:
        if (this.localAdsUserTag != null) goto L168;
        this.localAdsUserTag = Boolean.FALSE;
    L168:
        if (this.categories.isEmpty() == false) goto L171;
        this.categories = new ArrayList();
    L171:
        if (this.blockInfo.isEmpty() == false) goto L174;
        this.blockInfo = new ArrayList();
    L174:
        if (this.bubbleInfo != null) goto L177;
        this.bubbleInfo = new HashMap();
    L177:
        if ((r101 & 1) != 0) goto L180;
        this.audienceDisplayType = 99;
    L180:
        if ((r101 & 2) != 0) goto L183;
        this.commodityNoFilter = 1;
    L183:
        if (this.firstMessageId != null) goto L377;
        this.firstMessageId = "";
        return;
    }
}
