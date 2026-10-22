package androidx.compose.runtime.collection;

import D7.q;
import S7.n;
import S7.o;
import T7.a;
import T7.c;
import Y7.f;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0006\u0087\u0001\u0088\u0001\u0089\u0001B!\b\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u0012J#\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u001e\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0018J\u001e\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0019J\u001b\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0015\u0010\u001aJ#\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u0015\u0010\u001cJ\u001b\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u0015\u0010\u001dJ/\u0010 \u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\"\u0010!J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b(\u0010\u000fJ\u001b\u0010)\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b)\u0010\u0018J\u001b\u0010)\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010)\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b)\u0010\u0019J\u001b\u0010+\u001a\u00020\r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b+\u0010\u0019J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0006H\u0001¢\u0006\u0004\b/\u0010.J\r\u00100\u001a\u00028\u0000¢\u0006\u0004\b0\u00101J/\u00100\u001a\u00028\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b0\u00102J\u0010\u00104\u001a\u000203H\u0081\b¢\u0006\u0004\b4\u00105J\u0017\u00104\u001a\u0002032\u0006\u00107\u001a\u000206H\u0001¢\u0006\u0004\b4\u00108J\u0012\u00109\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\b9\u00101J1\u00109\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b9\u00102JC\u0010>\u001a\u00028\u0001\"\u0004\b\u0001\u0010:2\u0006\u0010;\u001a\u00028\u00012\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b>\u0010?JI\u0010A\u001a\u00028\u0001\"\u0004\b\u0001\u0010:2\u0006\u0010;\u001a\u00028\u00012\u001e\u0010=\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010@H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\bA\u0010BJC\u0010C\u001a\u00028\u0001\"\u0004\b\u0001\u0010:2\u0006\u0010;\u001a\u00028\u00012\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\bC\u0010?JI\u0010D\u001a\u00028\u0001\"\u0004\b\u0001\u0010:2\u0006\u0010;\u001a\u00028\u00012\u001e\u0010=\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010@H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\bD\u0010BJ/\u0010F\u001a\u00020\u00112\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bF\u0010GJ5\u0010H\u001a\u00020\u00112\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bH\u0010IJ/\u0010J\u001a\u00020\u00112\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bJ\u0010GJ5\u0010K\u001a\u00020\u00112\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bK\u0010IJ\u0018\u0010L\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\bN\u0010OJ/\u0010P\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bP\u0010QJ/\u0010R\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bR\u0010QJ\u0010\u0010S\u001a\u00020\rH\u0086\b¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\rH\u0086\b¢\u0006\u0004\bU\u0010TJ\r\u0010V\u001a\u00028\u0000¢\u0006\u0004\bV\u00101J/\u0010V\u001a\u00028\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bV\u00102J\u0015\u0010W\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\bW\u0010OJ\u0012\u0010X\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\bX\u00101J1\u0010X\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bX\u00102J=\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0006\b\u0001\u0010:\u0018\u00012\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bZ\u0010[JC\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0006\b\u0001\u0010:\u0018\u00012\u0018\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\\\u0010]JE\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0006\b\u0001\u0010:\u0018\u00012\u001a\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010<H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b^\u0010_J?\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0006\b\u0001\u0010:\u0018\u00012\u0014\u0010Y\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b`\u0010aJ\u0018\u0010b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\bb\u0010cJ\u0018\u0010d\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\bd\u0010cJ\u0015\u0010e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\be\u0010\u000fJ\u001b\u0010f\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\bf\u0010\u0018J\u001b\u0010f\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\bf\u0010\u0019J\u001b\u0010f\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\bf\u0010\u001dJ\u0015\u0010g\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\bg\u0010MJ\u001d\u0010j\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0006¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\u00112\u0006\u0010l\u001a\u00020\u0006H\u0001¢\u0006\u0004\bm\u0010.J$\u0010n\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001eH\u0086\b¢\u0006\u0004\bn\u0010GJ\u001b\u0010o\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\bo\u0010\u001dJ \u0010p\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bp\u0010qJ%\u0010u\u001a\u00020\u00112\u0016\u0010t\u001a\u0012\u0012\u0004\u0012\u00028\u00000rj\b\u0012\u0004\u0012\u00028\u0000`s¢\u0006\u0004\bu\u0010vJ/\u0010x\u001a\u00020\u00062\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u001eH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\bx\u0010QR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00048\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u0005\u0010y\u0012\u0004\bz\u0010'R\u001e\u0010{\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R%\u0010\u0007\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\r\n\u0004\b\u0007\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0015\u0010\u0082\u0001\u001a\u00020\u00068Æ\u0002¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0080\u0001R\u0016\u0010\u0086\u0001\u001a\u00030\u0083\u00018Æ\u0002¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u008a\u0001"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "content", "", "size", AppAgent.CONSTRUCT, "([Ljava/lang/Object;I)V", "getContent", "()[Ljava/lang/Object;", "element", "", "add", "(Ljava/lang/Object;)Z", "index", "LC7/r;", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/List;)Z", "(ILandroidx/compose/runtime/collection/MutableVector;)Z", "(Ljava/util/List;)Z", "(Landroidx/compose/runtime/collection/MutableVector;)Z", "([Ljava/lang/Object;)Z", "", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "Lkotlin/Function1;", "predicate", "any", "(LS7/k;)Z", "reversedAny", "", "asMutableList", "()Ljava/util/List;", "clear", "()V", "contains", "containsAll", "other", "contentEquals", "capacity", "ensureCapacity", "(I)V", "resizeStorage", "first", "()Ljava/lang/Object;", "(LS7/k;)Ljava/lang/Object;", "", "throwNoSuchElementException", "()Ljava/lang/Void;", "", "message", "(Ljava/lang/String;)Ljava/lang/Void;", "firstOrNull", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;LS7/n;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/Object;LS7/o;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "block", "forEach", "(LS7/k;)V", "forEachIndexed", "(LS7/n;)V", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "(LS7/k;)I", "indexOfLast", "isEmpty", "()Z", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "transform", "map", "(LS7/k;)[Ljava/lang/Object;", "mapIndexed", "(LS7/n;)[Ljava/lang/Object;", "mapIndexedNotNull", "(LS7/n;)Landroidx/compose/runtime/collection/MutableVector;", "mapNotNull", "(LS7/k;)Landroidx/compose/runtime/collection/MutableVector;", "plusAssign", "(Ljava/lang/Object;)V", "minusAssign", "remove", "removeAll", "removeAt", "start", "end", "removeRange", "(II)V", "newSize", "setSize", "removeIf", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "(Ljava/util/Comparator;)V", "selector", "sumBy", "[Ljava/lang/Object;", "getContent$annotations", "list", "Ljava/util/List;", "value", "I", "getSize", "()I", "getLastIndex", "lastIndex", "LY7/f;", "getIndices", "()LY7/f;", "indices", "VectorListIterator", "MutableVectorList", "SubList", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    public T[] content;
    private List<T> list;
    private int size;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010+\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\nJ\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ%\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u001e\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b&\u0010\nJ\u001d\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b'\u0010\u000eJ\u0017\u0010(\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010\u0012J\u001d\u0010)\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b)\u0010\u000eJ \u0010*\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b*\u0010+J%\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R\u0014\u00103\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/collection/MutableVector;", "vector", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/collection/MutableVector;)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "LC7/r;", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "()V", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Landroidx/compose/runtime/collection/MutableVector;", "getSize", "()I", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableVectorList<T> implements List<T>, c {
        private final MutableVector<T> vector;

        public MutableVectorList(MutableVector<T> mutableVector) {
            this.vector = mutableVector;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            return this.vector.add(element);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            return this.vector.addAll(index, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.vector.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            return this.vector.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            return this.vector.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.content[index];
        }

        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            return this.vector.indexOf(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.vector.getSize() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            return this.vector.lastIndexOf(element);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> elements) {
            return this.vector.removeAll(elements);
        }

        public T removeAt(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.removeAt(index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> elements) {
            return this.vector.retainAll(elements);
        }

        @Override // java.util.List
        public T set(int index, T element) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.set(index, element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.vector.add(index, element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            return this.vector.addAll(elements);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new VectorListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            return this.vector.remove(element);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.b(this, tArr);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010+\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u001f\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ%\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010!\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010&J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b'\u0010\fJ\u001d\u0010(\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b(\u0010\u0010J\u0017\u0010)\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0013J\u001d\u0010*\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b*\u0010\u0010J \u0010+\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b+\u0010,J%\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00102R\u0014\u00105\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "", "start", "end", AppAgent.CONSTRUCT, "(Ljava/util/List;II)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "LC7/r;", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "()V", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Ljava/util/List;", "I", "getSize", "()I", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SubList<T> implements List<T>, c {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i, int i6) {
            this.list = list;
            this.start = i;
            this.end = i6;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            List<T> list = this.list;
            int i = this.end;
            this.end = i + 1;
            list.add(i, element);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            this.list.addAll(index + this.start, elements);
            int size = elements.size();
            this.end += size;
            return size > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i6) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.list.get(index + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    return i6 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 > i) {
                return -1;
            }
            while (!k.b(this.list.get(i), element)) {
                if (i == i6) {
                    return -1;
                }
                i--;
            }
            return i - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> elements) {
            int i = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.end;
        }

        public T removeAt(int index) {
            MutableVectorKt.checkIndex(this, index);
            this.end--;
            return this.list.remove(index + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> elements) {
            int i = this.end;
            int i6 = i - 1;
            int i10 = this.start;
            if (i10 <= i6) {
                while (true) {
                    if (!elements.contains(this.list.get(i6))) {
                        this.list.remove(i6);
                        this.end--;
                    }
                    if (i6 == i10) {
                        break;
                    }
                    i6--;
                }
            }
            return i != this.end;
        }

        @Override // java.util.List
        public T set(int index, T element) {
            MutableVectorKt.checkIndex(this, index);
            return this.list.set(index + this.start, element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.list.add(index + this.start, element);
            this.end++;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new VectorListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    this.list.remove(i6);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.b(this, tArr);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            this.list.addAll(this.end, elements);
            int size = elements.size();
            this.end += size;
            return size > 0;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "list", "", "index", AppAgent.CONSTRUCT, "(Ljava/util/List;I)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "LC7/r;", "remove", "()V", "hasPrevious", "nextIndex", "()I", "previous", "previousIndex", "element", "add", "(Ljava/lang/Object;)V", "set", "Ljava/util/List;", "I", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class VectorListIterator<T> implements ListIterator<T>, a {
        private int index;
        private final List<T> list;

        public VectorListIterator(List<T> list, int i) {
            this.list = list;
            this.index = i;
        }

        @Override // java.util.ListIterator
        public void add(T element) {
            this.list.add(this.index, element);
            this.index++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.index;
            this.index = i + 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i = this.index - 1;
            this.index = i;
            return this.list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.index - 1;
            this.index = i;
            this.list.remove(i);
        }

        @Override // java.util.ListIterator
        public void set(T element) {
            this.list.set(this.index, element);
        }
    }

    public MutableVector(T[] tArr, int i) {
        this.content = tArr;
        this.size = i;
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final boolean add(T element) {
        int i = this.size + 1;
        if (this.content.length < i) {
            resizeStorage(i);
        }
        T[] tArr = this.content;
        int i6 = this.size;
        tArr[i6] = element;
        this.size = i6 + 1;
        return true;
    }

    public final boolean addAll(int index, List<? extends T> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        int size = elements.size();
        int i = this.size + size;
        if (this.content.length < i) {
            resizeStorage(i);
        }
        T[] tArr = this.content;
        int i6 = this.size;
        if (index != i6) {
            System.arraycopy(tArr, index, tArr, index + size, i6 - index);
        }
        int size2 = elements.size();
        for (int i10 = 0; i10 < size2; i10++) {
            tArr[index + i10] = elements.get(i10);
        }
        this.size += size;
        return true;
    }

    public final boolean any(S7.k predicate) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (((Boolean) predicate.invoke(tArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<T> asMutableList() {
        List<T> list = this.list;
        if (list != null) {
            return list;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            tArr[i6] = null;
        }
        this.size = 0;
    }

    public final boolean contains(T element) {
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i = 0; !k.b(this.content[i], element); i++) {
                if (i != size) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsAll(List<? extends T> elements) {
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            if (!contains(elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean contentEquals(MutableVector<T> other) {
        if (other.size != this.size) {
            return false;
        }
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i = 0; k.b(other.content[i], this.content[i]); i++) {
                if (i != size) {
                }
            }
            return false;
        }
        return true;
    }

    public final void ensureCapacity(int capacity) {
        if (this.content.length < capacity) {
            resizeStorage(capacity);
        }
    }

    public final T first(S7.k predicate) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            T t9 = tArr[i];
            if (((Boolean) predicate.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public final T firstOrNull(S7.k predicate) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            T t9 = tArr[i];
            if (((Boolean) predicate.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        return null;
    }

    public final <R> R fold(R initial, n operation) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            initial = (R) operation.invoke(initial, tArr[i]);
        }
        return initial;
    }

    public final <R> R foldIndexed(R initial, o operation) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            initial = (R) operation.invoke(Integer.valueOf(i), initial, tArr[i]);
        }
        return initial;
    }

    public final <R> R foldRight(R initial, n operation) {
        int size = getSize() - 1;
        T[] tArr = this.content;
        if (size >= tArr.length) {
            return initial;
        }
        while (size >= 0) {
            initial = (R) operation.invoke(tArr[size], initial);
            size--;
        }
        return initial;
    }

    public final <R> R foldRightIndexed(R initial, o operation) {
        int size = getSize() - 1;
        T[] tArr = this.content;
        if (size >= tArr.length) {
            return initial;
        }
        while (size >= 0) {
            initial = (R) operation.invoke(Integer.valueOf(size), tArr[size], initial);
            size--;
        }
        return initial;
    }

    public final void forEach(S7.k block) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(tArr[i]);
        }
    }

    public final void forEachIndexed(n block) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(Integer.valueOf(i), tArr[i]);
        }
    }

    public final void forEachReversed(S7.k block) {
        int size = getSize() - 1;
        T[] tArr = this.content;
        if (size >= tArr.length) {
            return;
        }
        while (size >= 0) {
            block.invoke(tArr[size]);
            size--;
        }
    }

    public final void forEachReversedIndexed(n block) {
        int size = getSize() - 1;
        T[] tArr = this.content;
        if (size >= tArr.length) {
            return;
        }
        while (size >= 0) {
            block.invoke(Integer.valueOf(size), tArr[size]);
            size--;
        }
    }

    public final T get(int index) {
        return this.content[index];
    }

    public final T[] getContent() {
        return this.content;
    }

    public final f getIndices() {
        return AbstractC1451a.X(0, getSize());
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T element) {
        T[] tArr = this.content;
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (k.b(element, tArr[i6])) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfFirst(S7.k predicate) {
        T[] tArr = this.content;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (((Boolean) predicate.invoke(tArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public final int indexOfLast(S7.k predicate) {
        int size = getSize() - 1;
        T[] tArr = this.content;
        if (size >= tArr.length) {
            return -1;
        }
        while (size >= 0) {
            if (((Boolean) predicate.invoke(tArr[size])).booleanValue()) {
                return size;
            }
            size--;
        }
        return -1;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getSize() != 0;
    }

    public final T last(S7.k predicate) {
        T[] tArr = this.content;
        for (int size = getSize() - 1; size >= 0; size--) {
            T t9 = tArr[size];
            if (((Boolean) predicate.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        throwNoSuchElementException("MutableVector contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public final int lastIndexOf(T element) {
        T[] tArr = this.content;
        for (int i = this.size - 1; i >= 0; i--) {
            if (k.b(element, tArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public final T lastOrNull(S7.k predicate) {
        T[] tArr = this.content;
        for (int size = getSize() - 1; size >= 0; size--) {
            T t9 = tArr[size];
            if (((Boolean) predicate.invoke(t9)).booleanValue()) {
                return t9;
            }
        }
        return null;
    }

    public final <R> R[] map(S7.k transform) {
        getSize();
        k.m();
        throw null;
    }

    public final <R> R[] mapIndexed(n transform) {
        getSize();
        k.m();
        throw null;
    }

    public final <R> MutableVector<R> mapIndexedNotNull(n transform) {
        getSize();
        k.m();
        throw null;
    }

    public final <R> MutableVector<R> mapNotNull(S7.k transform) {
        getSize();
        k.m();
        throw null;
    }

    public final void minusAssign(T element) {
        remove(element);
    }

    public final void plusAssign(T element) {
        add(element);
    }

    public final boolean remove(T element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(List<? extends T> elements) {
        int i = this.size;
        int size = elements.size();
        for (int i6 = 0; i6 < size; i6++) {
            remove(elements.get(i6));
        }
        return i != this.size;
    }

    public final T removeAt(int index) {
        T[] tArr = this.content;
        T t9 = tArr[index];
        if (index != getSize() - 1) {
            int i = index + 1;
            System.arraycopy(tArr, i, tArr, index, this.size - i);
        }
        int i6 = this.size - 1;
        this.size = i6;
        tArr[i6] = null;
        return t9;
    }

    public final void removeIf(S7.k predicate) {
        int size = getSize();
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            if (((Boolean) predicate.invoke(this.content[i6])).booleanValue()) {
                i++;
            } else if (i > 0) {
                T[] tArr = this.content;
                tArr[i6 - i] = tArr[i6];
            }
        }
        int i10 = size - i;
        q.f0(null, i10, this.content, size);
        setSize(i10);
    }

    public final void removeRange(int start, int end) {
        if (end > start) {
            int i = this.size;
            if (end < i) {
                T[] tArr = this.content;
                System.arraycopy(tArr, end, tArr, start, i - end);
            }
            int i6 = this.size - (end - start);
            int size = getSize() - 1;
            if (i6 <= size) {
                int i10 = i6;
                while (true) {
                    this.content[i10] = null;
                    if (i10 == size) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.size = i6;
        }
    }

    public final void resizeStorage(int capacity) {
        T[] tArr = this.content;
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[Math.max(capacity, length * 2)];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        this.content = tArr2;
    }

    public final boolean retainAll(Collection<? extends T> elements) {
        int i = this.size;
        for (int size = getSize() - 1; -1 < size; size--) {
            if (!elements.contains(this.content[size])) {
                removeAt(size);
            }
        }
        return i != this.size;
    }

    public final boolean reversedAny(S7.k predicate) {
        T[] tArr = this.content;
        for (int size = getSize() - 1; size >= 0; size--) {
            if (((Boolean) predicate.invoke(tArr[size])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final T set(int index, T element) {
        T[] tArr = this.content;
        T t9 = tArr[index];
        tArr[index] = element;
        return t9;
    }

    public final void setSize(int newSize) {
        this.size = newSize;
    }

    public final void sortWith(Comparator<T> comparator) {
        T[] tArr = this.content;
        int i = this.size;
        k.f(tArr, "<this>");
        k.f(comparator, "comparator");
        Arrays.sort(tArr, 0, i, comparator);
    }

    public final int sumBy(S7.k selector) {
        T[] tArr = this.content;
        int iIntValue = 0;
        for (int i = 0; i < getSize(); i++) {
            iIntValue += ((Number) selector.invoke(tArr[i])).intValue();
        }
        return iIntValue;
    }

    public final Void throwNoSuchElementException() {
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final Void throwNoSuchElementException(String message) {
        throw new NoSuchElementException(message);
    }

    public final boolean containsAll(Collection<? extends T> elements) {
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final T firstOrNull() {
        if (getSize() == 0) {
            return null;
        }
        return this.content[0];
    }

    public final T lastOrNull() {
        if (getSize() == 0) {
            return null;
        }
        return this.content[getSize() - 1];
    }

    public final boolean removeAll(MutableVector<T> elements) {
        int i = this.size;
        int size = elements.getSize() - 1;
        if (size >= 0) {
            int i6 = 0;
            while (true) {
                remove(elements.content[i6]);
                if (i6 == size) {
                    break;
                }
                i6++;
            }
        }
        return i != this.size;
    }

    public final void add(int index, T element) {
        int i = this.size + 1;
        if (this.content.length < i) {
            resizeStorage(i);
        }
        T[] tArr = this.content;
        int i6 = this.size;
        if (index != i6) {
            System.arraycopy(tArr, index, tArr, index + 1, i6 - index);
        }
        tArr[index] = element;
        this.size++;
    }

    public final boolean containsAll(MutableVector<T> elements) {
        f fVarX = AbstractC1451a.X(0, elements.getSize());
        int i = fVarX.f1569a;
        int i6 = fVarX.b;
        if (i > i6) {
            return true;
        }
        while (contains(elements.content[i])) {
            if (i == i6) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final T first() {
        if (getSize() != 0) {
            return this.content[0];
        }
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final T last() {
        if (getSize() != 0) {
            return this.content[getSize() - 1];
        }
        throwNoSuchElementException("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final boolean removeAll(Collection<? extends T> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        int i = this.size;
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i != this.size;
    }

    public final boolean addAll(int index, MutableVector<T> elements) {
        int i = elements.size;
        if (i == 0) {
            return false;
        }
        int i6 = this.size + i;
        if (this.content.length < i6) {
            resizeStorage(i6);
        }
        T[] tArr = this.content;
        int i10 = this.size;
        if (index != i10) {
            System.arraycopy(tArr, index, tArr, index + i, i10 - index);
        }
        System.arraycopy(elements.content, 0, tArr, index, i);
        this.size += i;
        return true;
    }

    public final boolean addAll(List<? extends T> elements) {
        return addAll(getSize(), (List) elements);
    }

    public final boolean addAll(MutableVector<T> elements) {
        return addAll(getSize(), elements);
    }

    public final boolean addAll(T[] elements) {
        int length = elements.length;
        if (length == 0) {
            return false;
        }
        int i = this.size + length;
        if (this.content.length < i) {
            resizeStorage(i);
        }
        System.arraycopy(elements, 0, this.content, this.size, length);
        this.size += length;
        return true;
    }

    public final boolean addAll(int index, Collection<? extends T> elements) {
        int i = 0;
        if (elements.isEmpty()) {
            return false;
        }
        int size = elements.size();
        int i6 = this.size + size;
        if (this.content.length < i6) {
            resizeStorage(i6);
        }
        T[] tArr = this.content;
        int i10 = this.size;
        if (index != i10) {
            System.arraycopy(tArr, index, tArr, index + size, i10 - index);
        }
        for (T t9 : elements) {
            int i11 = i + 1;
            if (i >= 0) {
                tArr[i + index] = t9;
                i = i11;
            } else {
                H4.o.X();
                throw null;
            }
        }
        this.size += size;
        return true;
    }

    public final boolean addAll(Collection<? extends T> elements) {
        return addAll(this.size, elements);
    }
}
