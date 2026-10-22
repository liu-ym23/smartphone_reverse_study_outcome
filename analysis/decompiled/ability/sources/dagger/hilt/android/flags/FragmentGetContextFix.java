package dagger.hilt.android.flags;

import android.content.Context;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.Preconditions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Set;
import javax.inject.Qualifier;

/* loaded from: classes2.dex */
public final class FragmentGetContextFix {

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
    @Qualifier
    public @interface DisableFragmentGetContextFix {
    }

    @EntryPoint
    @InstallIn({SingletonComponent.class})
    public interface FragmentGetContextFixEntryPoint {
        @DisableFragmentGetContextFix
        Set<Boolean> getDisableFragmentGetContextFix();
    }

    @InstallIn({SingletonComponent.class})
    public static abstract class FragmentGetContextFixModule {
        @DisableFragmentGetContextFix
        public abstract Set<Boolean> disableFragmentGetContextFix();
    }

    private FragmentGetContextFix() {
    }

    public static boolean isFragmentGetContextFixDisabled(Context context) {
        Set<Boolean> disableFragmentGetContextFix = ((FragmentGetContextFixEntryPoint) EntryPointAccessors.fromApplication(context, FragmentGetContextFixEntryPoint.class)).getDisableFragmentGetContextFix();
        Preconditions.checkState(disableFragmentGetContextFix.size() <= 1, "Cannot bind the flag @DisableFragmentGetContextFix more than once.", new Object[0]);
        if (disableFragmentGetContextFix.isEmpty()) {
            return true;
        }
        return disableFragmentGetContextFix.iterator().next().booleanValue();
    }
}
