package androidx.compose.runtime.external.kotlinx.collections.immutable;

import A0.f;
import C7.c;
import D7.A;
import D7.q;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import androidx.exifinterface.media.ExifInterface;
import i9.i;
import j9.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a@\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00040\u0002H\u0080\b¢\u0006\u0004\b\u0006\u0010\n\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0004\u0012\u00020\u00040\u0002H\u0080\b¢\u0006\u0004\b\u0006\u0010\u000f\u001a.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0013\u0010\u0014\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0015\u0010\u0014\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u0018\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u001a\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u001c\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0015\u0010\u0018\u001a6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0015\u0010\u001a\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0015\u0010\u001c\u001a.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0013\u0010\u001d\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0015\u0010\u001d\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u001e\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u001f\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0013\u0010 \u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0015\u0010\u001e\u001a6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0015\u0010\u001f\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0015\u0010 \u001a.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0013\u0010!\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0080\n¢\u0006\u0004\b\u0015\u0010!\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\"\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0013\u0010#\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0013\u0010$\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0015\u0010\"\u001a6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0015\u0010#\u001a4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0015\u0010$\u001a4\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0004¢\u0006\u0004\b%\u0010\"\u001a4\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0004¢\u0006\u0004\b%\u0010&\u001aN\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0080\n¢\u0006\u0004\b\u0013\u0010)\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0016H\u0080\n¢\u0006\u0004\b\u0013\u0010+\u001aV\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u001a\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019H\u0080\n¢\u0006\u0004\b\u0013\u0010,\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u001bH\u0080\n¢\u0006\u0004\b\u0013\u0010-\u001aP\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0014\u0010/\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0080\n¢\u0006\u0004\b\u0013\u00100\u001aO\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0014\u0010/\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0000¢\u0006\u0004\b1\u00100\u001aS\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0016H\u0000¢\u0006\u0004\b1\u0010+\u001aU\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u001a\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019H\u0000¢\u0006\u0004\b1\u0010,\u001aS\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u001bH\u0000¢\u0006\u0004\b1\u0010-\u001aB\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u00102\u001a\u00028\u0000H\u0080\u0002¢\u0006\u0004\b\u0015\u00103\u001aH\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0080\u0002¢\u0006\u0004\b\u0015\u0010+\u001aJ\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019H\u0080\u0002¢\u0006\u0004\b\u0015\u00105\u001aH\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\u0002¢\u0006\u0004\b\u0015\u0010-\u001a/\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0000¢\u0006\u0004\b6\u00107\u001a\u001b\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010H\u0000¢\u0006\u0004\b6\u00108\u001a/\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0000¢\u0006\u0004\b9\u0010:\u001a\u001b\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010H\u0000¢\u0006\u0004\b9\u0010;\u001a/\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0000¢\u0006\u0004\b<\u0010:\u001a\u001b\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010H\u0000¢\u0006\u0004\b<\u0010;\u001aS\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f2*\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0000¢\u0006\u0004\b=\u0010>\u001a'\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\fH\u0000¢\u0006\u0004\b=\u0010?\u001aS\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f2*\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0000¢\u0006\u0004\b@\u0010>\u001a'\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\fH\u0000¢\u0006\u0004\b@\u0010?\u001a/\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0001¢\u0006\u0004\bA\u00107\u001a\u001b\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0010H\u0001¢\u0006\u0004\bA\u00108\u001a/\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0001¢\u0006\u0004\bB\u0010:\u001a\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0010H\u0001¢\u0006\u0004\bB\u0010;\u001a/\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H\u0001¢\u0006\u0004\bC\u0010:\u001aS\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f2*\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0001¢\u0006\u0004\bD\u0010>\u001aS\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f2*\u0010*\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'0\u0019\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'H\u0001¢\u0006\u0004\bE\u0010>\u001a%\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\bG\u0010H\u001a%\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0000¢\u0006\u0004\bG\u0010I\u001a\u0019\u0010G\u001a\b\u0012\u0004\u0012\u00020K0F*\u00020JH\u0000¢\u0006\u0004\bG\u0010L\u001a%\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\bM\u0010N\u001a%\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0000¢\u0006\u0004\bM\u0010O\u001a\u0019\u0010M\u001a\b\u0012\u0004\u0012\u00020K0\b*\u00020JH\u0000¢\u0006\u0004\bM\u0010P\u001a%\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000Q\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\bR\u0010S\u001a%\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000Q\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0000¢\u0006\u0004\bR\u0010T\u001a\u0019\u0010R\u001a\b\u0012\u0004\u0012\u00020K0\u0001*\u00020JH\u0000¢\u0006\u0004\bR\u0010U\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\bV\u0010W\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0000¢\u0006\u0004\bV\u0010X\u001a\u0019\u0010V\u001a\b\u0012\u0004\u0012\u00020K0\u0001*\u00020JH\u0000¢\u0006\u0004\bV\u0010U\u001a%\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0000¢\u0006\u0004\bY\u0010W\u001a%\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0000¢\u0006\u0004\bY\u0010X\u001a\u0019\u0010Y\u001a\b\u0012\u0004\u0012\u00020K0\u0001*\u00020JH\u0000¢\u0006\u0004\bY\u0010U\u001a7\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010Z\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0000¢\u0006\u0004\b[\u0010\\\u001a7\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0000¢\u0006\u0004\b]\u0010^\u001a7\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0000¢\u0006\u0004\b_\u0010^¨\u0006`"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Lkotlin/Function1;", "", "LC7/r;", "mutator", "mutate", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;LS7/k;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;LS7/k;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;LS7/k;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "element", "plus", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "minus", "", "elements", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Li9/i;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "intersect", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Lkotlin/Pair;", "pair", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "pairs", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "", "map", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/util/Map;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "putAll", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "persistentListOf", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "persistentSetOf", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "persistentHashSetOf", "persistentMapOf", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "persistentHashMapOf", "immutableListOf", "immutableSetOf", "immutableHashSetOf", "immutableMapOf", "immutableHashMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "toImmutableList", "(Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "(Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "(Ljava/lang/CharSequence;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "toPersistentList", "(Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Ljava/lang/CharSequence;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toImmutableSet", "(Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "(Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "(Ljava/lang/CharSequence;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "toPersistentSet", "(Ljava/lang/Iterable;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Li9/i;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "toPersistentHashSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toImmutableMap", "(Ljava/util/Map;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toPersistentMap", "(Ljava/util/Map;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "toPersistentHashMap", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtensionsKt {
    @c
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        return persistentHashMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @c
    public static final <E> PersistentSet<E> immutableHashSetOf(E... eArr) {
        return persistentHashSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    @c
    public static final <E> PersistentList<E> immutableListOf(E... eArr) {
        return persistentListOf(Arrays.copyOf(eArr, eArr.length));
    }

    @c
    public static final <K, V> PersistentMap<K, V> immutableMapOf(Pair<? extends K, ? extends V>... pairArr) {
        return persistentMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @c
    public static final <E> PersistentSet<E> immutableSetOf(E... eArr) {
        return persistentSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    public static final <E> PersistentSet<E> intersect(PersistentSet<? extends E> persistentSet, Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return persistentSet.retainAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        k.f(builder, "<this>");
        k.f(elements, "elements");
        builder.retainAll(A.h0(elements));
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E e) {
        return persistentCollection.remove((PersistentCollection<? extends E>) e);
    }

    public static final <T> PersistentSet<T> mutate(PersistentSet<? extends T> persistentSet, S7.k kVar) {
        PersistentSet.Builder<? extends T> builder = persistentSet.builder();
        kVar.invoke(builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        PersistentHashMap<K, V> persistentHashMapEmptyOf$runtime = PersistentHashMap.INSTANCE.emptyOf$runtime();
        k.d(persistentHashMapEmptyOf$runtime, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = persistentHashMapEmptyOf$runtime.builder2();
        a.W(builder, pairArr);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf(E... eArr) {
        return PersistentHashSet.INSTANCE.emptyOf$runtime().addAll((Collection) q.L(eArr));
    }

    public static final <E> PersistentList<E> persistentListOf(E... eArr) {
        return UtilsKt.persistentVectorOf().addAll((Collection) q.L(eArr));
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf(Pair<? extends K, ? extends V>... pairArr) {
        PersistentOrderedMap<K, V> persistentOrderedMapEmptyOf$runtime = PersistentOrderedMap.INSTANCE.emptyOf$runtime();
        k.d(persistentOrderedMapEmptyOf$runtime, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = persistentOrderedMapEmptyOf$runtime.builder2();
        a.W(builder, pairArr);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> persistentSetOf(E... eArr) {
        return PersistentOrderedSet.INSTANCE.emptyOf$runtime().addAll((Collection) q.L(eArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E e) {
        return persistentCollection.add((PersistentCollection<? extends E>) e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.putAll>");
        return persistentMap.putAll((Map<? extends Object, ? extends Object>) map);
    }

    public static final <T> ImmutableList<T> toImmutableList(Iterable<? extends T> iterable) {
        ImmutableList<T> immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? toPersistentList(iterable) : immutableList;
    }

    public static final <K, V> ImmutableMap<K, V> toImmutableMap(Map<K, ? extends V> map) {
        ImmutableMap<K, V> immutableMap = map instanceof ImmutableMap ? (ImmutableMap) map : null;
        if (immutableMap != null) {
            return immutableMap;
        }
        PersistentMap.Builder builder = map instanceof PersistentMap.Builder ? (PersistentMap.Builder) map : null;
        PersistentMap<K, V> persistentMapBuild = builder != null ? builder.build2() : null;
        return persistentMapBuild != null ? persistentMapBuild : persistentMapOf().putAll((Map) map);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Iterable<? extends T> iterable) {
        ImmutableSet<T> immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        PersistentSet persistentSetBuild = builder != null ? builder.build() : null;
        return persistentSetBuild != null ? persistentSetBuild : plus(persistentSetOf(), (Iterable) iterable);
    }

    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(Map<K, ? extends V> map) {
        PersistentHashMap persistentHashMap = map instanceof PersistentHashMap ? (PersistentHashMap) map : null;
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        PersistentHashMapBuilder persistentHashMapBuilder = map instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) map : null;
        PersistentHashMap<K, V> persistentHashMapBuild = persistentHashMapBuilder != null ? persistentHashMapBuilder.build2() : null;
        return persistentHashMapBuild != null ? persistentHashMapBuild : PersistentHashMap.INSTANCE.emptyOf$runtime().putAll((Map) map);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Iterable<? extends T> iterable) {
        PersistentHashSet persistentHashSet = iterable instanceof PersistentHashSet ? (PersistentHashSet) iterable : null;
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = iterable instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) iterable : null;
        PersistentHashSet persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        return persistentHashSetBuild != null ? persistentHashSetBuild : plus(PersistentHashSet.INSTANCE.emptyOf$runtime(), (Iterable) iterable);
    }

    public static final <T> PersistentList<T> toPersistentList(Iterable<? extends T> iterable) {
        PersistentList<T> persistentList = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList != null) {
            return persistentList;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        PersistentList<T> persistentListBuild = builder != null ? builder.build() : null;
        return persistentListBuild == null ? plus(persistentListOf(), (Iterable) iterable) : persistentListBuild;
    }

    public static final <K, V> PersistentMap<K, V> toPersistentMap(Map<K, ? extends V> map) {
        PersistentOrderedMap persistentOrderedMap = map instanceof PersistentOrderedMap ? (PersistentOrderedMap) map : null;
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = map instanceof PersistentOrderedMapBuilder ? (PersistentOrderedMapBuilder) map : null;
        PersistentMap<K, V> persistentMapBuild = persistentOrderedMapBuilder != null ? persistentOrderedMapBuilder.build2() : null;
        return persistentMapBuild == null ? PersistentOrderedMap.INSTANCE.emptyOf$runtime().putAll((Map) map) : persistentMapBuild;
    }

    public static final <T> PersistentSet<T> toPersistentSet(Iterable<? extends T> iterable) {
        PersistentOrderedSet persistentOrderedSet = iterable instanceof PersistentOrderedSet ? (PersistentOrderedSet) iterable : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = iterable instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) iterable : null;
        PersistentSet<T> persistentSetBuild = persistentOrderedSetBuilder != null ? persistentOrderedSetBuilder.build() : null;
        return persistentSetBuild == null ? plus(PersistentOrderedSet.INSTANCE.emptyOf$runtime(), (Iterable) iterable) : persistentSetBuild;
    }

    @c
    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    @c
    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentCollection.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.k0(iterable, builder);
        return builder.build();
    }

    public static final <T> PersistentList<T> mutate(PersistentList<? extends T> persistentList, S7.k kVar) {
        PersistentList.Builder<? extends T> builder = persistentList.builder();
        kVar.invoke(builder);
        return builder.build();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.INSTANCE.emptyOf$runtime();
    }

    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.INSTANCE.emptyOf$runtime();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentCollection.addAll((Collection<? extends Object>) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.e0(iterable, builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        a.V(builder, iterable);
        return builder.build2();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E[] eArr) {
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.m0(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> mutate(PersistentMap<? extends K, ? extends V> persistentMap, S7.k kVar) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        kVar.invoke(builder);
        return builder.build2();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E[] eArr) {
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.g0(builder, eArr);
        return builder.build();
    }

    public static final <T> ImmutableList<T> toImmutableList(i iVar) {
        return toPersistentList(iVar);
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, i iVar) {
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.l0(builder, iVar);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, i iVar) {
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        A.f0(builder, iVar);
        return builder.build();
    }

    public static final ImmutableList<Character> toImmutableList(CharSequence charSequence) {
        return toPersistentList(charSequence);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(i iVar) {
        return toPersistentSet(iVar);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(i iVar) {
        return plus(persistentHashSetOf(), iVar);
    }

    public static final <T> PersistentList<T> toPersistentList(i iVar) {
        return plus(persistentListOf(), iVar);
    }

    public static final <T> PersistentSet<T> toPersistentSet(i iVar) {
        return plus(persistentSetOf(), iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E e) {
        return persistentList.remove((PersistentList<? extends E>) e);
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.INSTANCE.emptyOf$runtime();
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.INSTANCE.emptyOf$runtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E e) {
        return persistentList.add((PersistentList<? extends E>) e);
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V>[] pairArr) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        a.W(builder, pairArr);
        return builder.build2();
    }

    public static final PersistentSet<Character> toImmutableSet(CharSequence charSequence) {
        return toPersistentSet(charSequence);
    }

    public static final PersistentSet<Character> toPersistentHashSet(CharSequence charSequence) {
        PersistentSet.Builder builder = persistentHashSetOf().builder();
        m.Q0(charSequence, builder);
        return builder.build();
    }

    public static final PersistentList<Character> toPersistentList(CharSequence charSequence) {
        PersistentList.Builder builder = persistentListOf().builder();
        m.Q0(charSequence, builder);
        return builder.build();
    }

    public static final PersistentSet<Character> toPersistentSet(CharSequence charSequence) {
        PersistentSet.Builder builder = persistentSetOf().builder();
        m.Q0(charSequence, builder);
        return builder.build();
    }

    public static final <E> PersistentSet<E> intersect(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        return intersect(toPersistentSet(persistentCollection), (Iterable) iterable);
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentList.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.k0(iterable, builder);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentList.addAll((Collection<? extends Object>) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.e0(iterable, builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, i pairs) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        k.f(builder, "<this>");
        k.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builder.put((Object) pair.f4886a, (Object) pair.b);
        }
        return builder.build2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E e) {
        return persistentSet.remove((PersistentSet<? extends E>) e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E e) {
        return persistentSet.add((PersistentSet<? extends E>) e);
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentSet.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.k0(iterable, builder);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return persistentSet.addAll((Collection<? extends Object>) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.e0(iterable, builder);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K k) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.minus>");
        return persistentMap.remove((PersistentMap<? extends K, ? extends V>) k);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V> pair) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.plus>");
        return persistentMap.put((PersistentMap<? extends K, ? extends V>) pair.f4886a, (f) pair.b);
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E[] eArr) {
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.m0(builder, eArr);
        return builder.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, i iVar) {
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.l0(builder, iVar);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        return putAll(persistentMap, iterable);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V>[] pairArr) {
        return putAll(persistentMap, pairArr);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, i iVar) {
        return putAll(persistentMap, iVar);
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E[] eArr) {
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.m0(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        return putAll(persistentMap, map);
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E[] eArr) {
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.g0(builder, eArr);
        return builder.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, i iVar) {
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.l0(builder, iVar);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, i iVar) {
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        A.f0(builder, iVar);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends K> iterable) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        A.k0(iterable, builder.keySet());
        return builder.build2();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E[] eArr) {
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.g0(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K[] kArr) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        A.m0(builder.keySet(), kArr);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, i iVar) {
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        A.f0(builder, iVar);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, i iVar) {
        k.d(persistentMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        A.l0(builder.keySet(), iVar);
        return builder.build2();
    }
}
