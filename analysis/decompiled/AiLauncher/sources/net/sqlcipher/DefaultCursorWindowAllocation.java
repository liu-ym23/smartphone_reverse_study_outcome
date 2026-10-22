package net.sqlcipher;

import com.zyql.ai.selector.config.PictureConfig;

/* loaded from: classes5.dex */
public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long initialAllocationSize = PictureConfig.MB;
    private long WindowAllocationUnbounded = 0;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
