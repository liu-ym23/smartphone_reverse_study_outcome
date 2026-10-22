package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragmentV2;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetchJobKey;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventContext;
import com.bytedance.android.shopping.store.tabkit.mixframe.TabKitMixFrameTabFragment;
import com.bytedance.android.shopping.store.tabkit.model.r;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.t;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.TabKitDialogView;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 ù\u00012\u00020\u0001:\u0002ú\u0001B\t¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\tJ\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001d2\u0006\u0010\u001c\u001a\u00020\u0006J\u0017\u0010\u001f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\tJ\u0019\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b'\u0010%J\u0017\u0010(\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b(\u0010)J\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u0010\u0010.\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010/\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\tR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010C\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020N068\u0006¢\u0006\f\n\u0004\bO\u00108\u001a\u0004\bP\u0010:R)\u0010Q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N0\u001d068\u0006¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010:R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\f\n\u0004\bS\u00108\u001a\u0004\bT\u0010:R\u0017\u0010V\u001a\u00020U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u0006068\u0006¢\u0006\f\n\u0004\bZ\u00108\u001a\u0004\b[\u0010:R\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\\068\u0006¢\u0006\f\n\u0004\b]\u00108\u001a\u0004\b^\u0010:R\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\\068\u0006¢\u0006\f\n\u0004\b_\u00108\u001a\u0004\b`\u0010:R)\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001d068\u0006¢\u0006\f\n\u0004\ba\u00108\u001a\u0004\bb\u0010:R$\u0010c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010i\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010\u0017\"\u0004\bl\u0010mR'\u0010q\u001a\u0012\u0012\u0004\u0012\u00020o0nj\b\u0012\u0004\u0012\u00020o`p8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR'\u0010v\u001a\u0012\u0012\u0004\u0012\u00020u0nj\b\u0012\u0004\u0012\u00020u`p8\u0006¢\u0006\f\n\u0004\bv\u0010r\u001a\u0004\bw\u0010tR\u0017\u0010y\u001a\u00020x8\u0006¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0019\u0010~\u001a\u00020}8\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R:\u0010\u0084\u0001\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0082\u0001j\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R:\u0010\u0088\u0001\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0082\u0001j\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0085\u0001\u001a\u0006\b\u0089\u0001\u0010\u0087\u0001R<\u0010\u008b\u0001\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u008a\u00010\u0082\u0001j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u008a\u0001`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u0085\u0001\u001a\u0006\b\u008c\u0001\u0010\u0087\u0001R)\u0010\u008d\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008d\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R)\u0010\u0092\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008e\u0001\u001a\u0006\b\u0093\u0001\u0010\u008f\u0001\"\u0006\b\u0094\u0001\u0010\u0091\u0001R)\u0010\u0095\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008e\u0001\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0091\u0001R \u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u0098\u0001\u00108\u001a\u0005\b\u0098\u0001\u0010:R \u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u0099\u0001\u00108\u001a\u0005\b\u0099\u0001\u0010:R \u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u00108\u001a\u0005\b\u009a\u0001\u0010:R)\u0010\u009c\u0001\u001a\u0011\u0012\r\u0012\u000b \u009b\u0001*\u0004\u0018\u00010\t0\t068\u0006¢\u0006\u000e\n\u0005\b\u009c\u0001\u00108\u001a\u0005\b\u009d\u0001\u0010:R \u0010¡\u0001\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010\u008f\u0001R*\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R \u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\u000e\n\u0005\b©\u0001\u00108\u001a\u0005\bª\u0001\u0010:R,\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001a\u0010²\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010jR\u001c\u0010³\u0001\u001a\u00020\u00188\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R)\u0010Å\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u008e\u0001\u001a\u0006\bÆ\u0001\u0010\u008f\u0001\"\u0006\bÇ\u0001\u0010\u0091\u0001R\u001e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020\"0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R^\u0010Ì\u0001\u001aD\u0012\u0004\u0012\u00020\u0018\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ë\u00010nj\t\u0012\u0005\u0012\u00030Ë\u0001`p0\u0082\u0001j!\u0012\u0004\u0012\u00020\u0018\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ë\u00010nj\t\u0012\u0005\u0012\u00030Ë\u0001`p`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010\u0085\u0001\u001a\u0006\bÍ\u0001\u0010\u0087\u0001R*\u0010Î\u0001\u001a\u0012\u0012\u0004\u0012\u00020+0nj\b\u0012\u0004\u0012\u00020+`p8\u0006¢\u0006\u000e\n\u0005\bÎ\u0001\u0010r\u001a\u0005\bÏ\u0001\u0010tR+\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010´\u0001\u001a\u0006\bÑ\u0001\u0010¶\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R)\u0010Ô\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010\u008e\u0001\u001a\u0006\bÔ\u0001\u0010\u008f\u0001\"\u0006\bÕ\u0001\u0010\u0091\u0001R)\u0010Ö\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010\u008e\u0001\u001a\u0006\bÖ\u0001\u0010\u008f\u0001\"\u0006\b×\u0001\u0010\u0091\u0001R+\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010´\u0001\u001a\u0006\bÙ\u0001\u0010¶\u0001\"\u0006\bÚ\u0001\u0010Ó\u0001R$\u0010Ü\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0018\u0010ß\u0001\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010fR\u0016\u0010â\u0001\u001a\u0004\u0018\u00010\u000f8F¢\u0006\b\u001a\u0006\bà\u0001\u0010á\u0001R\u0014\u0010ã\u0001\u001a\u00020\t8F¢\u0006\b\u001a\u0006\bã\u0001\u0010\u008f\u0001R\u0014\u0010å\u0001\u001a\u00020\t8F¢\u0006\b\u001a\u0006\bä\u0001\u0010\u008f\u0001R\u0015\u0010ç\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010fR\u0015\u0010é\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bè\u0001\u0010fR\u0015\u0010ë\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bê\u0001\u0010fR\u0017\u0010ï\u0001\u001a\u0005\u0018\u00010ì\u00018F¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0016\u0010ò\u0001\u001a\u0004\u0018\u00010\"8F¢\u0006\b\u001a\u0006\bð\u0001\u0010ñ\u0001R\u001b\u0010ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ó\u00018F¢\u0006\b\u001a\u0006\bô\u0001\u0010õ\u0001¨\u0006û\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lcom/bytedance/android/shopping/store/tabkit/model/z;", "tabsResponse", "", "filterErrorTabFragment", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab1", "tab2", "", "checkTabValid", "Landroid/os/Bundle;", "arguments", "initPrefetchJobKey", "initMonitor", "", "tabId", "Lcom/bytedance/android/shopping/store/tabkit/model/v;", "getTabState", "(Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/tabkit/model/v;", "setTabKitData", "", "getTabKitMonitorId", "()Ljava/lang/Long;", "", "bundleUrl", "isAnchorTab", "buildBundleUrlWithRouterParams", "tab", "Lkotlin/Pair;", "getTabIndex", "isTabAlreadyShow", "(Ljava/lang/Integer;)Z", "tryCreate", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "getTabFragment", "getTabById", "(Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/tabkit/model/k;", "position", "getTrulyTabByPosition", "getTabTrulyIndex", "(Ljava/lang/Integer;)I", "getViewPagerTrulyPosition", "Lcom/bytedance/android/shopping/store/tabkit/g;", "listener", "addTabKitLifeListener", "prepare", "init", "removeMonitor", "clearFragments", "notifyLandingFinished", "notifyLandingStart", "notifyPageLandingFinished", "isRouterParamsInitialized", "Landroidx/lifecycle/MutableLiveData;", "screenState", "Landroidx/lifecycle/MutableLiveData;", "getScreenState", "()Landroidx/lifecycle/MutableLiveData;", "tabResponse", "getTabResponse", "Lcom/bytedance/android/shopping/store/tabkit/h;", "interceptorHelper", "Lcom/bytedance/android/shopping/store/tabkit/h;", "getInterceptorHelper", "()Lcom/bytedance/android/shopping/store/tabkit/h;", "Lcom/bytedance/android/shopping/store/tabkit/i;", "kvStorage", "Lcom/bytedance/android/shopping/store/tabkit/i;", "getKvStorage", "()Lcom/bytedance/android/shopping/store/tabkit/i;", "Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "routerParams", "Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "getRouterParams", "()Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "setRouterParams", "(Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;)V", "", "screenOffsetFactor", "getScreenOffsetFactor", "screenOffset", "getScreenOffset", "loadStatus", "getLoadStatus", "Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "eventContext", "Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "getEventContext", "()Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "currentHomeTab", "getCurrentHomeTab", "Lcom/bytedance/android/shopping/store/tabkit/model/y;", "currentTab", "getCurrentTab", "currentTabAfter", "getCurrentTabAfter", "foldScreenSize", "getFoldScreenSize", "lastTab", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getLastTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "setLastTab", "(Lcom/bytedance/android/shopping/store/tabkit/model/k;)V", "lastTimeStamp", "Ljava/lang/Long;", "getLastTimeStamp", "setLastTimeStamp", "(Ljava/lang/Long;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "Lkotlin/collections/ArrayList;", "lynxCards", "Ljava/util/ArrayList;", "getLynxCards", "()Ljava/util/ArrayList;", "Lti/l;", "hybridComponents", "getHybridComponents", "Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "jsEventStub", "Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "getJsEventStub", "()Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "jsBridge", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "getJsBridge", "()Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordedEventsMap", "Ljava/util/HashMap;", "getRecordedEventsMap", "()Ljava/util/HashMap;", "navBarVisibilityMap", "getNavBarVisibilityMap", "Lcom/bytedance/android/shopping/store/tabkit/model/d;", "topTabBarVisibilityMap", "getTopTabBarVisibilityMap", "isAnchorFinished", "Z", "()Z", "setAnchorFinished", "(Z)V", "firstSetData", "getFirstSetData", "setFirstSetData", "noRadius", "getNoRadius", "setNoRadius", "isUseNativeTopBar", "isUseNativeBottomBar", "isLandingFinished", "kotlin.jvm.PlatformType", "pageLandingFinished", "getPageLandingFinished", "landingFinishedOpt$delegate", "Lkotlin/Lazy;", "getLandingFinishedOpt", "landingFinishedOpt", "Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "abilityConfig", "Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "getAbilityConfig", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "setAbilityConfig", "(Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;)V", "tabSwitchMode", "getTabSwitchMode", "Lok3/a;", "tabKitMonitor", "Lok3/a;", "getTabKitMonitor", "()Lok3/a;", "setTabKitMonitor", "(Lok3/a;)V", "tabKitMonitorId", "tabsContainerId", "Ljava/lang/String;", "getTabsContainerId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "tabkitPrefetchJobKey", "Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "getTabkitPrefetchJobKey", "()Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "setTabkitPrefetchJobKey", "(Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;)V", "Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "tabKitComponentFactory", "Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "getTabKitComponentFactory", "()Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "setTabKitComponentFactory", "(Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;)V", "clickCloseBtn", "getClickCloseBtn", "setClickCloseBtn", "Landroid/util/SparseArray;", "tabFragmentsMap", "Landroid/util/SparseArray;", "Lcom/bytedance/android/shopping/store/tabkit/view/TabKitDialogView;", "dialogsMap", "getDialogsMap", "tabKitLifeListeners", "getTabKitLifeListeners", "marketingPageId", "getMarketingPageId", "setMarketingPageId", "(Ljava/lang/String;)V", "isLitePage", "setLitePage", "isFoldPage", "setFoldPage", "foldType", "getFoldType", "setFoldType", "Ljava/util/concurrent/ConcurrentHashMap;", "tabStates", "Ljava/util/concurrent/ConcurrentHashMap;", "getDefaultAnchorTab", "defaultAnchorTab", "getAnchorTabId", "()Ljava/lang/Integer;", "anchorTabId", "isFullScreen", "getCanShowSwipeIndicator", "canShowSwipeIndicator", "getTargetAnchorTab", "targetAnchorTab", "getAnchorTab", "anchorTab", "getAnchorHomeTab", "anchorHomeTab", "Lcom/bytedance/android/shopping/store/tabkit/model/r;", "getTabDowngradeConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/r;", "tabDowngradeConfig", "getCurrentSelectedFragment", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "currentSelectedFragment", "", "getHomeTabs", "()Ljava/util/List;", "homeTabs", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitViewModel extends QViewModel {
    public static final a Companion = null;
    public TabKitAbilityConfig abilityConfig;
    private boolean clickCloseBtn;
    private final MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> currentHomeTab;
    private final MutableLiveData<y> currentTab;
    private final MutableLiveData<y> currentTabAfter;
    private final HashMap<String, ArrayList<TabKitDialogView>> dialogsMap;
    private final TabKitEventContext eventContext;
    private boolean firstSetData;
    private final MutableLiveData<Pair<Integer, Integer>> foldScreenSize;
    private String foldType;
    private final ArrayList<ti.l> hybridComponents;
    private final h interceptorHelper;
    private boolean isAnchorFinished;
    private boolean isFoldPage;
    private final MutableLiveData<Boolean> isLandingFinished;
    private boolean isLitePage;
    private final MutableLiveData<Boolean> isUseNativeBottomBar;
    private final MutableLiveData<Boolean> isUseNativeTopBar;
    private final TabKitBridge jsBridge;
    private final com.bytedance.android.shopping.store.tabkit.bridge.c jsEventStub;
    private final i kvStorage;
    private final Lazy landingFinishedOpt$delegate;
    private com.bytedance.android.shopping.store.tabkit.model.k lastTab;
    private Long lastTimeStamp;
    private final MutableLiveData<Integer> loadStatus;
    private final ArrayList<ECLynxCard> lynxCards;
    private String marketingPageId;
    private final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, Boolean> navBarVisibilityMap;
    private boolean noRadius;
    private final MutableLiveData<Boolean> pageLandingFinished;
    private final HashMap<String, Boolean> recordedEventsMap;
    public TabKitRouterParams routerParams;
    private final MutableLiveData<Pair<Float, Float>> screenOffset;
    private final MutableLiveData<Float> screenOffsetFactor;
    private final MutableLiveData<Integer> screenState;
    private final SparseArray<TabKitTabFragment> tabFragmentsMap;
    private ITabKitComponentFactory tabKitComponentFactory;
    private final ArrayList<g> tabKitLifeListeners;
    private ok3.a tabKitMonitor;
    private Long tabKitMonitorId;
    private final MutableLiveData<z> tabResponse;
    private final ConcurrentHashMap<Integer, v> tabStates;
    private final MutableLiveData<Integer> tabSwitchMode;
    private TabkitPrefetchJobKey tabkitPrefetchJobKey;
    private final String tabsContainerId;
    private final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> topTabBarVisibilityMap;

    public static final class a {
        public a() {
        }

        public static String a(String r100, TabKitRouterParams r101, boolean r110, boolean r111, boolean r112) {
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L32
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L32
            CollectionsKt.addAll(r103, new String[]{"anchor_url", "ssr_url", "na_prefetch_cert"});     // Catch: Throwable -> L32
            if (r110 == true) goto L10;
            if (r112 == false) goto L7;
            r103.add(PhotoEnterModel.SOURCE_BTM_TOKEN);     // Catch: Throwable -> L32
        L7:
            List<String> r113 = hk3.a.d().a(r101.getBizTag());     // Catch: Throwable -> L32
            if (r113 == null) goto L10;
            r103.addAll(r113);     // Catch: Throwable -> L32
        L10:
            Uri r114 = UriProtector.parse(r100);     // Catch: Throwable -> L32
            Uri.Builder r115 = r114.buildUpon();     // Catch: Throwable -> L32
            Set<String> r116 = UriProtector.getQueryParameterNames(r114);     // Catch: Throwable -> L32
            ArrayList r104 = new ArrayList(r101.getParamsMap().keySet());     // Catch: Throwable -> L32
            r104.removeAll(r103);     // Catch: Throwable -> L32
            Iterator r105 = r104.iterator();     // Catch: Throwable -> L32
        L12:
            if (r105.hasNext() == false) goto L18;
            String r106 = (String) r105.next();     // Catch: Throwable -> L32
            if (r116.contains(r106) == true) goto L12;
            r115.appendQueryParameter(r106, r101.getParamsMap().get(r106));     // Catch: Throwable -> L32
            goto L12
        L18:
            if (r116.contains("disable_final_detect_when_detached") == true) goto L21;
            r115.appendQueryParameter("disable_final_detect_when_detached", "1");     // Catch: Throwable -> L32
        L21:
            if (r116.contains("ec_tabkit_container") == true) goto L24;
            r115.appendQueryParameter("ec_tabkit_container", "1");     // Catch: Throwable -> L32
        L24:
            if (r116.contains("loader_name") == true) goto L27;
            r115.appendQueryParameter("loader_name", "forest");     // Catch: Throwable -> L32
        L27:
            if (r116.contains("na_prefetch_sync_update") == true) goto L30;
            if (r111 == false) goto L30;
            r115.appendQueryParameter("na_prefetch_sync_update", "1");     // Catch: Throwable -> L32
        L30:
            return r115.toString();
        L32:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return r100;
        }
    }

    public static final class b implements ITabKitComponentFactory {
        public b() {
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final boolean getDisableBottomBar() {
            return false;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final BottomTabItemView createBottomTabItemView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AttributeSet r101 = null;
            return new BottomTabItemView(r100, r101, 6, 0);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final TopTabItemView createTopTabItemView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AttributeSet r101 = null;
            return new TopTabItemView(r100, r101, 6, 0);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final TabKitTabFragment createTab(com.bytedance.android.shopping.store.tabkit.model.k r100, boolean r101, TabKitAbilityConfig r102) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r100, "tab");
            Intrinsics.checkNotNullParameter(r102, "config");
            s r103 = r100.f();
            String r104 = null;
            if (r103 == null) goto L5;
            Integer r105 = r103.c();
        L7:
            if (r105 != null) goto L10;
        L23:
            boolean r106 = r102.b("btm_custom_page_v2");
            dm.a.a("ITabKitComponentFactory").i("createTab, enableBtmV2=" + r106);
            boolean r107 = false;
            if (r106 == false) goto L43;
            TabKitAnnieXTabFragment.Companion.getClass();
            if (TabKitAnnieXTabFragment.a.a(r100, r102) == false) goto L35;
            TabKitAnnieXTabFragmentV2.a r108 = TabKitAnnieXTabFragmentV2.Companion;
            Boolean r109 = Boolean.valueOf(!r101);
            r108.getClass();
            Intrinsics.checkNotNullParameter(r100, "tab");
            TabKitAnnieXTabFragmentV2 r110 = new TabKitAnnieXTabFragmentV2();
            Bundle r111 = new Bundle();
            Integer r112 = r100.n();
            if (r112 == null) goto L30;
            int r113 = r112.intValue();
        L31:
            r111.putInt("tab_id", r113);
            if (r109 == null) goto L34;
            r107 = r109.booleanValue();
        L34:
            r111.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r107);
            Unit r114 = Unit.INSTANCE;
            r110.setArguments(r111);
            r110.setLandingTab(r100.f186829e);
            TabKitTabFragment r115 = r110;
        L62:
            return r115;
        L30:
            r113 = 0;
            goto L31
        L35:
            TabKitHybridTabFragmentV2.a r116 = TabKitHybridTabFragmentV2.Companion;
            Boolean r117 = Boolean.valueOf(!r101);
            r116.getClass();
            Intrinsics.checkNotNullParameter(r100, "tab");
            TabKitHybridTabFragmentV2 r118 = new TabKitHybridTabFragmentV2();
            Bundle r119 = new Bundle();
            Integer r120 = r100.n();
            if (r120 == null) goto L38;
            int r121 = r120.intValue();
        L39:
            r119.putInt("tab_id", r121);
            if (r117 == null) goto L42;
            r107 = r117.booleanValue();
        L42:
            r119.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r107);
            Unit r122 = Unit.INSTANCE;
            r118.setArguments(r119);
            r118.setLandingTab(r100.f186829e);
            r115 = r118;
            goto L62
        L38:
            r121 = 0;
            goto L39
        L43:
            TabKitAnnieXTabFragment.Companion.getClass();
            if (TabKitAnnieXTabFragment.a.a(r100, r102) == false) goto L53;
            Boolean r123 = Boolean.valueOf(!r101);
            Intrinsics.checkNotNullParameter(r100, "tab");
            TabKitAnnieXTabFragment r124 = new TabKitAnnieXTabFragment();
            Bundle r125 = new Bundle();
            Integer r126 = r100.n();
            if (r126 == null) goto L48;
            int r127 = r126.intValue();
        L49:
            r125.putInt("tab_id", r127);
            if (r123 == null) goto L52;
            r107 = r123.booleanValue();
        L52:
            r125.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r107);
            Unit r128 = Unit.INSTANCE;
            r124.setArguments(r125);
            r124.setLandingTab(r100.f186829e);
            r115 = r124;
            goto L62
        L48:
            r127 = 0;
            goto L49
        L53:
            TabKitHybridTabFragment.a r129 = TabKitHybridTabFragment.Companion;
            Boolean r130 = Boolean.valueOf(!r101);
            r129.getClass();
            Intrinsics.checkNotNullParameter(r100, "tab");
            TabKitHybridTabFragment r131 = new TabKitHybridTabFragment();
            Bundle r132 = new Bundle();
            Integer r133 = r100.n();
            if (r133 == null) goto L56;
            int r134 = r133.intValue();
        L57:
            r132.putInt("tab_id", r134);
            if (r130 == null) goto L60;
            r107 = r130.booleanValue();
        L60:
            r132.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r107);
            Unit r135 = Unit.INSTANCE;
            r131.setArguments(r132);
            r131.setLandingTab(r100.f186829e);
            r115 = r131;
            goto L62
        L56:
            r134 = 0;
            goto L57
        L10:
            if (r105.intValue() != 4) goto L23;
            int r136 = TabKitMixFrameTabFragment.f186771j;
            Intrinsics.checkNotNullParameter(r100, "tab");
            TabKitMixFrameTabFragment r137 = new TabKitMixFrameTabFragment();
            Bundle r138 = new Bundle();
            r138.putSerializable("tab_id", r100.n());
            s r139 = r100.f();
            if (r139 == null) goto L16;
            com.bytedance.android.shopping.store.tabkit.model.a r140 = r139.a();
            if (r140 == null) goto L16;
            String r141 = r140.b();
        L17:
            r138.putSerializable("tab_api_url", r141);
            s r142 = r100.f();
            if (r142 == null) goto L22;
            com.bytedance.android.shopping.store.tabkit.model.a r143 = r142.a();
            if (r143 == null) goto L22;
            r104 = r143.a();
        L22:
            r138.putSerializable("tab_api_params", r104);
            Unit r144 = Unit.INSTANCE;
            r137.setArguments(r138);
            return r137;
        L16:
            r141 = null;
            goto L17
        L5:
            r105 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.TabKitViewModel$isRouterParamsInitialized$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(TabKitViewModel r100) {
            super(r100, TabKitViewModel.class, "routerParams", "getRouterParams()Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((TabKitViewModel) this.receiver).getRouterParams();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ((TabKitViewModel) this.receiver).setRouterParams((TabKitRouterParams) r100);
        }
    }

    public final boolean getLandingFinishedOpt() {
        return ((Boolean) this.landingFinishedOpt$delegate.getValue()).booleanValue();
    }

    static {
        Companion = new a();
    }

    public final void clearFragments() {
        this.tabFragmentsMap.clear();
    }

    public final TabKitAbilityConfig getAbilityConfig() {
        TabKitAbilityConfig r100 = this.abilityConfig;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L5:
        return r100;
    }

    public final Integer getAnchorTabId() {
        z r100 = this.tabResponse.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final boolean getCanShowSwipeIndicator() {
        Integer r100 = this.screenState.getValue();
        if (r100 != null) goto L6;
    L16:
        return false;
    L6:
        if (r100.intValue() != 1) goto L16;
        TabKitRouterParams r101 = this.routerParams;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L10:
        Integer r102 = r101.getSplitIndicatorHidden();
        if (r102 != null) goto L14;
        return true;
    L14:
        if (r102.intValue() == 1) goto L16;
        return true;
    }

    public final TabKitTabFragment getCurrentSelectedFragment() {
        y r100 = this.currentTab.getValue();
        if (r100 == null) goto L8;
        com.bytedance.android.shopping.store.tabkit.model.k r101 = r100.f186837a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return getTabFragment$default(this, r101, false, 2, null);
    L8:
        return null;
    }

    public final List<com.bytedance.android.shopping.store.tabkit.model.k> getHomeTabs() {
        z r100 = this.tabResponse.getValue();
        if (r100 == null) goto L7;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r101 = r100.j();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public final TabKitRouterParams getRouterParams() {
        TabKitRouterParams r100 = this.routerParams;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L5:
        return r100;
    }

    public final int getViewPagerTrulyPosition() {
        y r100 = this.currentTab.getValue();
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.store.tabkit.model.k r101 = r100.f186837a;
        if (r101 == null) goto L7;
        Integer r102 = r101.n();
    L9:
        return getTabTrulyIndex(r102);
    L7:
        r102 = null;
        goto L9
    }

    public final boolean isFullScreen() {
        Integer r100 = this.screenState.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 0) goto L8;
        return true;
    }

    public final boolean isRouterParamsInitialized() {
        if (this.routerParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void notifyLandingFinished() {
        TabKitRouterParams r100 = this.routerParams;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r100.getAnchorUrl()) == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.isLandingFinished.getValue(), Boolean.FALSE) == false) goto L12;
        this.isLandingFinished.setValue(Boolean.TRUE);
        return;
    }

    public final void notifyLandingStart() {
        TabKitRouterParams r100 = this.routerParams;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r100.getAnchorUrl()) == true) goto L8;
        return;
    L8:
        if (this.isLandingFinished.getValue() != null) goto L12;
        this.isLandingFinished.setValue(Boolean.FALSE);
        return;
    }

    public final void notifyPageLandingFinished() {
        this.pageLandingFinished.setValue(Boolean.TRUE);
    }

    public final void removeMonitor() {
        Long r100 = this.tabKitMonitorId;
        if (r100 == null) goto L6;
        long r101 = r100.longValue();
        Map<Long, TabkitFirstFramePref> r102 = ok3.a.f523622e;
        ok3.a.f523622e.remove(Long.valueOf(r101));
        return;
    }

    public TabKitViewModel() {
        this.screenState = new MutableLiveData();
        this.tabResponse = new MutableLiveData();
        this.interceptorHelper = new h();
        this.kvStorage = new i(this);
        this.screenOffsetFactor = new MutableLiveData();
        this.screenOffset = new MutableLiveData();
        this.loadStatus = new MutableLiveData();
        this.eventContext = new TabKitEventContext(this);
        this.currentHomeTab = new MutableLiveData();
        this.currentTab = new MutableLiveData();
        this.currentTabAfter = new MutableLiveData();
        this.foldScreenSize = new MutableLiveData();
        this.lynxCards = new ArrayList();
        this.hybridComponents = new ArrayList();
        this.jsEventStub = new com.bytedance.android.shopping.store.tabkit.bridge.c(this);
        this.jsBridge = new TabKitBridge(this);
        this.recordedEventsMap = new HashMap();
        this.navBarVisibilityMap = new HashMap();
        this.topTabBarVisibilityMap = new HashMap();
        this.firstSetData = true;
        this.isUseNativeTopBar = new MutableLiveData();
        this.isUseNativeBottomBar = new MutableLiveData();
        this.isLandingFinished = new MutableLiveData();
        this.pageLandingFinished = new MutableLiveData(Boolean.FALSE);
        this.landingFinishedOpt$delegate = LazyKt.lazy(TabKitViewModel$landingFinishedOpt$2.INSTANCE);
        this.tabSwitchMode = new MutableLiveData();
        this.tabsContainerId = UUID.randomUUID().toString();
        this.tabKitComponentFactory = new b();
        this.tabFragmentsMap = new SparseArray();
        this.dialogsMap = new HashMap();
        this.tabKitLifeListeners = new ArrayList();
        this.tabStates = new ConcurrentHashMap();
    }

    private final com.bytedance.android.shopping.store.tabkit.model.k getDefaultAnchorTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r100 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.firstOrNull(getHomeTabs());
        if (r100 == null) goto L9;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r101 = r100.m();
        if (r101 == null) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r102 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r101, 0);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.firstOrNull(getHomeTabs());
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getAnchorHomeTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r100 = getAnchorTab();
        if (r100 != null) goto L5;
    L10:
        com.bytedance.android.shopping.store.tabkit.model.k r101 = getAnchorTab();
        if (r101 != null) goto L16;
        return null;
    L16:
        return r101.f186825a;
    L5:
        if (r100.f186825a != null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L10;
        return getAnchorTab();
    L7:
        r102 = false;
        goto L8
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getAnchorTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r100 = getTargetAnchorTab();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return getDefaultAnchorTab();
    }

    public final r getTabDowngradeConfig() {
        Integer r100 = getAnchorTabId();
        if (r100 == null) goto L12;
        String r101 = String.valueOf(r100.intValue());
        if (r101 == null) goto L13;
        z r102 = this.tabResponse.getValue();
        if (r102 == null) goto L14;
        Map<String, r> r103 = r102.i();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.get(r101);
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTargetAnchorTab() {
        return getTabById(getAnchorTabId());
    }

    public final boolean getClickCloseBtn() {
        return this.clickCloseBtn;
    }

    public final MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> getCurrentHomeTab() {
        return this.currentHomeTab;
    }

    public final MutableLiveData<y> getCurrentTab() {
        return this.currentTab;
    }

    public final MutableLiveData<y> getCurrentTabAfter() {
        return this.currentTabAfter;
    }

    public final HashMap<String, ArrayList<TabKitDialogView>> getDialogsMap() {
        return this.dialogsMap;
    }

    public final TabKitEventContext getEventContext() {
        return this.eventContext;
    }

    public final boolean getFirstSetData() {
        return this.firstSetData;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getFoldScreenSize() {
        return this.foldScreenSize;
    }

    public final String getFoldType() {
        return this.foldType;
    }

    public final ArrayList<ti.l> getHybridComponents() {
        return this.hybridComponents;
    }

    public final h getInterceptorHelper() {
        return this.interceptorHelper;
    }

    public final TabKitBridge getJsBridge() {
        return this.jsBridge;
    }

    public final com.bytedance.android.shopping.store.tabkit.bridge.c getJsEventStub() {
        return this.jsEventStub;
    }

    public final i getKvStorage() {
        return this.kvStorage;
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getLastTab() {
        return this.lastTab;
    }

    public final Long getLastTimeStamp() {
        return this.lastTimeStamp;
    }

    public final MutableLiveData<Integer> getLoadStatus() {
        return this.loadStatus;
    }

    public final ArrayList<ECLynxCard> getLynxCards() {
        return this.lynxCards;
    }

    public final String getMarketingPageId() {
        return this.marketingPageId;
    }

    public final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, Boolean> getNavBarVisibilityMap() {
        return this.navBarVisibilityMap;
    }

    public final boolean getNoRadius() {
        return this.noRadius;
    }

    public final MutableLiveData<Boolean> getPageLandingFinished() {
        return this.pageLandingFinished;
    }

    public final HashMap<String, Boolean> getRecordedEventsMap() {
        return this.recordedEventsMap;
    }

    public final MutableLiveData<Pair<Float, Float>> getScreenOffset() {
        return this.screenOffset;
    }

    public final MutableLiveData<Float> getScreenOffsetFactor() {
        return this.screenOffsetFactor;
    }

    public final MutableLiveData<Integer> getScreenState() {
        return this.screenState;
    }

    public final ITabKitComponentFactory getTabKitComponentFactory() {
        return this.tabKitComponentFactory;
    }

    public final ArrayList<g> getTabKitLifeListeners() {
        return this.tabKitLifeListeners;
    }

    public final ok3.a getTabKitMonitor() {
        return this.tabKitMonitor;
    }

    public final Long getTabKitMonitorId() {
        return this.tabKitMonitorId;
    }

    public final MutableLiveData<z> getTabResponse() {
        return this.tabResponse;
    }

    public final MutableLiveData<Integer> getTabSwitchMode() {
        return this.tabSwitchMode;
    }

    public final TabkitPrefetchJobKey getTabkitPrefetchJobKey() {
        return this.tabkitPrefetchJobKey;
    }

    public final String getTabsContainerId() {
        return this.tabsContainerId;
    }

    public final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> getTopTabBarVisibilityMap() {
        return this.topTabBarVisibilityMap;
    }

    public final boolean isAnchorFinished() {
        return this.isAnchorFinished;
    }

    public final boolean isFoldPage() {
        return this.isFoldPage;
    }

    public final MutableLiveData<Boolean> isLandingFinished() {
        return this.isLandingFinished;
    }

    public final boolean isLitePage() {
        return this.isLitePage;
    }

    public final MutableLiveData<Boolean> isUseNativeBottomBar() {
        return this.isUseNativeBottomBar;
    }

    public final MutableLiveData<Boolean> isUseNativeTopBar() {
        return this.isUseNativeTopBar;
    }

    private final void filterErrorTabFragment(z r100) {
        int r101 = this.tabFragmentsMap.size();
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L24;
        int r104 = this.tabFragmentsMap.keyAt(r103);
        com.bytedance.android.shopping.store.tabkit.model.k r105 = getTabById(Integer.valueOf(this.tabFragmentsMap.get(r104).getTabId()));
        if (r105 == null) goto L23;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r106 = r100.j();
        if (r106 == null) goto L23;
        Iterator<T> r107 = r106.iterator();
    L11:
        if (r107.hasNext() == false) goto L23;
        com.bytedance.android.shopping.store.tabkit.model.k r108 = (com.bytedance.android.shopping.store.tabkit.model.k) r107.next();
        if (checkTabValid(r108, r105) == true) goto L15;
        r102.add(Integer.valueOf(r104));
    L15:
        List<com.bytedance.android.shopping.store.tabkit.model.k> r109 = r108.m();
        if (r109 == null) goto L11;
        Iterator<T> r110 = r109.iterator();
    L19:
        if (r110.hasNext() == false) goto L11;
        if (checkTabValid((com.bytedance.android.shopping.store.tabkit.model.k) r110.next(), r105) == true) goto L19;
        r102.add(Integer.valueOf(r104));
    L23:
        r103 = r103 + 1;
        goto L3
    L24:
        Iterator r111 = r102.iterator();
    L26:
        if (r111.hasNext() == false) goto L28;
        int r112 = ((Number) r111.next()).intValue();
        this.tabFragmentsMap.remove(r112);
        goto L26
    }

    private final void initMonitor(Bundle r100) {
        if (r100 == null) goto L5;
        Serializable r101 = r100.getSerializable(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
    L7:
        if ((r101 instanceof Long) == true) goto L9;
        r101 = null;
    L9:
        Long r102 = (Long) r101;
        if (r102 == null) goto L18;
        long r103 = r102.longValue();
        this.tabKitMonitorId = Long.valueOf(r103);
        Map<Long, TabkitFirstFramePref> r104 = ok3.a.f523622e;
        TabkitFirstFramePref r105 = ok3.a.C7061a.a(r103);
        if (r105 == null) goto L20;
        ok3.a r106 = new ok3.a(this, r105);
        this.tabKitMonitor = r106;
        TabkitFirstFramePref r107 = r106.f523626d;
        if (r107 == null) goto L19;
        TabkitFramePref.recordTime$default(r107, TabkitFirstFramePref.T_PAGE_INIT_END, null, 2, null);
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r101 = null;
        goto L7
    }

    private final void initPrefetchJobKey(Bundle r100) {
        Serializable r101 = null;
        if (r100 == null) goto L5;
        Serializable r102 = r100.getSerializable("tabkit_prefetch");
    L7:
        if ((r102 instanceof TabkitPrefetchJobKey) == false) goto L10;
        r101 = r102;
    L10:
        this.tabkitPrefetchJobKey = (TabkitPrefetchJobKey) r101;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void addTabKitLifeListener(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.tabKitLifeListeners.add(r100);
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTabById(Integer r100) {
        z r101 = this.tabResponse.getValue();
        if (r101 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r102 = r101.j();
    L6:
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        com.bytedance.android.shopping.store.tabkit.model.k r104 = (com.bytedance.android.shopping.store.tabkit.model.k) r103.next();
        if (Intrinsics.areEqual(r104.n(), r100) == true) goto L12;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r105 = r104.m();
        if (r105 == null) goto L9;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r107 = (com.bytedance.android.shopping.store.tabkit.model.k) r106.next();
        if (Intrinsics.areEqual(r107.n(), r100) == false) goto L17;
        return r107;
    L12:
        return r104;
    L21:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public final Pair<Integer, Integer> getTabIndex(com.bytedance.android.shopping.store.tabkit.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        z r101 = this.tabResponse.getValue();
        if (r101 == null) goto L30;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r102 = r101.j();
        if (r102 == null) goto L30;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L30;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.bytedance.android.shopping.store.tabkit.model.k r107 = (com.bytedance.android.shopping.store.tabkit.model.k) r105;
        if (Intrinsics.areEqual(r107, r100) == true) goto L15;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r108 = r107.m();
        if (r108 == null) goto L29;
        Iterator<T> r109 = r108.iterator();
        int r110 = 0;
    L20:
        if (r109.hasNext() == false) goto L29;
        Object r111 = r109.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        if (Intrinsics.areEqual((com.bytedance.android.shopping.store.tabkit.model.k) r111, r100) == true) goto L27;
        r110 = r112;
        goto L20
    L27:
        return new Pair(Integer.valueOf(r104), Integer.valueOf(r110));
    L29:
        r104 = r106;
        goto L8
    L15:
        return new Pair(Integer.valueOf(r104), 0);
    L30:
        Intrinsics.checkNotNull(null);
        return null;
    }

    public final v getTabState(Integer r100) {
        if (r100 == null) goto L11;
        r100.intValue();
        ConcurrentHashMap<Integer, v> r101 = this.tabStates;
        v r102 = r101.get(r100);
        if (r102 != null) goto L10;
        r102 = new v();
        v r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return r102;
    L11:
        return null;
    }

    public final int getTabTrulyIndex(Integer r100) {
        z r101 = this.tabResponse.getValue();
        if (r101 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r102 = r101.j();
    L6:
        int r103 = 0;
        if (r102 == null) goto L27;
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L27;
        com.bytedance.android.shopping.store.tabkit.model.k r105 = (com.bytedance.android.shopping.store.tabkit.model.k) r104.next();
        if (r105.g() == false) goto L14;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r106 = r105.m();
        if (r106 == null) goto L10;
        Iterator<T> r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.store.tabkit.model.k) r107.next()).n(), r100) == true) goto L24;
        r103 = r103 + 1;
        goto L21
    L24:
        return r103;
    L14:
        if (Intrinsics.areEqual(r105.n(), r100) == true) goto L15;
        r103 = r103 + 1;
        goto L10
    L15:
        return r103;
    L27:
        return r103 + 1;
    L5:
        r102 = null;
        goto L6
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTrulyTabByPosition(Integer r100) {
        z r101 = this.tabResponse.getValue();
        if (r101 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r102 = r101.j();
    L6:
        if (r102 == null) goto L30;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L30;
        com.bytedance.android.shopping.store.tabkit.model.k r105 = (com.bytedance.android.shopping.store.tabkit.model.k) r103.next();
        if (r105.g() == false) goto L12;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r106 = r105.m();
        if (r106 == null) goto L9;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r108 = (com.bytedance.android.shopping.store.tabkit.model.k) r107.next();
        if (r100 == null) goto L29;
        if (r104 != r100.intValue()) goto L29;
        return r108;
    L29:
        r104 = r104 + 1;
        goto L22
    L12:
        if (r100 != null) goto L15;
    L17:
        r104 = r104 + 1;
        goto L9
    L15:
        if (r104 != r100.intValue()) goto L17;
        return r105;
    L30:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public final void init(Bundle r100) {
        initMonitor(r100);
        TabKitRouterParams r101 = this.routerParams;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L5:
        this.abilityConfig = new TabKitAbilityConfig(r101);
        initPrefetchJobKey(r100);
    }

    public final boolean isTabAlreadyShow(Integer r100) {
        com.bytedance.android.shopping.store.tabkit.model.k r101 = getTabById(r100);
        Boolean r102 = null;
        if (r101 == null) goto L8;
        TabKitTabFragment r103 = getTabFragment(r101, false);
        if (r103 == null) goto L8;
        r102 = Boolean.valueOf(r103.isAlreadyShow());
    L8:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    }

    public final void prepare(Bundle r100) {
        Serializable r101 = null;
        if (r100 == null) goto L5;
        Serializable r102 = r100.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L7:
        if ((r102 instanceof TabKitRouterParams) == false) goto L10;
        r101 = r102;
    L10:
        TabKitRouterParams r103 = (TabKitRouterParams) r101;
        if (r103 != null) goto L13;
        r103 = new TabKitRouterParams();
    L13:
        this.routerParams = r103;
        boolean r104 = false;
        if (r100 == null) goto L16;
        r104 = r100.getBoolean("tabkit_lite_page", false);
    L16:
        this.isLitePage = r104;
        if (r100 == null) goto L24;
        String r105 = r100.getString("tabkit_fold_type");
        if (r105 == null) goto L25;
        String r106 = a2.c(r105);
        if (r106 == null) goto L26;
        this.foldType = r106;
        this.isFoldPage = true;
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setAbilityConfig(TabKitAbilityConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.abilityConfig = r100;
    }

    public final void setAnchorFinished(boolean r100) {
        this.isAnchorFinished = r100;
    }

    public final void setClickCloseBtn(boolean r100) {
        this.clickCloseBtn = r100;
    }

    public final void setFirstSetData(boolean r100) {
        this.firstSetData = r100;
    }

    public final void setFoldPage(boolean r100) {
        this.isFoldPage = r100;
    }

    public final void setFoldType(String r100) {
        this.foldType = r100;
    }

    public final void setLastTab(com.bytedance.android.shopping.store.tabkit.model.k r100) {
        this.lastTab = r100;
    }

    public final void setLastTimeStamp(Long r100) {
        this.lastTimeStamp = r100;
    }

    public final void setLitePage(boolean r100) {
        this.isLitePage = r100;
    }

    public final void setMarketingPageId(String r100) {
        this.marketingPageId = r100;
    }

    public final void setNoRadius(boolean r100) {
        this.noRadius = r100;
    }

    public final void setRouterParams(TabKitRouterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.routerParams = r100;
    }

    public final void setTabKitComponentFactory(ITabKitComponentFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabKitComponentFactory = r100;
    }

    public final void setTabKitData(z r100) {
        Intrinsics.checkNotNullParameter(r100, "tabsResponse");
        Map<String, String> r101 = r100.e();     // Catch: Exception -> L13
        if (r101 == null) goto L7;
        this.eventContext.getExtraParams().putAll(r101);     // Catch: Exception -> L13
    L7:
        if (r100.f186840a == true) goto L9;
        t.g(r100, this, true);     // Catch: Exception -> L13
    L9:
        this.loadStatus.setValue(1);     // Catch: Exception -> L13
        filterErrorTabFragment(r100);     // Catch: Exception -> L13
        this.tabResponse.setValue(r100);     // Catch: Exception -> L13
        cl.d.f24079a.getClass();     // Catch: Exception -> L13
        cl.d r102 = cl.d.a.b();     // Catch: Exception -> L13
        if (r102 == null) goto L17;
        r102.n();     // Catch: Exception -> L13
        return;
    L17:
        return;
    L13:
        e = move-exception;
        dm.a.a("ECTabKitDebug").i("setTabKitData error " + e);
        StackTraceElement[] r103 = e.getStackTrace();
        int r104 = r103.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L22;
        dm.a.a("ECTabKitDebug").i(String.valueOf(r103[r105]));
        r105 = r105 + 1;
        goto L15
    }

    public final void setTabKitMonitor(ok3.a r100) {
        this.tabKitMonitor = r100;
    }

    public final void setTabkitPrefetchJobKey(TabkitPrefetchJobKey r100) {
        this.tabkitPrefetchJobKey = r100;
    }

    private final boolean checkTabValid(com.bytedance.android.shopping.store.tabkit.model.k r100, com.bytedance.android.shopping.store.tabkit.model.k r110) {
        if (Intrinsics.areEqual(r100.n(), r110.n()) == false) goto L79;
        s r101 = r100.f();
        Integer r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.b();
        if (r103 == null) goto L9;
        Uri r104 = UriProtector.parse(r103);
    L10:
        s r105 = r110.f();
        if (r105 == null) goto L15;
        String r106 = r105.b();
        if (r106 == null) goto L15;
        Uri r107 = UriProtector.parse(r106);
    L16:
        int r108 = hk3.a.f485544a;
        int r109 = p.f45243a;
        Object r111 = Boolean.FALSE;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L21
        Object r114 = jj4.a.a("tabkit_check_tab_valid_opt", Boolean.class, r111, false);     // Catch: Throwable -> L21
        if (r114 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L21
    L28:
        if (((Boolean) r114).booleanValue() == false) goto L57;
        if (r104 == null) goto L31;
        String r115 = r104.getPath();
    L32:
        if (r107 == null) goto L34;
        String r116 = r107.getPath();
    L36:
        if (Intrinsics.areEqual(r115, r116) == false) goto L75;
        s r117 = r100.f();
        if (r117 == null) goto L40;
        Integer r118 = r117.c();
    L41:
        s r119 = r110.f();
        if (r119 == null) goto L44;
        Integer r120 = r119.c();
    L46:
        if (Intrinsics.areEqual(r118, r120) == false) goto L75;
        s r121 = r100.f();
        if (r121 == null) goto L50;
        Integer r122 = r121.d();
    L51:
        s r123 = r110.f();
        if (r123 == null) goto L55;
        r102 = r123.d();
    L55:
        if (Intrinsics.areEqual(r122, r102) == false) goto L75;
        return true;
    L50:
        r122 = null;
        goto L51
    L44:
        r120 = null;
        goto L46
    L40:
        r118 = null;
    L75:
        return false;
    L34:
        r116 = null;
        goto L36
    L31:
        r115 = null;
        goto L32
    L57:
        if (r104 == null) goto L59;
        String r124 = r104.getPath();
    L60:
        if (r107 == null) goto L62;
        String r125 = r107.getPath();
    L64:
        if (Intrinsics.areEqual(r124, r125) == false) goto L75;
        s r126 = r100.f();
        if (r126 == null) goto L68;
        Integer r127 = r126.c();
    L69:
        s r128 = r110.f();
        if (r128 == null) goto L73;
        r102 = r128.c();
    L73:
        if (Intrinsics.areEqual(r127, r102) == false) goto L75;
        return true;
    L68:
        r127 = null;
        goto L69
    L62:
        r125 = null;
        goto L64
    L59:
        r124 = null;
    L21:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Object r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r130) == true) goto L26;
        r111 = r130;
    L26:
        r114 = r111;
    L15:
        r107 = null;
    L9:
        r104 = null;
        goto L10
    L79:
        return true;
    }

    public final String buildBundleUrlWithRouterParams(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r102 = Companion;
        TabKitRouterParams r103 = this.routerParams;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L8:
        TabKitAbilityConfig r104 = this.abilityConfig;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L11:
        boolean r105 = r104.b("na_prefetch_sync_update");
        TabKitAbilityConfig r106 = this.abilityConfig;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L14:
        boolean r107 = r106.b("btm_custom_page_v2");
        r102.getClass();
        return a.a(r100, r103, r101, r105, r107);
    }

    public final TabKitTabFragment getTabFragment(com.bytedance.android.shopping.store.tabkit.model.k r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Integer r102 = r100.n();
        TabKitTabFragment r103 = null;
        if (r102 == null) goto L20;
        int r104 = r102.intValue();
        TabKitTabFragment r105 = this.tabFragmentsMap.get(r104);
        if (r105 != null) goto L21;
        if (r101 == false) goto L19;
        int r106 = 0;
        if (r100.f186825a == null) goto L10;
        boolean r107 = true;
    L11:
        ITabKitComponentFactory r108 = this.tabKitComponentFactory;
        TabKitAbilityConfig r109 = this.abilityConfig;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L14:
        r103 = r108.createTab(r100, r107, r109);
        SparseArray<TabKitTabFragment> r110 = this.tabFragmentsMap;
        Integer r111 = r100.n();
        if (r111 == null) goto L17;
        r106 = r111.intValue();
    L17:
        r110.put(r106, r103);
        goto L19
    L10:
        r107 = false;
    L19:
        return r103;
    L21:
        return r105;
    L20:
        return null;
    }

    public static /* synthetic */ String buildBundleUrlWithRouterParams$default(TabKitViewModel r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.buildBundleUrlWithRouterParams(r101, r102);
    }

    public static /* synthetic */ TabKitTabFragment getTabFragment$default(TabKitViewModel r100, com.bytedance.android.shopping.store.tabkit.model.k r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.getTabFragment(r101, r102);
    }
}
