package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SlidingWindowKt;
import kotlin.random.Random;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\n\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u000f\u001a\u001f\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0014\u0010\u0012\u001a'\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a%\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001b\u0010\u000f\u001a\u001d\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u001c\u0010\u0012\u001a\u001f\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001d\u0010\u000f\u001a\u001f\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u001e\u0010\u0012\u001a'\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b$\u0010\u000f\u001a\u001d\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b%\u0010\u0012\u001a\u001f\u0010&\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b&\u0010\u000f\u001a\u001f\u0010'\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b'\u0010\u0012\u001a+\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*\u001a+\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,\u001a=\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a)\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0000*\u000200*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b1\u00102\u001a=\u00106\u001a\u00028\u0000\"\u0010\b\u0000\u00104*\n\u0012\u0006\b\u0000\u0012\u00028\u000103\"\b\b\u0001\u0010\u0000*\u000200*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u00105\u001a\u00028\u0000¢\u0006\u0004\b6\u00107\u001a+\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;\u001a+\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b<\u0010*\u001a+\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b=\u0010,\u001a#\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b>\u00102\u001a-\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000?*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b@\u00102\u001a?\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010C\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Aj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`B¢\u0006\u0004\bD\u0010E\u001a\u0017\u0010G\u001a\u00020F*\b\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0004\bG\u0010H\u001a\u0017\u0010K\u001a\u00020J*\b\u0012\u0004\u0012\u00020I0\u001f¢\u0006\u0004\bK\u0010L\u001a\u0017\u0010N\u001a\u00020M*\b\u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\bN\u0010O\u001a\u0017\u0010R\u001a\u00020Q*\b\u0012\u0004\u0012\u00020P0\u001f¢\u0006\u0004\bR\u0010S\u001a7\u0010T\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u00104*\n\u0012\u0006\b\u0000\u0012\u00028\u000003*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00105\u001a\u00028\u0001¢\u0006\u0004\bT\u00107\u001a-\u0010W\u001a\u0012\u0012\u0004\u0012\u00028\u00000Uj\b\u0012\u0004\u0012\u00028\u0000`V\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bW\u0010X\u001a#\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bY\u00102\u001a#\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000Z\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b[\u00102\u001a#\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000Z\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f¢\u0006\u0004\b\\\u0010]\u001a#\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000^\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b_\u0010`\u001aC\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0086\bø\u0001\u0000¢\u0006\u0004\bc\u0010/\u001a)\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000d0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\be\u0010f\u001a#\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bg\u00102\u001a4\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000^\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bi\u0010j\u001a#\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000k\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bl\u0010`\u001a4\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000^\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bm\u0010j\u001a7\u0010n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\nH\u0086\bø\u0001\u0000¢\u0006\u0004\bn\u0010o\u001a\u0019\u0010q\u001a\u00020p*\b\u0012\u0004\u0012\u00020p0\u0001H\u0007¢\u0006\u0004\bq\u0010r\u001a+\u0010s\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000?*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bs\u0010t\u001a;\u0010u\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010C\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Aj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`BH\u0007¢\u0006\u0004\bu\u0010v\u001a=\u0010w\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010C\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Aj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`BH\u0007¢\u0006\u0004\bw\u0010v\u001a\u0019\u0010x\u001a\u00020p*\b\u0012\u0004\u0012\u00020p0\u0001H\u0007¢\u0006\u0004\bx\u0010r\u001a\u001b\u0010y\u001a\u0004\u0018\u00010p*\b\u0012\u0004\u0012\u00020p0\u0001H\u0007¢\u0006\u0004\by\u0010z\u001a+\u0010{\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000?*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b{\u0010t\u001a3\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010|\u001a\u00020\u0006H\u0007¢\u0006\u0004\b}\u0010*\u001a.\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b~\u0010\u007f\u001a8\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a0\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u007f\u001a1\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a8\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0082\u0001\u001a8\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a9\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u0001H\u0086\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\u001aL\u0010\u008e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010|\u001a\u00020\u00062\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00062\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001aJ\u0010\u0091\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0090\u00010\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010a*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0006\b\u0091\u0001\u0010\u0082\u0001\u001a\u008e\u0001\u0010\u009c\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u000f\b\u0001\u0010\u0094\u0001*\b0\u0092\u0001j\u0003`\u0093\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0007\u0010\u0095\u0001\u001a\u00028\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0096\u00012\n\b\u0002\u0010\u0098\u0001\u001a\u00030\u0096\u00012\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0096\u00012\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u00062\n\b\u0002\u0010\u009b\u0001\u001a\u00030\u0096\u00012\u0017\b\u0002\u0010b\u001a\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\n¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001\u001au\u0010\u009f\u0001\u001a\u00030\u009e\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0096\u00012\n\b\u0002\u0010\u0098\u0001\u001a\u00030\u0096\u00012\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0096\u00012\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u00062\n\b\u0002\u0010\u009b\u0001\u001a\u00030\u0096\u00012\u0017\b\u0002\u0010b\u001a\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\n¢\u0006\u0006\b\u009f\u0001\u0010 \u0001\u001a'\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001a\u001c\u0010£\u0001\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0006\b£\u0001\u0010¤\u0001\u001a\u001c\u0010¥\u0001\u001a\u00020P*\b\u0012\u0004\u0012\u00020P0\u0001H\u0007¢\u0006\u0006\b¥\u0001\u0010¦\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006§\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "f0", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "", "index", "j0", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "Lkotlin/Function1;", "defaultValue", "l0", "(Ljava/lang/Iterable;ILp9/l;)Ljava/lang/Object;", "p0", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "", "q0", "(Ljava/util/List;)Ljava/lang/Object;", "r0", "s0", "t0", "(Ljava/util/List;I)Ljava/lang/Object;", "u0", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "v0", "(Ljava/util/List;Ljava/lang/Object;)I", "B0", "C0", "D0", "E0", "", "Lkotlin/random/Random;", "random", "U0", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "W0", "X0", "Y0", "Z0", "n", "h0", "(Ljava/lang/Iterable;I)Ljava/util/List;", "i0", "(Ljava/util/List;I)Ljava/util/List;", "predicate", "m0", "(Ljava/lang/Iterable;Lp9/l;)Ljava/util/List;", "", "n0", "(Ljava/lang/Iterable;)Ljava/util/List;", "", "C", "destination", "o0", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "Lv9/i;", "indices", SdCardDbCreator.FIELD_LASTLOC_ID, "(Ljava/util/List;Lv9/i;)Ljava/util/List;", "f1", "g1", "V0", "", "b1", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "c1", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;", "", "h1", "(Ljava/util/Collection;)[Z", "", "", "i1", "(Ljava/util/Collection;)[B", "", "l1", "(Ljava/util/Collection;)[I", "", "", "n1", "(Ljava/util/Collection;)[J", "j1", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "k1", "(Ljava/lang/Iterable;)Ljava/util/HashSet;", "m1", "", "o1", "p1", "(Ljava/util/Collection;)Ljava/util/List;", "", "r1", "(Ljava/lang/Iterable;)Ljava/util/Set;", "R", "transform", "F0", "LZ8/J;", "u1", "(Ljava/lang/Iterable;)Ljava/lang/Iterable;", "g0", "other", "w0", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;", "", "q1", "s1", "c0", "(Ljava/lang/Iterable;Lp9/l;)Z", "", "H0", "(Ljava/lang/Iterable;)D", "G0", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "J0", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "I0", "M0", "L0", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "K0", ContentDisposition.Parameters.Size, "e0", "O0", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "N0", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/List;", "Q0", "T0", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "P0", "S0", "(Ljava/util/Collection;Ljava/lang/Iterable;)Ljava/util/List;", "LKa/j;", "R0", "(Ljava/util/Collection;LKa/j;)Ljava/util/List;", "step", "partialWindows", "t1", "(Ljava/lang/Iterable;IIZ)Ljava/util/List;", "Lkotlin/Pair;", "w1", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "x0", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/Appendable;", "", "z0", "(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/String;", "d0", "(Ljava/lang/Iterable;)LKa/j;", "d1", "(Ljava/lang/Iterable;)I", "e1", "(Ljava/lang/Iterable;)J", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes4.dex */
public class F extends C {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Z8/F$a", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Ka.j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f7660a;

        public a(Iterable iterable) {
            this.f7660a = iterable;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            return this.f7660a.iterator();
        }
    }

    public static /* synthetic */ String A0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
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
        return z0(iterable, charSequence, charSequence2, charSequence3, i10, charSequence5, interfaceC5074l2);
    }

    public static <T> T B0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) C0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T C0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(C1173v.o(list));
    }

    public static <T> T D0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T E0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T, R> List<R> F0(Iterable<? extends T> iterable, InterfaceC5074l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(transform, "transform");
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static <T extends Comparable<? super T>> T G0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static double H0(Iterable<Double> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T I0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T J0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static <T extends Comparable<? super T>> T K0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static Double L0(Iterable<Double> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static double M0(Iterable<Double> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static <T> List<T> N0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        Collection collectionG = A.G(elements);
        if (collectionG.isEmpty()) {
            return m1(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (!collectionG.contains(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static <T> List<T> O0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.p.d(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    public static <T> List<T> P0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        if (iterable instanceof Collection) {
            return S0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        A.E(arrayList, iterable);
        A.E(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> Q0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return T0((Collection) iterable, t10);
        }
        ArrayList arrayList = new ArrayList();
        A.E(arrayList, iterable);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> List<T> R0(Collection<? extends T> collection, Ka.j<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        A.D(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> S0(Collection<? extends T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            A.E(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> T0(Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> T U0(Collection<? extends T> collection, Random random) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) j0(collection, random.g(collection.size()));
    }

    public static <T> List<T> V0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return m1(iterable);
        }
        List<T> listO1 = o1(iterable);
        C.Z(listO1);
        return listO1;
    }

    public static <T> T W0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) X0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> T X0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> T Y0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> T Z0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> List<T> a1(List<? extends T> list, C5680i indices) {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(indices, "indices");
        return indices.isEmpty() ? C1173v.m() : m1(list.subList(indices.l().intValue(), indices.k().intValue() + 1));
    }

    public static <T extends Comparable<? super T>> List<T> b1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listO1 = o1(iterable);
            C1177z.B(listO1);
            return listO1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return m1(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        C1168p.H((Comparable[]) array);
        return C1168p.d(array);
    }

    public static <T> boolean c0(Iterable<? extends T> iterable, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> c1(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listO1 = o1(iterable);
            C1177z.C(listO1, comparator);
            return listO1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return m1(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        C1168p.I(array, comparator);
        return C1168p.d(array);
    }

    public static <T> Ka.j<T> d0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return new a(iterable);
    }

    public static int d1(Iterable<Integer> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static <T> List<List<T>> e0(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return t1(iterable, i10, i10, true);
    }

    public static long e1(Iterable<Long> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static <T> boolean f0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : u0(iterable, t10) >= 0;
    }

    public static <T> List<T> f1(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return C1173v.m();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return m1(iterable);
            }
            if (i10 == 1) {
                return C1172u.e(p0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return C1173v.t(arrayList);
    }

    public static <T> List<T> g0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return m1(q1(iterable));
    }

    public static <T> List<T> g1(List<? extends T> list, int i10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return C1173v.m();
        }
        int size = list.size();
        if (i10 >= size) {
            return m1(list);
        }
        if (i10 == 1) {
            return C1172u.e(C0(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static <T> List<T> h0(Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return m1(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i10;
            if (size <= 0) {
                return C1173v.m();
            }
            if (size == 1) {
                return C1172u.e(B0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i10 < size2) {
                        arrayList.add(list.get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i11 = 0;
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        return C1173v.t(arrayList);
    }

    public static boolean[] h1(Collection<Boolean> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            zArr[i10] = it.next().booleanValue();
            i10++;
        }
        return zArr;
    }

    public static <T> List<T> i0(List<? extends T> list, int i10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (i10 >= 0) {
            return f1(list, C5685n.f(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static byte[] i1(Collection<Byte> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArr[i10] = it.next().byteValue();
            i10++;
        }
        return bArr;
    }

    public static final <T> T j0(Iterable<? extends T> iterable, final int i10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i10) : (T) l0(iterable, i10, new InterfaceC5074l() { // from class: Z8.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return F.k0(i10, ((Integer) obj).intValue());
            }
        });
    }

    public static final <T, C extends Collection<? super T>> C j1(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static final Object k0(int i10, int i11) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i10 + '.');
    }

    public static <T> HashSet<T> k1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return (HashSet) j1(iterable, new HashSet(Q.e(C1174w.x(iterable, 12))));
    }

    public static final <T> T l0(Iterable<? extends T> iterable, int i10, InterfaceC5074l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i10 < 0 || i10 >= list.size()) ? defaultValue.invoke(Integer.valueOf(i10)) : (T) list.get(i10);
        }
        if (i10 < 0) {
            return defaultValue.invoke(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t10 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t10;
            }
            i11 = i12;
        }
        return defaultValue.invoke(Integer.valueOf(i10));
    }

    public static int[] l1(Collection<Integer> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    public static <T> List<T> m0(Iterable<? extends T> iterable, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (predicate.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static <T> List<T> m1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C1173v.t(o1(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C1173v.m();
        }
        if (size != 1) {
            return p1(collection);
        }
        return C1172u.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static <T> List<T> n0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return (List) o0(iterable, new ArrayList());
    }

    public static long[] n1(Collection<Long> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }

    public static final <C extends Collection<? super T>, T> C o0(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        for (T t10 : iterable) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static final <T> List<T> o1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return iterable instanceof Collection ? p1((Collection) iterable) : (List) j1(iterable, new ArrayList());
    }

    public static <T> T p0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) q0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> List<T> p1(Collection<? extends T> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> T q0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> Set<T> q1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) j1(iterable, new LinkedHashSet());
    }

    public static <T> T r0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> Set<T> r1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return Y.i((Set) j1(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return Y.e();
        }
        if (size != 1) {
            return (Set) j1(iterable, new LinkedHashSet(Q.e(collection.size())));
        }
        return X.d(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static <T> T s0(List<? extends T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> Set<T> s1(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        Set<T> setQ1 = q1(iterable);
        A.E(setQ1, other);
        return setQ1;
    }

    public static <T> T t0(List<? extends T> list, int i10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    public static final <T> List<List<T>> t1(Iterable<? extends T> iterable, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        SlidingWindowKt.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = SlidingWindowKt.b(iterable.iterator(), i10, i11, z10, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        int i12 = 0;
        while (i12 >= 0 && i12 < size) {
            int iJ = C5685n.j(i10, size - i12);
            if (iJ < i10 && !z10) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(iJ);
            for (int i13 = 0; i13 < iJ; i13++) {
                arrayList3.add(list.get(i13 + i12));
            }
            arrayList2.add(arrayList3);
            i12 += i11;
        }
        return arrayList2;
    }

    public static final <T> int u0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                C1173v.w();
            }
            if (kotlin.jvm.internal.p.d(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> Iterable<IndexedValue<T>> u1(final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return new K(new InterfaceC5063a() { // from class: Z8.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return F.v1(iterable);
            }
        });
    }

    public static <T> int v0(List<? extends T> list, T t10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        return list.indexOf(t10);
    }

    public static final Iterator v1(Iterable iterable) {
        return iterable.iterator();
    }

    public static <T> Set<T> w0(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        Set<T> setQ1 = q1(iterable);
        A.Q(setQ1, other);
        return setQ1;
    }

    public static <T, R> List<Pair<T, R>> w1(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C1174w.x(iterable, 10), C1174w.x(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(Y8.j.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T, A extends Appendable> A x0(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) throws IOException {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : iterable) {
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

    public static final <T> String z0(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(separator, "separator");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        kotlin.jvm.internal.p.i(postfix, "postfix");
        kotlin.jvm.internal.p.i(truncated, "truncated");
        return ((StringBuilder) x0(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, interfaceC5074l)).toString();
    }
}
