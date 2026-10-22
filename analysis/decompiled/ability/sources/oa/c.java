package oa;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class c extends k {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Mark mark, Mark mark2, int i) {
        super(mark, mark2);
        this.c = i;
    }

    @Override // oa.k
    public final Token$ID a() {
        switch (this.c) {
            case 0:
                return Token$ID.BlockEnd;
            case 1:
                return Token$ID.BlockMappingStart;
            case 2:
                return Token$ID.BlockSequenceStart;
            case 3:
                return Token$ID.DocumentEnd;
            case 4:
                return Token$ID.DocumentStart;
            case 5:
                return Token$ID.FlowEntry;
            case 6:
                return Token$ID.FlowMappingEnd;
            case 7:
                return Token$ID.FlowMappingStart;
            case 8:
                return Token$ID.FlowSequenceEnd;
            case 9:
                return Token$ID.FlowSequenceStart;
            case 10:
                return Token$ID.Key;
            default:
                return Token$ID.Value;
        }
    }
}
