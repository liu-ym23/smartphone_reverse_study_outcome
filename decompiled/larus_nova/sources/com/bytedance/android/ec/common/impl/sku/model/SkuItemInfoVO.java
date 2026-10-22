package com.bytedance.android.ec.common.impl.sku.model;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bÕ\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010RJ\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0011HÆ\u0003J\u0012\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010Þ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010â\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010ã\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\n\u0010ê\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010î\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\n\u0010ð\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u0005HÆ\u0003J\u0012\u0010ó\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+HÆ\u0003J\n\u0010ô\u0001\u001a\u00020.HÆ\u0003J\n\u0010õ\u0001\u001a\u00020.HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\u0012\u0010÷\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ù\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010û\u0001\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0080\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0084\u0002\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0087\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010HHÆ\u0003J\u0012\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J*\u0010\u0091\u0002\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`LHÆ\u0003J\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010NHÆ\u0003J\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0096\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0098\u0002\u001a\u00020\u0005HÆ\u0003Jª\u0006\u0010\u0099\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010'\u001a\u00020\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010)\u001a\u00020\u00052\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010.2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u009a\u0002J\u0015\u0010\u009b\u0002\u001a\u00020.2\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\n\u0010\u009d\u0002\u001a\u00020\u0011HÖ\u0001J\u0007\u0010\u009e\u0002\u001a\u00020.J\u0007\u0010\u009f\u0002\u001a\u00020.J\u0007\u0010 \u0002\u001a\u00020.J\u0007\u0010¡\u0002\u001a\u00020.J\n\u0010¢\u0002\u001a\u00020\u0003HÖ\u0001R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001e\u0010E\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010`\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010[\"\u0004\be\u0010fR\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010[R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bl\u0010bR\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010WR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010[R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010WR\u0015\u0010&\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010`\u001a\u0004\bp\u0010]R\u0015\u0010P\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u0010s\u001a\u0004\bq\u0010rR\u001a\u0010t\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010[R\u0015\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010`\u001a\u0004\b|\u0010]R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010[R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010[R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010WR#\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010[\"\u0005\b\u0086\u0001\u0010fR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R#\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001\"\u0006\b\u008a\u0001\u0010\u0083\u0001R!\u00105\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b\u008b\u0001\u0010r\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010[\"\u0005\b\u008f\u0001\u0010fR\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010[\"\u0005\b\u0091\u0001\u0010fR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010[\"\u0005\b\u0093\u0001\u0010fR\u0016\u0010O\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u0010s\u001a\u0005\b\u0094\u0001\u0010rR#\u0010D\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0095\u0001\u0010\u0081\u0001\"\u0006\b\u0096\u0001\u0010\u0083\u0001R#\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0097\u0001\u0010\u0081\u0001\"\u0006\b\u0098\u0001\u0010\u0083\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010[\"\u0005\b\u009a\u0001\u0010fR\u001f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010[\"\u0005\b\u009d\u0001\u0010fR\u0011\u0010/\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u0010vR\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b-\u0010vR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010[R\u0012\u0010\f\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010WR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010[R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\b¡\u0001\u0010\u0081\u0001R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010[R\u001e\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010W\"\u0005\b¨\u0001\u0010YR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010[R\u001c\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010W\"\u0005\b«\u0001\u0010YR\u0013\u0010\u0017\u001a\u00020\u0011¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010¤\u0001R#\u0010B\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0081\u0001\"\u0006\b®\u0001\u0010\u0083\u0001R\u001e\u0010Q\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010[\"\u0005\b°\u0001\u0010fR#\u0010=\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b±\u0001\u0010\u0081\u0001\"\u0006\b²\u0001\u0010\u0083\u0001R!\u0010@\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b³\u0001\u0010r\"\u0006\b´\u0001\u0010\u008d\u0001R\u001e\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010[\"\u0005\b¶\u0001\u0010fR\u001e\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010[\"\u0005\b¸\u0001\u0010fR\u001e\u0010A\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010[\"\u0005\bº\u0001\u0010fR#\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b»\u0001\u0010\u0081\u0001\"\u0006\b¼\u0001\u0010\u0083\u0001R!\u0010;\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b½\u0001\u0010r\"\u0006\b¾\u0001\u0010\u008d\u0001R!\u0010:\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b¿\u0001\u0010r\"\u0006\bÀ\u0001\u0010\u008d\u0001R\u001e\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010[\"\u0005\bÂ\u0001\u0010fR\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010[\"\u0005\bÄ\u0001\u0010fR\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010[\"\u0005\bÆ\u0001\u0010fR\u0012\u0010)\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\bÇ\u0001\u0010WR3\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001R\u001e\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010[\"\u0005\bË\u0001\u0010fR \u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\bÐ\u0001\u0010\u0081\u0001R\u001e\u0010F\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010[\"\u0005\bÒ\u0001\u0010fR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010W\"\u0005\bÔ\u0001\u0010YR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\bÕ\u0001\u0010\u0081\u0001R\u0014\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bÖ\u0001\u0010[R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\b×\u0001\u0010\u0081\u0001¨\u0006£\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "Ljava/io/Serializable;", "id", "", "stockNum", "", "unpayNum", "price", "originPrice", "discountPrice", "discountPriceText", "userLimit", "lowerLimit", "upperLimitToast", "lowerLimitToast", "limitText", "nowStock", "", "skuType", "benefitLabels", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "campaignPriceHeader", "priceHeaderStyle", "newBonusText", "marketPrice", "epInfo", "", "presellDelayDesc", "deliveryDelayDesc", "deliveryDelayBackground", "delayDescIcon", "delayDescStyle", "campaignStartTime", "campaignEndTime", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "atmosphereHeader", "campaignSubType", "depositPrice", "buttonLabel", "serverTime", "buttons", "", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "isSecKill", "", "isDepositPresale", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "firstPrice", "firstPricePrefix", "firstPriceSuffix", "firstPriceIsUnderline", "firstPriceSupplement", "secondPrice", "secondPricePrefix", "secondPriceSuffix", "secondPriceIsUnderline", "secondPriceIsReducePrice", "secondPriceSupplement", "regularPrice", "regularPricePrefix", "regularPriceSuffix", "regularPriceIsUnderline", "regularPriceSupplement", "priceType", "hotMinPrice", "hotMaxPrice", "atmosphereStyle", "stockDesc", "skuStatusDetail", "Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "skuExtra", "showEventTrack", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "buttonTip", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "hideTradeIn", "canAddCart", "promiseType", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;JLjava/util/List;ZZLcom/bytedance/android/ec/model/sku/CarAdaptComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "activityStock", "getActivityStock", "()J", "setActivityStock", "(J)V", "getAtmosphereHeader", "()Ljava/lang/String;", "getAtmosphereStyle", "()Ljava/lang/Integer;", "setAtmosphereStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBenefitLabels", "()Ljava/util/List;", "bigImageUrl", "getBigImageUrl", "setBigImageUrl", "(Ljava/lang/String;)V", "getButtonLabel", "getButtonTip", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "setButtonTip", "(Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;)V", "getButtons", "getCampaignEndTime", "getCampaignPriceHeader", "getCampaignStartTime", "getCampaignSubType", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "canSelect", "getCanSelect", "()Z", "setCanSelect", "(Z)V", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getDelayDescIcon", "getDelayDescStyle", "getDeliveryDelayBackground", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "()Ljava/lang/Long;", "setDiscountPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDiscountPriceText", "setDiscountPriceText", "getEpInfo", "()Ljava/lang/Object;", "getFirstPrice", "setFirstPrice", "getFirstPriceIsUnderline", "setFirstPriceIsUnderline", "(Ljava/lang/Boolean;)V", "getFirstPricePrefix", "setFirstPricePrefix", "getFirstPriceSuffix", "setFirstPriceSuffix", "getFirstPriceSupplement", "setFirstPriceSupplement", "getHideTradeIn", "getHotMaxPrice", "setHotMaxPrice", "getHotMinPrice", "setHotMinPrice", "getId", "setId", "imageUrl", "getImageUrl", "setImageUrl", "getLimitText", "getLowerLimit", "getLowerLimitToast", "getMarketPrice", "getNewBonusText", "getNowStock", "()I", "setNowStock", "(I)V", "getOriginPrice", "setOriginPrice", "getPresellDelayDesc", "getPrice", "setPrice", "getPriceHeaderStyle", "getPriceType", "setPriceType", "getPromiseType", "setPromiseType", "getRegularPrice", "setRegularPrice", "getRegularPriceIsUnderline", "setRegularPriceIsUnderline", "getRegularPricePrefix", "setRegularPricePrefix", "getRegularPriceSuffix", "setRegularPriceSuffix", "getRegularPriceSupplement", "setRegularPriceSupplement", "getSecondPrice", "setSecondPrice", "getSecondPriceIsReducePrice", "setSecondPriceIsReducePrice", "getSecondPriceIsUnderline", "setSecondPriceIsUnderline", "getSecondPricePrefix", "setSecondPricePrefix", "getSecondPriceSuffix", "setSecondPriceSuffix", "getSecondPriceSupplement", "setSecondPriceSupplement", "getServerTime", "getShowEventTrack", "()Ljava/util/HashMap;", "getSkuExtra", "setSkuExtra", "getSkuStatusDetail", "()Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "setSkuStatusDetail", "(Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;)V", "getSkuType", "getStockDesc", "setStockDesc", "getStockNum", "setStockNum", "getUnpayNum", "getUpperLimitToast", "getUserLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;JLjava/util/List;ZZLcom/bytedance/android/ec/model/sku/CarAdaptComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "equals", "other", "hashCode", "isGroupBuy", "isInDepositPresale", "isInPreSecKill", "isInSecKill", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuItemInfoVO implements Serializable {
    private final ECUrlModel activityIcon;
    private long activityStock;
    private final String atmosphereHeader;
    private Integer atmosphereStyle;
    private final List<PromotionBenefitLabel> benefitLabels;
    private String bigImageUrl;
    private final String buttonLabel;
    private ButtonTipComponent buttonTip;
    private final List<SkuBottomButtons> buttons;
    private final long campaignEndTime;
    private final String campaignPriceHeader;
    private final long campaignStartTime;
    private final Integer campaignSubType;
    private final Boolean canAddCart;
    private boolean canSelect;
    private final CarAdaptComponent carAdaptComponent;
    private final String delayDescIcon;
    private final Integer delayDescStyle;
    private final String deliveryDelayBackground;
    private final String deliveryDelayDesc;
    private final long depositPrice;
    private Long discountPrice;
    private String discountPriceText;
    private final Object epInfo;
    private Long firstPrice;
    private Boolean firstPriceIsUnderline;
    private String firstPricePrefix;
    private String firstPriceSuffix;
    private String firstPriceSupplement;
    private final Boolean hideTradeIn;
    private Long hotMaxPrice;
    private Long hotMinPrice;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f43093id;
    private String imageUrl;
    private final boolean isDepositPresale;
    private final boolean isSecKill;
    private final String limitText;
    private final long lowerLimit;
    private final String lowerLimitToast;
    private final Long marketPrice;
    private final String newBonusText;
    private int nowStock;
    private long originPrice;
    private final String presellDelayDesc;
    private long price;
    private final int priceHeaderStyle;
    private Long priceType;
    private String promiseType;
    private Long regularPrice;
    private Boolean regularPriceIsUnderline;
    private String regularPricePrefix;
    private String regularPriceSuffix;
    private String regularPriceSupplement;
    private Long secondPrice;
    private Boolean secondPriceIsReducePrice;
    private Boolean secondPriceIsUnderline;
    private String secondPricePrefix;
    private String secondPriceSuffix;
    private String secondPriceSupplement;
    private final long serverTime;
    private final HashMap<String, String> showEventTrack;
    private String skuExtra;
    private SkuStatusDetail skuStatusDetail;
    private final Long skuType;
    private String stockDesc;
    private long stockNum;
    private final Long unpayNum;
    private final String upperLimitToast;
    private final Long userLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuItemInfoVO copy$default(SkuItemInfoVO r210, String r211, long r212, Long r213, long r214, long r310, Long r311, String r312, Long r313, long r314, String r315, String r316, String r410, int r411, Long r412, List r413, String r414, int r415, String r416, Long r417, Object r418, String r419, String r510, String r511, String r512, Integer r513, long r514, long r515, ECUrlModel r516, String r517, Integer r610, long r611, String r612, long r613, List r614, boolean r615, boolean r616, CarAdaptComponent r617, Long r710, String r711, String r712, Boolean r713, String r714, Long r715, String r716, String r717, Boolean r718, Boolean r719, String r810, Long r811, String r812, String r813, Boolean r814, String r815, Long r816, Long r817, Long r818, Integer r819, String r910, SkuStatusDetail r911, String r912, HashMap r913, ButtonTipComponent r914, Boolean r915, Boolean r916, String r917, int r918, int r919, int r100, Object r101) {
        if ((r918 & 1) == 0) goto L5;
        String r102 = r210.f43093id;
    L7:
        if ((r918 & 2) == 0) goto L9;
        long r103 = r210.stockNum;
    L11:
        if ((r918 & 4) == 0) goto L13;
        Long r104 = r210.unpayNum;
    L15:
        if ((r918 & 8) == 0) goto L17;
        long r105 = r210.price;
    L19:
        if ((r918 & 16) == 0) goto L21;
        long r106 = r210.originPrice;
    L23:
        if ((r918 & 32) == 0) goto L25;
        Long r110 = r210.discountPrice;
    L27:
        if ((r918 & 64) == 0) goto L29;
        String r111 = r210.discountPriceText;
    L31:
        if ((r918 & 128) == 0) goto L33;
        Long r112 = r210.userLimit;
    L35:
        if ((r918 & 256) == 0) goto L37;
        long r113 = r210.lowerLimit;
    L38:
        long r317 = r113;
        if ((r918 & 512) == 0) goto L41;
        String r114 = r210.upperLimitToast;
    L43:
        if ((r918 & 1024) == 0) goto L45;
        String r115 = r210.lowerLimitToast;
    L46:
        String r318 = r115;
        if ((r918 & 2048) == 0) goto L49;
        String r116 = r210.limitText;
    L50:
        String r420 = r116;
        if ((r918 & 4096) == 0) goto L53;
        int r117 = r210.nowStock;
    L54:
        int r421 = r117;
        if ((r918 & 8192) == 0) goto L57;
        Long r118 = r210.skuType;
    L58:
        Long r422 = r118;
        if ((r918 & 16384) == 0) goto L61;
        List r119 = r210.benefitLabels;
    L62:
        List r423 = r119;
        if ((r918 & 32768) == 0) goto L65;
        String r120 = r210.campaignPriceHeader;
    L66:
        String r424 = r120;
        if ((r918 & 65536) == 0) goto L69;
        int r121 = r210.priceHeaderStyle;
    L70:
        int r425 = r121;
        if ((r918 & 131072) == 0) goto L73;
        String r122 = r210.newBonusText;
    L74:
        String r426 = r122;
        if ((r918 & 262144) == 0) goto L77;
        Long r123 = r210.marketPrice;
    L78:
        Long r427 = r123;
        if ((r918 & 524288) == 0) goto L81;
        Object r124 = r210.epInfo;
    L82:
        Object r428 = r124;
        if ((r918 & 1048576) == 0) goto L85;
        String r125 = r210.presellDelayDesc;
    L86:
        String r429 = r125;
        if ((r918 & 2097152) == 0) goto L89;
        String r126 = r210.deliveryDelayDesc;
    L90:
        String r518 = r126;
        if ((r918 & 4194304) == 0) goto L93;
        String r127 = r210.deliveryDelayBackground;
    L94:
        String r519 = r127;
        if ((r918 & 8388608) == 0) goto L97;
        String r128 = r210.delayDescIcon;
    L98:
        String r520 = r128;
        if ((r918 & 16777216) == 0) goto L101;
        Integer r129 = r210.delayDescStyle;
    L102:
        String r319 = r114;
        Integer r521 = r129;
        if ((r918 & 33554432) == 0) goto L105;
        long r130 = r210.campaignStartTime;
    L106:
        long r522 = r130;
        if ((r918 & 67108864) == 0) goto L109;
        long r131 = r210.campaignEndTime;
    L110:
        long r523 = r131;
        if ((r918 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ECUrlModel r132 = r210.activityIcon;
    L115:
        if ((268435456 & r918) == 0) goto L117;
        String r133 = r210.atmosphereHeader;
    L118:
        String r524 = r133;
        if ((r918 & 536870912) == 0) goto L121;
        Integer r134 = r210.campaignSubType;
    L122:
        ECUrlModel r525 = r132;
        Integer r618 = r134;
        if ((r918 & 1073741824) == 0) goto L125;
        long r135 = r210.depositPrice;
    L127:
        if ((r918 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r210.buttonLabel;
    L130:
        long r619 = r135;
        if ((r919 & 1) == 0) goto L133;
        long r136 = r210.serverTime;
    L134:
        long r620 = r136;
        if ((r919 & 2) == 0) goto L137;
        List r137 = r210.buttons;
    L139:
        if ((r919 & 4) == 0) goto L141;
        boolean r138 = r210.isSecKill;
    L142:
        boolean r621 = r138;
        if ((r919 & 8) == 0) goto L145;
        boolean r139 = r210.isDepositPresale;
    L146:
        boolean r622 = r139;
        if ((r919 & 16) == 0) goto L149;
        CarAdaptComponent r140 = r210.carAdaptComponent;
    L150:
        CarAdaptComponent r623 = r140;
        if ((r919 & 32) == 0) goto L153;
        Long r141 = r210.firstPrice;
    L154:
        Long r720 = r141;
        if ((r919 & 64) == 0) goto L157;
        String r142 = r210.firstPricePrefix;
    L158:
        String r721 = r142;
        if ((r919 & 128) == 0) goto L161;
        String r143 = r210.firstPriceSuffix;
    L162:
        String r722 = r143;
        if ((r919 & 256) == 0) goto L165;
        Boolean r144 = r210.firstPriceIsUnderline;
    L166:
        Boolean r723 = r144;
        if ((r919 & 512) == 0) goto L169;
        String r145 = r210.firstPriceSupplement;
    L170:
        String r724 = r145;
        if ((r919 & 1024) == 0) goto L173;
        Long r146 = r210.secondPrice;
    L174:
        Long r725 = r146;
        if ((r919 & 2048) == 0) goto L177;
        String r147 = r210.secondPricePrefix;
    L178:
        String r726 = r147;
        if ((r919 & 4096) == 0) goto L181;
        String r148 = r210.secondPriceSuffix;
    L182:
        String r727 = r148;
        if ((r919 & 8192) == 0) goto L185;
        Boolean r149 = r210.secondPriceIsUnderline;
    L186:
        Boolean r728 = r149;
        if ((r919 & 16384) == 0) goto L189;
        Boolean r150 = r210.secondPriceIsReducePrice;
    L190:
        Boolean r729 = r150;
        if ((r919 & 32768) == 0) goto L193;
        String r151 = r210.secondPriceSupplement;
    L194:
        String r820 = r151;
        if ((r919 & 65536) == 0) goto L197;
        Long r152 = r210.regularPrice;
    L198:
        Long r821 = r152;
        if ((r919 & 131072) == 0) goto L201;
        String r153 = r210.regularPricePrefix;
    L202:
        String r822 = r153;
        if ((r919 & 262144) == 0) goto L205;
        String r154 = r210.regularPriceSuffix;
    L206:
        String r823 = r154;
        if ((r919 & 524288) == 0) goto L209;
        Boolean r155 = r210.regularPriceIsUnderline;
    L210:
        Boolean r824 = r155;
        if ((r919 & 1048576) == 0) goto L213;
        String r156 = r210.regularPriceSupplement;
    L214:
        String r825 = r156;
        if ((r919 & 2097152) == 0) goto L217;
        Long r157 = r210.priceType;
    L218:
        Long r826 = r157;
        if ((r919 & 4194304) == 0) goto L221;
        Long r158 = r210.hotMinPrice;
    L222:
        Long r827 = r158;
        if ((r919 & 8388608) == 0) goto L225;
        Long r159 = r210.hotMaxPrice;
    L226:
        Long r828 = r159;
        if ((r919 & 16777216) == 0) goto L229;
        Integer r160 = r210.atmosphereStyle;
    L230:
        Integer r829 = r160;
        if ((r919 & 33554432) == 0) goto L233;
        String r161 = r210.stockDesc;
    L234:
        String r920 = r161;
        if ((r919 & 67108864) == 0) goto L237;
        SkuStatusDetail r162 = r210.skuStatusDetail;
    L238:
        SkuStatusDetail r921 = r162;
        if ((r919 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r163 = r210.skuExtra;
    L242:
        String r922 = r163;
        if ((r919 & 268435456) == 0) goto L245;
        HashMap r164 = r210.showEventTrack;
    L246:
        HashMap r923 = r164;
        if ((r919 & 536870912) == 0) goto L249;
        ButtonTipComponent r165 = r210.buttonTip;
    L250:
        ButtonTipComponent r924 = r165;
        if ((r919 & 1073741824) == 0) goto L253;
        Boolean r166 = r210.hideTradeIn;
    L255:
        if ((r919 & Integer.MIN_VALUE) == 0) goto L257;
        Boolean r108 = r210.canAddCart;
    L258:
        Boolean r925 = r108;
        if ((r100 & 1) == 0) goto L261;
        String r109 = r210.promiseType;
    L263:
        return r210.copy(r102, r103, r104, r105, r106, r110, r111, r112, r317, r319, r318, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r518, r519, r520, r521, r522, r523, r525, r524, r618, r619, r107, r620, r137, r621, r622, r623, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r820, r821, r822, r823, r824, r825, r826, r827, r828, r829, r920, r921, r922, r923, r924, r166, r925, r109);
    L261:
        r109 = r917;
        goto L263
    L257:
        r108 = r916;
        goto L258
    L253:
        r166 = r915;
        goto L255
    L249:
        r165 = r914;
        goto L250
    L245:
        r164 = r913;
        goto L246
    L241:
        r163 = r912;
        goto L242
    L237:
        r162 = r911;
        goto L238
    L233:
        r161 = r910;
        goto L234
    L229:
        r160 = r819;
        goto L230
    L225:
        r159 = r818;
        goto L226
    L221:
        r158 = r817;
        goto L222
    L217:
        r157 = r816;
        goto L218
    L213:
        r156 = r815;
        goto L214
    L209:
        r155 = r814;
        goto L210
    L205:
        r154 = r813;
        goto L206
    L201:
        r153 = r812;
        goto L202
    L197:
        r152 = r811;
        goto L198
    L193:
        r151 = r810;
        goto L194
    L189:
        r150 = r719;
        goto L190
    L185:
        r149 = r718;
        goto L186
    L181:
        r148 = r717;
        goto L182
    L177:
        r147 = r716;
        goto L178
    L173:
        r146 = r715;
        goto L174
    L169:
        r145 = r714;
        goto L170
    L165:
        r144 = r713;
        goto L166
    L161:
        r143 = r712;
        goto L162
    L157:
        r142 = r711;
        goto L158
    L153:
        r141 = r710;
        goto L154
    L149:
        r140 = r617;
        goto L150
    L145:
        r139 = r616;
        goto L146
    L141:
        r138 = r615;
        goto L142
    L137:
        r137 = r614;
        goto L139
    L133:
        r136 = r613;
        goto L134
    L129:
        r107 = r612;
        goto L130
    L125:
        r135 = r611;
        goto L127
    L121:
        r134 = r610;
        goto L122
    L117:
        r133 = r517;
        goto L118
    L113:
        r132 = r516;
        goto L115
    L109:
        r131 = r515;
        goto L110
    L105:
        r130 = r514;
        goto L106
    L101:
        r129 = r513;
        goto L102
    L97:
        r128 = r512;
        goto L98
    L93:
        r127 = r511;
        goto L94
    L89:
        r126 = r510;
        goto L90
    L85:
        r125 = r419;
        goto L86
    L81:
        r124 = r418;
        goto L82
    L77:
        r123 = r417;
        goto L78
    L73:
        r122 = r416;
        goto L74
    L69:
        r121 = r415;
        goto L70
    L65:
        r120 = r414;
        goto L66
    L61:
        r119 = r413;
        goto L62
    L57:
        r118 = r412;
        goto L58
    L53:
        r117 = r411;
        goto L54
    L49:
        r116 = r410;
        goto L50
    L45:
        r115 = r316;
        goto L46
    L41:
        r114 = r315;
        goto L43
    L37:
        r113 = r314;
        goto L38
    L33:
        r112 = r313;
        goto L35
    L29:
        r111 = r312;
        goto L31
    L25:
        r110 = r311;
        goto L27
    L21:
        r106 = r310;
        goto L23
    L17:
        r105 = r214;
        goto L19
    L13:
        r104 = r213;
        goto L15
    L9:
        r103 = r212;
        goto L11
    L5:
        r102 = r211;
        goto L7
    }

    public final String component1() {
        return this.f43093id;
    }

    public final String component10() {
        return this.upperLimitToast;
    }

    public final String component11() {
        return this.lowerLimitToast;
    }

    public final String component12() {
        return this.limitText;
    }

    public final int component13() {
        return this.nowStock;
    }

    public final Long component14() {
        return this.skuType;
    }

    public final List<PromotionBenefitLabel> component15() {
        return this.benefitLabels;
    }

    public final String component16() {
        return this.campaignPriceHeader;
    }

    public final int component17() {
        return this.priceHeaderStyle;
    }

    public final String component18() {
        return this.newBonusText;
    }

    public final Long component19() {
        return this.marketPrice;
    }

    public final long component2() {
        return this.stockNum;
    }

    public final Object component20() {
        return this.epInfo;
    }

    public final String component21() {
        return this.presellDelayDesc;
    }

    public final String component22() {
        return this.deliveryDelayDesc;
    }

    public final String component23() {
        return this.deliveryDelayBackground;
    }

    public final String component24() {
        return this.delayDescIcon;
    }

    public final Integer component25() {
        return this.delayDescStyle;
    }

    public final long component26() {
        return this.campaignStartTime;
    }

    public final long component27() {
        return this.campaignEndTime;
    }

    public final ECUrlModel component28() {
        return this.activityIcon;
    }

    public final String component29() {
        return this.atmosphereHeader;
    }

    public final Long component3() {
        return this.unpayNum;
    }

    public final Integer component30() {
        return this.campaignSubType;
    }

    public final long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.buttonLabel;
    }

    public final long component33() {
        return this.serverTime;
    }

    public final List<SkuBottomButtons> component34() {
        return this.buttons;
    }

    public final boolean component35() {
        return this.isSecKill;
    }

    public final boolean component36() {
        return this.isDepositPresale;
    }

    public final CarAdaptComponent component37() {
        return this.carAdaptComponent;
    }

    public final Long component38() {
        return this.firstPrice;
    }

    public final String component39() {
        return this.firstPricePrefix;
    }

    public final long component4() {
        return this.price;
    }

    public final String component40() {
        return this.firstPriceSuffix;
    }

    public final Boolean component41() {
        return this.firstPriceIsUnderline;
    }

    public final String component42() {
        return this.firstPriceSupplement;
    }

    public final Long component43() {
        return this.secondPrice;
    }

    public final String component44() {
        return this.secondPricePrefix;
    }

    public final String component45() {
        return this.secondPriceSuffix;
    }

    public final Boolean component46() {
        return this.secondPriceIsUnderline;
    }

    public final Boolean component47() {
        return this.secondPriceIsReducePrice;
    }

    public final String component48() {
        return this.secondPriceSupplement;
    }

    public final Long component49() {
        return this.regularPrice;
    }

    public final long component5() {
        return this.originPrice;
    }

    public final String component50() {
        return this.regularPricePrefix;
    }

    public final String component51() {
        return this.regularPriceSuffix;
    }

    public final Boolean component52() {
        return this.regularPriceIsUnderline;
    }

    public final String component53() {
        return this.regularPriceSupplement;
    }

    public final Long component54() {
        return this.priceType;
    }

    public final Long component55() {
        return this.hotMinPrice;
    }

    public final Long component56() {
        return this.hotMaxPrice;
    }

    public final Integer component57() {
        return this.atmosphereStyle;
    }

    public final String component58() {
        return this.stockDesc;
    }

    public final SkuStatusDetail component59() {
        return this.skuStatusDetail;
    }

    public final Long component6() {
        return this.discountPrice;
    }

    public final String component60() {
        return this.skuExtra;
    }

    public final HashMap<String, String> component61() {
        return this.showEventTrack;
    }

    public final ButtonTipComponent component62() {
        return this.buttonTip;
    }

    public final Boolean component63() {
        return this.hideTradeIn;
    }

    public final Boolean component64() {
        return this.canAddCart;
    }

    public final String component65() {
        return this.promiseType;
    }

    public final String component7() {
        return this.discountPriceText;
    }

    public final Long component8() {
        return this.userLimit;
    }

    public final long component9() {
        return this.lowerLimit;
    }

    public final SkuItemInfoVO copy(String r710, long r711, Long r712, long r810, long r811, Long r812, String r813, Long r814, long r815, String r816, String r910, String r911, int r912, Long r913, List<PromotionBenefitLabel> r914, String r915, int r916, String r917, Long r918, Object r919, String r100, String r101, String r102, String r103, Integer r104, long r105, long r107, ECUrlModel r109, String r110, Integer r111, long r112, String r114, long r115, List<SkuBottomButtons> r117, boolean r118, boolean r119, CarAdaptComponent r120, Long r121, String r122, String r123, Boolean r124, String r125, Long r126, String r127, String r128, Boolean r129, Boolean r130, String r131, Long r132, String r133, String r134, Boolean r135, String r136, Long r137, Long r138, Long r139, Integer r140, String r141, SkuStatusDetail r142, String r143, HashMap<String, String> r144, ButtonTipComponent r145, Boolean r146, Boolean r147, String r148) {
        Intrinsics.checkNotNullParameter(r813, "discountPriceText");
        Intrinsics.checkNotNullParameter(r915, "campaignPriceHeader");
        return new SkuItemInfoVO(r710, r711, r712, r810, r811, r812, r813, r814, r815, r816, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r107, r109, r110, r111, r112, r114, r115, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuItemInfoVO) == false) goto L136;
        SkuItemInfoVO r101 = (SkuItemInfoVO) r100;
        if (Intrinsics.areEqual(this.f43093id, r101.f43093id) == true) goto L8;
        return false;
    L8:
        if (this.stockNum == r101.stockNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.unpayNum, r101.unpayNum) == true) goto L12;
        return false;
    L12:
        if (this.price == r101.price) goto L14;
        return false;
    L14:
        if (this.originPrice == r101.originPrice) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPriceText, r101.discountPriceText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.userLimit, r101.userLimit) == true) goto L22;
        return false;
    L22:
        if (this.lowerLimit == r101.lowerLimit) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.upperLimitToast, r101.upperLimitToast) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.lowerLimitToast, r101.lowerLimitToast) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.limitText, r101.limitText) == true) goto L30;
        return false;
    L30:
        if (this.nowStock == r101.nowStock) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.skuType, r101.skuType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.benefitLabels, r101.benefitLabels) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.campaignPriceHeader, r101.campaignPriceHeader) == true) goto L38;
        return false;
    L38:
        if (this.priceHeaderStyle == r101.priceHeaderStyle) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.newBonusText, r101.newBonusText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.epInfo, r101.epInfo) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.presellDelayDesc, r101.presellDelayDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r101.deliveryDelayDesc) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.deliveryDelayBackground, r101.deliveryDelayBackground) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.delayDescIcon, r101.delayDescIcon) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.delayDescStyle, r101.delayDescStyle) == true) goto L56;
        return false;
    L56:
        if (this.campaignStartTime == r101.campaignStartTime) goto L58;
        return false;
    L58:
        if (this.campaignEndTime == r101.campaignEndTime) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.activityIcon, r101.activityIcon) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.atmosphereHeader, r101.atmosphereHeader) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.campaignSubType, r101.campaignSubType) == true) goto L66;
        return false;
    L66:
        if (this.depositPrice == r101.depositPrice) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L70;
        return false;
    L70:
        if (this.serverTime == r101.serverTime) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L74;
        return false;
    L74:
        if (this.isSecKill == r101.isSecKill) goto L76;
        return false;
    L76:
        if (this.isDepositPresale == r101.isDepositPresale) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.carAdaptComponent, r101.carAdaptComponent) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.firstPrice, r101.firstPrice) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.firstPricePrefix, r101.firstPricePrefix) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.firstPriceSuffix, r101.firstPriceSuffix) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.firstPriceIsUnderline, r101.firstPriceIsUnderline) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.firstPriceSupplement, r101.firstPriceSupplement) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.secondPrice, r101.secondPrice) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.secondPricePrefix, r101.secondPricePrefix) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.secondPriceSuffix, r101.secondPriceSuffix) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.secondPriceIsUnderline, r101.secondPriceIsUnderline) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.secondPriceIsReducePrice, r101.secondPriceIsReducePrice) == true) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.secondPriceSupplement, r101.secondPriceSupplement) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.regularPrice, r101.regularPrice) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.regularPricePrefix, r101.regularPricePrefix) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.regularPriceSuffix, r101.regularPriceSuffix) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.regularPriceIsUnderline, r101.regularPriceIsUnderline) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.regularPriceSupplement, r101.regularPriceSupplement) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.priceType, r101.priceType) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.hotMinPrice, r101.hotMinPrice) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.hotMaxPrice, r101.hotMaxPrice) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.atmosphereStyle, r101.atmosphereStyle) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.stockDesc, r101.stockDesc) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.skuStatusDetail, r101.skuStatusDetail) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.skuExtra, r101.skuExtra) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.showEventTrack, r101.showEventTrack) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.buttonTip, r101.buttonTip) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.hideTradeIn, r101.hideTradeIn) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.canAddCart, r101.canAddCart) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.promiseType, r101.promiseType) == true) goto L205;
        return false;
    L205:
        return true;
    L136:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v70, types: [int] */
    /* JADX WARN: Type inference failed for: r2v203 */
    /* JADX WARN: Type inference failed for: r2v227 */
    /* JADX WARN: Type inference failed for: r2v88, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    public int hashCode() {
        String r100 = this.f43093id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.stockNum;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Long r105 = this.unpayNum;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        long r108 = this.price;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.originPrice;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Long r112 = this.discountPrice;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.discountPriceText;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.userLimit;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (r117 + r119) * 31;
        long r121 = this.lowerLimit;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        String r123 = this.upperLimitToast;
        if (r123 == null) goto L25;
        int r124 = r123.hashCode();
    L26:
        int r125 = (r122 + r124) * 31;
        String r126 = this.lowerLimitToast;
        if (r126 == null) goto L29;
        int r127 = r126.hashCode();
    L30:
        int r128 = (r125 + r127) * 31;
        String r129 = this.limitText;
        if (r129 == null) goto L33;
        int r130 = r129.hashCode();
    L34:
        int r131 = (((r128 + r130) * 31) + this.nowStock) * 31;
        Long r132 = this.skuType;
        if (r132 == null) goto L37;
        int r133 = r132.hashCode();
    L38:
        int r134 = (r131 + r133) * 31;
        List<PromotionBenefitLabel> r135 = this.benefitLabels;
        if (r135 == null) goto L41;
        int r136 = r135.hashCode();
    L42:
        int r137 = (r134 + r136) * 31;
        String r138 = this.campaignPriceHeader;
        if (r138 == null) goto L45;
        int r139 = r138.hashCode();
    L46:
        int r140 = (((r137 + r139) * 31) + this.priceHeaderStyle) * 31;
        String r141 = this.newBonusText;
        if (r141 == null) goto L49;
        int r142 = r141.hashCode();
    L50:
        int r143 = (r140 + r142) * 31;
        Long r144 = this.marketPrice;
        if (r144 == null) goto L53;
        int r145 = r144.hashCode();
    L54:
        int r146 = (r143 + r145) * 31;
        Object r147 = this.epInfo;
        if (r147 == null) goto L57;
        int r148 = r147.hashCode();
    L58:
        int r149 = (r146 + r148) * 31;
        String r150 = this.presellDelayDesc;
        if (r150 == null) goto L61;
        int r151 = r150.hashCode();
    L62:
        int r152 = (r149 + r151) * 31;
        String r153 = this.deliveryDelayDesc;
        if (r153 == null) goto L65;
        int r154 = r153.hashCode();
    L66:
        int r155 = (r152 + r154) * 31;
        String r156 = this.deliveryDelayBackground;
        if (r156 == null) goto L69;
        int r157 = r156.hashCode();
    L70:
        int r158 = (r155 + r157) * 31;
        String r159 = this.delayDescIcon;
        if (r159 == null) goto L73;
        int r160 = r159.hashCode();
    L74:
        int r161 = (r158 + r160) * 31;
        Integer r162 = this.delayDescStyle;
        if (r162 == null) goto L77;
        int r163 = r162.hashCode();
    L78:
        int r164 = (r161 + r163) * 31;
        long r165 = this.campaignStartTime;
        int r166 = (r164 + ((int) (r165 ^ (r165 >>> 32)))) * 31;
        long r167 = this.campaignEndTime;
        int r168 = (r166 + ((int) (r167 ^ (r167 >>> 32)))) * 31;
        ECUrlModel r169 = this.activityIcon;
        if (r169 == null) goto L81;
        int r170 = r169.hashCode();
    L82:
        int r171 = (r168 + r170) * 31;
        String r172 = this.atmosphereHeader;
        if (r172 == null) goto L85;
        int r173 = r172.hashCode();
    L86:
        int r174 = (r171 + r173) * 31;
        Integer r175 = this.campaignSubType;
        if (r175 == null) goto L89;
        int r176 = r175.hashCode();
    L90:
        int r177 = (r174 + r176) * 31;
        long r178 = this.depositPrice;
        int r179 = (r177 + ((int) (r178 ^ (r178 >>> 32)))) * 31;
        String r180 = this.buttonLabel;
        if (r180 == null) goto L93;
        int r181 = r180.hashCode();
    L94:
        int r182 = (r179 + r181) * 31;
        long r183 = this.serverTime;
        int r184 = (r182 + ((int) (r183 ^ (r183 >>> 32)))) * 31;
        List<SkuBottomButtons> r185 = this.buttons;
        if (r185 == null) goto L97;
        int r186 = r185.hashCode();
    L98:
        int r187 = (r184 + r186) * 31;
        boolean r188 = this.isSecKill;
        ?? r189 = 1;
        ?? r190 = r188;
        if (r188 == false) goto L101;
        r190 = 1;
    L101:
        int r191 = (r187 + r190) * 31;
        boolean r192 = this.isDepositPresale;
        if (r192 == true) goto L105;
        r189 = r192;
    L105:
        int r193 = (r191 + r189) * 31;
        CarAdaptComponent r194 = this.carAdaptComponent;
        if (r194 == null) goto L108;
        int r195 = r194.hashCode();
    L109:
        int r196 = (r193 + r195) * 31;
        Long r197 = this.firstPrice;
        if (r197 == null) goto L112;
        int r198 = r197.hashCode();
    L113:
        int r199 = (r196 + r198) * 31;
        String r200 = this.firstPricePrefix;
        if (r200 == null) goto L116;
        int r201 = r200.hashCode();
    L117:
        int r202 = (r199 + r201) * 31;
        String r203 = this.firstPriceSuffix;
        if (r203 == null) goto L120;
        int r204 = r203.hashCode();
    L121:
        int r205 = (r202 + r204) * 31;
        Boolean r206 = this.firstPriceIsUnderline;
        if (r206 == null) goto L124;
        int r207 = r206.hashCode();
    L125:
        int r208 = (r205 + r207) * 31;
        String r209 = this.firstPriceSupplement;
        if (r209 == null) goto L128;
        int r210 = r209.hashCode();
    L129:
        int r211 = (r208 + r210) * 31;
        Long r212 = this.secondPrice;
        if (r212 == null) goto L132;
        int r213 = r212.hashCode();
    L133:
        int r214 = (r211 + r213) * 31;
        String r215 = this.secondPricePrefix;
        if (r215 == null) goto L136;
        int r216 = r215.hashCode();
    L137:
        int r217 = (r214 + r216) * 31;
        String r218 = this.secondPriceSuffix;
        if (r218 == null) goto L140;
        int r219 = r218.hashCode();
    L141:
        int r220 = (r217 + r219) * 31;
        Boolean r221 = this.secondPriceIsUnderline;
        if (r221 == null) goto L144;
        int r222 = r221.hashCode();
    L145:
        int r223 = (r220 + r222) * 31;
        Boolean r224 = this.secondPriceIsReducePrice;
        if (r224 == null) goto L148;
        int r225 = r224.hashCode();
    L149:
        int r226 = (r223 + r225) * 31;
        String r227 = this.secondPriceSupplement;
        if (r227 == null) goto L152;
        int r228 = r227.hashCode();
    L153:
        int r229 = (r226 + r228) * 31;
        Long r230 = this.regularPrice;
        if (r230 == null) goto L156;
        int r231 = r230.hashCode();
    L157:
        int r232 = (r229 + r231) * 31;
        String r233 = this.regularPricePrefix;
        if (r233 == null) goto L160;
        int r234 = r233.hashCode();
    L161:
        int r235 = (r232 + r234) * 31;
        String r236 = this.regularPriceSuffix;
        if (r236 == null) goto L164;
        int r237 = r236.hashCode();
    L165:
        int r238 = (r235 + r237) * 31;
        Boolean r239 = this.regularPriceIsUnderline;
        if (r239 == null) goto L168;
        int r240 = r239.hashCode();
    L169:
        int r241 = (r238 + r240) * 31;
        String r242 = this.regularPriceSupplement;
        if (r242 == null) goto L172;
        int r243 = r242.hashCode();
    L173:
        int r244 = (r241 + r243) * 31;
        Long r245 = this.priceType;
        if (r245 == null) goto L176;
        int r246 = r245.hashCode();
    L177:
        int r247 = (r244 + r246) * 31;
        Long r248 = this.hotMinPrice;
        if (r248 == null) goto L180;
        int r249 = r248.hashCode();
    L181:
        int r250 = (r247 + r249) * 31;
        Long r251 = this.hotMaxPrice;
        if (r251 == null) goto L184;
        int r252 = r251.hashCode();
    L185:
        int r253 = (r250 + r252) * 31;
        Integer r254 = this.atmosphereStyle;
        if (r254 == null) goto L188;
        int r255 = r254.hashCode();
    L189:
        int r256 = (r253 + r255) * 31;
        String r257 = this.stockDesc;
        if (r257 == null) goto L192;
        int r258 = r257.hashCode();
    L193:
        int r259 = (r256 + r258) * 31;
        SkuStatusDetail r260 = this.skuStatusDetail;
        if (r260 == null) goto L196;
        int r261 = r260.hashCode();
    L197:
        int r262 = (r259 + r261) * 31;
        String r263 = this.skuExtra;
        if (r263 == null) goto L200;
        int r264 = r263.hashCode();
    L201:
        int r265 = (r262 + r264) * 31;
        HashMap<String, String> r266 = this.showEventTrack;
        if (r266 == null) goto L204;
        int r267 = r266.hashCode();
    L205:
        int r268 = (r265 + r267) * 31;
        ButtonTipComponent r269 = this.buttonTip;
        if (r269 == null) goto L208;
        int r270 = r269.hashCode();
    L209:
        int r271 = (r268 + r270) * 31;
        Boolean r272 = this.hideTradeIn;
        if (r272 == null) goto L212;
        int r273 = r272.hashCode();
    L213:
        int r274 = (r271 + r273) * 31;
        Boolean r275 = this.canAddCart;
        if (r275 == null) goto L216;
        int r276 = r275.hashCode();
    L217:
        int r277 = (r274 + r276) * 31;
        String r278 = this.promiseType;
        if (r278 == null) goto L221;
        r101 = r278.hashCode();
    L221:
        return r277 + r101;
    L216:
        r276 = 0;
        goto L217
    L212:
        r273 = 0;
        goto L213
    L208:
        r270 = 0;
        goto L209
    L204:
        r267 = 0;
        goto L205
    L200:
        r264 = 0;
        goto L201
    L196:
        r261 = 0;
        goto L197
    L192:
        r258 = 0;
        goto L193
    L188:
        r255 = 0;
        goto L189
    L184:
        r252 = 0;
        goto L185
    L180:
        r249 = 0;
        goto L181
    L176:
        r246 = 0;
        goto L177
    L172:
        r243 = 0;
        goto L173
    L168:
        r240 = 0;
        goto L169
    L164:
        r237 = 0;
        goto L165
    L160:
        r234 = 0;
        goto L161
    L156:
        r231 = 0;
        goto L157
    L152:
        r228 = 0;
        goto L153
    L148:
        r225 = 0;
        goto L149
    L144:
        r222 = 0;
        goto L145
    L140:
        r219 = 0;
        goto L141
    L136:
        r216 = 0;
        goto L137
    L132:
        r213 = 0;
        goto L133
    L128:
        r210 = 0;
        goto L129
    L124:
        r207 = 0;
        goto L125
    L120:
        r204 = 0;
        goto L121
    L116:
        r201 = 0;
        goto L117
    L112:
        r198 = 0;
        goto L113
    L108:
        r195 = 0;
        goto L109
    L97:
        r186 = 0;
        goto L98
    L93:
        r181 = 0;
        goto L94
    L89:
        r176 = 0;
        goto L90
    L85:
        r173 = 0;
        goto L86
    L81:
        r170 = 0;
        goto L82
    L77:
        r163 = 0;
        goto L78
    L73:
        r160 = 0;
        goto L74
    L69:
        r157 = 0;
        goto L70
    L65:
        r154 = 0;
        goto L66
    L61:
        r151 = 0;
        goto L62
    L57:
        r148 = 0;
        goto L58
    L53:
        r145 = 0;
        goto L54
    L49:
        r142 = 0;
        goto L50
    L45:
        r139 = 0;
        goto L46
    L41:
        r136 = 0;
        goto L42
    L37:
        r133 = 0;
        goto L38
    L33:
        r130 = 0;
        goto L34
    L29:
        r127 = 0;
        goto L30
    L25:
        r124 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuItemInfoVO(id=" + this.f43093id + ", stockNum=" + this.stockNum + ", unpayNum=" + this.unpayNum + ", price=" + this.price + ", originPrice=" + this.originPrice + ", discountPrice=" + this.discountPrice + ", discountPriceText=" + this.discountPriceText + ", userLimit=" + this.userLimit + ", lowerLimit=" + this.lowerLimit + ", upperLimitToast=" + this.upperLimitToast + ", lowerLimitToast=" + this.lowerLimitToast + ", limitText=" + this.limitText + ", nowStock=" + this.nowStock + ", skuType=" + this.skuType + ", benefitLabels=" + this.benefitLabels + ", campaignPriceHeader=" + this.campaignPriceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", marketPrice=" + this.marketPrice + ", epInfo=" + this.epInfo + ", presellDelayDesc=" + this.presellDelayDesc + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", deliveryDelayBackground=" + this.deliveryDelayBackground + ", delayDescIcon=" + this.delayDescIcon + ", delayDescStyle=" + this.delayDescStyle + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", activityIcon=" + this.activityIcon + ", atmosphereHeader=" + this.atmosphereHeader + ", campaignSubType=" + this.campaignSubType + ", depositPrice=" + this.depositPrice + ", buttonLabel=" + this.buttonLabel + ", serverTime=" + this.serverTime + ", buttons=" + this.buttons + ", isSecKill=" + this.isSecKill + ", isDepositPresale=" + this.isDepositPresale + ", carAdaptComponent=" + this.carAdaptComponent + ", firstPrice=" + this.firstPrice + ", firstPricePrefix=" + this.firstPricePrefix + ", firstPriceSuffix=" + this.firstPriceSuffix + ", firstPriceIsUnderline=" + this.firstPriceIsUnderline + ", firstPriceSupplement=" + this.firstPriceSupplement + ", secondPrice=" + this.secondPrice + ", secondPricePrefix=" + this.secondPricePrefix + ", secondPriceSuffix=" + this.secondPriceSuffix + ", secondPriceIsUnderline=" + this.secondPriceIsUnderline + ", secondPriceIsReducePrice=" + this.secondPriceIsReducePrice + ", secondPriceSupplement=" + this.secondPriceSupplement + ", regularPrice=" + this.regularPrice + ", regularPricePrefix=" + this.regularPricePrefix + ", regularPriceSuffix=" + this.regularPriceSuffix + ", regularPriceIsUnderline=" + this.regularPriceIsUnderline + ", regularPriceSupplement=" + this.regularPriceSupplement + ", priceType=" + this.priceType + ", hotMinPrice=" + this.hotMinPrice + ", hotMaxPrice=" + this.hotMaxPrice + ", atmosphereStyle=" + this.atmosphereStyle + ", stockDesc=" + this.stockDesc + ", skuStatusDetail=" + this.skuStatusDetail + ", skuExtra=" + this.skuExtra + ", showEventTrack=" + this.showEventTrack + ", buttonTip=" + this.buttonTip + ", hideTradeIn=" + this.hideTradeIn + ", canAddCart=" + this.canAddCart + ", promiseType=" + this.promiseType + ")";
    }

    public final boolean isGroupBuy() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.longValue() != 120) goto L8;
        return true;
    }

    public final boolean isInDepositPresale() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L13:
        return false;
    L6:
        if (r100.longValue() != 10) goto L13;
        long r101 = this.campaignStartTime;
        long r102 = this.campaignEndTime;
        long r103 = SystemClock.elapsedRealtime();
        if (r101 > r103) goto L13;
        if (r102 < r103) goto L13;
        return true;
    }

    public final boolean isInPreSecKill() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.longValue() != 7) goto L10;
        if (SystemClock.elapsedRealtime() >= this.campaignStartTime) goto L10;
        return true;
    }

    public final boolean isInSecKill() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L13:
        return false;
    L6:
        if (r100.longValue() != 7) goto L13;
        long r101 = this.campaignStartTime;
        long r102 = this.campaignEndTime;
        long r103 = SystemClock.elapsedRealtime();
        if (r101 > r103) goto L13;
        if (r102 < r103) goto L13;
        return true;
    }

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final long getActivityStock() {
        return this.activityStock;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final Integer getAtmosphereStyle() {
        return this.atmosphereStyle;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTip() {
        return this.buttonTip;
    }

    public final List<SkuBottomButtons> getButtons() {
        return this.buttons;
    }

    public final long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final String getCampaignPriceHeader() {
        return this.campaignPriceHeader;
    }

    public final long getCampaignStartTime() {
        return this.campaignStartTime;
    }

    public final Integer getCampaignSubType() {
        return this.campaignSubType;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    public final CarAdaptComponent getCarAdaptComponent() {
        return this.carAdaptComponent;
    }

    public final String getDelayDescIcon() {
        return this.delayDescIcon;
    }

    public final Integer getDelayDescStyle() {
        return this.delayDescStyle;
    }

    public final String getDeliveryDelayBackground() {
        return this.deliveryDelayBackground;
    }

    public final String getDeliveryDelayDesc() {
        return this.deliveryDelayDesc;
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getDiscountPriceText() {
        return this.discountPriceText;
    }

    public final Object getEpInfo() {
        return this.epInfo;
    }

    public final Long getFirstPrice() {
        return this.firstPrice;
    }

    public final Boolean getFirstPriceIsUnderline() {
        return this.firstPriceIsUnderline;
    }

    public final String getFirstPricePrefix() {
        return this.firstPricePrefix;
    }

    public final String getFirstPriceSuffix() {
        return this.firstPriceSuffix;
    }

    public final String getFirstPriceSupplement() {
        return this.firstPriceSupplement;
    }

    public final Boolean getHideTradeIn() {
        return this.hideTradeIn;
    }

    public final Long getHotMaxPrice() {
        return this.hotMaxPrice;
    }

    public final Long getHotMinPrice() {
        return this.hotMinPrice;
    }

    public final String getId() {
        return this.f43093id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final long getLowerLimit() {
        return this.lowerLimit;
    }

    public final String getLowerLimitToast() {
        return this.lowerLimitToast;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final String getNewBonusText() {
        return this.newBonusText;
    }

    public final int getNowStock() {
        return this.nowStock;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final long getPrice() {
        return this.price;
    }

    public final int getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final Long getPriceType() {
        return this.priceType;
    }

    public final String getPromiseType() {
        return this.promiseType;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final Boolean getRegularPriceIsUnderline() {
        return this.regularPriceIsUnderline;
    }

    public final String getRegularPricePrefix() {
        return this.regularPricePrefix;
    }

    public final String getRegularPriceSuffix() {
        return this.regularPriceSuffix;
    }

    public final String getRegularPriceSupplement() {
        return this.regularPriceSupplement;
    }

    public final Long getSecondPrice() {
        return this.secondPrice;
    }

    public final Boolean getSecondPriceIsReducePrice() {
        return this.secondPriceIsReducePrice;
    }

    public final Boolean getSecondPriceIsUnderline() {
        return this.secondPriceIsUnderline;
    }

    public final String getSecondPricePrefix() {
        return this.secondPricePrefix;
    }

    public final String getSecondPriceSuffix() {
        return this.secondPriceSuffix;
    }

    public final String getSecondPriceSupplement() {
        return this.secondPriceSupplement;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final HashMap<String, String> getShowEventTrack() {
        return this.showEventTrack;
    }

    public final String getSkuExtra() {
        return this.skuExtra;
    }

    public final SkuStatusDetail getSkuStatusDetail() {
        return this.skuStatusDetail;
    }

    public final Long getSkuType() {
        return this.skuType;
    }

    public final String getStockDesc() {
        return this.stockDesc;
    }

    public final long getStockNum() {
        return this.stockNum;
    }

    public final Long getUnpayNum() {
        return this.unpayNum;
    }

    public final String getUpperLimitToast() {
        return this.upperLimitToast;
    }

    public final Long getUserLimit() {
        return this.userLimit;
    }

    public final boolean isDepositPresale() {
        return this.isDepositPresale;
    }

    public final boolean isSecKill() {
        return this.isSecKill;
    }

    public final void setActivityStock(long r100) {
        this.activityStock = r100;
    }

    public final void setAtmosphereStyle(Integer r100) {
        this.atmosphereStyle = r100;
    }

    public final void setBigImageUrl(String r100) {
        this.bigImageUrl = r100;
    }

    public final void setButtonTip(ButtonTipComponent r100) {
        this.buttonTip = r100;
    }

    public final void setCanSelect(boolean r100) {
        this.canSelect = r100;
    }

    public final void setDiscountPrice(Long r100) {
        this.discountPrice = r100;
    }

    public final void setDiscountPriceText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.discountPriceText = r100;
    }

    public final void setFirstPrice(Long r100) {
        this.firstPrice = r100;
    }

    public final void setFirstPriceIsUnderline(Boolean r100) {
        this.firstPriceIsUnderline = r100;
    }

    public final void setFirstPricePrefix(String r100) {
        this.firstPricePrefix = r100;
    }

    public final void setFirstPriceSuffix(String r100) {
        this.firstPriceSuffix = r100;
    }

    public final void setFirstPriceSupplement(String r100) {
        this.firstPriceSupplement = r100;
    }

    public final void setHotMaxPrice(Long r100) {
        this.hotMaxPrice = r100;
    }

    public final void setHotMinPrice(Long r100) {
        this.hotMinPrice = r100;
    }

    public final void setId(String r100) {
        this.f43093id = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setNowStock(int r100) {
        this.nowStock = r100;
    }

    public final void setOriginPrice(long r100) {
        this.originPrice = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setPriceType(Long r100) {
        this.priceType = r100;
    }

    public final void setPromiseType(String r100) {
        this.promiseType = r100;
    }

    public final void setRegularPrice(Long r100) {
        this.regularPrice = r100;
    }

    public final void setRegularPriceIsUnderline(Boolean r100) {
        this.regularPriceIsUnderline = r100;
    }

    public final void setRegularPricePrefix(String r100) {
        this.regularPricePrefix = r100;
    }

    public final void setRegularPriceSuffix(String r100) {
        this.regularPriceSuffix = r100;
    }

    public final void setRegularPriceSupplement(String r100) {
        this.regularPriceSupplement = r100;
    }

    public final void setSecondPrice(Long r100) {
        this.secondPrice = r100;
    }

    public final void setSecondPriceIsReducePrice(Boolean r100) {
        this.secondPriceIsReducePrice = r100;
    }

    public final void setSecondPriceIsUnderline(Boolean r100) {
        this.secondPriceIsUnderline = r100;
    }

    public final void setSecondPricePrefix(String r100) {
        this.secondPricePrefix = r100;
    }

    public final void setSecondPriceSuffix(String r100) {
        this.secondPriceSuffix = r100;
    }

    public final void setSecondPriceSupplement(String r100) {
        this.secondPriceSupplement = r100;
    }

    public final void setSkuExtra(String r100) {
        this.skuExtra = r100;
    }

    public final void setSkuStatusDetail(SkuStatusDetail r100) {
        this.skuStatusDetail = r100;
    }

    public final void setStockDesc(String r100) {
        this.stockDesc = r100;
    }

    public final void setStockNum(long r100) {
        this.stockNum = r100;
    }

    public SkuItemInfoVO(String r100, long r101, Long r102, long r110, long r111, Long r112, String r113, Long r114, long r115, String r116, String r210, String r211, int r212, Long r213, List<PromotionBenefitLabel> r214, String r215, int r216, String r217, Long r218, Object r219, String r310, String r311, String r312, String r313, Integer r314, long r315, long r316, ECUrlModel r317, String r410, Integer r411, long r412, String r413, long r414, List<SkuBottomButtons> r415, boolean r416, boolean r417, CarAdaptComponent r510, Long r511, String r512, String r513, Boolean r514, String r515, Long r516, String r517, String r518, Boolean r519, Boolean r610, String r611, Long r612, String r613, String r614, Boolean r615, String r616, Long r617, Long r618, Long r619, Integer r710, String r711, SkuStatusDetail r712, String r713, HashMap<String, String> r714, ButtonTipComponent r715, Boolean r716, Boolean r717, String r718) {
        Intrinsics.checkNotNullParameter(r113, "discountPriceText");
        Intrinsics.checkNotNullParameter(r215, "campaignPriceHeader");
        this.f43093id = r100;
        this.stockNum = r101;
        this.unpayNum = r102;
        this.price = r110;
        this.originPrice = r111;
        this.discountPrice = r112;
        this.discountPriceText = r113;
        this.userLimit = r114;
        this.lowerLimit = r115;
        this.upperLimitToast = r116;
        this.lowerLimitToast = r210;
        this.limitText = r211;
        this.nowStock = r212;
        this.skuType = r213;
        this.benefitLabels = r214;
        this.campaignPriceHeader = r215;
        this.priceHeaderStyle = r216;
        this.newBonusText = r217;
        this.marketPrice = r218;
        this.epInfo = r219;
        this.presellDelayDesc = r310;
        this.deliveryDelayDesc = r311;
        this.deliveryDelayBackground = r312;
        this.delayDescIcon = r313;
        this.delayDescStyle = r314;
        this.campaignStartTime = r315;
        this.campaignEndTime = r316;
        this.activityIcon = r317;
        this.atmosphereHeader = r410;
        this.campaignSubType = r411;
        this.depositPrice = r412;
        this.buttonLabel = r413;
        this.serverTime = r414;
        this.buttons = r415;
        this.isSecKill = r416;
        this.isDepositPresale = r417;
        this.carAdaptComponent = r510;
        this.firstPrice = r511;
        this.firstPricePrefix = r512;
        this.firstPriceSuffix = r513;
        this.firstPriceIsUnderline = r514;
        this.firstPriceSupplement = r515;
        this.secondPrice = r516;
        this.secondPricePrefix = r517;
        this.secondPriceSuffix = r518;
        this.secondPriceIsUnderline = r519;
        this.secondPriceIsReducePrice = r610;
        this.secondPriceSupplement = r611;
        this.regularPrice = r612;
        this.regularPricePrefix = r613;
        this.regularPriceSuffix = r614;
        this.regularPriceIsUnderline = r615;
        this.regularPriceSupplement = r616;
        this.priceType = r617;
        this.hotMinPrice = r618;
        this.hotMaxPrice = r619;
        this.atmosphereStyle = r710;
        this.stockDesc = r711;
        this.skuStatusDetail = r712;
        this.skuExtra = r713;
        this.showEventTrack = r714;
        this.buttonTip = r715;
        this.hideTradeIn = r716;
        this.canAddCart = r717;
        this.promiseType = r718;
        this.canSelect = true;
    }

    public /* synthetic */ SkuItemInfoVO(String r710, long r810, Long r811, long r812, long r813, Long r814, String r815, Long r816, long r910, String r911, String r912, String r913, int r914, Long r915, List r916, String r917, int r918, String r100, Long r101, Object r102, String r103, String r104, String r105, String r106, Integer r107, long r108, long r110, ECUrlModel r112, String r113, Integer r114, long r115, String r117, long r118, List r120, boolean r121, boolean r122, CarAdaptComponent r123, Long r124, String r125, String r126, Boolean r127, String r128, Long r129, String r130, String r131, Boolean r132, Boolean r133, String r134, Long r135, String r136, String r137, Boolean r138, String r139, Long r140, Long r141, Long r142, Integer r143, String r144, SkuStatusDetail r145, String r146, HashMap r147, ButtonTipComponent r148, Boolean r149, Boolean r150, String r151, int r152, int r153, int r154, DefaultConstructorMarker r155) {
        if ((r152 & 4) == 0) goto L5;
        Long r109 = null;
    L7:
        if ((r152 & 32) == 0) goto L9;
        Long r111 = null;
    L11:
        if ((r152 & 64) == 0) goto L13;
        String r116 = "";
    L15:
        if ((r152 & 128) == 0) goto L17;
        Long r119 = null;
    L19:
        if ((r152 & 256) == 0) goto L21;
        long r156 = 1;
    L23:
        if ((r152 & 512) == 0) goto L25;
        String r157 = null;
    L27:
        if ((r152 & 1024) == 0) goto L29;
        String r158 = null;
    L31:
        if ((r152 & 2048) == 0) goto L33;
        String r210 = null;
    L35:
        if ((r152 & 4096) == 0) goto L37;
        int r211 = -1;
    L39:
        if ((r152 & 8192) == 0) goto L41;
        Long r212 = null;
    L43:
        if ((r152 & 16384) == 0) goto L45;
        List r213 = null;
    L47:
        if ((r152 & 32768) == 0) goto L49;
        String r214 = "";
    L51:
        if ((r152 & 65536) == 0) goto L53;
        int r215 = -1;
    L55:
        if ((r152 & 131072) == 0) goto L57;
        String r216 = null;
    L59:
        if ((r152 & 262144) == 0) goto L61;
        Long r217 = null;
    L63:
        if ((r152 & 524288) == 0) goto L65;
        Object r218 = null;
    L67:
        if ((r152 & 1048576) == 0) goto L69;
        String r219 = null;
    L71:
        if ((r152 & 2097152) == 0) goto L73;
        String r310 = null;
    L75:
        if ((4194304 & r152) == 0) goto L77;
        String r311 = null;
    L79:
        if ((8388608 & r152) == 0) goto L81;
        String r312 = null;
    L83:
        if ((16777216 & r152) == 0) goto L85;
        Integer r313 = null;
    L87:
        if ((33554432 & r152) == 0) goto L89;
        long r314 = 0;
    L91:
        if ((67108864 & r152) == 0) goto L93;
        long r315 = 0;
    L95:
        if ((134217728 & r152) == 0) goto L97;
        ECUrlModel r410 = null;
    L99:
        if ((268435456 & r152) == 0) goto L101;
        String r411 = null;
    L103:
        if ((536870912 & r152) == 0) goto L105;
        Integer r412 = null;
    L107:
        if ((1073741824 & r152) == 0) goto L109;
        long r413 = 0;
    L111:
        if ((r152 & Integer.MIN_VALUE) == 0) goto L113;
        String r159 = null;
    L115:
        if ((r153 & 1) == 0) goto L117;
        long r414 = 0;
    L119:
        if ((r153 & 2) == 0) goto L121;
        List r415 = null;
    L123:
        if ((r153 & 4) == 0) goto L125;
        boolean r416 = false;
    L127:
        if ((r153 & 8) == 0) goto L129;
        boolean r417 = false;
    L131:
        if ((r153 & 16) == 0) goto L133;
        CarAdaptComponent r510 = null;
    L135:
        if ((r153 & 32) == 0) goto L137;
        Long r511 = null;
    L139:
        if ((r153 & 64) == 0) goto L141;
        String r512 = null;
    L143:
        if ((r153 & 128) == 0) goto L145;
        String r513 = null;
    L147:
        if ((r153 & 256) == 0) goto L149;
        Boolean r514 = null;
    L151:
        if ((r153 & 512) == 0) goto L153;
        String r515 = null;
    L155:
        if ((r153 & 1024) == 0) goto L157;
        Long r516 = null;
    L159:
        if ((r153 & 2048) == 0) goto L161;
        String r517 = null;
    L163:
        if ((r153 & 4096) == 0) goto L165;
        String r518 = null;
    L167:
        if ((r153 & 8192) == 0) goto L169;
        Boolean r519 = null;
    L171:
        if ((r153 & 16384) == 0) goto L173;
        Boolean r610 = null;
    L175:
        if ((32768 & r153) == 0) goto L177;
        String r160 = null;
    L179:
        if ((65536 & r153) == 0) goto L181;
        Long r611 = null;
    L183:
        if ((r153 & 131072) == 0) goto L185;
        String r612 = null;
    L187:
        if ((r153 & 262144) == 0) goto L189;
        String r613 = null;
    L191:
        if ((r153 & 524288) == 0) goto L193;
        Boolean r614 = null;
    L195:
        if ((r153 & 1048576) == 0) goto L197;
        String r615 = null;
    L199:
        if ((r153 & 2097152) == 0) goto L201;
        Long r616 = null;
    L203:
        if ((4194304 & r153) == 0) goto L205;
        Long r617 = null;
    L207:
        if ((8388608 & r153) == 0) goto L209;
        Long r618 = null;
    L211:
        if ((16777216 & r153) == 0) goto L213;
        Integer r619 = null;
    L215:
        if ((33554432 & r153) == 0) goto L217;
        String r711 = null;
    L219:
        if ((67108864 & r153) == 0) goto L221;
        SkuStatusDetail r712 = null;
    L223:
        if ((134217728 & r153) == 0) goto L225;
        String r713 = null;
    L227:
        if ((268435456 & r153) == 0) goto L229;
        HashMap r714 = null;
    L231:
        if ((536870912 & r153) == 0) goto L233;
        ButtonTipComponent r715 = null;
    L235:
        if ((1073741824 & r153) == 0) goto L237;
        Boolean r716 = Boolean.FALSE;
    L239:
        if ((r153 & Integer.MIN_VALUE) == 0) goto L241;
        Boolean r717 = Boolean.FALSE;
    L243:
        if ((r154 & 1) == 0) goto L245;
        String r718 = null;
    L246:
        this(r710, r810, r109, r812, r813, r111, r116, r119, r156, r157, r158, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r410, r411, r412, r413, r159, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r160, r611, r612, r613, r614, r615, r616, r617, r618, r619, r711, r712, r713, r714, r715, r716, r717, r718);
        return;
    L245:
        r718 = r151;
        goto L246
    L241:
        r717 = r150;
        goto L243
    L237:
        r716 = r149;
        goto L239
    L233:
        r715 = r148;
        goto L235
    L229:
        r714 = r147;
        goto L231
    L225:
        r713 = r146;
        goto L227
    L221:
        r712 = r145;
        goto L223
    L217:
        r711 = r144;
        goto L219
    L213:
        r619 = r143;
        goto L215
    L209:
        r618 = r142;
        goto L211
    L205:
        r617 = r141;
        goto L207
    L201:
        r616 = r140;
        goto L203
    L197:
        r615 = r139;
        goto L199
    L193:
        r614 = r138;
        goto L195
    L189:
        r613 = r137;
        goto L191
    L185:
        r612 = r136;
        goto L187
    L181:
        r611 = r135;
        goto L183
    L177:
        r160 = r134;
        goto L179
    L173:
        r610 = r133;
        goto L175
    L169:
        r519 = r132;
        goto L171
    L165:
        r518 = r131;
        goto L167
    L161:
        r517 = r130;
        goto L163
    L157:
        r516 = r129;
        goto L159
    L153:
        r515 = r128;
        goto L155
    L149:
        r514 = r127;
        goto L151
    L145:
        r513 = r126;
        goto L147
    L141:
        r512 = r125;
        goto L143
    L137:
        r511 = r124;
        goto L139
    L133:
        r510 = r123;
        goto L135
    L129:
        r417 = r122;
        goto L131
    L125:
        r416 = r121;
        goto L127
    L121:
        r415 = r120;
        goto L123
    L117:
        r414 = r118;
        goto L119
    L113:
        r159 = r117;
        goto L115
    L109:
        r413 = r115;
        goto L111
    L105:
        r412 = r114;
        goto L107
    L101:
        r411 = r113;
        goto L103
    L97:
        r410 = r112;
        goto L99
    L93:
        r315 = r110;
        goto L95
    L89:
        r314 = r108;
        goto L91
    L85:
        r313 = r107;
        goto L87
    L81:
        r312 = r106;
        goto L83
    L77:
        r311 = r105;
        goto L79
    L73:
        r310 = r104;
        goto L75
    L69:
        r219 = r103;
        goto L71
    L65:
        r218 = r102;
        goto L67
    L61:
        r217 = r101;
        goto L63
    L57:
        r216 = r100;
        goto L59
    L53:
        r215 = r918;
        goto L55
    L49:
        r214 = r917;
        goto L51
    L45:
        r213 = r916;
        goto L47
    L41:
        r212 = r915;
        goto L43
    L37:
        r211 = r914;
        goto L39
    L33:
        r210 = r913;
        goto L35
    L29:
        r158 = r912;
        goto L31
    L25:
        r157 = r911;
        goto L27
    L21:
        r156 = r910;
        goto L23
    L17:
        r119 = r816;
        goto L19
    L13:
        r116 = r815;
        goto L15
    L9:
        r111 = r814;
        goto L11
    L5:
        r109 = r811;
        goto L7
    }
}
