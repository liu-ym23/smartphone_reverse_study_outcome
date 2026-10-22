package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.keva.ext.fast.KevaMultiProcessFastConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010$\n\u0002\b\n\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\"\u0010 J\u0015\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u0002022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u0004\u0018\u0001022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u0002092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b=\u0010>J-\u0010?\u001a\u0002H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bD\u0010EJ$\u0010?\u001a\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bD\u0010FJ/\u0010G\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bH\u0010EJ&\u0010G\u001a\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bH\u0010FJ-\u0010I\u001a\u0002H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bL\u0010MJ$\u0010I\u001a\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bL\u0010NJ/\u0010O\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bP\u0010MJ&\u0010O\u001a\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bP\u0010NJ\u0015\u0010Q\u001a\u00020R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u0004\u0018\u00010R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bV\u0010TJ\u0015\u0010W\u001a\u00020X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u0004\u0018\u00010X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\\\u0010ZJ\u001f\u0010]\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b_\u0010`J!\u0010a\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bb\u0010`J\u0015\u0010c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bg\u0010eJ\u001b\u0010h\u001a\b\u0012\u0004\u0012\u0002020i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bj\u0010kJ\u001d\u0010l\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bm\u0010kJ\u001b\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001e0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bo\u0010kJ\u001d\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bq\u0010kJ\u001f\u0010r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bs\u0010kJ!\u0010t\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bu\u0010kJ\u001b\u0010v\u001a\b\u0012\u0004\u0012\u00020\n0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bw\u0010kJ\u001d\u0010x\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\by\u0010kJ3\u0010z\u001a\b\u0012\u0004\u0012\u0002H@0i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b{\u0010|J*\u0010z\u001a\b\u0012\u0004\u0012\u0002H@0i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\b{\u0010kJ5\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b~\u0010|J,\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\b~\u0010kJ\u0018\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0084\u0001\u0010\u0082\u0001J\u0019\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008a\u0001\u0010\u0088\u0001J\u001e\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J \u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008f\u0001\u0010\u008d\u0001J\u0019\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001J\u0019\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u009b\u0001\u0010\u0099\u0001J\u0019\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J\u0019\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001b\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b§\u0001\u0010¥\u0001J\u001e\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\n0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b©\u0001\u0010ª\u0001J \u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¬\u0001\u0010ª\u0001J6\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u0002H@0^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b®\u0001\u0010¯\u0001J-\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u0002H@0^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b®\u0001\u0010°\u0001J8\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b²\u0001\u0010¯\u0001J/\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b²\u0001\u0010°\u0001J7\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\bµ\u0001\u0010¶\u0001J.\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\bµ\u0001\u0010·\u0001J9\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b¹\u0001\u0010¶\u0001J0\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b¹\u0001\u0010·\u0001J\u001c\u0010º\u0001\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b»\u0001\u0010¼\u0001J \u0010½\u0001\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¾\u0001\u0010¼\u0001J\u0010\u0010¿\u0001\u001a\u000202¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0010¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u0017\u0010Å\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0005\bÆ\u0001\u0010\u0012J\u001a\u0010Ç\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0005\bÈ\u0001\u0010\u0012J\u001d\u0010É\u0001\u001a\u00020\u00102\u000b\u0010Ê\u0001\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0010\u0010Í\u0001\u001a\u000202¢\u0006\u0006\bÎ\u0001\u0010Á\u0001J\u0010\u0010Ï\u0001\u001a\u00020\n¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001f\u0010Ò\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ó\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u001e\u0010Ö\u0001\u001a\u00020\u00102\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u0013\u0010Ù\u0001\u001a\u000202HÖ\u0001¢\u0006\u0006\bÚ\u0001\u0010Á\u0001J\u0013\u0010Û\u0001\u001a\u00020\nHÖ\u0001¢\u0006\u0006\bÜ\u0001\u0010Ñ\u0001R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006Ý\u0001"}, d2 = {"Landroidx/savedstate/SavedStateReader;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", KevaMultiProcessFastConstant.CALL_METHOD, "Landroid/os/IBinder;", "key", "", "getBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;", "getBinderOrNull", "getBinderOrNull-impl", "getBoolean", "", "getBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Z", "getBooleanOrNull", "getBooleanOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "getChar", "", "getChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;)C", "getCharOrNull", "getCharOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Character;", "getCharSequence", "", "getCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/CharSequence;", "getCharSequenceOrNull", "getCharSequenceOrNull-impl", "getDouble", "", "getDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;)D", "getDoubleOrNull", "getDoubleOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "getFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;)F", "getFloatOrNull", "getFloatOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "getInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;)I", "getIntOrNull", "getIntOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "getLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;)J", "getLongOrNull", "getLongOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "parcelableClass", "Lkotlin/reflect/KClass;", "getParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull", "getParcelableOrNull-impl", "getJavaSerializable", "Ljava/io/Serializable;", "serializableClass", "getJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getJavaSerializableOrNull", "getJavaSerializableOrNull-impl", "getSize", "Landroid/util/Size;", "getSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/Size;", "getSizeOrNull", "getSizeOrNull-impl", "getSizeF", "Landroid/util/SizeF;", "getSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SizeF;", "getSizeFOrNull", "getSizeFOrNull-impl", "getSavedStateArray", "", "getSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Bundle;", "getSavedStateArrayOrNull", "getSavedStateArrayOrNull-impl", "getString", "getString-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "getStringOrNull-impl", "getIntList", "", "getIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getIntListOrNull", "getIntListOrNull-impl", "getCharSequenceList", "getCharSequenceList-impl", "getCharSequenceListOrNull", "getCharSequenceListOrNull-impl", "getSavedStateList", "getSavedStateList-impl", "getSavedStateListOrNull", "getSavedStateListOrNull-impl", "getStringList", "getStringList-impl", "getStringListOrNull", "getStringListOrNull-impl", "getParcelableList", "getParcelableList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/util/List;", "getParcelableListOrNull", "getParcelableListOrNull-impl", "getBooleanArray", "", "getBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Z", "getBooleanArrayOrNull", "getBooleanArrayOrNull-impl", "getCharArray", "", "getCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[C", "getCharArrayOrNull", "getCharArrayOrNull-impl", "getCharSequenceArray", "getCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArrayOrNull", "getCharSequenceArrayOrNull-impl", "getDoubleArray", "", "getDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[D", "getDoubleArrayOrNull", "getDoubleArrayOrNull-impl", "getFloatArray", "", "getFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[F", "getFloatArrayOrNull", "getFloatArrayOrNull-impl", "getIntArray", "", "getIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[I", "getIntArrayOrNull", "getIntArrayOrNull-impl", "getLongArray", "", "getLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[J", "getLongArrayOrNull", "getLongArrayOrNull-impl", "getStringArray", "getStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "getStringArrayOrNull", "getStringArrayOrNull-impl", "getParcelableArray", "getParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)[Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "getParcelableArrayOrNull", "getParcelableArrayOrNull-impl", "getSparseParcelableArray", "Landroid/util/SparseArray;", "getSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/util/SparseArray;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SparseArray;", "getSparseParcelableArrayOrNull", "getSparseParcelableArrayOrNull-impl", "getSavedState", "getSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "getSavedStateOrNull", "getSavedStateOrNull-impl", "size", "size-impl", "(Landroid/os/Bundle;)I", "isEmpty", "isEmpty-impl", "(Landroid/os/Bundle;)Z", "isNull", "isNull-impl", "contains", "contains-impl", "contentDeepEquals", "other", "contentDeepEquals-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepHashCode", "contentDeepHashCode-impl", "contentDeepToString", "contentDeepToString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "toMap", "", "toMap-impl", "(Landroid/os/Bundle;)Ljava/util/Map;", "equals", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SavedStateReader {
    private final Bundle source;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateReader m7830boximpl(Bundle r100) {
        return new SavedStateReader(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m7831constructorimpl(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7836equalsimpl(Bundle r100, Object r101) {
        if ((r101 instanceof SavedStateReader) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((SavedStateReader) r101).m7914unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7837equalsimpl0(Bundle r100, Bundle r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7908hashCodeimpl(Bundle r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7913toStringimpl(Bundle r100) {
        return "SavedStateReader(source=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m7836equalsimpl(this.source, r100);
    }

    public int hashCode() {
        return m7908hashCodeimpl(this.source);
    }

    public String toString() {
        return m7913toStringimpl(this.source);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Bundle m7914unboximpl() {
        return this.source;
    }

    private /* synthetic */ SavedStateReader(Bundle r100) {
        this.source = r100;
    }

    /* JADX INFO: renamed from: contentDeepHashCode-impl, reason: not valid java name */
    public static final int m7834contentDeepHashCodeimpl(Bundle r100) {
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepHashCode(r100);
    }

    /* JADX INFO: renamed from: contentDeepToString-impl, reason: not valid java name */
    public static final String m7835contentDeepToStringimpl(Bundle r100) {
        StringBuilder r101 = new StringBuilder((RangesKt.coerceAtMost(r100.size(), 429496729) * 5) + 2);
        SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepToString(r100, r101, new ArrayList());
        return r101.toString();
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m7909isEmptyimpl(Bundle r100) {
        return r100.isEmpty();
    }

    /* JADX INFO: renamed from: size-impl, reason: not valid java name */
    public static final int m7911sizeimpl(Bundle r100) {
        return r100.size();
    }

    /* JADX INFO: renamed from: toMap-impl, reason: not valid java name */
    public static final Map<String, Object> m7912toMapimpl(Bundle r100) {
        Map r101 = MapsKt.createMapBuilder(r100.size());
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r101.put(r103, r100.get(r103));
        goto L4
    L7:
        return MapsKt.build(r101);
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m7832containsimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.containsKey(r101);
    }

    /* JADX INFO: renamed from: contentDeepEquals-impl, reason: not valid java name */
    public static final boolean m7833contentDeepEqualsimpl(Bundle r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepEquals(r100, r101);
    }

    /* JADX INFO: renamed from: getBinder-impl, reason: not valid java name */
    public static final IBinder m7838getBinderimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        IBinder r102 = r100.getBinder(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getBinderOrNull-impl, reason: not valid java name */
    public static final IBinder m7839getBinderOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getBinder(r101);
    }

    /* JADX INFO: renamed from: getBoolean-impl, reason: not valid java name */
    public static final boolean m7840getBooleanimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        boolean r102 = r100.getBoolean(r101, false);
        if (r102 == false) goto L5;
    L9:
        return r102;
    L5:
        if (r100.getBoolean(r101, true) != true) goto L9;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getBooleanArray-impl, reason: not valid java name */
    public static final boolean[] m7841getBooleanArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        boolean[] r102 = r100.getBooleanArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getBooleanArrayOrNull-impl, reason: not valid java name */
    public static final boolean[] m7842getBooleanArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getBooleanArray(r101);
    }

    /* JADX INFO: renamed from: getBooleanOrNull-impl, reason: not valid java name */
    public static final Boolean m7843getBooleanOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        boolean r102 = false;
        boolean r103 = r100.getBoolean(r101, false);
        if (r103 == true) goto L11;
        if (r100.getBoolean(r101, true) != true) goto L7;
        r102 = true;
    L7:
        if (r102 != true) goto L11;
        return null;
    L11:
        return Boolean.valueOf(r103);
    }

    /* JADX INFO: renamed from: getChar-impl, reason: not valid java name */
    public static final char m7844getCharimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        char r102 = r100.getChar(r101, 0);
        if (r102 == 0) goto L5;
    L9:
        return r102;
    L5:
        if (r100.getChar(r101, CharCompanionObject.MAX_VALUE) != 65535) goto L9;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getCharArray-impl, reason: not valid java name */
    public static final char[] m7845getCharArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        char[] r102 = r100.getCharArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getCharArrayOrNull-impl, reason: not valid java name */
    public static final char[] m7846getCharArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getCharArray(r101);
    }

    /* JADX INFO: renamed from: getCharOrNull-impl, reason: not valid java name */
    public static final Character m7847getCharOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        char r102 = r100.getChar(r101, 0);
        if (r102 != 0) goto L9;
        if (r100.getChar(r101, CharCompanionObject.MAX_VALUE) != 65535) goto L9;
        return null;
    L9:
        return Character.valueOf(r102);
    }

    /* JADX INFO: renamed from: getCharSequence-impl, reason: not valid java name */
    public static final CharSequence m7848getCharSequenceimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        CharSequence r102 = r100.getCharSequence(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getCharSequenceArray-impl, reason: not valid java name */
    public static final CharSequence[] m7849getCharSequenceArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        CharSequence[] r102 = r100.getCharSequenceArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getCharSequenceArrayOrNull-impl, reason: not valid java name */
    public static final CharSequence[] m7850getCharSequenceArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getCharSequenceArray(r101);
    }

    /* JADX INFO: renamed from: getCharSequenceList-impl, reason: not valid java name */
    public static final List<CharSequence> m7851getCharSequenceListimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        ArrayList<CharSequence> r102 = r100.getCharSequenceArrayList(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getCharSequenceListOrNull-impl, reason: not valid java name */
    public static final List<CharSequence> m7852getCharSequenceListOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getCharSequenceArrayList(r101);
    }

    /* JADX INFO: renamed from: getCharSequenceOrNull-impl, reason: not valid java name */
    public static final CharSequence m7853getCharSequenceOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getCharSequence(r101);
    }

    /* JADX INFO: renamed from: getDouble-impl, reason: not valid java name */
    public static final double m7854getDoubleimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        double r102 = r100.getDouble(r101, Double.MIN_VALUE);
        boolean r103 = true;
        if (r102 != Double.MIN_VALUE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L15:
        return r102;
    L8:
        if (r100.getDouble(r101, Double.MAX_VALUE) == Double.MAX_VALUE) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L15;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    L5:
        r104 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getDoubleArray-impl, reason: not valid java name */
    public static final double[] m7855getDoubleArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        double[] r102 = r100.getDoubleArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getDoubleArrayOrNull-impl, reason: not valid java name */
    public static final double[] m7856getDoubleArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getDoubleArray(r101);
    }

    /* JADX INFO: renamed from: getDoubleOrNull-impl, reason: not valid java name */
    public static final Double m7857getDoubleOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        double r102 = r100.getDouble(r101, Double.MIN_VALUE);
        boolean r103 = true;
        if (r102 != Double.MIN_VALUE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L15;
        if (r100.getDouble(r101, Double.MAX_VALUE) == Double.MAX_VALUE) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L15;
        return null;
    L15:
        return Double.valueOf(r102);
    L5:
        r104 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getFloat-impl, reason: not valid java name */
    public static final float m7858getFloatimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        float r102 = r100.getFloat(r101, Float.MIN_VALUE);
        boolean r103 = true;
        if (r102 != Float.MIN_VALUE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L15:
        return r102;
    L8:
        if (r100.getFloat(r101, Float.MAX_VALUE) == Float.MAX_VALUE) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L15;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    L5:
        r104 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getFloatArray-impl, reason: not valid java name */
    public static final float[] m7859getFloatArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        float[] r102 = r100.getFloatArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getFloatArrayOrNull-impl, reason: not valid java name */
    public static final float[] m7860getFloatArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getFloatArray(r101);
    }

    /* JADX INFO: renamed from: getFloatOrNull-impl, reason: not valid java name */
    public static final Float m7861getFloatOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        float r102 = r100.getFloat(r101, Float.MIN_VALUE);
        boolean r103 = true;
        if (r102 != Float.MIN_VALUE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L15;
        if (r100.getFloat(r101, Float.MAX_VALUE) == Float.MAX_VALUE) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L15;
        return null;
    L15:
        return Float.valueOf(r102);
    L5:
        r104 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getInt-impl, reason: not valid java name */
    public static final int m7862getIntimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = r100.getInt(r101, Integer.MIN_VALUE);
        if (r102 == Integer.MIN_VALUE) goto L5;
    L9:
        return r102;
    L5:
        if (r100.getInt(r101, Integer.MAX_VALUE) != Integer.MAX_VALUE) goto L9;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getIntArray-impl, reason: not valid java name */
    public static final int[] m7863getIntArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        int[] r102 = r100.getIntArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getIntArrayOrNull-impl, reason: not valid java name */
    public static final int[] m7864getIntArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getIntArray(r101);
    }

    /* JADX INFO: renamed from: getIntList-impl, reason: not valid java name */
    public static final List<Integer> m7865getIntListimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        ArrayList<Integer> r102 = r100.getIntegerArrayList(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getIntListOrNull-impl, reason: not valid java name */
    public static final List<Integer> m7866getIntListOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getIntegerArrayList(r101);
    }

    /* JADX INFO: renamed from: getIntOrNull-impl, reason: not valid java name */
    public static final Integer m7867getIntOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = r100.getInt(r101, Integer.MIN_VALUE);
        if (r102 != Integer.MIN_VALUE) goto L9;
        if (r100.getInt(r101, Integer.MAX_VALUE) != Integer.MAX_VALUE) goto L9;
        return null;
    L9:
        return Integer.valueOf(r102);
    }

    /* JADX INFO: renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m7868getJavaSerializableimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m7869getJavaSerializableimpl(r100, r101, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    /* JADX INFO: renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m7870getJavaSerializableOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m7871getJavaSerializableOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    /* JADX INFO: renamed from: getLong-impl, reason: not valid java name */
    public static final long m7872getLongimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        long r102 = r100.getLong(r101, Long.MIN_VALUE);
        if (r102 == Long.MIN_VALUE) goto L5;
    L9:
        return r102;
    L5:
        if (r100.getLong(r101, Long.MAX_VALUE) != Long.MAX_VALUE) goto L9;
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getLongArray-impl, reason: not valid java name */
    public static final long[] m7873getLongArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        long[] r102 = r100.getLongArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getLongArrayOrNull-impl, reason: not valid java name */
    public static final long[] m7874getLongArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getLongArray(r101);
    }

    /* JADX INFO: renamed from: getLongOrNull-impl, reason: not valid java name */
    public static final Long m7875getLongOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        long r102 = r100.getLong(r101, Long.MIN_VALUE);
        if (r102 != Long.MIN_VALUE) goto L9;
        if (r100.getLong(r101, Long.MAX_VALUE) != Long.MAX_VALUE) goto L9;
        return null;
    L9:
        return Long.valueOf(r102);
    }

    /* JADX INFO: renamed from: getParcelable-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m7876getParcelableimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m7877getParcelableimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m7878getParcelableArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) m7879getParcelableArrayimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m7880getParcelableArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) m7881getParcelableArrayOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getParcelableList-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m7882getParcelableListimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m7883getParcelableListimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m7884getParcelableListOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m7885getParcelableListOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m7886getParcelableOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m7887getParcelableOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getSavedState-impl, reason: not valid java name */
    public static final Bundle m7888getSavedStateimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Bundle r102 = r100.getBundle(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getSavedStateArray-impl, reason: not valid java name */
    public static final Bundle[] m7889getSavedStateArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return (Bundle[]) m7879getParcelableArrayimpl(r100, r101, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateArrayOrNull-impl, reason: not valid java name */
    public static final Bundle[] m7890getSavedStateArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return (Bundle[]) m7881getParcelableArrayOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateList-impl, reason: not valid java name */
    public static final List<Bundle> m7891getSavedStateListimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return m7883getParcelableListimpl(r100, r101, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateListOrNull-impl, reason: not valid java name */
    public static final List<Bundle> m7892getSavedStateListOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return m7885getParcelableListOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateOrNull-impl, reason: not valid java name */
    public static final Bundle m7893getSavedStateOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getBundle(r101);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final Size m7894getSizeimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Size r102 = r100.getSize(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getSizeF-impl, reason: not valid java name */
    public static final SizeF m7895getSizeFimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        SizeF r102 = r100.getSizeF(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getSizeFOrNull-impl, reason: not valid java name */
    public static final SizeF m7896getSizeFOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getSizeF(r101);
    }

    /* JADX INFO: renamed from: getSizeOrNull-impl, reason: not valid java name */
    public static final Size m7897getSizeOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getSize(r101);
    }

    /* JADX INFO: renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m7898getSparseParcelableArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m7899getSparseParcelableArrayimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m7900getSparseParcelableArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m7901getSparseParcelableArrayOrNullimpl(r100, r101, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* JADX INFO: renamed from: getString-impl, reason: not valid java name */
    public static final String m7902getStringimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = r100.getString(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getStringArray-impl, reason: not valid java name */
    public static final String[] m7903getStringArrayimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        String[] r102 = r100.getStringArray(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getStringArrayOrNull-impl, reason: not valid java name */
    public static final String[] m7904getStringArrayOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getStringArray(r101);
    }

    /* JADX INFO: renamed from: getStringList-impl, reason: not valid java name */
    public static final List<String> m7905getStringListimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        ArrayList<String> r102 = r100.getStringArrayList(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getStringListOrNull-impl, reason: not valid java name */
    public static final List<String> m7906getStringListOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getStringArrayList(r101);
    }

    /* JADX INFO: renamed from: getStringOrNull-impl, reason: not valid java name */
    public static final String m7907getStringOrNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getString(r101);
    }

    /* JADX INFO: renamed from: isNull-impl, reason: not valid java name */
    public static final boolean m7910isNullimpl(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (m7832containsimpl(r100, r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.get(r101) != null) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7869getJavaSerializableimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "serializableClass");
        T r103 = (T) BundleCompat.getSerializable(r100, r101, JvmClassMappingKt.getJavaClass(r102));
        if (r103 == null) goto L5;
        return r103;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m7871getJavaSerializableOrNullimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "serializableClass");
        return (T) BundleCompat.getSerializable(r100, r101, JvmClassMappingKt.getJavaClass(r102));
    }

    /* JADX INFO: renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7877getParcelableimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        T r103 = (T) BundleCompat.getParcelable(r100, r101, JvmClassMappingKt.getJavaClass(r102));
        if (r103 == null) goto L5;
        return r103;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7879getParcelableArrayimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        T[] r103 = (T[]) m7881getParcelableArrayOrNullimpl(r100, r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m7881getParcelableArrayOrNullimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        T[] r103 = (T[]) BundleCompat.getParcelableArray(r100, r101, JvmClassMappingKt.getJavaClass(r102));
        if ((r103 instanceof Parcelable[]) == true) goto L7;
        return null;
    L7:
        return r103;
    }

    /* JADX INFO: renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7883getParcelableListimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        ArrayList r103 = BundleCompat.getParcelableArrayList(r100, r101, JvmClassMappingKt.getJavaClass(r102));
        if (r103 == null) goto L5;
        return r103;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m7885getParcelableListOrNullimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        return BundleCompat.getParcelableArrayList(r100, r101, JvmClassMappingKt.getJavaClass(r102));
    }

    /* JADX INFO: renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m7887getParcelableOrNullimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        return (T) BundleCompat.getParcelable(r100, r101, JvmClassMappingKt.getJavaClass(r102));
    }

    /* JADX INFO: renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7899getSparseParcelableArrayimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        SparseArray<T> r103 = m7901getSparseParcelableArrayOrNullimpl(r100, r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        SavedStateReaderKt.keyOrValueNotFoundError(r101);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m7901getSparseParcelableArrayOrNullimpl(Bundle r100, String r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(r100, r101, JvmClassMappingKt.getJavaClass(r102));
    }
}
