package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u001d\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/list/UserTabList;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "", "(ILjava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserTabList<T> extends ArrayList<T> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public UserTabList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T r100) {
        if (contains(r100) == false) goto L7;
        return false;
    L7:
        return super.add(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        T r103 = r102.next();
        if ((!contains(r103)) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        if ((!r101.isEmpty()) == true) goto L12;
        r101 = null;
    L12:
        if (r101 != null) goto L21;
        return false;
    L21:
        return super.addAll(r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int r100) {
        return (T) removeAt(r100);
    }

    public /* bridge */ Object removeAt(int r100) {
        return super.remove(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r100, T r101) {
        if (contains(r101) == false) goto L5;
        return;
    L5:
        super.add(r100, r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        if ((!contains(r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        if ((!r102.isEmpty()) == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L21;
        return false;
    L21:
        return super.addAll(r100, r102);
    }
}
