package com.stepos.policy.sdk.widget;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PolicyBasicRecyclerViewAdapter extends StepOSRecyclerView.a<BasicListViewHolder> {
    private Context mContext;
    private ArrayList<PolicyBasicListVO> mData;
    private int mMzThemeColor;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            if (view.findViewById(com.stepos.aiengine.R.id.title) != null) {
                TextView textView2 = (TextView) view.findViewById(com.stepos.aiengine.R.id.title);
                this.mTitle = textView2;
                textView2.setVisibility(0);
            }
            if (view.findViewById(com.stepos.aiengine.R.id.descOne) != null) {
                this.mSubTitle = (TextView) view.findViewById(com.stepos.aiengine.R.id.descOne);
            }
            if (view.findViewById(com.stepos.aiengine.R.id.descTwo) != null) {
                this.mDesc = (TextView) view.findViewById(com.stepos.aiengine.R.id.descTwo);
            }
            if (view.findViewById(com.stepos.aiengine.R.id.icon) != null) {
                this.mIcon = (ImageView) view.findViewById(com.stepos.aiengine.R.id.icon);
            }
        }
    }

    public PolicyBasicRecyclerViewAdapter(ArrayList<PolicyBasicListVO> arrayList, Context context) {
        new ArrayList();
        this.mData = arrayList;
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g8.a.f9091s);
        this.mMzThemeColor = typedArrayObtainStyledAttributes.getInt(11, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean isValidPosition(int i10) {
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        return arrayList != null && i10 >= 0 && i10 < arrayList.size() && this.mData.get(i10) != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (!isValidPosition(i10)) {
            return super.getItemViewType(i10);
        }
        PolicyBasicListVO policyBasicListVO = this.mData.get(i10);
        return policyBasicListVO.isHeader() ? policyBasicListVO.getHeaderType() : policyBasicListVO.getTypeId();
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, stepos.support.v7.widget.StepOSRecyclerView.s
    public boolean isEnabled(int i10) {
        return isValidPosition(i10) && getItemViewType(i10) != 30 && super.isEnabled(i10);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BasicListViewHolder basicListViewHolder, @SuppressLint({"RecyclerView"}) int i10) {
        View viewFindViewById;
        View view = basicListViewHolder.itemView;
        View viewFindViewById2 = view.findViewById(com.stepos.aiengine.R.id.divider);
        getItemViewType(i10);
        if (viewFindViewById2 == null || (viewFindViewById = view.findViewById(com.stepos.aiengine.R.id.list_item_split)) == null) {
            view.setBackground(view.getContext().getDrawable(com.stepos.aiengine.R.drawable.stepos_recyclerview_selector_f10));
        } else {
            viewFindViewById.setBackground(view.getContext().getDrawable(com.stepos.aiengine.R.drawable.stepos_recyclerview_selector_f10));
        }
        ArrayList<PolicyBasicListVO> arrayList = this.mData;
        if (arrayList == null || arrayList.get(i10) == null) {
            return;
        }
        if (basicListViewHolder.mTitle != null && this.mData.get(i10).getTitle() != null) {
            basicListViewHolder.mTitle.setText(this.mData.get(i10).getTitle());
        }
        if (basicListViewHolder.mSubTitle == null || this.mData.get(i10).getSubTitle() == null) {
            TextView textView = basicListViewHolder.mSubTitle;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            basicListViewHolder.mSubTitle.setText(this.mData.get(i10).getSubTitle());
            basicListViewHolder.mSubTitle.setVisibility(0);
        }
        if (basicListViewHolder.mDesc != null && this.mData.get(i10).getDesc() != null) {
            basicListViewHolder.mDesc.setText(this.mData.get(i10).getDesc());
        }
        if (basicListViewHolder.mIcon != null && this.mData.get(i10).getIcon() != null) {
            if (this.mData.get(i10).getIcon() instanceof Integer) {
                basicListViewHolder.mIcon.setBackgroundResource(((Integer) this.mData.get(i10).getIcon()).intValue());
            } else if (this.mData.get(i10).getIcon() instanceof Bitmap) {
                basicListViewHolder.mIcon.setImageBitmap((Bitmap) this.mData.get(i10).getIcon());
            }
        }
        if (getItemViewType(i10) == 11) {
            ViewGroup viewGroup = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item);
            final NewMessageView newMessageView = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.title_new_message_point);
            newMessageView.setHide(false);
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    NewMessageView newMessageView2 = newMessageView;
                    if (newMessageView2.f6954a) {
                        newMessageView2.setHide(false);
                    } else {
                        newMessageView2.setHide(true);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i10) == 12) {
            ViewGroup viewGroup2 = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item);
            final NewMessageView newMessageView2 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.title_new_message_number);
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
        if (getItemViewType(i10) == 13) {
            ViewGroup viewGroup3 = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item);
            final NewMessageView newMessageView3 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.arrow_right_new_message_point);
            newMessageView3.setHide(false);
            viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    NewMessageView newMessageView4 = newMessageView3;
                    if (newMessageView4.f6954a) {
                        newMessageView4.setHide(false);
                    } else {
                        newMessageView4.setHide(true);
                    }
                }
            });
            return;
        }
        if (getItemViewType(i10) == 14) {
            ViewGroup viewGroup4 = (ViewGroup) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item);
            final NewMessageView newMessageView4 = (NewMessageView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.arrow_right_new_message_number);
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
        if (getItemViewType(i10) == 32) {
            ((TextView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.arrow_right_number_message)).setText("推荐内容");
            return;
        }
        if (getItemViewType(i10) == 30) {
            return;
        }
        if (getItemViewType(i10) == 33) {
            ((TextView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.arrow_right_number_message)).setText("限时5折优惠");
            return;
        }
        if (getItemViewType(i10) == 31) {
            ((TextView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.arrow_right_number_message)).setText("2");
            return;
        }
        if (getItemViewType(i10) == 10) {
            ((TextView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.textlink)).setText("链接文字");
            return;
        }
        if (getItemViewType(i10) == 3) {
            final CheckedTextView checkedTextView = (CheckedTextView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.title);
            checkedTextView.setChecked(true);
            checkedTextView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    checkedTextView.toggle();
                }
            });
            return;
        }
        if (getItemViewType(i10) == 4) {
            final CheckBox checkBox = (CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.check_box);
            basicListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    checkBox.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i10) == 5) {
            ((CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.check_box)).setChecked(true);
            final CheckBox checkBox2 = (CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.check_box);
            basicListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    checkBox2.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i10) == 35) {
            ((CheckBox) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.check_box)).setChecked(true);
            basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item_split).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            return;
        }
        if (getItemViewType(i10) == 6) {
            return;
        }
        if (getItemViewType(i10) == 34) {
            basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.list_item_split).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            return;
        }
        if (getItemViewType(i10) == 7) {
            final Switch r10 = (Switch) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.switch1);
            ((Switch) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.switch1)).setChecked(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    r10.setChecked(!r0.isChecked());
                }
            });
            return;
        }
        if (getItemViewType(i10) == 8) {
            CircularProgressButton circularProgressButton = (CircularProgressButton) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.circularbutton);
            circularProgressButton.setIndeterminateProgressMode(true);
            circularProgressButton.t(CircularProgressButton.State.f6802a, false);
            circularProgressButton.setShowCenterIcon(true);
            return;
        }
        if (getItemViewType(i10) == 41 || getItemViewType(i10) == 42) {
            ((ImageView) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.stepos_cancel_icon)).setVisibility(0);
            return;
        }
        if (getItemViewType(i10) == 9) {
            final CircularProgressButton circularProgressButton2 = (CircularProgressButton) basicListViewHolder.itemView.findViewById(com.stepos.aiengine.R.id.circularbutton1);
            circularProgressButton2.setShowCenterIcon(true);
            final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 101);
            valueAnimatorOfInt.setDuration(FileStorageUploader.LOG_HEARTBEAT_MS);
            valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            circularProgressButton2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CircularProgressButton.State state = circularProgressButton2.getState();
                    CircularProgressButton.State state2 = CircularProgressButton.State.f6803b;
                    if (state != state2) {
                        if (valueAnimatorOfInt.isRunning()) {
                            valueAnimatorOfInt.cancel();
                        }
                        circularProgressButton2.t(state2, true);
                    } else {
                        circularProgressButton2.t(CircularProgressButton.State.f6802a, true);
                        circularProgressButton2.setIndeterminateProgressMode(false);
                        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter.11.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Integer num = (Integer) valueAnimator.getAnimatedValue();
                                if (num.intValue() == 101) {
                                    circularProgressButton2.t(CircularProgressButton.State.f6804c, true);
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
    public BasicListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewInflate;
        if (i10 != 100) {
            switch (i10) {
                case 0:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_normal, viewGroup, false);
                    break;
                case 1:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow, viewGroup, false);
                    viewInflate.setEnabled(false);
                    ((TextView) viewInflate.findViewById(com.stepos.aiengine.R.id.title)).setEnabled(false);
                    ((ImageFontCompatView) viewInflate.findViewById(com.stepos.aiengine.R.id.arrow_right)).setEnabled(false);
                    break;
                case 2:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_triangle, viewGroup, false);
                    break;
                case 3:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_checktext, viewGroup, false);
                    break;
                case 4:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_check_box, viewGroup, false);
                    break;
                case 5:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_check_box, viewGroup, false);
                    break;
                case 6:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_check_box_error, viewGroup, false);
                    break;
                case 7:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_switch, viewGroup, false);
                    break;
                case 8:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_circular_progress_button, viewGroup, false);
                    break;
                case 9:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_button, viewGroup, false);
                    break;
                case 10:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_text_link, viewGroup, false);
                    break;
                case 11:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_normal_new_message_point, viewGroup, false);
                    break;
                case 12:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_normal_new_message_number, viewGroup, false);
                    break;
                case 13:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_with_new_message_point, viewGroup, false);
                    break;
                case 14:
                    viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_with_new_message_number, viewGroup, false);
                    break;
                default:
                    switch (i10) {
                        case 16:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_normal, viewGroup, false);
                            break;
                        case 17:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_large, viewGroup, false);
                            break;
                        case 18:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_multi_line_normal, viewGroup, false);
                            break;
                        case 19:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_normal, viewGroup, false);
                            break;
                        case 20:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_apply_list_item_small_icon_normal, viewGroup, false);
                            break;
                        case 21:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_apply_list_item_small_icon_with_summary, viewGroup, false);
                            break;
                        case 22:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_apply_list_item_medium_icon_with_summary, viewGroup, false);
                            break;
                        case 23:
                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_apply_list_item_big_icon_with_summary_description, viewGroup, false);
                            break;
                        default:
                            switch (i10) {
                                case 25:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.stepos.aiengine.R.layout.stepos_header_image_list_item_normal, viewGroup, false);
                                    break;
                                case 26:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.stepos.aiengine.R.layout.stepos_header_image_list_item_with_summary, viewGroup, false);
                                    break;
                                case 27:
                                    viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.stepos.aiengine.R.layout.stepos_header_image_list_item_with_summary_large, viewGroup, false);
                                    break;
                                default:
                                    switch (i10) {
                                        case 30:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_group_category_header_normal, viewGroup, false);
                                            break;
                                        case 31:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_with_number_message, viewGroup, false);
                                            break;
                                        case 32:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_with_text_message, viewGroup, false);
                                            break;
                                        case 33:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_with_highlight_text_message, viewGroup, false);
                                            break;
                                        case 34:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_and_check_box, viewGroup, false);
                                            break;
                                        case 35:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_arrow_and_check_box, viewGroup, false);
                                            break;
                                        case 36:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_single_line_large, viewGroup, false);
                                            break;
                                        case 37:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_large_title, viewGroup, false);
                                            break;
                                        case 38:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_large, viewGroup, false);
                                            break;
                                        case 39:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_basics_list_item_double_line_large_title, viewGroup, false);
                                            break;
                                        case 40:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_search_list_item_normal, viewGroup, false);
                                            break;
                                        case 41:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_search_list_item_normal, viewGroup, false);
                                            break;
                                        case 42:
                                            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.stepos_search_list_item_normal, viewGroup, false);
                                            break;
                                        default:
                                            viewInflate = null;
                                            break;
                                    }
                            }
                    }
            }
        } else {
            viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.aiengine.R.layout.policysdk_list_item_head_title, viewGroup, false);
        }
        if (viewInflate == null) {
            return null;
        }
        return new BasicListViewHolder(viewInflate);
    }
}
