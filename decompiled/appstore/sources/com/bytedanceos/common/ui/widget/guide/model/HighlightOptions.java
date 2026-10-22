package com.bytedanceos.common.ui.widget.guide.model;

import android.view.View;
import com.bytedanceos.common.ui.widget.guide.listener.OnHighlightDrewListener;

/* JADX INFO: loaded from: classes2.dex */
public class HighlightOptions {
    public boolean fetchLocationEveryTime;
    public View.OnClickListener onClickListener;
    public OnHighlightDrewListener onHighlightDrewListener;
    public RelativeGuide relativeGuide;

    public static class Builder {
        private HighlightOptions options;

        public Builder() {
            this.options = new HighlightOptions();
        }

        public HighlightOptions build() {
            return this.options;
        }

        public Builder isFetchLocationEveryTime(boolean r10) {
            this.options.fetchLocationEveryTime = r10;
            return this;
        }

        public Builder setOnClickListener(View.OnClickListener r10) {
            this.options.onClickListener = r10;
            return this;
        }

        public Builder setOnHighlightDrewListener(OnHighlightDrewListener r10) {
            this.options.onHighlightDrewListener = r10;
            return this;
        }

        public Builder setRelativeGuide(RelativeGuide r10) {
            this.options.relativeGuide = r10;
            return this;
        }
    }

    public HighlightOptions() {
    }
}
