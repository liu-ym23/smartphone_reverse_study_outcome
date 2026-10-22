package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class RangeLayoutHelperFinder extends LayoutHelperFinder {

    @NonNull
    private Comparator<LayoutHelperItem> mLayoutHelperItemComparator;

    @NonNull
    private List<LayoutHelperItem> mLayoutHelperItems;

    @NonNull
    private List<LayoutHelper> mLayoutHelpers;

    public static class LayoutHelperItem {
        LayoutHelper layoutHelper;

        public LayoutHelperItem(LayoutHelper r10) {
            this.layoutHelper = r10;
        }

        public int getEndPosition() {
            return ((Integer) this.layoutHelper.getRange().getUpper()).intValue();
        }

        public int getStartPosition() {
            return ((Integer) this.layoutHelper.getRange().getLower()).intValue();
        }
    }

    public RangeLayoutHelperFinder() {
        this.mLayoutHelperItems = new LinkedList();
        this.mLayoutHelpers = new LinkedList();
        this.mLayoutHelperItemComparator = new AnonymousClass1(this);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelperFinder
    @Nullable
    public LayoutHelper getLayoutHelper(int r10) {
        int r11 = this.mLayoutHelperItems.size();
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r12 = r11 - 1;
        int r13 = 0;
    L6:
        if (r13 > r12) goto L18;
        int r14 = (r13 + r12) / 2;
        LayoutHelperItem r15 = this.mLayoutHelperItems.get(r14);
        if (r15.getStartPosition() > r10) goto L9;
        if (r15.getEndPosition() < r10) goto L12;
        if (r15.getStartPosition() > r10) goto L6;
        if (r15.getEndPosition() < r10) goto L6;
    L19:
        if (r15 != null) goto L22;
        return null;
    L22:
        return r15.layoutHelper;
    L12:
        r13 = r14 + 1;
        goto L6
    L9:
        r12 = r14 - 1;
        goto L6
    L18:
        r15 = null;
        goto L19
    }

    @Override // com.alibaba.android.vlayout.LayoutHelperFinder
    @NonNull
    public List<LayoutHelper> getLayoutHelpers() {
        return Collections.unmodifiableList(this.mLayoutHelpers);
    }

    @Override // java.lang.Iterable
    public Iterator<LayoutHelper> iterator() {
        return Collections.unmodifiableList(this.mLayoutHelpers).iterator();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelperFinder
    public Iterable<LayoutHelper> reverse() {
        List<LayoutHelper> r10 = this.mLayoutHelpers;
        final ListIterator<LayoutHelper> r11 = r10.listIterator(r10.size());
        return new AnonymousClass2(this, r11);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelperFinder
    public void setLayouts(@Nullable List<LayoutHelper> r10) {
        this.mLayoutHelpers.clear();
        this.mLayoutHelperItems.clear();
        if (r10 == null) goto L11;
        Iterator<LayoutHelper> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        LayoutHelper r12 = r11.next();
        this.mLayoutHelpers.add(r12);
        this.mLayoutHelperItems.add(new LayoutHelperItem(r12));
        goto L6
    L8:
        Collections.sort(this.mLayoutHelperItems, this.mLayoutHelperItemComparator);
        return;
    }
}
