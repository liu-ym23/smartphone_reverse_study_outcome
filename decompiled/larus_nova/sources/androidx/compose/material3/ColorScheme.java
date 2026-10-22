package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bm\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104B©\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b3\u00105Bñ\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b3\u00106Jí\u0003\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\bj\u0010kJ±\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bl\u0010mJ÷\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020qH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b;\u00108R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b<\u00108R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b=\u00108R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00108R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b?\u00108R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b@\u00108R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bA\u00108R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bB\u00108R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bC\u00108R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bD\u00108R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bE\u00108R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bF\u00108R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bG\u00108R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bH\u00108R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bI\u00108R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bJ\u00108R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bK\u00108R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bL\u00108R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bM\u00108R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bN\u00108R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bO\u00108R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bP\u00108R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bQ\u00108R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bR\u00108R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bS\u00108R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bT\u00108R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bU\u00108R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bV\u00108R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bW\u00108R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bX\u00108R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bY\u00108R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bZ\u00108R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b[\u00108R\u0013\u0010&\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b\\\u00108R\u0013\u0010'\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b]\u00108R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b^\u00108R\u0013\u0010)\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b_\u00108R\u0013\u0010*\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\b`\u00108R\u0013\u0010+\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\ba\u00108R\u0013\u0010,\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bb\u00108R\u0013\u0010-\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bc\u00108R\u0013\u0010.\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bd\u00108R\u0013\u0010/\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\be\u00108R\u0013\u00100\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bf\u00108R\u0013\u00101\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bg\u00108R\u0013\u00102\u001a\u00020\u0003¢\u0006\n\n\u0002\u00109\u001a\u0004\bh\u00108R\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR\u001c\u0010{\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010u\"\u0004\b}\u0010wR\u001d\u0010~\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010u\"\u0005\b\u0080\u0001\u0010wR\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010sX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010u\"\u0005\b\u0083\u0001\u0010wR\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\"\u0006\b\u008c\u0001\u0010\u0089\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0087\u0001\"\u0006\b\u008f\u0001\u0010\u0089\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0093\u0001\"\u0006\b\u0098\u0001\u0010\u0095\u0001R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u0093\u0001\"\u0006\b\u009b\u0001\u0010\u0095\u0001R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0093\u0001\"\u0006\b\u009e\u0001\u0010\u0095\u0001R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010¢\u0001\"\u0006\b§\u0001\u0010¤\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010¢\u0001\"\u0006\bª\u0001\u0010¤\u0001R\"\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R*\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\"\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R*\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bÁ\u0001\u0010´\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\"\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010É\u0001\"\u0006\bÎ\u0001\u0010Ë\u0001R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\"\u0010Õ\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0001\u0010Ò\u0001\"\u0006\b×\u0001\u0010Ô\u0001R\"\u0010Ø\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0001\u0010É\u0001\"\u0006\bÚ\u0001\u0010Ë\u0001R\"\u0010Û\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0001\u0010Ò\u0001\"\u0006\bÝ\u0001\u0010Ô\u0001R\"\u0010Þ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010É\u0001\"\u0006\bà\u0001\u0010Ë\u0001R\"\u0010á\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bâ\u0001\u0010Ò\u0001\"\u0006\bã\u0001\u0010Ô\u0001R\"\u0010ä\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bå\u0001\u0010É\u0001\"\u0006\bæ\u0001\u0010Ë\u0001R\"\u0010ç\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0001\u0010É\u0001\"\u0006\bé\u0001\u0010Ë\u0001R\"\u0010ê\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bë\u0001\u0010Ò\u0001\"\u0006\bì\u0001\u0010Ô\u0001R\"\u0010í\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0001\u0010Ò\u0001\"\u0006\bï\u0001\u0010Ô\u0001R\"\u0010ð\u0001\u001a\u0005\u0018\u00010ñ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R\"\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R\"\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R\"\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R\"\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0089\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R\"\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R\"\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0002\u0010\u0085\u0002\"\u0006\b\u0096\u0002\u0010\u0087\u0002R\"\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R\"\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\"\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\"\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R\"\u0010¯\u0002\u001a\u0005\u0018\u00010°\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R\"\u0010µ\u0002\u001a\u0005\u0018\u00010°\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0002\u0010²\u0002\"\u0006\b·\u0002\u0010´\u0002R*\u0010¸\u0002\u001a\u0005\u0018\u00010¹\u0002X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bº\u0002\u0010´\u0001\u001a\u0006\b»\u0002\u0010¼\u0002\"\u0006\b½\u0002\u0010¾\u0002R*\u0010¿\u0002\u001a\u0005\u0018\u00010À\u0002X\u0080\u000e¢\u0006\u001a\n\u0000\u0012\u0006\bÁ\u0002\u0010´\u0001\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002¨\u0006Æ\u0002"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", LynxVideoManagerLite.EVENT_ON_ERROR, "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPrimary-0d7_KjU", "()J", "J", "getOnPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getInversePrimary-0d7_KjU", "getSecondary-0d7_KjU", "getOnSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getTertiary-0d7_KjU", "getOnTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getBackground-0d7_KjU", "getOnBackground-0d7_KjU", "getSurface-0d7_KjU", "getOnSurface-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getSurfaceTint-0d7_KjU", "getInverseSurface-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getError-0d7_KjU", "getOnError-0d7_KjU", "getErrorContainer-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getScrim-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "getPrimaryFixed-0d7_KjU", "getPrimaryFixedDim-0d7_KjU", "getOnPrimaryFixed-0d7_KjU", "getOnPrimaryFixedVariant-0d7_KjU", "getSecondaryFixed-0d7_KjU", "getSecondaryFixedDim-0d7_KjU", "getOnSecondaryFixed-0d7_KjU", "getOnSecondaryFixedVariant-0d7_KjU", "getTertiaryFixed-0d7_KjU", "getTertiaryFixedDim-0d7_KjU", "getOnTertiaryFixed-0d7_KjU", "getOnTertiaryFixedVariant-0d7_KjU", "copy", "copy-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3", "(Landroidx/compose/material3/ButtonColors;)V", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3", "setDefaultElevatedButtonColorsCached$material3", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3", "setDefaultFilledTonalButtonColorsCached$material3", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3", "setDefaultOutlinedButtonColorsCached$material3", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3", "setDefaultTextButtonColorsCached$material3", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3", "(Landroidx/compose/material3/CardColors;)V", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3", "setDefaultElevatedCardColorsCached$material3", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3", "setDefaultOutlinedCardColorsCached$material3", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3", "(Landroidx/compose/material3/ChipColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3", "setDefaultElevatedAssistChipColorsCached$material3", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3", "setDefaultSuggestionChipColorsCached$material3", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3", "setDefaultElevatedSuggestionChipColorsCached$material3", "defaultFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultFilterChipColorsCached$material3", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultFilterChipColorsCached$material3", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedFilterChipColorsCached", "getDefaultElevatedFilterChipColorsCached$material3", "setDefaultElevatedFilterChipColorsCached$material3", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3", "setDefaultInputChipColorsCached$material3", "defaultVerticalDragHandleColorsCached", "Landroidx/compose/material3/DragHandleColors;", "getDefaultVerticalDragHandleColorsCached$material3", "()Landroidx/compose/material3/DragHandleColors;", "setDefaultVerticalDragHandleColorsCached$material3", "(Landroidx/compose/material3/DragHandleColors;)V", "defaultTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultTopAppBarColorsCached$material3$annotations", "()V", "getDefaultTopAppBarColorsCached$material3", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultTopAppBarColorsCached$material3", "(Landroidx/compose/material3/TopAppBarColors;)V", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3", "(Landroidx/compose/material3/CheckboxColors;)V", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3$annotations", "getDefaultDatePickerColorsCached$material3", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3", "(Landroidx/compose/material3/DatePickerColors;)V", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3", "(Landroidx/compose/material3/IconButtonColors;)V", "defaultIconButtonVibrantColorsCached", "getDefaultIconButtonVibrantColorsCached$material3", "setDefaultIconButtonVibrantColorsCached$material3", "defaultIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultIconToggleButtonColorsCached$material3", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultIconToggleButtonColorsCached$material3", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultIconToggleButtonVibrantColorsCached", "getDefaultIconToggleButtonVibrantColorsCached$material3", "setDefaultIconToggleButtonVibrantColorsCached$material3", "defaultFilledIconButtonColorsCached", "getDefaultFilledIconButtonColorsCached$material3", "setDefaultFilledIconButtonColorsCached$material3", "defaultFilledIconToggleButtonColorsCached", "getDefaultFilledIconToggleButtonColorsCached$material3", "setDefaultFilledIconToggleButtonColorsCached$material3", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3", "setDefaultFilledTonalIconButtonColorsCached$material3", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3", "setDefaultFilledTonalIconToggleButtonColorsCached$material3", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3", "setDefaultOutlinedIconButtonColorsCached$material3", "defaultOutlinedIconButtonVibrantColorsCached", "getDefaultOutlinedIconButtonVibrantColorsCached$material3", "setDefaultOutlinedIconButtonVibrantColorsCached$material3", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3", "setDefaultOutlinedIconToggleButtonColorsCached$material3", "defaultOutlinedIconToggleButtonVibrantColorsCached", "getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "defaultListItemColorsCached", "Landroidx/compose/material3/ListItemColors;", "getDefaultListItemColorsCached$material3", "()Landroidx/compose/material3/ListItemColors;", "setDefaultListItemColorsCached$material3", "(Landroidx/compose/material3/ListItemColors;)V", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3", "(Landroidx/compose/material3/MenuItemColors;)V", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "defaultShortNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultShortNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultShortNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationItemColors;)V", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "defaultWideWideNavigationRailColorsCached", "Landroidx/compose/material3/WideNavigationRailColors;", "getDefaultWideWideNavigationRailColorsCached$material3", "()Landroidx/compose/material3/WideNavigationRailColors;", "setDefaultWideWideNavigationRailColorsCached$material3", "(Landroidx/compose/material3/WideNavigationRailColors;)V", "defaultWideNavigationRailItemColorsCached", "getDefaultWideNavigationRailItemColorsCached$material3", "setDefaultWideNavigationRailItemColorsCached$material3", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3", "(Landroidx/compose/material3/RadioButtonColors;)V", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3", "(Landroidx/compose/material3/SliderColors;)V", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3", "(Landroidx/compose/material3/SwitchColors;)V", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3", "setDefaultTextFieldColorsCached$material3", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3$annotations", "getDefaultTimePickerColorsCached$material3", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3", "(Landroidx/compose/material3/TimePickerColors;)V", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3$annotations", "getDefaultRichTooltipColorsCached$material3", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3", "(Landroidx/compose/material3/RichTooltipColors;)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorScheme {
    public static final int $stable = 0;
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private IconButtonColors defaultFilledIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private IconButtonColors defaultIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private ListItemColors defaultListItemColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private IconButtonColors defaultOutlinedIconButtonColorsCached;
    private IconButtonColors defaultOutlinedIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private NavigationItemColors defaultShortNavigationBarItemColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private DragHandleColors defaultVerticalDragHandleColorsCached;
    private NavigationItemColors defaultWideNavigationRailItemColorsCached;
    private WideNavigationRailColors defaultWideWideNavigationRailColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onPrimaryFixed;
    private final long onPrimaryFixedVariant;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSecondaryFixed;
    private final long onSecondaryFixedVariant;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long onTertiaryFixed;
    private final long onTertiaryFixedVariant;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long primaryFixed;
    private final long primaryFixedDim;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long secondaryFixed;
    private final long secondaryFixedDim;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;
    private final long tertiaryFixed;
    private final long tertiaryFixedDim;

    public /* synthetic */ ColorScheme(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, DefaultConstructorMarker r913) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r810, r811, r812, r813, r814, r910, r911, r912);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use constructor with additional 'fixed' container roles.", replaceWith = @ReplaceWith(expression = "ColorScheme(primary,\nonPrimary,\nprimaryContainer,\nonPrimaryContainer,\ninversePrimary,\nsecondary,\nonSecondary,\nsecondaryContainer,\nonSecondaryContainer,\ntertiary,\nonTertiary,\ntertiaryContainer,\nonTertiaryContainer,\nbackground,\nonBackground,\nsurface,\nonSurface,\nsurfaceVariant,\nonSurfaceVariant,\nsurfaceTint,\ninverseSurface,\ninverseOnSurface,\nerror,\nonError,\nerrorContainer,\nonErrorContainer,\noutline,\noutlineVariant,\nscrim,\nsurfaceBright,\nsurfaceDim,\nsurfaceContainer,\nsurfaceContainerHigh,\nsurfaceContainerHighest,\nsurfaceContainerLow,\nsurfaceContainerLowest,)", imports = {}))
    public /* synthetic */ ColorScheme(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, DefaultConstructorMarker r711) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use constructor with additional 'surfaceContainer' roles.", replaceWith = @ReplaceWith(expression = "ColorScheme(primary,\nonPrimary,\nprimaryContainer,\nonPrimaryContainer,\ninversePrimary,\nsecondary,\nonSecondary,\nsecondaryContainer,\nonSecondaryContainer,\ntertiary,\nonTertiary,\ntertiaryContainer,\nonTertiaryContainer,\nbackground,\nonBackground,\nsurface,\nonSurface,\nsurfaceVariant,\nonSurfaceVariant,\nsurfaceTint,\ninverseSurface,\ninverseOnSurface,\nerror,\nonError,\nerrorContainer,\nonErrorContainer,\noutline,\noutlineVariant,\nscrim,\nsurfaceBright,\nsurfaceDim,\nsurfaceContainer,\nsurfaceContainerHigh,\nsurfaceContainerHighest,\nsurfaceContainerLow,\nsurfaceContainerLowest,\nprimaryFixed,\nprimaryFixedDim,\nonPrimaryFixed,\nonPrimaryFixedVariant,\nsecondaryFixed,\nsecondaryFixedDim,\nonSecondaryFixed,\nonSecondaryFixedVariant,\ntertiaryFixed,\ntertiaryFixedDim,\nonTertiaryFixed,\nonTertiaryFixedVariant)", imports = {}))
    public /* synthetic */ ColorScheme(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, DefaultConstructorMarker r514) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513);
    }

    public static /* synthetic */ void getDefaultDatePickerColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultRichTooltipColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultTimePickerColorsCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultTopAppBarColorsCached$material3$annotations() {
    }

    public String toString() {
        return "ColorScheme(primary=" + Color.m4835toStringimpl(this.primary) + "onPrimary=" + Color.m4835toStringimpl(this.onPrimary) + "primaryContainer=" + Color.m4835toStringimpl(this.primaryContainer) + "onPrimaryContainer=" + Color.m4835toStringimpl(this.onPrimaryContainer) + "inversePrimary=" + Color.m4835toStringimpl(this.inversePrimary) + "secondary=" + Color.m4835toStringimpl(this.secondary) + "onSecondary=" + Color.m4835toStringimpl(this.onSecondary) + "secondaryContainer=" + Color.m4835toStringimpl(this.secondaryContainer) + "onSecondaryContainer=" + Color.m4835toStringimpl(this.onSecondaryContainer) + "tertiary=" + Color.m4835toStringimpl(this.tertiary) + "onTertiary=" + Color.m4835toStringimpl(this.onTertiary) + "tertiaryContainer=" + Color.m4835toStringimpl(this.tertiaryContainer) + "onTertiaryContainer=" + Color.m4835toStringimpl(this.onTertiaryContainer) + "background=" + Color.m4835toStringimpl(this.background) + "onBackground=" + Color.m4835toStringimpl(this.onBackground) + "surface=" + Color.m4835toStringimpl(this.surface) + "onSurface=" + Color.m4835toStringimpl(this.onSurface) + "surfaceVariant=" + Color.m4835toStringimpl(this.surfaceVariant) + "onSurfaceVariant=" + Color.m4835toStringimpl(this.onSurfaceVariant) + "surfaceTint=" + Color.m4835toStringimpl(this.surfaceTint) + "inverseSurface=" + Color.m4835toStringimpl(this.inverseSurface) + "inverseOnSurface=" + Color.m4835toStringimpl(this.inverseOnSurface) + "error=" + Color.m4835toStringimpl(this.error) + "onError=" + Color.m4835toStringimpl(this.onError) + "errorContainer=" + Color.m4835toStringimpl(this.errorContainer) + "onErrorContainer=" + Color.m4835toStringimpl(this.onErrorContainer) + "outline=" + Color.m4835toStringimpl(this.outline) + "outlineVariant=" + Color.m4835toStringimpl(this.outlineVariant) + "scrim=" + Color.m4835toStringimpl(this.scrim) + "surfaceBright=" + Color.m4835toStringimpl(this.surfaceBright) + "surfaceDim=" + Color.m4835toStringimpl(this.surfaceDim) + "surfaceContainer=" + Color.m4835toStringimpl(this.surfaceContainer) + "surfaceContainerHigh=" + Color.m4835toStringimpl(this.surfaceContainerHigh) + "surfaceContainerHighest=" + Color.m4835toStringimpl(this.surfaceContainerHighest) + "surfaceContainerLow=" + Color.m4835toStringimpl(this.surfaceContainerLow) + "surfaceContainerLowest=" + Color.m4835toStringimpl(this.surfaceContainerLowest) + "primaryFixed=" + Color.m4835toStringimpl(this.primaryFixed) + "primaryFixedDim=" + Color.m4835toStringimpl(this.primaryFixedDim) + "onPrimaryFixed=" + Color.m4835toStringimpl(this.onPrimaryContainer) + "onPrimaryFixedVariant=" + Color.m4835toStringimpl(this.onPrimaryFixedVariant) + "secondaryFixed=" + Color.m4835toStringimpl(this.secondaryFixed) + "secondaryFixedDim=" + Color.m4835toStringimpl(this.secondaryFixedDim) + "onSecondaryFixed=" + Color.m4835toStringimpl(this.onSecondaryFixed) + "onSecondaryFixedVariant=" + Color.m4835toStringimpl(this.onSecondaryFixedVariant) + "tertiaryFixed=" + Color.m4835toStringimpl(this.tertiaryFixed) + "tertiaryFixedDim=" + Color.m4835toStringimpl(this.tertiaryFixedDim) + "onTertiaryFixed=" + Color.m4835toStringimpl(this.onTertiaryFixed) + "onTertiaryFixedVariant=" + Color.m4835toStringimpl(this.onTertiaryFixedVariant) + ')';
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1992getBackground0d7_KjU() {
        return this.background;
    }

    public final ChipColors getDefaultAssistChipColorsCached$material3() {
        return this.defaultAssistChipColorsCached;
    }

    public final ButtonColors getDefaultButtonColorsCached$material3() {
        return this.defaultButtonColorsCached;
    }

    public final CardColors getDefaultCardColorsCached$material3() {
        return this.defaultCardColorsCached;
    }

    public final CheckboxColors getDefaultCheckboxColorsCached$material3() {
        return this.defaultCheckboxColorsCached;
    }

    public final DatePickerColors getDefaultDatePickerColorsCached$material3() {
        return this.defaultDatePickerColorsCached;
    }

    public final ChipColors getDefaultElevatedAssistChipColorsCached$material3() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    public final ButtonColors getDefaultElevatedButtonColorsCached$material3() {
        return this.defaultElevatedButtonColorsCached;
    }

    public final CardColors getDefaultElevatedCardColorsCached$material3() {
        return this.defaultElevatedCardColorsCached;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColorsCached$material3() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColorsCached$material3() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    public final IconButtonColors getDefaultFilledIconButtonColorsCached$material3() {
        return this.defaultFilledIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColorsCached$material3() {
        return this.defaultFilledIconToggleButtonColorsCached;
    }

    public final ButtonColors getDefaultFilledTonalButtonColorsCached$material3() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColorsCached$material3() {
        return this.defaultFilledTonalIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColorsCached$material3() {
        return this.defaultFilledTonalIconToggleButtonColorsCached;
    }

    public final SelectableChipColors getDefaultFilterChipColorsCached$material3() {
        return this.defaultFilterChipColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonColorsCached$material3() {
        return this.defaultIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonVibrantColorsCached$material3() {
        return this.defaultIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonColorsCached$material3() {
        return this.defaultIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultIconToggleButtonVibrantColorsCached;
    }

    public final SelectableChipColors getDefaultInputChipColorsCached$material3() {
        return this.defaultInputChipColorsCached;
    }

    public final ListItemColors getDefaultListItemColorsCached$material3() {
        return this.defaultListItemColorsCached;
    }

    public final MenuItemColors getDefaultMenuItemColorsCached$material3() {
        return this.defaultMenuItemColorsCached;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached$material3() {
        return this.defaultNavigationBarItemColorsCached;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColorsCached$material3() {
        return this.defaultNavigationRailItemColorsCached;
    }

    public final ButtonColors getDefaultOutlinedButtonColorsCached$material3() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final CardColors getDefaultOutlinedCardColorsCached$material3() {
        return this.defaultOutlinedCardColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonColorsCached$material3() {
        return this.defaultOutlinedIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonVibrantColorsCached;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final RadioButtonColors getDefaultRadioButtonColorsCached$material3() {
        return this.defaultRadioButtonColorsCached;
    }

    public final RichTooltipColors getDefaultRichTooltipColorsCached$material3() {
        return this.defaultRichTooltipColorsCached;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColorsCached$material3() {
        return this.defaultSegmentedButtonColorsCached;
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColorsCached$material3() {
        return this.defaultShortNavigationBarItemColorsCached;
    }

    public final SliderColors getDefaultSliderColorsCached$material3() {
        return this.defaultSliderColorsCached;
    }

    public final ChipColors getDefaultSuggestionChipColorsCached$material3() {
        return this.defaultSuggestionChipColorsCached;
    }

    public final SwitchColors getDefaultSwitchColorsCached$material3() {
        return this.defaultSwitchColorsCached;
    }

    public final ButtonColors getDefaultTextButtonColorsCached$material3() {
        return this.defaultTextButtonColorsCached;
    }

    public final TextFieldColors getDefaultTextFieldColorsCached$material3() {
        return this.defaultTextFieldColorsCached;
    }

    public final TimePickerColors getDefaultTimePickerColorsCached$material3() {
        return this.defaultTimePickerColorsCached;
    }

    public final TopAppBarColors getDefaultTopAppBarColorsCached$material3() {
        return this.defaultTopAppBarColorsCached;
    }

    public final DragHandleColors getDefaultVerticalDragHandleColorsCached$material3() {
        return this.defaultVerticalDragHandleColorsCached;
    }

    public final NavigationItemColors getDefaultWideNavigationRailItemColorsCached$material3() {
        return this.defaultWideNavigationRailItemColorsCached;
    }

    public final WideNavigationRailColors getDefaultWideWideNavigationRailColorsCached$material3() {
        return this.defaultWideWideNavigationRailColorsCached;
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1993getError0d7_KjU() {
        return this.error;
    }

    /* JADX INFO: renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1994getErrorContainer0d7_KjU() {
        return this.errorContainer;
    }

    /* JADX INFO: renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1995getInverseOnSurface0d7_KjU() {
        return this.inverseOnSurface;
    }

    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m1996getInversePrimary0d7_KjU() {
        return this.inversePrimary;
    }

    /* JADX INFO: renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m1997getInverseSurface0d7_KjU() {
        return this.inverseSurface;
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1998getOnBackground0d7_KjU() {
        return this.onBackground;
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1999getOnError0d7_KjU() {
        return this.onError;
    }

    /* JADX INFO: renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m2000getOnErrorContainer0d7_KjU() {
        return this.onErrorContainer;
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m2001getOnPrimary0d7_KjU() {
        return this.onPrimary;
    }

    /* JADX INFO: renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2002getOnPrimaryContainer0d7_KjU() {
        return this.onPrimaryContainer;
    }

    /* JADX INFO: renamed from: getOnPrimaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2003getOnPrimaryFixed0d7_KjU() {
        return this.onPrimaryFixed;
    }

    /* JADX INFO: renamed from: getOnPrimaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2004getOnPrimaryFixedVariant0d7_KjU() {
        return this.onPrimaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m2005getOnSecondary0d7_KjU() {
        return this.onSecondary;
    }

    /* JADX INFO: renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2006getOnSecondaryContainer0d7_KjU() {
        return this.onSecondaryContainer;
    }

    /* JADX INFO: renamed from: getOnSecondaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2007getOnSecondaryFixed0d7_KjU() {
        return this.onSecondaryFixed;
    }

    /* JADX INFO: renamed from: getOnSecondaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2008getOnSecondaryFixedVariant0d7_KjU() {
        return this.onSecondaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m2009getOnSurface0d7_KjU() {
        return this.onSurface;
    }

    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m2010getOnSurfaceVariant0d7_KjU() {
        return this.onSurfaceVariant;
    }

    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m2011getOnTertiary0d7_KjU() {
        return this.onTertiary;
    }

    /* JADX INFO: renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2012getOnTertiaryContainer0d7_KjU() {
        return this.onTertiaryContainer;
    }

    /* JADX INFO: renamed from: getOnTertiaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2013getOnTertiaryFixed0d7_KjU() {
        return this.onTertiaryFixed;
    }

    /* JADX INFO: renamed from: getOnTertiaryFixedVariant-0d7_KjU, reason: not valid java name */
    public final long m2014getOnTertiaryFixedVariant0d7_KjU() {
        return this.onTertiaryFixedVariant;
    }

    /* JADX INFO: renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m2015getOutline0d7_KjU() {
        return this.outline;
    }

    /* JADX INFO: renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m2016getOutlineVariant0d7_KjU() {
        return this.outlineVariant;
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m2017getPrimary0d7_KjU() {
        return this.primary;
    }

    /* JADX INFO: renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2018getPrimaryContainer0d7_KjU() {
        return this.primaryContainer;
    }

    /* JADX INFO: renamed from: getPrimaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2019getPrimaryFixed0d7_KjU() {
        return this.primaryFixed;
    }

    /* JADX INFO: renamed from: getPrimaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2020getPrimaryFixedDim0d7_KjU() {
        return this.primaryFixedDim;
    }

    /* JADX INFO: renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m2021getScrim0d7_KjU() {
        return this.scrim;
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m2022getSecondary0d7_KjU() {
        return this.secondary;
    }

    /* JADX INFO: renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2023getSecondaryContainer0d7_KjU() {
        return this.secondaryContainer;
    }

    /* JADX INFO: renamed from: getSecondaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2024getSecondaryFixed0d7_KjU() {
        return this.secondaryFixed;
    }

    /* JADX INFO: renamed from: getSecondaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2025getSecondaryFixedDim0d7_KjU() {
        return this.secondaryFixedDim;
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m2026getSurface0d7_KjU() {
        return this.surface;
    }

    /* JADX INFO: renamed from: getSurfaceBright-0d7_KjU, reason: not valid java name */
    public final long m2027getSurfaceBright0d7_KjU() {
        return this.surfaceBright;
    }

    /* JADX INFO: renamed from: getSurfaceContainer-0d7_KjU, reason: not valid java name */
    public final long m2028getSurfaceContainer0d7_KjU() {
        return this.surfaceContainer;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHigh-0d7_KjU, reason: not valid java name */
    public final long m2029getSurfaceContainerHigh0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHighest-0d7_KjU, reason: not valid java name */
    public final long m2030getSurfaceContainerHighest0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLow-0d7_KjU, reason: not valid java name */
    public final long m2031getSurfaceContainerLow0d7_KjU() {
        return this.surfaceContainerLow;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLowest-0d7_KjU, reason: not valid java name */
    public final long m2032getSurfaceContainerLowest0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    /* JADX INFO: renamed from: getSurfaceDim-0d7_KjU, reason: not valid java name */
    public final long m2033getSurfaceDim0d7_KjU() {
        return this.surfaceDim;
    }

    /* JADX INFO: renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m2034getSurfaceTint0d7_KjU() {
        return this.surfaceTint;
    }

    /* JADX INFO: renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m2035getSurfaceVariant0d7_KjU() {
        return this.surfaceVariant;
    }

    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m2036getTertiary0d7_KjU() {
        return this.tertiary;
    }

    /* JADX INFO: renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m2037getTertiaryContainer0d7_KjU() {
        return this.tertiaryContainer;
    }

    /* JADX INFO: renamed from: getTertiaryFixed-0d7_KjU, reason: not valid java name */
    public final long m2038getTertiaryFixed0d7_KjU() {
        return this.tertiaryFixed;
    }

    /* JADX INFO: renamed from: getTertiaryFixedDim-0d7_KjU, reason: not valid java name */
    public final long m2039getTertiaryFixedDim0d7_KjU() {
        return this.tertiaryFixedDim;
    }

    public final void setDefaultAssistChipColorsCached$material3(ChipColors r100) {
        this.defaultAssistChipColorsCached = r100;
    }

    public final void setDefaultButtonColorsCached$material3(ButtonColors r100) {
        this.defaultButtonColorsCached = r100;
    }

    public final void setDefaultCardColorsCached$material3(CardColors r100) {
        this.defaultCardColorsCached = r100;
    }

    public final void setDefaultCheckboxColorsCached$material3(CheckboxColors r100) {
        this.defaultCheckboxColorsCached = r100;
    }

    public final void setDefaultDatePickerColorsCached$material3(DatePickerColors r100) {
        this.defaultDatePickerColorsCached = r100;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3(ChipColors r100) {
        this.defaultElevatedAssistChipColorsCached = r100;
    }

    public final void setDefaultElevatedButtonColorsCached$material3(ButtonColors r100) {
        this.defaultElevatedButtonColorsCached = r100;
    }

    public final void setDefaultElevatedCardColorsCached$material3(CardColors r100) {
        this.defaultElevatedCardColorsCached = r100;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3(SelectableChipColors r100) {
        this.defaultElevatedFilterChipColorsCached = r100;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3(ChipColors r100) {
        this.defaultElevatedSuggestionChipColorsCached = r100;
    }

    public final void setDefaultFilledIconButtonColorsCached$material3(IconButtonColors r100) {
        this.defaultFilledIconButtonColorsCached = r100;
    }

    public final void setDefaultFilledIconToggleButtonColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultFilledIconToggleButtonColorsCached = r100;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3(ButtonColors r100) {
        this.defaultFilledTonalButtonColorsCached = r100;
    }

    public final void setDefaultFilledTonalIconButtonColorsCached$material3(IconButtonColors r100) {
        this.defaultFilledTonalIconButtonColorsCached = r100;
    }

    public final void setDefaultFilledTonalIconToggleButtonColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultFilledTonalIconToggleButtonColorsCached = r100;
    }

    public final void setDefaultFilterChipColorsCached$material3(SelectableChipColors r100) {
        this.defaultFilterChipColorsCached = r100;
    }

    public final void setDefaultIconButtonColorsCached$material3(IconButtonColors r100) {
        this.defaultIconButtonColorsCached = r100;
    }

    public final void setDefaultIconButtonVibrantColorsCached$material3(IconButtonColors r100) {
        this.defaultIconButtonVibrantColorsCached = r100;
    }

    public final void setDefaultIconToggleButtonColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultIconToggleButtonColorsCached = r100;
    }

    public final void setDefaultIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultIconToggleButtonVibrantColorsCached = r100;
    }

    public final void setDefaultInputChipColorsCached$material3(SelectableChipColors r100) {
        this.defaultInputChipColorsCached = r100;
    }

    public final void setDefaultListItemColorsCached$material3(ListItemColors r100) {
        this.defaultListItemColorsCached = r100;
    }

    public final void setDefaultMenuItemColorsCached$material3(MenuItemColors r100) {
        this.defaultMenuItemColorsCached = r100;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3(NavigationBarItemColors r100) {
        this.defaultNavigationBarItemColorsCached = r100;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3(NavigationRailItemColors r100) {
        this.defaultNavigationRailItemColorsCached = r100;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3(ButtonColors r100) {
        this.defaultOutlinedButtonColorsCached = r100;
    }

    public final void setDefaultOutlinedCardColorsCached$material3(CardColors r100) {
        this.defaultOutlinedCardColorsCached = r100;
    }

    public final void setDefaultOutlinedIconButtonColorsCached$material3(IconButtonColors r100) {
        this.defaultOutlinedIconButtonColorsCached = r100;
    }

    public final void setDefaultOutlinedIconButtonVibrantColorsCached$material3(IconButtonColors r100) {
        this.defaultOutlinedIconButtonVibrantColorsCached = r100;
    }

    public final void setDefaultOutlinedIconToggleButtonColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultOutlinedIconToggleButtonColorsCached = r100;
    }

    public final void setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors r100) {
        this.defaultOutlinedIconToggleButtonVibrantColorsCached = r100;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3(TextFieldColors r100) {
        this.defaultOutlinedTextFieldColorsCached = r100;
    }

    public final void setDefaultRadioButtonColorsCached$material3(RadioButtonColors r100) {
        this.defaultRadioButtonColorsCached = r100;
    }

    public final void setDefaultRichTooltipColorsCached$material3(RichTooltipColors r100) {
        this.defaultRichTooltipColorsCached = r100;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3(SegmentedButtonColors r100) {
        this.defaultSegmentedButtonColorsCached = r100;
    }

    public final void setDefaultShortNavigationBarItemColorsCached$material3(NavigationItemColors r100) {
        this.defaultShortNavigationBarItemColorsCached = r100;
    }

    public final void setDefaultSliderColorsCached$material3(SliderColors r100) {
        this.defaultSliderColorsCached = r100;
    }

    public final void setDefaultSuggestionChipColorsCached$material3(ChipColors r100) {
        this.defaultSuggestionChipColorsCached = r100;
    }

    public final void setDefaultSwitchColorsCached$material3(SwitchColors r100) {
        this.defaultSwitchColorsCached = r100;
    }

    public final void setDefaultTextButtonColorsCached$material3(ButtonColors r100) {
        this.defaultTextButtonColorsCached = r100;
    }

    public final void setDefaultTextFieldColorsCached$material3(TextFieldColors r100) {
        this.defaultTextFieldColorsCached = r100;
    }

    public final void setDefaultTimePickerColorsCached$material3(TimePickerColors r100) {
        this.defaultTimePickerColorsCached = r100;
    }

    public final void setDefaultTopAppBarColorsCached$material3(TopAppBarColors r100) {
        this.defaultTopAppBarColorsCached = r100;
    }

    public final void setDefaultVerticalDragHandleColorsCached$material3(DragHandleColors r100) {
        this.defaultVerticalDragHandleColorsCached = r100;
    }

    public final void setDefaultWideNavigationRailItemColorsCached$material3(NavigationItemColors r100) {
        this.defaultWideNavigationRailItemColorsCached = r100;
    }

    public final void setDefaultWideWideNavigationRailColorsCached$material3(WideNavigationRailColors r100) {
        this.defaultWideWideNavigationRailColorsCached = r100;
    }

    private ColorScheme(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        Color.Companion r911 = Color.Companion;
        this(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional fixed roles instead")
    /* JADX INFO: renamed from: copy-G1PFc-w, reason: not valid java name */
    public final /* synthetic */ ColorScheme m1990copyG1PFcw(long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157) {
        return m1988copy_VG5OTI$default(this, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    /* JADX INFO: renamed from: copy-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1987copyG1PFcw$default(ColorScheme r110, long r111, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, int r713, Object r714) {
        if ((r713 & 1) == 0) goto L5;
        long r100 = r110.primary;
    L7:
        if ((r713 & 2) == 0) goto L9;
        long r101 = r110.onPrimary;
    L11:
        if ((r713 & 4) == 0) goto L13;
        long r102 = r110.primaryContainer;
    L15:
        if ((r713 & 8) == 0) goto L17;
        long r103 = r110.onPrimaryContainer;
    L19:
        if ((r713 & 16) == 0) goto L21;
        long r112 = r110.inversePrimary;
    L23:
        if ((r713 & 32) == 0) goto L25;
        long r113 = r110.secondary;
    L27:
        if ((r713 & 64) == 0) goto L29;
        long r114 = r110.onSecondary;
    L30:
        long r315 = r114;
        if ((r713 & 128) == 0) goto L33;
        long r115 = r110.secondaryContainer;
    L34:
        long r316 = r115;
        if ((r713 & 256) == 0) goto L37;
        long r116 = r110.onSecondaryContainer;
    L38:
        long r317 = r116;
        if ((r713 & 512) == 0) goto L41;
        long r117 = r110.tertiary;
    L42:
        long r318 = r117;
        if ((r713 & 1024) == 0) goto L45;
        long r118 = r110.onTertiary;
    L46:
        long r319 = r118;
        if ((r713 & 2048) == 0) goto L49;
        long r119 = r110.tertiaryContainer;
    L50:
        long r415 = r119;
        if ((r713 & 4096) == 0) goto L53;
        long r120 = r110.onTertiaryContainer;
    L54:
        long r416 = r120;
        if ((r713 & 8192) == 0) goto L57;
        long r121 = r110.background;
    L58:
        long r417 = r121;
        if ((r713 & 16384) == 0) goto L61;
        long r122 = r110.onBackground;
    L62:
        long r418 = r122;
        if ((r713 & 32768) == 0) goto L65;
        long r123 = r110.surface;
    L66:
        long r419 = r123;
        if ((r713 & 65536) == 0) goto L69;
        long r124 = r110.onSurface;
    L70:
        long r515 = r124;
        if ((r713 & 131072) == 0) goto L73;
        long r125 = r110.surfaceVariant;
    L74:
        long r516 = r125;
        if ((r713 & 262144) == 0) goto L77;
        long r126 = r110.onSurfaceVariant;
    L78:
        long r517 = r126;
        if ((r713 & 524288) == 0) goto L81;
        long r127 = r110.surfaceTint;
    L82:
        long r518 = r127;
        if ((r713 & 1048576) == 0) goto L85;
        long r128 = r110.inverseSurface;
    L86:
        long r519 = r128;
        if ((r713 & 2097152) == 0) goto L89;
        long r129 = r110.inverseOnSurface;
    L90:
        long r615 = r129;
        if ((r713 & 4194304) == 0) goto L93;
        long r130 = r110.error;
    L94:
        long r616 = r130;
        if ((r713 & 8388608) == 0) goto L97;
        long r131 = r110.onError;
    L98:
        long r617 = r131;
        if ((r713 & 16777216) == 0) goto L101;
        long r132 = r110.errorContainer;
    L102:
        long r618 = r132;
        if ((r713 & 33554432) == 0) goto L105;
        long r133 = r110.onErrorContainer;
    L106:
        long r619 = r133;
        if ((r713 & 67108864) == 0) goto L109;
        long r134 = r110.outline;
    L110:
        long r715 = r134;
        if ((r713 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r135 = r110.outlineVariant;
    L114:
        long r716 = r135;
        if ((r713 & 268435456) == 0) goto L117;
        long r136 = r110.scrim;
    L119:
        return r110.m1990copyG1PFcw(r100, r101, r102, r103, r112, r113, r315, r316, r317, r318, r319, r415, r416, r417, r418, r419, r515, r516, r517, r518, r519, r615, r616, r617, r618, r619, r715, r716, r136);
    L117:
        r136 = r712;
        goto L119
    L113:
        r135 = r711;
        goto L114
    L109:
        r134 = r710;
        goto L110
    L105:
        r133 = r614;
        goto L106
    L101:
        r132 = r613;
        goto L102
    L97:
        r131 = r612;
        goto L98
    L93:
        r130 = r611;
        goto L94
    L89:
        r129 = r610;
        goto L90
    L85:
        r128 = r514;
        goto L86
    L81:
        r127 = r513;
        goto L82
    L77:
        r126 = r512;
        goto L78
    L73:
        r125 = r511;
        goto L74
    L69:
        r124 = r510;
        goto L70
    L65:
        r123 = r414;
        goto L66
    L61:
        r122 = r413;
        goto L62
    L57:
        r121 = r412;
        goto L58
    L53:
        r120 = r411;
        goto L54
    L49:
        r119 = r410;
        goto L50
    L45:
        r118 = r314;
        goto L46
    L41:
        r117 = r313;
        goto L42
    L37:
        r116 = r312;
        goto L38
    L33:
        r115 = r311;
        goto L34
    L29:
        r114 = r310;
        goto L30
    L25:
        r113 = r214;
        goto L27
    L21:
        r112 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    private ColorScheme(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        Color.Companion r911 = Color.Companion;
        this(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), r911.m4863getUnspecified0d7_KjU(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional fixed roles instead")
    /* JADX INFO: renamed from: copy-C-Xl9yA, reason: not valid java name */
    public final /* synthetic */ ColorScheme m1989copyCXl9yA(long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171) {
        return m1988copy_VG5OTI$default(this, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, r171, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    /* JADX INFO: renamed from: copy-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1986copyCXl9yA$default(ColorScheme r110, long r111, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, int r910, int r911, Object r912) {
        if ((r910 & 1) == 0) goto L5;
        long r100 = r110.primary;
    L7:
        if ((r910 & 2) == 0) goto L9;
        long r101 = r110.onPrimary;
    L11:
        if ((r910 & 4) == 0) goto L13;
        long r102 = r110.primaryContainer;
    L15:
        if ((r910 & 8) == 0) goto L17;
        long r103 = r110.onPrimaryContainer;
    L19:
        if ((r910 & 16) == 0) goto L21;
        long r112 = r110.inversePrimary;
    L23:
        if ((r910 & 32) == 0) goto L25;
        long r113 = r110.secondary;
    L27:
        if ((r910 & 64) == 0) goto L29;
        long r114 = r110.onSecondary;
    L30:
        long r315 = r114;
        if ((r910 & 128) == 0) goto L33;
        long r115 = r110.secondaryContainer;
    L34:
        long r316 = r115;
        if ((r910 & 256) == 0) goto L37;
        long r116 = r110.onSecondaryContainer;
    L38:
        long r317 = r116;
        if ((r910 & 512) == 0) goto L41;
        long r117 = r110.tertiary;
    L42:
        long r318 = r117;
        if ((r910 & 1024) == 0) goto L45;
        long r118 = r110.onTertiary;
    L46:
        long r319 = r118;
        if ((r910 & 2048) == 0) goto L49;
        long r119 = r110.tertiaryContainer;
    L50:
        long r415 = r119;
        if ((r910 & 4096) == 0) goto L53;
        long r120 = r110.onTertiaryContainer;
    L54:
        long r416 = r120;
        if ((r910 & 8192) == 0) goto L57;
        long r121 = r110.background;
    L58:
        long r417 = r121;
        if ((r910 & 16384) == 0) goto L61;
        long r122 = r110.onBackground;
    L62:
        long r418 = r122;
        if ((r910 & 32768) == 0) goto L65;
        long r123 = r110.surface;
    L66:
        long r419 = r123;
        if ((r910 & 65536) == 0) goto L69;
        long r124 = r110.onSurface;
    L70:
        long r515 = r124;
        if ((r910 & 131072) == 0) goto L73;
        long r125 = r110.surfaceVariant;
    L74:
        long r516 = r125;
        if ((r910 & 262144) == 0) goto L77;
        long r126 = r110.onSurfaceVariant;
    L78:
        long r517 = r126;
        if ((r910 & 524288) == 0) goto L81;
        long r127 = r110.surfaceTint;
    L82:
        long r518 = r127;
        if ((r910 & 1048576) == 0) goto L85;
        long r128 = r110.inverseSurface;
    L86:
        long r519 = r128;
        if ((r910 & 2097152) == 0) goto L89;
        long r129 = r110.inverseOnSurface;
    L90:
        long r615 = r129;
        if ((r910 & 4194304) == 0) goto L93;
        long r130 = r110.error;
    L94:
        long r616 = r130;
        if ((r910 & 8388608) == 0) goto L97;
        long r131 = r110.onError;
    L98:
        long r617 = r131;
        if ((r910 & 16777216) == 0) goto L101;
        long r132 = r110.errorContainer;
    L102:
        long r618 = r132;
        if ((r910 & 33554432) == 0) goto L105;
        long r133 = r110.onErrorContainer;
    L106:
        long r619 = r133;
        if ((r910 & 67108864) == 0) goto L109;
        long r134 = r110.outline;
    L110:
        long r715 = r134;
        if ((r910 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r135 = r110.outlineVariant;
    L114:
        long r716 = r135;
        if ((r910 & 268435456) == 0) goto L117;
        long r136 = r110.scrim;
    L118:
        long r717 = r136;
        if ((r910 & 536870912) == 0) goto L121;
        long r137 = r110.surfaceBright;
    L122:
        long r718 = r137;
        if ((r910 & 1073741824) == 0) goto L125;
        long r138 = r110.surfaceDim;
    L126:
        long r719 = r138;
        if ((r910 & Integer.MIN_VALUE) == 0) goto L129;
        long r139 = r110.surfaceContainer;
    L130:
        long r815 = r139;
        if ((r911 & 1) == 0) goto L133;
        long r140 = r110.surfaceContainerHigh;
    L134:
        long r816 = r140;
        if ((r911 & 2) == 0) goto L137;
        long r141 = r110.surfaceContainerHighest;
    L138:
        long r817 = r141;
        if ((r911 & 4) == 0) goto L141;
        long r142 = r110.surfaceContainerLow;
    L142:
        long r818 = r142;
        if ((r911 & 8) == 0) goto L145;
        long r143 = r110.surfaceContainerLowest;
    L147:
        return r110.m1989copyCXl9yA(r100, r101, r102, r103, r112, r113, r315, r316, r317, r318, r319, r415, r416, r417, r418, r419, r515, r516, r517, r518, r519, r615, r616, r617, r618, r619, r715, r716, r717, r718, r719, r815, r816, r817, r818, r143);
    L145:
        r143 = r814;
        goto L147
    L141:
        r142 = r813;
        goto L142
    L137:
        r141 = r812;
        goto L138
    L133:
        r140 = r811;
        goto L134
    L129:
        r139 = r810;
        goto L130
    L125:
        r138 = r714;
        goto L126
    L121:
        r137 = r713;
        goto L122
    L117:
        r136 = r712;
        goto L118
    L113:
        r135 = r711;
        goto L114
    L109:
        r134 = r710;
        goto L110
    L105:
        r133 = r614;
        goto L106
    L101:
        r132 = r613;
        goto L102
    L97:
        r131 = r612;
        goto L98
    L93:
        r130 = r611;
        goto L94
    L89:
        r129 = r610;
        goto L90
    L85:
        r128 = r514;
        goto L86
    L81:
        r127 = r513;
        goto L82
    L77:
        r126 = r512;
        goto L78
    L73:
        r125 = r511;
        goto L74
    L69:
        r124 = r510;
        goto L70
    L65:
        r123 = r414;
        goto L66
    L61:
        r122 = r413;
        goto L62
    L57:
        r121 = r412;
        goto L58
    L53:
        r120 = r411;
        goto L54
    L49:
        r119 = r410;
        goto L50
    L45:
        r118 = r314;
        goto L46
    L41:
        r117 = r313;
        goto L42
    L37:
        r116 = r312;
        goto L38
    L33:
        r115 = r311;
        goto L34
    L29:
        r114 = r310;
        goto L30
    L25:
        r113 = r214;
        goto L27
    L21:
        r112 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    private ColorScheme(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914) {
        this.primary = r100;
        this.onPrimary = r101;
        this.primaryContainer = r102;
        this.onPrimaryContainer = r110;
        this.inversePrimary = r111;
        this.secondary = r112;
        this.onSecondary = r113;
        this.secondaryContainer = r114;
        this.onSecondaryContainer = r210;
        this.tertiary = r211;
        this.onTertiary = r212;
        this.tertiaryContainer = r213;
        this.onTertiaryContainer = r214;
        this.background = r310;
        this.onBackground = r311;
        this.surface = r312;
        this.onSurface = r313;
        this.surfaceVariant = r314;
        this.onSurfaceVariant = r410;
        this.surfaceTint = r411;
        this.inverseSurface = r412;
        this.inverseOnSurface = r413;
        this.error = r414;
        this.onError = r510;
        this.errorContainer = r511;
        this.onErrorContainer = r512;
        this.outline = r513;
        this.outlineVariant = r514;
        this.scrim = r610;
        this.surfaceBright = r611;
        this.surfaceDim = r612;
        this.surfaceContainer = r613;
        this.surfaceContainerHigh = r614;
        this.surfaceContainerHighest = r710;
        this.surfaceContainerLow = r711;
        this.surfaceContainerLowest = r712;
        this.primaryFixed = r713;
        this.primaryFixedDim = r714;
        this.onPrimaryFixed = r810;
        this.onPrimaryFixedVariant = r811;
        this.secondaryFixed = r812;
        this.secondaryFixedDim = r813;
        this.onSecondaryFixed = r814;
        this.onSecondaryFixedVariant = r910;
        this.tertiaryFixed = r911;
        this.tertiaryFixedDim = r912;
        this.onTertiaryFixed = r913;
        this.onTertiaryFixedVariant = r914;
    }

    /* JADX INFO: renamed from: copy-_VG5OTI, reason: not valid java name */
    public final ColorScheme m1991copy_VG5OTI(long r100, long r102, long r104, long r106, long r108, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194) {
        return new ColorScheme(r100, r102, r104, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r134, r136, r138, r140, r142, r144, r146, r148, r150, r152, r154, r156, r158, r160, r162, r164, r166, r168, r170, r172, r174, r176, r178, r180, r182, r184, r186, r188, r190, r192, r194, null);
    }

    /* JADX INFO: renamed from: copy-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1988copy_VG5OTI$default(ColorScheme r110, long r111, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r100, long r102, long r104, long r106, long r108, long r112, long r113, int r114, int r115, Object r116) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = r110.primary;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r103 = r110.onPrimary;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r105 = r110.primaryContainer;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r107 = r110.onPrimaryContainer;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r117 = r110.inversePrimary;
    L23:
        if ((r114 & 32) == 0) goto L25;
        long r118 = r110.secondary;
    L26:
        long r215 = r118;
        if ((r114 & 64) == 0) goto L29;
        long r119 = r110.onSecondary;
    L30:
        long r315 = r119;
        if ((r114 & 128) == 0) goto L33;
        long r120 = r110.secondaryContainer;
    L34:
        long r316 = r120;
        if ((r114 & 256) == 0) goto L37;
        long r121 = r110.onSecondaryContainer;
    L38:
        long r317 = r121;
        if ((r114 & 512) == 0) goto L41;
        long r122 = r110.tertiary;
    L42:
        long r318 = r122;
        if ((r114 & 1024) == 0) goto L45;
        long r123 = r110.onTertiary;
    L46:
        long r319 = r123;
        if ((r114 & 2048) == 0) goto L49;
        long r124 = r110.tertiaryContainer;
    L50:
        long r415 = r124;
        if ((r114 & 4096) == 0) goto L53;
        long r125 = r110.onTertiaryContainer;
    L54:
        long r416 = r125;
        if ((r114 & 8192) == 0) goto L57;
        long r126 = r110.background;
    L58:
        long r417 = r126;
        if ((r114 & 16384) == 0) goto L61;
        long r127 = r110.onBackground;
    L62:
        long r418 = r127;
        if ((r114 & 32768) == 0) goto L65;
        long r128 = r110.surface;
    L66:
        long r419 = r128;
        if ((r114 & 65536) == 0) goto L69;
        long r129 = r110.onSurface;
    L70:
        long r515 = r129;
        if ((r114 & 131072) == 0) goto L73;
        long r130 = r110.surfaceVariant;
    L74:
        long r516 = r130;
        if ((r114 & 262144) == 0) goto L77;
        long r131 = r110.onSurfaceVariant;
    L78:
        long r517 = r131;
        if ((r114 & 524288) == 0) goto L81;
        long r132 = r110.surfaceTint;
    L82:
        long r518 = r132;
        if ((r114 & 1048576) == 0) goto L85;
        long r133 = r110.inverseSurface;
    L86:
        long r519 = r133;
        if ((r114 & 2097152) == 0) goto L89;
        long r134 = r110.inverseOnSurface;
    L90:
        long r615 = r134;
        if ((r114 & 4194304) == 0) goto L93;
        long r135 = r110.error;
    L94:
        long r616 = r135;
        if ((r114 & 8388608) == 0) goto L97;
        long r136 = r110.onError;
    L98:
        long r617 = r136;
        if ((r114 & 16777216) == 0) goto L101;
        long r137 = r110.errorContainer;
    L102:
        long r618 = r137;
        if ((r114 & 33554432) == 0) goto L105;
        long r138 = r110.onErrorContainer;
    L106:
        long r619 = r138;
        if ((r114 & 67108864) == 0) goto L109;
        long r139 = r110.outline;
    L110:
        long r715 = r139;
        if ((r114 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r140 = r110.outlineVariant;
    L114:
        long r716 = r140;
        if ((r114 & 268435456) == 0) goto L117;
        long r141 = r110.scrim;
    L118:
        long r717 = r141;
        if ((r114 & 536870912) == 0) goto L121;
        long r142 = r110.surfaceBright;
    L122:
        long r718 = r142;
        if ((r114 & 1073741824) == 0) goto L125;
        long r143 = r110.surfaceDim;
    L126:
        long r719 = r143;
        if ((r114 & Integer.MIN_VALUE) == 0) goto L129;
        long r144 = r110.surfaceContainer;
    L130:
        long r815 = r144;
        if ((r115 & 1) == 0) goto L133;
        long r145 = r110.surfaceContainerHigh;
    L134:
        long r816 = r145;
        if ((r115 & 2) == 0) goto L137;
        long r146 = r110.surfaceContainerHighest;
    L138:
        long r817 = r146;
        if ((r115 & 4) == 0) goto L141;
        long r147 = r110.surfaceContainerLow;
    L142:
        long r818 = r147;
        if ((r115 & 8) == 0) goto L145;
        long r148 = r110.surfaceContainerLowest;
    L146:
        long r819 = r148;
        if ((r115 & 16) == 0) goto L149;
        long r149 = r110.primaryFixed;
    L150:
        long r915 = r149;
        if ((r115 & 32) == 0) goto L153;
        long r150 = r110.primaryFixedDim;
    L154:
        long r916 = r150;
        if ((r115 & 64) == 0) goto L157;
        long r151 = r110.onPrimaryFixed;
    L158:
        long r917 = r151;
        if ((r115 & 128) == 0) goto L161;
        long r152 = r110.onPrimaryFixedVariant;
    L162:
        long r918 = r152;
        if ((r115 & 256) == 0) goto L165;
        long r153 = r110.secondaryFixed;
    L166:
        long r919 = r153;
        if ((r115 & 512) == 0) goto L169;
        long r154 = r110.secondaryFixedDim;
    L170:
        long r109 = r154;
        if ((r115 & 1024) == 0) goto L173;
        long r155 = r110.onSecondaryFixed;
    L174:
        long r1010 = r155;
        if ((r115 & 2048) == 0) goto L177;
        long r156 = r110.onSecondaryFixedVariant;
    L178:
        long r1011 = r156;
        if ((r115 & 4096) == 0) goto L181;
        long r157 = r110.tertiaryFixed;
    L182:
        long r1012 = r157;
        if ((r115 & 8192) == 0) goto L185;
        long r158 = r110.tertiaryFixedDim;
    L186:
        long r1013 = r158;
        if ((r115 & 16384) == 0) goto L189;
        long r159 = r110.onTertiaryFixed;
    L191:
        if ((r115 & 32768) == 0) goto L193;
        long r160 = r110.onTertiaryFixedVariant;
    L195:
        return r110.m1991copy_VG5OTI(r101, r103, r105, r107, r117, r215, r315, r316, r317, r318, r319, r415, r416, r417, r418, r419, r515, r516, r517, r518, r519, r615, r616, r617, r618, r619, r715, r716, r717, r718, r719, r815, r816, r817, r818, r819, r915, r916, r917, r918, r919, r109, r1010, r1011, r1012, r1013, r159, r160);
    L193:
        r160 = r113;
        goto L195
    L189:
        r159 = r112;
        goto L191
    L185:
        r158 = r108;
        goto L186
    L181:
        r157 = r106;
        goto L182
    L177:
        r156 = r104;
        goto L178
    L173:
        r155 = r102;
        goto L174
    L169:
        r154 = r100;
        goto L170
    L165:
        r153 = r914;
        goto L166
    L161:
        r152 = r913;
        goto L162
    L157:
        r151 = r912;
        goto L158
    L153:
        r150 = r911;
        goto L154
    L149:
        r149 = r910;
        goto L150
    L145:
        r148 = r814;
        goto L146
    L141:
        r147 = r813;
        goto L142
    L137:
        r146 = r812;
        goto L138
    L133:
        r145 = r811;
        goto L134
    L129:
        r144 = r810;
        goto L130
    L125:
        r143 = r714;
        goto L126
    L121:
        r142 = r713;
        goto L122
    L117:
        r141 = r712;
        goto L118
    L113:
        r140 = r711;
        goto L114
    L109:
        r139 = r710;
        goto L110
    L105:
        r138 = r614;
        goto L106
    L101:
        r137 = r613;
        goto L102
    L97:
        r136 = r612;
        goto L98
    L93:
        r135 = r611;
        goto L94
    L89:
        r134 = r610;
        goto L90
    L85:
        r133 = r514;
        goto L86
    L81:
        r132 = r513;
        goto L82
    L77:
        r131 = r512;
        goto L78
    L73:
        r130 = r511;
        goto L74
    L69:
        r129 = r510;
        goto L70
    L65:
        r128 = r414;
        goto L66
    L61:
        r127 = r413;
        goto L62
    L57:
        r126 = r412;
        goto L58
    L53:
        r125 = r411;
        goto L54
    L49:
        r124 = r410;
        goto L50
    L45:
        r123 = r314;
        goto L46
    L41:
        r122 = r313;
        goto L42
    L37:
        r121 = r312;
        goto L38
    L33:
        r120 = r311;
        goto L34
    L29:
        r119 = r310;
        goto L30
    L25:
        r118 = r214;
        goto L26
    L21:
        r117 = r213;
        goto L23
    L17:
        r107 = r212;
        goto L19
    L13:
        r105 = r211;
        goto L15
    L9:
        r103 = r210;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
