package com.stepos.policy.sdk.widget;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.EnumC0493i;
import com.stepos.common.widget.NewMessageView;
import com.stepos.common.widget.Switch;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import i2.AbstractC0620a;
import java.util.ArrayList;
import stepos.support.v7.widget.X;

/* loaded from: classes.dex */
public class PolicyBasicRecyclerViewAdapter extends X {
    private Context mContext;
    private ArrayList<PolicyBasicListVO> mData;
    private int mMzThemeColor;

    public class BasicListViewHolder extends RecyclerView.ViewHolder {
        public TextView mDesc;
        public ImageView mIcon;
        public TextView mSubTitle;
        public TextView mTitle;

        public BasicListViewHolder(View view) {
            super(view);
            if (view.findViewById(R.id.text1) != null) {
                TextView textView = (TextView) view.findViewById(R.id.text1);
                this.mTitle = textView;
                textView.setVisibility(0);
            }
            if (view.findViewById(com.stepos.alphame.R.id.title) != null) {
                TextView textView2 = (TextView) view.findViewById(com.stepos.alphame.R.id.title);
                this.mTitle = textView2;
                textView2.setVisibility(0);
            }
            if (view.findViewById(com.stepos.alphame.R.id.descOne) != null) {
                this.mSubTitle = (TextView) view.findViewById(com.stepos.alphame.R.id.descOne);
            }
            if (view.findViewById(com.stepos.alphame.R.id.descTwo) != null) {
                this.mDesc = (TextView) view.findViewById(com.stepos.alphame.R.id.descTwo);
            }
            if (view.findViewById(com.stepos.alphame.R.id.icon) != null) {
                this.mIcon = (ImageView) view.findViewById(com.stepos.alphame.R.id.icon);
            }
        }
    }

    public PolicyBasicRecyclerViewAdapter(ArrayList<PolicyBasicListVO> arrayList, Context context) {
        new ArrayList();
        this.mData = arrayList;
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0620a.f13037s);
        this.mMzThemeColor = typedArrayObtainStyledAttributes.getInt(11, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        if (arrayList == null || arrayList.get(i4) == null) {
            return super.getItemViewType(i4);
        }
        boolean zIsHeader = this.mData.get(i4).isHeader();
        PolicyBasicListVO policyBasicListVO = this.mData.get(i4);
        return zIsHeader ? policyBasicListVO.getHeaderType() : policyBasicListVO.getTypeId();
    }

    @Override // stepos.support.v7.widget.l0
    public boolean isEnabled(int i4) {
        return getItemViewType(i4) != 30;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v17, types: [android.view.View] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BasicListViewHolder basicListViewHolder, @SuppressLint({"RecyclerView"}) int i4) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        CircularProgressButton circularProgressButton;
        View view;
        TextView textView;
        String str;
        ViewGroup viewGroup;
        View.OnClickListener onClickListener3;
        View viewFindViewById;
        View view2 = basicListViewHolder.itemView;
        View viewFindViewById2 = view2.findViewById(com.stepos.alphame.R.id.divider);
        getItemViewType(i4);
        if (viewFindViewById2 == null || (viewFindViewById = view2.findViewById(com.stepos.alphame.R.id.list_item_split)) == null) {
            view2.setBackground(view2.getContext().getDrawable(com.stepos.alphame.R.drawable.stepos_recyclerview_selector_f10));
        } else {
            viewFindViewById.setBackground(view2.getContext().getDrawable(com.stepos.alphame.R.drawable.stepos_recyclerview_selector_f10));
        }
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        if (arrayList == null || arrayList.get(i4) == null) {
            return;
        }
        if (basicListViewHolder.mTitle != null && this.mData.get(i4).getTitle() != null) {
            basicListViewHolder.mTitle.setText(this.mData.get(i4).getTitle());
        }
        if (basicListViewHolder.mSubTitle == null || this.mData.get(i4).getSubTitle() == null) {
            TextView textView2 = basicListViewHolder.mSubTitle;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            basicListViewHolder.mSubTitle.setText(this.mData.get(i4).getSubTitle());
            basicListViewHolder.mSubTitle.setVisibility(0);
        }
        if (basicListViewHolder.mDesc != null && this.mData.get(i4).getDesc() != null) {
            basicListViewHolder.mDesc.setText(this.mData.get(i4).getDesc());
        }
        if (basicListViewHolder.mIcon != null && this.mData.get(i4).getIcon() != null) {
            if (this.mData.get(i4).getIcon() instanceof Integer) {
                basicListViewHolder.mIcon.setBackgroundResource(((Integer) this.mData.get(i4).getIcon()).intValue());
            } else if (this.mData.get(i4).getIcon() instanceof Bitmap) {
                basicListViewHolder.mIcon.setImageBitmap((Bitmap) this.mData.get(i4).getIcon());
            }
        }
        if (getItemViewType(i4) == 11) {
            viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item);
            final NewMessageView newMessageView = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.title_new_message_point);
            newMessageView.setHide(false);
            onClickListener3 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    NewMessageView newMessageView2 = newMessageView;
                    newMessageView2.setHide(!newMessageView2.f11709a);
                }
            };
        } else if (getItemViewType(i4) == 12) {
            viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item);
            final NewMessageView newMessageView2 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.title_new_message_number);
            newMessageView2.setNewMessageNum(8);
            onClickListener3 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    newMessageView2.setNewMessageNum(newMessageView2.getNewMessageNum().intValue() == 0 ? 8 : 0);
                }
            };
        } else if (getItemViewType(i4) == 13) {
            viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item);
            final NewMessageView newMessageView3 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.arrow_right_new_message_point);
            newMessageView3.setHide(false);
            onClickListener3 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    NewMessageView newMessageView4 = newMessageView3;
                    newMessageView4.setHide(!newMessageView4.f11709a);
                }
            };
        } else {
            if (getItemViewType(i4) != 14) {
                if (getItemViewType(i4) == 32) {
                    textView = (TextView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.arrow_right_number_message);
                    str = "推荐内容";
                } else {
                    if (getItemViewType(i4) == 30) {
                        return;
                    }
                    if (getItemViewType(i4) == 33) {
                        textView = (TextView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.arrow_right_number_message);
                        str = "限时5折优惠";
                    } else if (getItemViewType(i4) == 31) {
                        textView = (TextView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.arrow_right_number_message);
                        str = "2";
                    } else {
                        if (getItemViewType(i4) != 10) {
                            if (getItemViewType(i4) != 3) {
                                if (getItemViewType(i4) == 4) {
                                    final CheckBox checkBox = (CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.check_box);
                                    ?? r9 = basicListViewHolder.itemView;
                                    onClickListener = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.6
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view3) {
                                            checkBox.setChecked(!r0.isChecked());
                                        }
                                    };
                                    circularProgressButton = r9;
                                } else if (getItemViewType(i4) == 5) {
                                    ((CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.check_box)).setChecked(true);
                                    final CheckBox checkBox2 = (CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.check_box);
                                    ?? r92 = basicListViewHolder.itemView;
                                    onClickListener = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.7
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view3) {
                                            checkBox2.setChecked(!r0.isChecked());
                                        }
                                    };
                                    circularProgressButton = r92;
                                } else if (getItemViewType(i4) == 35) {
                                    ((CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.check_box)).setChecked(true);
                                    View viewFindViewById3 = basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item_split);
                                    onClickListener2 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.8
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view3) {
                                        }
                                    };
                                    view = viewFindViewById3;
                                } else {
                                    if (getItemViewType(i4) == 6) {
                                        return;
                                    }
                                    if (getItemViewType(i4) == 34) {
                                        View viewFindViewById4 = basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item_split);
                                        onClickListener2 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.9
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view3) {
                                            }
                                        };
                                        view = viewFindViewById4;
                                    } else {
                                        if (getItemViewType(i4) == 7) {
                                            final Switch r10 = (Switch) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.switch1);
                                            ((Switch) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.switch1)).setChecked(true);
                                            view2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.10
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view3) {
                                                    r10.setChecked(!r0.isChecked());
                                                }
                                            });
                                            return;
                                        }
                                        if (getItemViewType(i4) == 8) {
                                            CircularProgressButton circularProgressButton2 = (CircularProgressButton) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.circularbutton);
                                            circularProgressButton2.setIndeterminateProgressMode(true);
                                            circularProgressButton2.t(EnumC0493i.f11911a, false);
                                            circularProgressButton2.setShowCenterIcon(true);
                                            return;
                                        }
                                        if (getItemViewType(i4) == 41 || getItemViewType(i4) == 42) {
                                            ((ImageView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.stepos_cancel_icon)).setVisibility(0);
                                            return;
                                        }
                                        if (getItemViewType(i4) != 9) {
                                            return;
                                        }
                                        final CircularProgressButton circularProgressButton3 = (CircularProgressButton) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.circularbutton1);
                                        circularProgressButton3.setShowCenterIcon(true);
                                        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 101);
                                        valueAnimatorOfInt.setDuration(5000L);
                                        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
                                        onClickListener = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view3) {
                                                EnumC0493i state = circularProgressButton3.getState();
                                                EnumC0493i enumC0493i = EnumC0493i.f11912b;
                                                if (state != enumC0493i) {
                                                    if (valueAnimatorOfInt.isRunning()) {
                                                        valueAnimatorOfInt.cancel();
                                                    }
                                                    circularProgressButton3.t(enumC0493i, true);
                                                } else {
                                                    circularProgressButton3.t(EnumC0493i.f11911a, true);
                                                    circularProgressButton3.setIndeterminateProgressMode(false);
                                                    valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11.1
                                                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                            Integer num = (Integer) valueAnimator.getAnimatedValue();
                                                            if (num.intValue() == 101) {
                                                                circularProgressButton3.t(EnumC0493i.f11913c, true);
                                                            }
                                                            circularProgressButton3.setProgressForState(num.intValue());
                                                        }
                                                    });
                                                    valueAnimatorOfInt.start();
                                                }
                                            }
                                        };
                                        circularProgressButton = circularProgressButton3;
                                    }
                                }
                                circularProgressButton.setOnClickListener(onClickListener);
                                return;
                            }
                            final CheckedTextView checkedTextView = (CheckedTextView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.title);
                            checkedTextView.setChecked(true);
                            onClickListener2 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.5
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    checkedTextView.toggle();
                                }
                            };
                            view = checkedTextView;
                            view.setOnClickListener(onClickListener2);
                            return;
                        }
                        textView = (TextView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.textlink);
                        str = "链接文字";
                    }
                }
                textView.setText(str);
                return;
            }
            viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.list_item);
            final NewMessageView newMessageView4 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.alphame.R.id.arrow_right_new_message_number);
            newMessageView4.setNewMessageNum(8);
            onClickListener3 = new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    newMessageView4.setNewMessageNum(newMessageView4.getNewMessageNum().intValue() == 0 ? 8 : 0);
                }
            };
        }
        viewGroup.setOnClickListener(onClickListener3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.BasicListViewHolder onCreateViewHolder(android.view.ViewGroup r4, int r5) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.onCreateViewHolder(android.view.ViewGroup, int):com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter$BasicListViewHolder");
    }
}
