package com.bytedance.android.btm.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import com.bytedance.android.btm.api.model.p;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0007J(\u0010\u0017\u001a\u00020\u00062\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007J2\u0010\u0017\u001a\u00020\u00062\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0015H\u0007J.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001aH\u0007J$\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0001H\u0007J\"\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\"\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020$H\u0007J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020%H\u0007J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'H\u0007J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'H\u0007J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0007J\u0010\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020'H\u0007J4\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001022\b\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u00100\u001a\u00020/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0013H\u0007J$\u00106\u001a\u00020\u00152\u0006\u00105\u001a\u0002042\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007JQ\u00109\u001a\u00020\u00152\u0006\u00105\u001a\u0002042\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00152\u0018\b\u0002\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000102H\u0007¢\u0006\u0004\b9\u0010:J\u0010\u0010=\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0007J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;H\u0007J\u0010\u0010=\u001a\u00020?2\u0006\u0010<\u001a\u00020?H\u0007J\b\u0010A\u001a\u00020@H\u0007J%\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bC\u0010DJ%\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bC\u0010EJ%\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bC\u0010FJ1\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0007¢\u0006\u0004\bC\u0010IJ1\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0007¢\u0006\u0004\bC\u0010JJ1\u0010C\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0007¢\u0006\u0004\bC\u0010KJ%\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bL\u0010DJ%\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bL\u0010EJ%\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\bL\u0010FJ1\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010N\u001a\u0004\u0018\u00010MH\u0007¢\u0006\u0004\bL\u0010OJ1\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010N\u001a\u0004\u0018\u00010MH\u0007¢\u0006\u0004\bL\u0010PJ1\u0010L\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010N\u001a\u0004\u0018\u00010MH\u0007¢\u0006\u0004\bL\u0010QJ\b\u0010S\u001a\u00020RH\u0007J\u0014\u0010V\u001a\u0004\u0018\u00010\u00132\b\u0010U\u001a\u0004\u0018\u00010TH\u0007J\u0014\u0010X\u001a\u0004\u0018\u00010W2\b\u0010U\u001a\u0004\u0018\u00010TH\u0007J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020YH\u0007J\u0016\u0010_\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010^\u001a\u00020]J*\u0010a\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013J\u0006\u0010c\u001a\u00020bJ\b\u0010e\u001a\u00020dH\u0007J\u0010\u0010h\u001a\u00020\u00062\u0006\u0010g\u001a\u00020fH\u0007J\u000e\u0010k\u001a\u00020\u00062\u0006\u0010j\u001a\u00020iJ\u000e\u0010l\u001a\u00020\u00062\u0006\u0010j\u001a\u00020iJ&\u0010p\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010m\u001a\u00020T2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010nH\u0007J\u0012\u0010p\u001a\u0004\u0018\u00010\u00132\u0006\u0010r\u001a\u00020qH\u0007J\u0012\u0010s\u001a\u0004\u0018\u00010\u00132\u0006\u0010r\u001a\u00020qH\u0007J&\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010m\u001a\u00020TH\u0007J4\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010m\u001a\u00020T2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00130uH\u0007J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010m\u001a\u00020TH\u0007J\"\u0010y\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010x\u001a\u00020\u00132\u0006\u0010m\u001a\u00020TH\u0007J$\u0010{\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010r\u001a\u00020n2\b\b\u0002\u0010z\u001a\u00020\u0015H\u0007J-\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010U\u001a\u0004\u0018\u00010T2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00130|2\b\b\u0002\u0010~\u001a\u00020/H\u0007J-\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010!\u001a\u0004\u0018\u00010\u00132\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00130|2\b\b\u0002\u0010~\u001a\u00020/H\u0007J*\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010U\u001a\u0004\u0018\u00010T2\b\b\u0002\u0010~\u001a\u00020/2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0015H\u0007J*\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010~\u001a\u00020/2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0015H\u0007J)\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007f2\u0007\u0010\u0083\u0001\u001a\u00020q2\b\b\u0002\u0010~\u001a\u00020/2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0015H\u0007J\t\u0010\u0085\u0001\u001a\u00020\u0015H\u0007J\u0013\u0010\u0086\u0001\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\u0013J\u0007\u0010\u008b\u0001\u001a\u00020\u0015J\u0007\u0010\u008c\u0001\u001a\u00020\u0015J\u0007\u0010\u008d\u0001\u001a\u00020\u0013J(\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u008e\u0001\u001a\u00020\u00132\u0007\u0010\u008f\u0001\u001a\u00020\u00132\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010nH\u0007J\u0016\u0010\u0092\u0001\u001a\u00020\u00152\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0013H\u0007Jv\u0010\u009d\u0001\u001a\u00020\u00152\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00012\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00132\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0097\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010\u009c\u0001\u001a\u00020\u0015H\u0007¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\t\u0010\u009f\u0001\u001a\u00020\u0015H\u0007J\u0007\u0010 \u0001\u001a\u00020\u0015J\u0007\u0010¡\u0001\u001a\u00020\u0006J\u0007\u0010¢\u0001\u001a\u00020\u0015R \u0010§\u0001\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/bytedance/android/btm/api/BtmSDK;", "", "Lcom/bytedance/android/btm/api/inner/e;", "createService", "Lcom/bytedance/android/btm/api/model/f;", "builder", "", "init", "initByLazy", "Landroid/app/Application;", "application", "minimizeInit", "Landroid/app/Activity;", "activity", "setInitInActivity", "Lcom/bytedance/android/btm/api/BtmHostDependManager;", "getDepend", "Ljava/lang/Class;", "clazz", "", "btm", "", "auto", "registerPageClass", "singleton", "clazzName", "Lcom/bytedance/android/btm/api/d;", "page", "registerPageInstance", "Lcom/bytedance/android/btm/api/e;", "instance", "unregisterPageInstance", "pageBtm", "sourceBtmToken", "registerBtmPageOnCreate", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/btm/api/a;", "Lcom/bytedance/android/btm/api/h;", "updateBtmPage", "Lcom/bytedance/android/btm/api/model/c;", "btmItem", "createBtmId", "obtainEventBtmParams", "willJumpToNextPage", "Lorg/json/JSONObject;", "createBtmChain", "btmId", "", "btmChainLength", "event", "", "generateBtmEventParams", "Landroid/view/View;", "view", "registerBtmPage", "back", "pageEventParams", "registerFEBtmPage", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Z", "Lcom/bytedance/android/btm/api/model/j;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "addBtmEventParam", "processEventModel", "Lcom/bytedance/android/btm/api/model/k;", "Lcom/bytedance/android/btm/api/BtmPageLifecycle;", "getPageLifecycle", "forward", "onPageShow", "(Ljava/lang/Object;Ljava/lang/Boolean;)V", "(Landroid/app/Activity;Ljava/lang/Boolean;)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/Boolean;)V", "Lcom/bytedance/android/btm/api/model/o;", "pageShowParams", "(Ljava/lang/Object;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/o;)V", "(Landroid/app/Activity;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/o;)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/o;)V", "onPageHide", "Lcom/bytedance/android/btm/api/model/m;", "pageHideParams", "(Ljava/lang/Object;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/m;)V", "(Landroid/app/Activity;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/m;)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/Boolean;Lcom/bytedance/android/btm/api/model/m;)V", "Lcom/bytedance/android/btm/api/c;", "getLaunchApi", "Lcom/bytedance/android/btm/api/model/PageFinder;", "finder", "getPageId", "Lcom/bytedance/android/btm/api/model/e;", "getBtmPageInfo", "Lcom/bytedance/android/btm/api/model/p;", "startNodeInfo", "externalEvoke", "schema", "Lcom/bytedance/android/btm/api/inner/h;", "callback", "getPageBtmWithSchemaAsync", "defaultPageBtm", "registerPageBtmWithSchemaAsync", "Lcom/bytedance/android/btm/api/k;", "getOnHybridContainerLoadSchemaCallback", "Lcom/bytedance/android/btm/api/g;", "getThreadExecutor", "Lcom/bytedance/android/btm/api/model/i;", "eventChecker", "registerEventChecker", "Lbd/b;", "pageCallback", "registerBtmPageCallback", "unregisterBtmPageCallback", "pageFinder", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "bcm", "createJumpSourceBtmToken", "Lcom/bytedance/android/btm/api/model/d;", "params", "createJumpSourceBtmTokenForJSB", "createReportParams", "", "extKeys", "createFullyReportParams", "key", "getReportParamsByKey", "clearOldValue", "setBcmPageParams", "", "biz", "chainLength", "Lkc/a;", "getBcmChainByFinder", "getBcmChainByToken", "isDomainStandard", "btmModel", "getBcmChainByBtmModel", "useV2Api", "removeSourceBtmTokenInQueue", "getCurrentResumedPage", "getLastCreatedPage", "tag", "setInitTag", "enableRouterMonitor", "removeBcmChainPageId", "getBtmJsbVersion", "originalUrl", "source", "bcmParams", "createExternalEvokeBtmToken", "enableExternalEvokeAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "category", "label", "", "value", "ext_value", "instant_only", "ext_json", "fromLancet", "onEventHook", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lorg/json/JSONObject;Z)Z", "delayEventHook", "removeSearchTokenC", "updateLazyDataSettings", "fixBcmValueNotConvert", "service$delegate", "Lkotlin/Lazy;", "getService", "()Lcom/bytedance/android/btm/api/inner/e;", "service", "<init>", "()V", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BtmSDK {
    public static final BtmSDK INSTANCE = null;
    private static final Lazy service$delegate = null;

    private BtmSDK() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public final String getBtmJsbVersion() {
        return "20001";
    }

    public final com.bytedance.android.btm.api.inner.e getService() {
        return (com.bytedance.android.btm.api.inner.e) service$delegate.getValue();
    }

    static {
        INSTANCE = new BtmSDK();
        service$delegate = LazyKt.lazy(BtmSDK$service$2.INSTANCE);
    }

    private final com.bytedance.android.btm.api.inner.e createService() {
    L13:
        th = move-exception;
        th.getMessage();
    L16:
        return com.bytedance.android.btm.api.inner.a.f42006g;
    L17:
        Constructor r100 = INVOKESTATIC_com_bytedance_android_btm_api_BtmSDK_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.btm.impl.BtmServiceImpl").getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L10
        r100.setAccessible(true);     // Catch: Throwable -> L10
        Object r101 = r100.newInstance(new Object[0]);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        return (com.bytedance.android.btm.api.inner.e) r101;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.btm.api.inner.IBtmService");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L13
        goto L16
    }

    public final void initByLazy() {
        Application r100 = BtmHostDependManager.F.b();
        if (r100 == null) goto L5;
        r100.registerComponentCallbacks(new b());
    L5:
        getService().init();
    }

    public final boolean delayEventHook() {
        return getService().delayEventHook();
    }

    public final boolean enableRouterMonitor() {
        return getService().enableRouterMonitor();
    }

    public final boolean fixBcmValueNotConvert() {
        return getService().fixBcmValueNotConvert();
    }

    public final Object getCurrentResumedPage() {
        return getService().getCurrentResumedPage();
    }

    public final Object getLastCreatedPage() {
        return getService().getLastCreatedPage();
    }

    public final c getLaunchApi() {
        return getService().getLaunchApi();
    }

    public final k getOnHybridContainerLoadSchemaCallback() {
        return getService().getHybridContainerLoadSchemaCallback();
    }

    public final BtmPageLifecycle getPageLifecycle() {
        return getService().getPageLifecycle();
    }

    public final g getThreadExecutor() {
        return getService().getThreadExecutor();
    }

    public final boolean removeBcmChainPageId() {
        return getService().removeBcmChainPageId();
    }

    public final boolean removeSearchTokenC() {
        return getService().removeSearchTokenC();
    }

    public final void updateLazyDataSettings() {
        getService().updateLazyDataSettings();
    }

    public final boolean useV2Api() {
        return getService().useV2ApiMall();
    }

    public final BtmHostDependManager getDepend() {
        return BtmHostDependManager.F;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_btm_api_BtmSDK_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static final /* synthetic */ com.bytedance.android.btm.api.inner.e access$createService(BtmSDK r100) {
        return r100.createService();
    }

    public final com.bytedance.android.btm.api.model.j addBtmEventParam(com.bytedance.android.btm.api.model.j r100) {
        return getService().addBtmEventParam(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "createReportParams || createJumpSourceBtmToken", imports = {}))
    public final JSONObject createBtmChain(com.bytedance.android.btm.api.model.c r100) {
        return getService().createBtmChain(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "createReportParams || createJumpSourceBtmToken", imports = {}))
    public final String createBtmId(com.bytedance.android.btm.api.model.c r100) {
        return getService().createBtmId(r100);
    }

    public final String createJumpSourceBtmToken(com.bytedance.android.btm.api.model.d r100) {
        return getService().createJumpSourceBtmToken(r100, false);
    }

    public final String createJumpSourceBtmTokenForJSB(com.bytedance.android.btm.api.model.d r100) {
        return getService().createJumpSourceBtmToken(r100, true);
    }

    public final boolean enableExternalEvokeAbility(String r100) {
        return getService().enableDeepLinkProcess(r100);
    }

    public final void externalEvoke(p r100) {
        getService().setStartNode(r100);
    }

    public final com.bytedance.android.btm.api.model.e getBtmPageInfo(PageFinder r100) {
        return getService().getBtmPageInfo(r100);
    }

    public final String getPageId(PageFinder r100) {
        return getService().getPageId(r100);
    }

    public final void init(com.bytedance.android.btm.api.model.f r110) {
        BtmHostDependManager r100 = BtmHostDependManager.F;
        r100.getClass();
        Application r101 = r110.f42034a;
        cd.c r102 = BtmHostDependManager.f41934b;
        KProperty<?>[] r103 = BtmHostDependManager.f41933a;
        boolean r104 = false;
        KProperty<?> r105 = r103[0];
        r102.f23359b = r101;
        boolean r106 = r110.f42035b;
        cd.c r107 = BtmHostDependManager.f41935c;
        KProperty<?> r108 = r103[1];
        r107.f23359b = Boolean.valueOf(r106);
        zc.c r109 = r110.f42036c;
        cd.c r111 = BtmHostDependManager.f41937e;
        KProperty<?> r112 = r103[3];
        r111.f23359b = r109;
        zc.h r113 = r110.f42037d;
        cd.c r114 = BtmHostDependManager.f41938f;
        KProperty<?> r115 = r103[4];
        r114.f23359b = r113;
        cd.c r116 = BtmHostDependManager.f41939g;
        KProperty<?> r117 = r103[5];
        r116.f23359b = null;
        zc.h r118 = r110.f42038e;
        cd.c r119 = BtmHostDependManager.f41940h;
        KProperty<?> r120 = r103[6];
        r119.f23359b = r118;
        cd.c r121 = BtmHostDependManager.f41941i;
        KProperty<?> r122 = r103[7];
        r121.f23359b = null;
        cd.c r123 = BtmHostDependManager.f41942j;
        KProperty<?> r124 = r103[8];
        r123.f23359b = null;
        cd.c r125 = BtmHostDependManager.f41943k;
        KProperty<?> r126 = r103[9];
        r125.f23359b = null;
        zc.a r127 = r110.f42039f;
        cd.c r128 = BtmHostDependManager.f41944l;
        KProperty<?> r129 = r103[10];
        r128.f23359b = r127;
        zc.g r130 = r110.f42040g;
        cd.c r131 = BtmHostDependManager.f41945m;
        KProperty<?> r132 = r103[11];
        r131.f23359b = r130;
        zc.e r133 = r110.f42041h;
        cd.c r134 = BtmHostDependManager.f41946n;
        KProperty<?> r135 = r103[12];
        r134.f23359b = r133;
        cd.c r136 = BtmHostDependManager.f41947o;
        KProperty<?> r137 = r103[13];
        r136.f23359b = null;
        String[] r138 = r110.f42043j;
        cd.c r139 = BtmHostDependManager.f41948p;
        KProperty<?> r140 = r103[14];
        r139.f23359b = r138;
        cd.c r141 = BtmHostDependManager.f41949q;
        KProperty<?> r142 = r103[15];
        r141.f23359b = "";
        boolean r143 = r110.f42044k;
        cd.c r144 = BtmHostDependManager.f41950r;
        KProperty<?> r145 = r103[16];
        r144.f23359b = Boolean.valueOf(r143);
        cd.c r146 = BtmHostDependManager.f41951s;
        KProperty<?> r147 = r103[17];
        r146.f23359b = Boolean.TRUE;
        cd.c r148 = BtmHostDependManager.f41952t;
        KProperty<?> r149 = r103[18];
        r148.f23359b = Boolean.FALSE;
        String r150 = r110.f42045l;
        cd.c r151 = BtmHostDependManager.f41953u;
        KProperty<?> r152 = r103[19];
        r151.f23359b = r150;
        String r153 = r110.f42046m;
        cd.c r154 = BtmHostDependManager.f41954v;
        KProperty<?> r155 = r103[20];
        r154.f23359b = r153;
        Function3<? super Long, ? super Long, ? super String, ? extends Object> r156 = r110.f42042i;
        cd.c r157 = BtmHostDependManager.C;
        KProperty<?> r158 = r103[23];
        r157.f23359b = r156;
        int r159 = r110.f42048o;
        cd.c r160 = BtmHostDependManager.f41955w;
        KProperty<?> r161 = r103[21];
        r160.f23359b = Integer.valueOf(r159);
        String r162 = r110.f42047n;
        cd.c r163 = BtmHostDependManager.f41956x;
        KProperty<?> r164 = r103[22];
        r163.f23359b = r162;
        Map<String, String> r165 = r110.f42049p;
        cd.c r166 = BtmHostDependManager.D;
        KProperty<?> r167 = r103[24];
        r166.f23359b = r165;
        String r168 = r110.f42050q;
        cd.c r169 = BtmHostDependManager.E;
        KProperty<?> r170 = r103[25];
        r169.f23359b = r168;
        com.bytedance.android.btm.api.inner.g r171 = INSTANCE.getService().getMonitor();
        if (r100.b() != null) goto L5;
    L18:
        r171.b(r104, BtmHostDependManager$initDepend$1.INSTANCE);
        Application r172 = r100.b();
        if (r172 == null) goto L21;
        r172.registerComponentCallbacks(new b());
    L21:
        getService().init();
        return;
    L5:
        if (((zc.c) r111.getValue(r100, r103[3])) == null) goto L18;
        if (((String[]) r139.getValue(r100, r103[14])).length != 0) goto L9;
        boolean r173 = true;
    L11:
        if ((!r173) == false) goto L18;
        if (r100.d().length() <= 0) goto L15;
        boolean r174 = true;
    L16:
        if (r174 == false) goto L18;
        r104 = true;
        goto L18
    L15:
        r174 = false;
        goto L16
    L9:
        r173 = false;
        goto L11
    }

    public final void minimizeInit(Application r100) {
        getService().minimizeInit(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "createReportParams", imports = {}))
    public final String obtainEventBtmParams(com.bytedance.android.btm.api.model.c r100) {
        r100.f42012b = Boolean.FALSE;
        return getService().createBtmId(r100);
    }

    public final boolean processEventModel(com.bytedance.android.btm.api.model.j r100) {
        return getService().processEventModel(r100);
    }

    public final void registerBtmPageCallback(bd.b r100) {
        getService().registerBtmPageCallback(r100);
    }

    public final void registerBtmPageOnCreate(a r100) {
        getDepend().getClass();
        BtmHostDependManager.g(r100);
    }

    public final void registerEventChecker(com.bytedance.android.btm.api.model.i r100) {
        getService().registerEventChecker(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageClass(final d r100) {
        getDepend().getClass();
        BtmSDK r101 = INSTANCE;
        com.bytedance.android.btm.api.inner.e r102 = r101.getService();
        String r103 = r100.f41969c;
        String r104 = r100.f41968b;
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L14;
        Class<?> r106 = r100.f41967a;
        if (r106 == null) goto L12;
        r104 = r106.getCanonicalName();
        if (r104 != null) goto L14;
    L12:
        r104 = "null";
    L14:
        if (r102.checkPageBtmFormat(r103, null, false, r104, null) == true) goto L18;
        BtmHostDependManager.f41957y.add(r100);
        ALogger.c(ALogger.f41996d, "registerPageClass", new BtmHostDependManager$registerPageClass$2(r100));
        r101.getService().onRegisterPage(r100);
        return;
    L18:
        return;
    L5:
        r105 = false;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageInstance(e r100) {
        getDepend().getClass();
        BtmHostDependManager.j(r100);
    }

    public final boolean removeSourceBtmTokenInQueue(String r100) {
        return getService().removeSourceBtmTokenInQueue(r100);
    }

    public final void setInitInActivity(Activity r100) {
        getService().setInitInActivity(r100);
    }

    public final void setInitTag(String r100) {
        getService().setInitTag(r100);
    }

    public final void unregisterBtmPageCallback(bd.b r100) {
        getService().unregisterBtmPageCallback(r100);
    }

    public final void unregisterPageInstance(Object r100) {
        getDepend().getClass();
        BtmHostDependManager.m(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "createJumpSourceBtmToken", imports = {}))
    public final void willJumpToNextPage(com.bytedance.android.btm.api.model.c r100) {
        r100.f42012b = Boolean.TRUE;
        getService().createBtmId(r100);
    }

    public final com.bytedance.android.btm.api.model.k addBtmEventParam(com.bytedance.android.btm.api.model.k r100) {
        return getService().addBtmEventParam(r100);
    }

    public final void registerBtmPageOnCreate(h r100) {
        getDepend().getClass();
        BtmHostDependManager.g(r100);
    }

    public final Map<String, Object> createFullyReportParams(String r100, PageFinder r101) {
        return getService().createFullyReportParams(r100, r101);
    }

    public final Map<String, Object> createReportParams(String r100, PageFinder r101) {
        return getService().createReportParams(r100, r101, null);
    }

    public final void getPageBtmWithSchemaAsync(String r100, com.bytedance.android.btm.api.inner.h r101) {
        getService().getPageBtmWithSchemaAsync(r100, r101);
    }

    public final void onPageHide(Activity r100, Boolean r101) {
        onPageHide(r100, r101, null);
    }

    public final void onPageShow(Activity r100, Boolean r101) {
        onPageShow(r100, r101, null);
    }

    public final void updateBtmPage(Activity r100, String r101) {
        getService().updateBtmPage(r100, r101);
    }

    public final void onPageHide(Fragment r100, Boolean r101) {
        onPageHide(r100, r101, null);
    }

    public final void onPageShow(Fragment r100, Boolean r101) {
        onPageShow(r100, r101, null);
    }

    public final void updateBtmPage(Fragment r100, String r101) {
        getService().updateBtmPage(r100, r101);
    }

    @Deprecated(message = "page必须为Activity/Fragment类型")
    public final void onPageHide(Object r100, Boolean r101) {
        onPageHide(r100, r101, null);
    }

    @Deprecated(message = "page必须为Activity/Fragment类型")
    public final void onPageShow(Object r100, Boolean r101) {
        onPageShow(r100, r101, null);
    }

    public final String createExternalEvokeBtmToken(String r100, String r101, BcmParams r102) {
        return getService().createExternalEvokeBtmToken(r100, r101, r102);
    }

    public final String createJumpSourceBtmToken(String r100, PageFinder r101, BcmParams r102) {
        com.bytedance.android.btm.api.inner.e r103 = getService();
        com.bytedance.android.btm.api.model.d r104 = new com.bytedance.android.btm.api.model.d();
        r104.f42022a = r100;
        r104.f42023b = r101;
        r104.f42024c = r102;
        return r103.createJumpSourceBtmToken(r104, false);
    }

    public final Map<String, Object> createReportParams(String r100, PageFinder r101, Set<String> r102) {
        return getService().createReportParams(r100, r101, r102);
    }

    public final Map<String, Object> generateBtmEventParams(String r100, int r101, String r102) {
        return getService().generateBtmEventParams(r100, r101, r102);
    }

    public final kc.a getBcmChainByBtmModel(com.bytedance.android.btm.api.model.d r100, int r101, boolean r102) {
        return com.bytedance.android.bcm.api.b.f41761a.getBcmChainByBtmModel(r100, CollectionsKt.listOf("ecom_entrance"), r101, r102);
    }

    public final kc.a getBcmChainByFinder(PageFinder r100, int r101, boolean r102) {
        return com.bytedance.android.bcm.api.b.f41761a.getBcmChainByFinder(r100, CollectionsKt.listOf("ecom_entrance"), r101, r102);
    }

    public final kc.a getBcmChainByToken(String r100, int r101, boolean r102) {
        return com.bytedance.android.bcm.api.b.f41761a.getBcmChainByToken(r100, CollectionsKt.listOf("ecom_entrance"), r101, r102);
    }

    public final Object getReportParamsByKey(String r100, String r101, PageFinder r102) {
        return getService().getReportParamsByKey(r100, r101, r102);
    }

    public final void onPageHide(Activity r100, final Boolean r101, final m r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageHide", new AnonymousClass2(r103, r101, r102));
        getPageLifecycle().e(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final void onPageShow(Activity r100, final Boolean r101, final o r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageShow", new C97852(r103, r101, r102));
        getPageLifecycle().g(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final boolean registerBtmPage(View r100, String r101, String r102) {
        return getService().registerBtmPage(r100, r101, r102, null);
    }

    public final void registerBtmPageOnCreate(Activity r100, String r101, String r102) {
        registerBtmPageOnCreate(new a(r100, r101, r102, 28));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageClass(Class<?> r100, String r101, boolean r102) {
        BtmHostDependManager r103 = getDepend();
        KProperty[] r104 = BtmHostDependManager.f41933a;
        r103.getClass();
        BtmHostDependManager.i(r100, r101, r102, false);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageInstance(Object r100, String r101, boolean r102) {
        getDepend().getClass();
        BtmHostDependManager.l(r100, r101, r102);
    }

    public final void setBcmPageParams(PageFinder r100, BcmParams r101, boolean r102) {
        com.bytedance.android.bcm.api.b.d(r100, r101, r102);
    }

    @Deprecated(message = "biz out of use")
    public final kc.a getBcmChainByFinder(PageFinder r100, List<String> r101, int r102) {
        return com.bytedance.android.bcm.api.b.b(r100, r101, r102);
    }

    @Deprecated(message = "biz out of use")
    public final kc.a getBcmChainByToken(String r100, List<String> r101, int r102) {
        return com.bytedance.android.bcm.api.b.f41761a.getBcmChainByToken(r100, r101, r102, false);
    }

    public final void onPageHide(Fragment r100, final Boolean r101, final m r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageHide", new AnonymousClass3(r103, r101, r102));
        getPageLifecycle().e(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final void onPageShow(Fragment r100, final Boolean r101, final o r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageShow", new C97863(r103, r101, r102));
        getPageLifecycle().g(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final void registerBtmPageOnCreate(Fragment r100, String r101, String r102) {
        registerBtmPageOnCreate(new h(r100, r101, r102, 28));
    }

    @Deprecated(message = "page必须为Activity/Fragment类型")
    public final void onPageHide(Object r100, final Boolean r101, final m r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageHide", new AnonymousClass1(r103, r101, r102));
        getPageLifecycle().e(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    @Deprecated(message = "page必须为Activity/Fragment类型")
    public final void onPageShow(Object r100, final Boolean r101, final o r102) {
        if (r100 == null) goto L4;
        final String r103 = r100.getClass().getName();
    L5:
        ALogger.c(ALogger.f41996d, "NA_onPageShow", new C97841(r103, r101, r102));
        getPageLifecycle().g(r100, r101, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public static /* synthetic */ boolean enableExternalEvokeAbility$default(BtmSDK r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.enableExternalEvokeAbility(r101);
    }

    public final void registerPageBtmWithSchemaAsync(String r100, Object r101, String r102, String r103) {
        getService().registerPageBtmWithSchemaAsync(r100, r101, r102, r103);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageClass(String r100, String r110, boolean r111, boolean r112) {
        getDepend().getClass();
        BtmSDK r101 = INSTANCE;
        if (r101.getService().checkPageBtmFormat(r110, null, false, r100, null) == true) goto L7;
        d r102 = new d(null, r100, r110, r111, r112);
        BtmHostDependManager.f41957y.add(r102);
        r101.getService().onRegisterPage(r102);
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "", replaceWith = @ReplaceWith(expression = "registerBtmPageOnCreate", imports = {}))
    public final void registerPageClass(Class<?> r100, String r101, boolean r102, boolean r103) {
        getDepend().getClass();
        BtmHostDependManager.i(r100, r101, r102, r103);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Activity r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageHide(r101, r102);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Activity r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageShow(r101, r102);
    }

    public final boolean registerFEBtmPage(View r100, String r101, String r102, Boolean r110, Map<String, ? extends Object> r111) {
        return getService().registerFEBtmPage(r100, r101, r102, r110, r111);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Fragment r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageHide(r101, r102);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Fragment r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageShow(r101, r102);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Object r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageHide(r101, r102);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Object r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onPageShow(r101, r102);
    }

    public static /* synthetic */ String createJumpSourceBtmToken$default(BtmSDK r100, String r101, PageFinder r102, BcmParams r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.createJumpSourceBtmToken(r101, r102, r103);
    }

    public static /* synthetic */ Map generateBtmEventParams$default(BtmSDK r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.generateBtmEventParams(r101, r102, r103);
    }

    public static /* synthetic */ kc.a getBcmChainByBtmModel$default(BtmSDK r100, com.bytedance.android.btm.api.model.d r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 20;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.getBcmChainByBtmModel(r101, r102, r103);
    }

    public static /* synthetic */ kc.a getBcmChainByFinder$default(BtmSDK r100, PageFinder r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 20;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.getBcmChainByFinder(r101, r102, r103);
    }

    public static /* synthetic */ kc.a getBcmChainByToken$default(BtmSDK r100, String r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 20;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.getBcmChainByToken(r101, r102, r103);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Activity r101, Boolean r102, m r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageHide(r101, r102, r103);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Activity r101, Boolean r102, o r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageShow(r101, r102, r103);
    }

    public static /* synthetic */ boolean registerBtmPage$default(BtmSDK r100, View r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.registerBtmPage(r101, r102, r103);
    }

    public static /* synthetic */ void registerPageClass$default(BtmSDK r100, Class r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = true;
    L8:
        r100.registerPageClass(r101, r102, r103);
    }

    public static /* synthetic */ void registerPageInstance$default(BtmSDK r100, Object r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = true;
    L8:
        r100.registerPageInstance(r101, r102, r103);
    }

    public static /* synthetic */ void setBcmPageParams$default(BtmSDK r100, PageFinder r101, BcmParams r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.setBcmPageParams(r101, r102, r103);
    }

    public static /* synthetic */ kc.a getBcmChainByFinder$default(BtmSDK r100, PageFinder r101, List r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = 20;
    L6:
        return r100.getBcmChainByFinder(r101, r102, r103);
    }

    public static /* synthetic */ kc.a getBcmChainByToken$default(BtmSDK r100, String r101, List r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = 20;
    L6:
        return r100.getBcmChainByToken(r101, r102, r103);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Fragment r101, Boolean r102, m r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageHide(r101, r102, r103);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Fragment r101, Boolean r102, o r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageShow(r101, r102, r103);
    }

    public static /* synthetic */ void onPageHide$default(BtmSDK r100, Object r101, Boolean r102, m r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageHide(r101, r102, r103);
    }

    public static /* synthetic */ void onPageShow$default(BtmSDK r100, Object r101, Boolean r102, o r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.onPageShow(r101, r102, r103);
    }

    public static /* synthetic */ void registerPageBtmWithSchemaAsync$default(BtmSDK r100, String r101, Object r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.registerPageBtmWithSchemaAsync(r101, r102, r103, r104);
    }

    public static /* synthetic */ void registerPageClass$default(BtmSDK r100, Class r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = true;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = false;
    L11:
        r100.registerPageClass(r101, r102, r103, r104);
    }

    public static /* synthetic */ void registerPageClass$default(BtmSDK r100, String r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = true;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = false;
    L11:
        r100.registerPageClass(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean registerFEBtmPage$default(BtmSDK r100, View r101, String r102, String r110, Boolean r111, Map r112, int r113, Object r114) {
        if ((r113 & 4) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        r111 = Boolean.FALSE;
    L9:
        Boolean r104 = r111;
        if ((r113 & 16) == 0) goto L12;
        Map r105 = null;
    L14:
        return r100.registerFEBtmPage(r101, r102, r103, r104, r105);
    L12:
        r105 = r112;
        goto L14
    L5:
        r103 = r110;
        goto L7
    }

    public final boolean onEventHook(Context r110, String r111, String r112, String r113, Long r114, Long r115, Boolean r116, JSONObject r117, boolean r118) {
        return getService().onEventHook(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
