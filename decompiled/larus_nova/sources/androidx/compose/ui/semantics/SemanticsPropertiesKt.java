package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0013\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\u0002¢\u0006\u0002\u0010\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a=\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u001e\b\b\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bH\u0080\b\u001a-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n0\u0004\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\n\u0010!\u001a\u00020\"*\u00020\u000f\u001a\n\u0010'\u001a\u00020\"*\u00020\u000f\u001a\f\u0010@\u001a\u00020\"*\u00020\u000fH\u0007\u001a\n\u0010A\u001a\u00020\"*\u00020\u000f\u001a\n\u0010b\u001a\u00020\"*\u00020\u000f\u001a\n\u0010c\u001a\u00020\"*\u00020\u000f\u001a\u000b\u0010«\u0001\u001a\u00020\"*\u00020\u000f\u001a\u0014\u0010¬\u0001\u001a\u00020\"*\u00020\u000f2\u0007\u0010\u00ad\u0001\u001a\u00020\u0006\u001a#\u0010®\u0001\u001a\u00020\"*\u00020\u000f2\u0016\u0010¯\u0001\u001a\u0011\u0012\u0005\u0012\u00030±\u0001\u0012\u0005\u0012\u00030²\u00010°\u0001\u001a\u000b\u0010¾\u0001\u001a\u00020\"*\u00020\u000f\u001a8\u0010Ç\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u001e\u0010É\u0001\u001a\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ë\u00010Ê\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a*\u0010Ì\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010Î\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001aW\u0010Ï\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062=\u0010É\u0001\u001a8\u0012\u0015\u0012\u00130P¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Ñ\u0001\u0012\u0015\u0012\u00130P¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u001aK\u0010Ó\u0001\u001a\u00020\"*\u00020\u000f28\u0010É\u0001\u001a3\b\u0001\u0012\u0016\u0012\u00140Ô\u0001¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Õ\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ô\u00010Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010±\u00010\b¢\u0006\u0003\u0010×\u0001\u001a/\u0010Ø\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0015\u0010É\u0001\u001a\u0010\u0012\u0005\u0012\u00030²\u0001\u0012\u0004\u0012\u00020\f0°\u0001\u001a0\u0010Ù\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a0\u0010Ú\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a/\u0010q\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a/\u0010v\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a0\u0010Û\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a*\u0010Ü\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a0\u0010Ý\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0016\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\f\u0018\u00010°\u0001\u001a=\u0010Þ\u0001\u001a\u00020\"*\u00020\u000f2\b\u0010ß\u0001\u001a\u00030\u0089\u00012\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001¢\u0006\u0006\bà\u0001\u0010á\u0001\u001a,\u0010â\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001H\u0007\u001aq\u0010ã\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062W\u0010É\u0001\u001aR\u0012\u0016\u0012\u00140²\u0001¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(å\u0001\u0012\u0016\u0012\u00140²\u0001¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(æ\u0001\u0012\u0015\u0012\u00130\f¢\u0006\u000e\bÐ\u0001\u0012\t\b\u0005\u0012\u0005\b\b(ç\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010ä\u0001\u001a*\u0010è\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010é\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ê\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ë\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ì\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010í\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010î\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ï\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ð\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ñ\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ò\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010Í\u0001\u001a*\u0010ó\u0001\u001a\u00020\"*\u00020\u000f2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00062\u0010\u0010É\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010P0Í\u0001\"(\u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"/\u0010\u0015\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013*\u0004\b\u0016\u0010\u0017\"/\u0010\u001b\u001a\u00020\u001a*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 *\u0004\b\u001c\u0010\u0017\"/\u0010#\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013*\u0004\b$\u0010\u0017\"/\u0010)\u001a\u00020(*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020(8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.*\u0004\b*\u0010\u0017\"/\u0010/\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b1\u00102\"\u0004\b3\u00104*\u0004\b0\u0010\u0017\"5\u00105\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b6\u00107\u001a\u0004\b5\u00102\"\u0004\b9\u00104*\u0004\b8\u0010\u0017\"/\u0010:\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b:\u00102\"\u0004\b<\u00104*\u0004\b;\u0010\u0017\"/\u0010=\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b=\u00102\"\u0004\b?\u00104*\u0004\b>\u0010\u0017\"/\u0010C\u001a\u00020B*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020B8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H*\u0004\bD\u0010\u0017\"/\u0010J\u001a\u00020I*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020I8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O*\u0004\bK\u0010\u0017\"/\u0010Q\u001a\u00020P*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020P8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V*\u0004\bR\u0010\u0017\"/\u0010X\u001a\u00020W*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020W8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]*\u0004\bY\u0010\u0017\"/\u0010^\u001a\u00020W*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020W8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]*\u0004\b_\u0010\u0017\"/\u0010e\u001a\u00020d*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020d8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bg\u0010,\"\u0004\bh\u0010.*\u0004\bf\u0010\u0017\"/\u0010i\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bk\u0010\u0011\"\u0004\bl\u0010\u0013*\u0004\bj\u0010\u0017\"(\u0010n\u001a\u00020m*\u00020\u000f2\u0006\u0010\r\u001a\u00020m8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r\"/\u0010s\u001a\u00020m*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020m8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bu\u0010p\"\u0004\bv\u0010r*\u0004\bt\u0010\u0017\"/\u0010w\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bw\u00102\"\u0004\by\u00104*\u0004\bx\u0010\u0017\"/\u0010z\u001a\u00020m*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020m8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b|\u0010p\"\u0004\b}\u0010r*\u0004\b{\u0010\u0017\"1\u0010~\u001a\u00020m*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020m8F@FX\u0086\u008e\u0002¢\u0006\u0014\u001a\u0005\b\u0080\u0001\u0010p\"\u0005\b\u0081\u0001\u0010r*\u0004\b\u007f\u0010\u0017\"7\u0010\u0083\u0001\u001a\u00030\u0082\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030\u0082\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001*\u0005\b\u0084\u0001\u0010\u0017\"<\u0010\u008a\u0001\u001a\u00030\u0089\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030\u0089\u00018G@GX\u0087\u008e\u0002¢\u0006\u001c\u0012\u0005\b\u008b\u0001\u00107\u001a\u0005\b\u008d\u0001\u0010,\"\u0005\b\u008e\u0001\u0010.*\u0005\b\u008c\u0001\u0010\u0017\"3\u0010\u008f\u0001\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b\u0091\u0001\u00102\"\u0005\b\u0092\u0001\u00104*\u0005\b\u0090\u0001\u0010\u0017\"7\u0010\u0094\u0001\u001a\u00030\u0093\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030\u0093\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001*\u0005\b\u0095\u0001\u0010\u0017\"7\u0010\u009b\u0001\u001a\u00030\u009a\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030\u009a\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001*\u0005\b\u009c\u0001\u0010\u0017\"7\u0010¢\u0001\u001a\u00030¡\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030¡\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001*\u0005\b£\u0001\u0010\u0017\"3\u0010¨\u0001\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\b¨\u0001\u00102\"\u0005\bª\u0001\u00104*\u0005\b©\u0001\u0010\u0017\"5\u0010³\u0001\u001a\u00030²\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030²\u00018F@FX\u0086\u008e\u0002¢\u0006\u0015\u001a\u0005\bµ\u0001\u0010,\"\u0005\b¶\u0001\u0010.*\u0005\b´\u0001\u0010\u0017\"7\u0010¸\u0001\u001a\u00030·\u0001*\u00020\u000f2\u0007\u0010\u0014\u001a\u00030·\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001*\u0005\b¹\u0001\u0010\u0017\"E\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030À\u00010¿\u0001*\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0005\u0012\u00030À\u00010¿\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001*\u0005\bÂ\u0001\u0010\u0017¨\u0006ô\u0001"}, d2 = {"throwSemanticsGetNotSupported", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "AccessibilityKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "name", "", "mergePolicy", "Lkotlin/Function2;", "ActionPropertyKey", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function;", "", "value", "contentDescription", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "<set-?>", "stateDescription", "getStateDescription$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getStateDescription", "setStateDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo$delegate", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "heading", "", "paneTitle", "getPaneTitle$delegate", "getPaneTitle", "setPaneTitle", "disabled", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion$delegate", "getLiveRegion", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setLiveRegion-hR3wRGc", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "focused", "getFocused$delegate", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "isContainer", "isContainer$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "isContainer$delegate", "setContainer", "isTraversalGroup", "isTraversalGroup$delegate", "setTraversalGroup", "isSensitiveData", "isSensitiveData$delegate", "setSensitiveData", "invisibleToUser", "hideFromAccessibility", "Landroidx/compose/ui/autofill/ContentType;", "contentType", "getContentType$delegate", "getContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", "setContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentType;)V", "Landroidx/compose/ui/autofill/ContentDataType;", "contentDataType", "getContentDataType$delegate", "getContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", "setContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentDataType;)V", "", "traversalIndex", "getTraversalIndex$delegate", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange$delegate", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "verticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "popup", "dialog", "Landroidx/compose/ui/semantics/Role;", "role", "getRole$delegate", "getRole", "setRole-kuIjeqM", "testTag", "getTestTag$delegate", "getTestTag", "setTestTag", "Landroidx/compose/ui/text/AnnotatedString;", "text", "getText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "textSubstitution", "getTextSubstitution$delegate", "getTextSubstitution", "setTextSubstitution", "isShowingTextSubstitution", "isShowingTextSubstitution$delegate", "setShowingTextSubstitution", "inputText", "getInputText$delegate", "getInputText", "setInputText", "editableText", "getEditableText$delegate", "getEditableText", "setEditableText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange$delegate", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction$annotations", "getImeAction$delegate", "getImeAction", "setImeAction-4L7nppU", "selected", "getSelected$delegate", "getSelected", "setSelected", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "getCollectionInfo$delegate", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo$delegate", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState$delegate", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "isEditable", "isEditable$delegate", "setEditable", "password", "error", "description", "indexForKey", "mapping", "Lkotlin/Function1;", "", "", "maxTextLength", "getMaxTextLength$delegate", "getMaxTextLength", "setMaxTextLength", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape$delegate", "getShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/graphics/Shape;)V", "selectableGroup", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions$delegate", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "getTextLayoutResult", "label", "action", "", "Landroidx/compose/ui/text/TextLayoutResult;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "onLongClick", "scrollBy", "Lkotlin/ParameterName;", "x", "y", "scrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function2;)V", "scrollToIndex", "onAutofillText", "setProgress", "showTextSubstitution", "clearTextSubstitution", "insertTextAtCursor", "onImeAction", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "performImeAction", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "relativeToOriginalText", "copyText", "cutText", "pasteText", BitableAnalytic.LinkSceneClickType.EXPAND, "collapse", "dismiss", "requestFocus", "pageUp", "pageDown", "pageLeft", "pageRight", "getScrollViewportLength", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/ui/semantics/AccessibilityAction;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function;", "", "parentValue", "childValue", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1<T> extends Lambda implements Function2<AccessibilityAction<T>, AccessibilityAction<T>, AccessibilityAction<T>> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(2);
        }

        public final AccessibilityAction<T> invoke(AccessibilityAction<T> r100, AccessibilityAction<T> r101) {
            if (r100 == null) goto L6;
            String r102 = r100.getLabel();
            if (r102 == null) goto L6;
        L7:
            if (r100 == null) goto L10;
            Function r103 = r100.getAction();
            if (r103 == null) goto L10;
        L12:
            return new AccessibilityAction(r102, r103);
        L10:
            r103 = r101.getAction();
        L6:
            r102 = r101.getLabel();
            goto L7
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
            return invoke((AccessibilityAction) r100, (AccessibilityAction) r101);
        }
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static /* synthetic */ void getImeAction$annotations(SemanticsPropertyReceiver r100) {
    }

    @Deprecated(message = "Use `isTraversalGroup` instead.", replaceWith = @ReplaceWith(expression = "isTraversalGroup", imports = {}))
    public static /* synthetic */ void isContainer$annotations(SemanticsPropertyReceiver r100) {
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isSensitiveData", "isSensitiveData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "shape", "getShape(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};
        SemanticsProperties r100 = SemanticsProperties.INSTANCE;
        r100.getStateDescription();
        r100.getProgressBarRangeInfo();
        r100.getPaneTitle();
        r100.getLiveRegion();
        r100.getFocused();
        r100.getIsContainer();
        r100.getIsTraversalGroup();
        r100.getIsSensitiveData();
        r100.getContentType();
        r100.getContentDataType();
        r100.getTraversalIndex();
        r100.getHorizontalScrollAxisRange();
        r100.getVerticalScrollAxisRange();
        r100.getRole();
        r100.getTestTag();
        r100.getTextSubstitution();
        r100.getIsShowingTextSubstitution();
        r100.getInputText();
        r100.getEditableText();
        r100.getTextSelectionRange();
        r100.getImeAction();
        r100.getSelected();
        r100.getCollectionInfo();
        r100.getCollectionItemInfo();
        r100.getToggleableState();
        r100.getIsEditable();
        r100.getMaxTextLength();
        r100.getShape();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    private static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    public static final /* synthetic */ Object access$throwSemanticsGetNotSupported() {
        return throwSemanticsGetNotSupported();
    }

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String r100) {
        return new SemanticsPropertyKey(r100, true);
    }

    private static final <T extends Function<? extends Boolean>> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String r100) {
        boolean r101 = true;
        return new SemanticsPropertyKey(r100, r101, AnonymousClass1.INSTANCE, null, 8, null);
    }

    public static final void dialog(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final void disabled(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final CollectionInfo getCollectionInfo(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getCollectionInfo().getValue(r100, $$delegatedProperties[22]);
    }

    private static Object getCollectionInfo$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getCollectionInfo();
    }

    public static final CollectionItemInfo getCollectionItemInfo(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue(r100, $$delegatedProperties[23]);
    }

    private static Object getCollectionItemInfo$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo();
    }

    public static final ContentDataType getContentDataType(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getContentDataType().getValue(r100, $$delegatedProperties[9]);
    }

    private static Object getContentDataType$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getContentDataType();
    }

    public static final String getContentDescription(SemanticsPropertyReceiver r100) {
        return (String) throwSemanticsGetNotSupported();
    }

    public static final ContentType getContentType(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getContentType().getValue(r100, $$delegatedProperties[8]);
    }

    private static Object getContentType$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getContentType();
    }

    public static final List<CustomAccessibilityAction> getCustomActions(SemanticsPropertyReceiver r100) {
        return SemanticsActions.INSTANCE.getCustomActions().getValue(r100, $$delegatedProperties[28]);
    }

    private static Object getCustomActions$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final AnnotatedString getEditableText(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getEditableText().getValue(r100, $$delegatedProperties[18]);
    }

    private static Object getEditableText$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getEditableText();
    }

    public static final boolean getFocused(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getFocused().getValue(r100, $$delegatedProperties[4]).booleanValue();
    }

    private static Object getFocused$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getFocused();
    }

    public static final ScrollAxisRange getHorizontalScrollAxisRange(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue(r100, $$delegatedProperties[11]);
    }

    private static Object getHorizontalScrollAxisRange$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    public static final int getImeAction(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getImeAction().getValue(r100, $$delegatedProperties[20]).m7170unboximpl();
    }

    private static Object getImeAction$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getImeAction();
    }

    public static final AnnotatedString getInputText(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getInputText().getValue(r100, $$delegatedProperties[17]);
    }

    private static Object getInputText$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getInputText();
    }

    public static final int getLiveRegion(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getLiveRegion().getValue(r100, $$delegatedProperties[3]).m6759unboximpl();
    }

    private static Object getLiveRegion$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getLiveRegion();
    }

    public static final int getMaxTextLength(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getMaxTextLength().getValue(r100, $$delegatedProperties[26]).intValue();
    }

    private static Object getMaxTextLength$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getMaxTextLength();
    }

    public static final String getPaneTitle(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getPaneTitle().getValue(r100, $$delegatedProperties[2]);
    }

    private static Object getPaneTitle$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getPaneTitle();
    }

    public static final ProgressBarRangeInfo getProgressBarRangeInfo(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue(r100, $$delegatedProperties[1]);
    }

    private static Object getProgressBarRangeInfo$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
    }

    public static final int getRole(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getRole().getValue(r100, $$delegatedProperties[13]).m6768unboximpl();
    }

    private static Object getRole$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getRole();
    }

    public static final boolean getSelected(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getSelected().getValue(r100, $$delegatedProperties[21]).booleanValue();
    }

    private static Object getSelected$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getSelected();
    }

    public static final Shape getShape(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getShape().getValue(r100, $$delegatedProperties[27]);
    }

    private static Object getShape$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getShape();
    }

    public static final String getStateDescription(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getStateDescription().getValue(r100, $$delegatedProperties[0]);
    }

    private static Object getStateDescription$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getStateDescription();
    }

    public static final String getTestTag(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTestTag().getValue(r100, $$delegatedProperties[14]);
    }

    private static Object getTestTag$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTestTag();
    }

    public static final AnnotatedString getText(SemanticsPropertyReceiver r100) {
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final long getTextSelectionRange(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange().getValue(r100, $$delegatedProperties[19]).m7002unboximpl();
    }

    private static Object getTextSelectionRange$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange();
    }

    public static final AnnotatedString getTextSubstitution(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTextSubstitution().getValue(r100, $$delegatedProperties[15]);
    }

    private static Object getTextSubstitution$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTextSubstitution();
    }

    public static final ToggleableState getToggleableState(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getToggleableState().getValue(r100, $$delegatedProperties[24]);
    }

    private static Object getToggleableState$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getToggleableState();
    }

    public static final float getTraversalIndex(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTraversalIndex().getValue(r100, $$delegatedProperties[10]).floatValue();
    }

    private static Object getTraversalIndex$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getTraversalIndex();
    }

    public static final ScrollAxisRange getVerticalScrollAxisRange(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue(r100, $$delegatedProperties[12]);
    }

    private static Object getVerticalScrollAxisRange$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
    }

    public static final void heading(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final void hideFromAccessibility(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getHideFromAccessibility(), Unit.INSTANCE);
    }

    @Deprecated(message = "Use `hideFromAccessibility()` instead.", replaceWith = @ReplaceWith(expression = "hideFromAccessibility()", imports = {}))
    public static final void invisibleToUser(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final boolean isContainer(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsContainer().getValue(r100, $$delegatedProperties[5]).booleanValue();
    }

    private static Object isContainer$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsContainer();
    }

    public static final boolean isEditable(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsEditable().getValue(r100, $$delegatedProperties[25]).booleanValue();
    }

    private static Object isEditable$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsEditable();
    }

    public static final boolean isSensitiveData(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsSensitiveData().getValue(r100, $$delegatedProperties[7]).booleanValue();
    }

    private static Object isSensitiveData$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsSensitiveData();
    }

    public static final boolean isShowingTextSubstitution(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().getValue(r100, $$delegatedProperties[16]).booleanValue();
    }

    private static Object isShowingTextSubstitution$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution();
    }

    public static final boolean isTraversalGroup(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue(r100, $$delegatedProperties[6]).booleanValue();
    }

    private static Object isTraversalGroup$delegate(SemanticsPropertyReceiver r100) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup();
    }

    public static final void password(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void popup(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void selectableGroup(SemanticsPropertyReceiver r100) {
        r100.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final <T> SemanticsPropertyKey<T> AccessibilityKey(String r100, Function2<? super T, ? super T, ? extends T> r101) {
        return new SemanticsPropertyKey(r100, true, r101, null, 8, null);
    }

    public static final void error(SemanticsPropertyReceiver r100, String r101) {
        r100.set(SemanticsProperties.INSTANCE.getError(), r101);
    }

    public static final void indexForKey(SemanticsPropertyReceiver r100, Function1<Object, Integer> r101) {
        r100.set(SemanticsProperties.INSTANCE.getIndexForKey(), r101);
    }

    public static final void scrollByOffset(SemanticsPropertyReceiver r100, Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> r101) {
        r100.set(SemanticsActions.INSTANCE.getScrollByOffset(), r101);
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver r100, CollectionInfo r101) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue(r100, $$delegatedProperties[22], r101);
    }

    public static final void setCollectionItemInfo(SemanticsPropertyReceiver r100, CollectionItemInfo r101) {
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue(r100, $$delegatedProperties[23], r101);
    }

    public static final void setContainer(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getIsContainer().setValue(r100, $$delegatedProperties[5], Boolean.valueOf(r101));
    }

    public static final void setContentDataType(SemanticsPropertyReceiver r100, ContentDataType r101) {
        SemanticsProperties.INSTANCE.getContentDataType().setValue(r100, $$delegatedProperties[9], r101);
    }

    public static final void setContentDescription(SemanticsPropertyReceiver r100, String r101) {
        r100.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(r101));
    }

    public static final void setContentType(SemanticsPropertyReceiver r100, ContentType r101) {
        SemanticsProperties.INSTANCE.getContentType().setValue(r100, $$delegatedProperties[8], r101);
    }

    public static final void setCustomActions(SemanticsPropertyReceiver r100, List<CustomAccessibilityAction> r101) {
        SemanticsActions.INSTANCE.getCustomActions().setValue(r100, $$delegatedProperties[28], r101);
    }

    public static final void setEditable(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue(r100, $$delegatedProperties[25], Boolean.valueOf(r101));
    }

    public static final void setEditableText(SemanticsPropertyReceiver r100, AnnotatedString r101) {
        SemanticsProperties.INSTANCE.getEditableText().setValue(r100, $$delegatedProperties[18], r101);
    }

    public static final void setFocused(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getFocused().setValue(r100, $$delegatedProperties[4], Boolean.valueOf(r101));
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver r100, ScrollAxisRange r101) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue(r100, $$delegatedProperties[11], r101);
    }

    @Deprecated(message = "Pass the ImeAction to onImeAction instead.")
    /* JADX INFO: renamed from: setImeAction-4L7nppU, reason: not valid java name */
    public static final void m6786setImeAction4L7nppU(SemanticsPropertyReceiver r100, int r101) {
        SemanticsProperties.INSTANCE.getImeAction().setValue(r100, $$delegatedProperties[20], ImeAction.m7164boximpl(r101));
    }

    public static final void setInputText(SemanticsPropertyReceiver r100, AnnotatedString r101) {
        SemanticsProperties.INSTANCE.getInputText().setValue(r100, $$delegatedProperties[17], r101);
    }

    /* JADX INFO: renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m6787setLiveRegionhR3wRGc(SemanticsPropertyReceiver r100, int r101) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue(r100, $$delegatedProperties[3], LiveRegionMode.m6753boximpl(r101));
    }

    public static final void setMaxTextLength(SemanticsPropertyReceiver r100, int r101) {
        SemanticsProperties.INSTANCE.getMaxTextLength().setValue(r100, $$delegatedProperties[26], Integer.valueOf(r101));
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver r100, String r101) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue(r100, $$delegatedProperties[2], r101);
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver r100, ProgressBarRangeInfo r101) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue(r100, $$delegatedProperties[1], r101);
    }

    /* JADX INFO: renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m6788setRolekuIjeqM(SemanticsPropertyReceiver r100, int r101) {
        SemanticsProperties.INSTANCE.getRole().setValue(r100, $$delegatedProperties[13], Role.m6762boximpl(r101));
    }

    public static final void setSelected(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getSelected().setValue(r100, $$delegatedProperties[21], Boolean.valueOf(r101));
    }

    public static final void setSensitiveData(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getIsSensitiveData().setValue(r100, $$delegatedProperties[7], Boolean.valueOf(r101));
    }

    public static final void setShape(SemanticsPropertyReceiver r100, Shape r101) {
        SemanticsProperties.INSTANCE.getShape().setValue(r100, $$delegatedProperties[27], r101);
    }

    public static final void setShowingTextSubstitution(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue(r100, $$delegatedProperties[16], Boolean.valueOf(r101));
    }

    public static final void setStateDescription(SemanticsPropertyReceiver r100, String r101) {
        SemanticsProperties.INSTANCE.getStateDescription().setValue(r100, $$delegatedProperties[0], r101);
    }

    public static final void setTestTag(SemanticsPropertyReceiver r100, String r101) {
        SemanticsProperties.INSTANCE.getTestTag().setValue(r100, $$delegatedProperties[14], r101);
    }

    public static final void setText(SemanticsPropertyReceiver r100, AnnotatedString r101) {
        r100.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(r101));
    }

    /* JADX INFO: renamed from: setTextSelectionRange-FDrldGo, reason: not valid java name */
    public static final void m6789setTextSelectionRangeFDrldGo(SemanticsPropertyReceiver r100, long r101) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue(r100, $$delegatedProperties[19], TextRange.m6986boximpl(r101));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver r100, AnnotatedString r101) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue(r100, $$delegatedProperties[15], r101);
    }

    public static final void setToggleableState(SemanticsPropertyReceiver r100, ToggleableState r101) {
        SemanticsProperties.INSTANCE.getToggleableState().setValue(r100, $$delegatedProperties[24], r101);
    }

    public static final void setTraversalGroup(SemanticsPropertyReceiver r100, boolean r101) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(r100, $$delegatedProperties[6], Boolean.valueOf(r101));
    }

    public static final void setTraversalIndex(SemanticsPropertyReceiver r100, float r101) {
        SemanticsProperties.INSTANCE.getTraversalIndex().setValue(r100, $$delegatedProperties[10], Float.valueOf(r101));
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver r100, ScrollAxisRange r101) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue(r100, $$delegatedProperties[12], r101);
    }

    public static final void clearTextSubstitution(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), new AccessibilityAction(r101, r102));
    }

    public static final void collapse(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(r101, r102));
    }

    public static final void copyText(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(r101, r102));
    }

    public static final void cutText(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(r101, r102));
    }

    public static final void dismiss(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(r101, r102));
    }

    public static final void expand(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(r101, r102));
    }

    public static final void getScrollViewportLength(SemanticsPropertyReceiver r100, String r101, final Function0<Float> r102) {
        r100.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), new AccessibilityAction(r101, new C87701(r102)));
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver r100, String r101, Function1<? super List<TextLayoutResult>, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(r101, r102));
    }

    public static final void insertTextAtCursor(SemanticsPropertyReceiver r100, String r101, Function1<? super AnnotatedString, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), new AccessibilityAction(r101, r102));
    }

    public static final void onAutofillText(SemanticsPropertyReceiver r100, String r101, Function1<? super AnnotatedString, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getOnAutofillText(), new AccessibilityAction(r101, r102));
    }

    public static final void onClick(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(r101, r102));
    }

    public static final void onLongClick(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(r101, r102));
    }

    public static final void pageDown(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getPageDown(), new AccessibilityAction(r101, r102));
    }

    public static final void pageLeft(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getPageLeft(), new AccessibilityAction(r101, r102));
    }

    public static final void pageRight(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getPageRight(), new AccessibilityAction(r101, r102));
    }

    public static final void pageUp(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getPageUp(), new AccessibilityAction(r101, r102));
    }

    public static final void pasteText(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(r101, r102));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsPropertyReceiver.onImeAction` instead.", replaceWith = @ReplaceWith(expression = "onImeAction(imeActionType = ImeAction.Default, label = label, action = action)", imports = {"androidx.compose.ui.semantics.onImeAction", "androidx.compose.ui.text.input.ImeAction"}))
    public static final void performImeAction(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(r101, r102));
    }

    public static final void requestFocus(SemanticsPropertyReceiver r100, String r101, Function0<Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(r101, r102));
    }

    public static final void scrollBy(SemanticsPropertyReceiver r100, String r101, Function2<? super Float, ? super Float, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(r101, r102));
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver r100, String r101, Function1<? super Integer, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(r101, r102));
    }

    public static final void setProgress(SemanticsPropertyReceiver r100, String r101, Function1<? super Float, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(r101, r102));
    }

    public static final void setSelection(SemanticsPropertyReceiver r100, String r101, Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(r101, r102));
    }

    public static final void setText(SemanticsPropertyReceiver r100, String r101, Function1<? super AnnotatedString, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(r101, r102));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver r100, String r101, Function1<? super AnnotatedString, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), new AccessibilityAction(r101, r102));
    }

    public static final void showTextSubstitution(SemanticsPropertyReceiver r100, String r101, Function1<? super Boolean, Boolean> r102) {
        r100.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), new AccessibilityAction(r101, r102));
    }

    /* JADX INFO: renamed from: onImeAction-9UiTYpY, reason: not valid java name */
    public static final void m6784onImeAction9UiTYpY(SemanticsPropertyReceiver r100, int r101, String r102, Function0<Boolean> r103) {
        r100.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.m7164boximpl(r101));
        r100.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(r102, r103));
    }

    public static /* synthetic */ void clearTextSubstitution$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        clearTextSubstitution(r100, r101, r102);
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        collapse(r100, r101, r102);
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        copyText(r100, r101, r102);
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cutText(r100, r101, r102);
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        dismiss(r100, r101, r102);
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        expand(r100, r101, r102);
    }

    public static /* synthetic */ void getScrollViewportLength$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        getScrollViewportLength(r100, r101, r102);
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        getTextLayoutResult(r100, r101, r102);
    }

    public static /* synthetic */ void insertTextAtCursor$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        insertTextAtCursor(r100, r101, r102);
    }

    public static /* synthetic */ void onAutofillText$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        onAutofillText(r100, r101, r102);
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        onClick(r100, r101, r102);
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        onLongClick(r100, r101, r102);
    }

    public static /* synthetic */ void pageDown$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        pageDown(r100, r101, r102);
    }

    public static /* synthetic */ void pageLeft$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        pageLeft(r100, r101, r102);
    }

    public static /* synthetic */ void pageRight$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        pageRight(r100, r101, r102);
    }

    public static /* synthetic */ void pageUp$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        pageUp(r100, r101, r102);
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        pasteText(r100, r101, r102);
    }

    public static /* synthetic */ void performImeAction$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        performImeAction(r100, r101, r102);
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        requestFocus(r100, r101, r102);
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver r100, String r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        scrollBy(r100, r101, r102);
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        scrollToIndex(r100, r101, r102);
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        setProgress(r100, r101, r102);
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver r100, String r101, Function3 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        setSelection(r100, r101, r102);
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        setText(r100, r101, r102);
    }

    public static /* synthetic */ void setTextSubstitution$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        setTextSubstitution(r100, r101, r102);
    }

    public static /* synthetic */ void showTextSubstitution$default(SemanticsPropertyReceiver r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        showTextSubstitution(r100, r101, r102);
    }

    /* JADX INFO: renamed from: onImeAction-9UiTYpY$default, reason: not valid java name */
    public static /* synthetic */ void m6785onImeAction9UiTYpY$default(SemanticsPropertyReceiver r100, int r101, String r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        m6784onImeAction9UiTYpY(r100, r101, r102, r103);
    }
}
