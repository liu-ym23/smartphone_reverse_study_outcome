package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.C4851b;
import kotlin.random.Random;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000ø\u0001\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0018\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a*\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0010\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0014\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010\"\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010$\u001a\u0004\u0018\u00010\u000f*\u00020\u000e2\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010&\u001a\u0004\u0018\u00010\u001e*\u00020\u001d2\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b&\u0010'\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0003*\u00020(2\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b+\u0010,\u001a\u0019\u0010-\u001a\u00020\u000f*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b/\u00100\u001a\u0019\u00101\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b1\u00102\u001a\u0019\u00103\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013¢\u0006\u0004\b3\u00104\u001a\u0019\u00105\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0017¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b7\u0010\u001b\u001a\u0011\u00108\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b8\u00109\u001a'\u0010:\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b:\u0010,\u001a\u0019\u0010;\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b;\u00102\u001a!\u0010<\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b<\u0010\u001b\u001a)\u0010?\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010>\u001a\u00020=H\u0007¢\u0006\u0004\b?\u0010@\u001a\u001f\u0010A\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bA\u0010\u001b\u001a\u0011\u0010B\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\bB\u0010C\u001a!\u0010D\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bD\u0010\u001b\u001a-\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010E\u001a\u00020\u000f¢\u0006\u0004\bG\u0010H\u001a+\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\b\b\u0000\u0010\u0000*\u00020I*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\bJ\u0010K\u001a?\u0010O\u001a\u00028\u0000\"\u0010\b\u0000\u0010M*\n\u0012\u0006\b\u0000\u0012\u00028\u00010L\"\b\b\u0001\u0010\u0000*\u00020I*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u0010N\u001a\u00028\u0000¢\u0006\u0004\bO\u0010P\u001a\u0019\u0010S\u001a\u00020\u0006*\u00020\u00062\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010T\u001a-\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010E\u001a\u00020\u000f¢\u0006\u0004\bU\u0010H\u001aC\u0010Y\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010X\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Vj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`W¢\u0006\u0004\bY\u0010Z\u001aA\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010X\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Vj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`W¢\u0006\u0004\b[\u0010\\\u001a\u0019\u0010]\u001a\u00020\u0012*\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0001¢\u0006\u0004\b]\u0010^\u001a9\u0010_\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010M*\n\u0012\u0006\b\u0000\u0012\u00028\u00000L*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010N\u001a\u00028\u0001¢\u0006\u0004\b_\u0010P\u001a+\u0010`\u001a\u00028\u0000\"\u0010\b\u0000\u0010M*\n\u0012\u0006\b\u0000\u0012\u00020\u000f0L*\u00020\u000e2\u0006\u0010N\u001a\u00028\u0000¢\u0006\u0004\b`\u0010a\u001a%\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bb\u0010K\u001a\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00070F*\u00020\u0006¢\u0006\u0004\bc\u0010d\u001a\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000b0F*\u00020\n¢\u0006\u0004\be\u0010f\u001a\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000f0F*\u00020\u000e¢\u0006\u0004\bg\u0010h\u001a\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00130F*\u00020\u0012¢\u0006\u0004\bi\u0010j\u001a\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001e0F*\u00020\u001d¢\u0006\u0004\bk\u0010l\u001a\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020n0F*\u00020m¢\u0006\u0004\bo\u0010p\u001a\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030F*\u00020(¢\u0006\u0004\bq\u0010r\u001a\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00170F*\u00020\u0016¢\u0006\u0004\bs\u0010t\u001a%\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000u\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bv\u0010K\u001a\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00070u*\u00020\u0006¢\u0006\u0004\bw\u0010d\u001a\u0017\u0010x\u001a\b\u0012\u0004\u0012\u00020\u000b0u*\u00020\n¢\u0006\u0004\bx\u0010f\u001a\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000f0u*\u00020\u000e¢\u0006\u0004\by\u0010h\u001a\u0017\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00130u*\u00020\u0012¢\u0006\u0004\bz\u0010j\u001a\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020\u001e0u*\u00020\u001d¢\u0006\u0004\b{\u0010l\u001a\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020n0u*\u00020m¢\u0006\u0004\b|\u0010p\u001a\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00030u*\u00020(¢\u0006\u0004\b}\u0010r\u001a\u0017\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170u*\u00020\u0016¢\u0006\u0004\b~\u0010t\u001a(\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u007f\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u001a\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u007f*\u00020\u000e¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a0\u0010\u0086\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u0085\u00010\u0084\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0000\u0010K\u001a)\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0088\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u0081\u0001\u001aO\u0010\u008c\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008b\u00010F\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000f\u0010\u008a\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001aN\u0010\u008e\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008b\u00010F\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0084\u0001H\u0086\u0004¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0092\u0001\u0010\u009c\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u000f\b\u0001\u0010\u0092\u0001*\b0\u0090\u0001j\u0003`\u0091\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0007\u0010\u0093\u0001\u001a\u00028\u00012\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0096\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0094\u00012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u000f2\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0094\u00012\u0019\b\u0002\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u009a\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0084\u0001\u0010\u009e\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010\u0092\u0001*\b0\u0090\u0001j\u0003`\u0091\u0001*\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00028\u00002\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0096\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0094\u00012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u000f2\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0094\u00012\u0019\b\u0002\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u009a\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001\u001ay\u0010¡\u0001\u001a\u00030 \u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0096\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0094\u00012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u000f2\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0094\u00012\u0019\b\u0002\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u009a\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001ak\u0010£\u0001\u001a\u00030 \u0001*\u00020\u00062\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0096\u0001\u001a\u00030\u0094\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0094\u00012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u000f2\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0094\u00012\u0019\b\u0002\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u009a\u0001¢\u0006\u0006\b£\u0001\u0010¤\u0001\u001a)\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0084\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b¥\u0001\u0010\u0087\u0001\u001a)\u0010§\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¦\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001a\u0013\u0010©\u0001\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0005\b©\u0001\u00109\"%\u0010R\u001a\u00020Q\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001\"&\u0010®\u0001\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0018\u0010®\u0001\u001a\u00020\u000f*\u00020\u000e8F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0018\u0010®\u0001\u001a\u00020\u000f*\u00020\u00128F¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001\"\u0018\u0010®\u0001\u001a\u00020\u000f*\u00020\u001d8F¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001\"\u0018\u0010®\u0001\u001a\u00020\u000f*\u00020\u00168F¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001¨\u0006·\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "R", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "", "", "N", "([BB)Z", "", "", ExifInterface.LATITUDE_SOUTH, "([SS)Z", "", "", "P", "([II)Z", "", "", "Q", "([JJ)Z", "", "", "O", "([CC)Z", "X", "([Ljava/lang/Object;)Ljava/lang/Object;", "Z", "", "", "Y", "([F)Ljava/lang/Float;", "index", "j0", "([Ljava/lang/Object;I)Ljava/lang/Object;", "i0", "([II)Ljava/lang/Integer;", "h0", "([FI)Ljava/lang/Float;", "", "g0", "([ZI)Ljava/lang/Boolean;", "o0", "([Ljava/lang/Object;Ljava/lang/Object;)I", "k0", "([BB)I", "p0", "([SS)I", "m0", "([II)I", "n0", "([JJ)I", "l0", "([CC)I", "y0", "x0", "([J)J", "A0", "z0", "B0", "Lkotlin/random/Random;", "random", "C0", "([Ljava/lang/Object;Lkotlin/random/Random;)Ljava/lang/Object;", "E0", "D0", "([C)C", "F0", "n", "", "U", "([Ljava/lang/Object;I)Ljava/util/List;", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "([Ljava/lang/Object;)Ljava/util/List;", "", "C", "destination", ExifInterface.LONGITUDE_WEST, "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "Lv9/i;", "indices", "G0", "([BLv9/i;)[B", "K0", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "H0", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "I0", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "W0", "([Ljava/lang/Long;)[J", "M0", "L0", "([ILjava/util/Collection;)Ljava/util/Collection;", "T0", "N0", "([B)Ljava/util/List;", "U0", "([S)Ljava/util/List;", "R0", "([I)Ljava/util/List;", "S0", "([J)Ljava/util/List;", "Q0", "([F)Ljava/util/List;", "", "", "P0", "([D)Ljava/util/List;", "V0", "([Z)Ljava/util/List;", "O0", "([C)Ljava/util/List;", "", "d1", "X0", "e1", "b1", "c1", SdCardDbCreator.FIELD_LASTLOC_ID, "Z0", "f1", "Y0", "", "i1", "([Ljava/lang/Object;)Ljava/util/Set;", "h1", "([I)Ljava/util/Set;", "", "LZ8/J;", "j1", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "", "g1", "other", "Lkotlin/Pair;", "m1", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "l1", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "Lkotlin/Function1;", "transform", "r0", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/Appendable;", "q0", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/Appendable;", "", "u0", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/String;", "t0", "([BLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/String;", "L", "LKa/j;", "M", "([Ljava/lang/Object;)LKa/j;", "J0", "a0", "([Ljava/lang/Object;)Lv9/i;", "f0", "([Ljava/lang/Object;)I", "lastIndex", "d0", "([I)I", "e0", "([J)I", "c0", "([F)I", "b0", "([C)I", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes4.dex */
public class r extends C1168p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Z8/r$a", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Iterable<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f7702a;

        public a(Object[] objArr) {
            this.f7702a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return C4851b.a(this.f7702a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Z8/r$b", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Ka.j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f7703a;

        public b(Object[] objArr) {
            this.f7703a = objArr;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            return C4851b.a(this.f7703a);
        }
    }

    public static <T> int A0(T[] tArr, T t10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (t10 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i11 = length2 - 1;
                    if (kotlin.jvm.internal.p.d(t10, tArr[length2])) {
                        return length2;
                    }
                    if (i11 < 0) {
                        break;
                    }
                    length2 = i11;
                }
            }
        }
        return -1;
    }

    public static <T> T B0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static <T> T C0(T[] tArr, Random random) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(random, "random");
        if (tArr.length != 0) {
            return tArr[random.g(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static char D0(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T E0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T F0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static byte[] G0(byte[] bArr, C5680i indices) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        kotlin.jvm.internal.p.i(indices, "indices");
        return indices.isEmpty() ? new byte[0] : C1168p.o(bArr, indices.l().intValue(), indices.k().intValue() + 1);
    }

    public static final <T> T[] H0(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.p.h(tArr2, "copyOf(...)");
        C1168p.I(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> I0(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        return C1168p.d(H0(tArr, comparator));
    }

    public static long J0(long[] jArr) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        return j10;
    }

    public static final <T> List<T> K0(T[] tArr, int i10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return C1173v.m();
        }
        int length = tArr.length;
        if (i10 >= length) {
            return T0(tArr);
        }
        if (i10 == 1) {
            return C1172u.e(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    public static <T> Iterable<T> L(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return tArr.length == 0 ? C1173v.m() : new a(tArr);
    }

    public static final <C extends Collection<? super Integer>> C L0(int[] iArr, C destination) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        for (int i10 : iArr) {
            destination.add(Integer.valueOf(i10));
        }
        return destination;
    }

    public static <T> Ka.j<T> M(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return tArr.length == 0 ? Ka.t.j() : new b(tArr);
    }

    public static final <T, C extends Collection<? super T>> C M0(T[] tArr, C destination) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        for (T t10 : tArr) {
            destination.add(t10);
        }
        return destination;
    }

    public static boolean N(byte[] bArr, byte b10) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        return k0(bArr, b10) >= 0;
    }

    public static List<Byte> N0(byte[] bArr) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? X0(bArr) : C1172u.e(Byte.valueOf(bArr[0])) : C1173v.m();
    }

    public static boolean O(char[] cArr, char c10) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        return l0(cArr, c10) >= 0;
    }

    public static List<Character> O0(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? Y0(cArr) : C1172u.e(Character.valueOf(cArr[0])) : C1173v.m();
    }

    public static boolean P(int[] iArr, int i10) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        return m0(iArr, i10) >= 0;
    }

    public static List<Double> P0(double[] dArr) {
        kotlin.jvm.internal.p.i(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? Z0(dArr) : C1172u.e(Double.valueOf(dArr[0])) : C1173v.m();
    }

    public static boolean Q(long[] jArr, long j10) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        return n0(jArr, j10) >= 0;
    }

    public static List<Float> Q0(float[] fArr) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? a1(fArr) : C1172u.e(Float.valueOf(fArr[0])) : C1173v.m();
    }

    public static <T> boolean R(T[] tArr, T t10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return o0(tArr, t10) >= 0;
    }

    public static List<Integer> R0(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? b1(iArr) : C1172u.e(Integer.valueOf(iArr[0])) : C1173v.m();
    }

    public static boolean S(short[] sArr, short s10) {
        kotlin.jvm.internal.p.i(sArr, "<this>");
        return p0(sArr, s10) >= 0;
    }

    public static List<Long> S0(long[] jArr) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? c1(jArr) : C1172u.e(Long.valueOf(jArr[0])) : C1173v.m();
    }

    public static <T> List<T> T(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return F.m1(g1(tArr));
    }

    public static <T> List<T> T0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? d1(tArr) : C1172u.e(tArr[0]) : C1173v.m();
    }

    public static <T> List<T> U(T[] tArr, int i10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (i10 >= 0) {
            return K0(tArr, C5685n.f(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static List<Short> U0(short[] sArr) {
        kotlin.jvm.internal.p.i(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? e1(sArr) : C1172u.e(Short.valueOf(sArr[0])) : C1173v.m();
    }

    public static <T> List<T> V(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return (List) W(tArr, new ArrayList());
    }

    public static List<Boolean> V0(boolean[] zArr) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? f1(zArr) : C1172u.e(Boolean.valueOf(zArr[0])) : C1173v.m();
    }

    public static final <C extends Collection<? super T>, T> C W(T[] tArr, C destination) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static long[] W0(Long[] lArr) {
        kotlin.jvm.internal.p.i(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public static <T> T X(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Byte> X0(byte[] bArr) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    public static Float Y(float[] fArr) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final List<Character> Y0(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    public static <T> T Z(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final List<Double> Z0(double[] dArr) {
        kotlin.jvm.internal.p.i(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    public static <T> C5680i a0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return new C5680i(0, f0(tArr));
    }

    public static final List<Float> a1(float[] fArr) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    public static int b0(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        return cArr.length - 1;
    }

    public static final List<Integer> b1(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static int c0(float[] fArr) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        return fArr.length - 1;
    }

    public static final List<Long> c1(long[] jArr) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static int d0(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> List<T> d1(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return new ArrayList(C1173v.j(tArr, false, 1, null));
    }

    public static int e0(long[] jArr) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final List<Short> e1(short[] sArr) {
        kotlin.jvm.internal.p.i(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    public static <T> int f0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final List<Boolean> f1(boolean[] zArr) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    public static Boolean g0(boolean[] zArr, int i10) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        if (i10 < 0 || i10 >= zArr.length) {
            return null;
        }
        return Boolean.valueOf(zArr[i10]);
    }

    public static final <T> Set<T> g1(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return (Set) M0(tArr, new LinkedHashSet(Q.e(tArr.length)));
    }

    public static Float h0(float[] fArr, int i10) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        if (i10 < 0 || i10 >= fArr.length) {
            return null;
        }
        return Float.valueOf(fArr[i10]);
    }

    public static Set<Integer> h1(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? (Set) L0(iArr, new LinkedHashSet(Q.e(iArr.length))) : X.d(Integer.valueOf(iArr[0])) : Y.e();
    }

    public static Integer i0(int[] iArr, int i10) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        if (i10 < 0 || i10 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static <T> Set<T> i1(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) M0(tArr, new LinkedHashSet(Q.e(tArr.length))) : X.d(tArr[0]) : Y.e();
    }

    public static <T> T j0(T[] tArr, int i10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (i10 < 0 || i10 >= tArr.length) {
            return null;
        }
        return tArr[i10];
    }

    public static <T> Iterable<IndexedValue<T>> j1(final T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        return new K(new InterfaceC5063a() { // from class: Z8.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.k1(tArr);
            }
        });
    }

    public static final int k0(byte[] bArr, byte b10) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final Iterator k1(Object[] objArr) {
        return C4851b.a(objArr);
    }

    public static final int l0(char[] cArr, char c10) {
        kotlin.jvm.internal.p.i(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static <T, R> List<Pair<T, R>> l1(T[] tArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(C1174w.x(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(Y8.j.a(tArr[i10], r10));
            i10++;
        }
        return arrayList;
    }

    public static final int m0(int[] iArr, int i10) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static <T, R> List<Pair<T, R>> m1(T[] tArr, R[] other) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(Y8.j.a(tArr[i10], other[i10]));
        }
        return arrayList;
    }

    public static final int n0(long[] jArr, long j10) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static <T> int o0(T[] tArr, T t10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.p.d(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final int p0(short[] sArr, short s10) {
        kotlin.jvm.internal.p.i(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A q0(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super Byte, ? extends CharSequence> interfaceC5074l) throws IOException {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (interfaceC5074l != null) {
                buffer.append(interfaceC5074l.invoke(Byte.valueOf(b10)));
            } else {
                buffer.append(String.valueOf((int) b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T, A extends Appendable> A r0(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) throws IOException {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            La.s.a(buffer, t10, interfaceC5074l);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String t0(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super Byte, ? extends CharSequence> interfaceC5074l) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        return ((StringBuilder) q0(bArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, interfaceC5074l)).toString();
    }

    public static final <T> String u0(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        return ((StringBuilder) r0(tArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, interfaceC5074l)).toString();
    }

    public static /* synthetic */ String v0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            interfaceC5074l = null;
        }
        CharSequence charSequence5 = charSequence4;
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return t0(bArr, charSequence, charSequence2, charSequence3, i10, charSequence5, interfaceC5074l2);
    }

    public static /* synthetic */ String w0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            interfaceC5074l = null;
        }
        CharSequence charSequence5 = charSequence4;
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return u0(objArr, charSequence, charSequence2, charSequence3, i10, charSequence5, interfaceC5074l2);
    }

    public static long x0(long[] jArr) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[e0(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T y0(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[f0(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int z0(int[] iArr, int i10) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }
}
