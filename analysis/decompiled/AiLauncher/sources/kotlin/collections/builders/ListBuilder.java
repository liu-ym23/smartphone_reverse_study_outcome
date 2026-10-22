package kotlin.collections.builders;

import Z8.AbstractC1156d;
import Z8.AbstractC1160h;
import Z8.C1168p;
import Z8.C1172u;
import a9.C1242b;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.ContentDisposition;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q9.InterfaceC5162a;
import q9.InterfaceC5165d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0016\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0000\u0018\u0000 c*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0003Z]dB\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b \u0010!J-\u0010$\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u001eJ5\u0010,\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0019H\u0016¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00028\u00002\u0006\u00102\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b3\u0010'J \u00104\u001a\u00028\u00002\u0006\u00102\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b8\u00107J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0096\u0002¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<H\u0016¢\u0006\u0004\b=\u0010>J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0006\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010?J\u0017\u0010@\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010@\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b@\u0010!J\u001d\u0010B\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bB\u0010CJ%\u0010B\u001a\u00020\u00192\u0006\u00102\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bB\u0010DJ\u000f\u0010E\u001a\u00020\u000fH\u0016¢\u0006\u0004\bE\u0010\u0011J\u0017\u0010F\u001a\u00028\u00002\u0006\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010'J\u0017\u0010G\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\bG\u0010AJ\u001d\u0010H\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bH\u0010CJ\u001d\u0010I\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bI\u0010CJ%\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0016¢\u0006\u0004\bL\u0010MJ)\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00010O\"\u0004\b\u0001\u0010N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0OH\u0016¢\u0006\u0004\bQ\u0010SJ\u001a\u0010T\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\bT\u0010AJ\u000f\u0010U\u001a\u00020\bH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH\u0016¢\u0006\u0004\bX\u0010YR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010`R\u0014\u0010b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010V¨\u0006e"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "LZ8/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "initialCapacity", "<init>", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "LY8/t;", "H", "()V", "y", "n", "D", "minCapacity", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "other", "", "z", "(Ljava/util/List;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "G", "(II)V", "element", "v", "(ILjava/lang/Object;)V", "", "elements", "u", "(ILjava/util/Collection;I)V", "J", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "K", "retain", "L", "(IILjava/util/Collection;Z)I", "x", "()Ljava/util/List;", "isEmpty", "()Z", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "c", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "[Ljava/lang/Object;", "backing", Const.INTENT_KEY_PKGNAME, "I", "length", "Z", "isReadOnly", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, "BuilderSubList", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ListBuilder<E> extends AbstractC1160h<E> implements List<E>, RandomAccess, Serializable, InterfaceC5165d {

    /* renamed from: e, reason: collision with root package name */
    public static final ListBuilder f34725e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public E[] backing;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int length;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isReadOnly;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001]BC\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u001b\u0010!\u001a\u00020 2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0004\b%\u0010&J-\u0010)\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u00100J5\u00102\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u00101\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020 H\u0016¢\u0006\u0004\b4\u00105J\u0018\u00107\u001a\u00028\u00012\u0006\u00106\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b7\u0010,J \u00108\u001a\u00028\u00012\u0006\u00106\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\b<\u0010;J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010=H\u0096\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00010@H\u0016¢\u0006\u0004\bA\u0010BJ\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00010@2\u0006\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\bA\u0010CJ\u0017\u0010D\u001a\u00020 2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010D\u001a\u00020\u00172\u0006\u00106\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bD\u0010&J\u001d\u0010F\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bF\u0010GJ%\u0010F\u001a\u00020 2\u0006\u00106\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bF\u0010HJ\u000f\u0010I\u001a\u00020\u0017H\u0016¢\u0006\u0004\bI\u0010\u001bJ\u0017\u0010J\u001a\u00028\u00012\u0006\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\bJ\u0010,J\u0017\u0010K\u001a\u00020 2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bK\u0010EJ\u001d\u0010L\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bL\u0010GJ\u001d\u0010M\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bM\u0010GJ%\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010QJ)\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0002\u0010R2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00020\bH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bH\u0016¢\u0006\u0004\bT\u0010VJ\u001a\u0010W\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\bW\u0010EJ\u000f\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010`R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u00105R\u0014\u0010g\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010Y¨\u0006h"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "LZ8/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "backing", "", "offset", "length", "parent", "Lkotlin/collections/builders/ListBuilder;", Parameters.ROOT, "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "x", "()V", "n", "t", "", "other", "", "u", "(Ljava/util/List;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "element", "m", "(ILjava/lang/Object;)V", "", "elements", "l", "(ILjava/util/Collection;I)V", "y", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "z", "(II)V", "retain", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(IILjava/util/Collection;Z)I", "isEmpty", "()Z", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "c", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "[Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_UMID, "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "e", "Lkotlin/collections/builders/ListBuilder;", "v", "isReadOnly", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractC1160h<E> implements List<E>, RandomAccess, Serializable, InterfaceC5165d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public E[] backing;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int offset;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int length;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final BuilderSubList<E> parent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final ListBuilder<E> root;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001d¨\u0006\""}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$a;", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "list", "", "index", "<init>", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "hasPrevious", "()Z", "hasNext", "previousIndex", "()I", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "set", "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", Const.INTENT_KEY_PKGNAME, "I", "c", "lastIndex", Const.INTENT_KEY_UMID, "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a<E> implements ListIterator<E>, InterfaceC5162a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final BuilderSubList<E> list;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public int index;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public int lastIndex;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public int expectedModCount;

            public a(BuilderSubList<E> list, int i10) {
                p.i(list, "list");
                this.list = list;
                this.index = i10;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) list).modCount;
            }

            private final void a() {
                if (((AbstractList) this.list.root).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(E element) {
                a();
                BuilderSubList<E> builderSubList = this.list;
                int i10 = this.index;
                this.index = i10 + 1;
                builderSubList.add(i10, element);
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.index < this.list.length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                a();
                if (this.index >= this.list.length) {
                    throw new NoSuchElementException();
                }
                int i10 = this.index;
                this.index = i10 + 1;
                this.lastIndex = i10;
                return (E) this.list.backing[this.list.offset + this.lastIndex];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public E previous() {
                a();
                int i10 = this.index;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.index = i11;
                this.lastIndex = i11;
                return (E) this.list.backing[this.list.offset + this.lastIndex];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i10 = this.lastIndex;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.list.c(i10);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
            }

            @Override // java.util.ListIterator
            public void set(E element) {
                a();
                int i10 = this.lastIndex;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.list.set(i10, element);
            }
        }

        public BuilderSubList(E[] backing, int i10, int i11, BuilderSubList<E> builderSubList, ListBuilder<E> root) {
            p.i(backing, "backing");
            p.i(root, "root");
            this.backing = backing;
            this.offset = i10;
            this.length = i11;
            this.parent = builderSubList;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void n() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() throws NotSerializableException {
            if (v()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        private final void x() {
            ((AbstractList) this).modCount++;
        }

        public final int A(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
            BuilderSubList<E> builderSubList = this.parent;
            int iA = builderSubList != null ? builderSubList.A(rangeOffset, rangeLength, elements, retain) : this.root.L(rangeOffset, rangeLength, elements, retain);
            if (iA > 0) {
                x();
            }
            this.length -= iA;
            return iA;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E element) {
            t();
            n();
            m(this.offset + this.length, element);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            p.i(elements, "elements");
            t();
            n();
            int size = elements.size();
            l(this.offset + this.length, elements, size);
            return size > 0;
        }

        @Override // Z8.AbstractC1160h
        /* renamed from: b */
        public int getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String() {
            n();
            return this.length;
        }

        @Override // Z8.AbstractC1160h
        public E c(int index) {
            t();
            n();
            AbstractC1156d.INSTANCE.b(index, this.length);
            return y(this.offset + index);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            t();
            n();
            z(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object other) {
            n();
            if (other != this) {
                return (other instanceof List) && u((List) other);
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            n();
            AbstractC1156d.INSTANCE.b(index, this.length);
            return this.backing[this.offset + index];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            n();
            return C1242b.i(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object element) {
            n();
            for (int i10 = 0; i10 < this.length; i10++) {
                if (p.d(this.backing[this.offset + i10], element)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            n();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        public final void l(int i10, Collection<? extends E> elements, int n10) {
            x();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.l(i10, elements, n10);
            } else {
                this.root.u(i10, elements, n10);
            }
            this.backing = (E[]) this.root.backing;
            this.length += n10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object element) {
            n();
            for (int i10 = this.length - 1; i10 >= 0; i10--) {
                if (p.d(this.backing[this.offset + i10], element)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public final void m(int i10, E element) {
            x();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.m(i10, element);
            } else {
                this.root.v(i10, element);
            }
            this.backing = (E[]) this.root.backing;
            this.length++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object element) {
            t();
            n();
            int iIndexOf = indexOf(element);
            if (iIndexOf >= 0) {
                c(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            p.i(elements, "elements");
            t();
            n();
            return A(this.offset, this.length, elements, false) > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            p.i(elements, "elements");
            t();
            n();
            return A(this.offset, this.length, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            t();
            n();
            AbstractC1156d.INSTANCE.b(index, this.length);
            E[] eArr = this.backing;
            int i10 = this.offset;
            E e10 = eArr[i10 + index];
            eArr[i10 + index] = element;
            return e10;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            AbstractC1156d.INSTANCE.d(fromIndex, toIndex, this.length);
            return new BuilderSubList(this.backing, this.offset + fromIndex, toIndex - fromIndex, this, this.root);
        }

        public final void t() {
            if (v()) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            p.i(array, "array");
            n();
            int length = array.length;
            int i10 = this.length;
            if (length >= i10) {
                E[] eArr = this.backing;
                int i11 = this.offset;
                C1168p.i(eArr, array, 0, i11, i10 + i11);
                return (T[]) C1172u.g(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i12 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i12, i10 + i12, array.getClass());
            p.h(tArr, "copyOfRange(...)");
            return tArr;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            n();
            return C1242b.j(this.backing, this.offset, this.length, this);
        }

        public final boolean u(List<?> other) {
            return C1242b.h(this.backing, this.offset, this.length, other);
        }

        public final boolean v() {
            return this.root.isReadOnly;
        }

        public final E y(int i10) {
            x();
            BuilderSubList<E> builderSubList = this.parent;
            this.length--;
            return builderSubList != null ? builderSubList.y(i10) : (E) this.root.J(i10);
        }

        public final void z(int rangeOffset, int rangeLength) {
            if (rangeLength > 0) {
                x();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.z(rangeOffset, rangeLength);
            } else {
                this.root.K(rangeOffset, rangeLength);
            }
            this.length -= rangeLength;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            n();
            AbstractC1156d.INSTANCE.c(index, this.length);
            return new a(this, index);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, E element) {
            t();
            n();
            AbstractC1156d.INSTANCE.c(index, this.length);
            m(this.offset + index, element);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int index, Collection<? extends E> elements) {
            p.i(elements, "elements");
            t();
            n();
            AbstractC1156d.INSTANCE.c(index, this.length);
            int size = elements.size();
            l(this.offset + index, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            n();
            E[] eArr = this.backing;
            int i10 = this.offset;
            return C1168p.q(eArr, i10, this.length + i10);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001d¨\u0006\""}, d2 = {"Lkotlin/collections/builders/ListBuilder$b;", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/collections/builders/ListBuilder;", "list", "", "index", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "hasPrevious", "()Z", "hasNext", "previousIndex", "()I", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "set", "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/ListBuilder;", Const.INTENT_KEY_PKGNAME, "I", "c", "lastIndex", Const.INTENT_KEY_UMID, "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<E> implements ListIterator<E>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final ListBuilder<E> list;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int index;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int lastIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int expectedModCount;

        public b(ListBuilder<E> list, int i10) {
            p.i(list, "list");
            this.list = list;
            this.index = i10;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        private final void a() {
            if (((AbstractList) this.list).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            a();
            ListBuilder<E> listBuilder = this.list;
            int i10 = this.index;
            this.index = i10 + 1;
            listBuilder.add(i10, element);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.index >= this.list.length) {
                throw new NoSuchElementException();
            }
            int i10 = this.index;
            this.index = i10 + 1;
            this.lastIndex = i10;
            return (E) this.list.backing[this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int i10 = this.index;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.index = i11;
            this.lastIndex = i11;
            return (E) this.list.backing[this.lastIndex];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i10 = this.lastIndex;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.list.c(i10);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            a();
            int i10 = this.lastIndex;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.list.set(i10, element);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        f34725e = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    private final void H() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E J(int i10) {
        H();
        E[] eArr = this.backing;
        E e10 = eArr[i10];
        C1168p.i(eArr, eArr, i10, i10 + 1, this.length);
        C1242b.f(this.backing, this.length - 1);
        this.length--;
        return e10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            H();
        }
        E[] eArr = this.backing;
        C1168p.i(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
        E[] eArr2 = this.backing;
        int i10 = this.length;
        C1242b.g(eArr2, i10 - rangeLength, i10);
        this.length -= rangeLength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < rangeLength) {
            int i12 = rangeOffset + i10;
            if (elements.contains(this.backing[i12]) == retain) {
                E[] eArr = this.backing;
                i10++;
                eArr[i11 + rangeOffset] = eArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = rangeLength - i11;
        E[] eArr2 = this.backing;
        C1168p.i(eArr2, eArr2, rangeOffset + i11, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.backing;
        int i14 = this.length;
        C1242b.g(eArr3, i14 - i13, i14);
        if (i13 > 0) {
            H();
        }
        this.length -= i13;
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i10, Collection<? extends E> elements, int n10) {
        H();
        G(i10, n10);
        Iterator<? extends E> it = elements.iterator();
        for (int i11 = 0; i11 < n10; i11++) {
            this.backing[i10 + i11] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i10, E element) {
        H();
        G(i10, 1);
        this.backing[i10] = element;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final void y() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean z(List<?> other) {
        return C1242b.h(this.backing, 0, this.length, other);
    }

    public final void A(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (minCapacity > eArr.length) {
            this.backing = (E[]) C1242b.e(this.backing, AbstractC1156d.INSTANCE.e(eArr.length, minCapacity));
        }
    }

    public final void D(int n10) {
        A(this.length + n10);
    }

    public final void G(int i10, int n10) {
        D(n10);
        E[] eArr = this.backing;
        C1168p.i(eArr, eArr, i10 + n10, i10, this.length);
        this.length += n10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        y();
        v(this.length, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        p.i(elements, "elements");
        y();
        int size = elements.size();
        u(this.length, elements, size);
        return size > 0;
    }

    @Override // Z8.AbstractC1160h
    /* renamed from: b, reason: from getter */
    public int getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String() {
        return this.length;
    }

    @Override // Z8.AbstractC1160h
    public E c(int index) {
        y();
        AbstractC1156d.INSTANCE.b(index, this.length);
        return J(index);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        y();
        K(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof List) && z((List) other);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractC1156d.INSTANCE.b(index, this.length);
        return this.backing[index];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return C1242b.i(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (p.d(this.backing[i10], element)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (p.d(this.backing[i10], element)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        y();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            c(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        p.i(elements, "elements");
        y();
        return L(0, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        p.i(elements, "elements");
        y();
        return L(0, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        y();
        AbstractC1156d.INSTANCE.b(index, this.length);
        E[] eArr = this.backing;
        E e10 = eArr[index];
        eArr[index] = element;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractC1156d.INSTANCE.d(fromIndex, toIndex, this.length);
        return new BuilderSubList(this.backing, fromIndex, toIndex - fromIndex, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        p.i(array, "array");
        int length = array.length;
        int i10 = this.length;
        if (length >= i10) {
            C1168p.i(this.backing, array, 0, 0, i10);
            return (T[]) C1172u.g(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i10, array.getClass());
        p.h(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return C1242b.j(this.backing, 0, this.length, this);
    }

    public final List<E> x() {
        y();
        this.isReadOnly = true;
        return this.length > 0 ? this : f34725e;
    }

    public ListBuilder(int i10) {
        this.backing = (E[]) C1242b.d(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        AbstractC1156d.INSTANCE.c(index, this.length);
        return new b(this, index);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        y();
        AbstractC1156d.INSTANCE.c(index, this.length);
        v(index, element);
    }

    public /* synthetic */ ListBuilder(int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        p.i(elements, "elements");
        y();
        AbstractC1156d.INSTANCE.c(index, this.length);
        int size = elements.size();
        u(index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return C1168p.q(this.backing, 0, this.length);
    }
}
