package x2;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public abstract class c extends StepOSRecyclerView.c<RecyclerView.ViewHolder> {
    private void j(int i5, View view) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag();
        int iIntValue = tag instanceof Integer ? ((Integer) tag).intValue() : 0;
        boolean z5 = (iIntValue & 1) == 1;
        boolean z6 = (iIntValue & 2) == 2;
        Context context = view.getContext();
        int iB = T1.g.b(context, R.attr.marginSmall);
        int iB2 = T1.g.b(context, R.attr.marginSmall);
        int paddingTop = view.getPaddingTop();
        int paddingStart = view.getPaddingStart();
        int paddingBottom = view.getPaddingBottom();
        int paddingEnd = view.getPaddingEnd();
        if (z5) {
            if (i5 == 2 || i5 == 1) {
                paddingTop -= iB;
            }
        } else if (i5 != 2 && i5 != 1) {
            paddingTop += iB;
        }
        if (z6) {
            if (i5 == 0 || i5 == 1) {
                paddingBottom -= iB2;
            }
        } else if (i5 != 0 && i5 != 1) {
            paddingBottom += iB2;
        }
        if (i5 == 3) {
            view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
            view.setTag(3);
            return;
        }
        if (i5 == 0) {
            view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
            view.setTag(1);
        } else if (i5 == 2) {
            view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
            view.setTag(2);
        } else if (i5 == 1) {
            view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
            view.setTag(0);
        }
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
        super.onBindViewHolder(viewHolder, i5);
        j(immersiveItemType(i5), viewHolder.itemView);
    }
}
