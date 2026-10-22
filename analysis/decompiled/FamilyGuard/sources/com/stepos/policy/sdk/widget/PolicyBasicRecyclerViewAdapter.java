package com.stepos.policy.sdk.widget;

import H1.g;
import H1.h;
import H1.i;
import H1.m;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.ImageFontCompatView;
import com.stepos.common.widget.NewMessageView;
import com.stepos.common.widget.Switch;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import com.stepos.policy.sdk.r;
import java.util.ArrayList;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public class PolicyBasicRecyclerViewAdapter extends StepOSRecyclerView.c<BasicListViewHolder> {
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
            int i5 = h.f2276t0;
            if (view.findViewById(i5) != null) {
                TextView textView2 = (TextView) view.findViewById(i5);
                this.mTitle = textView2;
                textView2.setVisibility(0);
            }
            int i6 = h.f2263n;
            if (view.findViewById(i6) != null) {
                this.mSubTitle = (TextView) view.findViewById(i6);
            }
            int i7 = h.f2265o;
            if (view.findViewById(i7) != null) {
                this.mDesc = (TextView) view.findViewById(i7);
            }
            int i8 = h.f2281w;
            if (view.findViewById(i8) != null) {
                this.mIcon = (ImageView) view.findViewById(i8);
            }
        }
    }

    public PolicyBasicRecyclerViewAdapter(ArrayList<PolicyBasicListVO> arrayList, Context context) {
        new ArrayList();
        this.mData = arrayList;
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(m.p6);
        this.mMzThemeColor = typedArrayObtainStyledAttributes.getInt(m.q6, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean isValidPosition(int i5) {
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        return arrayList != null && i5 >= 0 && i5 < arrayList.size() && this.mData.get(i5) != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (!isValidPosition(i5)) {
            return super.getItemViewType(i5);
        }
        PolicyBasicListVO policyBasicListVO = this.mData.get(i5);
        return policyBasicListVO.isHeader() ? policyBasicListVO.getHeaderType() : policyBasicListVO.getTypeId();
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, stepos.support.v7.widget.StepOSRecyclerView.u
    public boolean isEnabled(int i5) {
        return isValidPosition(i5) && getItemViewType(i5) != 30 && super.isEnabled(i5);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BasicListViewHolder basicListViewHolder, int i5) {
        View viewFindViewById;
        View view = basicListViewHolder.itemView;
        View viewFindViewById2 = view.findViewById(h.f2267p);
        getItemViewType(i5);
        if (viewFindViewById2 == null || (viewFindViewById = view.findViewById(h.f2211A)) == null) {
            view.setBackground(view.getContext().getDrawable(g.f2168D));
        } else {
            viewFindViewById.setBackground(view.getContext().getDrawable(g.f2168D));
        }
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        if (arrayList == null || arrayList.get(i5) == null) {
            return;
        }
        if (basicListViewHolder.mTitle != null && this.mData.get(i5).getTitle() != null) {
            basicListViewHolder.mTitle.setText(this.mData.get(i5).getTitle());
        }
        if (basicListViewHolder.mSubTitle == null || this.mData.get(i5).getSubTitle() == null) {
            TextView textView = basicListViewHolder.mSubTitle;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            basicListViewHolder.mSubTitle.setText(this.mData.get(i5).getSubTitle());
            basicListViewHolder.mSubTitle.setVisibility(0);
        }
        if (basicListViewHolder.mDesc != null && this.mData.get(i5).getDesc() != null) {
            basicListViewHolder.mDesc.setText(this.mData.get(i5).getDesc());
        }
        if (basicListViewHolder.mIcon != null && this.mData.get(i5).getIcon() != null) {
            if (this.mData.get(i5).getIcon() instanceof Integer) {
                basicListViewHolder.mIcon.setBackgroundResource(((Integer) this.mData.get(i5).getIcon()).intValue());
            } else if (this.mData.get(i5).getIcon() instanceof Bitmap) {
                basicListViewHolder.mIcon.setImageBitmap((Bitmap) this.mData.get(i5).getIcon());
            }
        }
        if (getItemViewType(i5) == 11) {
            ViewGroup viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(h.f2286z);
            final NewMessageView newMessageView = (NewMessageView) basicListViewHolder.itemView.findViewById(h.f2282w0);
            newMessageView.setHide(false);
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (newMessageView.c()) {
                        newMessageView.setHide(false);
                    } else {
                        newMessageView.setHide(true);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i5) == 12) {
            ViewGroup viewGroup2 = (ViewGroup) basicListViewHolder.itemView.findViewById(h.f2286z);
            final NewMessageView newMessageView2 = (NewMessageView) basicListViewHolder.itemView.findViewById(h.f2280v0);
            newMessageView2.setNewMessageNum(8);
            viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (newMessageView2.getNewMessageNum().intValue() == 0) {
                        newMessageView2.setNewMessageNum(8);
                    } else {
                        newMessageView2.setNewMessageNum(0);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i5) == 13) {
            ViewGroup viewGroup3 = (ViewGroup) basicListViewHolder.itemView.findViewById(h.f2286z);
            final NewMessageView newMessageView3 = (NewMessageView) basicListViewHolder.itemView.findViewById(h.f2247f);
            newMessageView3.setHide(false);
            viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (newMessageView3.c()) {
                        newMessageView3.setHide(false);
                    } else {
                        newMessageView3.setHide(true);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i5) == 14) {
            ViewGroup viewGroup4 = (ViewGroup) basicListViewHolder.itemView.findViewById(h.f2286z);
            final NewMessageView newMessageView4 = (NewMessageView) basicListViewHolder.itemView.findViewById(h.f2245e);
            newMessageView4.setNewMessageNum(8);
            viewGroup4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (newMessageView4.getNewMessageNum().intValue() == 0) {
                        newMessageView4.setNewMessageNum(8);
                    } else {
                        newMessageView4.setNewMessageNum(0);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i5) == 32) {
            ((TextView) basicListViewHolder.itemView.findViewById(h.f2249g)).setText("推荐内容");
            return;
        }
        if (getItemViewType(i5) == 30) {
            return;
        }
        if (getItemViewType(i5) == 33) {
            ((TextView) basicListViewHolder.itemView.findViewById(h.f2249g)).setText("限时5折优惠");
            return;
        }
        if (getItemViewType(i5) == 31) {
            ((TextView) basicListViewHolder.itemView.findViewById(h.f2249g)).setText("2");
            return;
        }
        if (getItemViewType(i5) == 10) {
            ((TextView) basicListViewHolder.itemView.findViewById(h.f2270q0)).setText("链接文字");
            return;
        }
        if (getItemViewType(i5) == 3) {
            final CheckedTextView checkedTextView = (CheckedTextView) basicListViewHolder.itemView.findViewById(h.f2276t0);
            checkedTextView.setChecked(true);
            checkedTextView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    checkedTextView.toggle();
                }
            });
            return;
        }
        if (getItemViewType(i5) == 4) {
            final CheckBox checkBox = (CheckBox) basicListViewHolder.itemView.findViewById(h.f2251h);
            basicListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    checkBox.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i5) == 5) {
            View view2 = basicListViewHolder.itemView;
            int i6 = h.f2251h;
            ((CheckBox) view2.findViewById(i6)).setChecked(true);
            final CheckBox checkBox2 = (CheckBox) basicListViewHolder.itemView.findViewById(i6);
            basicListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    checkBox2.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i5) == 35) {
            ((CheckBox) basicListViewHolder.itemView.findViewById(h.f2251h)).setChecked(true);
            basicListViewHolder.itemView.findViewById(h.f2211A).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                }
            });
            return;
        }
        if (getItemViewType(i5) == 6) {
            return;
        }
        if (getItemViewType(i5) == 34) {
            basicListViewHolder.itemView.findViewById(h.f2211A).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                }
            });
            return;
        }
        if (getItemViewType(i5) == 7) {
            View view3 = basicListViewHolder.itemView;
            int i7 = h.f2264n0;
            final Switch r8 = (Switch) view3.findViewById(i7);
            ((Switch) basicListViewHolder.itemView.findViewById(i7)).setChecked(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    r8.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i5) == 8) {
            CircularProgressButton circularProgressButton = (CircularProgressButton) basicListViewHolder.itemView.findViewById(h.f2253i);
            circularProgressButton.setIndeterminateProgressMode(true);
            circularProgressButton.d0(CircularProgressButton.l.PROGRESS, false, false);
            circularProgressButton.setShowCenterIcon(true);
            return;
        }
        if (getItemViewType(i5) == 41 || getItemViewType(i5) == 42) {
            ((ImageView) basicListViewHolder.itemView.findViewById(h.f2250g0)).setVisibility(0);
            return;
        }
        if (getItemViewType(i5) == 9) {
            final CircularProgressButton circularProgressButton2 = (CircularProgressButton) basicListViewHolder.itemView.findViewById(h.f2255j);
            circularProgressButton2.setShowCenterIcon(true);
            final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 101);
            valueAnimatorOfInt.setDuration(5000L);
            valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            circularProgressButton2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    CircularProgressButton.l state = circularProgressButton2.getState();
                    CircularProgressButton.l lVar = CircularProgressButton.l.IDLE;
                    if (state != lVar) {
                        if (valueAnimatorOfInt.isRunning()) {
                            valueAnimatorOfInt.cancel();
                        }
                        circularProgressButton2.d0(lVar, true, true);
                    } else {
                        circularProgressButton2.d0(CircularProgressButton.l.PROGRESS, true, true);
                        circularProgressButton2.setIndeterminateProgressMode(false);
                        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Integer num = (Integer) valueAnimator.getAnimatedValue();
                                if (num.intValue() == 101) {
                                    circularProgressButton2.d0(CircularProgressButton.l.COMPLETE, true, false);
                                }
                                circularProgressButton2.setProgressForState(num.intValue());
                            }
                        });
                        valueAnimatorOfInt.start();
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BasicListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        View viewInflate;
        if (i5 != 100) {
            switch (i5) {
                case 0:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2292F, viewGroup, false);
                    break;
                case 1:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2328s, viewGroup, false);
                    viewInflate.setEnabled(false);
                    ((TextView) viewInflate.findViewById(h.f2276t0)).setEnabled(false);
                    ((ImageFontCompatView) viewInflate.findViewById(h.f2243d)).setEnabled(false);
                    break;
                case 2:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2297K, viewGroup, false);
                    break;
                case 3:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2289C, viewGroup, false);
                    break;
                case 4:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2287A, viewGroup, false);
                    break;
                case 5:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2287A, viewGroup, false);
                    break;
                case 6:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2288B, viewGroup, false);
                    break;
                case 7:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2295I, viewGroup, false);
                    break;
                case 8:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2290D, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2335z, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2296J, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2294H, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2293G, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2332w, viewGroup, false);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2331v, viewGroup, false);
                    break;
                default:
                    switch (i5) {
                        case 16:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2326q, viewGroup, false);
                            break;
                        case 17:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2324o, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2327r, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2326q, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2322m, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2323n, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2321l, viewGroup, false);
                            break;
                        case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2320k, viewGroup, false);
                            break;
                        default:
                            switch (i5) {
                                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.f2300N, viewGroup, false);
                                    break;
                                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.f2301O, viewGroup, false);
                                    break;
                                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i.f2302P, viewGroup, false);
                                    break;
                                default:
                                    switch (i5) {
                                        case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2299M, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2333x, viewGroup, false);
                                            break;
                                        case 32:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2334y, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2330u, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2329t, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2329t, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2291E, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2325p, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2324o, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2325p, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2306T, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2306T, viewGroup, false);
                                            break;
                                        case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(i.f2306T, viewGroup, false);
                                            break;
                                        default:
                                            viewInflate = null;
                                            break;
                                    }
                            }
                    }
            }
        } else {
            viewInflate = LayoutInflater.from(this.mContext).inflate(r.f15815c, viewGroup, false);
        }
        if (viewInflate == null) {
            return null;
        }
        return new BasicListViewHolder(viewInflate);
    }
}
