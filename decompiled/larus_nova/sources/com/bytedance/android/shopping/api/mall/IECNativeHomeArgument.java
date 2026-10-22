package com.bytedance.android.shopping.api.mall;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010$\n\u0002\by\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u00105J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\t\u0010t\u001a\u00020\u0007HÆ\u0003J\t\u0010u\u001a\u00020\u0007HÆ\u0003J\t\u0010v\u001a\u00020\u0007HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\fHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010|\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u0087\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\n\u0010\u008a\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0007HÆ\u0003J\u0018\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0007HÆ\u0003J\u0018\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)HÆ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u009a\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010PJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010<J\n\u0010\u009d\u0001\u001a\u00020\u0007HÆ\u0003J\u009e\u0004\u0010\u009e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00072\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010\u009f\u0001J\n\u0010 \u0001\u001a\u00020\u0005HÖ\u0001J\u0016\u0010¡\u0001\u001a\u00020\u00072\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001HÖ\u0003J\n\u0010¤\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010¥\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010¦\u0001\u001a\u00030§\u00012\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010ª\u0001\u001a\u00020\u0005HÖ\u0001R\u0015\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u00100\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u0010@R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0011\u00102\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010@R\u0011\u0010'\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0011\u0010/\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010@R\u0011\u0010,\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010@R\u0013\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bJ\u0010<R\u001f\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010@R\u001f\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bM\u0010LR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bN\u00107R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010PR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bR\u0010<R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bS\u00107R\u0011\u0010&\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bT\u0010@R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010VR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bX\u0010@R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010VR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bZ\u0010PR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b[\u0010<R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010@R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\b]\u0010<R\u0013\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010:R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010VR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010:R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010VR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010:\"\u0004\be\u0010fR\u0015\u00104\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bg\u0010PR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bh\u0010<R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010VR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\bj\u00107R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010:R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bl\u0010@R\u0011\u00101\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bm\u0010@R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bn\u0010VR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010=\u001a\u0004\bo\u0010<¨\u0006«\u0001"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECNativeHomeArgument;", "Landroid/os/Parcelable;", "bundleConfigUrl", "", "loadMoreRangeSize", "", "videoSmoothEnter", "", "liveSmoothEnter", "bundlePreloaded", "disableBuiltin", "naOfflineVersion", "", "geckoExist", "isTopTabPage", "panelTopOffset", "topBarPreloadStrategy", "refreshEnable", "shouldCheckECPlugin", "enableFirstScreenStraightOut", "enableCorrectShowReport", "dataEngineTag", "pageCardDynamicParamTimeout", "pageCardSchema", "preloadTemplateConfig", "reportSlardar", "renderThreadStrategy", "enableEngineParentControl", "needLeaveRefresh", "leaveTimeout", "needReportLastAction", "lastActionLen", "sceneID", "needRefreshPage", "mallScrollTimeInterval", "mallStraightOutSync", "mallUpdateSuggestWorldByLynxCard", "bottomTabHeight", "mallFPSMonitorAfterFirstScreen", "enableMallFpsOpt", "grassParams", "", "pageCardDelayInit", "naMallPreloadStrategy", "exposureEventAsyncReport", "landingInfo", "geckoChannel", "enableTopBar", "enableBackground", "showHalfMallBar", "enableLoadGeckoInThread", "optForRebuildId", "rebuildTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Long;Ljava/lang/Boolean;ZIILjava/lang/Boolean;ZZZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;ZIIZLjava/lang/Integer;ZZLjava/util/Map;IIZLjava/util/Map;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Long;)V", "getBottomTabHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBundleConfigUrl", "()Ljava/lang/String;", "getBundlePreloaded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDataEngineTag", "getDisableBuiltin", "()Z", "getEnableBackground", "getEnableCorrectShowReport", "getEnableEngineParentControl", "getEnableFirstScreenStraightOut", "getEnableLoadGeckoInThread", "getEnableMallFpsOpt", "getEnableTopBar", "getExposureEventAsyncReport", "getGeckoChannel", "getGeckoExist", "getGrassParams", "()Ljava/util/Map;", "getLandingInfo", "getLastActionLen", "getLeaveTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLiveSmoothEnter", "getLoadMoreRangeSize", "getMallFPSMonitorAfterFirstScreen", "getMallScrollTimeInterval", "()I", "getMallStraightOutSync", "getMallUpdateSuggestWorldByLynxCard", "getNaMallPreloadStrategy", "getNaOfflineVersion", "getNeedLeaveRefresh", "getNeedRefreshPage", "getNeedReportLastAction", "getOptForRebuildId", "getPageCardDelayInit", "getPageCardDynamicParamTimeout", "()J", "getPageCardSchema", "getPanelTopOffset", "getPreloadTemplateConfig", "setPreloadTemplateConfig", "(Ljava/lang/String;)V", "getRebuildTime", "getRefreshEnable", "getRenderThreadStrategy", "getReportSlardar", "getSceneID", "getShouldCheckECPlugin", "getShowHalfMallBar", "getTopBarPreloadStrategy", "getVideoSmoothEnter", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Long;Ljava/lang/Boolean;ZIILjava/lang/Boolean;ZZZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;ZIIZLjava/lang/Integer;ZZLjava/util/Map;IIZLjava/util/Map;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/IECNativeHomeArgument;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IECNativeHomeArgument implements Parcelable {
    public static final Parcelable.Creator<IECNativeHomeArgument> CREATOR = null;
    private final Integer bottomTabHeight;
    private final String bundleConfigUrl;
    private final Boolean bundlePreloaded;
    private final String dataEngineTag;
    private final boolean disableBuiltin;
    private final boolean enableBackground;
    private final boolean enableCorrectShowReport;
    private final boolean enableEngineParentControl;
    private final boolean enableFirstScreenStraightOut;
    private final boolean enableLoadGeckoInThread;
    private final boolean enableMallFpsOpt;
    private final boolean enableTopBar;
    private final boolean exposureEventAsyncReport;
    private final String geckoChannel;
    private final Boolean geckoExist;
    private final Map<String, String> grassParams;
    private final boolean isTopTabPage;
    private final Map<String, String> landingInfo;
    private final Integer lastActionLen;
    private final Long leaveTimeout;
    private final Boolean liveSmoothEnter;
    private final Integer loadMoreRangeSize;
    private final boolean mallFPSMonitorAfterFirstScreen;
    private final int mallScrollTimeInterval;
    private final int mallStraightOutSync;
    private final boolean mallUpdateSuggestWorldByLynxCard;
    private final int naMallPreloadStrategy;
    private final Long naOfflineVersion;
    private final Boolean needLeaveRefresh;
    private final boolean needRefreshPage;
    private final Boolean needReportLastAction;
    private final String optForRebuildId;
    private final int pageCardDelayInit;
    private final long pageCardDynamicParamTimeout;
    private final String pageCardSchema;
    private final int panelTopOffset;
    private String preloadTemplateConfig;
    private final Long rebuildTime;
    private final Boolean refreshEnable;
    private final int renderThreadStrategy;
    private final Integer reportSlardar;
    private final String sceneID;
    private final boolean shouldCheckECPlugin;
    private final boolean showHalfMallBar;
    private final int topBarPreloadStrategy;
    private final Boolean videoSmoothEnter;

    public static class a implements Parcelable.Creator<IECNativeHomeArgument> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IECNativeHomeArgument createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "in");
            String r100 = r510.readString();
            if (r510.readInt() == 0) goto L5;
            Integer r101 = Integer.valueOf(r510.readInt());
        L7:
            if (r510.readInt() != 0) goto L9;
            Boolean r102 = null;
        L15:
            if (r510.readInt() != 0) goto L17;
            Boolean r103 = null;
        L23:
            if (r510.readInt() != 0) goto L25;
            Boolean r104 = null;
        L31:
            if (r510.readInt() == 0) goto L33;
            boolean r110 = true;
        L35:
            if (r510.readInt() == 0) goto L37;
            Long r111 = Long.valueOf(r510.readLong());
        L39:
            if (r510.readInt() != 0) goto L41;
            Boolean r112 = null;
        L47:
            if (r510.readInt() == 0) goto L49;
            boolean r113 = true;
        L50:
            int r114 = r510.readInt();
            int r115 = r510.readInt();
            if (r510.readInt() != 0) goto L53;
            Boolean r116 = null;
        L59:
            if (r510.readInt() == 0) goto L61;
            boolean r117 = true;
        L63:
            if (r510.readInt() == 0) goto L65;
            boolean r118 = true;
        L67:
            if (r510.readInt() == 0) goto L69;
            boolean r119 = true;
        L70:
            String r210 = r510.readString();
            long r211 = r510.readLong();
            String r212 = r510.readString();
            String r213 = r510.readString();
            if (r510.readInt() == 0) goto L73;
            Integer r214 = Integer.valueOf(r510.readInt());
        L74:
            int r215 = r510.readInt();
            if (r510.readInt() == 0) goto L77;
            boolean r216 = true;
        L79:
            if (r510.readInt() != 0) goto L81;
            Boolean r217 = null;
        L87:
            if (r510.readInt() == 0) goto L89;
            Long r218 = Long.valueOf(r510.readLong());
        L91:
            if (r510.readInt() != 0) goto L93;
            Boolean r310 = null;
        L99:
            if (r510.readInt() == 0) goto L101;
            Integer r311 = Integer.valueOf(r510.readInt());
        L102:
            String r312 = r510.readString();
            if (r510.readInt() == 0) goto L105;
            boolean r313 = true;
        L106:
            int r314 = r510.readInt();
            int r315 = r510.readInt();
            if (r510.readInt() == 0) goto L109;
            boolean r316 = true;
        L111:
            if (r510.readInt() == 0) goto L113;
            Integer r317 = Integer.valueOf(r510.readInt());
        L115:
            if (r510.readInt() == 0) goto L117;
            boolean r318 = true;
        L119:
            if (r510.readInt() == 0) goto L121;
            boolean r319 = true;
        L123:
            if (r510.readInt() == 0) goto L128;
            int r105 = r510.readInt();
            LinkedHashMap r106 = new LinkedHashMap(r105);
        L125:
            if (r105 == 0) goto L127;
            r106.put(r510.readString(), r510.readString());
            r105 = r105 - 1;
            goto L125
        L127:
            LinkedHashMap r410 = r106;
        L129:
            int r411 = r510.readInt();
            int r412 = r510.readInt();
            if (r510.readInt() == 0) goto L132;
            boolean r413 = true;
        L134:
            if (r510.readInt() == 0) goto L139;
            int r107 = r510.readInt();
            LinkedHashMap r108 = new LinkedHashMap(r107);
        L136:
            if (r107 == 0) goto L138;
            r108.put(r510.readString(), r510.readString());
            r107 = r107 - 1;
            goto L136
        L138:
            LinkedHashMap r414 = r108;
        L140:
            String r415 = r510.readString();
            if (r510.readInt() == 0) goto L143;
            boolean r416 = true;
        L145:
            if (r510.readInt() == 0) goto L147;
            boolean r511 = true;
        L149:
            if (r510.readInt() == 0) goto L151;
            boolean r512 = true;
        L153:
            if (r510.readInt() == 0) goto L155;
            boolean r513 = true;
        L156:
            String r514 = r510.readString();
            if (r510.readInt() == 0) goto L159;
            Long r515 = Long.valueOf(r510.readLong());
        L161:
            return new IECNativeHomeArgument(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r511, r512, r513, r514, r515);
        L159:
            r515 = null;
            goto L161
        L155:
            r513 = false;
            goto L156
        L151:
            r512 = false;
            goto L153
        L147:
            r511 = false;
            goto L149
        L143:
            r416 = false;
            goto L145
        L139:
            r414 = null;
            goto L140
        L132:
            r413 = false;
            goto L134
        L128:
            r410 = null;
            goto L129
        L121:
            r319 = false;
            goto L123
        L117:
            r318 = false;
            goto L119
        L113:
            r317 = null;
            goto L115
        L109:
            r316 = false;
            goto L111
        L105:
            r313 = false;
            goto L106
        L101:
            r311 = null;
            goto L102
        L93:
            if (r510.readInt() == 0) goto L95;
            boolean r320 = true;
        L96:
            r310 = Boolean.valueOf(r320);
            goto L99
        L95:
            r320 = false;
            goto L96
        L89:
            r218 = null;
            goto L91
        L81:
            if (r510.readInt() == 0) goto L83;
            boolean r219 = true;
        L84:
            r217 = Boolean.valueOf(r219);
            goto L87
        L83:
            r219 = false;
            goto L84
        L77:
            r216 = false;
            goto L79
        L73:
            r214 = null;
            goto L74
        L69:
            r119 = false;
            goto L70
        L65:
            r118 = false;
            goto L67
        L61:
            r117 = false;
            goto L63
        L53:
            if (r510.readInt() == 0) goto L55;
            boolean r120 = true;
        L56:
            r116 = Boolean.valueOf(r120);
            goto L59
        L55:
            r120 = false;
            goto L56
        L49:
            r113 = false;
            goto L50
        L41:
            if (r510.readInt() == 0) goto L43;
            boolean r121 = true;
        L44:
            r112 = Boolean.valueOf(r121);
            goto L47
        L43:
            r121 = false;
            goto L44
        L37:
            r111 = null;
            goto L39
        L33:
            r110 = false;
            goto L35
        L25:
            if (r510.readInt() == 0) goto L27;
            boolean r109 = true;
        L28:
            r104 = Boolean.valueOf(r109);
            goto L31
        L27:
            r109 = false;
            goto L28
        L17:
            if (r510.readInt() == 0) goto L19;
            boolean r122 = true;
        L20:
            r103 = Boolean.valueOf(r122);
            goto L23
        L19:
            r122 = false;
            goto L20
        L9:
            if (r510.readInt() == 0) goto L11;
            boolean r123 = true;
        L12:
            r102 = Boolean.valueOf(r123);
            goto L15
        L11:
            r123 = false;
            goto L12
        L5:
            r101 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IECNativeHomeArgument[] newArray(int r100) {
            return new IECNativeHomeArgument[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IECNativeHomeArgument copy$default(IECNativeHomeArgument r110, String r111, Integer r112, Boolean r210, Boolean r211, Boolean r212, boolean r213, Long r214, Boolean r215, boolean r216, int r217, int r218, Boolean r219, boolean r310, boolean r311, boolean r312, String r313, long r314, String r315, String r316, Integer r317, int r318, boolean r410, Boolean r411, Long r412, Boolean r413, Integer r414, String r415, boolean r416, int r417, int r418, boolean r419, Integer r510, boolean r511, boolean r512, Map r513, int r514, int r515, boolean r516, Map r517, String r518, boolean r519, boolean r610, boolean r611, boolean r612, String r613, Long r614, int r615, int r616, Object r617) {
        if ((r615 & 1) == 0) goto L5;
        String r100 = r110.bundleConfigUrl;
    L7:
        if ((r615 & 2) == 0) goto L9;
        Integer r101 = r110.loadMoreRangeSize;
    L11:
        if ((r615 & 4) == 0) goto L13;
        Boolean r102 = r110.videoSmoothEnter;
    L15:
        if ((r615 & 8) == 0) goto L17;
        Boolean r103 = r110.liveSmoothEnter;
    L19:
        if ((r615 & 16) == 0) goto L21;
        Boolean r104 = r110.bundlePreloaded;
    L23:
        if ((r615 & 32) == 0) goto L25;
        boolean r105 = r110.disableBuiltin;
    L27:
        if ((r615 & 64) == 0) goto L29;
        Long r106 = r110.naOfflineVersion;
    L31:
        if ((r615 & 128) == 0) goto L33;
        Boolean r113 = r110.geckoExist;
    L35:
        if ((r615 & 256) == 0) goto L37;
        boolean r114 = r110.isTopTabPage;
    L39:
        if ((r615 & 512) == 0) goto L41;
        int r115 = r110.panelTopOffset;
    L43:
        if ((r615 & 1024) == 0) goto L45;
        int r116 = r110.topBarPreloadStrategy;
    L47:
        if ((r615 & 2048) == 0) goto L49;
        Boolean r117 = r110.refreshEnable;
    L51:
        if ((r615 & 4096) == 0) goto L53;
        boolean r118 = r110.shouldCheckECPlugin;
    L54:
        boolean r319 = r118;
        if ((r615 & 8192) == 0) goto L57;
        boolean r119 = r110.enableFirstScreenStraightOut;
    L58:
        boolean r320 = r119;
        if ((r615 & 16384) == 0) goto L61;
        boolean r120 = r110.enableCorrectShowReport;
    L62:
        boolean r321 = r120;
        if ((r615 & 32768) == 0) goto L65;
        String r121 = r110.dataEngineTag;
    L66:
        Boolean r220 = r117;
        String r322 = r121;
        if ((r615 & 65536) == 0) goto L69;
        long r122 = r110.pageCardDynamicParamTimeout;
    L70:
        long r323 = r122;
        if ((r615 & 131072) == 0) goto L73;
        String r123 = r110.pageCardSchema;
    L75:
        if ((262144 & r615) == 0) goto L77;
        String r124 = r110.preloadTemplateConfig;
    L78:
        String r324 = r124;
        if ((r615 & 524288) == 0) goto L81;
        Integer r125 = r110.reportSlardar;
    L82:
        Integer r325 = r125;
        if ((r615 & 1048576) == 0) goto L85;
        int r126 = r110.renderThreadStrategy;
    L86:
        int r326 = r126;
        if ((r615 & 2097152) == 0) goto L89;
        boolean r127 = r110.enableEngineParentControl;
    L90:
        boolean r420 = r127;
        if ((r615 & 4194304) == 0) goto L93;
        Boolean r128 = r110.needLeaveRefresh;
    L94:
        Boolean r421 = r128;
        if ((r615 & 8388608) == 0) goto L97;
        Long r129 = r110.leaveTimeout;
    L98:
        Long r422 = r129;
        if ((r615 & 16777216) == 0) goto L101;
        Boolean r130 = r110.needReportLastAction;
    L102:
        Boolean r423 = r130;
        if ((r615 & 33554432) == 0) goto L105;
        Integer r131 = r110.lastActionLen;
    L106:
        Integer r424 = r131;
        if ((r615 & 67108864) == 0) goto L109;
        String r132 = r110.sceneID;
    L110:
        String r425 = r132;
        if ((r615 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        boolean r133 = r110.needRefreshPage;
    L114:
        boolean r426 = r133;
        if ((r615 & 268435456) == 0) goto L117;
        int r134 = r110.mallScrollTimeInterval;
    L118:
        int r427 = r134;
        if ((r615 & 536870912) == 0) goto L121;
        int r135 = r110.mallStraightOutSync;
    L122:
        int r428 = r135;
        if ((r615 & 1073741824) == 0) goto L125;
        boolean r136 = r110.mallUpdateSuggestWorldByLynxCard;
    L127:
        if ((r615 & Integer.MIN_VALUE) == 0) goto L129;
        Integer r107 = r110.bottomTabHeight;
    L130:
        Integer r520 = r107;
        if ((r616 & 1) == 0) goto L133;
        boolean r108 = r110.mallFPSMonitorAfterFirstScreen;
    L134:
        boolean r521 = r108;
        if ((r616 & 2) == 0) goto L137;
        boolean r109 = r110.enableMallFpsOpt;
    L138:
        boolean r522 = r109;
        if ((r616 & 4) == 0) goto L141;
        Map r137 = r110.grassParams;
    L142:
        Map r523 = r137;
        if ((r616 & 8) == 0) goto L145;
        int r138 = r110.pageCardDelayInit;
    L146:
        int r524 = r138;
        if ((r616 & 16) == 0) goto L149;
        int r139 = r110.naMallPreloadStrategy;
    L150:
        int r525 = r139;
        if ((r616 & 32) == 0) goto L153;
        boolean r140 = r110.exposureEventAsyncReport;
    L154:
        boolean r526 = r140;
        if ((r616 & 64) == 0) goto L157;
        Map r141 = r110.landingInfo;
    L158:
        Map r527 = r141;
        if ((r616 & 128) == 0) goto L161;
        String r142 = r110.geckoChannel;
    L162:
        String r528 = r142;
        if ((r616 & 256) == 0) goto L165;
        boolean r143 = r110.enableTopBar;
    L166:
        boolean r529 = r143;
        if ((r616 & 512) == 0) goto L169;
        boolean r144 = r110.enableBackground;
    L170:
        boolean r618 = r144;
        if ((r616 & 1024) == 0) goto L173;
        boolean r145 = r110.showHalfMallBar;
    L174:
        boolean r619 = r145;
        if ((r616 & 2048) == 0) goto L177;
        boolean r146 = r110.enableLoadGeckoInThread;
    L178:
        boolean r620 = r146;
        if ((r616 & 4096) == 0) goto L181;
        String r147 = r110.optForRebuildId;
    L183:
        if ((r616 & 8192) == 0) goto L185;
        Long r148 = r110.rebuildTime;
    L187:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r220, r319, r320, r321, r322, r323, r123, r324, r325, r326, r420, r421, r422, r423, r424, r425, r426, r427, r428, r136, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r618, r619, r620, r147, r148);
    L185:
        r148 = r614;
        goto L187
    L181:
        r147 = r613;
        goto L183
    L177:
        r146 = r612;
        goto L178
    L173:
        r145 = r611;
        goto L174
    L169:
        r144 = r610;
        goto L170
    L165:
        r143 = r519;
        goto L166
    L161:
        r142 = r518;
        goto L162
    L157:
        r141 = r517;
        goto L158
    L153:
        r140 = r516;
        goto L154
    L149:
        r139 = r515;
        goto L150
    L145:
        r138 = r514;
        goto L146
    L141:
        r137 = r513;
        goto L142
    L137:
        r109 = r512;
        goto L138
    L133:
        r108 = r511;
        goto L134
    L129:
        r107 = r510;
        goto L130
    L125:
        r136 = r419;
        goto L127
    L121:
        r135 = r418;
        goto L122
    L117:
        r134 = r417;
        goto L118
    L113:
        r133 = r416;
        goto L114
    L109:
        r132 = r415;
        goto L110
    L105:
        r131 = r414;
        goto L106
    L101:
        r130 = r413;
        goto L102
    L97:
        r129 = r412;
        goto L98
    L93:
        r128 = r411;
        goto L94
    L89:
        r127 = r410;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L75
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.bundleConfigUrl;
    }

    public final int component10() {
        return this.panelTopOffset;
    }

    public final int component11() {
        return this.topBarPreloadStrategy;
    }

    public final Boolean component12() {
        return this.refreshEnable;
    }

    public final boolean component13() {
        return this.shouldCheckECPlugin;
    }

    public final boolean component14() {
        return this.enableFirstScreenStraightOut;
    }

    public final boolean component15() {
        return this.enableCorrectShowReport;
    }

    public final String component16() {
        return this.dataEngineTag;
    }

    public final long component17() {
        return this.pageCardDynamicParamTimeout;
    }

    public final String component18() {
        return this.pageCardSchema;
    }

    public final String component19() {
        return this.preloadTemplateConfig;
    }

    public final Integer component2() {
        return this.loadMoreRangeSize;
    }

    public final Integer component20() {
        return this.reportSlardar;
    }

    public final int component21() {
        return this.renderThreadStrategy;
    }

    public final boolean component22() {
        return this.enableEngineParentControl;
    }

    public final Boolean component23() {
        return this.needLeaveRefresh;
    }

    public final Long component24() {
        return this.leaveTimeout;
    }

    public final Boolean component25() {
        return this.needReportLastAction;
    }

    public final Integer component26() {
        return this.lastActionLen;
    }

    public final String component27() {
        return this.sceneID;
    }

    public final boolean component28() {
        return this.needRefreshPage;
    }

    public final int component29() {
        return this.mallScrollTimeInterval;
    }

    public final Boolean component3() {
        return this.videoSmoothEnter;
    }

    public final int component30() {
        return this.mallStraightOutSync;
    }

    public final boolean component31() {
        return this.mallUpdateSuggestWorldByLynxCard;
    }

    public final Integer component32() {
        return this.bottomTabHeight;
    }

    public final boolean component33() {
        return this.mallFPSMonitorAfterFirstScreen;
    }

    public final boolean component34() {
        return this.enableMallFpsOpt;
    }

    public final Map<String, String> component35() {
        return this.grassParams;
    }

    public final int component36() {
        return this.pageCardDelayInit;
    }

    public final int component37() {
        return this.naMallPreloadStrategy;
    }

    public final boolean component38() {
        return this.exposureEventAsyncReport;
    }

    public final Map<String, String> component39() {
        return this.landingInfo;
    }

    public final Boolean component4() {
        return this.liveSmoothEnter;
    }

    public final String component40() {
        return this.geckoChannel;
    }

    public final boolean component41() {
        return this.enableTopBar;
    }

    public final boolean component42() {
        return this.enableBackground;
    }

    public final boolean component43() {
        return this.showHalfMallBar;
    }

    public final boolean component44() {
        return this.enableLoadGeckoInThread;
    }

    public final String component45() {
        return this.optForRebuildId;
    }

    public final Long component46() {
        return this.rebuildTime;
    }

    public final Boolean component5() {
        return this.bundlePreloaded;
    }

    public final boolean component6() {
        return this.disableBuiltin;
    }

    public final Long component7() {
        return this.naOfflineVersion;
    }

    public final Boolean component8() {
        return this.geckoExist;
    }

    public final boolean component9() {
        return this.isTopTabPage;
    }

    public final IECNativeHomeArgument copy(String r510, Integer r511, Boolean r512, Boolean r513, Boolean r514, boolean r515, Long r516, Boolean r517, boolean r518, int r519, int r610, Boolean r611, boolean r612, boolean r613, boolean r614, String r615, long r616, String r617, String r618, Integer r710, int r711, boolean r712, Boolean r713, Long r714, Boolean r715, Integer r716, String r717, boolean r718, int r719, int r810, boolean r811, Integer r812, boolean r813, boolean r814, Map<String, String> r815, int r816, int r817, boolean r818, Map<String, String> r819, String r910, boolean r911, boolean r912, boolean r913, boolean r914, String r915, Long r916) {
        Intrinsics.checkNotNullParameter(r615, "dataEngineTag");
        Intrinsics.checkNotNullParameter(r717, "sceneID");
        return new IECNativeHomeArgument(r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IECNativeHomeArgument) == false) goto L98;
        IECNativeHomeArgument r101 = (IECNativeHomeArgument) r100;
        if (Intrinsics.areEqual(this.bundleConfigUrl, r101.bundleConfigUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadMoreRangeSize, r101.loadMoreRangeSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoSmoothEnter, r101.videoSmoothEnter) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveSmoothEnter, r101.liveSmoothEnter) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bundlePreloaded, r101.bundlePreloaded) == true) goto L16;
        return false;
    L16:
        if (this.disableBuiltin == r101.disableBuiltin) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.naOfflineVersion, r101.naOfflineVersion) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.geckoExist, r101.geckoExist) == true) goto L22;
        return false;
    L22:
        if (this.isTopTabPage == r101.isTopTabPage) goto L24;
        return false;
    L24:
        if (this.panelTopOffset == r101.panelTopOffset) goto L26;
        return false;
    L26:
        if (this.topBarPreloadStrategy == r101.topBarPreloadStrategy) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.refreshEnable, r101.refreshEnable) == true) goto L30;
        return false;
    L30:
        if (this.shouldCheckECPlugin == r101.shouldCheckECPlugin) goto L32;
        return false;
    L32:
        if (this.enableFirstScreenStraightOut == r101.enableFirstScreenStraightOut) goto L34;
        return false;
    L34:
        if (this.enableCorrectShowReport == r101.enableCorrectShowReport) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dataEngineTag, r101.dataEngineTag) == true) goto L38;
        return false;
    L38:
        if (this.pageCardDynamicParamTimeout == r101.pageCardDynamicParamTimeout) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.pageCardSchema, r101.pageCardSchema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.preloadTemplateConfig, r101.preloadTemplateConfig) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.reportSlardar, r101.reportSlardar) == true) goto L46;
        return false;
    L46:
        if (this.renderThreadStrategy == r101.renderThreadStrategy) goto L48;
        return false;
    L48:
        if (this.enableEngineParentControl == r101.enableEngineParentControl) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.needLeaveRefresh, r101.needLeaveRefresh) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.leaveTimeout, r101.leaveTimeout) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.needReportLastAction, r101.needReportLastAction) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.lastActionLen, r101.lastActionLen) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.sceneID, r101.sceneID) == true) goto L60;
        return false;
    L60:
        if (this.needRefreshPage == r101.needRefreshPage) goto L62;
        return false;
    L62:
        if (this.mallScrollTimeInterval == r101.mallScrollTimeInterval) goto L64;
        return false;
    L64:
        if (this.mallStraightOutSync == r101.mallStraightOutSync) goto L66;
        return false;
    L66:
        if (this.mallUpdateSuggestWorldByLynxCard == r101.mallUpdateSuggestWorldByLynxCard) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.bottomTabHeight, r101.bottomTabHeight) == true) goto L70;
        return false;
    L70:
        if (this.mallFPSMonitorAfterFirstScreen == r101.mallFPSMonitorAfterFirstScreen) goto L72;
        return false;
    L72:
        if (this.enableMallFpsOpt == r101.enableMallFpsOpt) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.grassParams, r101.grassParams) == true) goto L76;
        return false;
    L76:
        if (this.pageCardDelayInit == r101.pageCardDelayInit) goto L78;
        return false;
    L78:
        if (this.naMallPreloadStrategy == r101.naMallPreloadStrategy) goto L80;
        return false;
    L80:
        if (this.exposureEventAsyncReport == r101.exposureEventAsyncReport) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.landingInfo, r101.landingInfo) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.geckoChannel, r101.geckoChannel) == true) goto L86;
        return false;
    L86:
        if (this.enableTopBar == r101.enableTopBar) goto L88;
        return false;
    L88:
        if (this.enableBackground == r101.enableBackground) goto L90;
        return false;
    L90:
        if (this.showHalfMallBar == r101.showHalfMallBar) goto L92;
        return false;
    L92:
        if (this.enableLoadGeckoInThread == r101.enableLoadGeckoInThread) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.optForRebuildId, r101.optForRebuildId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.rebuildTime, r101.rebuildTime) == true) goto L148;
        return false;
    L148:
        return true;
    L98:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v110 */
    /* JADX WARN: Type inference failed for: r2v111 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v129 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v132 */
    /* JADX WARN: Type inference failed for: r2v137 */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v139 */
    /* JADX WARN: Type inference failed for: r2v140 */
    /* JADX WARN: Type inference failed for: r2v141 */
    /* JADX WARN: Type inference failed for: r2v142 */
    /* JADX WARN: Type inference failed for: r2v143 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v147 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v66, types: [int] */
    /* JADX WARN: Type inference failed for: r2v70, types: [int] */
    /* JADX WARN: Type inference failed for: r2v75, types: [int] */
    /* JADX WARN: Type inference failed for: r2v77, types: [int] */
    /* JADX WARN: Type inference failed for: r2v84, types: [int] */
    /* JADX WARN: Type inference failed for: r2v92, types: [int] */
    /* JADX WARN: Type inference failed for: r2v94, types: [int] */
    /* JADX WARN: Type inference failed for: r2v96, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.bundleConfigUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.loadMoreRangeSize;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.videoSmoothEnter;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.liveSmoothEnter;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.bundlePreloaded;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.disableBuiltin;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (r115 + r118) * 31;
        Long r120 = this.naOfflineVersion;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.geckoExist;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.isTopTabPage;
        ?? r127 = r126;
        if (r126 == false) goto L36;
        r127 = 1;
    L36:
        int r128 = (((((r125 + r127) * 31) + this.panelTopOffset) * 31) + this.topBarPreloadStrategy) * 31;
        Boolean r129 = this.refreshEnable;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.shouldCheckECPlugin;
        ?? r133 = r132;
        if (r132 == false) goto L43;
        r133 = 1;
    L43:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.enableFirstScreenStraightOut;
        ?? r136 = r135;
        if (r135 == false) goto L46;
        r136 = 1;
    L46:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.enableCorrectShowReport;
        ?? r139 = r138;
        if (r138 == false) goto L49;
        r139 = 1;
    L49:
        int r140 = (r137 + r139) * 31;
        String r141 = this.dataEngineTag;
        if (r141 == null) goto L52;
        int r142 = r141.hashCode();
    L53:
        long r143 = this.pageCardDynamicParamTimeout;
        int r144 = (((r140 + r142) * 31) + ((int) (r143 ^ (r143 >>> 32)))) * 31;
        String r145 = this.pageCardSchema;
        if (r145 == null) goto L56;
        int r146 = r145.hashCode();
    L57:
        int r147 = (r144 + r146) * 31;
        String r148 = this.preloadTemplateConfig;
        if (r148 == null) goto L60;
        int r149 = r148.hashCode();
    L61:
        int r150 = (r147 + r149) * 31;
        Integer r151 = this.reportSlardar;
        if (r151 == null) goto L64;
        int r152 = r151.hashCode();
    L65:
        int r153 = (((r150 + r152) * 31) + this.renderThreadStrategy) * 31;
        boolean r154 = this.enableEngineParentControl;
        ?? r155 = r154;
        if (r154 == false) goto L68;
        r155 = 1;
    L68:
        int r156 = (r153 + r155) * 31;
        Boolean r157 = this.needLeaveRefresh;
        if (r157 == null) goto L71;
        int r158 = r157.hashCode();
    L72:
        int r159 = (r156 + r158) * 31;
        Long r160 = this.leaveTimeout;
        if (r160 == null) goto L75;
        int r161 = r160.hashCode();
    L76:
        int r162 = (r159 + r161) * 31;
        Boolean r163 = this.needReportLastAction;
        if (r163 == null) goto L79;
        int r164 = r163.hashCode();
    L80:
        int r165 = (r162 + r164) * 31;
        Integer r166 = this.lastActionLen;
        if (r166 == null) goto L83;
        int r167 = r166.hashCode();
    L84:
        int r168 = (r165 + r167) * 31;
        String r169 = this.sceneID;
        if (r169 == null) goto L87;
        int r170 = r169.hashCode();
    L88:
        int r171 = (r168 + r170) * 31;
        boolean r172 = this.needRefreshPage;
        ?? r173 = r172;
        if (r172 == false) goto L91;
        r173 = 1;
    L91:
        int r174 = (((((r171 + r173) * 31) + this.mallScrollTimeInterval) * 31) + this.mallStraightOutSync) * 31;
        boolean r175 = this.mallUpdateSuggestWorldByLynxCard;
        ?? r176 = r175;
        if (r175 == false) goto L94;
        r176 = 1;
    L94:
        int r177 = (r174 + r176) * 31;
        Integer r178 = this.bottomTabHeight;
        if (r178 == null) goto L97;
        int r179 = r178.hashCode();
    L98:
        int r180 = (r177 + r179) * 31;
        boolean r181 = this.mallFPSMonitorAfterFirstScreen;
        ?? r182 = r181;
        if (r181 == false) goto L101;
        r182 = 1;
    L101:
        int r183 = (r180 + r182) * 31;
        boolean r184 = this.enableMallFpsOpt;
        ?? r185 = r184;
        if (r184 == false) goto L104;
        r185 = 1;
    L104:
        int r186 = (r183 + r185) * 31;
        Map<String, String> r187 = this.grassParams;
        if (r187 == null) goto L107;
        int r188 = r187.hashCode();
    L108:
        int r189 = (((((r186 + r188) * 31) + this.pageCardDelayInit) * 31) + this.naMallPreloadStrategy) * 31;
        boolean r190 = this.exposureEventAsyncReport;
        ?? r191 = r190;
        if (r190 == false) goto L111;
        r191 = 1;
    L111:
        int r192 = (r189 + r191) * 31;
        Map<String, String> r193 = this.landingInfo;
        if (r193 == null) goto L114;
        int r194 = r193.hashCode();
    L115:
        int r195 = (r192 + r194) * 31;
        String r196 = this.geckoChannel;
        if (r196 == null) goto L118;
        int r197 = r196.hashCode();
    L119:
        int r198 = (r195 + r197) * 31;
        boolean r199 = this.enableTopBar;
        ?? r200 = r199;
        if (r199 == false) goto L122;
        r200 = 1;
    L122:
        int r201 = (r198 + r200) * 31;
        boolean r202 = this.enableBackground;
        ?? r203 = r202;
        if (r202 == false) goto L125;
        r203 = 1;
    L125:
        int r204 = (r201 + r203) * 31;
        boolean r205 = this.showHalfMallBar;
        ?? r206 = r205;
        if (r205 == false) goto L128;
        r206 = 1;
    L128:
        int r207 = (r204 + r206) * 31;
        boolean r208 = this.enableLoadGeckoInThread;
        if (r208 == true) goto L132;
        r117 = r208;
    L132:
        int r209 = (r207 + r117) * 31;
        String r210 = this.optForRebuildId;
        if (r210 == null) goto L135;
        int r211 = r210.hashCode();
    L136:
        int r212 = (r209 + r211) * 31;
        Long r213 = this.rebuildTime;
        if (r213 == null) goto L140;
        r101 = r213.hashCode();
    L140:
        return r212 + r101;
    L135:
        r211 = 0;
        goto L136
    L118:
        r197 = 0;
        goto L119
    L114:
        r194 = 0;
        goto L115
    L107:
        r188 = 0;
        goto L108
    L97:
        r179 = 0;
        goto L98
    L87:
        r170 = 0;
        goto L88
    L83:
        r167 = 0;
        goto L84
    L79:
        r164 = 0;
        goto L80
    L75:
        r161 = 0;
        goto L76
    L71:
        r158 = 0;
        goto L72
    L64:
        r152 = 0;
        goto L65
    L60:
        r149 = 0;
        goto L61
    L56:
        r146 = 0;
        goto L57
    L52:
        r142 = 0;
        goto L53
    L39:
        r130 = 0;
        goto L40
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "IECNativeHomeArgument(bundleConfigUrl=" + this.bundleConfigUrl + ", loadMoreRangeSize=" + this.loadMoreRangeSize + ", videoSmoothEnter=" + this.videoSmoothEnter + ", liveSmoothEnter=" + this.liveSmoothEnter + ", bundlePreloaded=" + this.bundlePreloaded + ", disableBuiltin=" + this.disableBuiltin + ", naOfflineVersion=" + this.naOfflineVersion + ", geckoExist=" + this.geckoExist + ", isTopTabPage=" + this.isTopTabPage + ", panelTopOffset=" + this.panelTopOffset + ", topBarPreloadStrategy=" + this.topBarPreloadStrategy + ", refreshEnable=" + this.refreshEnable + ", shouldCheckECPlugin=" + this.shouldCheckECPlugin + ", enableFirstScreenStraightOut=" + this.enableFirstScreenStraightOut + ", enableCorrectShowReport=" + this.enableCorrectShowReport + ", dataEngineTag=" + this.dataEngineTag + ", pageCardDynamicParamTimeout=" + this.pageCardDynamicParamTimeout + ", pageCardSchema=" + this.pageCardSchema + ", preloadTemplateConfig=" + this.preloadTemplateConfig + ", reportSlardar=" + this.reportSlardar + ", renderThreadStrategy=" + this.renderThreadStrategy + ", enableEngineParentControl=" + this.enableEngineParentControl + ", needLeaveRefresh=" + this.needLeaveRefresh + ", leaveTimeout=" + this.leaveTimeout + ", needReportLastAction=" + this.needReportLastAction + ", lastActionLen=" + this.lastActionLen + ", sceneID=" + this.sceneID + ", needRefreshPage=" + this.needRefreshPage + ", mallScrollTimeInterval=" + this.mallScrollTimeInterval + ", mallStraightOutSync=" + this.mallStraightOutSync + ", mallUpdateSuggestWorldByLynxCard=" + this.mallUpdateSuggestWorldByLynxCard + ", bottomTabHeight=" + this.bottomTabHeight + ", mallFPSMonitorAfterFirstScreen=" + this.mallFPSMonitorAfterFirstScreen + ", enableMallFpsOpt=" + this.enableMallFpsOpt + ", grassParams=" + this.grassParams + ", pageCardDelayInit=" + this.pageCardDelayInit + ", naMallPreloadStrategy=" + this.naMallPreloadStrategy + ", exposureEventAsyncReport=" + this.exposureEventAsyncReport + ", landingInfo=" + this.landingInfo + ", geckoChannel=" + this.geckoChannel + ", enableTopBar=" + this.enableTopBar + ", enableBackground=" + this.enableBackground + ", showHalfMallBar=" + this.showHalfMallBar + ", enableLoadGeckoInThread=" + this.enableLoadGeckoInThread + ", optForRebuildId=" + this.optForRebuildId + ", rebuildTime=" + this.rebuildTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.bundleConfigUrl);
        Integer r102 = this.loadMoreRangeSize;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
    L6:
        Boolean r103 = this.videoSmoothEnter;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
    L10:
        Boolean r104 = this.liveSmoothEnter;
        if (r104 == null) goto L13;
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
    L14:
        Boolean r105 = this.bundlePreloaded;
        if (r105 == null) goto L17;
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
    L18:
        r100.writeInt(this.disableBuiltin ? 1 : 0);
        Long r106 = this.naOfflineVersion;
        if (r106 == null) goto L21;
        r100.writeInt(1);
        r100.writeLong(r106.longValue());
    L22:
        Boolean r107 = this.geckoExist;
        if (r107 == null) goto L25;
        r100.writeInt(1);
        r100.writeInt(r107.booleanValue() ? 1 : 0);
    L26:
        r100.writeInt(this.isTopTabPage ? 1 : 0);
        r100.writeInt(this.panelTopOffset);
        r100.writeInt(this.topBarPreloadStrategy);
        Boolean r108 = this.refreshEnable;
        if (r108 == null) goto L29;
        r100.writeInt(1);
        r100.writeInt(r108.booleanValue() ? 1 : 0);
    L30:
        r100.writeInt(this.shouldCheckECPlugin ? 1 : 0);
        r100.writeInt(this.enableFirstScreenStraightOut ? 1 : 0);
        r100.writeInt(this.enableCorrectShowReport ? 1 : 0);
        r100.writeString(this.dataEngineTag);
        r100.writeLong(this.pageCardDynamicParamTimeout);
        r100.writeString(this.pageCardSchema);
        r100.writeString(this.preloadTemplateConfig);
        Integer r109 = this.reportSlardar;
        if (r109 == null) goto L33;
        r100.writeInt(1);
        r100.writeInt(r109.intValue());
    L34:
        r100.writeInt(this.renderThreadStrategy);
        r100.writeInt(this.enableEngineParentControl ? 1 : 0);
        Boolean r110 = this.needLeaveRefresh;
        if (r110 == null) goto L37;
        r100.writeInt(1);
        r100.writeInt(r110.booleanValue() ? 1 : 0);
    L38:
        Long r111 = this.leaveTimeout;
        if (r111 == null) goto L41;
        r100.writeInt(1);
        r100.writeLong(r111.longValue());
    L42:
        Boolean r112 = this.needReportLastAction;
        if (r112 == null) goto L45;
        r100.writeInt(1);
        r100.writeInt(r112.booleanValue() ? 1 : 0);
    L46:
        Integer r113 = this.lastActionLen;
        if (r113 == null) goto L49;
        r100.writeInt(1);
        r100.writeInt(r113.intValue());
    L50:
        r100.writeString(this.sceneID);
        r100.writeInt(this.needRefreshPage ? 1 : 0);
        r100.writeInt(this.mallScrollTimeInterval);
        r100.writeInt(this.mallStraightOutSync);
        r100.writeInt(this.mallUpdateSuggestWorldByLynxCard ? 1 : 0);
        Integer r114 = this.bottomTabHeight;
        if (r114 == null) goto L53;
        r100.writeInt(1);
        r100.writeInt(r114.intValue());
    L54:
        r100.writeInt(this.mallFPSMonitorAfterFirstScreen ? 1 : 0);
        r100.writeInt(this.enableMallFpsOpt ? 1 : 0);
        Map<String, String> r115 = this.grassParams;
        if (r115 == null) goto L60;
        r100.writeInt(1);
        r100.writeInt(r115.size());
        Iterator<Map.Entry<String, String>> r116 = r115.entrySet().iterator();
    L58:
        if (r116.hasNext() == false) goto L61;
        Map.Entry<String, String> r117 = r116.next();
        r100.writeString(r117.getKey());
        r100.writeString(r117.getValue());
    L61:
        r100.writeInt(this.pageCardDelayInit);
        r100.writeInt(this.naMallPreloadStrategy);
        r100.writeInt(this.exposureEventAsyncReport ? 1 : 0);
        Map<String, String> r118 = this.landingInfo;
        if (r118 == null) goto L67;
        r100.writeInt(1);
        r100.writeInt(r118.size());
        Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
    L65:
        if (r119.hasNext() == false) goto L68;
        Map.Entry<String, String> r120 = r119.next();
        r100.writeString(r120.getKey());
        r100.writeString(r120.getValue());
    L68:
        r100.writeString(this.geckoChannel);
        r100.writeInt(this.enableTopBar ? 1 : 0);
        r100.writeInt(this.enableBackground ? 1 : 0);
        r100.writeInt(this.showHalfMallBar ? 1 : 0);
        r100.writeInt(this.enableLoadGeckoInThread ? 1 : 0);
        r100.writeString(this.optForRebuildId);
        Long r121 = this.rebuildTime;
        if (r121 == null) goto L71;
        r100.writeInt(1);
        r100.writeLong(r121.longValue());
        return;
    L71:
        r100.writeInt(0);
        return;
    L67:
        r100.writeInt(0);
        goto L68
    L60:
        r100.writeInt(0);
        goto L61
    L53:
        r100.writeInt(0);
        goto L54
    L49:
        r100.writeInt(0);
        goto L50
    L45:
        r100.writeInt(0);
        goto L46
    L41:
        r100.writeInt(0);
        goto L42
    L37:
        r100.writeInt(0);
        goto L38
    L33:
        r100.writeInt(0);
        goto L34
    L29:
        r100.writeInt(0);
        goto L30
    L25:
        r100.writeInt(0);
        goto L26
    L21:
        r100.writeInt(0);
        goto L22
    L17:
        r100.writeInt(0);
        goto L18
    L13:
        r100.writeInt(0);
        goto L14
    L9:
        r100.writeInt(0);
        goto L10
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final Integer getBottomTabHeight() {
        return this.bottomTabHeight;
    }

    public final String getBundleConfigUrl() {
        return this.bundleConfigUrl;
    }

    public final Boolean getBundlePreloaded() {
        return this.bundlePreloaded;
    }

    public final String getDataEngineTag() {
        return this.dataEngineTag;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final boolean getEnableBackground() {
        return this.enableBackground;
    }

    public final boolean getEnableCorrectShowReport() {
        return this.enableCorrectShowReport;
    }

    public final boolean getEnableEngineParentControl() {
        return this.enableEngineParentControl;
    }

    public final boolean getEnableFirstScreenStraightOut() {
        return this.enableFirstScreenStraightOut;
    }

    public final boolean getEnableLoadGeckoInThread() {
        return this.enableLoadGeckoInThread;
    }

    public final boolean getEnableMallFpsOpt() {
        return this.enableMallFpsOpt;
    }

    public final boolean getEnableTopBar() {
        return this.enableTopBar;
    }

    public final boolean getExposureEventAsyncReport() {
        return this.exposureEventAsyncReport;
    }

    public final String getGeckoChannel() {
        return this.geckoChannel;
    }

    public final Boolean getGeckoExist() {
        return this.geckoExist;
    }

    public final Map<String, String> getGrassParams() {
        return this.grassParams;
    }

    public final Map<String, String> getLandingInfo() {
        return this.landingInfo;
    }

    public final Integer getLastActionLen() {
        return this.lastActionLen;
    }

    public final Long getLeaveTimeout() {
        return this.leaveTimeout;
    }

    public final Boolean getLiveSmoothEnter() {
        return this.liveSmoothEnter;
    }

    public final Integer getLoadMoreRangeSize() {
        return this.loadMoreRangeSize;
    }

    public final boolean getMallFPSMonitorAfterFirstScreen() {
        return this.mallFPSMonitorAfterFirstScreen;
    }

    public final int getMallScrollTimeInterval() {
        return this.mallScrollTimeInterval;
    }

    public final int getMallStraightOutSync() {
        return this.mallStraightOutSync;
    }

    public final boolean getMallUpdateSuggestWorldByLynxCard() {
        return this.mallUpdateSuggestWorldByLynxCard;
    }

    public final int getNaMallPreloadStrategy() {
        return this.naMallPreloadStrategy;
    }

    public final Long getNaOfflineVersion() {
        return this.naOfflineVersion;
    }

    public final Boolean getNeedLeaveRefresh() {
        return this.needLeaveRefresh;
    }

    public final boolean getNeedRefreshPage() {
        return this.needRefreshPage;
    }

    public final Boolean getNeedReportLastAction() {
        return this.needReportLastAction;
    }

    public final String getOptForRebuildId() {
        return this.optForRebuildId;
    }

    public final int getPageCardDelayInit() {
        return this.pageCardDelayInit;
    }

    public final long getPageCardDynamicParamTimeout() {
        return this.pageCardDynamicParamTimeout;
    }

    public final String getPageCardSchema() {
        return this.pageCardSchema;
    }

    public final int getPanelTopOffset() {
        return this.panelTopOffset;
    }

    public final String getPreloadTemplateConfig() {
        return this.preloadTemplateConfig;
    }

    public final Long getRebuildTime() {
        return this.rebuildTime;
    }

    public final Boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final int getRenderThreadStrategy() {
        return this.renderThreadStrategy;
    }

    public final Integer getReportSlardar() {
        return this.reportSlardar;
    }

    public final String getSceneID() {
        return this.sceneID;
    }

    public final boolean getShouldCheckECPlugin() {
        return this.shouldCheckECPlugin;
    }

    public final boolean getShowHalfMallBar() {
        return this.showHalfMallBar;
    }

    public final int getTopBarPreloadStrategy() {
        return this.topBarPreloadStrategy;
    }

    public final Boolean getVideoSmoothEnter() {
        return this.videoSmoothEnter;
    }

    public final boolean isTopTabPage() {
        return this.isTopTabPage;
    }

    public final void setPreloadTemplateConfig(String r100) {
        this.preloadTemplateConfig = r100;
    }

    public IECNativeHomeArgument(String r100, Integer r101, Boolean r102, Boolean r103, Boolean r110, boolean r111, Long r112, Boolean r113, boolean r114, int r115, int r116, Boolean r117, boolean r118, boolean r119, boolean r210, String r211, long r212, String r213, String r214, Integer r215, int r216, boolean r217, Boolean r218, Long r310, Boolean r311, Integer r312, String r313, boolean r314, int r315, int r316, boolean r317, Integer r318, boolean r319, boolean r410, Map<String, String> r411, int r412, int r413, boolean r414, Map<String, String> r415, String r416, boolean r417, boolean r418, boolean r419, boolean r510, String r511, Long r512) {
        Intrinsics.checkNotNullParameter(r211, "dataEngineTag");
        Intrinsics.checkNotNullParameter(r313, "sceneID");
        this.bundleConfigUrl = r100;
        this.loadMoreRangeSize = r101;
        this.videoSmoothEnter = r102;
        this.liveSmoothEnter = r103;
        this.bundlePreloaded = r110;
        this.disableBuiltin = r111;
        this.naOfflineVersion = r112;
        this.geckoExist = r113;
        this.isTopTabPage = r114;
        this.panelTopOffset = r115;
        this.topBarPreloadStrategy = r116;
        this.refreshEnable = r117;
        this.shouldCheckECPlugin = r118;
        this.enableFirstScreenStraightOut = r119;
        this.enableCorrectShowReport = r210;
        this.dataEngineTag = r211;
        this.pageCardDynamicParamTimeout = r212;
        this.pageCardSchema = r213;
        this.preloadTemplateConfig = r214;
        this.reportSlardar = r215;
        this.renderThreadStrategy = r216;
        this.enableEngineParentControl = r217;
        this.needLeaveRefresh = r218;
        this.leaveTimeout = r310;
        this.needReportLastAction = r311;
        this.lastActionLen = r312;
        this.sceneID = r313;
        this.needRefreshPage = r314;
        this.mallScrollTimeInterval = r315;
        this.mallStraightOutSync = r316;
        this.mallUpdateSuggestWorldByLynxCard = r317;
        this.bottomTabHeight = r318;
        this.mallFPSMonitorAfterFirstScreen = r319;
        this.enableMallFpsOpt = r410;
        this.grassParams = r411;
        this.pageCardDelayInit = r412;
        this.naMallPreloadStrategy = r413;
        this.exposureEventAsyncReport = r414;
        this.landingInfo = r415;
        this.geckoChannel = r416;
        this.enableTopBar = r417;
        this.enableBackground = r418;
        this.showHalfMallBar = r419;
        this.enableLoadGeckoInThread = r510;
        this.optForRebuildId = r511;
        this.rebuildTime = r512;
    }

    public /* synthetic */ IECNativeHomeArgument(String r510, Integer r511, Boolean r512, Boolean r513, Boolean r514, boolean r515, Long r516, Boolean r610, boolean r611, int r612, int r613, Boolean r614, boolean r615, boolean r616, boolean r617, String r618, long r619, String r710, String r711, Integer r712, int r713, boolean r714, Boolean r715, Long r716, Boolean r717, Integer r718, String r810, boolean r811, int r812, int r813, boolean r814, Integer r815, boolean r816, boolean r817, Map r818, int r819, int r910, boolean r911, Map r912, String r913, boolean r914, boolean r915, boolean r916, boolean r917, String r918, Long r919, int r100, int r101, DefaultConstructorMarker r102) {
        if ((r100 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r100 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r100 & 4) == 0) goto L13;
        Boolean r105 = null;
    L15:
        if ((r100 & 8) == 0) goto L17;
        Boolean r106 = null;
    L19:
        if ((r100 & 16) == 0) goto L21;
        Boolean r107 = null;
    L23:
        if ((r100 & 32) == 0) goto L25;
        boolean r110 = false;
    L27:
        if ((r100 & 64) == 0) goto L29;
        Long r111 = null;
    L31:
        if ((r100 & 128) == 0) goto L33;
        Boolean r112 = null;
    L35:
        if ((r100 & 512) == 0) goto L37;
        int r113 = 0;
    L39:
        if ((r100 & 1024) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r100 & 2048) == 0) goto L45;
        Boolean r115 = null;
    L47:
        if ((r100 & 4096) == 0) goto L49;
        boolean r116 = false;
    L51:
        if ((r100 & 8192) == 0) goto L53;
        boolean r117 = false;
    L55:
        if ((r100 & 16384) == 0) goto L57;
        boolean r118 = false;
    L59:
        if ((65536 & r100) == 0) goto L61;
        long r210 = 200;
    L63:
        if ((131072 & r100) == 0) goto L65;
        String r211 = null;
    L67:
        if ((262144 & r100) == 0) goto L69;
        String r212 = null;
    L71:
        if ((524288 & r100) == 0) goto L73;
        Integer r213 = null;
    L75:
        if ((1048576 & r100) == 0) goto L77;
        int r214 = 0;
    L79:
        if ((2097152 & r100) == 0) goto L81;
        boolean r215 = true;
    L83:
        if ((4194304 & r100) == 0) goto L85;
        Boolean r216 = Boolean.FALSE;
    L87:
        if ((8388608 & r100) == 0) goto L89;
        Long r217 = Long.MAX_VALUE;
    L91:
        if ((16777216 & r100) == 0) goto L93;
        Boolean r310 = Boolean.FALSE;
    L95:
        if ((33554432 & r100) == 0) goto L97;
        Integer r311 = 0;
    L99:
        if ((67108864 & r100) == 0) goto L101;
        String r312 = UUID.randomUUID().toString();
    L103:
        if ((134217728 & r100) == 0) goto L105;
        boolean r313 = false;
    L107:
        if ((268435456 & r100) == 0) goto L109;
        int r314 = 150;
    L111:
        if ((536870912 & r100) == 0) goto L113;
        int r315 = 0;
    L115:
        if ((1073741824 & r100) == 0) goto L117;
        boolean r316 = false;
    L119:
        if ((r100 & Integer.MIN_VALUE) == 0) goto L121;
        Integer r317 = 0;
    L123:
        if ((r101 & 1) == 0) goto L125;
        boolean r318 = false;
    L127:
        if ((r101 & 2) == 0) goto L129;
        boolean r319 = false;
    L131:
        if ((r101 & 4) == 0) goto L133;
        Map r410 = null;
    L135:
        if ((r101 & 8) == 0) goto L137;
        int r411 = 0;
    L139:
        if ((r101 & 16) == 0) goto L141;
        int r412 = 0;
    L143:
        if ((r101 & 32) == 0) goto L145;
        boolean r413 = false;
    L147:
        if ((r101 & 64) == 0) goto L149;
        Map r414 = null;
    L151:
        if ((r101 & 128) == 0) goto L153;
        String r415 = null;
    L155:
        if ((r101 & 256) == 0) goto L157;
        boolean r416 = true;
    L159:
        if ((r101 & 512) == 0) goto L161;
        boolean r417 = true;
    L163:
        if ((r101 & 1024) == 0) goto L165;
        boolean r418 = false;
    L167:
        if ((r101 & 2048) == 0) goto L169;
        boolean r419 = false;
    L171:
        if ((r101 & 4096) == 0) goto L173;
        String r517 = null;
    L175:
        if ((r101 & 8192) == 0) goto L177;
        Long r518 = null;
    L178:
        this(r103, r104, r105, r106, r107, r110, r111, r112, r611, r113, r114, r115, r116, r117, r118, r618, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r517, r518);
        return;
    L177:
        r518 = r919;
        goto L178
    L173:
        r517 = r918;
        goto L175
    L169:
        r419 = r917;
        goto L171
    L165:
        r418 = r916;
        goto L167
    L161:
        r417 = r915;
        goto L163
    L157:
        r416 = r914;
        goto L159
    L153:
        r415 = r913;
        goto L155
    L149:
        r414 = r912;
        goto L151
    L145:
        r413 = r911;
        goto L147
    L141:
        r412 = r910;
        goto L143
    L137:
        r411 = r819;
        goto L139
    L133:
        r410 = r818;
        goto L135
    L129:
        r319 = r817;
        goto L131
    L125:
        r318 = r816;
        goto L127
    L121:
        r317 = r815;
        goto L123
    L117:
        r316 = r814;
        goto L119
    L113:
        r315 = r813;
        goto L115
    L109:
        r314 = r812;
        goto L111
    L105:
        r313 = r811;
        goto L107
    L101:
        r312 = r810;
        goto L103
    L97:
        r311 = r718;
        goto L99
    L93:
        r310 = r717;
        goto L95
    L89:
        r217 = r716;
        goto L91
    L85:
        r216 = r715;
        goto L87
    L81:
        r215 = r714;
        goto L83
    L77:
        r214 = r713;
        goto L79
    L73:
        r213 = r712;
        goto L75
    L69:
        r212 = r711;
        goto L71
    L65:
        r211 = r710;
        goto L67
    L61:
        r210 = r619;
        goto L63
    L57:
        r118 = r617;
        goto L59
    L53:
        r117 = r616;
        goto L55
    L49:
        r116 = r615;
        goto L51
    L45:
        r115 = r614;
        goto L47
    L41:
        r114 = r613;
        goto L43
    L37:
        r113 = r612;
        goto L39
    L33:
        r112 = r610;
        goto L35
    L29:
        r111 = r516;
        goto L31
    L25:
        r110 = r515;
        goto L27
    L21:
        r107 = r514;
        goto L23
    L17:
        r106 = r513;
        goto L19
    L13:
        r105 = r512;
        goto L15
    L9:
        r104 = r511;
        goto L11
    L5:
        r103 = r510;
        goto L7
    }
}
