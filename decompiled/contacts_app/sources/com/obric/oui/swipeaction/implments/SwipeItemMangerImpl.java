package com.obric.oui.swipeaction.implments;

import android.view.View;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.SimpleSwipeListener;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SwipeItemMangerImpl implements SwipeItemMangerInterface {
    public final int INVALID_POSITION;
    protected int mOpenPosition;
    protected Set<Integer> mOpenPositions;
    protected Set<OSwipeLayout> mShownLayouts;
    private Attributes.Mode mode;
    protected SwipeAdapterInterface swipeAdapterInterface;

    class OnLayoutListener implements OSwipeLayout.OnLayout {
        private int position;
        final /* synthetic */ SwipeItemMangerImpl this$0;

        OnLayoutListener(SwipeItemMangerImpl r1, int r2) {
            this.this$0 = r1;
            this.position = r2;
        }

        public void setPosition(int r1) {
            this.position = r1;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.OnLayout
        public void onLayout(OSwipeLayout r2) {
            if (this.this$0.isOpen(this.position) == false) goto L5;
            r2.open(false, false);
            return;
        L5:
            r2.close(false, false);
        }
    }

    class SwipeMemory extends SimpleSwipeListener {
        private int position;
        final /* synthetic */ SwipeItemMangerImpl this$0;

        SwipeMemory(SwipeItemMangerImpl r1, int r2) {
            this.this$0 = r1;
            this.position = r2;
        }

        @Override // com.obric.oui.swipeaction.SimpleSwipeListener, com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onClose(OSwipeLayout r2) {
            if (SwipeItemMangerImpl.access$000(this.this$0) != Attributes.Mode.Multiple) goto L5;
            this.this$0.mOpenPositions.remove(Integer.valueOf(this.position));
            return;
        L5:
            this.this$0.mOpenPosition = -1;
        }

        @Override // com.obric.oui.swipeaction.SimpleSwipeListener, com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onStartOpen(OSwipeLayout r3) {
            if (SwipeItemMangerImpl.access$000(this.this$0) != Attributes.Mode.Single) goto L6;
            this.this$0.closeAllExcept(r3);
            return;
        }

        @Override // com.obric.oui.swipeaction.SimpleSwipeListener, com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
        public void onOpen(OSwipeLayout r3) {
            if (SwipeItemMangerImpl.access$000(this.this$0) != Attributes.Mode.Multiple) goto L5;
            this.this$0.mOpenPositions.add(Integer.valueOf(this.position));
            return;
        L5:
            this.this$0.closeAllExcept(r3);
            SwipeItemMangerImpl r4 = this.this$0;
            r4.mOpenPosition = this.position;
        }

        public void setPosition(int r1) {
            this.position = r1;
        }
    }

    class ValueBox {
        OnLayoutListener onLayoutListener;
        int position;
        SwipeMemory swipeMemory;
        final /* synthetic */ SwipeItemMangerImpl this$0;

        ValueBox(SwipeItemMangerImpl r1, int r2, SwipeMemory r3, OnLayoutListener r4) {
            this.this$0 = r1;
            this.swipeMemory = r3;
            this.onLayoutListener = r4;
            this.position = r2;
        }
    }

    static /* synthetic */ Attributes.Mode access$000(SwipeItemMangerImpl r0) {
        return r0.mode;
    }

    public SwipeItemMangerImpl(SwipeAdapterInterface r2) {
        this.mode = Attributes.Mode.Single;
        this.INVALID_POSITION = -1;
        this.mOpenPosition = -1;
        this.mOpenPositions = new HashSet();
        this.mShownLayouts = new HashSet();
        if (r2 == null) goto L7;
        this.swipeAdapterInterface = r2;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public Attributes.Mode getMode() {
        return this.mode;
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void setMode(Attributes.Mode r1) {
        this.mode = r1;
        this.mOpenPositions.clear();
        this.mShownLayouts.clear();
        this.mOpenPosition = -1;
    }

    public void bind(View r5, int r6) {
        int r0 = this.swipeAdapterInterface.getSwipeLayoutResourceId(r6);
        OSwipeLayout r7 = (OSwipeLayout) r5.findViewById(r0);
        if (r7 == null) goto L10;
        if (r7.getTag(r0) != null) goto L7;
        OnLayoutListener r1 = new OnLayoutListener(this, r6);
        SwipeMemory r2 = new SwipeMemory(this, r6);
        r7.addSwipeListener(r2);
        r7.addOnLayoutListener(r1);
        r7.setTag(r0, new ValueBox(this, r6, r2, r1));
        this.mShownLayouts.add(r7);
        return;
    L7:
        ValueBox r4 = (ValueBox) r7.getTag(r0);
        r4.swipeMemory.setPosition(r6);
        r4.onLayoutListener.setPosition(r6);
        r4.position = r6;
        return;
    L10:
        throw new IllegalStateException("can not find SwipeLayout in target view");
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void openItem(int r3) {
        if (this.mode == Attributes.Mode.Multiple) goto L5;
        this.mOpenPosition = r3;
    L8:
        this.swipeAdapterInterface.notifyDatasetChanged();
        return;
    L5:
        if (this.mOpenPositions.contains(Integer.valueOf(r3)) == true) goto L8;
        this.mOpenPositions.add(Integer.valueOf(r3));
        goto L8
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeItem(int r3) {
        if (this.mode != Attributes.Mode.Multiple) goto L6;
        this.mOpenPositions.remove(Integer.valueOf(r3));
    L8:
        this.swipeAdapterInterface.notifyDatasetChanged();
        return;
    L6:
        if (this.mOpenPosition != r3) goto L8;
        this.mOpenPosition = -1;
        goto L8
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllExcept(OSwipeLayout r2) {
        Iterator<OSwipeLayout> r1 = this.mShownLayouts.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        OSwipeLayout r0 = r1.next();
        if (r0 == r2) goto L4;
        r0.close();
        goto L4
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllItems() {
        if (this.mode != Attributes.Mode.Multiple) goto L5;
        this.mOpenPositions.clear();
    L6:
        Iterator<OSwipeLayout> r2 = this.mShownLayouts.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().close();
        goto L8
    L10:
        return;
    L5:
        this.mOpenPosition = -1;
        goto L6
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void removeShownLayouts(OSwipeLayout r1) {
        this.mShownLayouts.remove(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<Integer> getOpenItems() {
        if (this.mode != Attributes.Mode.Multiple) goto L7;
        return new ArrayList(this.mOpenPositions);
    L7:
        return Collections.singletonList(Integer.valueOf(this.mOpenPosition));
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<OSwipeLayout> getOpenLayouts() {
        return new ArrayList(this.mShownLayouts);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public boolean isOpen(int r3) {
        if (this.mode != Attributes.Mode.Multiple) goto L7;
        return this.mOpenPositions.contains(Integer.valueOf(r3));
    L7:
        if (this.mOpenPosition != r3) goto L9;
        return true;
    L9:
        return false;
    }
}
